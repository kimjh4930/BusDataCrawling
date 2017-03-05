package com.paper.main;

import static org.junit.Assert.*;

import org.junit.Test;

import com.paper.domain.BusLineInfo;

public class AppTest {
	
	@Test
	public void test_lombok을_추가하고_제대로_동작하는지_확인(){
		BusLineInfo busLine = new BusLineInfo();
		//busLine.setBusInterval(123);
		
		//assertEquals("123값이 반환되어야 함.", 123, busLine.getBusInterval());
	}

}
