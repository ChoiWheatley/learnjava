package ch9;

import org.junit.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LearnStringTokenizer {

  public static void main(String[] args) {
    /** split 함수를 사용하여 문자열 잘라내기 */
    final var splitted = "100,200,300,400".split(",");

    /** Scanner의 delimiter를 정의하여 문자열 잘라내기 */
    final var scanned = new Scanner("100,200,300,400")
        .useDelimiter(",");

    try (var scanCsv = new Scanner(new File("ch9/names.csv"))
        .useDelimiter("\n")) {
      while (scanCsv.hasNext()) {
        final var line = scanCsv.next();
        var tokenizer = new StringTokenizer(line, ",");
        while (tokenizer.hasMoreTokens()) {
          System.out.println(tokenizer.nextToken());
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
