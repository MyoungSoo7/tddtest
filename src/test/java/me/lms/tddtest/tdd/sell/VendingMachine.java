package me.lms.tddtest.tdd.sell;


public class VendingMachine {

    private int changeAmount;

    public void insertCoin(int coin){
        this.changeAmount += coin;
    }

    public int getChangeAmount(){
        return this.changeAmount;
    }

    public void selectDrink(Drink drink){
        this.changeAmount -= drink.getPrice();
    }

    public CoinSet getChangeCoinSet(){
        CoinSet coinSet = new CoinSet();
        int[] coins = {500, 100, 50, 10};
        for(int coin : coins){
            while(this.changeAmount >= coin){
                this.changeAmount -= coin;
                coinSet.add(coin);
            }
        }
        return coinSet;
    }

}
