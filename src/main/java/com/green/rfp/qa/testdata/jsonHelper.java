package com.green.rfp.qa.testdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class jsonHelper {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	String d1=	"03/15/2022";
  //  String d2 =	"Mar 15 2022";
	 Date date1=new SimpleDateFormat("mmm/dd/yyyy").parse(d1);  
	    System.out.println(d1+"\t"+date1);  
	    SimpleDateFormat ft = new SimpleDateFormat("mm/dd/yyyy", Locale.US);
	    java.util.Date t=ft.parse("03/15/2022");
	    ft.applyPattern("mmm dd yyyy");
	    System.out.println(ft.format(t));
   	    SimpleDateFormat  s= new SimpleDateFormat("MMM");
        String strMonth= s.format("03/15/2022");
	    System.out.println("Month in MMM format = "+strMonth);
	}

}
