package me.lms.tddtest.tdd.video;

import java.time.LocalDateTime;

public class Lend {

    private LocalDateTime lendDate;
    private LocalDateTime returnDate;
    private int discount;
    private int point;
    private int lendDays;


    public Lend(User user , Video video){
        this.lendDate = LocalDateTime.now();
        this.returnDate = null;
        this.lendDays = 1;
        this.discount = 0;
        this.point = 0;
    }

    public Lend(LocalDateTime lendDate, LocalDateTime returnDate, int lendDays, int discount, int point) {
        this.lendDate = lendDate;
        this.returnDate = returnDate;
        this.lendDays = lendDays;
        this.discount = discount;
        this.point = point;
    }

    public LocalDateTime getLendDate() {
        return lendDate;
    }

    public void setLendDate(LocalDateTime lendDate) {
        this.lendDate = lendDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getLendDays() {
        return lendDays;
    }

    public void setLendDays(int lendDays) {
        this.lendDays = lendDays;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Lend{" +
                "lendDate=" + lendDate +
                ", returnDate=" + returnDate +
                ", discount=" + discount +
                ", point=" + point +
                ", lendDays=" + lendDays +
                '}';
    }
}
