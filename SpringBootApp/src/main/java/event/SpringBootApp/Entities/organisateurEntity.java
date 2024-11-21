package event.SpringBootApp.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oraganisateurs")
public class organisateurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idO;
    private String Nom;
    private String Prenom;
    private String Email;
    private String password;
    private Long Numero;
    @Transient
    private String confpassword;
    @Transient
    private String confemail;


    @OneToMany(mappedBy = "organisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<eventEntity> events;

}
