package edu.miu.cs489.suleman.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;

    private PensionPlan pensionPlan;

    // Constructors
    public Employee() {
        // Default constructor
    }

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public void setPensionPlan(PensionPlan pensionPlan){
        this.pensionPlan = pensionPlan;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public PensionPlan getPensionPlan(){
        return this.pensionPlan;
    }

    public boolean isEligibleForUpcomingEnrollment(){
        if(Objects.isNull(this.getPensionPlan())){
            LocalDate now = LocalDate.now().plusMonths(1);
            now = now.withDayOfMonth(now.getMonth().length(now.isLeapYear()));
            long employmentTenure = ChronoUnit.YEARS.between(
                    this.employmentDate,
                    now);
            System.out.println(employmentTenure);
            return Objects.isNull(this.getPensionPlan().getEnrollmentDate()) && employmentTenure >= 5;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }

}
