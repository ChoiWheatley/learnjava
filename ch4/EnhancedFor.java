package ch4;

public class EnhancedFor {
  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, 40, 50 };

    // 기존의 방식
    for (int i = 0; i < arr.length; ++i) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
    // 향상된 방식, 얘는 read only라고?
    for (final var elem : arr) {
      System.out.print(elem + " ");
    }
    System.out.println();
  }
}
