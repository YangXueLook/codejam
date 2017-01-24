package googleChallenge;

public class MadScienceQuarterly {
	
	
	
	public static int answer(int[] L, int k) { 
		int sum = 0;
		int currentSum = 0;
		for(int i = 0; i < L.length; i++)
		{
			if(currentSum < 0)
				currentSum = L[i];
			else
				currentSum = currentSum + L[i];
			
			sum = Math.max(sum, currentSum);
		}


		return sum;

    }
	
	public static int answer2(int[] L, int k) { 
		int sum = 0;
		
		for(int i = 0; i < L.length; i++)
		{
			int currentSum = 0;
			for(int j = i; j < L.length && (j - i + 1) <= k; j++)
			{
				currentSum = currentSum + L[j];
				sum = Math.max(sum, currentSum);
			}
				
		}



		return sum;

    }

	public static void main(String[] args) {
		System.out.println(answer2(new int[]{40, 91, -68, -36, 24, -67, -32, -23, -33, -527}, 7));

	}

}
