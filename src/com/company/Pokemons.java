package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class Pokemons {
    public ArrayList<Result> getPokemons() {return pokemons;}

    public Pokemons(ArrayList<Result> pokemons)
    {
        this.pokemons = pokemons;
    }

    public void setRates(ArrayList<Result> rates) {this.pokemons = pokemons;}

    private ArrayList<Result> pokemons;

    public Pokemons()
    {
        pokemons = new ArrayList<>();
    }

    public void add(Result currency) {this.pokemons.add(currency);}

    @Override

    public String toString()
    {
        String result = "Rates {" + (new Date()).toLocaleString() +"}"+ System.lineSeparator();

        for (Result c:pokemons) {
            result += c + System.lineSeparator();
        }

        return result;
    }

    public Pokemons filterByName(String name)
    {
        Pokemons tempPokemons = new Pokemons();
        for (Result currency:this.pokemons) {
            if (currency.getName().toLowerCase().contains(name.toLowerCase()))
            {
                tempPokemons.add(currency);
            }
        }

        return tempPokemons;
    }

}