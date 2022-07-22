package Payroll; //Enclosed in Payroll package

import java.io.*; //Import the input output library
import java.util.Scanner; //Import scanner

public class Payroll
{
    public static void main(String[] args)
    {
        try{
            /*Variables to store information received from file and send them
            to the appropriate object.*/
            String empName, empNo, hireDate;
            int shiftNo;
            double hourlyPayRate;

            /*To specify the file we're working with and receive input from said file.*/
            Scanner scanner = new Scanner(new File("Information.txt"));
            /*So that we're able to write to the file indicated below.*/
            PrintWriter printWriter = new PrintWriter("Department.txt");

            /*The appropriate formatting to be printed to the console and written to the specified file.*/
            System.out.printf("%-10s%-15s%-20s%-15s%-15s%-15s\n", "Name", "Employee No", "Department", "Hire Date", "Shift Name", "Pay Rate");
            printWriter.printf("%-10s%-15s%-20s%-15s%-15s%-15s\n", "Name", "Employee No", "Department", "Hire Date", "Shift Name", "Pay Rate");
            System.out.println("-----------------------------------------------------------------------------------------");
            printWriter.println("-----------------------------------------------------------------------------------------");

            /*Read from the file aforementioned and to write that information into Department.txt*/
            while(scanner.hasNext()) //Checks if scanner has another token in its input
            {
                empName = scanner.next(); //Scans employee name
                empNo = scanner.next(); //Scans employee number
                if(!empNo.matches(Employee.regexEmpNo)){ //Checks whether employee number matches employee number regex
                    throw new Exception("Invalid employee number.");
                }
                hireDate = scanner.next(); //Scans hire date
                if (!hireDate.matches(Employee.regexHireDate)) { //Checks whether hire date matches hire date regex
                    throw new Exception("Invalid hire date.");
                }
                shiftNo = scanner.nextInt(); //Scans shift number

                if(shiftNo != 0) //For production workers
                {
                    hourlyPayRate = scanner.nextDouble(); //Scans hourly pay rate
                    ProductionWorker productionWorker = new ProductionWorker(shiftNo, hourlyPayRate, empName, empNo, hireDate); //Creates object of production worker

                    /*Prints production worker information into console and writes into Department.txt*/
                    System.out.printf("%-10s%-15s%-20s%-15s%-15s%s%.2f\n", productionWorker.getEmpName(), productionWorker.getEmpNo(), productionWorker.empDepartment(), productionWorker.getHireDate(), productionWorker.shift(), "RM", productionWorker.getHourlyPayRate());
                    printWriter.printf("%-10s%-15s%-20s%-15s%-15s%s%.2f\n", productionWorker.getEmpName(), productionWorker.getEmpNo(), productionWorker.empDepartment(), productionWorker.getHireDate(), productionWorker.shift(), "RM", productionWorker.getHourlyPayRate());
                }else{ //For non-production workers
                    Employee employee = new Employee(empName, empNo, hireDate); //Creates object of employee

                    /*Prints employee information into console and writes into Department.txt*/
                    System.out.printf("%-10s%-15s%-20s%-15s\n", employee.getEmpName(), employee.getEmpNo(), employee.empDepartment(), employee.getHireDate());
                    printWriter.printf("%-10s%-15s%-20s%-15s\n", employee.getEmpName(), employee.getEmpNo(), employee.empDepartment(), employee.getHireDate());
                }
            }
            scanner.close(); //Close scanner
            printWriter.close(); //Close print writer

        } catch (Exception e){ //Catch exceptions
            System.out.println(e.getMessage()); //Prints error message
            e.printStackTrace(); //Specifies error that occurred and location of occurrence
        }
    }
}
