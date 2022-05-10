package com.sai.repository;

import com.sai.model.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderRepository extends  JpaRepository<Orders, Long> {
}
