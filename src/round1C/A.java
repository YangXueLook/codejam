package round1C;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loopTimes = Integer.parseInt(scan.nextLine());

		String[] result = new String[loopTimes];
		
		
		
		for (int i = 0; i < loopTimes; i++)
		{
			int r = scan.nextInt();
			int c = scan.nextInt();
			int w = scan.nextInt();
			
			
			
			result[i] = String.valueOf(helper(r, c, w));
		}
		
		for (int i = 0; i < loopTimes; i++)
		{
			System.out.println("Case #" + (i+1) + ": "+ result[i]);
		}

	}

	private static int helper(int r, int c, int w) {
		// TODO Auto-generated method stub
//		int result = 0;
		int cut = c%w == 0 ?c/w:c/w+1;
		
//		int cut = (int) Math.ceil(c/w);
//		System.out.println(cut);
		
		return cut + w - 1 + (r - 1) * (c/w);
	}

}
