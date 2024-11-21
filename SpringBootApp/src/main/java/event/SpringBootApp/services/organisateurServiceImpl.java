package event.SpringBootApp.services;

import event.SpringBootApp.Entities.organisateurEntity;
import event.SpringBootApp.Entities.userEntity;
import event.SpringBootApp.repository.organisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class organisateurServiceImpl implements organisateurService{

    @Autowired
    organisateurRepository oR;

    @Override
    public organisateurEntity addorganisateur(organisateurEntity organisateur) {

        return oR.save(organisateur);
    }

    @Override
    public organisateurEntity updateorganisateur(organisateurEntity organisateur, int idO) {
        organisateurEntity existingOrganisateur = oR.findById(idO)
                .orElseThrow(() -> new EntityNotFoundException("organisateur not found with id: " + idO));


        existingOrganisateur.setNom(organisateur.getNom());
        existingOrganisateur.setPrenom(organisateur.getPrenom());
        existingOrganisateur.setEmail(organisateur.getEmail());
        existingOrganisateur.setPassword(organisateur.getPassword());


        return oR.save(existingOrganisateur);
    }

    @Override
    public void deleteuser(int idO) {

    }


    @Override
    public void deleteorganisateur(int idO){
        oR.deleteById(idO);
    }{


    }

    @Override
    public List<organisateurEntity> getALL() {
        {
            return (List<organisateurEntity>) oR.findAll();
        }

    }

    @Override
    public List<organisateurEntity> addall(List<organisateurEntity> organisateurall) {
        {
            return (List<organisateurEntity>) oR.saveAll(organisateurall);
        }
    }

    @Override
    public String add(organisateurEntity organisateur) {
        if(organisateur.getEmail(). equals(organisateur.getConfemail())){
            oR.save(organisateur);
            return "save";
        }else {
            return "email exist";
        }
    }

    @Override
    public String addpa(organisateurEntity organisateur) {
        if(organisateur.getPassword(). equals(organisateur.getConfpassword())){
            oR.save(organisateur);
            return "save";
        }else {
            return "not equal";
        }

    }


}

