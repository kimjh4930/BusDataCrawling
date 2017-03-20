package com.paper.domain;

import lombok.Data;

@Data
public class BusRoadInfo {
	
	private int 	index;
	private String 	busStopId;
	private String 	roadSituation;
	
	@Override
	public String toString(){
		return 	String.valueOf(this.getIndex()) + "," +
				String.valueOf(this.getBusStopId()) + "," +
				String.valueOf(this.getRoadSituation());
	}

}
