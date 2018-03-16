package com.project.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long>{

}
