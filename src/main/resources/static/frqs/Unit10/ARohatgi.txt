package com.nighthawk.csa.data.AkshayCBTests;

public class Unit10 {
    public static class NumberSystem {
        public  int gcf(int a, int b) {
            if( (a % b) == 0) {
                return b;
            } else if ( ( a % b) != 0) {
                return gcf(b, a%b);
            }
            return 0;
        }

        public  void reduceFraction(int n, int d) {
            int sn = n / gcf(n, d);
            int sd = d / gcf(n, d);

            if (d == 1) {
                System.out.println(n + " / " + d + " reduces to " + sn);
            } else {
                System.out.println(n + " / " + d + " reduces to " + sn + " / " + sd);
            }
        }
    }

    public static void main(String[] args) {
        NumberSystem n = new NumberSystem();

        n.reduceFraction(30, 3);
        n.reduceFraction(8, 20);
        n.reduceFraction(24, 9);
        n.reduceFraction(7, 3);

    }

}
