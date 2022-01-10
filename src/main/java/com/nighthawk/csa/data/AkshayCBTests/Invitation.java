package com.nighthawk.csa.data.AkshayCBTests;

public class Invitation {
    private String hostName;
    private String address;

    public Invitation(String n, String a) {
        hostName = n;
        address = a;
    }

    public String getHostName() {
        return hostName;
    }

    public void setAddress(String a) {
        address = a;
    }

}
