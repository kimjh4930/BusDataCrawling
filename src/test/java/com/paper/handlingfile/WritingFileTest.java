package com.paper.handlingfile;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import com.paper.domain.OutputBusData;
import com.paper.handlingfiles.WritingFile;

public class WritingFileTest {
	
	public String readFromFile_지정한_경로에_파일이_제대로_생성되었는지_확인한다(String filename){
		
		BufferedReader br = null;
		InputStreamReader isr = null;
		FileInputStream fis = null;
		
		File file = new File("/Users/junha/Documents/workspace/BusDataCrawling/" + filename);
		
		String temp = "";
		String content = "";
		
		try{
			
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			
			while( (temp = br.readLine()) != null ){
				content += temp;
			}
			
			System.out.println(content);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				fis.close();
			}catch (IOException e){
				e.printStackTrace();
			}
			
			try{
				isr.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
			try{
				br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		return content;
	}
	
	@Test
	public void writeToFile_경로와_버스정보_결과값을_넣으면_버스번호폴더에_차량번호파일이_생성되고_저장된다(){
		
		WritingFile writingFile = new WritingFile();
		
		OutputBusData outputBusData = new OutputBusData();
		outputBusData.setDate("170224");
		outputBusData.setArrivalTime("112233");
		outputBusData.setBusStopId("1234");
		outputBusData.setHangingTime(100);
		outputBusData.setBusNum("521");
		outputBusData.setBusLicenseNum("9999999");
		
		String path = "/Users/junha/Documents/workspace/BusDataCrawling/";
		
		writingFile.writeToFile(path, outputBusData);
		
	}

}
