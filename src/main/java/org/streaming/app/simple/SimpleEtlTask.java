package org.streaming.app.simple;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

import java.util.concurrent.CompletionStage;


public class SimpleEtlTask {

    public void runProcess(){
        ActorSystem actorSystem = ActorSystem.create("basic-etl-task");

        ActorMaterializer materializer = ActorMaterializer.create(actorSystem);

        final Source<Integer, NotUsed> source = Source.range(0, 10000);

        final Flow<Integer, String, NotUsed> flow = Flow.fromFunction((Integer n) -> n.toString());

        final Sink<String, CompletionStage<Done>> sink = Sink.foreach(str -> System.out.println(str));

        final RunnableGraph<NotUsed> runnable = source.via(flow).to(sink);

        runnable.run(materializer);
    }
}
