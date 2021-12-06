import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.lang.String;
import java.lang.StringBuilder;

class Day3Binary {
	public static void main(String args[]){
		int x = 12;
		int y = 1000;
		String[] arr = new char[y];
		int[] counter = new int[x];
		String gammaString;
		String epsilonString;
		StringBuilder sbg = new StringBuilder();
		StringBuilder sbe = new StringBuilder();


		try{
			File data = new File("Day3BinaryData.txt");
			Scanner sc = new Scanner(data);

		    while(sc.hasNext()){
		        for(int j = 0; j < y; j++){
			        String line = sc.nextLine();

			        /*int length = (int) (Math.log10(line) + 1);
			        System.out.println( line + " length: " + length);     this is the line counting thing*/
		        
			        for(int i = 0; i < x; i++){
			        	arr[j][i] = line.charAt(i);
			        	char temp = line.charAt(i);
			        	if(temp == '1'){
			        		counter[i]++;
			        	}
			        	//System.out.println(arr[j][i]);
			        }
			        //System.out.println(" ");  line break take a breather
		        }
		        //System.out.println("Command is: " + command + " for a value of: " + value);
		    }
		    sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Ye fucked up");
			e.printStackTrace();
		}

		for(int i = 0; i < x; i++){
			System.out.println("Total 1s in " + i + " line: " + counter[i]);
			if ((y - counter[i]) > counter[i]){ //if zero more than ones
				sbg.append('0');
				sbe.append('1');
			}
			else{
				sbg.append('1');
				sbe.append('0');
			}
		}
		gammaString = sbg.toString();
		epsilonString = sbe.toString();
		System.out.println("gammaString:" + gammaString + "   epsilonString:" + epsilonString);
	}
}

//gammaString:100011100101   epsilonString:011100011010


