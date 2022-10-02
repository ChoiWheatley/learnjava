package ch7;

public class InnerClasses {
  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    inner.method1();
  }
}

class OuterClass {
  private int outerPrivateVar = 0;
  static int outerStaticVar = 0;

  class InstanceInner {
  }

  static class StaticInner {
  }

  InstanceInner instanceInner = new InstanceInner();
  static StaticInner staticInner = new StaticInner();

  static void staticMethod() {
    /** Must qualify the allocation with an enclosing instance of type OuterClass */
    // InstanceInner instanceInner = new InstanceInner();
    /** 굳이 인스턴스 클래스를 만들고 싶다면 외부클래스의 객체를 생성하는 수밖에 */
    (new OuterClass()).new InstanceInner();
    new StaticInner();
  }

  void outerMethod() {
    int localVar = 0;
    final int LOCAL_CONST = 0;

    class LocalInner {
      int localInnerVar = outerPrivateVar;
      int localInnerVar2 = outerStaticVar;
      /**
       * 외부 클래스의 지역변수는 immutable 변수만 접근가능하다.
       * 하지만 java1.8 이래로 final을 생략하고 쓸 수는 있지만 immutable
       * 속성은 유지가 된다.
       */
      int localInnerVar3 = localVar;
      int localInnerVar4 = LOCAL_CONST;

      void localInnerMethod() {
        // localVar = 50; // 따라서 이 문장은 오류를 발생시키게 된다.
      }
    }
  }
}

class Outer {
  String value = "Outer value";

  class Inner {
    String value = "Inner value";

    void method1() {
      String value = "Inner method1 value";
      System.out.println("value: " + value);
      System.out.println("this.value: " + this.value);
      System.out.println("Outer.this.value: " + Outer.this.value);
    }
  }
}