package walmart;

import java.util.Scanner;

public class MinMaxDigit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int min = Integer.parseInt(in.nextLine());
		int max = Integer.parseInt(in.nextLine());
		int score = 0;
		for(int i = min; i <= max; i++)
		{
			score = score + helper(i);
		}
		System.out.println(score);
	}

	private static int helper(int num) {
		int result = 0;
		String s = String.valueOf(num);
		for(int i = 1; i < s.length() - 1; i++)
		{
			if(s.charAt(i - 1) < s.charAt(i) && s.charAt(i + 1) < s.charAt(i))
				result++;
			else if(s.charAt(i - 1) > s.charAt(i) && s.charAt(i + 1) > s.charAt(i))
				result++;
		}

		
		return result;
	}

}
