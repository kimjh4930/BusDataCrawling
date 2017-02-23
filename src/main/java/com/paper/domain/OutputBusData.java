package com.paper.domain;

import lombok.Data;

@Data
public class OutputBusData {
	
	int Date;			//yymmdd
	int arrivalTime;	//hhmmss
	
	int busStopId;
	int hangingTIme;
	
	int busNum;
	int busLicenseNum;
	
	
	@Override
	public String toString(){
		
		return 	String.valueOf(this.getDate()) + "," + 
				String.valueOf(this.getArrivalTime()) + "," + 
				String.valueOf(this.getBusStopId()) + "," + 
				String.valueOf(this.getHangingTIme()) + "," + 
				String.valueOf(this.getBusNum()) + "," + 
				String.valueOf(this.getBusLicenseNum()) + "\n";
		
	}
	

}
