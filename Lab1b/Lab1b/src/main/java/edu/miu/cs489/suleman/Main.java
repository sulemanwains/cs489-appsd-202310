package edu.miu.cs489.suleman;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs489.model.Employee;
import edu.miu.cs489.model.PensionPlan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.stream(new Employee[]{
                new Employee(1,"Daniel","Agar",LocalDate.of(2018,01,17),105945.50),
                new Employee(2,"Benard","Shaw",LocalDate.of(2018,10,03),19750.00),
                new Employee(3,"Carly","Agar",LocalDate.of(2014,05,16),842000.75),
                new Employee(4,"Wesley","Schneider",LocalDate.of(2018,11,02),74500.00),

        }).toList();
        employees.get(0).setPensionPlan(new PensionPlan("EX1089",LocalDate.of(2023,01,17),100.00));
        employees.get(1).setPensionPlan(new PensionPlan("",null,000.00));
        employees.get(2).setPensionPlan(new PensionPlan("SM2307",LocalDate.of(2019,11,04),155.50));
        employees.get(3).setPensionPlan(new PensionPlan("",null,000.00));

        try{
            printEmployeeWithPensionPlanByLastNameAndYearlySalary(employees);
            monthlyUpcomingEnrollees(employees);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    public static void monthlyUpcomingEnrollees(List<Employee> employees) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //Filtering employees
        employees = employees.stream().filter(Employee::isEligibleForUpcomingEnrollment).toList();
        //Srting Employees
        employees = employees.stream().sorted(Comparator.comparing(Employee::getEmploymentDate)).toList();
        System.out.println("\n\nMonthly Upcoming Enrollees List (By Enrollment Date)\n--------------------\n");
        System.out.println(mapper.writeValueAsString(employees));
        System.out.println("\n--------------------------\n\n");
    }
    public static void printEmployeeWithPensionPlanByLastNameAndYearlySalary(List<Employee> employees) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //let's sort employees
        employees = employees.stream().sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2,o1);
            }
        })).toList();
        System.out.println("\n\nEmployees List with Pension Plan (By Last name and yearly Salary)\n--------------------\n");
        System.out.println(mapper.writeValueAsString(employees));
        System.out.println("\n--------------------------\n\n");
    }


}