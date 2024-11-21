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
@Table(name = "sponsoring")
public class sponsoringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSpon;
    private String nom;
    private String prenom;
    private Double montant;

    @ManyToMany(mappedBy = "sponsors")
    private Set<eventEntity> events;
}
