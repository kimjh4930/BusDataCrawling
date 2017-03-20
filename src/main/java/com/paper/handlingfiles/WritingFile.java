package com.paper.handlingfiles;

import java.io.File;
import java.io.FileWriter;

import com.paper.domain.OutputBusData;

public class WritingFile {
	
	public void writeToFile(String path, OutputBusData outputBusData){
		
		try{
			
			File directory = new File(path + "/");
			
			if(!directory.exists()){
				directory.mkdirs();
			}
			
			File file = new File(path + "/"
								+ outputBusData.getBusNum() + ".txt");
			
			FileWriter fw = new FileWriter(file, true);
			
			fw.write(outputBusData.toString() + "\n");
			fw.flush();
			
			fw.close();
	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
		
}
