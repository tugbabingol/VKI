package com.tugbabingol.vki_projesi.business.services;
import java.util.List;

public interface IVKIServices<D,E>{

    public D entityToDto(E e);

    public E dtoToEntity(D d);
    //SPEED DATA
    public List<D> vkiServiceSpeedData(Long key);

    //ALL DELETE
    public String vkiServiceDeleteAll();
    //FIND ID
    public D vkiServiceFindById(Long id);
    // FIND SURNAME
    public List<D> vkiServiceFindByName(String uName);

    ////////////////////////////////////////////////////////////
    //  REGISTER C R U D
    // CREATE
    public D vkiServiceCreate(D d);

    // LIST
    public List<D> vkiServiceList();


    // UPDATE
    public D vkiServiceUpdate(Long id, D d);

    // DELETE
    public D vkiServiceDeleteById(Long id);



}
