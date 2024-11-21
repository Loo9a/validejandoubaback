package event.SpringBootApp.services;

import event.SpringBootApp.Entities.sponsoringEntity;

import event.SpringBootApp.repository.sponsoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sponsoringServiceImpl implements sponsoringService {

    @Autowired
    sponsoringRepository SR;

    @Override
    public sponsoringEntity addsponsoring(sponsoringEntity sponsoring) {

        return SR.save(sponsoring);
    }
}