package event.SpringBootApp.services;

import event.SpringBootApp.Entities.speakerEntity;

import java.util.List;

public interface speakerService {
    speakerEntity addspeaker(speakerEntity speaker);

    speakerEntity updatespeaker(speakerEntity speaker, int idS);

    void deletespeaker(int idS);

    List<speakerEntity> getALL();

    List<speakerEntity> addall(List<speakerEntity> speakerEntities);

    String add(speakerEntity speaker);

    String addpa(speakerEntity speaker);
}
