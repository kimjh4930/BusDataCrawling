package com.paper.dataprocessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessingHtmlData {
	//정규식을 이용해서 데이터를 뽑아냄.
	
	public String getBusInfoFromRegex (String busHtml, String busRegex){
		
		Pattern busInfoPattern = Pattern.compile(busRegex);
		Matcher busInfoMatcher = busInfoPattern.matcher(busHtml.trim());
		
		String busLineInfo = "";
		
		while(busInfoMatcher.find()){
			busLineInfo = busInfoMatcher.group(0).trim();
		}
		
		return busLineInfo;
		
	}
	
	

}
