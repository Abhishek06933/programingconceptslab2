package com.example.lab2pgc;

public class hotel {

    private final int id;
    private final String guestname;
    private final int room;
    private final int payment;

    public hotel(int id, String guestname, int room, int payment) {
        this.id = id;
        this.guestname = guestname;
        this.room = room;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public String getGuestname() {
        return guestname;
    }

    public int getRoom() {
        return room;
    }

    public int getPayment() {
        return payment;
    }
}
