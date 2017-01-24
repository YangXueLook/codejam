package googleChallenge;

public class MinionGame {
	
//	def solve(N, T):
//	    M, M2 = [0]*N, [0]*N
//
//	    M[0] = 1
//	    for i in xrange(T):
//	        M, M2 = M2, M
//	        for j in xrange(N):
//	            M[j] = (j>0 and M2[j-1]) + M2[j] + (j+1<N-1 and M2[j+1])
//
//	    return M[N-1]

	
	public static int answer(int t, int n) { 
		
		int[] TStepResult = new int[n];
		int[] TMinusOneStepResult;
		
		TStepResult[0] = 1;
		
		//DP a(t, n) = a(t - 1, n)(for stay) + a(t - 1, n - 1)(for right) + a(t - 1, n + 1)(for left)
		
		for(int i = 0; i < t; i++)
		{
			TMinusOneStepResult = TStepResult;
			TStepResult = new int[n];
			for(int j = 0; j < n; j++)
			{
				TStepResult[j] = (TStepResult[j] + TMinusOneStepResult[j])%123454321;
				if(j > 0)
					TStepResult[j] = (TStepResult[j] + TMinusOneStepResult[j - 1])%123454321;
				if(j < n - 2)
				TStepResult[j] = (TStepResult[j] + TMinusOneStepResult[j + 1])%123454321;
			}
		
			
		}


		return TStepResult[n - 1];

    } 
	
	//
//	print solve(3, 2) #1
//	print solve(2, 1) #1
//	print solve(2, 3) #3
//	print solve(5, 20) #19535230

	public static void main(String[] args) {
		System.out.println(answer(20,5));
		

	}

}
