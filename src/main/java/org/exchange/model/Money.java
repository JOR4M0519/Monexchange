package org.exchange.model;

import org.exchange.controller.RateExchangeMoney;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Money {

    private double moneyS=0;

    private double MoneyC = 0;

    public Money() {
    }

    public static List<Map.Entry<String, Double>> rateExchangeMoneyList(String codeISO_source, String codeISO_convert){

        RateExchangeMoney rateMoney = new RateExchangeMoney(codeISO_source,codeISO_convert);

        List<Map.Entry<String, Double>> rateExchangeList = rateMoney.getExchange();

        return rateExchangeList;
    }

    public double getMoneyS() {
        return moneyS;
    }

    public void setMoneyS(double moneyS) {
        this.moneyS = moneyS;
    }

    public double getMoneyC() {
        return MoneyC;
    }

    public void setMoneyC(double moneyC) {
        MoneyC = moneyC;
    }
}
