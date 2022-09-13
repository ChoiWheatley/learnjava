package ch5;

import java.util.Arrays;

public class ArrayStudy {
  public static void main(String[] args) {
    int[] score = new int[5];
    // score.length는 상수다. 생성된 뒤에 변경할 수 없다.
    for (var i = 0; i < score.length; ++i) {
      System.out.printf("%d ", score[i]);
    }
    System.out.println();
    // 배열의 초기화
    int[] scores = { 50, 60, 70, 80, 90 };
    System.out.println(scores);
    System.out.println(Arrays.toString(scores)); // 자동으로 이쁘게 만들어 String으로 리턴해줌.

    // 배열의 복사
    var tmp = new int[scores.length * 2]; // 배열의 크기가 런타임에 결정이 된다.
    for (var i = 0; i < scores.length; ++i) {
      tmp[i] = scores[i]; // 직접 복사 해야만 해?
    }
    scores = tmp; // 바꿔치기! 이때 scores가 원래 가리키고 있던 포인터는 어디가냐
    System.out.println(Arrays.toString(tmp));

    // System.arraycopy()를 사용한 더 효율적인 배열복사
    var scores2 = new int[scores.length * 2];
    System.arraycopy(
        scores, // 원본
        0, // 원본[0] 부터
        scores2, // 타겟
        0, // 타겟[0] 부터
        scores.length); // 원본[0] 부터 몇 개
    System.out.println(Arrays.toString(scores2));
  }

}
