package me.lms.tddtest.tdd.sell;


public class VendingMachine {

    private int changeAmount;
    private ChangeModule changeModule;

    public VendingMachine(){
        this.changeAmount = 0;
        this.changeModule = new ChangeModule();
    }

    public void insertCoin(int coin){
        this.changeAmount += coin;
    }

    public int getChangeAmount(){
        return this.changeAmount;
    }

    public void selectDrink(Drink drink){
        this.changeAmount -= drink.getPrice();
    }

    public CoinSet getChangeCoinSetModule(int changeAmount){
        this.changeAmount = changeAmount;
        return changeModule.getChangeCoinSetModule(changeAmount);
    }

}
