package com.tugbabingol.vki_projesi.data.repository;

import com.tugbabingol.vki_projesi.data.entity.VkiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVkiRepository extends JpaRepository<VkiEntity, Long> {

    Iterable<VkiEntity> findByUserName(String userName);

}
