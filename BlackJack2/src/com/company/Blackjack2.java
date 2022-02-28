package com.company;
import java.util.Scanner;
import java.util.Random;
public class Blackjack {

    public static void main(String[] args) {
        P1Random rndm = new P1Random();
        rndm.nextInt(13) + 1;
        int a = rndm.nextInt(13) + 1;
        int b;
        int c;
        int dealer;
        int menu = 0;
        int whatever = 0;
        int one = 1;
        Scanner input = new Scanner (System.in);
            int counter = 1;
            System.out.println ("START GAME #" + counter);
            System.out.println (" ");
            a = randNum.nextInt(13) + 1;
            if (a == 1) {

            }
            System.out.println ("Your card is a " + a + "!");
            System.out.println ("Your hand is: " + a );


            while
            System.out.println ("START GAME #" + counter);
        }
            while (whatever == 0) {
                System.out.println (" ");
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println(" ");
                System.out.print("Choose an option: ");
                menu = input.nextInt();
                if (menu == 1) {
                    b = randNum.nextInt((13) + 1);
                    System.out.println ("Your card is a " + b + "!");
                    a = a + b;
                    if (a < 21) {
                        System.out.println ("Your hand is: " + a);
                    }
                    if (a > 21) {
                        System.out.println (" ");
                        System.out.println ("You exceeded 21! You lose.");
                        break;
                    }
                }
                if (menu == 2) {
                dealer = randNum.nextInt((11) + 16);
                System.out.println ("Dealer's hand: " + dealer);
                System.out.println ("Your hand is: " + a);
                    if (a <= 21 && a >= dealer && dealer !=21 ) {
                        System.out.println("You win!");
                        break;
                    }
                }
            }
    }
}
