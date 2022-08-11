package com.ganesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.request.PassengerRequest;
import com.ganesh.response.TicketResponse;
import com.ganesh.service.IrctcService;

@RestController
public class IrctcRestController {
	
	@Autowired
	private IrctcService service;
	
	@PostMapping(value = "/bookticket" , consumes = {"application/xml","application/json"})
	public ResponseEntity<String> bookTicket(@RequestBody PassengerRequest request){
		
		String ticket = service.bookTicket(request);
		String msg = "Ticket Booking Completed ::" + ticket;
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/ticket/{pnr}" , produces = {"application/xml","application/json"})
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String pnr){
		TicketResponse ticketByPnr = service.getTicketByPnr(pnr);
		return new ResponseEntity<>(ticketByPnr,HttpStatus.OK);
	}

}
