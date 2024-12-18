package me.lms.tddtest.tdd.tax;

public class StandardTax {

    public int getTaxAmount(int income) {
        if (income < 1200) {
            return (int) (income * 0.08);
        } else if (income < 4600) {
            return (int) (income * 0.17 - 108);
        } else if (income < 8800) {
            return (int) (income * 0.26 - 522);
        } else {
            return (int) (income * 0.35 - 1314);
        }

    }
}
