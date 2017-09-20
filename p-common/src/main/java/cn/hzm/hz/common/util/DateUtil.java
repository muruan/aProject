package cn.hzm.hz.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getDate(){
		  SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date now=new Date();
	        String s= myFmt2.format(now);
	        System.out.println(s+"字符串");
	        Date d = null;
	        try {
				 d = myFmt2.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	       return d;
		 
	}
	
}