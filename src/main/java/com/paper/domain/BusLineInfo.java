package com.paper.domain;

import lombok.Data;

@Data
public class BusLineInfo {
	
	private int 	index;
	private String 	date;
	private long 	millisTime;
	
	private String 	busLicense;
	private int 	busInterval;
	private int 	currentLocation;
	private int		busType;
	
	private int 	formerBusLicense;
	private int 	formerBusLocation;
	private String 	busIntervalTime;

}
