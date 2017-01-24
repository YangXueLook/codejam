package HRContest;

public class MinXor {
	
	static int minXor(int[] a) {
		
		
		
		int[] resultArray = new int[a.length];
		for(int i = 0; i < resultArray.length; i++)
		{
			resultArray[i] = Integer.MAX_VALUE;
		}
		resultArray[0] = 0;
		
		
		
		for(int i = 0; i < a.length; i++)
		{
			for(int j = i + 1; j < a.length; j++)
			{
				
//				System.out.println(i+"\t"+j+"----------"+resultArray[j]+"\t"+resultArray[i]+"\t"+a[i]+"\t"+a[j]);
//				System.out.println((resultArray[i] + a[i]^a[j])+"*************");
				
				resultArray[j] = Math.min(resultArray[j], resultArray[i] + (a[i]^a[j]));
			}
//			System.out.println(i+"+++++++++++++");
//			for(int ii: resultArray)
//			{
//				System.out.print(ii+ "\t");
//				
//			}
//			System.out.println();
		}

		
		return resultArray[resultArray.length - 1];
    }

	public static void main(String[] args) {
		int[] a = new int[]{2,0,3,5};
		System.out.println(minXor(a));

	}

}
