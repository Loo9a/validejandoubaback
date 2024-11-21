package event.SpringBootApp.services;

import event.SpringBootApp.Entities.userEntity;

import java.util.List;

public interface userService {
    userEntity adduser(userEntity user);


    userEntity updateuser(userEntity user, int idV);

    void deleteuser(int idV);

    List<userEntity> getALL();

    List<userEntity> addall(List<userEntity> userall);
    String add(userEntity user );

    String addpa(userEntity user );







}
