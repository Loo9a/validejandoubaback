package event.SpringBootApp.controllers;

import event.SpringBootApp.Entities.userEntity;
import event.SpringBootApp.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/user")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class userController {
@Autowired
userService us;

    @GetMapping( "/test")
     public String test(){
        return "Hello";
    }
    @PostMapping( "/adduser")
    public userEntity add(@RequestBody userEntity user){
        return us.adduser(user);

    }
    @PutMapping("/upuser/{idV}")
    public String upuser2(@RequestBody userEntity user, @PathVariable ("idV")int idV) {
        String msg = "";
        us.updateuser(user, idV);
        msg="user updated";
        return msg;
    }
    @DeleteMapping("/delete/{idV}")
    public String deleteuser(@PathVariable("idV") int idV){
        String msg=",";
        us.deleteuser(idV);
        msg="user deleted";
        return msg;
    }

    @GetMapping("getALL")
    public List<userEntity> getALL(){
        return us.getALL();
    }
    @PostMapping("addall")
    public List<userEntity> addall(@RequestBody List<userEntity> userEntities){
        return us.addall(userEntities);
    }
    @PostMapping("/adduser3")
    public String add3(@RequestBody userEntity user){
        return us.add(user);
    }
    @PostMapping("/adduser2")
    public String add2(@RequestBody userEntity user){
        return us.addpa(user);
    }





}
