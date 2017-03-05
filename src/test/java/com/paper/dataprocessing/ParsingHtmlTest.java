package com.paper.dataprocessing;

import org.junit.Test;

public class ParsingHtmlTest {

	String parsingResult;
	String basicUrl = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?";
	
	@Test
	public void DownloadHtml_3_2번_버스테스트(){
		
		ParsingHtml parsingHtml = new ParsingHtml();
		
		parsingResult = parsingHtml.DownloadHtml(basicUrl+"routenm=3-2&routeid=165000310&authtpcd=2&rNo=704");
		
		System.out.println(parsingResult);
		
		
	}
}
