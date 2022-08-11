package com.ganesh.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketResponse {
	
	private Integer ticketId;
	private String status;
	private Double cost;
	private String from;
	private String to;
	private String pnr;
	private String jdate;
	private String name;

}
