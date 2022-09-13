import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

class PlayGround {
  public static final int WIDTH = 20;
  public static final int HEIGHT = 10;

  public static void main(String[] args) {
    int x = 10, y = 20;
    int tmp = 0;

    System.out.println("x: " + x + " y: " + y);

    tmp = x;
    x = y;
    y = tmp;

    System.out.println("x: " + x + " y: " + y);
    Date today = new Date();
    System.out.println("today is " + today);

    var triangleArea = (WIDTH * HEIGHT) / 2;
    System.out.println(triangleArea);

    // suffix `p` literal: 실수 리터럴의 16진 표현
    double somethingRealNo = 0x0.2p-1; // (2 * 16^(-1)*2^(-1))
    System.out.println(0.0625 + " == " + somethingRealNo);

    // float에 double을 끼워넣으면 컴파일 에러 발생
    // float f = 3.14;

    // String syntatic sugar
    var someString = new String("Hello, world");
    var someOtherString = "Hello, other world";
    someString += new Date().toString(); // + operator
    someOtherString += Integer.valueOf(32);
    System.out.println("" + 7 + 7); // 결과는?
    System.out.println("" + (7 + 7)); // 결과는?
    System.out.println(7 + 7 + ""); // 결과는?

    System.out.printf("age: %d\n", 16);
    var hex = 0x11a9f;
    System.out.printf("hexadecimal: %#x, %X\n", hex, hex);
    var greetings = "Hello, world! My name is Choi Wheatley";
    System.out.printf("[%-20s]\n", greetings);
    System.out.printf("[%20s]\n", greetings);
    System.out.printf("[%.3s]\n", greetings);

    // using Scanner Object
    // final var scanner = new Scanner(System.in);
    // final var input = scanner.nextLine();
    // final var inputNo = Integer.parseInt(input); // 숫자가 아닌 놈들 (공백 포함)이 들어가면 예외를
    // 발생한다.

    // java char is basically unicode with UTF-16 encoding
    final String str = "😋🤪🤫😶‍🌫️💩👻";
    final byte[] charset = str.getBytes(StandardCharsets.UTF_8);
    final String resultString = new String(charset, StandardCharsets.UTF_8);
    System.out.println(resultString);
    InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
    Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
    /// 어떻게 UTF_8 스트림을 하나씩 출력하지?
    int data;
    try {
      data = reader.read();
      while (data != -1) {
        System.out.printf("%c ", (char) data);
        data = reader.read();
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}