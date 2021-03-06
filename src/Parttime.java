/**
 * used to create a parttime employee
 * @author Malav Doshi and Herik Patel
 */
public class Parttime extends Employee{

    /**
     * Represents hourly wage for an employee
     */
    private double hourlyPayRate;
    /**
     * Represents payment for the an employee
     */
    private double payment = 0;
    /**
     * Represents total hours an employee worked
     */
    private int hours;
    /**
     * Represents how many extra hours an employee worked
     */
    private int extraHours;
    /**
     * Constructor for the class Parttime
     */
    public Parttime(){
    }

    /**
     * Constructor for the class Parttime used to instantiate values
     * @param profile Profile of an employee
     * @param hourlyPayRate Hourly pay rate of a part time employee
     */
    public Parttime(Profile profile, double hourlyPayRate){
        super(profile);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * This method is used to set hours for part time employee
     * @param hours time which we want to set for an employee
     */
    public void setHours(int hours){
        this.hours = hours;
    }

    /**
     * This method is used to get number of hours an employee worked
     * @return number of hours of an employee
     */
    public int getHours(){
        return hours;
    }

    /**
     * This method is used to calculate payment for the part-time employee
     */
    @Override
    public void calculatePayment() {

        double extraPayment;
        int maxHours = 80;
        double extraRate = 1.5;

        if(hours > maxHours){ //Extra hours to be paid 1.5x hourly rate
            payment = maxHours * hourlyPayRate;
            extraHours = this.hours - maxHours;
            extraPayment = extraHours * extraRate * hourlyPayRate;
            payment += extraPayment;
            payment = Math.round(payment * 100.0) / 100.0;
            return;
        }

        payment = this.hours * hourlyPayRate;
        payment = Math.round(payment * 100.0) / 100.0;
    }


    /**
     * This method is used to compare objects to see if the employee is already present in the database
     * @param obj Object to be compared
     * @return True if obj is same as the compared object. False otherwise.
     */
    @Override
    public boolean equals(Object obj){

        if(obj instanceof Parttime){
            return super.equals(obj);
        }
        return false;
    }


    /**
     * This method is used to convert fields such as payment and hourly rate to string and other info is obtained from the parent class
     * @return string with all the info of a parttime employee
     */
    @Override
    public String toString(){
        return super.toString() + "::Payment $" + payment + "::PART TIME:: Hourly Rate $" + hourlyPayRate + "::Hours worked this period: " + this.hours;
    }
}
