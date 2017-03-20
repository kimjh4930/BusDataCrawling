package com.paper.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.paper.dataprocessing.BusInfoToFile;
import com.paper.dataprocessing.ParsingHtml;
import com.paper.dataprocessing.ProcessingHtmlData;
import com.paper.domain.BusLineInfo;
import com.paper.domain.BusRoadInfo;
import com.paper.domain.BusUrlInfo;
import com.paper.domain.OutputBusData;
import com.paper.handlingfiles.ReadingFile;

public class App {
	
	static final String busUrlInfoPath = "../";
	static final String busUrlInfoFileName = "IncheonYeonsuBus.txt";
	static final String busUrlBasic = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?";
	
	static final String busRegex = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
	static final String roadRegex = String.format("\\d+;\\d{9,10};\\d;\\d+");
	
	//버스번호, 번호판번호, 자료들.
	static Map<String, Map<String, OutputBusData>> recentBusLineInfoMap;
	
	static Map<String, Map<String, OutputBusData>> modifiedBusLineInfoMap;
	//이전 자료와 비교한 후 새로 보관하는 자료.
	static Map<String, Map<String, OutputBusData>> newBusLineInfoMap;
	
	static private ReadingFile 			readBusNumUrl;
	static private ParsingHtml 			parsingHtml;
	static private ProcessingHtmlData 	processingHtmlData;
	static private BusInfoToFile 		busInfoToFile;
	
	public static void main(String[] args){
		
		int sleepSec = 10;
		
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

		initializeSetting();
		
		exec.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				System.out.println("실행.");
				checkBusInfo();
			}
			
		}, 0, sleepSec, TimeUnit.SECONDS);
		
	}
	
	public static void initializeSetting(){
		
		readBusNumUrl 		= new ReadingFile();
		parsingHtml 		= new ParsingHtml();
		processingHtmlData	= new ProcessingHtmlData();
		busInfoToFile 		= new BusInfoToFile();
		
		recentBusLineInfoMap 	= new HashMap<>();
		modifiedBusLineInfoMap 	= new HashMap<>();
		newBusLineInfoMap 		= new HashMap<>();
		
	}
	
	public static void checkBusInfo(){
		
		String 				parsingHtmlResult = null;
		
		List<String> 		urlList;
		List<BusUrlInfo>	busUrlInfoList;
		
		List<BusLineInfo>	busLineInfoList = new ArrayList<>();
		List<String>		operateBusList = new ArrayList<>();
		
		//List<BusRoadInfo>	roadInfoList = new ArrayList<>();
		
		List<String>		roadSituationList = new ArrayList<>();
		
		urlList = readBusNumUrl.readBusUrl(busUrlInfoPath, busUrlInfoFileName);
		busUrlInfoList = readBusNumUrl.splitUrlData(",", urlList);
		
		//시간설정.
		//현재시
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat timeForamt = new SimpleDateFormat("HHmmss");
		
		String day = dayFormat.format(new Date(currentTime));
		String time = timeForamt.format(new Date(currentTime));
		
		//for(int i=0; i<busUrlInfoList.size(); i++){
		for(int i=0; i<1; i++){
			List<OutputBusData> 		dataFromWebList = new ArrayList<>();
			Map<String, BusRoadInfo>	roadInfoMap = new HashMap<>();
			
			String handleBusNum = busUrlInfoList.get(i).getBusNum();
			
			parsingHtmlResult 		= parsingHtml.DownloadHtml(busUrlBasic + busUrlInfoList.get(i).getBusUrl());
			operateBusList 			= processingHtmlData.getBusInfoFromRegex(parsingHtmlResult, busRegex);
			busLineInfoList 		= processingHtmlData.splitRawBusData(";", operateBusList);
			roadSituationList 		= processingHtmlData.getBusInfoFromRegex(parsingHtmlResult, roadRegex);
			roadInfoMap 			= processingHtmlData.splitRawRoadData(";", roadSituationList);
			dataFromWebList 		= busInfoToFile.putOutToFile(handleBusNum, busLineInfoList, roadInfoMap, day, time);
			
			
			Map<String, OutputBusData> pairLicenseBusinfoMap = new HashMap<>();
			
			for(int j=0; j<dataFromWebList.size(); j++){
				pairLicenseBusinfoMap.put(dataFromWebList.get(j).getBusLicenseNum(), dataFromWebList.get(j));
			}
			newBusLineInfoMap.put(handleBusNum, pairLicenseBusinfoMap);
			
			//System.out.println(dataFromWebList);
		}
		
		//비교 시작.
		
		if(recentBusLineInfoMap.isEmpty()){
			System.out.println("Enter");
			recentBusLineInfoMap.putAll(newBusLineInfoMap);
		}
		
		//for(int i=0; i<busUrlInfoList.size(); i++){
		for(int i=0; i<1; i++){
			
			Map<String, OutputBusData> updatedBusDataMap = new HashMap<>();
			
			String handleBusNum = busUrlInfoList.get(i).getBusNum();
			
			List<OutputBusData> newBusDataList = new ArrayList<>(newBusLineInfoMap.get(handleBusNum).values());
			
			updatedBusDataMap = busInfoToFile.compareCurrentAndPast(recentBusLineInfoMap.get(handleBusNum), newBusDataList);
			
			modifiedBusLineInfoMap.put(handleBusNum, updatedBusDataMap);
		}
		
		recentBusLineInfoMap.clear();
		recentBusLineInfoMap.putAll(modifiedBusLineInfoMap);
		
		modifiedBusLineInfoMap.clear();
		newBusLineInfoMap.clear();
	}

}
