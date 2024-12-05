package org.exchange.controller;

import org.exchange.model.Money;

import java.util.List;
import java.util.Map;

public class Operation {

    private Money money;
    private List<Map.Entry<String, Double>> entryList;

    public Operation(){
        money = new Money();
    }

    public double getOperation(String codeISO_C){
        if (entryList != null){
            entryList.forEach(e->{
                if(e.getKey().equals(codeISO_C)){
                    double conversion = money.getMoneyS()*e.getValue();
                    money.setMoneyC(conversion);

                }
            });
        }

        return money.getMoneyC();

    }

    public Money getMoney() {
        return money;
    }

    public List<Map.Entry<String, Double>> getEntryList() {
        return entryList;
    }

    public void setList(String codeISO_source, String codeISO_convert) {
        entryList = Money.rateExchangeMoneyList(codeISO_source,codeISO_convert);
        this.entryList = entryList;
    }
}
