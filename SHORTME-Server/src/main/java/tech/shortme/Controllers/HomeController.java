package tech.shortme.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.shortme.Services.MainServices;
import tech.shortme.Views.UrlAddRequest;

@RestController
@RequestMapping("/")
@CrossOrigin
public class HomeController {

    @Autowired
    MainServices mainServices;

    @PostMapping("add")
    public String shortener(@RequestBody UrlAddRequest urlAddRequest){
        return mainServices.addURL(urlAddRequest);
    }

    @GetMapping("{shortURL}")
    public String gotoLink(@PathVariable("shortURL") String shortURL){
        return mainServices.gotoLink(shortURL);
    }
}
