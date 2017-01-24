package yogeshtest;

import java.util.Arrays;

public class Q3 {
	
	//O(a.length())
//	description is weird:
//	"It should work regardless of the order two strings are passed in,"-- I believe it is not true. 
//	since "shift the characters to left by 1 in 'aaad', you get 'zzzc', and 'zzzc' and 'zzcz' are anagrams."
//	but if I shift shift the characters to left by 1 in 'zzcz', I will get 'wwbw', not 'aada'.
//	I will follow your first example. If you really want "regardless of the order two strings", 
//	just call isAnagram(a, b, x) || isAnagram(b, a, x);
	
	static boolean isAnagram(String a, String b, int x) {
		if(a == null || b == null || a.length() != b.length())
			return false;
		
		x = x%26;
		if(x < 0)
		{
			x = x + 26;
		}
		
		int[] countArray = new int[26];
		Arrays.fill(countArray, 0);
		
		for(int i = 0; i < a.length(); i++)
		{
			int index = (a.charAt(i) - 'a' + x)%26;
			countArray[index]++;
		}
		for(int i = 0; i < b.length(); i++)
		{
			countArray[b.charAt(i) - 'a']--;
		}
		
		for(int i: countArray)
		{
			if(i != 0)
				return false;
		}

		return true;
	}
	
	//test
	public static void main(String[] args) {
		
//		System.out.println(isAnagram("aaad", "zzcz", -1));
		
		
		for(int i = 0; i < 100000; i++)
		{
			int x = (int) ((Math.random() - 0.5) * 10000);
			int length = (int) ((Math.random()) * 10) + 1;
			
			char[] arrayA = new char[length];
			char[] arrayB = new char[length];
			
			for(int j = 0; j < length; j++)
			{
				arrayA[j] = (char) ('a' + (int) ((Math.random()) * 26));
				arrayB[j] = (char) ('a' + (int) ((Math.random()) * 26));
			}
			
			String a = String.valueOf(arrayA);
			String b = String.valueOf(arrayB);
			if(isAnagram(a, b, x))
			{
				System.out.println(a + "\t" + b + "\t" + x);
			}
			
		}
		
		
		

	}

}
