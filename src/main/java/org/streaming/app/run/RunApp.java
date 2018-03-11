package org.streaming.app.run;

import org.streaming.app.simple.SimpleEtlTask;

public class RunApp {

    public static void main(String[] args) {
        SimpleEtlTask simpleEtlTask = new SimpleEtlTask();
        simpleEtlTask.runProcess();
    }
}
