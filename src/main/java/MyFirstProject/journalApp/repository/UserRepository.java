package MyFirstProject.journalApp.repository;


import MyFirstProject.journalApp.entity.JournalEntry;
import MyFirstProject.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

User findByuserName(String userName);
}
