package event.SpringBootApp.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idV;
    private String nom;
    private String prenom;
    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String adress;
    @Transient
    private String confpassword;
    @Transient
    private String confemail;
    @Enumerated(EnumType.STRING)
    private Role role;  // Assign role as an enum field





}
