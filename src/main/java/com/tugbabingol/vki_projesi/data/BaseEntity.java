package com.tugbabingol.vki_projesi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

import java.io.Serializable;
import java.util.Date;

//LOMBOK

//@Builder
@SuperBuilder
@Getter
@Setter

// abstract CLASS
@MappedSuperclass
@JsonIgnoreProperties(value={},allowGetters = true) // json buradaki verileri takip etme
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

    // Serileştirme
    public static final long serialVersionUID=1L;

    // ID : import jakarta.persistence.Id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Builder.Default
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "system_date", nullable = false, updatable = false)
    protected Date systemDate = new Date();




} //end class
