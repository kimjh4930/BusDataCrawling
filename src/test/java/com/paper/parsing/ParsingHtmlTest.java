package com.paper.parsing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.paper.dataprocessing.ParsingHtml;

public class ParsingHtmlTest {
	
	@Test
	public void testDownloadHtml_수행하면_HTML페이지를_가져온다 (){
		
		ParsingHtml parsingHtml = new ParsingHtml();
		String bus521 = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";
		
		System.out.println(parsingHtml.DownloadHtml(bus521));
		
		assertNotNull("값이 제대로 넘어오면 null값이 아님.", parsingHtml.DownloadHtml(bus521));
		
	}

}
