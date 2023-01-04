package ch9;

import java.util.Scanner;

/**
 * 콘솔에서 정수들을 입력받아 더하는 프로그램을 작성한다.
 */
public class LearnScanner2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    int cnt = 0;

    while (sc.hasNextInt()) {
      sum += sc.nextInt();
      cnt++;
    }
    System.out.println("sum = " + sum);
    System.out.println("average = " + (double) (sum / cnt));
  }
}
