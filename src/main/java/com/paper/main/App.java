package com.paper.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paper.dataprocessing.BusInfoToFile;
import com.paper.dataprocessing.ParsingHtml;
import com.paper.dataprocessing.ProcessingHtmlData;
import com.paper.domain.BusLineInfo;
import com.paper.domain.BusUrlInfo;
import com.paper.domain.OutputBusData;
import com.paper.handlingfiles.ReadingFile;

public class App {
	
	static final String busUrlInfoPath = "/Users/junha/Documents/workspace/BusDataCrawling/";
	static final String busUrlInfoFileName = "IncheonYeonsuBus.txt";
	static final String busUrlBasic = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?";
	
	static final String busRegex = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
	
	public static void main(String[] args){
		
		String 				parsingHtmlResult = null;
		
		ReadingFile 		readBusNumUrl = new ReadingFile();
		ParsingHtml 		parsingHtml = new ParsingHtml();
		ProcessingHtmlData 	processingHtmlData = new ProcessingHtmlData();
		BusInfoToFile 		busInfoToFile = new BusInfoToFile();
		
		List<String> 		rawBusData = new ArrayList<>();
		List<BusLineInfo> 	busFinalInfo = new ArrayList<>();
		List<String> 		urlList;
		List<BusUrlInfo>	busUrlInfoList;
		
		List<BusLineInfo>	busLineInfoList = new ArrayList<>();
		List<String>		operateBusList = new ArrayList<>();
		
		
		//현재 가져온 버스 정보를 보관.
		//Map<String, List<OutputBusData>> recentBusLineInfoMap = new HashMap<>();
		//버스번호, 번호판번호, 자료들.
		Map<String, Map<String, OutputBusData>> recentBusLineInfoMap = new HashMap<>();
		
		//이전 자료와 비교한 후 새로 보관하는 자료.
		Map<String, Map<String, OutputBusData>> updatedBusLineInfoMap = new HashMap<>();
		
		urlList = readBusNumUrl.readBusUrl(busUrlInfoPath, busUrlInfoFileName);
		busUrlInfoList = readBusNumUrl.splitUrlData(",", urlList);
		
		
		for(int i=0; i<busUrlInfoList.size(); i++){
			
			List<OutputBusData> dataFromWebList = new ArrayList<>();
			
			String handleBusNum = busUrlInfoList.get(i).getBusNum();
			
			
			parsingHtmlResult = parsingHtml.DownloadHtml(busUrlBasic + busUrlInfoList.get(i).getBusUrl());
			operateBusList = processingHtmlData.getBusInfoFromRegex(parsingHtmlResult, busRegex);
			busLineInfoList = processingHtmlData.splitRawData(";", operateBusList);
			
			dataFromWebList = busInfoToFile.putOutToFile(handleBusNum, busLineInfoList);
			
			//System.out.println(dataFromWebList);
			
			Map<String, OutputBusData> pairLicenseBusinfoMap = new HashMap<>();
			Map<String, Map<String, OutputBusData>> tempMap = new HashMap<>();
			
			for(int j=0; j<dataFromWebList.size(); j++){
				//System.out.println(dataFromWebList.get(j).getBusLicenseNum());
				pairLicenseBusinfoMap.put(dataFromWebList.get(j).getBusLicenseNum(), dataFromWebList.get(j));
			}
			
			//tempMap.put(handleBusNum, pairLicenseBusinfo);
			recentBusLineInfoMap.put(handleBusNum, pairLicenseBusinfoMap);
		}
		
		//비교 시작.
		for(int i=0; i<busUrlInfoList.size(); i++){
			
			String handleBusNum = busUrlInfoList.get(i).getBusNum();
			
			//busInfoToFile.compareCurrentAndPast(recentBusLineInfoMap.get(handleBusNum), currentData)
			
			//argumentMap.put(recentBusLineInfoMap.get(handleBusNum).get, recentBusLineInfoMap.get(handleBusNum));
			
		}
		
		
		
	}

}
