package com.paper.handlingfile;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.paper.domain.BusUrlInfo;
import com.paper.handlingfiles.ReadingFile;

public class ReadingFileTest {
	
	@Ignore
	@Test
	public void readBusUrl_수행하면_버스번호와_연관된Url이_나온다(){
		
		String path = "/Users/junha/Documents/workspace/BusDataCrawling/";
		String filename = "IncheonYeonsuBus.txt";
		
		ReadingFile readingFile = new ReadingFile();
		List<BusUrlInfo> busUrlInfo = readingFile.readBusUrl1(path, filename);
		
		for(int i=0; i< busUrlInfo.size(); i++){
			System.out.print(busUrlInfo.get(i).getBusNum() + ",");
			System.out.println(busUrlInfo.get(i).getBusURL());
		}

		
	}
	
	@Test
	public void splitUrlData_리스트를_입력하면_split해서_list모델에_담긴다(){
		
		String busUrlInfoPath = "/Users/junha/Documents/workspace/BusDataCrawling/";
		String busUrlInfoFileName = "IncheonYeonsuBus.txt";
		
		ReadingFile		readBusNumUrl = new ReadingFile();
		
		List<String>	urlList = readBusNumUrl.readBusUrl(busUrlInfoPath, busUrlInfoFileName);
		List<BusUrlInfo> busUrlInfoList = readBusNumUrl.splitUrlData(",", urlList);

		System.out.println("busUrlInfoList.size() : " + busUrlInfoList.size());
		
		for(int i=0; i < busUrlInfoList.size(); i++){
			System.out.println(busUrlInfoList.get(i));
		}
		
		
	}

}
