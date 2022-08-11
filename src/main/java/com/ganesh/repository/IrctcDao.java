package com.ganesh.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ganesh.response.TicketResponse;

@Repository
public class IrctcDao {
	
	private Map<String, TicketResponse> map = new HashMap<>();
	
	public String saveTicket(TicketResponse response) {
		map.put(response.getPnr(), response);
		return response.getPnr();
	}
	
	public TicketResponse getTicketByPnr(String pnr) {
		if(map.containsKey(pnr)) {
			return map.get(pnr);
		}
		return null;
	}

}
