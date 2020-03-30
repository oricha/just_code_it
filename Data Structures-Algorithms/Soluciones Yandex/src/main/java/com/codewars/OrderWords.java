package com.codewars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.SortedSet;
import java.util.TreeSet;

public class OrderWords {
	
	public static String order(String words) {
	    // ...
		if(words == null || words.equals("")) return "";
		StringBuffer result = new StringBuffer();
		Hashtable<Integer, String> source = new Hashtable<Integer,String>();
		String[] splited = words.split("\\s+");
		
		for(int i = 0; i < splited.length; i++){
			String item = splited[i];
			StringBuffer number =new StringBuffer("");
			for(int j=0; j < item.length(); j++){
				if(Character.isDigit((item.charAt(j)))){
					number.append(Character.getNumericValue(item.charAt(j)));
				}
			}
			 source.put( Integer.valueOf( number.toString()), item);
		}
		
		SortedSet<Integer> keys = new TreeSet<Integer>(source.keySet());
		boolean flat = false;
		for (Integer key : keys) { 
			   String value = source.get(key);
			   result.append(flat ? " "+ value: value );
			   flat = true;
			}
		
		return result.toString();
	  }
	
	public static String order2(String words) {
	    return Arrays.stream(words.split(" "))
	      .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
	      .reduce((a, b) -> a + " " + b).get();
	  }
}
