package org.streaming.app.employee;

import akka.NotUsed;
import akka.stream.javadsl.Source;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSource {

    public Source<Employee, NotUsed> getEmployees(){
        return Source.from(getEmps());
    }

    private List<Employee> getEmps(){
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("Suresh Kumar", "9874563210", "suresh@gmail.com", 32, 82000));
        list.add(new Employee("Kamal", "8574963210", "kamal@gmail.com", 29, 75000));
        list.add(new Employee("Bala", "9874586321", "bala@gmail.com", 27, 65000));
        list.add(new Employee("Logesh", "9966338855", "logesh@gmail.com", 27, 78000));
        list.add(new Employee("Sriram", "9977885544", "sriram@gmail.com", 24, 50000));
        return list;
    }
}
