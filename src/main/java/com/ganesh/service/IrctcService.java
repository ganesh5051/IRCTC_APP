package com.ganesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.repository.IrctcDao;
import com.ganesh.request.PassengerRequest;
import com.ganesh.response.TicketResponse;

@Service
public class IrctcService {
	
	@Autowired
	private IrctcDao idao;
	
	public String bookTicket(PassengerRequest request) {
		
		TicketResponse response = new TicketResponse();
		response.setTicketId(12345);
		response.setName(request.getName());
		response.setStatus("CONFIRMED");
		response.setCost(560.00);
		response.setFrom(request.getFrom());
		response.setTo(request.getTo());
		response.setJdate(request.getJdate());
		response.setPnr("PNR23456758");
		 idao.saveTicket(response);
		
		return "PNR23456758";
	}
	
	public TicketResponse getTicketByPnr(String pnr) {
		return idao.getTicketByPnr(pnr);
	}

}
