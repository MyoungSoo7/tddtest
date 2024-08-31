package me.lms.tddtest.tdd.account;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private static Account account;

    @BeforeAll
    public static void setUp(){
        account = new Account(10000);
    }

    @Test
    public void testPingBack() throws Exception {
        Thread.sleep(500);
        assertEquals("ping", "ping");
    }

    // 결과가 옳은가? 경계조건이 옳은가? 역(reverse)관계를 확인할 수 있는가?
    // 다른 수단을 사용해서 결과를 교차확인 할 수 있는가?
    // 에러조건을 강제로 만들어 낼 수 있는가?
    // 성능이 한도내에 있는가?
    @Test
    @DisplayName("조회, 입금, 출금 테스트")
    public void depositTest(){
        // assertions, test fixture(일관된 테스트 실행환경), test runner(테스트 실행기)
        // 단위테스트 JUnit , Matchers라이브러리 Hamcrest (테스트케이스 의미 명확)
        // AC2 애자일 코치 김창준 : TDD 개발 시간 15% 증가, 결함 60% 감소
        assertEquals(10000, account.getBalance());
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
        account.withdraw(1000);
        assertEquals(10000, account.getBalance());
        String[] names = {"kim", "lee", "park"};
        assertArrayEquals(names, new String[]{"kim", "lee", "park"});

    }

    // TDD한계 : 동시성 문제, 접근제한자 문제, GUI 문제, 의존성 모듈 테스트
    @Test
    @DisplayName("마이너스통장인출")
    public void testWithdraw_마이너스통장인출(){
        Account account = new Account(10000);
        account.withdraw(10000);
        assertEquals(0, account.getBalance());
    }

    // Mocking(조각하기 쉬운재료) : 가짜 객체를 만들어서 테스트 -> 대상 객체가 의존하는 객체를 대체(의존성을 Mock으로 대체)
    // 일반적인 테스트 더블은 상태(state)를 기반으로 테스트 테이스를 작성한다.
    // Mock 객체는 행위(behavior)를 기반으로 테스트 케이스를 작성한다.
    @Test
    @DisplayName("Mocking을 사용한 테스트")
    public void testWithdraw_Mocking(){
       //expect(mockList.add("item")).andReturn(true);
    }

    @AfterAll
    public static void tearDown(){
        account = null;
    }

}
