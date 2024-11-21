package event.SpringBootApp.services;

import event.SpringBootApp.Entities.speakerEntity;
import event.SpringBootApp.repository.speakerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class speakerServiceImpl implements speakerService{

    @Autowired
    speakerRepository sR;


    @Override
    public speakerEntity addspeaker(speakerEntity speaker) {
        return sR.save(speaker);
    }

    @Override
    public speakerEntity updatespeaker(speakerEntity speaker, int idS) {

            speakerEntity existingSpeaker = sR.findById(idS)
                    .orElseThrow(() -> new EntityNotFoundException("speaker not found with id: " + idS));


            existingSpeaker.setNom(speaker.getNom());
            existingSpeaker.setPrenom(speaker.getPrenom());
            existingSpeaker.setEmail(speaker.getEmail());
            existingSpeaker.setPassword(speaker.getPassword());
            existingSpeaker.setNumero(speaker.getNumero());
            existingSpeaker.setBio(speaker.getBio());


        return sR.save(existingSpeaker);
    }

    @Override
    public void deletespeaker(int idS){
        sR.deleteById(idS);
    }

    @Override
    public List<speakerEntity> getALL() {
        {
            return (List<speakerEntity>) sR.findAll();
        }
    }

    @Override
    public List<speakerEntity> addall(List<speakerEntity> speakerall) {
            return (List<speakerEntity>) sR.saveAll(speakerall);
        }

    @Override
    public String add(speakerEntity speaker) {
        if(speaker.getEmail(). equals(speaker.getEmail())){
            sR.save(speaker);
            return "save";
        }else {
            return "email exist";
        }

    }

    @Override
    public String addpa(speakerEntity speaker) {
        return null;
    }
}


