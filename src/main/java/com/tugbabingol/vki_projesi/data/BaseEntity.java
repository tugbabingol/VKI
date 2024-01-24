package com.tugbabingol.vki_projesi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//LOMBOK

@Builder
@Getter
@Setter

// abstract CLASS
@MappedSuperclass
@JsonIgnoreProperties(value={"id","system_date"},allowGetters = true) // json buradaki verileri takip etme
abstract public class BaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID : import jakarta.persistence.Id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected  Long id;

    // DATE
    @Builder.Default // Lombok Default
    @Temporal(TemporalType.TIMESTAMP)
    protected Date systemDate = new Date();

    public BaseEntity(){

    }

} //end class
