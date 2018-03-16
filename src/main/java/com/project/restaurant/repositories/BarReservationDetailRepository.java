package com.project.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.BarReservationDetail;

@Repository
public interface BarReservationDetailRepository extends CrudRepository<BarReservationDetail, Long>{

}
