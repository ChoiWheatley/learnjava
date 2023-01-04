package ch9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LearnRegex {
  public static void main(String[] args) {
    {
      String[] datas = {
          "bat",
          "baby",
          "bonus",
          "cA",
          "ca",
          "co",
          "c.",
          "c0",
          "car",
          "combat",
          "count",
          "date",
          "disc"
      };
      Pattern p = Pattern.compile("c[a-z]*"); // c로 시작하는 소문자 영단어
      for (final var data : datas) {
        if (p.matcher(data).matches()) {
          System.out.println(data);
        }
      }
      System.out.println();
      // stream
      Stream.of(datas)
          .filter((data) -> p.matcher(data).matches())
          .forEach(System.out::println);
    }
  }
}
