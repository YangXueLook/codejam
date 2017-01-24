package HRContest;

public class PermutationEncryption {
	
	static String encode(int[] p, int k, String s) {
		String org = s;
		int loopLength = 1;
		
		while(true)
		{
			s = oneTimePermutation(p, s);
			if(!s.equals(org))
			{
				loopLength++;
			}
			else
			{
				break;
			}
		}
		
		int realLoopTime = k%loopLength;
		
		for(int i = 0; i < realLoopTime; i++)
			s = oneTimePermutation(p, s); 
		

		return s;
    }
	
	static String oneTimePermutation(int[] p,String s)
	{
		StringBuffer result = new StringBuffer("");
		for(int i: p)
		{
			result.append(s.charAt(i - 1));
		}
		
		return result.toString();
	}

	public static void main(String[] args) {
		int[] p = new int[]{4,3,2,1};
		String s = "dcba";
		
		System.out.println(oneTimePermutation(p, s));

	}

}
