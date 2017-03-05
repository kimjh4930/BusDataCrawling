package com.paper.domain;

import java.util.List;

import lombok.Data;

@Data
public class BusCompareResult {
	
	private boolean isModified;		//변경되었는가, 변경되지않았는가 구별변수
	private OutputBusData outputBusData;

}
