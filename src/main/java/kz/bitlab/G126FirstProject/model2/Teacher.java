package kz.bitlab.G126FirstProject.model2;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;
}
