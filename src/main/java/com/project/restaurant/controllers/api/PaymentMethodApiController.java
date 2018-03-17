package com.project.restaurant.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restaurant.models.PaymentMethod;
import com.project.restaurant.services.PaymentMethodService;

@RestController
@RequestMapping(path = "/api/paymentMethod")
public class PaymentMethodApiController {

	@Autowired
	private PaymentMethodService paymentMethodService;

	// search ALL
	@RequestMapping(method = RequestMethod.GET, path = { "/find" })
	public @ResponseBody List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodService.search();
	}

	// add + update Item
	@RequestMapping(method = RequestMethod.POST, path = { "/add", "/update" })
	public @ResponseBody List<PaymentMethod> addItem(@RequestBody PaymentMethod items) {
		return paymentMethodService.save(items);
	}

	// delete Item
	// deleteBy entity
	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public @ResponseBody List<PaymentMethod> deleteItem(@RequestBody PaymentMethod items) {
		return paymentMethodService.delete(items);
	}

	// deleteBy entity
	@RequestMapping(method = RequestMethod.GET, path = "/deleteById")
	public @ResponseBody List<PaymentMethod> deleteById(@RequestParam Long id) {
		return paymentMethodService.deleteById(id);
	}
}
