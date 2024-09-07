package me.lms.tddtest.tdd.video;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoStoreTest {

    private static User user;
    private static Video video;
    private static Video video2;
    private static Video video3;
    private static Lend lend;
    private static Lend lend2;
    private static Lend lend3;
    private static VideoStore videoStore;

    @BeforeAll
    public static void setUp(){
        // 고객
        String inputUserName = "lms";
        user = new User(inputUserName);

        // 영화
        String movieVideoType =VideoType.MOVIE.toString();
        String movieVideoName ="If only";
        int moviePrice = 1000;
        video = new Video(movieVideoType,movieVideoName,moviePrice);

        // 다큐멘터리 영화
        String documentaryVideoType =VideoType.DOCUMENTARY.toString();
        String documentaryVideoName ="World War II";
        int documentaryPrice = 1000;

        // 스포츠 영화
        String sportsVideoType =VideoType.SPORTS.toString();
        String sportsVideoName ="Just do it";
        int sportsPrice = 1000;

        // 영화 2
        video = new Video(movieVideoType,movieVideoName,moviePrice);
        video2 = new Video(documentaryVideoType,documentaryVideoName,documentaryPrice);
        video3 = new Video(sportsVideoType,sportsVideoName,sportsPrice);

        // 대여
        lend = new Lend(user,video);
        lend2 = new Lend(user,video2);
        lend3 = new Lend(user,video3);
        videoStore= new VideoStore(user);
        videoStore = new VideoStore(user, video, lend);

    }


    // 대여한다.(고객이 비디오를)  고객 -> 대여 -> 영화
    @Test
    public void 고객이_비디오를_대여한다(){

        assertEquals("lms",user.getName());
        assertEquals("If only",video.getTitle());
        assertEquals("MOVIE",video.getCategory());
        assertEquals(1000,video.getPrice());
        assertEquals(1,lend.getLendDays());
        assertEquals(0,lend.getDiscount());
        if(video.getCategory().equals(VideoType.SPORTS.toString())) {
            assertEquals(2, lend.getPoint());
        }else{
            assertEquals(1,lend.getPoint());
        }
        assertEquals(1,lend.getLendVideoCount());

    }

    // 할인된다.(시스템이 비디오 일일 대여가격을)
    @Test
    public void 시스템이_비디오_할인되는_일일_대여가격을_계산한다(){
        int moviePrice = videoStore.calcRentalFee(video.getPrice(), 5, 2, 0.5);
        int documentaryPrice = videoStore.calcRentalFee(video2.getPrice(), 5, 3, 0.3);
        int sportPrice = videoStore.calcRentalFee(video3.getPrice(), 5, 5, 0);
        assertEquals(3500, moviePrice);
        assertEquals(3600, documentaryPrice);
        assertEquals(5000, sportPrice);
    }

    // 계산한다.(시스템이 총 대여가격을)
    @Test
    public void 시스템이_총_대여가격을_계산한다(){
        int totalRentalFee = videoStore.calcRentalFee(video.getPrice(), 5, 2, 0.5) + videoStore.calcRentalFee(video2.getPrice(), 5, 3, 0.3) + videoStore.calcRentalFee(video3.getPrice(), 5, 5, 0);
        assertEquals(12100, totalRentalFee);

    }

    // 계산한다.(시스템이 포인트 총합을)
    @Test
    public void calculateTotalPoint(){
        int totalPoint = videoStore.getPoint( video.getCategory() ) + videoStore.getPoint(video2.getCategory()) + videoStore.getPoint(video3.getCategory());
        assertEquals(3, totalPoint);
    }

    // 누적된다.(시스템이 포인트를)
    @Test
    public void calculatePoint(){
        int totalPoint = videoStore.getPoint( video.getCategory() ) + videoStore.getPoint(video2.getCategory()) + videoStore.getPoint(video3.getCategory());
        user.setPoint(totalPoint);
        assertEquals(3, user.getPoint());
    }


    // 계산한다.(시스템이 총 대여비디오 수를)
    @Test
    public void calculateTotalVideoCount(){
        int totalVideoCount = lend.getLendVideoCount() + lend2.getLendVideoCount() + lend3.getLendVideoCount();
        assertEquals(3, totalVideoCount);
    }


    // 제공한다.(시스템이 대여정보를)
    @Test
    public void provideRentalInfo(){

        VideoStore videoStore = new VideoStore(user, video, lend);
        VideoStore videoStore2 = new VideoStore(user, video2, lend2);
        VideoStore videoStore3 = new VideoStore(user, video3, lend3);
        System.out.println(videoStore.toString());
        System.out.println(videoStore2.toString());
        System.out.println(videoStore3.toString());

    }


}
