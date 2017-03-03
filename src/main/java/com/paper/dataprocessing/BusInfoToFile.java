package com.paper.dataprocessing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.paper.domain.BusLineInfo;

public class BusInfoToFile {

	public void putOutToFile(List<BusLineInfo> busLineInfoList){
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("yymmdd");
		SimpleDateFormat timeForamt = new SimpleDateFormat("hhmmss");
		
		String day = dayFormat.format(new Date(currentTime));
		String time = timeForamt.format(new Date(currentTime));
		
		for(int i=0; i<busLineInfoList.size(); i++){
			
		}
	}
}
