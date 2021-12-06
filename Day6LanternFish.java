import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.lang.Math;
import java.util.List;

class Day6LanternFish {
	public static long[] DATE = new long[9];
	public static long FISH = 0; //needs to be long
	//ArrayList<Int> spawnData = new ArrayList<Int>();

	public static void main(String args[]){
		SplitData();
		//AssignFishToDateArray(data);
		OneDay(256);
		//System.out.println("How many fish there are per date: " + Arrays.toString(DATE));
		System.out.println("Fish total: " + CountFish());
	}

	public static void OneDay(int days){
		// each number count down with each tick
		// if 0 -> generate new number as 8, current number as 6
		// if 8 -> does not -- for this loop
		for (int j = 1; j <= days; j++) {
			long day0 = DATE[0];
			System.out.println("day0 = " + day0);
			for (int i = 0 ; i < 8; i++) {
				DATE[i] = DATE[i+1];	
			}
			DATE[8] = day0;
			DATE[6] += day0;
			System.out.println("How many fish there are on day " + j + Arrays.toString(DATE));
		}

	}

	public static long CountFish(){
		for (int j = 0; j<DATE.length; j++){
			FISH += DATE[j];
		}
		return FISH;
	}

	public static void SplitData(){
		try{
			File fileData = new File("Day6LanternFishData.txt");
			Scanner sc = new Scanner(fileData);
			//Pattern arrowPattern = Pattern.compile(" -> ");
			Pattern commaPattern = Pattern.compile(",");

		    while(sc.hasNextLine()){
		    	//String string = sc.nextLine();
		    	String[] temp = commaPattern.split(sc.nextLine());
				//ArrayList<String> list = new ArrayList<String>(string.split(","));
				int[] data = new int[temp.length];
		    	for (int i = 0; i < temp.length; i++){
		    		data[i] = Integer.parseInt(temp[i]);
		    	}
		    	//List<Integer> list = Arrays.asList(data);
			    //System.out.println(list);
			    System.out.println("Fish at beginning: " + Arrays.toString(data));
			    AssignFishToDateArray(data);
		    }
		    sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Ye fucked up");
			e.printStackTrace();
		}
	}

	public static void AssignFishToDateArray(int[] data){
		for (int j=0; j < data.length; j++) {  //j, counting every fish's date
			for (int i=0; i < 9; i++) { //i, counting every day
				//data[j]; returns a int
				if(data[j] == i){
					DATE[i]++;
				}
			}
		}
		System.out.println("How many fish there are at the beginning: " + Arrays.toString(DATE));
		//return DATE[];
	}

}
