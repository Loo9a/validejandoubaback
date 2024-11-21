package event.SpringBootApp.controllers;

import event.SpringBootApp.Entities.organisateurEntity;
import event.SpringBootApp.services.organisateurService;
import event.SpringBootApp.services.userService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/organisateur")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class organisateurController {
    @Autowired
    organisateurService os;

    @GetMapping( "/test")
    public String test(){
        return "welcom";
    }
    @PostMapping( "/addorganisateur")
    public organisateurEntity add(@RequestBody organisateurEntity organisateur){
        return os.addorganisateur(organisateur);

    }
    @PutMapping("/uporganisateur/{idO}")
    public String uporganisateur2(@RequestBody organisateurEntity organisateur, @PathVariable ("idO")int idO) {
        String msg = "";
        os.updateorganisateur(organisateur, idO);
        msg="organisateur updated";
        return msg;
    }
    @DeleteMapping("/delete/{idO}")
    public String deleteorganisateur(@PathVariable("idO") int idO){
        String msg=",";
        os.deleteorganisateur(idO);
        msg="organisateur deleted";
        return msg;
    }

    @GetMapping("getALL")
    public List<organisateurEntity> getALL(){
        return os.getALL();
    }
    @PostMapping("addall")
    public List<organisateurEntity> addall(@RequestBody List<organisateurEntity> organisateurEntities){
        return os.addall(organisateurEntities);
    }
    @PostMapping("/addorganisateur3")
    public String add3(@RequestBody organisateurEntity organisateur){
        return os.add(organisateur);
    }
    @PostMapping("/addorganisateur2")
    public String add2(@RequestBody organisateurEntity organisateur){
        return os.addpa(organisateur);
    }





}
