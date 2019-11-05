package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "user_id")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "user_id")
    private List<Submission> submissions = new ArrayList<>();

    @NotNull
    @Size(max = 100)
    private String fullname;

    @Size(max = 100)
    @NotNull
    @Email
    private String email;

    @Size(max = 50)
    @NotNull
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at",nullable = false)
    private LocalDate created_at;

}
