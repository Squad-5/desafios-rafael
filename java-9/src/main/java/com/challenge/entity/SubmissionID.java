package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class SubmissionID implements Serializable {

    @ManyToOne
    @NotNull
    private User user_id;

    @NotNull
    @ManyToOne
    private Challenge challenge_id;

}
