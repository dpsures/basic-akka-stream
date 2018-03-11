package org.streaming.app.employee;

import akka.Done;
import akka.stream.javadsl.Sink;

import java.util.concurrent.CompletionStage;

public class EmployeeSink {

    public Sink<Employee, CompletionStage<Done>> sinkData(){
        Sink<Employee, CompletionStage<Done>> sink = Sink.foreach(emp -> {
           emp.setStatus(4);
            System.out.println(emp.getName()+" --- "+emp.getTaxAmoount()+" --- "+emp.getStatus());
        });
        return sink;
    }
}
