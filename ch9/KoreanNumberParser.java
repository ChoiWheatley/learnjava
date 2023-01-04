package ch9;

import static java.util.Map.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.Test;

public class KoreanNumberParser {
  public static void main(String[] args) {
    var zero = "영";
    assert NUMBER.indexOf(zero) == 0;

    var ten = "십";
    assert UNIT_VALUE.get(ten) == 10;

    var test1 = "삼천구백이십칠";
    assert koreanToNum(test1) == 3927L;

    var test2 = "삼억구천일백이십일";
    assert koreanToNum(test2) == 300_009_121L;

    var test3 = "칠천팔백오십일만구천일백일십일"; // 만, 억, 조 단위는 십, 백, 천 조합이 들어간다.
    assert koreanToNum(test3) == 78_519_111L;
  }

  @Test
  public void numberBasic() {
    assertEquals(0, NUMBER.indexOf("영"));
    assertEquals(1, NUMBER.indexOf("일"));
    assertEquals(2, NUMBER.indexOf("이"));
    assertEquals(3, NUMBER.indexOf("삼"));
    assertEquals(4, NUMBER.indexOf("사"));
    assertEquals(5, NUMBER.indexOf("오"));
    assertEquals(6, NUMBER.indexOf("육"));
    assertEquals(7, NUMBER.indexOf("칠"));
    assertEquals(8, NUMBER.indexOf("팔"));
    assertEquals(9, NUMBER.indexOf("구"));
  }

  @Test
  public void unitBasic() {
    assertEquals(10L, UNIT_VALUE.get("십").longValue());
    assertEquals(100L, UNIT_VALUE.get("백").longValue());
    assertEquals(1000L, UNIT_VALUE.get("천").longValue());
    assertEquals(10000L, UNIT_VALUE.get("만").longValue());
    assertEquals(100000000L, UNIT_VALUE.get("억").longValue());
    assertEquals(1000000000000L, UNIT_VALUE.get("조").longValue());
  }

  @Test
  public void lessThanThousand() {
    Map<String, Long> sampleAnswer = Map.ofEntries(
        entry("일", 1L),
        entry("이십일", 21L),
        entry("삼백이십일", 321L),
        entry("사천삼백이십일", 4321L));
    for (final var entry : sampleAnswer.entrySet()) {
      final var sample = entry.getKey();
      final var answer = entry.getValue();
      assertEquals(answer, koreanToNum(sample));
    }
  }

  @Test
  public void biggerThanThousand() {
    Map<String, Long> sampleAnswer = Map.ofEntries(
        entry("일만", 10_000L),
        entry("일억", 100_000_000L),
        entry("일조", 1_000_000_000_000L));
    for (final var entry : sampleAnswer.entrySet()) {
      final var sample = entry.getKey();
      final var answer = entry.getValue();
      assertEquals(answer, koreanToNum(sample));
    }
  }

  @Test
  public void complexCase() {
    var sample = "사천삼백이십일조사천삼백이십일억사천삼백이십일만사천삼백이십일";
    Long answer = 4_321_432_143_214_321L;
    assertEquals(answer, koreanToNum(sample));
  }

  public static final String NUMBER = "영일이삼사오육칠팔구";

  public static final Map<String, Long> UNIT_VALUE = Map.ofEntries(
      entry("십", (long) 1e1),
      entry("백", (long) 1e2),
      entry("천", (long) 1e3),
      entry("만", (long) 1e4),
      entry("억", (long) 1e8),
      entry("조", (long) 1e12));

  public static final String UNIT = String.join("", UNIT_VALUE.keySet());

  /**
   * 한글을 숫자로 변환하는 메서드
   * 
   * @param input 최대 '조' 단위까지 파싱 가능
   */
  public static Long koreanToNum(String input) throws RuntimeException {
    // 최종 결과를 저장.
    long result = 0;
    long num = 0;
    long lessThanThousand = 0;

    for (var elem : input.toCharArray()) {
      int check = NUMBER.indexOf(elem);
      // 아직 enum 쓸 줄을 모른다.
      if (check == -1) {
        /**
         * 단위인 경우
         */
        long exp = UNIT_VALUE.get(String.valueOf(elem));
        if (exp >= 1e4) {
          /**
           * 만단위 이후부터는 임시변수에 있던 값에다 해당 승수를 곱하여
           * 최종 값에다 추가한다.
           */
          result += (lessThanThousand + num) * exp;
          lessThanThousand = 0;
          num = 0;
        } else if (0 < exp && exp < 1e4) {
          /*
           * 천단위 이하로는 바로 계산 때리지 말고 임시변수에 추가한다.
           */
          lessThanThousand += num * exp;
          num = 0;
        } else {
          throw new RuntimeException("UNIT_VALUE not found!!!!!!");
        }
      } else {
        /**
         * 숫자인 경우
         */
        num = check;
      }
    }

    result += lessThanThousand + num;

    return result;
  }
}
