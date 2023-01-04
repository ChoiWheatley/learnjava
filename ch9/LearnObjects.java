package ch9;

import java.util.Comparator;
import java.util.Objects;
import static java.lang.System.*;

public class LearnObjects {
  public static void main(String[] args) {
    /** requireNonNull은 null 체크를 한다. NullPointerException을 발생한다. */
    {
      Integer iNull = null;
      var something = Objects.requireNonNullElse(iNull, 0);

      try {
        var something2 = Objects.requireNonNull(iNull, "hello");
      } catch (Exception e) {
        e.printStackTrace();
        out.println("keep going");
      }

      try {
        var something3 = Objects.requireNonNull(iNull, () -> String.valueOf(Math.random()));
      } catch (Exception e) {
        e.printStackTrace();
        out.println("keep going");
      }
    }

    /** equals(a,b)는 내부에서 Null 검사를 한다. 둘 다 null이면 참임. */
    {
      Object something = null;
      Object something2 = null;
      Object somtehing3 = "h";
      assert Objects.equals(something, something2);
      assert !Objects.equals(something, somtehing3);
    }

    /** deepEquals()는 객체를 재귀적으로 비교할 수 있다. */
    {
      final var str2D1 = new String[][] {
          { "aaa", "bbb", "ccc" },
          { "AAA", "BBB", "CCC" }
      };
      final var str2D2 = new String[][] {
          { "aaa", "bbb", "ccc" },
          { "AAA", "BBB", "CCC" }
      };
      assert Objects.deepEquals(str2D1, str2D2);
    }

    /** compare는 Comparator에 의해 특정한 규칙에 따른 비교가 가능하다. */
    {
      String hello = "hello, world!";
      String hello2 = "HELLO, WORLD!";
      Comparator<String> c = String.CASE_INSENSITIVE_ORDER; // 대소문자 구별하지 않는 비교
      assert Objects.compare(hello, hello2, c) == 0;
    }
  }
}
