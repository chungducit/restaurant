package com.project.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
