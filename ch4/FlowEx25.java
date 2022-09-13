package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FlowEx25 {
  public static void main(String[] args) {
    while (true) {
      System.out.print("숫자를 입력하세여 >>> ");
      Scanner s = new Scanner(System.in);
      final var firstLine = s.nextLine();
      try {
        final var num = Integer.parseInt(firstLine);
        var tmp = num;
        List<Integer> list = new ArrayList<>();
        while (tmp > 0) {
          // 각 자릿수들을 추출
          final var digit = tmp % 10;
          list.add(digit);
          tmp /= 10;
        }
        for (final var i : list) {
          System.out.printf("%d ", i);
        }
        System.out.println();
        var sum = 0;
        for (final var i : list) {
          sum += i;
        }
        System.out.println("각 자릿수의 합 : " + sum);
      } catch (NumberFormatException e) {
        // TODO: handle exception
        if (firstLine.equals("quit")) {
          break;
        }
        System.out.println("숫.자.를.입.력.하.시.라.고.요.");
        continue;
      }
    }
  }
}
