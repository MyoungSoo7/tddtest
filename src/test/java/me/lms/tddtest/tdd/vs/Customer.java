package me.lms.tddtest.tdd.vs;

public class Customer {

    private String name;
    private Rental rental;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rental lend() {
        rental = new Rental();
        rental.setRentalPeriod(1);
        return rental;
    }



}
