package com.codewars;

public class StringToCamelCase {
	
	 static String toCamelCase(String s){
		 
		  String[] array = s.split("-");
		  	
		  	for( int i=0; i< array.length; i++){
		  		String word =  array[i];
		  		 word = word.charAt(0) +  word.substring(1, word.length()-1);
		  		array[i]  = word;
		  	}
		  	
		  	 s = String.join("_", array);
		    return s;
		  }

}
