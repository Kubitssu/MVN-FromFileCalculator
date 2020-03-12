package com.kubitssu.reader;

import com.kubitssu.Operations;

import java.util.LinkedHashMap;

public interface Reader {
    public LinkedHashMap<Operations, Integer> readFile(String path) throws IllegalArgumentException;
}
