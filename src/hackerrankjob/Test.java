package hackerrankjob;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static final char ZERO = '0';
	public static final char ONE = '1';

	static int count(String s) {
		int res = 0;
		Queue<Integer> pivotIndexesQ = new LinkedList<Integer>();
		int length = s.length();

		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1))
				pivotIndexesQ.add(i);
		}
		if (pivotIndexesQ.size() == 0)
			return 0;

		res += pivotIndexesQ.size();
		int currentIndex = pivotIndexesQ.poll();

		while (true) {
			char firstHalf = s.charAt(currentIndex);
			char secondHalf = s.charAt(currentIndex + 1);
			int i = currentIndex - 1;
			int j = currentIndex + 2;
			while (i >= 0 && s.charAt(i) == firstHalf && j < length
					&& s.charAt(j) == secondHalf) {
				res++;
				i--;
				j++;
			}
			if (pivotIndexesQ.isEmpty())
				break;
			else
				currentIndex = pivotIndexesQ.poll();
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sddf");
	}

}
