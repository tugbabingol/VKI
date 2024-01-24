package com.tugbabingol.vki_projesi.data.entity;

import com.tugbabingol.vki_projesi.data.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
@Data
@Log4j2
@AllArgsConstructor //Clasın içindeki tüm Variable oldupuğu constructor
@NoArgsConstructor // Boş bir Constructor
@Builder

@Entity
@Table(name = "vki")
public class VkiEntity extends BaseEntity implements Serializable {
    //Veritabanı oluşturuldu

    public static final Long serialVersionUID = 1L;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_Weight")
    private Float userWeight;

    @Column(name = "user_Height")
    private Float userHeight;

    @Column(name = "user_Vki")
    private Float userVki;


}
