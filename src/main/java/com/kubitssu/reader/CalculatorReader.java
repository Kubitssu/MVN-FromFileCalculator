package com.kubitssu.reader;

import com.kubitssu.Operations;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Scanner;

@Getter
@Setter
public class CalculatorReader implements Reader {

    private Operations operation;
    private int value;
    private static final Logger log = Logger.getLogger(Reader.class.getName());

    @Override
    public LinkedHashMap<Operations, Integer> readFile(String path) {

        File file = new File(path);
        LinkedHashMap<Operations, Integer> OperationsAndValues = new LinkedHashMap<>();
        //Reading Content of the file and splitting each line in to Key and Value for Linked Hash Map
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (scanner.hasNextLine()) {
                String[] entryText = scanner.nextLine().split(" ");
                switch (entryText[0]) {
                    case "multiply":
                        operation = Operations.MULTIPLY;
                        break;
                    case "add":
                        operation = Operations.ADD;
                        break;
                    case "subtract":
                        operation = Operations.SUBTRACT;
                        break;
                    case "divide":
                        operation = Operations.DIVIDE;
                        break;
                    case "apply":
                        operation = Operations.APPLY;
                        break;
                    default:
                        // Default case breaks general expectations of the application, exception should be thrown
                        throw new IllegalArgumentException("Unknown Operation");
                }
                setValue(Integer.parseInt(entryText[1]));

                //Putting Operation and Value to Linked Hash Map
                OperationsAndValues.put(getOperation(), getValue());

            }
        } catch (IOException e) {
            log.error("IO Exception caught" + e);

        }
        return OperationsAndValues;
    }
}
