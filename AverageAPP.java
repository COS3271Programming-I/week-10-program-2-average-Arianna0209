package week10;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageAPP {
	static Scanner userinput = new Scanner(System.in);
	
	// This program allows the user to enter a list of integers and it will calculate their average.
	
	// The method to calculate the average from a list:
	static double averageCalculator(List<Integer> numbers) {
		double total = 0;
		for (int count = 0; count < numbers.size(); count++) {
			total += numbers.get(count);}
		double average = total/numbers.size();
		return average;
	}
	
	static int intTry(String message) {
		int response;
		while (true) {
			try {
				System.out.print(message);
				response = userinput.nextInt();
				userinput.nextLine();
				return response;
			} 
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid integer number (no decimal point).");
				userinput.nextLine();
				continue;
			}
		}
	}
	
	static int intTry1To30(String message) {
		int validNumber;
		while (true) {
			validNumber = intTry(message);
			if (validNumber >= 1 && validNumber <= 30) {
				return validNumber;
			}
			else {
				System.out.println("Please enter a number between 1 and 30.");
				continue;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// Tell the user what the program does:
		System.out.println("This program calculates the average of a set of integers you input.");
		
		// Ask the user how many numbers they would like to input:
		int lengthOfList = intTry1To30("\nHow many numbers would you like to input? Choose a number from 1 to 30: ");
		
		// Create a list:
		List<Integer> numberList = new ArrayList<>();
		
		// Fill the list:
		for (int count = 0; count < lengthOfList; count++) {
			int item = intTry(String.format("Enter number %d: ", (count+1)));
			numberList.add(item);
		}
		
		// Calculate the average:
		double averageOfNums = averageCalculator(numberList);
		
		// Print the average:
		System.out.format("\nThe average of the numbers you provided is %.2f.", averageOfNums);
		
		// Tell the user the program has ended:
		System.out.println("\n\nProgram Ended.");
	}

}
