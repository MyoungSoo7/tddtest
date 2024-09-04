package me.lms.tddtest.tdd.video;

public class Video {

    private String category;
    private String title;
    private int price;
    private int period;

    public Video(String category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public Video(String category, String title, int price, int period) {
        this.category = category;
        this.title = title;
        this.price = price;
        this.period = period;
    }

    public void initalize(){
        if(period >= 3){
            price = ((price/2) /100) * 100;
        }
        if(period == 3){
            price = price/3;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
