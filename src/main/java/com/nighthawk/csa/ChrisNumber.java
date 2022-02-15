package com.nighthawk.csa;

import java.util.ArrayList;
import java.util.Random;

// Write a Class Number
public class ChrisNumber {
    private int min = 3;
    private int max = 36;

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public ChrisNumber(int n, int mi, int ma) {
        // constructor
        // instance variables
        min = mi;
        max = ma;
    }

    // It contains a getter for the Random Number
    public int min() {
        return this.min;
    }

    public int max() {
        return this.max;
    }



    // It contains a getter for Index, or the order it was initialized



    // Write a tester method
    public static void main(String[] args) {

        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Number> squirrels = new ArrayList<Number>();

        // Initialize 10 squirrels of class type Number
        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops
        squirrels.add(3);
        squirrels.add(8);
        squirrels.add(13);


        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for(number : n) {
            System.out.println();
        }

    }

}

// Squirrels: 3 Day: 9
// Squirrels: 8 Day: 0
// Squirrels: 13 Day: 7
// Squirrels: 16 Day: 1
// Squirrels: 19 Day: 6
// Squirrels: 24 Day: 5
// Squirrels: 25 Day: 2
// Squirrels: 28 Day: 8
// Squirrels: 32 Day: 4
// Squirrels: 34 Day: 3

