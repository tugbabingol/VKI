package com.tugbabingol.vki_projesi.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVKIApi<D> {

    public ResponseEntity<List<D>> vkiApiSpeedData(Long key);

    //ALL DELETE
    public ResponseEntity<?> vkiApiDeleteAll();


    ///////////
    //FIND BY NAME
    public ResponseEntity<?> vkiApiFindByUserName(String userName);

    ////////////////
    //CRUD
    //CREATE
    public ResponseEntity<?> vkiApiCreate(D d);

    //LIST
    public ResponseEntity<List<D>> vkiApiList();

    //FIND
    public ResponseEntity<?> vkiApiFindById(Long id);

    //UPDATE
    public ResponseEntity<?> vkiApiUpdate(Long id, D d);

    //DELETE
    public ResponseEntity<?> vkiApiDeleteById(Long id);

}//end interface
