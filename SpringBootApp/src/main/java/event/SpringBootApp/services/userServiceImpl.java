package event.SpringBootApp.services;

import event.SpringBootApp.Entities.userEntity;
import event.SpringBootApp.repository.userRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class userServiceImpl implements userService{

    @Autowired
    userRepository uR;

    @Override
    public userEntity adduser(userEntity user) {

        return uR.save(user);
    }

    @Override
    public userEntity updateuser(userEntity user, int idV) {

        userEntity existingUser = uR.findById(idV)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + idV));


        existingUser.setNom(user.getNom());
        existingUser.setPrenom(user.getPrenom());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAdress(user.getAdress());

        return uR.save(existingUser);
    }
    @Override
    public void deleteuser(int idV){
     uR.deleteById(idV);
    }

    @Override
    public List<userEntity> getALL() {
        return (List<userEntity>) uR.findAll();
    }

    @Override
    public List<userEntity> addall(List<userEntity> userall) {
        return (List<userEntity>) uR.saveAll(userall);
    }

    @Override
    public String add(userEntity user) {


            if(user.getEmail(). equals(user.getConfemail())){
                uR.save(user);
                return "save";
            }else {
                return "email exist";
            }

    }

    @Override
    public String addpa(userEntity user) {
        if(user.getPassword(). equals(user.getConfpassword())){
            uR.save(user);
            return "save";
        }else {
            return "not equal";
        }



    }


}

