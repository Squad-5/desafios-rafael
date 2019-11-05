package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = Candidate.TABLE_NAME)
public class Candidate {

    public static final String TABLE_NAME = "candidate";

    @EmbeddedId
    public CandidateID candidateid;


    @NotNull
    public int status;

    @CreatedDate
    @Column(name = "created_at")
    @NotNull
    private LocalDateTime created_at;

}
