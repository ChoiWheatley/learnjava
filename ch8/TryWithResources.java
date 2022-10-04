package ch8;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {
  static final String FILENAME = "ch8/score.dat";

  public static void main(String[] args) {
    // trycatch();
    // tryresources();

    System.out.println("\n\n수동자원반환");
    /** 수동 자원 반환 */
    CloseableResource cr = null;
    try {
      cr = new CloseableResource();
      cr.exceptionWork(true);
    } catch (WorkException e) {
      e.printStackTrace(); // 얘가 실행된다.
    } finally {
      try {
        cr.close();
      } catch (CloseException e) {
        e.printStackTrace(); // 얘도 같이 실행된다.
      }
    }

    System.out.println("\n\n자동자원반환");
    /** 자동 자원 반환 */
    try (var cr1 = new CloseableResource()) {
      cr1.exceptionWork(false);
    } catch (WorkException e) {
      e.printStackTrace();
    } catch (CloseException e) {
      e.printStackTrace();
    }

    System.out.println("\n\n자동자원반환");
    /** 자동 자원 반환 */
    try (var cr1 = new CloseableResource()) {
      cr1.exceptionWork(true);
    } catch (WorkException e) {
      e.printStackTrace();
    } catch (CloseException e) {
      e.printStackTrace();
    }
  }

  static void trycatch() {
    FileInputStream fis = null;
    DataInputStream dis = null;
    int sum = 0;
    // manual 자원해제 (try-catch)
    try {
      fis = new FileInputStream(FILENAME);
      dis = new DataInputStream(fis);

      while (true) {
        var score = dis.readInt();
        System.out.println(score);
        sum += score;
      }
    } catch (EOFException eof) {
      System.out.println("점수의 총합은 " + sum + " 입니다.");
    } catch (IOException ie) {
      ie.printStackTrace();
    } finally {
      try {
        fis.close();
        dis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  static void tryresources() {
    int sum1 = 0;

    // 자원해제를 알아서 (try-with-resources)
    try (var fis1 = new FileInputStream(FILENAME);
        var dis1 = new DataInputStream(fis1)) {

      while (true) {
        var score = dis1.readInt();
        System.out.println(score);
        sum1 += score;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (EOFException e) {
      System.out.println("점수의 총합은 " + sum1 + " 입니다.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class CloseableResource implements AutoCloseable {
  public void exceptionWork(boolean exception) throws WorkException {
    System.out.println("CloseableResource :: exceptionWork(" + exception + ")");
    if (exception) {
      throw new WorkException("WorkException발생");
    }
  }

  @Override
  public void close() throws CloseException {
    System.out.println("CloseableResource :: close()");
    System.out.println("강제로 close() 안에서 예외를 던질거임");
    throw new CloseException("CloseException발생");
  }

}

class WorkException extends Exception {
  WorkException(String msg) {
    super(msg);
  }
}

class CloseException extends Exception {
  CloseException(String msg) {
    super(msg);
  }
}