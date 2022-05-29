package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) {
	JSONGetter jsonGetter = new JSONGetter();
    jsonGetter.url = "https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=4";
    jsonGetter.run();

    System.out.println("Waiting for data...");
    String jsonString = jsonGetter.jsonIn;
    System.out.println(jsonString);

    Object obj = null;
    try
    {
        obj = new JSONParser().parse(jsonString);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    System.out.println();

    JSONArray jsonArray = (JSONArray) obj;
    System.out.println(jsonArray.toJSONString());
    System.out.println();

    Rates rates = new Rates();

    for (Object jsonObject:jsonArray) {
        JSONObject current = (JSONObject) jsonObject;
        String ccy = (String) current.get("ccy");
        String ccy_base = (String) current.get("ccy_base");
        String buy = (String) current.get("buy");
        String sale = (String) current.get("sale");
        Currency currency = new Currency(ccy, ccy_base, buy, sale);
        rates.add(currency);
    }

    System.out.println(rates);

    rates.getRates().sort(Currency.byNameAsc);
    System.out.println(rates);

    Rates withCHF = rates.filterByCCY("CHF");
    System.out.println("with CHF: " + withCHF);
    }
}
