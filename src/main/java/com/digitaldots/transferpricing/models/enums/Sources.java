package com.digitaldots.transferpricing.models.enums;



public enum Sources {
    WU("WU","Western Union"),
    MG("MG","MoneyGram"),
    RIA("RIA", "RIA Money");

    private final String key;
    private final String value;
    Sources(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
