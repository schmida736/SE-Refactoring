package renting;

import java.util.*;

public class Customer {

    public Customer (String newName){
        name = newName;
    }
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    private double totalCharge = 0;
    private int totalFrequentRenterPoints = 0;

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }
    public String getName (){
        return name;
    }

    public int getTotalFrequentRenterPoints() {
        return totalFrequentRenterPoints;
    }

    public void setTotalFrequentRenterPoints(int totalFrequentRenterPoints) {
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
    }

    public String statement() {
        setTotalFrequentRenterPoints(0);
        setTotalCharge(0);
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");
        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();

            setTotalFrequentRenterPoints((int) (getTotalFrequentRenterPoints() + each.getFrequentRenterPoints()));
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(each.getCharge()).append("\n");
            setTotalCharge(getTotalCharge() + each.getCharge());
        }
        //add footer lines
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }
}