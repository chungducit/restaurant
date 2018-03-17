package com.project.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurant.models.PaymentMethod;
import com.project.restaurant.repositories.PaymentMethodRepository;

@Service
public class PaymentMethodService {

	@Autowired
	private PaymentMethodRepository PaymentMethodRepository;

	public List<PaymentMethod> search() {
		return (List<PaymentMethod>) PaymentMethodRepository.findAll();
	}

	public List<PaymentMethod> save(PaymentMethod items) {
		PaymentMethodRepository.save(items);
		return (List<PaymentMethod>) PaymentMethodRepository.findAll();
	}

	public List<PaymentMethod> delete(PaymentMethod items) {
		PaymentMethodRepository.delete(items);
		return (List<PaymentMethod>) PaymentMethodRepository.findAll();
	}

	public List<PaymentMethod> deleteById(Long id) {
		PaymentMethodRepository.deleteById(id);
		return (List<PaymentMethod>) PaymentMethodRepository.findAll();
	}
}
