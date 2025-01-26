package MyFirstProject.journalApp.controller;

import MyFirstProject.journalApp.entity.JournalEntry;
//import lombok.Data;
import MyFirstProject.journalApp.entity.User;
import MyFirstProject.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import MyFirstProject.journalApp.service.JournalEntryService;

import java.util.*;

@RestController
@RequestMapping("/journal")

public class JournalEntryController_v2 {


  @Autowired
  private JournalEntryService journalEntryService;
  @Autowired
  private UserService userService;

    //get all entry
    @GetMapping
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
      // localhost:8080/journal GET

      User user = userService.findByuserName(userName);
      List<JournalEntry> all=user.getJournalEntries();
      if (all!=null && !all.isEmpty()){
        return new ResponseEntity<>(all,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //create entry
    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String userName) {
      try {
        journalEntryService.saveEntry(myEntry,userName);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

    //get entry by id
    @GetMapping("/id/{myid}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myid){
      Optional<JournalEntry> journalEntry = journalEntryService.findById(myid);
      if(journalEntry.isPresent()){
        return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //delete entry
    @DeleteMapping("/id/{myid}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myid) {
    journalEntryService.deleteById(myid);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update entry

    @PutMapping("/id/{id}")
    public  ResponseEntity<?>  updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
      JournalEntry old = journalEntryService.findById(id).orElse(null);
      if(old !=null){
        old.setTitle(newEntry.getTitle()!= null && !newEntry.getTitle().equals("")?newEntry.getTitle(): old.getTitle());
        old.setContent(newEntry.getContent()!= null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
//        journalEntryService.saveEntry(old,userName);
        return new ResponseEntity<>(old,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
