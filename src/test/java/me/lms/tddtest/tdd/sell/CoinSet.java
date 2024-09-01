package me.lms.tddtest.tdd.sell;

import java.util.ArrayList;
import java.util.List;

// 잔돈 코인을 담기 위해 사용하는 코인 컨테이너
public class CoinSet {

    private List<Integer> coinSet = new ArrayList<Integer>();

    public void add(int coin){
        this.coinSet.add(coin);
    }

    @Override
    public boolean equals(Object coinSet){
        if( !(coinSet instanceof CoinSet) ){
            return false;
        }
        return this.toString().equals(coinSet.toString());
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Integer coin : this.coinSet){
            builder.append(coin);
        }
        return builder.toString();
    }

}
