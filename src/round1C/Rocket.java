package round1C;

import java.util.Scanner;

public class Rocket {
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = Integer.parseInt(scan.nextLine());
		
		System.out.println("  /\\");
		
		for(int i = 0; i < length; i++)
			System.out.println("  ||");
		
		System.out.println(" /||\\");
		System.out.println("/:||:\\");
		
		for(int i = 1; i < length; i++)
			System.out.println("|:||:|");
		
		System.out.println("|/||\\|");
		
		System.out.println("  **");
		System.out.println("  **");
	}

}
