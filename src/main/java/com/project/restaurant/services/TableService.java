package com.project.restaurant.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurant.models.BarReservation;
import com.project.restaurant.models.Tables;
import com.project.restaurant.models.business.TableInfo;
import com.project.restaurant.repositories.BarReservationRepository;
import com.project.restaurant.repositories.TableRepository;
import com.project.restaurant.websocket.SocketController;

@Service
public class TableService {
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	private BarReservationRepository barReservationRepository;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	private static final Logger logger = LoggerFactory.getLogger(SocketController.class);
	
    @Autowired
    public TableService (TableRepository tableRepository, BarReservationRepository barReservationRepository) {
        this.tableRepository = tableRepository;
        this.barReservationRepository = barReservationRepository;
    }
	
	public List<TableInfo> getTableReservationsByStatus (String status) {
		Iterable<Tables> tables = this.tableRepository.findAll();
		Map<Long, TableInfo> tableReservationMap = new HashMap<>();
		tables.forEach(tb -> {
			TableInfo tableInfo = new TableInfo();
			tableInfo.setId(tb.getId());
			tableInfo.setName(tb.getName());
			tableInfo.setCode(tb.getCode());
			tableInfo.setCapacity(tb.getCapacity());
			tableInfo.setStatus("EMPTY");
			tableReservationMap.put(tb.getId(), tableInfo);
        });
		
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		@SuppressWarnings("deprecation")
		Date date = new Date(timestamp.getYear(), timestamp.getMonth(), timestamp.getDate());
//		new java.sql.Date(date.getTime())
//		Iterable<BarReservation> reservations = this.barReservationRepository.findByBookedTime(new Timestamp(date.getTime()));
		Iterable<BarReservation> reservations = this.barReservationRepository.findByBookedTimeGreaterThanEqual(new Timestamp(date.getTime()));
//		Iterable<BarReservation> reservations = this.barReservationRepository.findByStatus(status);
		System.out.print(date.getTime());
		if (null != reservations) {
            reservations.forEach(reservation -> {
            	TableInfo tableInfo = tableReservationMap.get(reservation.getTable_id());
            	if (null != tableInfo) {
                	tableInfo.setStatus(reservation.getStatus());
                	/*tableInfo.setDate(date);
                	tableInfo.setFirstName(guest.getFirstName());
                	tableInfo.setLastName(guest.getLastName());
                	tableInfo.setGuestId(guest.getId());
                   */
            	}
            });
        }
        List<TableInfo> tableReservations = new ArrayList<>();
        for (Long tableId : tableReservationMap.keySet()) {
        	tableReservations.add(tableReservationMap.get(tableId));
        }
        return tableReservations;
	}
	
    private Date createDateFromDateString(String dateString) {
        Date date = null;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException pe) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
	
}
