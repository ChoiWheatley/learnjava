package ch9;

import java.util.Scanner;
import static java.lang.System.*;

public class LearnScanner1 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String[] argArr = null;

    while (true) {
      String prompt = ">>";
      out.print(prompt);

      // 화면으로부터 라인단위 입력
      String input = s.nextLine();
      input = input.trim();
      argArr = input.split(" +"); // `+` 기호는 앞글자가 여러 개 올 수 있다는 의미임.
      String command = argArr[0].trim();
      if (command.equals("q")) {
        System.exit(0);
      } else {
        for (final var elem : argArr) {
          out.println(elem);
        }
      }
    }
  }
}
