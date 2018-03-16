package com.project.restaurant.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restaurant.models.business.TableInfo;
import com.project.restaurant.services.TableService;

@RestController
@RequestMapping(value = "/api/v1")
public class TableController {
	@Autowired
	private TableService tableService;
	
	/*@GetMapping(value = "/gettables")
	public @ResponseBody Iterable<Tables> addNewUser (@RequestParam String name, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Tables n = new Tables();
		n.setName(name);
		n.setCode(email);
		tableRepository.save(n);
		Long a = tableRepository.countByName("First");
		return a.toString();
	}*/
	
    @RequestMapping(method = RequestMethod.GET, value = "/gettables")
    public List<TableInfo> getAllReservationsForDate() {
        return tableService.getTableReservationsByStatus("CHECKIN");
    }
	
	
}
