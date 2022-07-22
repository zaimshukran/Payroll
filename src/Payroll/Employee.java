package Payroll; //Enclosed in Payroll package

public class Employee
{
    private String empName, empNo, hireDate;
    /*To enforce the structure of employee number.*/
    public static final String regexEmpNo = "[0-9][0-9][0-9][-][hapsHAPS]";
    /*To enforce structure of hire date.*/
    public static final String regexHireDate = "^((0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])\\/\\d{4})";

    /*Constructor with no arguments, default constructor.*/
    public Employee()
    {
        empName = "";
        empNo = "";
        hireDate = "";
    }

    /*Constructor with arguments to set value of variables to the parameters.*/
    public Employee(String empName, String empNo, String hireDate)
    {
        this.empName = empName;
        this.empNo = empNo;
        this.hireDate = hireDate;
    }

    /*Getter method to get empName.*/
    public String getEmpName()
    {
        return empName;
    }

    /*Getter method to get empNo.*/
    public String getEmpNo()
    {
        return empNo;
    }

    /*Getter method to get hireDate.*/
    public String getHireDate()
    {
        return hireDate;
    }

    /*Setter method to set empName.*/
    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    /*Setter method to set empNo.*/
    public void setEmpNo(String empNo)
    {
        this.empNo = empNo;
    }

    /*Setter method to set hireDate.*/
    public void setHireDate(String hireDate)
    {
        this.hireDate = hireDate;
    }

    /*Method to find the department of the employee.*/
    public String empDepartment()
    {
        /*To create a variable that holds the value of the character that represents department.
        length() returns the amount of characters in the string while charAt starts at 0. Therefore,
        empNo.length()-1 is to make it so that charAt will access the character that represents department.
         */
        char empDepartment = empNo.charAt(empNo.length()-1);

        /*To identify the department from empDepartment.*/
        return switch (empDepartment) { //Switch expression
            case 'H', 'h' -> "Human Resources";
            case 'A', 'a' -> "Accounting";
            case 'P', 'p' -> "Production";
            case 'S', 's' -> "Shipping";
            default -> "";
        };
    }
}
