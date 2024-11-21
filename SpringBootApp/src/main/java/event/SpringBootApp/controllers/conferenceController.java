package event.SpringBootApp.controllers;


import event.SpringBootApp.Entities.conferenceEntity;


import event.SpringBootApp.Entities.eventEntity;
import event.SpringBootApp.services.conferenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/conference")
@CrossOrigin(origins = "*" , allowedHeaders = "*")


public class conferenceController {
    @Autowired
    conferenceService cs;
    @GetMapping( "/test")
    public String test(){
        return "Hello";
    }
    @PostMapping( "/addconference")
    public conferenceEntity add(@RequestBody conferenceEntity conference){
        return cs.addconference(conference);

    }
    @PutMapping("/upconference/{idC}")
    public String upconference1(@RequestBody conferenceEntity conference, @PathVariable ("idC")int idC) {
        String msg = "";
        cs.updateconference(conference, idC);
        msg="conference updated";
        return msg;
    }
    @DeleteMapping("/delete/{idC}")
    public String deleteconference(@PathVariable("idC") int idC){
        String msg=",";
        cs.deleteconference(idC);
        msg="conference deleted";
        return msg;
    }
    @GetMapping("getALL")
    public List<conferenceEntity> getALL(){
        return cs.getALL();
    }

}


