import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Day4Bingo {
	public static void main(String args[]){
		//100 bingo cards
		int numOfCards = 100;
		String[][][] bingoData = new String[numOfCards][5][5]; //n,a,b
		//"7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
		String inputString = "57,9,8,30,40,62,24,70,54,73,12,3,71,95,58,88,23,81,53,80,22,45,98,37,18,72,14,20,66,0,19,31,82,34,55,29,27,96,48,28,87,83,36,26,63,21,5,46,33,86,32,56,6,38,52,16,41,74,99,77,13,35,65,4,78,91,90,43,1,2,64,60,94,85,61,84,42,76,68,10,49,89,11,17,79,69,39,50,25,51,47,93,44,92,59,75,7,97,67,15";
		String[] input = inputString.split(",");
		bingoData = bingoArrayMaking(bingoData,numOfCards);
		//print3d(bingoData);

		int counter = 0;
		//while(counter < numOfCards){
			int winner = WinnerBingo(bingoData,numOfCards,input);
			System.out.println("the winning card is: " + winner);
			System.out.println("the winning total: " + 
				IntTotal(bingoData,numOfCards,winner));
			ClearSheet(bingoData,numOfCards,winner);
			System.out.println("===============");
			counter++;
		//}


		/*
		int loser = LoserBingo(bingoData,numOfCards,input);
		System.out.println("the losing card is: " + loser);
		System.out.println("the losing total: " + 
			IntTotal(bingoData,numOfCards,loser));		
		*/

		print3d(bingoData);

		//function to compare a number to all of the arrays. if matches, turns number into "X"
		//after every one number loop, check each line/horizontal line and see if there's a bingo.
		//function for checking the winning bingo, loop through each number is it O or number?
			//if it's number, adds it up

	}
	/*empty out the array
	*/
	public static void ClearSheet(String[][][]bingoData, int numOfCards, int sheetNumber){
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				bingoData[sheetNumber][a][b] = "";
			}
		}
	}
	/* returns the number total of the numbers left not X'ed
	*/
	public static int IntTotal(String[][][]bingoData, int numOfCards, int sheetNumber){
		int sum = 0;
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				if(!bingoData[sheetNumber][a][b].equals("X")){
					int temp = Integer.valueOf(bingoData[sheetNumber][a][b]);
					sum += temp;
				}

			}
		}
		return sum;
	}


	/* returns the array number for the bingo sheet that bingo'ed
	*/
	public static int WinnerBingo(String[][][]bingoData, int numOfCards, String[] input){
		for(int i = 0; i < input.length; i++){
			//PretendLoop(String[][][] bingoArrayMaking(bingoData,numOfCards), boolean i==,)
			for (int n = 0; n < numOfCards; n++){
				if(!bingoData[n][0][0].isEmpty()){
					for (int a = 0; a < 5; a++) {
						for (int b = 0; b < 5; b++) {
							//System.out.println("n:" + n + " a: " + a + " b: " + b );
							//System.out.println("bingoData:" + bingoData[n][a][b] + " input[i]:" + input[i]);
							if(bingoData[n][a][b].equals(input[i])){
								//System.out.println(bingoData[n][a][b] + " = "+input[i] + " @ bingo card " + n+ " a:" + a + " b:" + b);
								bingoData[n][a][b] = "X";
							}
						}
						//System.out.println(" ");
					}
					if (CheckBingo(bingoData,numOfCards)){
						System.out.println("BINGO ALERT!! the winner is the " + n + "th card");

						print3d(bingoData);
						System.out.println("last number checked: " + input[i]);
						return n;

					}
					//System.out.println("===============");
				}

			}
		}
		return 0;
		//i guess theres no bingos?
	}


	public static int LoserBingo(String[][][]bingoData, int numOfCards, String[] input){
		int winnerCount = 0;
		for(int i = 0; i < input.length; i++){
			//PretendLoop(String[][][] bingoArrayMaking(bingoData,numOfCards), boolean i==,)
			for (int n = 0; n < numOfCards; n++){
				for (int a = 0; a < 5; a++) {
					for (int b = 0; b < 5; b++) {
						//System.out.println("n:" + n + " a: " + a + " b: " + b );
						//System.out.println("bingoData:" + bingoData[n][a][b] + " input[i]:" + input[i]);
						if(bingoData[n][a][b].equals(input[i])){
							//System.out.println(bingoData[n][a][b] + " = "+input[i] + " @ bingo card " + n+ " a:" + a + " b:" + b);
							bingoData[n][a][b] = "X";
						}
					}
					//System.out.println(" ");
				}
				if (CheckBingo(bingoData,numOfCards)){
					winnerCount++;
					System.out.println("BINGO ALERT!! the winner is the " + n + "th card");
					System.out.println("last number checked: " + input[i]);
					if(winnerCount == numOfCards){
						print3d(bingoData);
					}
				}
				//System.out.println("===============");
			}
		}
		return 0;
		//i guess theres no bingos?
	}

	public static boolean CheckBingo(String[][][] bingoData, int numOfCards){
		boolean bingo = false;
		for (int n = 0; n < numOfCards; n++){
			for (int a = 0; a < 5; a++) {
				int horizontalCounter = 0;
				int verticalCounter = 0;
				for (int b = 0; b < 5; b++) {

					if(bingoData[n][a][b].equals("X")){
						horizontalCounter++;
						if(horizontalCounter == 5){
							bingo = true;
							return bingo;
						}
					}
					if(bingoData[n][b][a].equals("X")){
						verticalCounter++;
						if(verticalCounter == 5){
							bingo = true;
							return bingo;
						}
					}
				}
			}
		}
		//System.out.println("No bingo here");
		return bingo;
	}


	public static String[][][] bingoArrayMaking(String[][][] bingoData, int numOfCards){
		try{
			File fileData = new File("Day4Bingo.txt");
			Scanner sc = new Scanner(fileData);
			String[] tempArray = new String[5];

		    while(sc.hasNextLine()){
			    for(int n = 0; n < numOfCards ;n++){
			    	for(int a = 0; a < 5; a++){
			    		// 1. read line, loop to search for double space and deletes it. and then do String.split() into an array
			    		// 2. read two char at a time? put it in array separately

			    		String tempLine = sc.nextLine();
			    		if (!tempLine.isEmpty()){
				    		tempArray = tempLine.split(" ");
				    		for(int b = 0; b < 5; b++){
				    			bingoData[n][a][b] = tempArray[b];
				    			//System.out.println("n:" + n + " a: " + a + " b: " + b);
				    			//System.out.println(bingoData[n][a][b]);
				    		}
			    			//System.out.println(" ");
				    	}
				    	else{
				    		//System.out.println("girl help there is an empty line");
				    		a--;
				    	}
			    	}
			    }
		    }
		    sc.close();
		    //print3d(bingoData);
		}
		catch(FileNotFoundException e){
			System.out.println("Ye fucked up");
			e.printStackTrace();
		}
		return bingoData;
	}


    /**
     * Imprime os elementos de um vetor de inteiros separados por espacos De
     * interesse apenas pedagogico. Para imprimir vetor qq devem usar
     * System.out.println(Arrays.toString(v))
     *
     * @param v O vetor a imprimir
     * @requires {@code v != null}
     */
    public static void print(String[] v) {
        for (int i = 0; i < v.length; i++)
            System.out.print(v[i] + "|");
        System.out.println();
    }


    public static void print3d(String[][][] v){
    	for (int n = 0; n < v.length; n++) {
    		for (int a = 0; a < v[n].length; a++) {
    			for (int b = 0; b < v[n][a].length ; b++) {
    				System.out.print(v[n][a][b] + " ");
    			}
    		System.out.println(" ");
    		}
		System.out.println(" ");
    	}
    }
}
/*first win:
last number checked: 14
the winning card is: 88
the winning total: 741
*/
/*last win:
last number checked: 89
the winning card is: 68
the winning total: 278
*/
