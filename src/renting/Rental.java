package renting;

public class Rental {
    private final Movie movie;
    private final int daysRented;
    public Rental(Movie newMovie, int newDaysRented) {
        movie = newMovie;
        daysRented = newDaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double result = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (this.getDaysRented() > 2)
                    result += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += this.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (this.getDaysRented() > 3)
                    result += (this.getDaysRented() - 3) * 1.5;
                break;
            default:
                return -1;
        }
        return result;
    }

    public double getFrequentRenterPoints() {
        // add frequent renter points
        double frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}