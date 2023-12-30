package com.AnotherOne.AnotherAPP.Repositories;

import com.AnotherOne.AnotherAPP.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
