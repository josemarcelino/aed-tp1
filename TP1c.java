import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math.*;

public class TP1c {
	
	private static BufferedReader br;
	private static int trainAvailable[];
	
	public static void main(String[] args){
		
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp;
		int i = 0;
		while((temp = receiveWords()) != null){
			for(String t : temp){
				if(i == 0){
					trainAvailable = new int [Integer.parseInt(t)];
				}
				else{
					trainAvailable[i-1] = Integer.parseInt(t);
				}
				i++;
			}
		}

		System.out.println(findAmountMoney());
	}
	
	
	private static int findAmountMoney(){

	int matrix[][] = new int[trainAvailable.length][trainAvailable.length];
	int line = 0;
	int column = 0;
	
	int A;
	int B;
	int C;
	for(int diag = trainAvailable.length; diag != 0; diag--){
		line = 0;
		column = trainAvailable.length - diag;
		for(int i = diag-1; i >= 0; i--){
			//System.out.println(line + " : " + column);

			if( line + 2 >= trainAvailable.length)
				A = 0;
			else
				 A = matrix[line+2][column];

			if( line +1 >= trainAvailable.length || column-1 < 0)
				B = 0;
			else
				B = matrix[line+1][column-1];

			if( column - 2 < 0)
				C = 0;
			else
				C = matrix[line][column-2];

			matrix[line][column] = Math.max(trainAvailable[line] + Math.min(A, B), trainAvailable[column] + Math.min(B, C));
			line++;
			column++;

		}
		


	}
/*
		for(int q = 0; q < trainAvailable.length; q ++){
	 	for(int u = 0; u < trainAvailable.length; u++){
	 		System.out.print(matrix[q][u]);	
		}
	System.out.println("");
	}
*/

	return matrix[0][trainAvailable.length - 1];
}

	public static String[] receiveWords(){
		try {
			String s = br.readLine();
			if(!s.equals("")) return s.split(" ");
			else return null;
		} catch (Exception e) {}
		return null;
	}

}
