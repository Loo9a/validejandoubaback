package event.SpringBootApp.controllers;

import event.SpringBootApp.Entities.eventEntity;


import event.SpringBootApp.services.eventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/event")
@CrossOrigin(origins = "*" , allowedHeaders = "*")


public class eventController {
        @Autowired
        eventService es;
        @GetMapping( "/test")
        public String test(){
            return "Hello";
        }
        @PostMapping( "/addevent")
        public eventEntity add(@RequestBody eventEntity event){
        return es.addevent(event);

    }
    @PutMapping("/upevent/{idE}")
    public String upevent1(@RequestBody eventEntity event, @PathVariable ("idE")int idE) {
        String msg = "";
        es.updateevent(event, idE);
        msg="event updated";
        return msg;
    }
    @DeleteMapping("/delete/{idE}")
    public String deleteevent(@PathVariable("idE") int idE){
        String msg=",";
        es.deleteevent(idE);
        msg="event deleted";
        return msg;
    }
    @GetMapping("getALL")
    public List<eventEntity> getALL(){
        return es.getALL();
    }

}
