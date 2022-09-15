package ch7;

public class PropertyBinding {
  public static void main(String[] args) {
    Parent2 p = new Child2();
    Child2 c = new Child2();
    assert p.who.equals("Parent");
    assert c.who.equals("Child");
  }
}

class Parent2 {
  String who = "Parent";
}

class Child2 extends Parent2 {
  String who = "Child";
}
