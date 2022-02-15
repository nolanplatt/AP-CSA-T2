package com.nighthawk.csa.starters.squirrel;
import java.util.ArrayList;

// Write a Class Number
public class Number {
    // instance variables
    int squirrelAmount;
    int index;
    static int indexCounter = 0;

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public Number() {
        // Since Math.random() * 34 will return a value between 0 and 33,
        // Then adding 3 to both will pick a random number between 3 and 36.
        squirrelAmount = (int) Math.floor(Math.random() * 34) + 3;
        // Index
        index = indexCounter;
        indexCounter++;
    }

    // It contains a getter for the Random Number
    public int getSquirrelAmount() {
        return squirrelAmount;
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
        int leastRandomNumber = 37;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (squirrels.get(j).getSquirrelAmount() < leastRandomNumber) {
                    squirrels.add(squirrels.get(j));
                    squirrels.remove(j);
                    leastRandomNumber = squirrels.get(j).getSquirrelAmount();
                }
            }
        }

        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        for (Number i : squirrels) {
            System.out.println("Squirrels: " + i.getSquirrelAmount() + " Day: " + i.getIndex());
        }

    }
}
