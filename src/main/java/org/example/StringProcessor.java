package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    public static String extractEmail(String sender){

        Pattern mailPattern = Pattern.compile(".*<(.*@[a-z]+\\.[a-z]+)>");
        Matcher matcher = mailPattern.matcher(sender);
        if(matcher.find()) {
            return matcher.group(1);
        }

        return "";
    }

    public static Set <String> getUniqueMails(ArrayList<String> mails){
        return new HashSet<>(mails);
    }

    public static ArrayList<String> getPrivateMails(){
        return null;
    }

    public static ArrayList<String> getBusinessMails(){
        return null;
    }
}
