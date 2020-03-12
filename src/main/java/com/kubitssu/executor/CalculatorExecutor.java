package com.kubitssu.executor;

import com.kubitssu.Operations;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;

public class CalculatorExecutor implements Executor {
    @Setter
    @Getter
    private int outputValue;
    private static final Logger log = Logger.getLogger(Executor.class.getName());

    @Override
    public void executor(LinkedHashMap<Operations, Integer> OperationsAndValues) {
        setOutputValue(OperationsAndValues.get(Operations.APPLY));
        for (Operations iterator : OperationsAndValues.keySet()) {
            switch (iterator) {
                case MULTIPLY:
                    outputValue *= OperationsAndValues.get(iterator);
                    break;
                case ADD:
                    outputValue += OperationsAndValues.get(iterator);
                    break;
                case SUBTRACT:
                    outputValue -= OperationsAndValues.get(iterator);
                    break;
                case DIVIDE:
                    outputValue /= OperationsAndValues.get(iterator);
                    break;
                case APPLY:
                    break;
                default:
                    log.error("Unknown Operation");
                    break;
            }

        }
    }
}
