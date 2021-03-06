package com.paper.dataprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.paper.domain.BusLineInfo;
import com.paper.domain.BusRoadInfo;

public class ProcessingHtmlData {

	public List<String> getBusInfoFromRegex(String busHtml, String busRegex) {

		List<String> operateBusInfoList = new ArrayList<String>();

		Pattern busInfoPattern = Pattern.compile(busRegex);
		Matcher busInfoMatcher = busInfoPattern.matcher(busHtml.trim());

		while (busInfoMatcher.find()) {
			operateBusInfoList.add(busInfoMatcher.group(0).trim());
		}

		return operateBusInfoList;

	}

	public List<BusLineInfo> splitRawBusData(String splitWord, List<String> rawDataList) {

		List<BusLineInfo> busLineInfoList = new ArrayList<>();
		
		for(String rawData : rawDataList){
			
			String[] splitResult = rawData.split(splitWord);
			BusLineInfo busLineInfo = new BusLineInfo();

			busLineInfo.setBusLicense(splitResult[0]);
			busLineInfo.setBusInterval(splitResult[1]);
			busLineInfo.setCurrentLocation(splitResult[2]);
			busLineInfo.setBusType(splitResult[3]);
			busLineInfo.setFormerBusLicense(splitResult[4]);
			busLineInfo.setBusInterval(splitResult[5]);
			// splitResult[6]은 잘 모르겠음.
			
			busLineInfoList.add(busLineInfo);
			
		}

		return busLineInfoList;
	}
	
	public Map<String, BusRoadInfo> splitRawRoadData(String splitWord, List<String> rawDataList){
		Map<String, BusRoadInfo> busRoadInfoMap = new HashMap<>();
		
		for(String rawData : rawDataList){
			String[] splitResult = rawData.split(splitWord);
			BusRoadInfo busRoadInfo = new BusRoadInfo();
			
			busRoadInfo.setIndex(Integer.parseInt(splitResult[0]));
			busRoadInfo.setBusStopId(splitResult[1]);
			busRoadInfo.setRoadSituation(splitResult[3]);
			
			busRoadInfoMap.put(splitResult[0], busRoadInfo);
		}
		
		return busRoadInfoMap;
	}

}
