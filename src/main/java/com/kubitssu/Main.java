package com.kubitssu;

import com.kubitssu.executor.CalculatorExecutor;
import com.kubitssu.executor.Executor;
import com.kubitssu.reader.CalculatorReader;
import com.kubitssu.reader.Reader;
import org.apache.log4j.Logger;

public class Main {
    private static final org.apache.log4j.Logger log = Logger.getLogger(Executor.class.getName());

    public static void main(String[] args) {

        Reader read = new CalculatorReader();
        Executor exec = new CalculatorExecutor();
        try {
            exec.executor(read.readFile(args[0]));
            System.out.println(exec.getOutputValue());
        } catch (Exception e) {
            log.error("Exception caught" + e);
        }
    }
}

