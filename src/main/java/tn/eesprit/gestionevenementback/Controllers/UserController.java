package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Event;
import tn.eesprit.gestionevenementback.Entities.User;
import tn.eesprit.gestionevenementback.Exception.ResourceNotFoundException;
import tn.eesprit.gestionevenementback.Repository.UserRepository;
import tn.eesprit.gestionevenementback.Services.EmailService;
import tn.eesprit.gestionevenementback.Services.IUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private final IUserService userService;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final EmailService emailService;
    @GetMapping("/get-users")
    public ResponseEntity<List<User>> getUsers( )  {
        List<User> users = userRepository.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/add")
    User addUser(@RequestBody User user)
    {
        return userService.addOrUpdateUser(user);
    }
    @PutMapping("/update")
    User updateUser(@RequestBody User user){
        return userService.addOrUpdateUser(user);
    }
    @GetMapping("/get-user/{id}")
    public ResponseEntity<User> getEvent(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @PutMapping("/active-user/{id}")
    public ResponseEntity<User> activeAccount(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));
        user.setActive(true);
        userRepository.save(user);
      String status=  this.emailService.sendSimpleMail(user.getEmail());
      System.out.println(status);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @PutMapping("/desactive-user/{id}")
    public ResponseEntity<User> desactiveAccount(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));
        user.setActive(false);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> getEvent(@PathVariable(value = "id") Long id,@RequestBody User user) throws ResourceNotFoundException {
        User _user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));
        if(user.getPassword()!=""){
            _user.setPassword(encoder.encode(user.getPassword()));
        }
        _user.setFirstName(user.getFirstName());
        _user.setLastName(user.getLastName());
        _user.setEmail(user.getEmail());
        _user.setPhone(user.getPhone());
        userRepository.save(_user);

        return new ResponseEntity<>(_user, HttpStatus.OK);

    }
    @GetMapping("/all")
    List<User> getAllUsers(){return userService.retrieveAllUsers();}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
