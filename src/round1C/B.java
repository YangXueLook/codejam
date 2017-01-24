package round1C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
//		System.out.println(matched("ABABA","ABAB"));
		
		
//		ArrayList<Character> charList = new ArrayList<Character>();
//		charList.add('A');
//		charList.add('B');
//		ArrayList<String> stringList = getAllPossibleStrings(charList, 2);
//		System.out.println(" stringList.size()  "+ stringList.size());
//		for(int i = 0; i < stringList.size(); i++)
//			System.out.println(stringList.get(i));
		
		
		
		Scanner scan = new Scanner(System.in);
		int loopTimes = Integer.parseInt(scan.nextLine());

		String[] result = new String[loopTimes];

		for (int i = 0; i < loopTimes; i++) {
			int k = scan.nextInt();
			int l = scan.nextInt();
			int s = scan.nextInt();
			scan.nextLine();
			String keyboard = scan.nextLine();
			String target = scan.nextLine();

			result[i] = String.valueOf(helper(k, l, s, keyboard, target));
		}

		for (int i = 0; i < loopTimes; i++) {
			System.out.println("Case #" + (i + 1) + ": " + result[i]);
		}

	}

	private static double helper(int k, int l, int s, String keyboard,
			String target) {
		HashMap<Character, Integer> keyboardMap = new HashMap<Character, Integer>();
		ArrayList<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < k; i++) {
			if (keyboardMap.containsKey(keyboard.charAt(i))) {
				keyboardMap.put(keyboard.charAt(i),
						keyboardMap.get(keyboard.charAt(i)) + 1);
			} else {
				keyboardMap.put(keyboard.charAt(i), 1);
				charList.add(keyboard.charAt(i));
			}
		}
		for (int i = 0; i < target.length(); i++) {
			if (!(keyboardMap.containsKey(target.charAt(i))))
				return 0;
		}

		int minPossibleOffset = 1;
//		System.out.println("------");
		while (!target.substring(minPossibleOffset).equals(
				target.substring(0, target.length() - minPossibleOffset))
				&& minPossibleOffset < target.length()) {
			minPossibleOffset++;
		}
//		System.out.println(minPossibleOffset);
		// HashMap<Character, Double> keyboardMap = new HashMap<Character,
		// Double>();
		
		double maxPossible = 0;
		for(int i = 0; i + target.length() - 1 < s; i = i + minPossibleOffset)
		{
			maxPossible++;
		}
//		System.out.println(maxPossible);
		
		
		
		
//		double oneSectionExpect = 1;
//		for(int i = 0; i < target.length(); i++)
//		{
//			oneSectionExpect = oneSectionExpect * (double)keyboardMap.get(target.charAt(i))/(double)keyboard.length();
//		}
//		System.out.println(oneSectionExpect);
		
		
		double expected = 0;
		ArrayList<String> allStringList = getAllPossibleStrings(charList, s);
		for(int i = 0; i < allStringList.size(); i++)
		{
			String str = allStringList.get(i);
			int match = matched(str,target);
			if(match != 0)
			{
				double fact = 1;
				for(int j = 0; j < str.length(); j++)
				{
					fact = fact * (double)keyboardMap.get(str.charAt(j))/(double)keyboard.length();
				}
				expected = expected + (double)match*fact;
			}
		}

		
		
		return maxPossible - expected;
	}
	
	private static int matched(String s, String p)
	{
		int result = 0;
		for(int i = 0; i <= s.length() - p.length(); i++)
		{
			if(s.substring(i, i + p.length()).equals(p))
				result++;
				
		}
		return result;
	}
	
	private static ArrayList<String> getAllPossibleStrings(ArrayList<Character> charArray, int l)
	{
		ArrayList<String> result = new ArrayList<String>();
		if(l == 1)
		{
			for(int i = 0; i < charArray.size(); i++ )
				result.add(String.valueOf(charArray.get(i)));
			return result;
		}
		else
		{
//			char c = charArray.get(0);
//			charArray.remove(0);
			ArrayList<String> temp = getAllPossibleStrings(charArray, l - 1);
			for(int i = 0; i < temp.size(); i++)
			{
				String s = temp.get(i);
				for(int k = 0; k < charArray.size(); k++ )
				{
					StringBuffer sb = new StringBuffer(s);
					sb.append(charArray.get(k));
					result.add(sb.toString());
				}
				
			}
			return result;
		}
			 
	}

}
