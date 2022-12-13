/*
Create a class called Date that includes three pieces of information as instance variables—a month (type int), a day (type int), and a year (type int).
Your class should have a constructor that initializes the three instance variables and assumes that the values (and date constructed from these variables) provided are correct.
Provide a set and a get method for each instance variable.
Implement checks for date validity when setting any variable.
Provide a method displayDate that displays the month, day, and year separated
by forward slashes (/). Write a test application named DateTest that demonstrates class Date’s  capabilities. */

import java.io.*;

public class Date {
    private int month;
    private int day;
    private int year;
    
    
    public Date()
    {
    month = 12;
    day = 13;
    year = 2022;
    }

    public int getMonth(){
        return month;
    }


    public void setMonth(int newMonth)
    {
        try
        {
            if (newMonth > 12 || newMonth < 1)
            {
                throw new IllegalArgumentException("The value is out of range.");
            }
            this.month = newMonth;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException();
        }
    }
    public int getDay(){
        return day;
    }


    public void setDay(int newDay)
    {
        try
        {
            if (newDay > 31 || newDay < 1)
            {
                throw new IllegalArgumentException("The value is out of range.");
            }
            this.month = newDay;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException();
        }
    }
    public int getYear(){
        return year;
    }


    public void setYear(int newYear)
    {
        try
        {
            if (newYear > 12 || newYear < 1)
            {
                throw new IllegalArgumentException("The value is out of range.");
            }
            this.month = newYear;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException();
        }
    }
    
    public String displayDate()
    {
    	return "The current date is " + getDay() + "." + getMonth() + "." + getYear();
    }
}
