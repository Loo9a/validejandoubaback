package event.SpringBootApp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "speakers")
public class speakerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idS;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Long numero;
    private String bio;

    // Many-to-Many relationship with conferences
    @ManyToMany(mappedBy = "speakers")
    private Set<conferenceEntity> conferences;  // Can be empty or null
}
