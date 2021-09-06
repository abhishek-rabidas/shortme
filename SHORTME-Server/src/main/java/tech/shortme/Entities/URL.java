package tech.shortme.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
@Document(collection = "URLS")
public class URL {
    @MongoId
    private long id;
    private String originalURL;
    private String shortURL;
    private long clicks;
    private Date createdOn;
    private Date lastClick;
}