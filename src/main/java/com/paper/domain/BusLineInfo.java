package com.paper.domain;

import lombok.Data;

@Data
public class BusLineInfo {
	
	private int 	index;
	private String	busNum;
	private String 	date;
	private long 	millisTime;
	
	private String 	busLicense;
	private String 	busInterval;
	private String 	currentLocation;
	private String	busType;
	
	private String 	formerBusLicense;
	private String 	formerBusLocation;
	private String 	busIntervalTime;

}
