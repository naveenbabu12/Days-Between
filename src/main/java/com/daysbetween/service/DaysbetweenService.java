package com.daysbetween.service;

import org.springframework.stereotype.Service;

@Service
public class DaysbetweenService {
	
    /**
     * Static date class has day 'dd', month 'mm' and year 'yy' properties
     * @author naveen
     *
     */
	static class Date
    {
        int dd, mm, yy;
 
        public Date(int dd, int mm, int yy)
        {
            this.dd = dd;
            this.mm = mm;
            this.yy = yy;
        }
 
    };
 
    // To show months in words
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    static String[] ordinal = {"st", "nd", "rd", "th"};

    // To store number of days in all months from January to Dec.
    static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 
    /**
     * Returns counts number of leap years before the given date
     * @param d
     * @return
     */
    static int countLeapYears(Date d)
    {
        int years = d.yy;
 
        // Check if the current year needs to be considered
        // for the count of leap years or not
        if (d.mm <= 2)
        {
            years--;
        }
 
        // An year is a leap year if it is a multiple of 4,
        // multiple of 400 and not a multiple of 100.
        return years / 4 - years / 100 + years / 400;
    }
 
    /**
     * Returns number of days between two given dates
     * @param dt1
     * @param dt2
     * @return
     */
    static int getDifference(Date dt1, Date dt2)
    {
        // COUNT TOTAL NUMBER OF DAYS BEFORE FIRST DATE 'dt1'
 
        // initialize count using years and day
        int n1 = dt1.yy * 365 + dt1.dd;
 
        // Add days for months in given date
        for (int i = 0; i < dt1.mm - 1; i++)
        {
            n1 += monthDays[i];
        }
 
        // Since every leap year is of 366 days,
        // Add a day for every leap year
        n1 += countLeapYears(dt1);
 
        // SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE 'dt2'
        int n2 = dt2.yy * 365 + dt2.dd;
        for (int i = 0; i < dt2.mm - 1; i++)
        {
            n2 += monthDays[i];
        }
        n2 += countLeapYears(dt2);
 
        // return difference between two counts
        return (n2 - n1);
    }
 
    /**
     * Returns days between from and to dates
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public int getDays(String dateFrom, String dateTo)
    {
    	String[] dtFr = dateFrom.split("\\/");
    	String[] dtTo = dateTo.split("\\/");
    	
        Date dt1 = new Date(Integer.parseInt(dtFr[0]), Integer.parseInt(dtFr[1]), Integer.parseInt(dtFr[2]));
        Date dt2 = new Date(Integer.parseInt(dtTo[0]), Integer.parseInt(dtTo[1]), Integer.parseInt(dtTo[2]));
        int days = getDifference(dt1, dt2);
        System.out.println("Difference between two dates is " + days);
        return days;
    }
    
    /**
     * Prepare date in to word format
     * @param date
     * @return
     */
    public String dateToWordFormat(String date) {
    	
    	String[] dt = date.split("\\/");
    	String month = months[Integer.parseInt(dt[1])-1];
    	String day = "";
    	
    	if (Integer.parseInt(dt[0]) < 4) {
    		day = dt[0]+ordinal[Integer.parseInt(dt[0])-1];
    	} else {
    		day = dt[0]+ordinal[3];
    	}
    	return "".concat(month).concat(" ").concat(day).concat(" ").concat(dt[2]);
    }

    /**
     * Prepare formatted output
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public String prepareOutput(String dateFrom, String dateTo) {
    	String output = "";
		String dtFr = dateToWordFormat(dateFrom);
		String dtTo = dateToWordFormat(dateTo);
		String days = String.valueOf(getDays(dateFrom, dateTo));
		output = output.concat("<b>Output: </b>The number of days between <b>").concat(dtFr).concat(" and ").concat(dtTo).concat(" is </b>").concat(days).concat(" days<br /><br /><br />");
    	return output;
    }
    
   /*
    public static void main(String[] args)
    {
        Date dt1 = new Date(1, 2, 2000);
        Date dt2 = new Date(1, 2, 2004);
        System.out.println("Difference between from and to dates is " + getDifference(dt1, dt2));
    }
    */
}
