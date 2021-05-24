package by.silebin.information_handling.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private Deque<Integer> values = new ArrayDeque<>();

    public int pop() {
        return values.pop();
    }

    public void push(int value) {
        values.push(value);
    }
}
