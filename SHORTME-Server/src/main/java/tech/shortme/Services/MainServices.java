package tech.shortme.Services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.shortme.Entities.URL;
import tech.shortme.Repo.URLRepo;
import tech.shortme.Views.UrlAddRequest;

import java.util.Date;

@Service
public class MainServices {
    @Autowired
    URLRepo urlRepo;

    @Value("${hostname}")
    String hostname;

    public String addURL(UrlAddRequest addRequest){
        if (addRequest.getOriginalURL() == null) throw new RuntimeException("URL Empty");
        String originalURL = addRequest.getOriginalURL();
        String shortURL = urlGenerator();
        URL url = new URL();
        url.setId(urlRepo.count()+1);
        url.setOriginalURL(originalURL);
        url.setShortURL(shortURL);
        url.setCreatedOn(new Date());
        url.setClicks(0);
        url.setLastClick(null);
        urlRepo.save(url);
        return hostname+"/"+shortURL;
    }

    private String urlGenerator(){
        String shortURL = RandomStringUtils.randomAlphabetic(4);
        if (urlRepo.countByShortURL(shortURL)==0)
            return shortURL;
        else return urlGenerator();
    }

    public String gotoLink(String url){
        URL myURL = urlRepo.findByShortURL(url);
        if(myURL == null) throw new RuntimeException("No URL Mapped");
        myURL.setClicks(myURL.getClicks()+1);
        myURL.setLastClick(new Date());
        urlRepo.save(myURL);
        return myURL.getOriginalURL();
    }
}