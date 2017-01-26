package com.paper.dataprocessing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.paper.domain.BusLineInfo;

public class SplitingRawDataTest {
	
	@Test
	public void testSplitRawData_실행하면_분리된_문자열이_list로_생성된다(){
		
		SplitingRawData splitingRawData = new SplitingRawData();
		BusLineInfo busLineInfoTest = new BusLineInfo();
		
		busLineInfoTest = splitingRawData.splitRawData(";", "7117501;472;83;3;7117503;370;0");
		
		assertEquals("7117501",busLineInfoTest.getBusLicense());
		
	}

}
