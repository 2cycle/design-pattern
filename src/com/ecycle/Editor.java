package com.ecycle;

public class Editor {

    public String text;

    public Editor() {
        super();
        text = "";
    }

    //Drag UI가 없으므로 editor에서 선택은 전체 선택만 할 수 있도록 기능 제한
    public String getSelection() {
        return text;
    }

    //Drag UI가 없으므로 삭제는 전체 삭제
    public void deleteSelection() {
        text = "";
    }

    public void replaceSelection(String newText) {
        text += newText;
    }
}