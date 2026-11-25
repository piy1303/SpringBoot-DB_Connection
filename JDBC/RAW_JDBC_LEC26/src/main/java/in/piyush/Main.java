package in.piyush;

import in.piyush.model.Employer;
import in.piyush.repository.EmployerRepo;

import java.sql.Connection;
import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployerRepo employerRepo = new EmployerRepo();

//        employerRepo.createEmployer();

          employerRepo.createEmployer1(new Employer("shivam" , "shivam@gmail.com" , 22));

//        employerRepo.updateEmployer();

//        employerRepo.deleteEmployer();

//        employerRepo.getAllEmployer();

//        employerRepo.getEmployerByID();
    }
}
