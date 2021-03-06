package io.zipcoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Problem6 {
    //Step 1: convert given 12 hour numerical format into 24 hours format
    //use SimpleDateFormat to format input to 24 hours

    String[] units = {"Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty"};
    public String convertTo24Hours(String input) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = parseFormat.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return displayFormat.format(date);
    }

    //Step 2: convert the 24 hour format into military time phrase in string format
    //after the first two digit, add "Hundred and" to the end
    //add Hours at the end of each string
    public String convertToMilitaryTime(String input){
        String formattedInput = convertTo24Hours(input);
        String[] time= formattedInput.split(":");
        String hour = convertToWords(time[0]);
        String minute=convertToWords(time[1]);
        return hour + " Hundred and " + minute + " Hours";


    }
    public String convertToWords(String input){
        int num = Integer.parseInt(input);
        String word="";
        if(num<10){
            word+=units[0]+" "+units[num];
        }
        if(num<20 && num>=10){
            word+=units[num];
        }
        if(num>=20){
            if(num%10==0){
                word+=tens[num/10];
            }
            else {
                word += tens[num / 10] + " " + units[num % 10];
            }
        }
        return word;
    }
}
