package edu.miu.cs489.suleman;

import edu.miu.cs489.suleman.model.Employee;
import edu.miu.cs489.suleman.model.PensionPlan;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        var employees = new Employee[]{
                new Employee(333,"Daniel","Agar",LocalDate.of(2018,01,17),105945.50),
                new Employee(444,"Benard","Shaw",LocalDate.of(2018,10,03),19750.00),
                new Employee(444,"Carly","Agar",LocalDate.of(2014,05,16),842000.75),
                new Employee(444,"Wesley","Schneider",LocalDate.of(2018,11,02),74500.00),


        };
        var pensionPlansensionPlan = new PensionPlan[]{
                new PensionPlan("EX1089",LocalDate.of(2023,01,17),100.00),
                new PensionPlan("",LocalDate.of(2023,01,17),100.00),
                new PensionPlan("SM2307",LocalDate.of(2023,01,17),100.00),
                new PensionPlan("",LocalDate.of(2023,01,17),100.00),



        };

    }
}