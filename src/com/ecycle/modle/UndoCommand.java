package com.ecycle.modle;

import com.ecycle.Application;
import com.ecycle.Editor;

public class UndoCommand extends Command{
    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        app.undo();

        return false;
    }
}