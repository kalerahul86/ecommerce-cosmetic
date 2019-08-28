package com.cosmetic.cosmeticsetupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetic.cosmetic_common.entity.CosmeticMaster;

@Repository
public interface CosmeticMasterRepository extends JpaRepository<CosmeticMaster, String>{

}
