package com.paper.dataprocessing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.paper.domain.BusCompareResult;
import com.paper.domain.BusLineInfo;
import com.paper.domain.OutputBusData;

public class BusInfoToFileTest {

	@Test
	public void compareCurrentAnPast_현재과거자료를_비교해서_최근자료로_업데이트한다() {
		
		ProcessingHtmlData processingHtmlData = new ProcessingHtmlData();
		
		List<BusLineInfo> busLineInfoListPast = new ArrayList<>();
		List<BusLineInfo> busLineInfoListCurrent = new ArrayList<>();
		List<String> operateBusListPast = new ArrayList<>();
		List<String> operateBusListCurrent = new ArrayList<>();
		List<OutputBusData> outputBusDataCurrentList = new ArrayList<>();
		List<OutputBusData> resultList = new ArrayList<>();
		
		Map<String, OutputBusData> pastBusInfoMap = new HashMap<>();
		
		
		String past = "7211341;1995;24;3;7211340;916;0, 7211340;572;53;3;7211339;1260;0, 7211339;997;83;3;7016016;-999;0, 7016016;2199;88;3;7015086;-999;0, 7211338;968;112;3;7211337;648;0, 7211337;1958;127;3;7211300;498;0, 7211300;1201;144;3;7211299;705;0, 7211299;2089;162;3;7211258;266;0, 7211258;801;171;3;7015087;-999;0, 7015087;2120;212;3;7015086;446;0, 7015086;2237;227;3;7015085;685;0, 7015085;1457;244;3;7015065;599;0, 7015065;1911;260;3;7015081;593;0, 7015081;303;280;3;7015067;531;0, 7015067;2239;299;3;7015063;391;0, 7015063;1969;309;3;7015062;320;0, 7015062;879;317;3;7015061;847;0, 7015061;2180;337;3;7015060;724;0, 7015060;1907;360;3;0;-999;0";
		String current = "7211341;1995;29;3;7211340;862;0, 7211340;572;53;3;7211339;1245;0, 7211339;997;83;3;7016016;-999;0, 7016016;2199;88;3;7015086;-999;0, 7211338;968;113;3;7211337;719;0, 7211337;1958;131;3;7211300;554;0, 7211300;1201;144;3;7211299;705;0, 7211299;2089;169;3;7211258;242;0, 7211258;801;177;3;7015087;-999;0, 7015087;2120;219;3;7015086;419;0, 7015086;2237;234;3;7015085;753;0, 7015085;1457;245;3;7015065;619;0, 7015065;1911;260;3;7015081;593;0, 7015081;303;282;3;7015067;598;0, 7015067;2239;302;3;7015063;428;0, 7015063;1969;314;3;7015062;330;0, 7015062;879;322;3;7015061;847;0, 7015061;2180;339;3;7015060;649;0, 7015060;1907;365;3;0;-999;0, 7111111;1907;360;3;0;-999;0";
		
		operateBusListPast = processingHtmlData.getBusInfoFromRegex(past, "\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
		busLineInfoListPast = processingHtmlData.splitRawBusData(";", operateBusListPast);
		
		//이전에 저장되어있는 데이터.
		for(int i=0; i<busLineInfoListPast.size(); i++){
			OutputBusData outputBusDataPast = new OutputBusData();
			
			outputBusDataPast.setDate("170303");
			outputBusDataPast.setArrivalTime("120000");
			outputBusDataPast.setBusStopId(busLineInfoListPast.get(i).getCurrentLocation());
			outputBusDataPast.setHangingTime(0);
			outputBusDataPast.setBusNum(busLineInfoListPast.get(i).getBusNum());
			outputBusDataPast.setBusLicenseNum(busLineInfoListPast.get(i).getBusLicense());
			
			pastBusInfoMap.put(busLineInfoListPast.get(i).getBusLicense(), outputBusDataPast);
		}
		
		//새로운데이터.
		operateBusListCurrent = processingHtmlData.getBusInfoFromRegex(current, "\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
		busLineInfoListCurrent = processingHtmlData.splitRawBusData(";", operateBusListCurrent);
		
		for(int i=0; i<busLineInfoListCurrent.size(); i++){
			OutputBusData outputBusDataCurrent = new OutputBusData();
			
			outputBusDataCurrent.setDate("170303");
			outputBusDataCurrent.setArrivalTime("120030");
			outputBusDataCurrent.setBusStopId(busLineInfoListCurrent.get(i).getCurrentLocation());
			outputBusDataCurrent.setHangingTime(0);
			outputBusDataCurrent.setBusNum(busLineInfoListCurrent.get(i).getBusNum());
			outputBusDataCurrent.setBusLicenseNum(busLineInfoListCurrent.get(i).getBusLicense());
			
			outputBusDataCurrentList.add(outputBusDataCurrent);
		}
		
		BusInfoToFile busInfoToFile = new BusInfoToFile();
		
		//resultList = busInfoToFile.compareCurrentAndPast(pastBusInfoMap, outputBusDataCurrentList);
		
		//System.out.println(busCompareResultList.size());
		
//		for(int i=0; i<busCompareResultList.size(); i++){
//			System.out.println(busCompareResultList.get(i));
//		}
		
		//System.out.println(resultList.get(19));
		
		//assertEquals("20", String.valueOf(resultList.size()));
		
	}

}
