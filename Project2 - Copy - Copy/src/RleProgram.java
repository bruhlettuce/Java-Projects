//By: Lorne Huxtable
import java.util.Scanner;
public class RleProgram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menuSelect = 2;
        String fileName;

        //1. display welcome

        System.out.println("Welcome to the RLE image encoder!");
        System.out.println(" ");

        //2. display color test with message

        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow); //imageData array
        System.out.println(" ");
        System.out.println(" ");

        byte[] imageData = null;

        //3. display menu - part a can do while loop or if-else chains
        //option 1, 2, and 6
        while (menuSelect != 0) {

            System.out.println("RLE Menu");
            System.out.println("--------");
            System.out.println("0. Exit");
            System.out.println("1. Load File");
            System.out.println("2. Load Test Image");
            System.out.println("3. Read RLE String");
            System.out.println("4. Read RLE Hex String");
            System.out.println("5. Read Data Hex String");
            System.out.println("6. Display Image");
            System.out.println("7. Display RLE String");
            System.out.println("8. Display Hex RLE Data");
            System.out.println("9. Display Hex Flat Data");
            System.out.println(" ");
            System.out.print("Select a Menu Option: ");
            menuSelect = input.nextInt();

            if (menuSelect == 1) { // Menu Option 1

                System.out.print("Enter name of file to load: ");
                fileName = input.next();
                imageData = ConsoleGfx.loadFile(fileName);
                System.out.println(" ");

            }
            if (menuSelect == 2) { // Menu Option 2

                imageData = ConsoleGfx.testImage;
                System.out.println("Test image data loaded.");
                System.out.println(" ");

            }
            if (menuSelect == 3) { // Menu Option 3

                System.out.print("Enter an RLE string to be decoded: ");
                String rleString = input.next();
                stringToRle(rleString);
                System.out.println(" ");

            }
            if (menuSelect == 4) { // Menu Option 4

                System.out.print("Enter the hex string holding RLE data: ");
                String hexString = input.next();
                byte[] datahex = stringToData(hexString);
                System.out.println(" ");


            }
            if (menuSelect == 5) { // Menu Option 5

                System.out.print("Enter the hex string holding flat data: ");
                String flatData = input.next();
                System.out.println(" ");


            }
            if (menuSelect == 6) { // Menu Option 6

                System.out.println("Displaying image...");
                ConsoleGfx.displayImage(imageData);
                System.out.println(" ");

            }
            if (menuSelect == 7) { // Menu Option 7

                //System.out.print("RLE representation: " + toRleString(convertRle));
                System.out.println(" ");


            }
            if (menuSelect == 8) { // Menu Option 8

            }
            if (menuSelect == 9) { // Menu Option 9
                //toHexString(dataHex);

            }
            if (menuSelect == 0) { // Exit
                break;
            }
        }
    }

    // Start of Methods:
    public static String toHexString(byte[] data) { // Method 1
        int i;
        String temp;
        String hexString = "";
        for (i = 0; i < data.length; i++) {

            temp = hexCharDecode(data[i]);
            hexString += temp;

        }
        return hexString;
    }

    public static String hexCharDecode(int digit) { // Method 1 Helper, takes in a digit and returns a char string

        if (digit == 1) {
            return "1";
        }
        if (digit == 2) {
            return "2";
        }
        if (digit == 3) {
            return "3";
        }
        if (digit == 4) {
            return "4";
        }
        if (digit == 5) {
            return "5";
        }
        if (digit == 6) {
            return "6";
        }
        if (digit == 7) {
            return "7";
        }
        if (digit == 8) {
            return "8";
        }
        if (digit == 9) {
            return "9";
        }
        if (digit == 10) {
            return "a";
        }
        if (digit == 11) {
            return "b";
        }
        if (digit == 12) {
            return "c";
        }
        if (digit == 13) {
            return "d";
        }
        if (digit == 14) {
            return "e";
        }
        if (digit == 15) {
            return "f";
        }

        return String.valueOf(digit);
    }

    public static int getDecodedLength(byte[] rleData) { // Method 4
        int i;
        int sum = 0;
        for (i = 0; i < rleData.length; i++) {
            sum = sum + rleData[i]; // Adds the sum at every second array value
            i = i + 1;
        }
        return sum;
    }

    public static int countRuns(byte[] flatData) { // Method 2
        int i;
        int pixelCount = 1;
        int count = 1;
        for (i = 0; i < flatData.length - 1; i++) {
            if (pixelCount % 15 == 0) { // stops if the pixel length is greater than 15
                count++;
            }
            if (flatData[i] == flatData[i + 1]) { // count continues if the next element is the same as the previous
                pixelCount++;

            } else { // if condition is false, reset the pixel count but continues the count
                count++;
                pixelCount = 1;
            }
        }
        return count;
    }

    public static byte[] encodeRle(byte[] flatData) { // Method 3
        int i;
        int count = 1;
        int j = 0;
        byte[] encode = new byte[countRuns(flatData) * 2]; // takes in how many digits there are and reserves two spaces for each digit
        for (i = 0; i < flatData.length - 1; i++) {
            if (flatData[i] == flatData[i + 1]) {
                count++;
            }
            if (count % 15 == 0) { // if the pixel count reaches 15, forms a new group
                encode[j] = (byte) count;
                j = j + 1;
                encode[j] = flatData[i];
                j = j + 1;
                count = 0;
            }
            if (flatData[i] != flatData[i + 1]) { // if the element in front differs from the last, new group
                encode[j] = (byte) count;
                j = j + 1;
                encode[j] = flatData[i];
                j = j + 1;
                count = 1;
            }
            if (i == flatData.length - 2) { // To read last values of array
                encode[j] = (byte) count;
                j = j + 1;
                encode[j] = flatData[i + 1]; // Allows final element to be read
                count = 1;
            }

        }
        return encode;
    }

    public static byte[] stringToData(String dataString) { // Method 6
        int i;
        byte[] newString = new byte[dataString.length()];
        for (i = 0; i < dataString.length(); i++) {
            byte temp = stringToArray(dataString.charAt(i));
            newString[i] = temp;

        }
        return newString;
    }

    public static byte stringToArray(char digit) { // Helper method for Method 6; takes in a char and returns a byte

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

        return (byte) digit;
    }

    public static byte[] decodeRle(byte[] rleData) { // Method 5
        int i;
        byte iterations = 0;
        byte element = 0;
        byte value;
        byte[] decode = new byte[arrayLengthMethod(rleData)];
        for (i = 0; i < rleData.length; i++) {
            iterations = rleData[i];
            i = i + 1;
            value = rleData[i];
            for (int j = 0; j < iterations; j++) { // elements are filled based off the number of iterations
                decode[element] = value;
                element++;
            }
        }
        return decode;
    }

    public static byte arrayLengthMethod(byte[] rleData) { // decodeRle (Method 5) helper method, which reads every second value in the array input and adds them up
        int i;
        byte temp = 0;
        byte arrayLengthMethod = 0;
        for (i = 0; i < rleData.length; ) {
            arrayLengthMethod += rleData[i];
            i = i + 2;
        }
        return arrayLengthMethod;
    }

    public static String toRleString(byte[] rleData) { // Method 7
        int i;
        int colonCount = -1;
        String toRle = "";
        String temp = null;
        for (i = 0; i < rleData.length; i++) {
            if (i == 0 || i % 2 == 0 && i != rleData.length - 1 ) { //takes every even element and normally adds
                temp = String.valueOf(rleData[i]);
                toRle += temp;
                colonCount++;
            }
            if (i % 2 != 0 && i != 0 && i != rleData.length - 1) { // if the element is odd, it will add a delimiter afterwards
                temp = Integer.toHexString(rleData[i]);
                if (i < rleData.length - 1) {
                    toRle += temp + ":";
                    colonCount++;

                }
                else {
                    toRle += rleData[i];
                }
            }
            if (i == rleData.length - 1) { // condition to hand the last value
                temp = Integer.toHexString(rleData[i]);
                toRle += temp;
            }
        }
        return toRle;
    }

    public static byte[] stringToRle(String rleString) { // Method 8

        int i; // used to read character in the rleString
        int j = 0; // Array element value
        byte[] rleArray = new byte[rleArrayLength(rleString)]; // uses rleArrayLength method to get the length of the array
        for (i = 0; i < rleString.length() - 1; i++) {
            if (rleString.charAt(i) == ':') { // Skips over delimiters
               continue;
            }
            if (rleString.charAt(i) == '0') {
                rleArray[j] = 0;
                j++;
            }
            if (rleString.charAt(i) == '1' && rleString.charAt(i+1) > '5') {
                rleArray[j] = 1;
                j++;
            }
            if (rleString.charAt(i) == '2') {
                rleArray[j] = 2;
                j++;
            }
            if (rleString.charAt(i) == '3') {
                rleArray[j] = 3;
                j++;
            }
            if (rleString.charAt(i) == '4') {
                rleArray[j] = 4;
                j++;
            }
            if (rleString.charAt(i) == '5') {
                rleArray[j] = 5;
                j++;
            }
            if (rleString.charAt(i) == '6') {
                rleArray[j] = 6;
                j++;
            }
            if (rleString.charAt(i) == '7') {
                rleArray[j] = 7;
                j++;
            }
            if (rleString.charAt(i) == '8') {
                rleArray[j] = 8;
                j++;
            }
            if (rleString.charAt(i) == '9') {
                rleArray[j] = 9;
                j++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'0' && rleString.charAt(i) == '1' ) { // checks to see if characters add up 1+0, the statement after && prevents it from reading other characters with the same ASCII values
                rleArray[j] = 10;
                j++;
                i++;
            }
            if (rleString.charAt(i) == 'a') {
                rleArray[j] = 10;
                j++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1' + '1' && rleString.charAt(i) == '1' ) {
                rleArray[j] = 11;
                j++;
                i++;
            }
            if (rleString.charAt(i) == 'b') {
                rleArray[j] = 11;
                j++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'2' && rleString.charAt(i) == '1' ) {
                rleArray[j] = 12;
                j++;
                i++;
            }
            if (rleString.charAt(i) == 'c') {
                rleArray[j] = 12;
                j++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'3' && rleString.charAt(i) == '1' ) {
                rleArray[j] = 13;
                j++;
                i++;
            }
            if (rleString.charAt(i) == 'd') {
                rleArray[j] = 13;
                j++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'4' && rleString.charAt(i) == '1' ) {
                rleArray[j] = 14;
                j++;
                i++;
            }
            if (rleString.charAt(i) == 'e') {
                rleArray[j] = 14;
                j++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'5'&& rleString.charAt(i) == '1' ) {
                rleArray[j] = 15;
                j++;
                i++;
            }
            if (rleString.charAt(i) == 'f') {
                rleArray[j] = 15;
                j++;
            }
            if (j == rleArray.length - 1) { // Condition handles the last value
                rleArray[j] = charConvert(rleString.charAt(i+1));
            }

        }
        return rleArray;
        /* My logic is flawed, so if I have time I will correct my code with this:
        rleString.split - gives array of strings
        //parsebyte byte -> hex
        //variable that keeps tr
        String[] randomArray = rleString.split(":");
        byte[] byteArray = new byte[randomArray * 2];
        int byteindex = 0;
        for (int z = 0; z < randomArray.length; z++) {
            if (randomArray[z].length() == 2) {
                //parsebyte & byteindex byteArray[byteIndex] == the first character
                //byteIndex++
                //parsebyte & byteindex byteArray[byteIndex] == the second character(hex converted) byteindex++
            }
            else {
                //parsebyte & byteindex byteArray[byteIndex] == the first character //str.substring (start, end) str.substring(0, 2) of hello = he
            }
        }*/
    }

    public static int rleArrayLength(String rleString) { //Method to get array length for Method 8
        int i;
        int count = 1;
        for (i = 0; i < rleString.length() - 1; i++) {
            if (rleString.charAt(i) == ':') {
                i++;
            }
            if (i == rleString.length() - 1) {
                count++;
            }
            if (rleString.charAt(i) == '0') {
                count++;
            }
            if (rleString.charAt(i) == '1' && rleString.charAt(i+1) > '5') {
                count++;
            }
            if (rleString.charAt(i) == '2') {
                count++;
            }
            if (rleString.charAt(i) == '3') {
                count++;
            }
            if (rleString.charAt(i) == '4') {
                count++;
            }
            if (rleString.charAt(i) == '5') {
                count++;
            }
            if (rleString.charAt(i) == '6') {
                count++;
            }
            if (rleString.charAt(i) == '7') {
                count++;
            }
            if (rleString.charAt(i) == '8') {
                count++;
            }
            if (rleString.charAt(i) == '9') {
                count++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'0' && rleString.charAt(i) == '1' ) {
                count++;
                i++;
            }
            if (rleString.charAt(i) == 'a') {
                count++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1' + '1' && rleString.charAt(i) == '1' ) {
                count++;
                i++;
            }
            if (rleString.charAt(i) == 'b') {
                count++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'2' && rleString.charAt(i) == '1' ) {
                count++;
                i++;
            }
            if (rleString.charAt(i) == 'c') {
                count++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'3' && rleString.charAt(i) == '1' ) {
                count++;
                i++;
            }
            if (rleString.charAt(i) == 'd') {
                count++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'4' && rleString.charAt(i) == '1' ) {
                count++;
                i++;
            }
            if (rleString.charAt(i) == 'e') {
                count++;
            }
            if (rleString.charAt(i) + rleString.charAt(i + 1) == '1'+'5' && rleString.charAt(i) == '1' ) {
                count++;
                i++;
            }
            if (rleString.charAt(i) == 'f') {
                count++;
            }
        }
        return count;
    }

    public static byte charConvert(char convert) { // Method for the last if statement in Method 8, it will convert a char to number
        if (convert == '0') {
            return 0;
        }
        if (convert == '1') {
            return 1;
        }
        if (convert == '2') {
            return 2;
        }
        if (convert == '3') {
            return 3;
        }
        if (convert == '4') {
            return 4;
        }
        if (convert == '5') {
            return 5;
        }
        if (convert == '6') {
            return 6;
        }
        if (convert == '7') {
            return 7;
        }
        if (convert == '8') {
            return 8;
        }
        if (convert == '9') {
            return 9;
        }
        if (convert == 'a') {
            return 10;
        }
        if (convert == 'b') {
            return 11;
        }
        if (convert == 'c') {
            return 12;
        }
        if (convert == 'd') {
            return 13;
        }
        if (convert == 'e') {
            return 14;
        }
        if (convert == 'f') {
            return 15;
        }
        return (byte) convert;
    }

}
// Help from Megan Wolf (TA) on Method StringToRle
