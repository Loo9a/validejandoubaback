package event.SpringBootApp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Conference")
public class conferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;
    private String titre;
    private LocalDateTime heure;
    private int duree;

    // Many-to-One relationship to event, with optional reference
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = true)  // Nullable foreign key
    private eventEntity event;
    // Many-to-Many relationship with speakers
    @ManyToMany
    @JoinTable(
            name = "conference_speaker",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private Set<speakerEntity> speakers;  // Can be empty or null
}
