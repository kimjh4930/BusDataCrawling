package com.paper.handlingfiles;

import com.paper.domain.OutputBusData;

public class TimeCalculator {
	
	public int calculateTimeConsumption(OutputBusData previous, OutputBusData latest){
		
		int previousTime = this.transferToSecond(previous.getArrivalTime());
		int latestTime = this.transferToSecond(latest.getArrivalTime());
		
		if(!previous.getDate().equals(latest.getDate())){
			
			return (86400 - previousTime) + latestTime;
			
		}else{
			return latestTime - previousTime;
		}
		
	}
	
	public int transferToSecond (String time){
		
		int hour = Integer.parseInt(time.substring(0,2));
		int minute = Integer.parseInt(time.substring(2,4));
		int second = Integer.parseInt(time.substring(4,6));
		
		return hour * 3600 + minute * 60 + second;
	}

}
