package org.example.Model;

public class CustomPeriod {
    private int month;
    private int year;
    public CustomPeriod(String string){
        int delimiter = string.indexOf(" ");
        this.year = Integer.parseInt(string.substring(0,delimiter));
        this.month = Integer.parseInt(string.substring(delimiter + 1));
    }
    public CustomPeriod(int year, int month){
        this.year = year;
        this.month = month;
    }
    public String toString(){
        return  year + " year " + month + " month";
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

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static CustomPeriod getPeriod(String string){
        int delimiter = string.indexOf(" year ");
        int year = Integer.parseInt(string.substring(0,delimiter));
        delimiter += 6;
        int month = Integer.parseInt(string.substring(delimiter,string.lastIndexOf(" month")));
        return new CustomPeriod(year,month);
    }

    public boolean moreThan(CustomPeriod period){
        if(this.getYear() > period.getYear()) return true;
        else if(this.getYear() < period.getYear()) return  false;
        return this.getMonth() > period.getMonth();
    }
    public boolean moreOrEqualThan(CustomPeriod period){
        if(this.getYear() >= period.getYear()) return true;
        else if(this.getYear() < period.getYear()) return  false;
        return this.getMonth() >= period.getMonth();
    }

}
