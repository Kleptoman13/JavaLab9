package com.company;

import java.util.Comparator;

public class Currency {

    private String ccy;
    private String baseCcy;
    private String buy;
    private String sale;

    /**
     *
     * @param sale
     * @param baseCcy
     * @param buy
     * @param ccy
     */
    public Currency(String ccy, String baseCcy, String buy, String sale) {
        super();
        this.setCcy(ccy);
        this.setBaseCcy(baseCcy);
        this.setBuy(buy);
        this.setSale(sale);
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBaseCcy() {
        return baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
        this.baseCcy = baseCcy;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        String result = "{" + getCcy() + ", "
                + getBaseCcy() + ", "
                + getBuy() + ", "
                + getSale() + "}";
        return result;
    }

    public static Comparator<Currency> byNameAsc = Comparator.comparing(o -> o.ccy);
}
