package eventorganizer;

import java.util.Calendar;

/**
 Date class: Manages and validates dates, allowing for comparison and future date checking.
 @author Sreekruthi Dubagunta, Shatakshi Ranjan
 */
public class Date implements Comparable<Date> {

    private int year;
    private int month;
    private int day;

    private static final int MIN_DAY = 1;
    private static final int[] MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int FEBRUARY = 2;


    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUATERCENTENNIAL = 400;

    private static final int SEMIANNUAL = 6;

    /**
     * Date constructor
     * @param year of Date
     * @param month of Date
     * @param day of Date
     */
    public Date(int year, int month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Method to get year of Date
     * @return year of Date
     */
    public int getYear() {
        return year;
    }

    /**
     * Method to get month of Date
     * @return month of Date
     */
    public int getMonth() {
        return month;
    }

    /**
     * Method to get day of Date
     * @return day of Date
     */
    public int getDay() {
        return day;
    }

    /**
     * Method to return if Date is valid
     * @return if Date is valid
     */
    public boolean isValid() {
        if (month < MIN_MONTH || month > MAX_MONTH)
            return false;
        if (day < MIN_DAY || day > MAX_DAYS[month])
            return false;
        if (month == FEBRUARY) {
            if (year % QUADRENNIAL == 0) {
                if (year % CENTENNIAL == 0 && year % QUATERCENTENNIAL != 0 && day >= MAX_DAYS[month]) {
                    return false;
                }
            } else if (day >= MAX_DAYS[month]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to compare Date with other Date
     * @param other other Date
     * @return integer comparing Date and other Date
     */
    @Override
    public int compareTo(Date other) {
        if (year != other.year) {
            return year - other.year;
        } else {
            if (month != other.month)
                return month - other.month;
            else
                return day - other.day;
        }
    }

    /**
     * Return String representation of Date
     * @return String representation of Date
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Get if Date is in the future
     * @return if Date is in the future
     */
    public boolean isFuture() {
        Date today = new Date(Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH) + 1,
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        return compareTo(today) > 0;
    }

    /**
     * Get if Date is within 6 months
     * @return if Date is within 6 months
     */
    public boolean isWithin6Months() {
        int Within = 6;
        Calendar today = Calendar.getInstance();
        Calendar sixMonthsLater = Calendar.getInstance();
        sixMonthsLater.add(Calendar.MONTH, Within);

        Calendar eventDate = Calendar.getInstance();
        eventDate.set(year, month - 1, day);

        return eventDate.compareTo(today) >= 0 && eventDate.compareTo(sixMonthsLater) <= 0;
    }

    /**
     * Date class Testbed
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Date d;
        d = new Date(2023,0,1);
        boolean expectedOutput = false;
        boolean actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);


        d = new Date(2023,1,1);
        expectedOutput = true;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,13,1);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,1,0);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,1,32);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,4,31);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,2,31);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,2,30);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,2,29);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2023,2,28);
        expectedOutput = true;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2024,2,30);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2024,2,31);
        expectedOutput = false;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);

        d = new Date(2024,2,29);
        expectedOutput = true;
        actualOutput = d.isValid();
        System.out.println("Date:" + d + ", Expected Output:" + expectedOutput + ", Actual Output:" + actualOutput);
    }
}

