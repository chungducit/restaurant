package com.project.restaurant.repositories;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.BarReservation;

@Repository
public interface BarReservationRepository extends CrudRepository<BarReservation, Long>{
	Iterable<BarReservation> findByStatus(String status);
	Iterable<BarReservation> findByBookedTime(Timestamp bookedTime);
	Iterable<BarReservation> findByBookedTimeGreaterThanEqual(Timestamp bookedTime);
}
