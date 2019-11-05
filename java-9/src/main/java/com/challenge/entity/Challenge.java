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
@Table(name = Challenge.TABLE_NAME)
public class Challenge {

    public static final String TABLE_NAME = "challenge";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "challenge_id")
    @NotNull
    private List<Acceleration> accelerations;

    @OneToMany(mappedBy = "challenge_id")
    @NotNull
    private List<Submission> submissions;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate created_at;

}
