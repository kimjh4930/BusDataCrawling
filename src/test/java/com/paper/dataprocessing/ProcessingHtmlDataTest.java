package com.paper.dataprocessing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.paper.parsing.ParsingHtml;

public class ProcessingHtmlDataTest {
	
	@Test
	public void testGetBusLineInfo_매개변수로_html정보와_원하는_정규식을_넣으면_버스정보를_얻을수있다 (){
		
		ParsingHtml parsinghtml = new ParsingHtml();
		
		String busHtml = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";
		//String busRegex = String.format("\\d+;\\d+;\\d+;\\d+;\\d{4};\\d{4};\\d+;\\d+;\\d{4};\\d{4};\\d+;\\d+");
		String busRegex = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
		String htmlInfo = parsinghtml.DownloadHtml(busHtml);
		
		ProcessingHtmlData processingHtmlData = new ProcessingHtmlData();
		
		System.out.println(htmlInfo);
		System.out.println(processingHtmlData.getBusInfoFromRegex(htmlInfo, busRegex));
		
		assertNotSame("제대로 값을 가져오면 \"\" 값이 아님", "", processingHtmlData.getBusInfoFromRegex(htmlInfo, busRegex));
		
	}

}
