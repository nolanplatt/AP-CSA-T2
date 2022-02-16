package com.nighthawk.csa;

import java.util.ArrayList;

// Write a Class Number
class Number {
    // instance variables
    int squirrelNum;
    int index;
    static int indexCounter = 0;

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public Number() {
        // Since Math.random() * 34 will return a value between 0 and 33,
        // Then adding 3 to both will pick a random number between 3 and 36.
        squirrelNum = (int) Math.floor(Math.random() * 34) + 3;
        // Index
        index = indexCounter;
        indexCounter++;
    }

    // It contains a getter for the Random Number
    public int getSquirrelNum() {
        return squirrelNum;
    }

    // It contains a getter for Index, or the order it was initialized
    public int getIndex() {
        return index;
    }

    // Write a tester method
    public static void main(String[] args) {

        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Number> squirrels = new ArrayList<>();


        // Initialize 10 squirrels of class type Number
        for (int i = 0; i < 10; i++) {
            Number squirrel = new Number();
            squirrels.add(squirrel);
        }

        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops
        int min = 37;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (squirrels.get(j).getSquirrelNum() < min) {
                    squirrels.add(squirrels.get(j));
                    squirrels.remove(j);
                    min = squirrels.get(j).getSquirrelNum();
                }
            }
        }

        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for (Number i : squirrels) {
            System.out.println("Squirrels: " + i.getSquirrelNum() + " Day: " + i.getIndex());
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

