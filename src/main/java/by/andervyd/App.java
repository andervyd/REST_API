package by.andervyd;

import by.andervyd.configuration.Config;
import by.andervyd.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {

    private static Long count = Long.valueOf(0);

    public static void main( String[] args ) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Communication communication = context.getBean("communication", Communication.class);

    // get all employees:
        List<Employee> allEmployees = communication.getAllEmployees();

        System.out.println("List employee:\n");
        for(Employee employee : allEmployees) {
            System.out.println(employee);

            count++;
        }
        System.out.println("\nTotal count employee: " + count);

System.out.println("\n------------------------------------------------------------\n");

    // get one employee by id
        Employee employeeById = communication.getEmployee((long) 3);
        System.out.println("Employee: " + employeeById);

System.out.println("\n------------------------------------------------------------\n");

    // save new employee
        Employee newEmployee = new Employee("Sveta", "Sokolova", "HR", 1600);
        communication.saveEmployee(newEmployee);

System.out.println("\n------------------------------------------------------------\n");

    // update employee
        Employee updateEmployee = new Employee("Sveta", "Sokolova", "HR", 1800);
        updateEmployee.setId((long) 15);
        communication.saveEmployee(updateEmployee);

System.out.println("\n------------------------------------------------------------\n");

    // delete employee
        communication.deleteEmployee((long) 16);
    }
}
