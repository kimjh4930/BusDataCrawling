package com.paper.dataprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paper.domain.BusLineInfo;
import com.paper.domain.OutputBusData;
import com.paper.handlingfiles.TimeCalculator;
import com.paper.handlingfiles.WritingFile;

public class BusInfoToFile {

	public List<OutputBusData> putOutToFile(String busNumber ,List<BusLineInfo> busLineInfoList, String day, String time){
		
		List<OutputBusData> outputBusDataList = new ArrayList<>();
		
		for(int i=0; i<busLineInfoList.size(); i++){
			
			OutputBusData outputBusData = new OutputBusData();
			
			outputBusData.setDate(day);
			outputBusData.setArrivalTime(time);
			outputBusData.setBusStopId(busLineInfoList.get(i).getCurrentLocation());
			outputBusData.setBusNum(busNumber);
			outputBusData.setBusLicenseNum(busLineInfoList.get(i).getBusLicense());
			
			outputBusDataList.add(outputBusData);
		}
		
		return outputBusDataList;
	}
	
	public Map<String, OutputBusData> compareCurrentAndPast (Map<String, OutputBusData> recentBusLineInfoMap, List<OutputBusData> currentData){
				
		TimeCalculator timeCalculator = new TimeCalculator();
		Map<String, OutputBusData> recentBusDataMap = new HashMap<>();
		
		for(int i=0; i<currentData.size(); i++){
			
			OutputBusData pastBusData = new OutputBusData();
			OutputBusData updatedBusData = new OutputBusData();
			
			if( !recentBusLineInfoMap.containsKey(currentData.get(i).getBusLicenseNum()) ){
				//없음. 형식을 새로 생성해서 HashMap에 넣는다.
				//System.out.println("Hashmap에 넣음.");
				recentBusLineInfoMap.put(currentData.get(i).getBusLicenseNum(), currentData.get(i));
				
				updatedBusData = currentData.get(i);
				
			}else{
				//있으면 비교 진행.
				//System.out.println("있음.");
				pastBusData = recentBusLineInfoMap.get(currentData.get(i).getBusLicenseNum());
				
				if(pastBusData.getBusStopId() != currentData.get(i).getBusStopId()){
					//버스가 이동함.
					System.out.println(currentData.get(i).getBusNum() + " " + currentData.get(i) + "버스가 이동함.");
					
					int elapseTime = timeCalculator.calculateTimeConsumption(pastBusData.getArrivalTime(), currentData.get(i).getArrivalTime());
					int gapBusStop = currentData.get(i).getBusStopId() - pastBusData.getBusStopId();
					
					updatedBusData.setDate(currentData.get(i).getDate());
					updatedBusData.setArrivalTime(currentData.get(i).getArrivalTime());
					updatedBusData.setBusStopId(currentData.get(i).getBusStopId());
					updatedBusData.setHangingTime(elapseTime);
					updatedBusData.setBusNum(currentData.get(i).getBusNum());
					updatedBusData.setBusLicenseNum(currentData.get(i).getBusLicenseNum());
					updatedBusData.setBusStopInterval(gapBusStop);
					
					//변경이 있으면 다시 조회해서 찾는다. db에 저장되어야 할 것 같음.
					
					//파일로 뺄 것.
					//WritingFile writingFile = new WritingFile();
					
					//writingFile.writeToFile("/Users/junha/Documents/workspace/BusDataCrawling/busResult", updatedBusData);
					
					
				}else{
					//버스가 이동하지 않음.
					//System.out.println("버스가 이동하지 않음.");
					updatedBusData = pastBusData;
					
				}
				
			}
			
			recentBusDataMap.put(currentData.get(i).getBusLicenseNum(), updatedBusData);
			
		}
		
		return recentBusDataMap;
	}
	
	
}
