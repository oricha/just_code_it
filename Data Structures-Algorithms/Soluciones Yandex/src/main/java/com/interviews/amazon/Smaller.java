package com.interviews.amazon;




public class Smaller {

	
	public String solution(String S) {
		
		byte sumMusic = Byte.valueOf("0");
		byte sumImage = Byte.valueOf("0");
		byte sumMovie = Byte.valueOf("0");
		byte sumOther = Byte.valueOf("0");
		
        String[] lines = S.split(System.getProperty("line.separator"));
        
        for (int i = 0; i < lines.length; i++){
        	String[] file = lines[i].split(" ");
        	byte bytes = Byte.valueOf(file[1].replace("b", ""));
        	switch(fileType(file[0])) {
        		case "MUSIC" :
        			sumMusic ^= bytes;
        		case "IMAGE" :
        			sumImage ^= bytes ;	
        		case "MOVIE" :
        			sumMovie ^= bytes ;	
        		default:	
        			sumOther ^= bytes ;
        	}
        }
        
        return  "music "+  sumMusic + "b"+"\r\n "+
		        "images "+  sumImage + "b"+"\r\n "+
		        "movies "+  sumMovie + "b"+"\r\n "+
		        "other "+  sumOther + "b"+"\r\n ";
    }
	
	public String fileType(String nameFile){
		String result = "OTHER";
		
		if (nameFile.endsWith(".mp3") || nameFile.endsWith(".aac") || nameFile.endsWith(".flac")){
			return "MUSIC";
		}
		if (nameFile.endsWith(".jpg") || nameFile.endsWith(".bmp") || nameFile.endsWith(".gif")){
			return "IMAGE";
		}
		if (nameFile.endsWith(".mp4") || nameFile.endsWith(".avi") || nameFile.endsWith(".mkv")){
			return "MOVIE";
		}
		
		return result;
	}
}
