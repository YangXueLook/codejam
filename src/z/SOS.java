package z;

import java.util.Scanner;

public class SOS {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        
        System.out.println(helper(S));
    }

	private static int helper(String s) {
		// TODO Auto-generated method stub
		int result = 0;
		
		for(int i = 0; i < s.length(); i = i + 3)
		{
			if(s.charAt(i) != 'S')
				result++;
			if(s.charAt(i + 1) != 'O')
				result++;
			if(s.charAt(i + 2) != 'S')
				result++;
		}
		
		return result;
	}

}
