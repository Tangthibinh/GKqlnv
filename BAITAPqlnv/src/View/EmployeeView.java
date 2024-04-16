package View;

import Model.EmployeeModel;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private Scanner scanner;

    public EmployeeView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("----- Employee Management System -----");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Display Employees");
        System.out.println("5. Search Employee");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public EmployeeModel getEmployeeInput() {
        System.out.print("Enter Employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter Birth Day: ");
        String birthDay = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Employee Type: ");
        String employeeType = scanner.nextLine();

        System.out.print("Enter Employee Count: ");
        int employeeCount = Integer.parseInt(scanner.nextLine());

        return new EmployeeModel(employeeId, fullName, birthDay, phone, email, employeeType, employeeCount);
    }

    public void displayEmployee(EmployeeModel employee) {
        System.out.println("----- Found Employee -----");
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Full Name: " + employee.getFullName());
        System.out.println("Birth Day: " + employee.getBirthDay());
        System.out.println("Phone: " + employee.getPhoneNumber());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Employee Type: " + employee.getEmployeeType());
        System.out.println("Employee Count: " + employee.getEmployeeCount());
    }

    public void displayEmployees(List<EmployeeModel> employees) {
        System.out.println("----- Employee List -----");
        for (EmployeeModel employee : employees) {
            showInfo(employee);
            System.out.println();
        }
    }

    public void showInfo(EmployeeModel employee) {
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Full Name: " + employee.getFullName());
        System.out.println("Birth Day: " + employee.getBirthDay());
        System.out.println("Phone: " + employee.getPhoneNumber());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Employee Type: " + employee.getEmployeeType());
        System.out.println("Employee Count: " + employee.getEmployeeCount());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}