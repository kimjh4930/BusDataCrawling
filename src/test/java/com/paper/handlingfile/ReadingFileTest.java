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
		String filename = "IncheonYeonsuBus.txt";
		
		ReadingFile readingFile = new ReadingFile();
		List<BusUrlInfo> busUrlInfo = readingFile.readBusUrl1(path, filename);
		
//		for(int i=0; i< busUrlInfo.size(); i++){
//			System.out.print(busUrlInfo.get(i).getBusNum() + ",");
//			System.out.println(busUrlInfo.get(i).getBusURL());
//		}

		
	}

}
