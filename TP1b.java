import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math.*;

public class TP1b {
	
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

		System.out.println(findAmountMoney(0, trainAvailable.length-1));
	}
	
	
	private static int findAmountMoney(int first, int last){
		if(first == last)
			return trainAvailable[last];
		if (first == last-1)
			return Math.max(trainAvailable[first],trainAvailable[last]);
		else{ 
			int a = trainAvailable[first] + Math.min(findAmountMoney(first + 2,last),findAmountMoney(first+1, last-1));
			int b = trainAvailable[last] + Math.min(findAmountMoney(first+1,last-1),findAmountMoney(first, last-2));
			return Math.max(a,b);
		}
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
