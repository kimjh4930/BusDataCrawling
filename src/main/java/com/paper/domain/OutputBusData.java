package com.paper.domain;

import lombok.Data;

@Data
public class OutputBusData {
	
	private String date;		//yymmdd
	private String arrivalTime;	//hhmmss
	
	private String busStopId;
	private int	   hangingTime;	//걸린시간.
	
	private String busNum;
	private String busLicenseNum;
	
	@Override
	public String toString(){
		
		return 	String.valueOf(this.getDate()) + "," + 
				String.valueOf(this.getArrivalTime()) + "," + 
				String.valueOf(this.getBusStopId()) + "," + 
				String.valueOf(this.getHangingTime()) + "," + 
				String.valueOf(this.getBusNum()) + "," + 
				String.valueOf(this.getBusLicenseNum()) + ";";
		
	}
	

}
