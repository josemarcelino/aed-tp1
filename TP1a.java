import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TP1a {
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
	
	private static int findAmountMoney() {
		
		int thiefNumber1 = 0;
		int beginning = 0;
		int end = trainAvailable.length;
		for(int i = 0; i < trainAvailable.length; i++){
			if(trainAvailable[beginning] >= trainAvailable[end-1]){
				if(i%2 == 0)
					thiefNumber1 += trainAvailable[beginning];
				beginning++;
			}
			else{
				if(i%2 == 0)
					thiefNumber1 += trainAvailable[end-1];
				end--;
			}
		}
		
		return thiefNumber1;
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
