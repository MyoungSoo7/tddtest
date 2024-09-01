package me.lms.tddtest.tdd.video;

public class Video {

    private String title;
    private String category;
    private int price;
    private VideoType videoType;
    private Rental rental;

    public Video(String title, String category, int price, VideoType videoType) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.videoType = videoType;
    }
/*
    // 대여한다.(고객이 비디오를)  고객 -> 대여 -> 영화
    public void lend(User user) {
        rental = new User(user.getName(), user.getRental());
    }

    // 할인된다.(시스템이 비디오 일일 대여가격을)
    public int getDiscountedPrice() {
        return videoType.getPoint();
    }

    // 누적된다.(시스템이 포인트를)
    public int getAccumulatedPoint() {
        return videoType.getPoint();
    }
    // 계산한다.(시스템이 포인트 총합을)
    public int getTotalPoint() {
        return videoType.getPoint();
    }
    // 계산한다.(시스템이 총 대여가격을)
    public int getTotalPrice() {
        return videoType.getPoint();
    }
    // 계산한다.(시스템이 총 대여비디오 수를)
    public int getTotalVideoCount() {
        return videoType.getPoint();
    }
    // 제공한다.(시스템이 대여정보를)
    public Rental getRental() {
        return rental;
    }
*/




}
