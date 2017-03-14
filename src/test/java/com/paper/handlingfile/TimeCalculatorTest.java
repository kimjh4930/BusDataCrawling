package com.paper.handlingfile;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.paper.domain.OutputBusData;
import com.paper.handlingfiles.TimeCalculator;

public class TimeCalculatorTest {
	
	@Ignore
	@Test
	public void calculateConsumptionTime_실행하면_시간차이를_계산한다(){
		
		TimeCalculator timeCalculator = new TimeCalculator();
		
		int prevTimeResult = timeCalculator.transferToSecond("090010");
		int latestTimeResult = timeCalculator.transferToSecond("090540");
		
		int timeConsumption = latestTimeResult - prevTimeResult;
		
		assertEquals(330, timeConsumption);
		
	}
	
	@Ignore
	@Test
	public void transferToSecond_시간을_초단위로_변환한다(){
		TimeCalculator timeCalculator = new TimeCalculator();
		
		int transferResult = timeCalculator.transferToSecond("090540");
		
		assertEquals(32740, transferResult);
	}
	
	@Test
	public void calculateConsumptionTime_날짜가_다를경우_시간을_계산한다(){
		
		TimeCalculator timeCalculator = new TimeCalculator();
		
		OutputBusData previous 	= new OutputBusData();
		OutputBusData latest	= new OutputBusData();
		
		previous.setDate("170313");
		previous.setArrivalTime("235500");
		
		latest.setDate("170314");
		latest.setArrivalTime("000520");
		
		int timeConsumption = timeCalculator.calculateTimeConsumption(previous, latest);
		
		System.out.println(timeConsumption);
		assertEquals(620, timeConsumption);
	}
	
	

}
