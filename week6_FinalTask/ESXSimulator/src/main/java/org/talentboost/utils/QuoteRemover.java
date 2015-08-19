package org.talentboost.utils;

public class QuoteRemover {
    public static String remove(String input){
        String result = input.replaceAll("[\'\"]", "");
        return result;
    }
}
