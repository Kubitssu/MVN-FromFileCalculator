package com.kubitssu.executor;

import com.kubitssu.Operations;

import java.util.LinkedHashMap;

public interface Executor {
    void executor(LinkedHashMap<Operations, Integer> OperationsAndValues);

    int getOutputValue();
}
