package kz.bitlab.G126FirstProject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CABINET")
    private int cabinet;

    @Column(name = "CREDIT")
    private int credit;


}
