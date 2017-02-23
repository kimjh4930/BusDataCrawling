package com.paper.dataprocessing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.paper.domain.BusLineInfo;

public class ProcessingHtmlDataTest {
	
	@Test
	public void testGetBusLineInfo_매개변수로_html정보와_원하는_정규식을_넣으면_버스정보를_얻을수있다 (){
		
		ParsingHtml parsinghtml = new ParsingHtml();
		
		String busHtml = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";
		//String busRegex = String.format("\\d+;\\d+;\\d+;\\d+;\\d{4};\\d{4};\\d+;\\d+;\\d{4};\\d{4};\\d+;\\d+");
		String busRegex = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
		String htmlInfo = parsinghtml.DownloadHtml(busHtml);
		
		List<String> resultList = new ArrayList<String>();
		
		ProcessingHtmlData processingHtmlData = new ProcessingHtmlData();
		
		resultList = processingHtmlData.getBusInfoFromRegex(htmlInfo, busRegex);
		
		for(String result : resultList){
			System.out.println(result);
		}
		
		assertNotSame("제대로 값을 가져오면 \"\" 값이 아님", "", processingHtmlData.getBusInfoFromRegex(htmlInfo, busRegex));
		
	}
	
	@Ignore
	@Test
	public void testSplitRawData_실행하면_분리된_문자열이_list로_생성된다(){
		
		ProcessingHtmlData processingHtmlDataTest = new ProcessingHtmlData();
		BusLineInfo busLineInfoTest = new BusLineInfo();
		
		busLineInfoTest = processingHtmlDataTest.splitRawData(";", "7117501;472;83;3;7117503;370;0");
		
		assertEquals("7117501",busLineInfoTest.getBusLicense());
		
	}

}
