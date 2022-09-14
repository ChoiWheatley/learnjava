package ch7;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * static 멤버를 호출할 때 클래스 이름 생략 가능.
 */
import static java.lang.System.out;

public class ImportTest {
  public static void main(String[] args) {
    var today = new Date();
    var dateString = new SimpleDateFormat("yyyy/MM/dd");
    var timeString = new SimpleDateFormat("hh:mm:ss a");

    out.println("오늘 날짜는 " + dateString.format(today) + " 입니다.");
    out.println("현재 시간은 " + timeString.format(today) + " 입니다.");
  }
}
