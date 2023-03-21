package com.ait.otom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.otom.entities.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {

}
