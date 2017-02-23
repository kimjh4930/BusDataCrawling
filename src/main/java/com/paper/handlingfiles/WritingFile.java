package com.paper.handlingfiles;

import java.io.File;
import java.io.FileWriter;

import com.paper.domain.OutputBusData;

public class WritingFile {
	
	public void writeToFile(String path, OutputBusData outputBusData){
	
		//String filePath = "/Users/junha/Documents/workspace/BusDataCrawling/" + filename;
		
		try{
			
			File file = new File(path + "/"
								//+ outputBusData.getBusNum() + "/"
								+ outputBusData.getBusLicenseNum() + ".txt");
			
			//폴더에 안들어가짐 수정해야함.
			
			FileWriter fw = new FileWriter(file, true);
			
			fw.write(outputBusData.toString());
			fw.flush();
			
			fw.close();
	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
		
}
