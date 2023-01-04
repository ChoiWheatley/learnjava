package ch9;

import static java.lang.System.*;

import java.beans.Transient;
import java.util.Random;

public class LearnRandom {
  public static void main(String[] args) {
    /** seed를 따로 정의하지 않는 Math.random() */
    {
      out.println(Math.random()); // 사실 아래의 문장과 동등하다.
      out.println(new Random().nextDouble());
    }

    out.println();
    /** seed값을 따로 정할 수 있는 Random 클래스 */
    {
      Random r = new Random(0L);
      for (var i = 0; i < 10; ++i) {
        out.println(r.nextInt()); // 몇 번이고 실행해도 아마 같은 값이 나올 것이다.
      }
    }
  }
}
