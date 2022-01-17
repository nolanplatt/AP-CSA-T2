package com.nighthawk.csa.data.AkshayCBTests;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;

public class Unit6 {
    public static void main(String[] args) {
//        QuestionOne Q1 = new QuestionOne();
//        Q1.FindSubStr("ing");

        Payroll P = new Payroll();
        System.out.println(P.computeBonusThreshold());

        P.computeWages(10.0, 1.5);
        System.out.println(Arrays.toString(P.getWages()));

    }
}

class Payroll {
    private int[] itemsSold = new int[]{48, 50, 37, 62, 38, 70, 55, 37, 64, 60};
    private double[] wages = new double[10];
    private double bonusThreshold;

    public double computeBonusThreshold() {
        int max = itemsSold[0];
        int min = itemsSold[0];

        // find max
        for(int i = 0; i < itemsSold.length; i++) {
            if (itemsSold[i] > max) {
                max = itemsSold[i];
            }
        }

        // find min
        for(int j = 0; j < itemsSold.length; j++) {
            if (itemsSold[j] < min) {
                min = itemsSold[j];
            }
        }

        // avg accounting for max and min
        int sum = 0;
        for(int g = 0; g < itemsSold.length; g++) {
            System.out.println(g);
            sum = sum + itemsSold[g];
        }

        System.out.println(sum);

        sum = sum - max - min;
        double doubleSum = sum;

        bonusThreshold = sum/8.0;
        return sum/8.0;
    }

    public void computeWages(double fixedWage, double perItemWage) {
        for(int a = 0; a < itemsSold.length; a++) {
            if(itemsSold[a] > bonusThreshold) {
                wages[a] = (fixedWage + perItemWage * itemsSold[a]) * 1.1;
            } else {
                wages[a] = fixedWage + perItemWage * itemsSold[a];
            }
        }

    }

    public double[] getWages() {
        return wages;
    }
}


class QuestionOne {
    ArrayList<String> words = new ArrayList<>(Arrays.asList("ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"));

    public void FindSubStr( String str ) {
        for (String word : words) {
            if (word.substring(word.length() - 3).equals(str)) {
                System.out.println(word);
            }
        }
    }

}
