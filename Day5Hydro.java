import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.lang.Math;

class Day5Hydro {
	public static int[][] CARD = new int[1000][1000];

	public static void main(String args[]){
		//int[][][] dataArr = new int[numOfLines][2][2];
		/*
		[n - representing lines]
		[a - coord set 1 or 2]
		[b - x or y]
		*/
		AssignArray();
		print3d(CARD);
	}

	public static void NoteCard(int[] data){
		int x1 = data[0];
		int y1 = data[1];
		int x2 = data[2];
		int y2 = data[3];

		int maxX = Math.max(x1, x2);
		int minX = Math.min(x1, x2);
		int maxY = Math.max(y1, y2);
		int minY = Math.min(y1, y2);

		if (x1 == x2){
			//if x match, compare y
			int fixed = x1;
			for (int i = minY; i <= maxY; i++) {
				CARD[fixed][i] += 1;
			}
		}
		else if(y1 == y2){
			//if y match, compare x
			int fixed = y1;
			for (int i = minX; i <= maxX; i++) {
				CARD[i][fixed] += 1;
			}
		}
		else if((y1-y2)/(x1-x2) == 1){
			// line goes /
			for (int i = 0; i <= maxX-minX; i++) {
				//System.out.println("i: " + i + " minX+i:" + (minX+i) + " minY-i: " + (minY-i));
				CARD[minX+i][minY+i] += 1;
			}
		}
		else if((y1-y2)/(x1-x2) == -1){
			// line goes \
			for (int i = 0; i <= maxX-minX; i++) {
				//System.out.println("i: " + i + " minX+i:" + (minX+i) + " minY-i: " + (minY-i));
				CARD[minX+i][maxY-i] += 1;
			}
		}
		
	}

	public static void AssignArray(){
		try{
			File fileData = new File("Day5HydroData.txt");
			Scanner sc = new Scanner(fileData);
			//Pattern arrowPattern = Pattern.compile(" -> ");
			Pattern commaPattern = Pattern.compile(",");

		    while(sc.hasNextLine()){ // learn how to do regex
		    	String[] temp = commaPattern.split(sc.nextLine());
		    	int[] data = new int[temp.length];
		    	for (int i = 0; i < temp.length; i++){
		    		data[i] = Integer.parseInt(temp[i]);
		    	}
		    	NoteCard(data);
	    		System.out.println(Arrays.toString(data));
		    }
		    sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Ye fucked up");
			e.printStackTrace();
		}
	}

	public static void PatternTest(){
	    Pattern pattern = Pattern.compile("\\d,\\d -> \\d,\\d");
	    Matcher matcher = pattern.matcher("2,2 -> 2,1");
	    boolean matchFound = matcher.find();
	    if(matchFound) {
		    System.out.println("Match found");
	    } else {
		    System.out.println("Match not found");
	    }
	}

    public static void print3d(int[][] v){
    	int counter = 0;
    	for (int a = 0; a < v.length; a++) {
    		for (int b = 0; b < v[a].length; b++) {
				//System.out.print(v[b][a] + "|");
				if (v[b][a] >= 2){
					counter++;
				}
    		}
		//System.out.println(" ");
    	}
    	System.out.println("2 or more crosses:" + counter);
    }


}
