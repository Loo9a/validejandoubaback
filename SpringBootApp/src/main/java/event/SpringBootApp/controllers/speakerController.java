package event.SpringBootApp.controllers;

import event.SpringBootApp.Entities.speakerEntity;
import event.SpringBootApp.services.speakerService;
import event.SpringBootApp.services.userService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/speaker")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class speakerController {
    @Autowired
    speakerService ss;

    @GetMapping( "/test")
    public String test(){
        return "welcom";
    }
    @PostMapping( "/addspeaker")
    public speakerEntity add(@RequestBody speakerEntity speaker){
        return ss.addspeaker(speaker);

    }
    @PutMapping("/uporganisateur/{idS}")
    public String upspeaker2(@RequestBody speakerEntity speaker, @PathVariable ("idS")int idS) {
        String msg = "";
        ss.updatespeaker(speaker, idS);
        msg="speaker updated";
        return msg;
    }
    @DeleteMapping("/delete/{idS}")
    public String deletespeaker(@PathVariable("idS") int idS){
        String msg=",";
        ss.deletespeaker(idS);
        msg="speaker deleted";
        return msg;
    }

    @GetMapping("getALL")
    public List<speakerEntity> getALL(){
        return ss.getALL();
    }
    @PostMapping("addall")
    public List<speakerEntity> addall(@RequestBody List<speakerEntity> speakerEntities){
        return ss.addall(speakerEntities);
    }
    @PostMapping("/addspeaker3")
    public String add3(@RequestBody speakerEntity speaker){
        return ss.add(speaker);
    }
    @PostMapping("/addspeaker2")
    public String add2(@RequestBody speakerEntity speaker){
        return ss.addpa(speaker);
    }





}
