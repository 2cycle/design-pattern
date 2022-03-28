package com.ecycle;

import com.ecycle.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Application {

    //Excel의 여러 Sheet가 있는것과 같이
    //1 프로그램 안에 여러 editor가 있음을 표현하였다.
    //예제에서는 사용하지 않는다.
    public List<Editor> editors;

    //복사나 잘라내기같은 기능 수행 시
    //해당 text가 저장될 장소
    public String clipboard;

    public CommandHistory history;

    public Editor activeEditor;

    public Map<String, Consumer<Void>> shortcut;

    public Application() {
        super();
        editors = new ArrayList<>();
        clipboard = "";
        history = new CommandHistory();
        activeEditor = new Editor();
        shortcut = new HashMap<>();
    }

    public void createUI() {

        shortcut.put("copy", (Void)
                -> executeCommand(new CopyCommand(this, activeEditor)));
        shortcut.put("paste", (Void)
                -> executeCommand(new PasteCommand(this, activeEditor)));
        shortcut.put("cut", (Void)
                -> executeCommand(new CutCommand(this, activeEditor)));
        shortcut.put("undo", (Void)
                -> executeCommand(new UndoCommand(this, activeEditor)));
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    public void undo() {
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}