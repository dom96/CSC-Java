package prac5;

import java.text.DecimalFormat;

public class HourlyEmployee extends FullTimeEmployee implements Comparable<HourlyEmployee>
{      
    // for full-time hourly employees

    public final static int MAX_REGULAR_HOURS = 40;

    public final static double OVERTIME_FACTOR = 1.5;

    protected int hoursWorked;

    protected double payRate,    
                     regularPay,
                     overtimePay;
                     
    /**
     *  Initializes this full-time HourlyEmployee object to have an empty string for
     *  the name, 0 for hours worked, 0.00 for the pay rate, grossPay, regularPay
     *  and overtimePay.
     *
     */
    public HourlyEmployee()
    {
        hoursWorked = 0;
        payRate = 0.00;
        regularPay = 0.00;
        overtimePay = 0.00;
    } // default constructor

    
    /**
     *  Initializes this full-time HourlyEmployee object's name and gross pay from a
     *  a specified name, hours worked and pay rate.  If the hours worked is
     *  at most MAX_REGULAR_HOURS, the gross pay is the hours worked times 
     *  the pay rate. Otherwise, the gross pay is MAX_REGULAR_HOURS time the
     *  pay rate, plus the pay rate times OVERTIME_FACTOR for all overtime hours.
     *
     *  @param name - the specified name.
     *  @param hoursWorked - the specified hours worked.     
     *  @param payRate - the specified pay rate.
     *
     */ 
    public HourlyEmployee (String name, int hoursWorked, double payRate) 
    {        
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;

        if (hoursWorked <= MAX_REGULAR_HOURS)
        {
            regularPay = hoursWorked * payRate;
            overtimePay = 0.00;
        } // if
        else
        {
            regularPay = MAX_REGULAR_HOURS * payRate;
            overtimePay = (hoursWorked - MAX_REGULAR_HOURS) * 
                                    (payRate * OVERTIME_FACTOR);            
        } // else    
        grossPay = regularPay + overtimePay;
    } // 3-parameter constructor


    /**
     *  Returns the hours worked by this full-time HourlyEmployee object.     
     *
     *  @return the hours worked by this full-time HourlyEmployee object.
     * 
     */
    public int getHoursWorked()
    {
        return hoursWorked;
    } // method getHoursWorked


    /**
     *  Returns the pay rate of this full-time HourlyEmployee object.     
     *
     *  @return the pay rate this full-time HourlyEmployee object.
     * 
     */
    public double getPayRate()
    {
        return payRate;
    } // method getPayRate
    
    
    /**
     *  Returns the regular pay of this full-time HourlyEmployee object.     
     *
     *  @return the regular pay this full-time HourlyEmployee object.
     * 
     */
    public double getRegularPay()
    {
        return regularPay;
    } // method getRegularPay
    
    
    /**
     *  Returns the overtime pay of this full-time HourlyEmployee object.     
     *  @return the overtime pay this full-time HourlyEmployee object.
     * 
     */
    public double getOvertimePay()
    {
        return overtimePay;
    } // method getOvertimePay
           
    
    /**
     *  Returns a String representation of this full-time HourlyEmployee object with the 
     *  name followed by a space followed by a dollar sign followed by the gross pay 
     *  (with two fractional digits) followed by " FULL TIME HOURLY".
     *
     *  @return a String representation of this full-time HourlyEmployee object.
     *
     */  
    public String toString()
    {       
        //final String FULL_TIME_STATUS = " HOURLY";
        
        return super.toString() ;
    } // method toString

    public int compareTo(HourlyEmployee compareEmp) {
    	if (grossPay != compareEmp.grossPay) {
    		return Double.compare(grossPay, compareEmp.grossPay);
    	}
    	
    	if (hoursWorked != compareEmp.hoursWorked) {
    		return Double.compare(hoursWorked, compareEmp.hoursWorked);
    	}
    	
    	return name.compareTo(compareEmp.name);
 
	}	

} // class HourlyEmployee
