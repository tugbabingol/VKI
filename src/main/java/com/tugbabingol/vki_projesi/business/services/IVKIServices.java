package com.tugbabingol.vki_projesi.business.services;

import java.util.List;

public interface IVKIServices<D,E>{

    // Model Mapper
    //veritabanından gelen verileri gönderirken özel yani backend e ait
    //verileri göndermememize yarar. yani maskeler

    public D entityToDto(E e);
    //Entity yi Dto ya çevirir.
    public E dtoToEntity(D d);
    //Dto yu Entitiy e çevirir.

    ////////////////////////////////////////////////////////////

    // SPEED DATA
    public List<D> vkiServiceSpeedData(Long key);
    // Girilen değer kadar otomatik değer oluşturur.

    // ALL DELETE
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

} //End Interface IRegisterServicesviceFindByName(String uName);