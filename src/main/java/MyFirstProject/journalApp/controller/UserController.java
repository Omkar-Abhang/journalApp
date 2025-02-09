package MyFirstProject.journalApp.controller;

import MyFirstProject.journalApp.entity.JournalEntry;
import MyFirstProject.journalApp.entity.User;
import MyFirstProject.journalApp.service.JournalEntryService;
import MyFirstProject.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getAllUsers(){
    return userService.getAll();
  }

  @PostMapping
  public void createUser(@RequestBody User user){
    userService.saveEntry(user);
  }

  @PutMapping("/{userName}")
  public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
    User userInDB =userService.findByuserName(userName);
    if(userInDB !=null){
      userInDB.setUserName(user.getUserName());
      userInDB.setPassword(user.getPassword());
      userService.saveEntry(userInDB);

    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }
//  @DeleteMapping
//  public ResponseEntity<?> deleteUser(){
//
//  }

}
