package HRContest;

import java.util.ArrayList;

public class CircleTest {
	static private final int POINT_NUM = 9;
	static private int[][] e = { { 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 1, 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0 } };
	static ArrayList<Integer> trace = new ArrayList<Integer>();
	static boolean hasCycle = false;

	public static void main(String[] args) {
		findCycle(0);
		if (!hasCycle)
			System.out.println("No Cycle.");
	}

	static void findCycle(int v) {
		int j = trace.indexOf(v);
		if ((j) != -1) {
			hasCycle = true;
			System.out.print("Cycle:");
			while (j < trace.size()) {
				System.out.print(trace.get(j) + " ");
				j++;
			}
			System.out.print("\n");
			return;
		}
		trace.add(v);

		for (int i = 0; i < POINT_NUM; i++) {
			if (e[v][i] == 1)
				findCycle(i);
		}
		trace.remove(trace.size() - 1);
	}
}
