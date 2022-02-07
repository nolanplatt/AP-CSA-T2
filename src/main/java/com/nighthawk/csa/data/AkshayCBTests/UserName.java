package com.nighthawk.csa.data.AkshayCBTests;

import java.util.ArrayList;
import java.util.Objects;

public class UserName {
    String[] used = {"harta", "hartm", "harty"};
    ArrayList<String> possibleNames = new ArrayList<String>();

    public UserName(String firstName, String lastName) {
        String uname = lastName;
        for(int i = 0; i < firstName.length(); i++) {
            uname = uname + firstName.charAt(i);
            System.out.println(uname);
            possibleNames.add(uname);
        }
        System.out.println(possibleNames);
    }

    public boolean isUsed(String name) {
        for(int j = 0; j < used.length; j++) {
            if(Objects.equals(used[j], name)) {
                return true;
            }
        }
        return false;
    }

    public void setAvailableUserNames() {
        for(int y = 0; y < possibleNames.size(); y++) {
            if ( isUsed(possibleNames.get(y)) ) {
                possibleNames.remove(y);
            }
        }
        System.out.println(possibleNames);
    }

    public static void main(String[] args) {
        UserName u = new UserName("mary", "hart");
        u.setAvailableUserNames();
    }
}
