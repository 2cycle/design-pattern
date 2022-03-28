package com.ecycle.modle;

import com.ecycle.Application;
import com.ecycle.Editor;

public class PasteCommand extends Command{
    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        saveBackup();
        editor.replaceSelection(app.clipboard);

        return true;
    }
}