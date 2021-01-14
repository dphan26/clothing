package com.example.demo;

import org.apache.commons.lang3.StringUtils;

public class CheckNumeric {

	public static void main(String[] args) {
	
     String text1 = "0123a4";
     String text2 = "01234";
     boolean rs1 = StringUtils.isNumeric(text1);
     boolean rs2 = StringUtils.isNumeric(text2);
     System.out.println("rs1: " + rs1);
     System.out.println("rs1: " + rs2);


}
}
