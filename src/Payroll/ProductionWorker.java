package Payroll; //Enclosed in Payroll package

public class ProductionWorker extends Employee
{
    private int shiftNo;
    private double hourlyPayRate;

    /*Constructor with no arguments, default constructor.
    It also calls the default constructor of its super class, Employee.*/
    public ProductionWorker()
    {
        super();
        shiftNo = 0;
        hourlyPayRate = 0.0;
    }

    /*Constructor with arguments to set value of variables to the parameters.
    It also calls the parameterised constructor of its super class, Employee.*/
    public ProductionWorker(int shiftNo, double hourlyPayRate, String empName, String empNo, String hireDate)
    {
        super(empName, empNo, hireDate);
        this.shiftNo = shiftNo;
        this.hourlyPayRate = hourlyPayRate;
    }

    /*Getter method to get shiftNo.*/
    public int getShiftNo()
    {
        return shiftNo;
    }

    /*Getter method to get hourlyPayRate.*/
    public double getHourlyPayRate()
    {
        return hourlyPayRate;
    }

    /*Setter method to set shiftNo.*/
    public void setShiftNo(int shiftNo)
    {
        this.shiftNo = shiftNo;
    }

    /*Setter method to set hourlyPayRate.*/
    public void setHourlyPayRate(double hourlyPayRate)
    {
        this.hourlyPayRate = hourlyPayRate;
    }

    /*Method to find the production worker's shift.*/
    public String shift()
    {
        return switch (this.shiftNo) { //Switch expression
            case 1 -> "Morning Shift";
            case 2 -> "Swing Shift";
            case 3 -> "Night Shift";
            default -> "";
        };
    }
}
