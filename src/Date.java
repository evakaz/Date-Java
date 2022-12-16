/*
Create a class called Date that includes three pieces of information as instance variables—a month (type int), a day (type int), and a year (type int).
Your class should have a constructor that initializes the three instance variables and assumes that the values (and date constructed from these variables) provided are correct.
Provide a set and a get method for each instance variable.
Implement checks for date validity when setting any variable.
Provide a method displayDate that displays the month, day, and year separated
by forward slashes (/). Write a test application named DateTest that demonstrates class Date’s  capabilities. */

import java.io.*;
import java.util.*;

public class Date {
    private int month;
    private int day;
    private int year;
    private final int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

   
    public Date(int day, int month, int year)
    {
    	check(day, month, year);
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }
    
    private void check(int day, int month, int year) {
    	if (year < 0)
        {
            throw new IllegalArgumentException("The value is out of range.");
        }
    	if (month < 1 || month > 12) {
    		throw new IllegalArgumentException("The value is out of range.");
    	}
    	if (year % 4 == 0)
    	{
    		daysPerMonth[1] = 29;
    	}
    	int maxNumDays = daysPerMonth[month-1];
    	if (day > maxNumDays || day < 1)
        {
            throw new IllegalArgumentException("The value is out of range.");
        }
    }
    


    public int getMonth(){
        return month;
    }


    public void setMonth(int newMonth)
    {
    	check(day, newMonth, year);
		this.month = newMonth;
	}
    
    
    public int getDay(){
        return day;
    }


    public void setDay(int newDay)
    {
    	check(newDay, month, year);
        this.month = newDay;
    }

    public int getYear() {
        return year;
    }


    public void setYear(int newYear)
    {
    	check(day, month, newYear);
        this.month = newYear;
    }
    
    public String displayDate()
    {
    	return "The current date is " + getDay() + "/" + getMonth() + "/" + getYear();
    }
}
