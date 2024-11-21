package event.SpringBootApp.controllers;
import event.SpringBootApp.Entities.sponsoringEntity;
import event.SpringBootApp.services.sponsoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/sponsoring")
@CrossOrigin(origins = "*" , allowedHeaders = "*")


public class sponsoringController {
    @Autowired
    sponsoringService Ss;
    @GetMapping( "/test")
    public String test(){
        return "Hello";
    }
    @PostMapping( "/addsponsoring")
    public sponsoringEntity add(@RequestBody sponsoringEntity sponsoring) {
        return Ss.addsponsoring(sponsoring);

    }

}
