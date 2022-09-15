package ch7;

public class MethodBinding {
  public static void main(String[] args) {
    Parent p = new Child();
    Child c = new Child();
    assert p.who().equals(c.who());
  }
}

class Parent {
  String who() {
    return "Parent";
  }
}

class Child extends Parent {
  @Override
  String who() {
    return "Child";
  }
}