package MyFirstProject.journalApp.service;

import MyFirstProject.journalApp.entity.JournalEntry;
import MyFirstProject.journalApp.entity.User;
import MyFirstProject.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

@Autowired
private JournalEntryRepository journalEntryRepository;

@Autowired
private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String userName){
        User user= userService.findByuserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }


    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }


}
// controller -->  service -->  repository