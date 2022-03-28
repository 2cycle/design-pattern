package com.ecycle.modle;

import com.ecycle.Application;
import com.ecycle.Editor;

public class CopyCommand extends Command{
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        app.clipboard = editor.getSelection();

        return false;
    }
}