package com.marcelo.mystore.utils;

import org.springframework.stereotype.Service;


@Service
public class RegionUtils {

	public String locateRegion(String state) {
		if(state.equals(null)) {
			return " ";
		}
		if(state.equalsIgnoreCase("AC") ||
				state.equalsIgnoreCase("AP") ||
				state.equalsIgnoreCase("AM") ||
				state.equalsIgnoreCase("PA") ||
				state.equalsIgnoreCase("RR") ||
				state.equalsIgnoreCase("RO") ||
				state.equalsIgnoreCase("TO")) {
			return "North";
		}
		if(state.equalsIgnoreCase("MA") ||
				state.equalsIgnoreCase("PI") ||
				state.equalsIgnoreCase("CE") ||
				state.equalsIgnoreCase("RN") ||
				state.equalsIgnoreCase("PB") ||
				state.equalsIgnoreCase("PE") ||
				state.equalsIgnoreCase("SE") ||
				state.equalsIgnoreCase("BA") ||
				state.equalsIgnoreCase("AL")) {
			return "NorthEast";
		}
		if(state.equalsIgnoreCase("MG") ||
				state.equalsIgnoreCase("ES") ||
				state.equalsIgnoreCase("SP") ||
				state.equalsIgnoreCase("RJ")) {
			return "SouthEast";
		}
		if(state.equalsIgnoreCase("PR") ||
				state.equalsIgnoreCase("SC") ||
				state.equalsIgnoreCase("RS")) {
			return "South";
		}
		if(state.equalsIgnoreCase("GO") ||
				state.equalsIgnoreCase("DF") ||
				state.equalsIgnoreCase("MT") ||
				state.equalsIgnoreCase("MS")) {
			return "MidWest";
		}
		return " ";
	}
	
	
}
