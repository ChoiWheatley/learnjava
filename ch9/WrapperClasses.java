package ch9;

import static java.lang.System.*;

public class WrapperClasses {
  public static void main(String[] args) {
    int v = 1;
    char c = 'a';
    byte b = 5;
    boolean bo = false;
    Integer integer = Integer.valueOf(v);
    print(v);
    print(c);
    print(b);
    print(bo);
    print(integer);
    print(Integer.MAX_VALUE);
    print(Integer.MIN_VALUE);
    print(Integer.SIZE);
    print(Integer.BYTES);
    print(Integer.TYPE);
  }

  public static void print(Object something) {
    out.println(something);
  }
}
