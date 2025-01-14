package MyFirstProject.journalApp.controller;

import MyFirstProject.journalApp.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MyFirstProject.journalApp.service.JournalEntryService;

import java.util.*;

@RestController
@RequestMapping("/journal")

public class JournalEntryController_v2 {

  @Autowired
  private JournalEntryService journalEntryService;

    //get all entry
    @GetMapping
    public List<JournalEntry> getAll() {
        // localhost:8080/journal GET
      return journalEntryService.getAll();

    }

    //create entry
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return true;

    }

    //get entry by id
    @GetMapping("/id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable long myid) {

    return null;
    }

    //delete entry
    @DeleteMapping("/id/{myid}")
    public JournalEntry deleteJournalEntryById(@PathVariable long myid) {

    return null;
    }

    //update entry

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalyId(@PathVariable long id, @RequestBody JournalEntry myEntry) {
    return null;
    }

}
