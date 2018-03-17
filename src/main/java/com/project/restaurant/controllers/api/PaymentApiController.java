package com.project.restaurant.controllers.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restaurant.models.Payment;
import com.project.restaurant.services.PaymentService;

@RestController
@RequestMapping(path="/api/payment")
public class PaymentApiController {


	@Autowired
	private PaymentService paymentService;

	// search ALL
	@RequestMapping(method = RequestMethod.GET, path = { "/find" })
	public @ResponseBody List<Payment> getAllPayment() {
		return paymentService.search();
	}

	// add + update Item
	@RequestMapping(method = RequestMethod.POST, path = { "/add", "/update" })
	public @ResponseBody List<Payment> addItem(@RequestBody Payment items) {
		return paymentService.save(items);
	}

	// delete Item
	// deleteBy entity
	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public @ResponseBody List<Payment> deleteItem(@RequestBody Payment items) {
		return paymentService.delete(items);
	}

	// deleteBy entity
	@RequestMapping(method = RequestMethod.GET, path = "/deleteById")
	public @ResponseBody List<Payment> deleteById(@RequestParam Long id) {
		return paymentService.deleteById(id);
	}
	
	// deleteBy entity
		@RequestMapping(method = RequestMethod.GET, path = "/findById")
		public @ResponseBody Optional<Payment> findById(@RequestParam Long id) {
			return paymentService.findById(id);
		}

}
