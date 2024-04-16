package Controller;

import Model.EmployeeModel;
import View.EmployeeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private List<EmployeeModel> employees;
    private EmployeeView view;

    public EmployeeController() {
        employees = new ArrayList<>();
        view = new EmployeeView();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee(scanner);
                    break;
                case 3:
                    deleteEmployee(scanner);
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    searchEmployee(scanner);
                    break;
                case 6:
                    view.displayMessage("Exiting the program...");
                    return;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addEmployee() {
        EmployeeModel employee = view.getEmployeeInput();
        employees.add(employee);
        view.displayMessage("Employee added successfully.");
    }

    private void updateEmployee(Scanner scanner) {
        view.displayMessage("Enter the employee ID to update: ");
        String employeeId = scanner.nextLine();

        EmployeeModel employee = employees.stream()
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElse(null);

        if (employee == null) {
            view.displayMessage("Invalid employee ID. Employee not found.");
            return;
        }

        EmployeeModel updatedEmployee = view.getUpdatedEmployeeInput(employee);
        int index = employees.indexOf(employee);
        employees.set(index, updatedEmployee);

        view.displayMessage("Employee updated successfully.");
    }

    private void deleteEmployee(Scanner scanner) {
        view.displayMessage("Enter the employee ID to delete: ");
        String employeeId = scanner.nextLine();

        boolean isDeleted = employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .map(employee -> {
                    employees.remove(employee);
                    return true;
                })
                .orElse(false);

        if (isDeleted) {
            view.displayMessage("Employee deleted successfully.");
        } else {
            view.displayMessage("Invalid employee ID. Employee not found.");
        }
    }

    private void displayEmployees() {
        employees.stream()
                .forEach(view::displayEmployee);
    }

    private void searchEmployee(Scanner scanner) {
        view.displayMessage("Enter the employee ID to search: ");
        String employeeId = scanner.nextLine();

        employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .ifPresentOrElse(
                    view::displayEmployee,
                    () -> view.displayMessage("Invalid employee ID. Employee not found.")
                );
    }
}