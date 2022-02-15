package com.nighthawk.csa.data.AkshayCBTests;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Write a Class Number
public class Number {
    private final int squirrelNum;


    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public Number() {
        squirrelNum = (int) (Math.random() * ( 36 - 3 + 1) + 3);
    }

    // It contains a getter for the Random Number

    public int getSquirrelNum() {
        return squirrelNum;
    }

    // It contains a getter for Index, or the order it was initialized


    // Write a tester method
    public static void main(String[] args) {

        // Create an ArrayList of Type Number, my ArrayList is called squirrels
        ArrayList<Number> squirrels = new ArrayList<Number>();

        // Initialize 10 squirrels of class type Number
        Number squirrel0 = new Number();
        squirrels.add(squirrel0);
        Number squirrel1 = new Number();
        squirrels.add(squirrel1);
        Number squirrel2 = new Number();
        squirrels.add(squirrel2);
        Number squirrel3 = new Number();
        squirrels.add(squirrel3);
        Number squirrel4 = new Number();
        squirrels.add(squirrel4);
        Number squirrel5 = new Number();
        squirrels.add(squirrel5);
        Number squirrel6 = new Number();
        squirrels.add(squirrel6);
        Number squirrel7 = new Number();
        squirrels.add(squirrel7);
        Number squirrel8 = new Number();
        squirrels.add(squirrel8);
        Number squirrel9 = new Number();
        squirrels.add(squirrel9);

        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops

        for (Number n : squirrels) {
            System.out.println(n.getSquirrelNum()); // Just for testing
        }

//        for (Number n : squirrels) {
//            minIndex = squirrels.get(n);
//            for (Number n : squirrels) {
//
//            }
//
//        }

        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
        System.out.println("Squirrel number " + squirrels.size());
    }

}
