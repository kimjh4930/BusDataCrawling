package com.paper.dataprocessing;

import com.paper.domain.BusLineInfo;

public class SplitingRawData {
	
	public BusLineInfo splitRawData(String splitWord,String rawData){
		
		String[] splitResult = rawData.split(";");
		BusLineInfo busLineInfo = new BusLineInfo();
		
		busLineInfo.setBusLicense(splitResult[0]);
		busLineInfo.setBusInterval(Integer.parseInt(splitResult[1]));
		busLineInfo.setCurrentLocation(Integer.parseInt(splitResult[2]));
		busLineInfo.setBusType(Integer.parseInt(splitResult[3]));
		busLineInfo.setFormerBusLicense(Integer.parseInt(splitResult[4]));
		busLineInfo.setBusInterval(Integer.parseInt(splitResult[5]));
		//splitResult[6]은 잘 모르겠음.
		
		return busLineInfo;
	}
	
}
