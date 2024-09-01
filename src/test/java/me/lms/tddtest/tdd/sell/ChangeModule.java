package me.lms.tddtest.tdd.sell;

public class ChangeModule {

    enum COIN {
        KRW500(500), KRW100(100), KRW50(50), KRW10(10);
        private int value;
        COIN(int value){
            this.value = value;
        }
    }

    public CoinSet getChangeCoinSet(int changeAmount){
        CoinSet coinSet = new CoinSet();
        //int remainChangeAmount = changeAmount;
        for(COIN coin : COIN.values()){
            while(changeAmount >= coin.value){
                changeAmount -= coin.value;
                coinSet.add(coin.value);
            }
        }

        return coinSet;
    }
}
