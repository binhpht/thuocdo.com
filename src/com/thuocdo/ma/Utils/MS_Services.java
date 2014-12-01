package com.thuocdo.ma.Utils;

import java.sql.Timestamp;
import java.util.Calendar;


import com.thuocdo.ma.Bean.AgeRank;

public class MS_Services {
	public static boolean checkAge(Timestamp birthday,AgeRank ageRank){
		
		Calendar cal = Calendar.getInstance();
		int age=cal.getTime().getYear()- birthday.getYear();
		System.out.println(age);
		int[] rank=getAgeRank(ageRank.getDescription());
		if(age>=rank[0]&& age<=rank[1]){
			return true;
		}else{
			return false;
		}
	}
	
	public static int[] getAgeRank(String ageRank){
		int[] rank=new int[2];
		if(ageRank.equals("12-17")){
			rank[0]=12;
			rank[1]=17;
		}else if(ageRank.equals("18-35")){
			rank[0]=18;
			rank[1]=35;
		}else if(ageRank.equals("36-55")){
			rank[0]=36;
			rank[1]=55;
		}else if(ageRank.equals("56-70")){
			rank[0]=56;
			rank[1]=70;
		}else if(ageRank.equals("Trên 70")){
			rank[0]=36;
			rank[1]=55;
		}
		return rank;
	}
}
