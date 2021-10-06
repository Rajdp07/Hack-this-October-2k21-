package com.nayan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayan.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{





}
