package com.tugbabingol.vki_projesi.data.repository;

import com.tugbabingol.vki_projesi.data.entity.VkiEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IVkiRepository extends CrudRepository<VkiEntity, Long> {


}
