package event.SpringBootApp.services;

import event.SpringBootApp.Entities.conferenceEntity;


import java.util.List;

public interface conferenceService {

    conferenceEntity addconference(conferenceEntity conference);

    conferenceEntity updateconference(conferenceEntity conference, int idC);

    void deleteconference(int idC);

    List<conferenceEntity> getALL();
}
