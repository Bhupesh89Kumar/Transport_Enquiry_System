package com.shashi.beans;

import java.io.Serializable;

public class BookingDetails implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String mailId;
    private String tr_no;
    private String date;
    private String from_stn;
    private String to_stn;
    private int seats;
    private Double amount;

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getTr_no() {
        return tr_no;
    }

    public void setTr_no(String tr_no) {
        this.tr_no = tr_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom_stn() {
        return from_stn;
    }

    public void setFrom_stn(String from_stn) {
        this.from_stn = from_stn;
    }

    public String getTo_stn() {
        return to_stn;
    }

    public void setTo_stn(String to_stn) {
        this.to_stn = to_stn;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // Method to print booking details in a fancy table format
    public void printBookingDetails() {
        System.out.println("+----------------------------------------+");
        System.out.printf("| %-15s | %s%n", "Mail ID:", mailId);
        System.out.printf("| %-15s | %s%n", "Train No:", tr_no);
        System.out.printf("| %-15s | %s%n", "Date:", date);
        System.out.printf("| %-15s | %s%n", "From Station:", from_stn);
        System.out.printf("| %-15s | %s%n", "To Station:", to_stn);
        System.out.printf("| %-15s | %d%n", "Seats:", seats);
        System.out.printf("| %-15s | $%.2f%n", "Amount:", amount);
        System.out.println("+----------------------------------------+");
    }

    public static void main(String[] args) {
        // Create a BookingDetails object with sample data
        BookingDetails booking = new BookingDetails();
        booking.setMailId("john@example.com");
        booking.setTr_no("12345");
        booking.setDate("2024-04-29");
        booking.setFrom_stn("POTHERI");
        booking.setTo_stn("TIRUSULAM");
        booking.setSeats(2);
        booking.setAmount(150.0);

        // Print the booking details in a fancy table
        booking.printBookingDetails();
    }
}
