package com.company;

import java.util.Comparator;

public class Result {

    private String name;
    private String url;

    public Result() {
    }

    /**
     * 
     * @param name
     * @param url
     */
    public Result(String name, String url) {
        super();
        this.setName(name);
        this.setUrl(url);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        String result = "Pokemon {" + getName() + ", " + getUrl() + "}";
        return result;
    }

    public static Comparator<Result> byNameAsc = Comparator.comparing(o -> o.name);
    public static Comparator<Result> byNameDesc = (o1, o2) -> o2.name.compareTo(o1.name);

}
