package walmart;

import java.util.Scanner;

public class HikingSelfies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int x = Integer.parseInt(in.nextLine());
		System.out.println((int)Math.abs((Math.pow(2, n)) - 1 - x));

	}

}
