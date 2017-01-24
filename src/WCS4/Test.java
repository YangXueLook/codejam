package WCS4;

import java.math.BigInteger;

public class Test {

	public static void main(String[] args) {
		char[] arrayA = new char[]{'0' , 'F', '0', 'A'};
		
		// TODO Auto-generated method stub
		StringBuffer sbA = new StringBuffer();
		sbA.append(arrayA);
		BigInteger ba = new BigInteger(sbA.toString(), 16);
		String binaryA = ba.toString(2);
		System.out.print(binaryA);
	}

}
