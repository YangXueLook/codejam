package z;

import java.util.Scanner;

public class Candy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        System.out.println(helper(N));

	}

	private static int helper(int n) {
		// TODO Auto-generated method stub
		int[][] array = new int[n][7];
		int[] value = new int[]{1,2,5,10,20,50,100};
		
		return 0;
	}

}
