package renting;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private final int priceCode;
    public Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        priceCode = newPriceCode;
    }
    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle (){
        return title;
    }
}