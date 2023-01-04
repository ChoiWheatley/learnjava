package ch8;

public class ChainedException {
  public static void main(String[] args) {
    /** checked 예외발생 */
    // throw new SomeCheckedException("msg"); // 컴파일 타임에 걸린다. 따라서 강제적으로 try-catch 사용

    /** checked 예외를 unchecked로 둔갑 */
    throw new RuntimeException(new SomeCheckedException("This is a checked exception"));
  }
}

class SomeCheckedException extends Exception {
  SomeCheckedException(String msg) {
    super(msg);
  }
}