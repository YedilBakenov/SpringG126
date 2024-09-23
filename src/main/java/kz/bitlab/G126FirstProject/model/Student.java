package kz.bitlab.G126FirstProject.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@Builder
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "GPA")
    private Double gpa;

    @Column(name = "AGE")
    private int age;

    @Column(name="BIO", columnDefinition = "text")
    private String bio;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @ManyToMany
    @ToString.Exclude
    private List<Subject> subjects = new ArrayList<>();
 }
