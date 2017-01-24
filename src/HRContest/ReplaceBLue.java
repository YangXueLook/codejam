package HRContest;

import java.util.HashSet;

public class ReplaceBLue {
	
	static String replaceBLUE(String str) {
		String[] array = str.split(" ");
		
		
		
		
		StringBuffer sb = new StringBuffer("");
		
		for(String s: array)
		{
			if(isAna(s))
			{
				sb.append("XXXX");
			}
			else
			{
				sb.append(s);
			}
			
			sb.append(" ");
		}
		
		sb.deleteCharAt(sb.length() - 1);
		
		
		
//
//		for(int i = 0; i < sb.length() - 3;)
//		{
//			if(isAna(sb.substring(i, i + 4)))
//			{
//				sb.replace(i, i + 4, "XXXX");
//				i = i + 4;
//			}
//			else
//				i++;
//		}
		
		return sb.toString();

    }
	
	static boolean isAna(String s)
	{
		if(s.length() !=4)
			return false;
		
		HashSet<Character> set = new HashSet<Character>();
		set.add('B');
		set.add('L');
		set.add('U');
		set.add('E');

		for(int i = 0; i < s.length(); i++)
		{
			if(set.contains(s.charAt(i)))
				set.remove(s.charAt(i));
		}
			
		return set.size() == 0;
	}

	public static void main(String[] args) {
		System.out.println(replaceBLUE("THE PEOPEL OF REDLAND WANTS TO GET RID OF BLUE AND UEBL BUT LEBUS ARE GOOD"));
		System.out.println(replaceBLUE(null));
	}

}
