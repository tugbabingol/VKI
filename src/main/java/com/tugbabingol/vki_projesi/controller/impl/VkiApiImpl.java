package com.tugbabingol.vki_projesi.controller.impl;

import com.tugbabingol.vki_projesi.business.dto.VkiDto;
import com.tugbabingol.vki_projesi.business.services.IVKIServices;
import com.tugbabingol.vki_projesi.controller.IVKIApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor//INJECTION
@Log4j2
@RestController
@RequestMapping("/vki/api/v1.0.0")
@CrossOrigin

public class VkiApiImpl implements IVKIApi<VkiDto> {

    //INJECTION
    private  final IVKIServices ivkiServices;
    ////////////////////////////////////////
    //SPEED DATA
    @Override
    @GetMapping("/speed/data/{id}")
    public ResponseEntity<List<VkiDto>> vkiApiSpeedData(@PathVariable(name = "id") Long key) {
        return ResponseEntity.ok(ivkiServices.vkiServiceSpeedData(key));
    }
    //DELETE ALL
    @Override
    @GetMapping("/delete/all")
    public ResponseEntity<?> vkiApiDeleteAll() {
        return ResponseEntity.ok(ivkiServices.vkiServiceDeleteAll());
    }
    /////////////////////////
    //FIND
    @Override
    @GetMapping("/find")
    public ResponseEntity<?> vkiApiFindByUserName(@RequestParam String userName) {
        return ResponseEntity.ok(ivkiServices.vkiServiceFindByName(userName));
    }
    //CREATE
    @Override
    @GetMapping("/create")
    public ResponseEntity<?> vkiApiCreate(@Valid @RequestBody VkiDto vkiDto) {
        return ResponseEntity.ok(ivkiServices.vkiServiceCreate(vkiDto));
    }
    //LIST
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<VkiDto>> vkiApiList() {
        return ResponseEntity.ok(ivkiServices.vkiServiceList());
    }
    //FIND BY ID
    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<?> vkiApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(ivkiServices.vkiServiceFindById(id));
    }
    //UPDATE
    @Override
    @GetMapping("/update/{id}")
    public ResponseEntity<?> vkiApiUpdate(@PathVariable(name = "id") Long id,@Valid @RequestBody VkiDto vkiDto) {
        return ResponseEntity.status(HttpStatus.OK).body(ivkiServices.vkiServiceUpdate(id,vkiDto));
    }
    //DELETE BY ID
    @Override
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> vkiApiDeleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(ivkiServices.vkiServiceDeleteById(id));
    }
}
