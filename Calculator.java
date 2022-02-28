//By Lorne Huxtable
import java.util.Scanner;
public class Calculator {

    public static void main (String[] args) {
	Scanner input = new Scanner (System.in);

	// Identifiers

	double num1;
	double num2;
	int calcSelect;
	double add;
	double subtract;
	double multiplication;
	double division;

	// Enter Operands

	System.out.println ("Enter first operand:");
	num1 = input.nextDouble ();
	System.out.println ("Enter second operand:");
	num2 = input.nextDouble ();

	// Calculator Menu Display

	System.out.println ("Calculator Menu");
	System.out.println ("---------------");
	System.out.println ("1. Addition");
	System.out.println ("2. Subtraction");
	System.out.println ("3. Multiplication");
	System.out.println ("4. Division");

	System.out.println ("Which operation do you want to perform?");
	calcSelect = input.nextInt();

	// If Else Statements to choose Int from menu

	if (calcSelect == 1) {
		add = num1 + num2;
		System.out.println ("The result of the operation is " + add + ". Goodbye!");
	}
	else if (calcSelect == 2) {
		subtract = num1 - num2;
		System.out.println ("The result of the operation is " + subtract + ". Goodbye!");
	}
	else if (calcSelect == 3) {
		multiplication = num1 * num2;
		System.out.println ("The result of the operation is " + multiplication + ". Goodbye!");
	}
	else if (calcSelect == 4) {
		division = num1 / num2;
		System.out.println ("The result of the operation is " + division + ". Goodbye!");
	}
	else {
		System.out.println ("Error: Invalid selection! Terminating program.");
		}
	// End of Code
    }
}
