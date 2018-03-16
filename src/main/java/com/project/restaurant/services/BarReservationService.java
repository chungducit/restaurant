package com.project.restaurant.services;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurant.models.BarReservation;
import com.project.restaurant.models.BarReservationDetail;
import com.project.restaurant.models.Items;
import com.project.restaurant.models.business.BBarReservation;
import com.project.restaurant.models.business.TableInfo;
import com.project.restaurant.repositories.BarReservationDetailRepository;
import com.project.restaurant.repositories.BarReservationRepository;
import com.project.restaurant.repositories.ItemsRepository;
import com.project.restaurant.websocket.SocketController;

@Service
public class BarReservationService {

	private static final Logger logger = LoggerFactory.getLogger(SocketController.class);
	@Autowired
	private BarReservationRepository barReservationRepository;
	@Autowired
	private BarReservationDetailRepository barReservationDetailRepository;
	@Autowired
	private ItemsRepository itemsRepository;
	
	public TableInfo addReservation (BBarReservation reserInfo) {
		BarReservation barReser = new BarReservation();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		barReser.setBooked_user(reserInfo.getUser_id());
		barReser.setStatus(reserInfo.getStatus());
		barReser.setPeople_quantity(reserInfo.getCapacity());
		barReser.setbookedTime(timestamp);
		barReser.setTable_id(reserInfo.getTable_id());
		barReservationRepository.save(barReser);
		List<Items> items = reserInfo.getItems();
//		barReser.getId()
		if (items.size() > 0) {
			items.forEach(i -> {
				BarReservationDetail barDetail = new BarReservationDetail();
				barDetail.setitemId(i.getId());
				barDetail.setDiscount(0);
				barDetail.setQuantity(i.getQuantity());
				barDetail.setBar_reservation_id(barReser.getId());
				barDetail.setPrice(i.getPrice());
				barReservationDetailRepository.save(barDetail);
			});
		}
		
		TableInfo tableInfo = new TableInfo();
		tableInfo.setId(reserInfo.getTable_id());
		tableInfo.setBar_reservation_id(barReser.getId());
		tableInfo.setCapacity(reserInfo.getCapacity());
		tableInfo.setStatus(reserInfo.getStatus());
		
		return tableInfo;
	}
	
}
