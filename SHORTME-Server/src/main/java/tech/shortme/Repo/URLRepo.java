package tech.shortme.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.shortme.Entities.URL;

public interface URLRepo extends MongoRepository<URL, Long> {
    public long count();
    public URL findByShortURL(String shortURL);
    public int countByShortURL(String shortURL);
}
