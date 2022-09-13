package ch6;

import java.util.Arrays;

class TV {
  String color;
  boolean power;
  int channel;

  void power() {
    power = !power;
  }

  void channelUp() {
    channel++;
  }

  void channelDown() {
    channel--;
  }
}

class TvTest {
  public static void main(String[] args) {
    TV t = new TV();
    t.channel = 7;
    System.out.println("channel = " + t.channel);
    t.channelUp();
    System.out.println("channel = " + t.channel);
    t.power = true;
    System.out.println("power = " + t.power);
    t.power();
    System.out.println("power = " + t.power);
    System.out.println("color = " + t.color);
    // t.color.equals("anObject"); // NullPointerException

    /// # 객체배열
    TV[] tvArr = new TV[3]; // 배열은 생성했지, TV 객체는 생성안함
    System.out.println(Arrays.toString(tvArr)); // 그래서 출력해보면 null 만 나옴.
    for (var ref : tvArr) {
      ref = new TV(); // JAVA에서 enhanced for loop는 불변이다.
    }
    System.out.println(Arrays.toString(tvArr));
    for (var i = 0; i < tvArr.length; ++i) {
      TV ref = tvArr[i]; // tvArr[i] 은 현재 null이다. 따라서 ref도 null을 받는다. 하지만 tvArr[i]을 포인트 하지 않는다.
      ref = new TV(); // ref에 새 인스턴스의 레퍼런스가 할당되었다. 하지만 tvArr[i]에는 아무런 변화가 일어나지 않는다.
    }
    System.out.println(Arrays.toString(tvArr));
    for (var i = 0; i < tvArr.length; ++i) {
      tvArr[i] = new TV(); // 비로소 참조값이 저장이 된다. 간접적으로는 안되는 건가?
    }
    System.out.println(Arrays.toString(tvArr)); // 생성한 뒤에 출력하면 인스턴스 가리키는 주소들을 뱉어냄.

    /// # Any 객체 배열
    Object[] anyArr = new Object[3];
    anyArr[0] = new String("Hello World!");
    anyArr[1] = 32;
    anyArr[2] = new TV();
    System.out.println(Arrays.toString(anyArr)); // 아무 타입이나 다 들어간다!
  }
}