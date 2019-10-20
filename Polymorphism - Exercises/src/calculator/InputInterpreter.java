package calculator;

import calculator.operations.*;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;
    private ArrayDeque<Integer> memory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memory = new ArrayDeque<>();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {

        switch (operation) {
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisibleOperation();
            case "ms":
                return new MemorySaveOperation(this.memory);
            case "mr":
                return new MemoryRecallOperation(this.memory);
        }

        return null;
    }
}
