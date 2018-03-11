package org.streaming.app.employee;

import akka.NotUsed;
import akka.stream.javadsl.Flow;

public class EmployeeFlow {

    public Flow<Employee, Employee, NotUsed> processTax(){

        Flow<Employee, Employee, NotUsed> flow = Flow.fromFunction((Employee emp) -> {
            double salary = emp.getSalary();
            double taxPerc = 10;

            double taxAmount = salary/taxPerc;
            emp.setTaxAmoount(taxAmount);
            return  emp;
        });
        return flow;
    }
}
