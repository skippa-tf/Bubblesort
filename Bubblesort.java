/*
github.jasoncodes.ca
This program bubble sorts an array which is given by input.
*/

import java.util.Scanner;

public class BubbleSort {
	/**
	* Main method to execute the Bubble Sort program.
	* @param args Command-line arguments (not used).
	*/
	public static void main(String[] args) {
		// Scanner object for input.
		Scanner input = new Scanner(System.in);

		// Get the array size and element types.
		int arraySize = arraySize(input);
		char elementType = elementType(input);
			
		// Create the arrays based on the elementType and sort them.
		if (elementType == 'i'){
			int[] array = getArray(arraySize, input);
			sort(array, arraySize);
		}
		else if (elementType == 'd'){
			double[] array = getArray(arraySize, input, true);
			sort(array, arraySize);
		}
		
		
	}
	
	/**
	* Prompts the user to enter integers and returns an array of those integers.
	* @param arraySize The size of the array to be created.
	* @param input The Scanner object for reading user input.
	* @return An array of integers.
	*/
	public static int[] getArray(int arraySize, Scanner input) {
		int[] array = new int[arraySize];
		for (int i = 0; i < arraySize; i++){
			System.out.println("Enter a number: ");
			array[i] = input.nextInt();
		}
		return array;
	}
	
	/**
	* Prompts the user to enter doubles and returns an array of those doubles.
	* @param arraySize The size of the array to be created.
	* @param input The Scanner object for reading user input.
	* @param isDouble A flag to indicate the array should be of type double.
	* @return An array of doubles.
	*/
	public static double[] getArray(int arraySize, Scanner input, boolean isDouble) {
		double[] array = new double[arraySize];
		for (int i = 0; i < arraySize; i++){
			System.out.println("Enter a number: ");
			array[i] = input.nextDouble();
		}	
		return array;
	}
	
	/**
	* Sorts an array of integers using the Bubble Sort algorithm.
	* @param array The array to be sorted.
	* @param arraySize The size of the array.
	*/
	public static void sort(int[] array, int arraySize) {
		boolean didSwap = false;
		do {
			didSwap = false;
			for (int i = 0; i < arraySize - 1; i++) {
				int valueAtIndexI = array[i];
				// Swap the values if the value of the current index is greater than the next value.
				if (array[i] > array[i + 1]) {
					array[i] = array[i + 1];
					array[i + 1] = valueAtIndexI;
					didSwap = true; // If we did a swap we want to do another sweep.
					printArray(array);
				}

			}
		} while (didSwap);
		
		// Print the array if no swaps were made.
		if (!didSwap) {
			printArray(array);
		}
	}
	
	/**
	* Sorts an array of doubles using the Bubble Sort algorithm.
	* @param array The array to be sorted.
	* @param arraySize The size of the array.
	*/
	public static void sort(double[] array, int arraySize) {
		boolean didSwap = false;
		do {
			didSwap = false;
			for (int i = 0; i < arraySize - 1; i++) {
				double valueAtIndexI = array[i];
				// Swap the values if the value of the current index is greater than the next value.
				if (array[i] > array[i + 1]) {
					array[i] = array[i + 1];
					array[i + 1] = valueAtIndexI;
					didSwap = true; // If we did a swap we want to do another sweep.
					printArray(array);
				}

			}
		} while (didSwap);
		
		// Print the array if no swaps were made.
		if (!didSwap) {
			printArray(array);
		}
	}
	
	/**
	* Prints the elements of an integer array to the console.
	* @param array The integer array to be printed.
	*/
	public static void printArray(int[] array) {
		// This method prints a given array
		int arraySize = array.length;
		for (int n = 0; n < arraySize; n++) {
			System.out.print(array[n]);
			if (n < arraySize - 1) { // Print a comma for the first arraySize - 1 characters
				System.out.print(", ");
			}
		}
		System.out.println("");		
	}


	/**
	* Prints the elements of a double array to the console.
	* @param array The double array to be printed.
	*/	
	public static void printArray(double[] array) {
		// This method prints a given array
		int arraySize = array.length;
		for (int n = 0; n < arraySize; n++) {
			System.out.print(array[n]);
			if (n < arraySize - 1) { // Print a comma for the first arraySize - 1 characters
				System.out.print(", ");
			}
		}
		System.out.println("");		
	}

	/**
	* Prompts the user to specify the type of elements for sorting.
	* Accepts either 'i' for integers or 'd' for doubles.
	*
	* @param input The Scanner object for reading user input.
	* @return The character representing the type of elements ('i' or 'd').
	*/
	public static char elementType(Scanner input) {
		boolean incorrectInput = true;
		char elementType = 0;
		System.out.println("Enter 'i' for ints or 'd' for doubles: ");
		while (incorrectInput){
			// Get the input and check if it is valid.
			elementType = input.next().charAt(0);
			if (elementType == 'i' || elementType == 'd') {
				incorrectInput = false;
				break;
			}
			System.out.println("Enter only 'i' or 'd'! ");
		}
		return elementType;
	}

	/**
	* Prompts the user to specify the size of the array to be sorted.
	* Validates that the input is an integer.
	*
	* @param input The Scanner object for reading user input.
	* @return The size of the array to be sorted.
	*/
	public static int arraySize(Scanner input) {
		boolean incorrectInput = true;
		int arraySize = 0;
		System.out.println("How many numbers will you need sorted? ");
		while (incorrectInput){
			// Get the input and check if it is valid.
			try {
				arraySize = input.nextInt();
				incorrectInput = false;
			} catch (Exception e) {
				System.out.println("Enter only integers!");
				input.next();
			}
		}
		return arraySize;
	}
	
	
}