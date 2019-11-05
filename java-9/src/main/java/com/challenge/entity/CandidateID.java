package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class CandidateID implements Serializable {

    @ManyToOne
    @NotNull
    private User user_id;

    @ManyToOne
    @NotNull
    private Acceleration acceleration_id;

    @ManyToOne
    @NotNull
    private Company company_id;


}
