package MyFirstProject.journalApp.service;

import MyFirstProject.journalApp.entity.JournalEntry;
import MyFirstProject.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

@Autowired
private JournalEntryRepository journalEntryRepository;

public void saveEntry(JournalEntry journalEntry){
    journalEntryRepository.save(journalEntry);
}

public List<JournalEntry> getAll(){
    return journalEntryRepository.findAll();
    }

}
// controller -->  service -->  repository