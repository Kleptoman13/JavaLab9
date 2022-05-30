package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        JSONGetter jsonGetter = new JSONGetter();
        jsonGetter.url = "https://pokeapi.co/api/v2/pokemon";
        jsonGetter.run();

        System.out.println("Waiting for data...");
        String jsonString = jsonGetter.jsonIn;
        System.out.println(jsonString);

        Object obj = null;
        try
        {
            obj = new JSONParser().parse(jsonString);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        System.out.println(obj);
        System.out.println();

        JSONObject jsonObj = (JSONObject) obj;
        System.out.println(jsonObj.toJSONString());
        System.out.println();

        JSONArray results = (JSONArray) jsonObj.get("results");
        System.out.println(results.toJSONString());

        Pokemons pokemons = new Pokemons();

        for (Object jsonObject:results) {
            JSONObject current = (JSONObject) jsonObject;
            String name = (String) current.get("name");
            String url = (String) current.get("url");
            Result pokemon = new Result(name, url);
            pokemons.add(pokemon);
        }

        System.out.println(pokemons);

        pokemons.getPokemons().sort(Result.byNameAsc);
        System.out.println(pokemons);

        pokemons.getPokemons().sort(Result.byNameDesc);
        System.out.println(pokemons);

        Pokemons tempName = pokemons.filterByName("pid");
        System.out.println("With pid: " + tempName);
    }
}
