package me.lms.tddtest.tdd.sell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    // [업무시나리오]
    // 돈을 넣는다.(사람)
    // 투입한 금액이 표시된다. (하드웨어 + *소프트웨어)
    // 투입한 금액내에서 선택 가능한 음료가 있다면 해당 버튼에 불이 들어온다.(하드웨어)
    // 음료를 선택한다.(사람)
    // 선택한 음료가 나온다.(하드웨어)
    // 투입금액 표시화면에는 선택한 음료 가격만큼 제외된 가격이 표시된다. (하드웨어 + *소프트웨어)
    // 만일 표시된 남은 금액이 다른 음료를 선택할 수 있는 금액이하면 바로 잔돈으로 반환한다.(*소프트웨어)
    // 다른 음료를 선택할 수 있는 금액이 남아 있다면 최초 동전을 넣었을 때와 동일하게 동작한다. (*소프트웨어)
    // 반환 버튼을 눌렀을 경우(일부 사람) 상황에 관계없이 표시되어 있는 금액을 최소 잔돈으로 반환한다.

    // <개발 가능범위>
    // 투입한 금액이 표시된다. -> 투입한 금액을 알 수 있다. 즉, 현재 잔액을 알 수 있다.
    // 투입 금액 표시화면에는 선택한 음료 가격만큼 제외된 가격이 표시된다. -> 현재 잔액을 알 수 있다.
    // 만일 표시된 남은 금액이 다른 음료를 선택할 수 있는 금액 이하이면 바로 잔돈으로 반환한다. -> 잔액이 최소음료가격이하인지 여부를 확인한다.
    // 다른 음료를 선택할 수 있는 금액이 남아 있다면 최초 동전을 넣었을 때와 동일하게 동작한다.
    // 표시되어 있는 금액을 최소 잔돈으로 반환한다.

    // *기능*
    // 1. 음료수의 가격 확인 (Drink)
    // 2. 잔액 확인 (VenidngMachine)
    // 3. 잔돈 반환 (CoinSet)

    // 구현범위
    // 잔액 확인, 잔액만큼 최소 동전으로 거스름돈 반환
    @Test
    public void 잔액확인(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(1000);
        vendingMachine.insertCoin(1000);
        vendingMachine.insertCoin(1000);
        assertEquals(3000, vendingMachine.getChangeAmount());
    }
    @Test
    public void 잔액만큼_최소동전으로_거스름돈_반환(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(100);
        vendingMachine.insertCoin(100);
        vendingMachine.insertCoin(500);
        vendingMachine.selectDrink(new Drink("콜라", 650));
        CoinSet expectedCoinSetModule = new CoinSet();
        expectedCoinSetModule.add(50);
        assertEquals(expectedCoinSetModule, vendingMachine.getChangeCoinSetModule(vendingMachine.getChangeAmount()));

    }
    // CoinSet 클래스와 잔돈계산 메소드의 문제( ChangeModule, CoinSet)
    @Test
    @DisplayName("거스름돈")
    public void 오로지_잔돈_계산_모듈에만_집중(){
        ChangeModule changeModule = new ChangeModule();
        CoinSet expectedCoinSet = new CoinSet();
        expectedCoinSet.add(50);
        assertEquals(expectedCoinSet, changeModule.getChangeCoinSetModule(50));

    }



}
