package com.paper.domain;

import org.junit.Test;

public class OutputBusDataTest {
	
	//Lombok Override 테스트 했더니 안됨.
	@Test
	public void OutputBusData_자료가_변경되어_들어가는지_확인(){
		OutputBusData outputBusData = new OutputBusData();
		//안
		outputBusData.setClassifyStop("1234567890");
		
		System.out.println(outputBusData.getClassifyStop());
		
	}

}
