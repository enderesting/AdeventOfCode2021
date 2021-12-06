import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

class Day2Dive {
	public static void main(String args[]){
		int horizontal = 0;
		int depth = 0;
		int aim = 0;
		try{
			File data = new File("Day2DiveData.txt");
			Scanner sc = new Scanner(data);
		    while(sc.hasNext()){
		        String command = sc.next();
		        int value = sc.nextInt();
		        if (command.equals("forward")){
		        	horizontal += value;
		        	depth += aim*value;
		        }
		        else if(command.equals("down")){
		        	aim += value;
		        }
		        else if(command.equals("up")){
		        	aim -= value;
		        }
		        //System.out.println("Command is: " + command + " for a value of: " + value);
		    }
		    sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Ye fucked up");
			e.printStackTrace();
		}
		System.out.println("Horizontal is: " + horizontal + " Depth is: " + depth);
		int product = horizontal * depth;
		System.out.println("product of both equals: " + product);

	}
}