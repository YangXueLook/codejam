package googleChallenge;

public class FindMaxEqualNumber {
	
	public static int answer(int[] x) { 
		if(x == null || x.length == 1)
			return 1;
		
		int sum = 0;
		for(int i: x)
			sum = sum + i;
		
		if(sum % x.length == 0)
			return x.length;
		else
			return x.length - 1;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
