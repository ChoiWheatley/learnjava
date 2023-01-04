package ch7;

import java.awt.*;
import java.awt.event.*;

public class AnnonymousClass {
  public static void main(String[] args) {
    /**
     * 익명클래스 없이 이벤트 핸들링 하기
     */
    Button b = new Button("Start");
    b.addActionListener(new EventHandler());

    /**
     * 익명클래스로 bloat 없이 이벤트 핸들링 하기
     */
    b.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("This is from annonymous class!");
      }

    });
  }
}

/**
 * 익명클래스 없이 ActionListener 구현체 만드는 방법.
 */
class EventHandler implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent arg0) {
    System.out.println("Helllllo world!");
  }
}