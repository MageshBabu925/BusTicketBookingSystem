package com.classes;

public class Booking {
    private int id;
    private int busNo;
    private String username;
    private String bookingDate;

    public Booking(int id, int busNo, String username, String bookingDate) {
        this.id = id;
        this.busNo = busNo;
        this.username = username;
        this.bookingDate = bookingDate;
    }

    public Booking() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
