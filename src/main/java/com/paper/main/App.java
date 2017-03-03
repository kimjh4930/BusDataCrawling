package com.paper.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.paper.dataprocessing.ParsingHtml;
import com.paper.dataprocessing.ProcessingHtmlData;
import com.paper.domain.BusLineInfo;
import com.paper.domain.BusUrlInfo;
import com.paper.domain.OutputBusData;
import com.paper.handlingfiles.ReadingFile;
import com.paper.handlingfiles.WritingFile;

public class App {
	
	static final String busUrlInfoPath = "/Users/junha/Documents/workspace/BusDataCrawling/";
	static final String busUrlInfoFileName = "IncheonYeonsuBus.txt";
	static final String busUrlBasic = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?";
	
	static final String busRegex = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
	
	static Map<String, List<OutputBusData>> currentBusLineInfoMap = new HashMap<>();
	
	static List<BusUrlInfo> busUrlInfo = new ArrayList<>();
	
	public static void main(String[] args){
		
		String 				parsingHtmlResult = null;
		
		ReadingFile 		readBusNumUrl = new ReadingFile();
		ParsingHtml 		parsingHtml = new ParsingHtml();
		ProcessingHtmlData 	processingHtmlData = new ProcessingHtmlData();
		
		List<String> 		rawBusData = new ArrayList<>();
		List<BusLineInfo> 	busFinalInfo = new ArrayList<>();
		List<String> 		urlList;
		List<BusUrlInfo>	busUrlInfoList;
		
		urlList = readBusNumUrl.readBusUrl(busUrlInfoPath, busUrlInfoFileName);
		busUrlInfoList = readBusNumUrl.splitUrlData(",", urlList);
		
		System.out.println(busUrlInfoList.size());
		
		for(int i=0; i<busUrlInfoList.size(); i++){
			//System.out.println(busUrlInfoList);
			//System.out.println(urlList.get(i));
		}
		
		
//		for(int i=0; i<busUrlInfo.size(); i++){
//			
//			List<String> operateBusList = new ArrayList<>();
//			List<BusLineInfo> busLineInfoList = new ArrayList<>();
//			
//			WritingFile writingFile = new WritingFile();
//			
//			parsingHtmlResult = parsingHtml.DownloadHtml(busUrlInfo.get(i).getBusURL());
//			operateBusList = processingHtmlData.getBusInfoFromRegex(parsingHtmlResult, busRegex);
//			
//			busLineInfoList = processingHtmlData.splitRawData(";", operateBusList);
//			
//			
//		}
		
		
		
		
//		String parseResult = null;
//		List<String> rawData = new ArrayList<String>();
//		List<BusLineInfo> busFinalInfo521 = new ArrayList<BusLineInfo>();
//		
//		ParsingHtml parsingHtml = new ParsingHtml();
//		ProcessingHtmlData processingHtmlData = new ProcessingHtmlData();
//		BusLineInfo busLineInfo521 = new BusLineInfo();
//		
//		parseResult = parsingHtml.DownloadHtml(busURL521);
//		rawData = processingHtmlData.getBusInfoFromRegex( parseResult , busRegex );
//		
//		for(int i=0; i<rawData.size(); i++){
//			busFinalInfo521.add(processingHtmlData.splitRawData(";", rawData.get(i)));
//		}
//		
//		System.out.println(busFinalInfo521);
		
	}

}
