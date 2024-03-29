package com.tugbabingol.vki_projesi.data.entity;

import com.tugbabingol.vki_projesi.data.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@EqualsAndHashCode(callSuper = false)
@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor



// ENTITY
@Entity
@Table(name = "registers")
public class RegisterEntity extends BaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // Global Variable (6)
    // Dikkat: message sonunda boşluk olmasın
    // unique = true,
    @Column(name = "register_nick_name",nullable = true, updatable = false,insertable = true,length = 100)
    private String registerNickName;

    @Column(name = "register_name",columnDefinition = "varchar(255) default 'adınızı girmediniz'")
    private String registerName;

    @Column(name = "register_surname")
    private String registerSurname;

    @Column(name = "register_email")
    private String registerEmail;

    @Column(name = "register_password")
    private String registerPassword;

    @Column(name = "active")
    private Boolean registerIsPassive=false;
} //end class
