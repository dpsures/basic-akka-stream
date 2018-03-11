package org.streaming.app.run;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import org.streaming.app.employee.Employee;
import org.streaming.app.employee.EmployeeFlow;
import org.streaming.app.employee.EmployeeSink;
import org.streaming.app.employee.EmployeeSource;

import java.util.concurrent.CompletionStage;

public class RunEmployeeEtl {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("akka-stream-etl");

        ActorMaterializer materializer = ActorMaterializer.create(system);

        EmployeeSource employeeSource = new EmployeeSource();
        Source<Employee, NotUsed> source = employeeSource.getEmployees();

        //source.runForeach(emp -> System.out.println(emp.getName()), materializer);

        EmployeeFlow employeeFlow = new EmployeeFlow();
        Flow<Employee, Employee, NotUsed> flow = employeeFlow.processTax();

        EmployeeSink employeeSink = new EmployeeSink();
        Sink<Employee, CompletionStage<Done>> sink = employeeSink.sinkData();

        RunnableGraph<NotUsed> runnableGraph = source.via(flow).to(sink);

        runnableGraph.run(materializer);
    }
}
