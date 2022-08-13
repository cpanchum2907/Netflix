package fr.epita.netflix.controller;

import fr.epita.netflix.datamodel.SeenMovie;
import fr.epita.netflix.exceptions.BadRequestAlertException;
import fr.epita.netflix.repository.MovieUserRepository;
import fr.epita.netflix.repository.SeenMovieRepository;
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
public class SeenMovieController {

    @Autowired
    private SeenMovieRepository seenMovieRepository;

    @PostMapping("/seen-movies")
    public ResponseEntity<SeenMovie> createSeenMovie(@RequestBody SeenMovie seenMovie) throws URISyntaxException {
        if (seenMovie.getId() != null) {
            throw new BadRequestAlertException("A new seenMovie cannot already have an ID");
        }
        SeenMovie result = seenMovieRepository.createMovieUser(seenMovie);
        return ResponseEntity.created(new URI("/netflix/seen-movies/" + result.getId()))
                .body(result);
    }

    @GetMapping("/seen-movies")
    public List<SeenMovie> getAllSeenMovies() {
        return seenMovieRepository.getMovieUser();
    }


    @GetMapping("/seen-movies/{id}")
    public ResponseEntity<SeenMovie> getSeenMovie(@PathVariable Long id) {
        List<SeenMovie> seenMovie = seenMovieRepository.getById(id);
        return new ResponseEntity<>(seenMovie.get(0), HttpStatus.OK);
    }



}
