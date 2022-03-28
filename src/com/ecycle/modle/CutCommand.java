package com.ecycle.modle;

import com.ecycle.Application;
import com.ecycle.Editor;

public class CutCommand extends Command {
    public CutCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        saveBackup();
        app.clipboard = editor.getSelection();
        editor.deleteSelection();

        return true;
    }
}