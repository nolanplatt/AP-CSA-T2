package com.nighthawk.csa.data.AkshayCBTests;
import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator {
    String prefix;
    int numRandDigits;
    ArrayList<String> passwords = new ArrayList<String>();

    public PasswordGenerator(int len, String prefix) {
        this.prefix = prefix;
        numRandDigits = len;
    }

    public int pwCount() {
        System.out.println(passwords.size());
        return passwords.size();
    }

    public void pwGen() {
        String numberString = "";
        for(int i = 0; i < numRandDigits; i++) {
            Random random = new Random();
            int value = random.nextInt(9);
            String strValue = String.format("%d", value);
            numberString = numberString + strValue;
        }
        String password = prefix + "." + numberString;
        passwords.add(password);
        System.out.println(password);
    }

    public static void main(String[] args) {
        PasswordGenerator pw1 = new PasswordGenerator(4, "chs");
        pw1.pwGen();
        pw1.pwCount();
        pw1.pwGen();
        pw1.pwCount();

        PasswordGenerator pw2 = new PasswordGenerator(6, "A");
        pw2.pwGen();
        pw2.pwCount();
        pw2.pwGen();
        pw2.pwCount();

    }

}
