package com.tugbabingol.vki_projesi.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

//LOMBOK
@SuperBuilder
@Getter
@Setter

// abstract CLASS
abstract public class AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID
    protected  Long id;

    // DATE
    @Builder.Default // Lombok Default
    protected Date systemDate=new Date(System.currentTimeMillis());

    //////////////////////////////////////////////////////////////////
    // AUDITING
    // Kim ekledi
    @JsonIgnore // Backte giden veride bunu göstermek
    protected String createdUser;

    // Kim ne zaman ekledi
    @JsonIgnore
    protected Date createdDate;

    // Kim güncelledi
    @JsonIgnore
    protected String lastUser;

    // Kim ne zaman güncelledi
    @JsonIgnore
    protected Date lastDate;

    protected AuditingAwareBaseDto() {
    }
} //end class
