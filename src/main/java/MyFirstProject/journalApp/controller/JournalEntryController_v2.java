package MyFirstProject.journalApp.controller;

import MyFirstProject.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MyFirstProject.journalApp.service.JournalEntryService;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController_v2 {

  @Autowired
  private JournalEntryService journalEntryService;

    //get all entry
    @GetMapping
    public List<JournalEntry> getAllJournal() {           // localhost:8080/journal GET
      return journalEntryService.get();
    }

    //create entry
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
      myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;

    }

    //get entry by id
    @GetMapping("/id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myid) {

    return journalEntryService.findById(myid).orElse(null);
    }

    //delete entry
    @DeleteMapping("/id/{myid}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myid) {
    journalEntryService.deleteById(myid);
    return true;
    }

    //update entry

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
      JournalEntry old = journalEntryService.findById(id).orElse(null);
      if(old !=null){
        old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle(): old.getTitle());
        old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
      }
      journalEntryService.saveEntry(old);
      return old;
    }

}
