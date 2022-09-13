package ch6;

public class ReferenceParam {
  public static void main(String[] args) {
    /**
     * int 형은 primitive type으로, 값 그 자체를 들고 있다. 따라서 파라미터로 얘를 넘겨버리면
     * 원본값은 변하지 않을 것이다.
     */
    int x = 10;
    System.out.println("int x = " + x);
    change(x); // 10이 복사되어 들어간다.
    System.out.println("changed int x = " + x);
    /**
     * Integer는 int형을 래핑한 객체이다. 그렇다면 얘를 파라미터로 넘기면 과연 어떻게 될까?
     */
    Integer y = 10;
    System.out.println("Integer y = " + y);
    change(y);
    System.out.println("changed Integer y = " + y);
    /**
     * int 형을 레퍼런스로 전달하고 싶다면 배열을 사용하라.
     */
    int[] z = { 10 };
    System.out.println("int[] z[0] = " + z[0]);
    change(z);
    System.out.println("changed int[] z[0] = " + z[0]);
  }

  static void change(Integer x) {
    System.out.println("in change(), hash of x = " + System.identityHashCode(x));
    x = 10000;
    System.out.println("in change(), x = " + x);
    System.out.println("in change(), hash of x = " + System.identityHashCode(x));
  }

  static void change(int[] x) {
    x[0] = 10000;
    System.out.println("in change(), x = " + x[0]);
  }

}
