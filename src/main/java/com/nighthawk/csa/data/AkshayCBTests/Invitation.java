package com.nighthawk.csa.data.AkshayCBTests;

public class Invitation {
    private String hostName;
    private String address;

//    public Invitation(String n, String a) {
//        hostName = n;
//        address = a;
//    }

    public Invitation(String address) {
        this.address = address;
        hostName = "Host";
    }

    public String getHostName() {
        return hostName;
    }

    public void setAddress(String a) {
        address = a;
    }

    public String invitationString(String invitee) {
        String inviteString = "Dear " + invitee + ", please attend my event at " + address + ". See you then, " + hostName + ".";
        return inviteString;
    }


}
