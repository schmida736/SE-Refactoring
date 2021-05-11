package renting;

import java.util.*;

public class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();
    public Customer (String newName){
        name = newName;
    }
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }
    public String getName (){
        return name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(each.getCharge()).append("\n");
            totalAmount += each.getCharge();
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}