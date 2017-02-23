package com.paper.handlingfiles;

public class TimeCalculator {
	
	public int calculateTimeConsumption(int previousTime, int latestTime){
		
		return latestTime - previousTime;
		
	}
	
	public int transferToSecond (String time){
		
		int hour = Integer.parseInt(time.substring(0,2));
		int minute = Integer.parseInt(time.substring(2,4));
		int second = Integer.parseInt(time.substring(4,6));
		
		return hour * 3600 + minute * 60 + second;
	}

}
