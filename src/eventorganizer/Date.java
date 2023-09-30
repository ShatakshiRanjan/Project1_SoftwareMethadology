package eventorganizer;

import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(){
        Calendar today = Calendar.getInstance();
        this.year = today.get(1);
        this.month = today.get(2) + 1;
        this.day = today.get(5);
    }

    public Date getToday(){
        Calendar today = Calendar.getInstance();
        int year = today.get(1);
        int month = today.get(2) + 1;
        int day = today.get(5);
        Date t = new Date(month, day, year);
        return t;
    }

    public Date(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public Date(String date) {
        String[] arrOfStr = date.split("/", 3);
        String m = arrOfStr[0];
        String d = arrOfStr[1];
        String y = arrOfStr[2];
        this.month = Integer.parseInt(m);
        this.day = Integer.parseInt(d);
        this.year = Integer.parseInt(y);
    }

    public boolean isValidMonth() {
        return this.month >= 1 && this.month <= 12;
    }

    public boolean isValidDay() {
        if ((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) && this.day <= 31 && this.day >= 1) {
            return true;
        } else if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && this.day <= 30 && this.day >= 1) {
            return true;
        } else if (this.month == 2 && this.isLeapYear() && this.day <= 29 && this.day >= 1) {
            return true;
        } else {
            return this.month == 2 && !this.isLeapYear() && this.day <= 28 && this.day >= 1;
        }
    }

    public boolean isLeapYear() {
        int year = this.year; // Assuming 'year' is a class variable

        boolean isLeapYear = false;

        // Leap years are divisible by 4
        if (year % 4 == 0) {
            isLeapYear = true;

            // But if it's also divisible by 100, it's not a leap year unless it's also divisible by 400
            if (year % 100 == 0 && year % 400 != 0) {
                isLeapYear = false;
            }
        }
        return isLeapYear;
    }

    public boolean isValid() {
        return this.isValidDay() && this.isValidMonth();
    }

    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Date)) {
            return false;
        } else {
            Date date = (Date)other;
            return this.day == date.day && this.month == date.month && this.year == date.year;
        }
    }

    public int compareTo(Date other) {
        if(this.year > other.year){
            return 1;
        } else if(this.month > other.month){
            return -1;
        } else if(this.month < other.month){
            return 1;
        } else if(this.day < other.day){
            return -1;
        } else if(this.day > other.month) {
            return 1;
        } else {
            return this.day < other.month ? 1:0;
        }
    }
}
