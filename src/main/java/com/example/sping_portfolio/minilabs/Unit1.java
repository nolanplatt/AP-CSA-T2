package com.example.sping_portfolio.minilabs;

public class Unit1 {
    public static void main(String[] args) {
        int i1 = 7, i2 = 2;
        System.out.println("Integer Division");
        System.out.println(String.format("\tint format: %d/%d is %d",i1, i2, i1/i2));
        System.out.printf("\tint sprintf: %d/%d is %d\t",i1, i2, i1/i2);
        System.out.println();

        double d1 = 7, d2 = 2;
        System.out.println("Double Division");
        System.out.println(String.format("\tdouble format: %.2f/%.2f is %.2f",d1, d2, d1/d2));
        System.out.printf("\tdouble sprintf: %.2f/%.2f is %.2f\t",d1, d2, d1/d2);
        System.out.println();
        System.out.printf("\tint cast to double sprintf: %d/%d is %.2f\t",i1, i2, i1/(double)i2);
        System.out.println();
    }
}
