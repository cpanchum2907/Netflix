package fr.epita.netflix.controller;

import fr.epita.netflix.datamodel.Contact;
import fr.epita.netflix.exceptions.BadRequestAlertException;
import fr.epita.netflix.repository.ContactRepository;
import fr.epita.netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/netflix")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws URISyntaxException {
        if (contact.getId() != null) {
            throw new BadRequestAlertException("A new contact cannot already have an ID");
        }
        Contact result = contactRepository.createContact(contact);
        return ResponseEntity.created(new URI("/netflix/contacts/" + result.getId()))
                .body(result);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactRepository.getContacts();
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Contact contact = contactRepository.getById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
