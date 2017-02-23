package com.paper.handlingfile;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

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
	
	

}
