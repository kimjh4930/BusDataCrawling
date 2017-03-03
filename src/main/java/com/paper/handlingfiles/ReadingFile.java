package com.paper.handlingfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.paper.domain.BusUrlInfo;

public class ReadingFile {
	
	public List<BusUrlInfo> readBusUrl1(String path, String filename){
		
		List<BusUrlInfo> busUrlInfo = new ArrayList<>();
		
		BufferedReader br = null;
		InputStreamReader isr = null;
		FileInputStream fis = null;
		
		File file = new File(path + filename);
		
		String temp = "";
		
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			
			while((temp = br.readLine()) != null ){
				System.out.println(temp);
				//busUrlInfo.add(this.splitUrlData(",", temp));
			}
		}catch(FileNotFoundException e){
			
		}catch(Exception e){
			
		}finally {
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
		
		return busUrlInfo;
		
	}
	
	public List<String> readBusUrl(String path, String filename){
		
		List<String> busUrlInfo = new ArrayList<>();
		
		File file = new File(path + filename);
		String temp = "";
		
		try{
			
			Scanner scanner = new Scanner(file,"UTF-8");
			
			while((temp = scanner.nextLine()) != null){
				busUrlInfo.add(temp);
			}
			
		}catch(Exception e){
			
		}
		
		return busUrlInfo;
		
	}
	
	public List<BusUrlInfo> splitUrlData(String splitWord, List<String> busNumUrl){
		
		List<BusUrlInfo> busUrlInfoList = new ArrayList<>();
		
		for(int i=0; i<busNumUrl.size(); i++){
			
			BusUrlInfo busUrlInfo = new BusUrlInfo();
			String[] splitResult = busNumUrl.get(i).split(splitWord);
			
			busUrlInfo.setBusNum(splitResult[0]);
			busUrlInfo.setBusURL(splitResult[1]);
			
			busUrlInfoList.add(busUrlInfo);
			
		}
		
		return busUrlInfoList;
	}

}
