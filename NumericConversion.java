
import java.util.Scanner;
public class NumericConversion {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menu = 0;
        String hex; // hexadecimal value
        String binary; // binary value
        String bhex; // binary to hex value

        while (menu != 4) { // menu will quit at 4

            System.out.println ("Decoding Menu");
            System.out.println ("-------------");
            System.out.println ("1. Decode hexadecimal"); // Hexadecimal is 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F with A-F representing 10-15 with base 16
            System.out.println ("2. Decode binary"); // 0 and 1, with base 2
            System.out.println ("3. Convert binary to hexadecimal"); // conversions in last method
            System.out.println ("4. Quit");
            System.out.println (" ");
            System.out.print ("Please enter an option: ");
            menu = input.nextInt();

            if (menu == 1) { // Option 1

                System.out.print("Please enter the numeric string to convert: ");
                hex = input.next();
                long numvar = hexStringDecode(hex); // Runs method on line 92
                System.out.println("Result: " + numvar);
                System.out.println(" ");

            }
            if (menu == 2) { // Option 2


                System.out.print("Please enter the numeric string to convert: ");
                binary = input.next();
                short numvar2 = binaryStringDecode(binary);
                System.out.println("Result: " + numvar2);
                System.out.println(" ");

            }
            if (menu == 3) { // Option 3

                System.out.print("Please enter the numeric string to convert: ");
                bhex = input.next();
                String numvar3 = binaryToHex(bhex);
                System.out.println("Result: " + numvar3);
                System.out.println(" ");

            }
            if (menu == 4) { // Option 4
                System.out.println ("Goodbye!");
                break;
            }

        }
    }

    public static long hexStringDecode(String hex) { // produces entire line of hexidecimal

        long value = 0;
        int i;
        int lastch;
        char reversech; // int lastch and reversech are only here for the sake of the reverse function/method
        String reverse = "";

        for (i = 1; i <= hex.length(); ++i) { // Reverses string

            lastch = hex.length() - i;
            reversech = hex.charAt(lastch);
            reverse = reverse + reversech;

        }
        hex = reverse;
        for (i = 0; i < hex.length(); ++i) {

            short hexval = hexCharDecode(hex.charAt(i));
            value = value + (hexval * (long) Math.pow(16, i));

        }
        return value;
    }

    public static short hexCharDecode(char digit) { // converts each hexidecimal digit, required method

        if (digit == '0' || digit == '0') {
            return 0;
        }
        if (digit == '1' || digit == '1') {
            return 1;
        }
        if (digit == '2' || digit == '2') {
            return 2;
        }
        if (digit == '3' || digit == '3') {
            return 3;
        }
        if (digit == '4' || digit == '4') {
            return 4;
        }
        if (digit == '5' || digit == '5') {
            return 5;
        }
        if (digit == '6' || digit == '6') {
            return 6;
        }
        if (digit == '7' || digit == '7') {
            return 7;
        }
        if (digit == '8' || digit == '8') {
            return 8;
        }
        if (digit == '9' || digit == '9') {
            return 9;
        }
        if (digit == 'A' || digit == 'a') {
            return 10;
        }
        if (digit == 'B' || digit == 'b') {
            return 11;
        }
        if (digit == 'C' || digit == 'c') {
            return 12;
        }
        if (digit == 'D' || digit == 'd') {
            return 13;
        }
        if (digit == 'E' || digit == 'e') {
            return 14;
        }
        if (digit == 'F' || digit == 'f') {
            return 15;
        }
        if (digit == 'X' || digit == 'x') {
            return 0;
        }

        return (short) digit;
    }

    public static short binaryStringDecode(String binary) { // produces whole binary value, required method

        long value = 0;
        int i;
        int lastch;
        char reversech; // int lastch and reversech are only here for the sake of the reverse function/method
        String reverse = "";

        for (i = 1; i <= binary.length(); ++i) { // Reverses string

            lastch = binary.length() - i;
            reversech = binary.charAt(lastch);
            reverse = reverse + reversech;

        }
        binary = reverse;
        for (i = 0; i < binary.length(); ++i) {

            short binaryval = ignoreChar(binary.charAt(i));
            value = value + (binaryval * (long) Math.pow(2, i));

        }

        return (short) value;

    }

    public static short ignoreChar(char binaryval) { // evaluates binary values individually while ignoring b's


        if (binaryval == '0') {
            return 0;
        }
        if (binaryval == '1') {
            return 1;
        }
        if (binaryval == 'b') {
            return 0;
        }
        return (short) binaryval;
    }


    public static String binaryToHex(String binary) { // converts binary to hex, required method

        String value = "";
        int i;
        int lastch;
        char reversech; // int lastch and reversech are only here for the sake of the reverse function/method
        String reverse = "";

        for (i = 1; i <= binary.length(); ++i) { // Reverses string

            lastch = binary.length() - i;
            reversech = binary.charAt(lastch);
            reverse = reverse + reversech;

        }
        binary = reverse;
        int a = 4;
        int b = 0;
        for (i = 0; i < reverse.length();) {

            String quadlengths = reverse.substring(reverse.length() - a, reverse.length() - b); // gives the interval starting from first 4 and moving over by 4

            for (i = 1; i <= 4; ++i) { // reverse quadlengths to match correct hexadecimal value

                lastch = quadlengths.length() - i;
                reversech = quadlengths.charAt(lastch);
                reverse = reverse + reversech;

            }
            String quadval = readInQuads(reverse); // runs binary to hex method
            value = value + quadval;
            a = a + 4;
            b = b + 4;
            if (a >= binary.length() + 4) { // will end if it extends pass 4 over the binary length
                break;
            }

        }

        return String.valueOf(value);
    }

    public static String readInQuads (String quadval) { // converts binary string to hex string

        if (quadval.equals("0000")) {
            return "0";
        }
        if (quadval.equals("0001")) {
            return "1";
        }
        if (quadval == "0010") {
            return "2";
        }
        if (quadval.equals("0011")) {
            return "3";
        }
        if (quadval.equals("0100")) {
            return "4";
        }
        if (quadval.equals("0101")) {
            return "5";
        }
        if (quadval.equals("0110")) {
            return "6";
        }
        if (quadval.equals("0111")) {
            return "7";
        }
        if (quadval.equals("1000")) {
            return "8";
        }
        if (quadval.equals("1001")) {
            return "9";
        }
        if (quadval.equals("1010")) {
            return "A";
        }
        if (quadval.equals("1011")) {
            return "B";
        }
        if (quadval.equals("1100")) {
            return "C";
        }
        if (quadval.equals("1101")) {
            return "D";
        }
        if (quadval.equals("1110")) {
            return "E";
        }
        if (quadval.equals("1111")) {
            return "F";
        }
        return quadval;
    }
}

// Lab 4 OH with Dominic Della Sera & Leet Schaepe
// Check Lab Slides, write stuff down (loops), review quiz questions for exams