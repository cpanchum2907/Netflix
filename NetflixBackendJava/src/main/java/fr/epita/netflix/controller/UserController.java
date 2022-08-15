package fr.epita.netflix.controller;

import fr.epita.netflix.Configuration.CloakConfiguration;
import fr.epita.netflix.datamodel.User;
import fr.epita.netflix.exceptions.BadRequestAlertException;
import fr.epita.netflix.repository.UserRepository;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/netflix")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>();
            userRepository.getUsers().forEach(users::add);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {

        if (user.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID");
        } else {
            User newUser = userRepository.createUser(user);
            CloakConfiguration cloakConfiguration = new CloakConfiguration(user.getLogin(), user.getFirstName(), user.getLastName(), user.getEmail());
            cloakConfiguration.configuration();
            return ResponseEntity.created(new URI("/netflix/users/" + newUser.getId()))
                    .body(newUser);
        }
    }


    @DeleteMapping("/users/{name}")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("name") String userName) {
        userRepository.deleteByName(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/checkByemail")
    public User getUser(@PathVariable("name") String email) {
       User user = userRepository.getUserByEmail(email);
       User user1 = new User();
       user1.setEmail("chandana");
       user1.setLogin("chandana");
       user1.setPassword("chandana");
       user1.setFirstName("chandana");
       user1.setLastName("chandana");
       if(user != null) {
              return null;
       }
       else{
             // return new ResponseEntity<>(HttpStatus.OK);
             return user1;
       }
    }




}
