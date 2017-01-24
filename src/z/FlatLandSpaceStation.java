package z;

import java.util.Arrays;
import java.util.Scanner;

public class FlatLandSpaceStation {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        
        System.out.println(helper(c, n));
    }

	private static int helper(int[] c, int n) {
		Arrays.sort(c);
		int maxDistance = Math.max(c[0] - 0, n - 1 - c[c.length - 1]);
		int intervalDistance = 0;
		
	
		
		for(int i = 0; i < c.length - 1; i++)
			intervalDistance = Math.max(intervalDistance, c[i + 1] - c[i]);
		
		
		maxDistance = Math.max(maxDistance, intervalDistance/2);
		
		return maxDistance;
	}

}
