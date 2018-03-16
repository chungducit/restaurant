package com.project.restaurant.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.project.restaurant.models.business.BBarReservation;
import com.project.restaurant.models.business.TableInfo;
import com.project.restaurant.services.BarReservationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SocketController {

	@Autowired
	private BarReservationService barReservationService;
	private static final Logger logger = LoggerFactory.getLogger(SocketController.class);
	
	@MessageMapping("/reservation")
    @SendTo("/topic/reservation")
    public TableInfo greeting(BBarReservation message) throws Exception {
        return barReservationService.addReservation(message);
    }
}
