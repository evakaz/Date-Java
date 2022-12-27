/*
Create a class called Date that includes three pieces of information as instance variables—a month (type int), a day (type int), and a year (type int).
Your class should have a constructor that initializes the three instance variables and assumes that the values (and date constructed from these variables) provided are correct.
Provide a set and a get method for each instance variable.
Implement checks for date validity when setting any variable.
Provide a method displayDate that displays the month, day, and year separated
by forward slashes (/). Write a test application named DateTest that demonstrates class Date’s  capabilities. 
It is not allowed to use built-in date functions in Java. 
Create a function, that allows add days to the current date.
Create a function, that allows subtract days to the current date.
*/

public class Date {
    private int month;
    private int day;
    private int year;
    private final static int[] DAYS_PER_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

   
    public Date(int day, int month, int year) {
    	check(day, month, year);
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }
    
    
    private int getMaxNumDays(int myMonth, int myYear) {
    	int maxNumDays = DAYS_PER_MONTH[myMonth-1];
    	if (myYear % 4 == 0 && myMonth == 2) {
    		maxNumDays = 29;
    	}
    	return maxNumDays;
    	
    }
    
    private void check(int day, int month, int year) {
    	if (year < 0) {
            throw new IllegalArgumentException("The value is out of range.");
        }
    	if (month < 1 || month > 12) {
    		throw new IllegalArgumentException("The value is out of range.");
    	}
    	if (day > getMaxNumDays(month, year) || day < 1) {
            throw new IllegalArgumentException("The value is out of range.");
        }
    }
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int newMonth) {
    	check(day, newMonth, year);
		this.month = newMonth;
	}
    
    public int getDay() {
        return day;
    }

    public void setDay(int newDay) {
    	check(newDay, month, year);
        this.month = newDay;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int newYear) {
    	check(day, month, newYear);
        this.month = newYear;
    }
    
    public String displayDate() {
    	return "The current date is " + getDay() + "/" + getMonth() + "/" + getYear();
    }
    
    public void subsctractDays(int subDay) {
    	if(subDay >= 0) {
		int maxNumDays = getMaxNumDays(this.month, this.year); 
		this.day = this.day - subDay;
		while (this.day <= 0) {
			this.month--;
			while(this.month <= 0) {
				this.year--;
				this.month = 12;
			}
			this.day = getMaxNumDays(this.month, this.year) + this.day;
		}
	}
	else {
		throw new IllegalArgumentException("The value cannot be negative.");
	}
    }
    
    public void addDay(int addedDay) {
    	if (addedDay > 0) {
    		int maxNumDays = getMaxNumDays(this.month, this.year);
    	
	        this.day = this.day + addedDay;
	        while (this.day > maxNumDays) {
	        	this.month++;
	            this.day = this.day - maxNumDays; 
	            if (this.month > 12) {
	            	this.year++;
	            	this.month = 1; 
	            }
	        }
            maxNumDays = getMaxNumDays(this.month, this.year);
    	}
    	else {
    		subscDays(-addedDay);
    	}
    }
}
