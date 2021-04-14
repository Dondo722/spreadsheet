package org.example.Model;

public class CustomPeriod {
    private int month;
    private int year;
    public CustomPeriod(String string){
        int delimiter = string.indexOf(" ");
        this.month = Integer.parseInt(string.substring(0,delimiter));
        this.year = Integer.parseInt(string.substring(delimiter + 1));
    }
    public String toString(){
        return month + " months " + year + " years";
    }

    public static boolean canBe(String string){
        int delimiter = string.indexOf(" ");
        if ((string.substring(0,delimiter)).matches("[a-zA-Z]+$")) return false;
        return (!string.substring(delimiter + 1).matches("[a-zA-Z]+$"));
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
