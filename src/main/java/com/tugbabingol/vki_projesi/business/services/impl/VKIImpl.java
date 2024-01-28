package com.tugbabingol.vki_projesi.business.services.impl;

import com.tugbabingol.vki_projesi.bean.ModelMapperBeanClass;
import com.tugbabingol.vki_projesi.business.dto.VkiDto;
import com.tugbabingol.vki_projesi.business.services.IVKIServices;
import com.tugbabingol.vki_projesi.data.entity.VkiEntity;
import com.tugbabingol.vki_projesi.data.repository.IVkiRepository;
import com.tugbabingol.vki_projesi.exception.Resource404NotFoundException;
import com.tugbabingol.vki_projesi.exception.TugbaBingolException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Log4j2
@Service
public class VKIImpl implements IVKIServices<VkiDto, VkiEntity> {

    private final IVkiRepository iVkiRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;

    public VKIImpl(IVkiRepository iVkiRepository, ModelMapperBeanClass modelMapperBeanClass) {
        this.iVkiRepository = iVkiRepository;
        this.modelMapperBeanClass = modelMapperBeanClass;
    }

    @Override
    public VkiDto entityToDto(VkiEntity vkiEntity) {
        return null;
    }

    @Override
    public VkiEntity dtoToEntity(VkiDto vkiDto) {
        return null;
    }
    //SPEED DATA
    @Override
    public List<VkiDto> vkiServiceSpeedData(Long key) {
        List<VkiDto> vkiDtoList=new ArrayList<>();
        Random random = new Random();
        if (key != null) {
            for (int i = 1; i <=key ; i++) {
                VkiDto vkiDto=VkiDto
                        .builder()
                        .userName("name "+(i%3))
                        .userWeight(random.nextFloat(120))
                        .userHeight(random.nextFloat(25)*10)
                        .build();
                VkiEntity registerEntity = dtoToEntity(vkiDto);
                iVkiRepository.save(registerEntity);
                vkiDto.setId(registerEntity.getId());
                vkiDto.setSystemDate(registerEntity.getSystemDate());
                vkiDtoList.add(vkiDto);
            }
        }
        vkiDtoList.stream().forEach((temp)->
                System.out.println(temp)
        );
        return vkiDtoList;
    }
    //DELETE ALL
    @Override
    public String vkiServiceDeleteAll() {
        iVkiRepository.deleteAll();
        return iVkiRepository.findAll().toString();
    }
    //FIND BY ID
    @Override
    public VkiDto vkiServiceFindById(Long id) {
        VkiEntity findVKIentity =  null ;
        if (id!=null){
            findVKIentity = iVkiRepository.findById(id).orElseThrow(
                    ()-> new Resource404NotFoundException(id + " nolu id yoktur.")
            );
        } else if (id==null) {
            throw new TugbaBingolException("id null olarak geldi");
        }
        return entityToDto(findVKIentity);
    }
    // FIND BY NAME
    @Override
    public List<VkiDto> vkiServiceFindByName(String userName) {
        Iterable<VkiEntity> registerEntityIterable = iVkiRepository.findByUserName(userName);
        List<VkiDto> vkiDtoList=new ArrayList<>();
        for(VkiEntity entity: registerEntityIterable ){
            // Entity Listesini ==> Dto Listesine çeviriyor / list e ekliyor.
            vkiDtoList.add(entityToDto(entity));
        }
        return vkiDtoList;

    }
    //CREATE
    @Transactional
    @Override
    public VkiDto vkiServiceCreate(VkiDto vkiDto) {
        if (vkiDto != null){
            VkiEntity vkiEntity = dtoToEntity(vkiDto);
            iVkiRepository.save(vkiEntity);
            vkiDto.setId(vkiEntity.getId());
            vkiDto.setUserName(vkiEntity.getUserName());
            vkiDto.setUserWeight(vkiEntity.getUserWeight());
            vkiDto.setUserHeight(vkiEntity.getUserHeight());
            vkiDto.setSystemDate(vkiEntity.getSystemDate());
        }
        return vkiDto;
    }
    //LIST
    @Override
    public List<VkiDto> vkiServiceList() {
        //Entity List
        Iterable<VkiEntity> vkiEntityIterable =  iVkiRepository.findAll();
        //DTO List
        List<VkiDto> vkiDtoList = new ArrayList<>();
        for (VkiEntity entity: vkiEntityIterable){
            vkiDtoList.add(entityToDto(entity));
        }
        log.info("Vki Liste Sayısı: " + vkiDtoList.size());
        return vkiDtoList;
    }
    //UPDATE
    @Override
    @Transactional
    public VkiDto vkiServiceUpdate(Long id, VkiDto vkiDto) {
        //ilgili vki kayıt
        VkiDto vkiFindDto = vkiServiceFindById(id);
        //Entity Instance
        VkiEntity vkiEntity = null;
        if (vkiFindDto!=null){
            vkiEntity = dtoToEntity(vkiDto);
            vkiEntity.setId(vkiDto.getId());
            vkiEntity.setUserName(vkiDto.getUserName());
            vkiEntity.setUserWeight(vkiDto.getUserWeight());
            vkiEntity.setUserHeight(vkiDto.getUserHeight());
            vkiEntity.setSystemDate(vkiDto.getSystemDate());
            iVkiRepository.save(vkiEntity);
        }
        return entityToDto(vkiEntity);
    }
    //DELETE BY ID
    @Override
    public VkiDto vkiServiceDeleteById(Long id) {
        VkiDto vkiFindDto = vkiServiceFindById(id);
        if (vkiFindDto!=null){
            iVkiRepository.deleteById(id);
        }
        return vkiFindDto;
    }
}
