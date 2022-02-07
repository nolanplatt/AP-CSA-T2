package com.nighthawk.csa.data.AkshayCBTests;

public class Unit9B {
    public static class Animal {
        String type;
        String species;
        String name;

        public Animal(String t, String s, String n) {
            type = t;
            species = s;
            name = n;
        }

        public String toString() {
            return name + " the " + species + " is a " + type;
        }
    }

    public static class Herbivore extends Animal {

        public Herbivore(String s, String n) {
            super("herbivore", s, n);
        }

    }

    public static class Elephant extends Herbivore {
        double length;

        public Elephant(String n, double l) {
            super("elephant", n);
            length = l;
        }

        @Override
        public String toString() {
            return super.toString() + " with tusks " + length + " meters long";
        }

    }

    public static void main(String[] args) {
        Animal lisa = new Animal("carnivore", "lion", "Lisa");
        System.out.println(lisa.toString());

        Herbivore gary = new Herbivore("giraffe", "Gary");
        System.out.println(gary.toString());

        Elephant percy = new Elephant("Percy", 2.0);
        System.out.println(percy.toString());

    }

}
