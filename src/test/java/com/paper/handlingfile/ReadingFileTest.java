package com.paper.handlingfile;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.paper.domain.BusUrlInfo;
import com.paper.handlingfiles.ReadingFile;

public class ReadingFileTest {
	
	@Test
	public void readBusUrl_수행하면_버스번호와_연관된Url이_나온다(){
		
		String path = "/Users/junha/Documents/workspace/BusDataCrawling/";
		String filename = "incheonbuslist.txt";
		
		ReadingFile readingFile = new ReadingFile();
		List<BusUrlInfo> busUrlInfo = new ArrayList<>();
		
		busUrlInfo = readingFile.readBusUrl(path, filename);
		
		//System.out.println(busUrlInfo.get(0).getBusURL());
		assertEquals(521,busUrlInfo.get(0).getBusNum());
		
	}

}
