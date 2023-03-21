package com.ait.otom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.otom.entities.CustomerEntity;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {

}
