package com.paper.main;

import java.util.ArrayList;
import java.util.List;

import com.paper.dataprocessing.ParsingHtml;
import com.paper.dataprocessing.ProcessingHtmlData;
import com.paper.domain.BusLineInfo;

public class App {
	
	static List<BusLineInfo> busList521;
	
	public static void main(String[] args){
		
		String busURL521 = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";
		String busRegex521 = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
		String parseResult = null;
		List<String> rawData = new ArrayList<String>();
		List<BusLineInfo> busFinalInfo521 = new ArrayList<BusLineInfo>();
		
		initializeStaticArrayList();
		
		ParsingHtml parsingHtml = new ParsingHtml();
		ProcessingHtmlData processingHtmlData = new ProcessingHtmlData();
		BusLineInfo busLineInfo521 = new BusLineInfo();
		
		parseResult = parsingHtml.DownloadHtml(busURL521);
		rawData = processingHtmlData.getBusInfoFromRegex( parseResult , busRegex521 );
		
		for(int i=0; i<rawData.size(); i++){
			busFinalInfo521.add(processingHtmlData.splitRawData(";", rawData.get(i)));
		}
		
		System.out.println(busFinalInfo521);
		
	}
	
	public static void initializeStaticArrayList(){
		busList521 = new ArrayList<BusLineInfo>();
	}

}
