package fr.epita.netflix.controller;

import fr.epita.netflix.datamodel.Address;
import fr.epita.netflix.exceptions.BadRequestAlertException;
import fr.epita.netflix.repository.AdressRepository;
import fr.epita.netflix.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

public class AdressController {

    @Autowired
    private AdressRepository addressRepository;

    @PostMapping("/addresses")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) throws URISyntaxException {
        if (address.getId() != null) {
            throw new BadRequestAlertException("A new address cannot already have an ID");
        }
        Address result = addressRepository.createAddress(address);
        return ResponseEntity.created(new URI("/api/addresses/" + result.getId()))
                .body(result);
    }

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressRepository.getAddress();
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        Address address = addressRepository.getById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
