package fr.aelion.streamer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Module {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private  String name;

    private  String objective;


    /**
     * récupère le cours complet*/
    @ManyToOne
    @JoinColumn(name =  "course_id")
    private  Course course;
}
