package com.project.restaurant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurant.models.Payment;
import com.project.restaurant.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public List<Payment> search() {
		return (List<Payment>) paymentRepository.findAll();
	}

	public List<Payment> save(Payment items) {
		paymentRepository.save(items);
		return (List<Payment>) paymentRepository.findAll();
	}

	public List<Payment> delete(Payment items) {
		paymentRepository.delete(items);
		return (List<Payment>) paymentRepository.findAll();
	}

	public List<Payment> deleteById(Long id) {
		paymentRepository.deleteById(id);
		return (List<Payment>) paymentRepository.findAll();
	}

	public Optional<Payment> findById(Long id) {
		return paymentRepository.findById(id);
	}

}
