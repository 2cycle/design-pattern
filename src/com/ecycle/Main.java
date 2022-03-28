package com.ecycle;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        Application app = new Application();

        app.createUI();

        System.out.println("====Editor start====");
        //editor에 abcd를 타이핑한다.
        app.activeEditor.replaceSelection("abcd");
        System.out.println(app.activeEditor.getSelection());

        //이어서 efg를 타이핑한다.
        app.activeEditor.replaceSelection("efg");
        System.out.println(app.activeEditor.getSelection());

        //복사 기능으로 clipboard에 있는 text를 저장한다.
        Consumer<Void> copyCommand = app.shortcut.get("copy");
        Consumer<Void> pasteCommand = app.shortcut.get("paste");
        Consumer<Void> cutCommand = app.shortcut.get("cut");

        copyCommand.accept(null);
        System.out.println(app.activeEditor.getSelection());

        //붙여넣기 기능으로 clipboard의 text를 붙여넣기 한다.
        pasteCommand.accept(null);
        System.out.println(app.activeEditor.getSelection());

        //되돌리기 기능을 수행한다.
        app.undo();
        System.out.println(app.activeEditor.getSelection());

        //잘라내기 기능 수행
        cutCommand.accept(null);
        System.out.println(app.activeEditor.getSelection());

        //붙여넣기 2번 수행
        pasteCommand.accept(null);
        pasteCommand.accept(null);
        System.out.println(app.activeEditor.getSelection());

        app.undo();
        System.out.println(app.activeEditor.getSelection());
        app.undo();
        System.out.println(app.activeEditor.getSelection());
        System.out.println("====Editor end====");
    }
}
