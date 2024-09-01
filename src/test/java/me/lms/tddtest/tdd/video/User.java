package me.lms.tddtest.tdd.video;

public class User {
    private String name;
    private Rental rental;

    public User(String name, Rental rental){
        this.name = name;
        this.rental = rental;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
