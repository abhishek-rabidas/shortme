package tech.shortme.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
@Document(collection = "Users")
public class User {
    @MongoId
    private String UID;
    private String name;
    private String email;
    private String password;
    private int totalURL;
    private Date joinDate;
}
