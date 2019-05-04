package com.powertech.nelson.dao;

import org.springframework.data.repository.CrudRepository;

import com.powertech.nelson.entity.Plant;

public interface PlantDao extends CrudRepository<Plant, Long> {

}
