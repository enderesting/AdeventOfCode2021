import java.io.*;
class Day1SonarSweep {
	public static void main(String args[]){
		int n = 0;
		int numOfLines = 2000;
		int[] Data = new int[numOfLines];
		int[] DataSum = new int[numOfLines];
		int counter = 0;
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("Day1SonarData.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line

			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console, br.readLine() means it reads one line at a time
				Data[n] = Integer.parseInt(strLine);
				System.out.println(Data[n]);
				n++;
			}
			  //Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			}

		System.out.println("final n is: " + n);

		//add every three together put it in an array
		for(int j = 1; j < n-1; j++){
			DataSum[j-1] = Data[j-1] + Data[j] + Data[j+1];
		}

		//compare three-add array to the previous term
		for(int i = 1; i < n; i++){
			if(DataSum[i] > DataSum[i-1]){
				//System.out.println(Data[i] + " is bigger than " + Data[i-1]);
				counter ++;
			}
		}

		//System.out.println("Total increased times is: " + ArrayIncreaseCounter(n,Data[]));
		System.out.println("Total increased times is: " + counter);

	}

	/*public int ArrayIncreaseCounter(int n, int Array[]){
		int counter = 0;
		for(int i = 1; i < n; i++){
			if(Array[i] > Array[i-1]){
				//System.out.println(Data[i] + " is bigger than " + Data[i-1]);
				counter ++;
			}
		}
		return counter;
	}*/
}


/*import java.util.Scanner;

public class Day1SonarSweep{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.input);

		int first = 
	}
}*/


//FIRST ANSWER: 1502
//SECOND ANSWER: 1538