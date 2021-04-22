package org.example.Model;

public class CustomPeriod {
    private int month;
    private int year;
    public CustomPeriod(String string){
        CustomPeriod period = getPeriod(string);
        this.month = period.getMonth();
        this.year = period.getYear();
    }
    public CustomPeriod(int year, int month){
        this.year = year;
        this.month = month;
    }
    public String toString(){
        return  year + "y " + month + "m";
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
        int year = Integer.parseInt(string.substring(0,string.indexOf("y")));
        int month = Integer.parseInt(string.substring(string.indexOf(" ") + 1,string.indexOf("m")));
        return new CustomPeriod(year,month);
    }

    public static CustomPeriod createPeriod(String string){
        int year = Integer.parseInt(string.substring(0,string.indexOf(" ")));
        int month = Integer.parseInt(string.substring(string.indexOf(" ") + 1));
        return new CustomPeriod(year,month);
    }

    public static boolean canBe(String string){
        try{
            Integer.parseInt(string.substring(0,string.indexOf(" ")));
            Integer.parseInt(string.substring(string.indexOf(" ") + 1));
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
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
