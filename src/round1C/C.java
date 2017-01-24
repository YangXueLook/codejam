package round1C;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loopTimes = Integer.parseInt(scan.nextLine());

		String[] result = new String[loopTimes];
		
		
		
		for (int i = 0; i < loopTimes; i++)
		{
			int n = scan.nextInt();
			
			
			
			result[i] = String.valueOf(helper(n));
		}
		
		for (int i = 0; i < loopTimes; i++)
		{
			System.out.println("Case #" + (i+1) + ": "+ result[i]);
		}

	}

}
