
import java.util.Scanner;
public class SciCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double value = 0.0; // Calculator Value
        int calcSelect = 0; // Menu Selection
        double num1; // Operand 1
        double num2; // Operand 2
        int calcMenu = 0; // Guides access to menus. 0 = full menu, 1 = selection/secondary menu
        int numCalc = 0; // Number of Calculations
        double sumCalc = 0; // Sum of all values
        int addSum = 0; // Prevents values from being added if invalid menu selection


        // Start of Program

       System.out.println ("Current Result: " + value);
       System.out.println (" ");

        while (calcMenu == 0) { // Calculator Menu Display


            System.out.println ("Calculator Menu");
            System.out.println ("---------------");
            System.out.println ("0. Exit Program");
            System.out.println ("1. Addition");
            System.out.println ("2. Subtraction");
            System.out.println ("3. Multiplication");
            System.out.println ("4. Division");
            System.out.println ("5. Exponentiation");
            System.out.println ("6. Logarithm");
            System.out.println ("7. Display Average");
            System.out.println (" ");
            calcMenu = 1;


                while (calcMenu == 1) { // Secondary Menu

                    System.out.print ("Enter Menu Selection: ");
                    calcSelect = input.nextInt();
                    calcMenu = 0;

                    if (calcSelect == 1) { // Option 1

                        System.out.print ("Enter first operand: ");
                        num1 = input.nextDouble();
                        System.out.print ("Enter second operand: ");
                        num2 = input.nextDouble();
                        value = num1 + num2;
                        System.out.println (" ");
                        System.out.println ("Current Result: " + value);
                        System.out.println (" ");
                        calcMenu = 0;
                        numCalc = numCalc + 1;
                        sumCalc = sumCalc + value;

                    }
                    if (calcSelect == 2) { // Option 2

                        System.out.print ("Enter first operand: ");
                        num1 = input.nextDouble();
                        System.out.print ("Enter second operand: ");
                        num2 = input.nextDouble();
                        value = num1 - num2;
                        System.out.println (" ");
                        System.out.println ("Current Result: " + value);
                        System.out.println (" ");
                        calcMenu = 0;
                        numCalc = numCalc + 1;
                        sumCalc = sumCalc + value;

                    }
                    if (calcSelect == 3) { // Option 3

                        System.out.print ("Enter first operand: ");
                        num1 = input.nextDouble();
                        System.out.print ("Enter second operand: ");
                        num2 = input.nextDouble();
                        value = num1 * num2;
                        System.out.println (" ");
                        System.out.println ("Current Result: " + value);
                        System.out.println (" ");
                        calcMenu = 0;
                        numCalc = numCalc + 1;
                        sumCalc = sumCalc + value;

                    }
                    if (calcSelect == 4) { // Option 4

                        System.out.print ("Enter first operand: ");
                        num1 = input.nextDouble();
                        System.out.print ("Enter second operand: ");
                        num2 = input.nextDouble();
                        value = num1 / num2;
                        System.out.println (" ");
                        System.out.println ("Current Result: " + value);
                        System.out.println (" ");
                        calcMenu = 0;
                        numCalc = numCalc + 1;
                        sumCalc = sumCalc + value;

                    }
                    if (calcSelect == 5) { // Option 5

                        System.out.print ("Enter first operand: ");
                        num1 = input.nextDouble();
                        System.out.print ("Enter second operand: ");
                        num2 = input.nextDouble();
                        value = Math.pow(num1, num2);
                        System.out.println (" ");
                        System.out.println ("Current Result: " + value);
                        System.out.println (" ");
                        calcMenu = 0;
                        numCalc = numCalc + 1;
                        sumCalc = sumCalc + value;

                    }
                    if (calcSelect == 6) { // // Option 6

                        System.out.print ("Enter first operand: ");
                        num1 = input.nextDouble();
                        System.out.print ("Enter second operand: ");
                        num2 = input.nextDouble();
                        value = Math.log(num2) / Math.log(num1);
                        System.out.println (" ");
                        System.out.println ("Current Result: " + value);
                        System.out.println (" ");
                        calcMenu = 0;
                        numCalc = numCalc + 1;
                        sumCalc = sumCalc + value;

                    }
                    if (calcSelect == 7) { // // Option 7

                        if (numCalc == 0) { // If 7 is pressed at the start

                            System.out.println (" ");
                            System.out.println ("Error: No calculations yet to average!");
                            System.out.println (" ");
                            calcMenu = 1;
                            addSum = 1;

                        } else { // If 7 is pressed afterwards

                            System.out.println (" ");
                            System.out.println ("Sum of calculations: " + sumCalc);
                            System.out.println ("Number of calculations: " + numCalc);
                            System.out.print ("Average of calculations: ");
                            System.out.printf ("%.2f", (sumCalc / numCalc));
                            System.out.println (" ");
                            calcMenu = 1;

                        }

                    }
                    if (calcSelect == 0) { // Option 0

                        System.out.println (" ");
                        System.out.println ("Thanks for using this calculator. Goodbye!");
                        calcMenu = 2;

                    }
                    if (calcSelect < 0 || calcSelect > 7) { // If invalid integer is chosen in the menu

                        System.out.println ("Error: Invalid selection!");
                        System.out.println (" ");
                        calcMenu = 1;
                    }
                }

    }
}
}