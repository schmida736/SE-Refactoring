package renting.tests;

import org.junit.jupiter.api.*;
import renting.*;


class CustomerTest {
    private static final Movie m1 = new Movie("movie1", 1);
    private static final Movie m2 = new Movie("movie2", 2);
    private static final Rental r1 = new Rental(m1, 10);
    private static final Rental r2 = new Rental(m2, 5);
    private static final Customer c1 = new Customer("joe");

    @BeforeAll
    static void before(){
        c1.addRental(r1);   c1.addRental(r2);
    }

    @Test
    void statement() {
        assert c1.statement().equals("""
                Rental Record for joe
                \tTitle\t\tDays\tAmount
                \tmovie1\t\t10\t30.0
                \tmovie2\t\t5\t4.5
                Amount owed is 34.5
                You earned 3 frequent renter points""");
    }
}