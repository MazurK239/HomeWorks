package game;

import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, thik of a number between 0 and 100.");
		System.out.println("I am sure that I can guess it with less than 8 attempts:)");
		System.out.println("Ready? (y/n)");
		if (scanner.nextLine().equals("y")) {
			int left = 0;
			int right = 100;
			int middle;
			String answer;
			while (true) {
				middle = (int)Math.ceil((right + left) / 2.0);
				System.out.println("Is your nubmer less than " + middle + "? (y/n)");
				answer = scanner.nextLine();
				if (answer.equals("y")) {
					right = middle-1;
				} else if (answer.equals("n")) {
					left = middle;
				}
				System.out.print(left + ", ");
				System.out.println(right);
				if (right == left) {
					System.out.println("Your number is " + left);
					break;
				}
			}
					
		}
		
	}
	
}
