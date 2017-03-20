package com.paper.dataprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.paper.domain.BusRoadInfo;

public class ProcessingHtmlTest {
	
	static final String roadRegex = String.format("\\d+;\\d{9,10};\\d;\\d+");
	
	@Test
	public void getBusInfoFromRegex_도로정보를_가져온다(){
		
		ParsingHtml parsingHtml = new ParsingHtml();
		ProcessingHtmlData processingHtmlData = new ProcessingHtmlData();
		List<String> roadSituationList = new ArrayList<>();
		Map<String, BusRoadInfo> BusRoadInfoMap = new HashMap<>();
		
		String parsingHtmlResult = parsingHtml.DownloadHtml("http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=320&routeid=165000392&authtpcd=2&rNo=946");
		//System.out.println(parsingHtmlResult);
		roadSituationList = processingHtmlData.getBusInfoFromRegex(parsingHtmlResult, roadRegex);
		
		BusRoadInfoMap = processingHtmlData.splitRawRoadData(";", roadSituationList);
		
		System.out.println(BusRoadInfoMap);
	}
	
	

}
