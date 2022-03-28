package com.ecycle;

import com.ecycle.model.Command;

import java.util.Stack;

public class CommandHistory {

    private Stack<Command> history;

    public CommandHistory() {
        super();
        history = new Stack<>();
    }

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

}