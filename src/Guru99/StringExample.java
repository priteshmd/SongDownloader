package Guru99;

import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;

public class StringExample
{
     
    public static String titleCaseConversion(String inputString) 
    {
        if (StringUtils.isBlank(inputString)) {
            return "";
        }
 
        if (StringUtils.length(inputString) == 1) {
            return inputString.toUpperCase();
        }
 
        StringBuffer resultPlaceHolder = new StringBuffer(inputString.length());
 
        Stream.of(inputString.split(" ")).forEach(stringPart -> {
            char[] charArray = stringPart.toLowerCase().toCharArray();
            charArray[0] = Character.toUpperCase(charArray[0]);
            resultPlaceHolder.append(new String(charArray)).append(" ");
        });
 
        return StringUtils.trim(resultPlaceHolder.toString());
    }
}