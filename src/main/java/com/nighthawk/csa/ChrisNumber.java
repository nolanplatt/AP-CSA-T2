package com.nighthawk.csa;

import java.util.ArrayList;

// Write a Class Number
public class ChrisNumber {
    // instance variables
    private int min=3;
    private int max=36;

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public ChrisNumber(int min, int max) {
        // constructor
        this.min = min;
        this.max = max;
    }

    // It contains a getter for the Random Number
    public double rand(){
        return Math.random() * ( max - min );
    }


    // It contains a getter for Index, or the order it was initialized
    public Index() {

    }

    // Write a tester method
    public static void main(String[] args) {

        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Number> squirrels = new ArrayList<Number>();

        // Initialize 10 squirrels of class type Number
        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops


        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for( : ) {

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

