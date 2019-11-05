package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = Acceleration.TABLE_NAME)
public class Acceleration {

    public static final String TABLE_NAME = "acceleration";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @ManyToOne
    @NotNull
    private Challenge challenge_id;

    @OneToMany(mappedBy = "acceleration_id")
    @NotNull
    private List<Candidate> candidates;

    @CreatedDate
    @NotNull
    @Column(name = "created_at")
    private LocalDate created_at;

}
