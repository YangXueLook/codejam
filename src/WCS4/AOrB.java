package WCS4;

import java.math.BigInteger;
import java.util.Scanner;

public class AOrB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		for(int i = 0; i < n; i++)
		{
			int k = Integer.parseInt(in.nextLine());
			String a = in.nextLine();
			String b = in.nextLine();
			String c = in.nextLine();
			System.out.println(helper(a, b, c, k));
		}

	}

	private static String helper(String a, String b, String c, int k) {
		String binaryA = new BigInteger(a, 16).toString(2);
		String binaryB = new BigInteger(b, 16).toString(2);
		String binaryC = new BigInteger(c, 16).toString(2);
		
		int len = Math.max(binaryA.length(), Math.max(binaryB.length(), binaryC.length()));
		
		StringBuffer sbA = new StringBuffer();
		for(int i = 0; i < len - binaryA.length(); i++)
		{
			sbA.append('0');
		}
		sbA.append(binaryA);
		
		StringBuffer sbB = new StringBuffer();
		for(int i = 0; i < len - binaryB.length(); i++)
		{
			sbB.append('0');
		}
		sbB.append(binaryB);
		
		StringBuffer sbC = new StringBuffer();
		for(int i = 0; i < len - binaryC.length(); i++)
		{
			sbC.append('0');
		}
		sbC.append(binaryC);
		
		
		for(int i = 0; i < sbC.length(); i++)
		{
			if(sbC.charAt(i) == '0')
			{
				if(sbA.charAt(i) == '1')
				{
					sbA.setCharAt(i, '0');
					k--;
				}
				if(sbB.charAt(i) == '1')
				{
					sbB.setCharAt(i, '0');
					k--;
				}
			}
			else
			{
				if(sbA.charAt(i) == '0' && sbB.charAt(i) == '0')
				{
					sbB.setCharAt(i, '1');
					k--;
				}
			}
			
			if(k < 0)
			{
				return "-1";
			}
			
		}
		
		for(int i = 0; i < sbC.length(); i++)
		{
			if(k <= 0)
				break;
			else
			{
				if(sbC.charAt(i) == '1' && sbA.charAt(i) == '1' && sbB.charAt(i) == '1')
				{
					sbA.setCharAt(i, '0');
					k--;
				}
				else if(sbC.charAt(i) == '1' && sbA.charAt(i) == '1' && sbB.charAt(i) == '0' && k >= 2)
				{
					sbA.setCharAt(i, '0');
					sbB.setCharAt(i, '1');
					k = k - 2;
				}
			}
		}
		
		StringBuffer result = new StringBuffer();
		result.append(new BigInteger(sbA.toString(), 2).toString(16).toUpperCase());
		result.append("\n");
		result.append(new BigInteger(sbB.toString(), 2).toString(16).toUpperCase());
		
		return result.toString();
	}

	

}
