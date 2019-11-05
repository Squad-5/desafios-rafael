package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = Submission.TABLE_NAME)
public class Submission {

    public static final String TABLE_NAME = "submission";

    @EmbeddedId
    private SubmissionID id;

    @NotNull
    private float score;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate created_at;

}
