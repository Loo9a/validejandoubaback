package event.SpringBootApp.services;

import event.SpringBootApp.Entities.organisateurEntity;

import java.util.List;

public interface organisateurService {
    organisateurEntity addorganisateur(organisateurEntity organisateur);

    organisateurEntity updateorganisateur(organisateurEntity organisateur, int idO);

    void deleteuser(int idO);

    void deleteorganisateur(int idO);

    List<organisateurEntity> getALL();

    List<organisateurEntity> addall(List<organisateurEntity> organisateurEntities);

    String add(organisateurEntity organisateur);

    String addpa(organisateurEntity organisateur);
}
