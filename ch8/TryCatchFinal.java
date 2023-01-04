package ch8;

/**
 * TryCatchFinal
 */
public class TryCatchFinal {
  public static void main(String[] args) {
    method1();
  }

  static void method1() {
    try {
      System.out.println("method1()");
      return; // 리턴을 하더라도 finally 구문은 반드시 호출된다.
    } catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      System.out.println("fimally, 마참내!");
    }
  }
}