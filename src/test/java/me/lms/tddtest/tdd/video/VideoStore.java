package me.lms.tddtest.tdd.video;

public class VideoStore {

    // 비디오 가게에서 고객이 대여하는 비디오의 대여정보 조회할 수 있는 프로그램

   /* // [요구사항]
    private String userName; // 고객은 이름을 갖는다.
    private String video; // 고객은 한번에 여러개의 비디오를 대여할 수 있으나 각각의 대여기간은 다를 수 있다.
    private String lendVideo; // 비디오 대여
    private int lendDays; // 대여가능기간
    private LocalDateTime lendDate; // 대여일
    private LocalDateTime returnDate; // 반납일
    private int lateFee; // 연체료
    private String category; // 비디오 카테고리(영화, 스포츠, 다큐)
    // 대여기간이 2일 이상 되면 3일째부터는 대여요금이 1/2로 할인
    // 다큐멘터리는 3일 이상 대여하면 4일째부터는 1/3 할인
    // 스포츠는 장기대여 할인 없다.
    private int price; // 대여요금
    private int point; // 포인트 (대여할 때마다 1포인트씩 적립, 스포츠는 2포인트)*/

    // 요구사항 고객의 현재 총 대여비디오수

    // TDD
    // 하나의 목적을 갖는 의미나 동작으로 최대한 간결하게 표현
    // 업무 규칙과 기능 요구사항을 분리한다.
    // 고유명사는 대명사로, 명시적인 숫자는 변수로 참조할 수 있도록 표시해두면 도움이 된다.
    // 행동의 주체를 가급적 명황히 표현한다.
    // 동작과 소유를 분리한다. ( 객체의 동작인가 소유인가?)
    // 복합 한자어는 유심히 봐서 분리 가능한지 확인해서 풀어쓰면 더 좋다. (대여요금 -> 대여시에 발생하는 요금)
    // 상호작용을 유심히 관찰한다. (시스템의 행위인가? 고객의 행위인가?)
    // 구어체는 좀 더 명확한 의미를 가진 문어체로 변경한다. (구한다 -> 화면에 보여준다. 계산한다. 저장한다 , 올라간다 -> 증가한다. 누적한다.)

    // * 업무규칙 *
    // 고객은 이름을 갖는다.
    // 고객은 한 번에 여러개의 비디오를 대여할 수 있다.'
    // 대여기간은 비디오마다 다를 수 있다.
    // 비디오에는 종류가 있다.
    // 각 비디오는 독립적인 일일 대여요금이 있다.
    // 영화는 대여기간이 2일 이상 되면 3일째부터는 대여요금이 1/2로 할인된다.
    // 다큐멘터리는 대여기간이 3일 이상 되면 4일째부터는 1/3 할인된다.
    // 스포츠는 장기대여 할인이 없다.
    // 고객은 대여할 때마다 1포인트씩 적립된다.(단 스포츠는 2포인트)
    // 시스템은 고객의 과거의 대여기록을 보유하고 있을 필요 없다.
    // 대여는 일 단위, 포인트는 정수, 할인은 분수비율 (합의)

    // 기능 요구 사항
    // 1. 고객은 비디오를 대여할 수 있다.
    // 2. 시스템은 고객의 현재 대여정보를 제공할 수 있다. ( 대여 정보: 총 대여비디오수, 비디오(종류,제목,가격),대여기간리스트, 총대여가격, 현재 대여하고 있는 비디오로 인해 추가된 포인트
    // 3. 시스템은 현 대여로 인해 발생하는 포인트 총합을 계산할 수 있다.
    // 4. 시스템은 대여된 비디오들의 총 대여가격을 계산할 수 있다.
    // 5. 시스템은 총 대여비디오 수를 계산할 수 있다.

    // 행위기반 클래스 도출
    // 대여한다.(고객이 비디오를)  고객 -> 대여 -> 영화
    // 할인된다.(시스템이 비디오 일일 대여가격을)
    // 누적된다.(시스템이 포인트를)
    // 계산한다.(시스템이 포인트 총합을)
    // 계산한다.(시스템이 총 대여가격을)
    // 계산한다.(시스템이 총 대여비디오 수를)
    // 제공한다.(시스템이 대여정보를)

    // 소유기반 클래스 도출
    // 이름을 갖는다.(고객)
    // 종류를 갖는다.(비디오)
    // 대여요금을 갖는다(비디오)
    // 포인트를 갖는다(비디오타입)
    // 대여일수를 갖는다(각 대여는)

    // 시작은 소유기반 클래스부터, 의존성이 낮은 클래스부터 테스트케이스를 만드는 식으로 한다.
    // 소유기반부터 행위기반 클래스까지 테스트 케이스를 만들면서 개발해 나가다보면 통합테스트 수준의 테스트 케이스가 만들어진다.

    // 행위기반 클래스 도출
    private User user;
    private Video video;
    private Lend lend;

    public VideoStore(User user) {
        this.user = user;
    }

    public VideoStore(User user, Video video) {
        this.user = user;
        this.video = video;
    }

    public VideoStore(User user, Video video , Lend lend) {
        this.user = user;
        this.video = video;
        this.lend = lend;
    }

    public int calcRentalFee(int defaultCharge , int rentalPeriod, int discountPeriod, double discountPercentage){
        int rentlFeeTotal =0;
        // 할인된다.(시스템이 비디오 일일 대여가격을)
        if(rentalPeriod <= discountPeriod){
            rentlFeeTotal = defaultCharge * rentalPeriod;
         // 계산한다.(시스템이 총 대여가격을)
        }else{
            rentlFeeTotal = (int) defaultCharge * discountPeriod;
            rentlFeeTotal += (int) defaultCharge * discountPercentage * (rentalPeriod - discountPeriod);
        }
        return rentlFeeTotal;
    }

    // 계산한다.(시스템이 포인트 총합을)
    public int getPoint(String type){
        int point = 0;
        if(type.equals("sport")){
            point = 2;
        }else{
            point = 1;
        }
        return point;
    }

    // 계산한다.(시스템이 총 대여비디오 수를)
    public int getTotalVideoCount(Lend lend){
        return lend.getLendVideoCount();
    }

    // 제공한다.(시스템이 대여정보를)
    public Video getVideoInfo(Video video){
        return video;
    }

    // 누적된다.(시스템이 포인트를)
    public int getPointTotal(int point){
        return point;
    }


    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Lend getLend() {
        return lend;
    }

    public void setLend(Lend lend) {
        this.lend = lend;
    }

    @Override
    public String toString() {
        return "VideoStore{" +
                "user=" + user +
                ", video=" + video +
                ", lend=" + lend +
                '}';
    }
}
