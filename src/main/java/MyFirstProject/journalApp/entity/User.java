package MyFirstProject.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
//@Getter
//@Setter

//instead of Getter Setter we can use @Data

@Data
public class User
{
     @Id
     private ObjectId id;
     @Indexed(unique = true)
     @NonNull
     private String userName;
     @NonNull
     private String password;

//     connecting both collections
     @DBRef
     private List<JournalEntry> journalEntries=new ArrayList<>();




}
