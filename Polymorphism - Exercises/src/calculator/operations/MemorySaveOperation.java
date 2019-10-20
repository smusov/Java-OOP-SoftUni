package calculator.operations;

import java.util.ArrayDeque;

public class MemorySaveOperation implements Operation {

    private ArrayDeque<Integer> memory;

    public MemorySaveOperation(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
