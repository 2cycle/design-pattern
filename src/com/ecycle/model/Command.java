package com.ecycle.model;

import com.ecycle.Application;
import com.ecycle.Editor;

public abstract class Command {

    protected Application app;

    protected Editor editor;

    protected String backup;

    public Command(Application app, Editor editor) {
        super();
        this.app = app;
        this.editor = editor;
    }

    //기능 수행 전 현재 text를 저장한다.
    //Copy나 잘라내기 수행 시 되돌리기 기능을 지원하려면 해당 text를 저장해놓아야 한다.
    public void saveBackup() {
        backup = editor.text;
    }

    //되돌리기를 수행하면 현재 editor의 text를
    //기능 수행 전의 text로 변경한다.
    public void undo() {
        editor.text = backup;
    }

    //각 command 에서 구현해야할 기능
    //반환형 boolean은 해당 기능을 Command 이력을에 넣을지 말지를 결정하는 용도이다.
    //ex - 복사, 되돌리기 Command를 해당 이력에 넣어버리면
    //Undo를 했을 때 복사나, 되돌리기를 다시 수행하기 때문에
    //의도된 대로 동작하지 않는다.
    public abstract boolean execute();
}