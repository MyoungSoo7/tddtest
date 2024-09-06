package me.lms.tddtest.tdd.video;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoStoreTest {


    // 대여한다.(고객이 비디오를)  고객 -> 대여 -> 영화
    @Test
    public void 비디오정보를_가져온다(){
        String inputVideoType =VideoType.MOVIE.toString();
        String inputVideoName ="If only";
        int inputPrice = 1000;

        Video video = new Video(inputVideoType,inputVideoName,inputPrice);
        String outputVideoName = video.getTitle();
        String outputVideoType = video.getCategory();
        int outputPrice = video.getPrice();

        assertEquals(inputVideoName,outputVideoName);
        assertEquals(inputVideoType,outputVideoType);
        assertEquals(inputPrice,outputPrice);
    }


    // 대여한다.(고객이 비디오를)  고객 -> 대여 -> 영화
    @Test
    public void 고객이_비디오를_대여한다(){
        String inputUserName = "lms";
        String inputVideoType =VideoType.MOVIE.toString();
        String inputVideoName ="If only";
        int inputPrice = 1000;

        User user = new User(inputUserName);
        Video video = new Video(inputVideoType,inputVideoName,inputPrice);
        VideoStore videoStore = new VideoStore(user,video,videoType,null);
        Lend lend = videoStore.lendVideo(user,video);
        // 영화는 2일이상되면 3일 째부터 1/2할인
        // 영화는 1개 대여 1포인트


    }

    // 할인된다.(시스템이 비디오 일일 대여가격을)


    // 누적된다.(시스템이 포인트를)


    // 계산한다.(시스템이 포인트 총합을)


    // 계산한다.(시스템이 총 대여가격을)


    // 계산한다.(시스템이 총 대여비디오 수를)


    // 제공한다.(시스템이 대여정보를)

}
