package event.SpringBootApp.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Event")
public class eventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idE;
    private String nom;
    private String lieu;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "organisateur_id", nullable = false)
    private organisateurEntity organisateur;
    @ManyToMany
    @JoinTable(
            name = "event_sponsor",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "sponsor_id")
    )
    private Set<sponsoringEntity> sponsors;
    // One-to-Many relationship with optional conferences
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<conferenceEntity> conferences;  // Can be empty or null
}

