package org.talentboost.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    public static List<String> splitBySpaceOutsideQuotes(String input) {
        // splits by space only outside single or double quated marks
        Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
        Matcher regexMatcher = regex.matcher(input);

        List<String> matchList = new ArrayList<String>();
        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }

        return matchList;
    }
    
    public static String getStringRepresentation(List<String> input, int start, int end){
        String result = String.join(" ", input.subList(start, end));
        
        return result;
    }
}
