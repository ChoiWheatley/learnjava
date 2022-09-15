package ch7;

import java.util.List;

public class AbstractAndInterface {
  public static void main(String[] args) {
    List<Unit> group = List.of(
        new Marine(),
        new Tank(),
        new Marine(),
        new Dropship(),
        new Marine());

    // move altogether
    for (var unit : group) {
      unit.move(100, 200);
    }

    // stimpack altogether
    group.stream().filter(unit -> unit instanceof Marine).forEach(
        marine -> ((Marine) marine).stimPack());
  }

}

abstract class Unit {
  Point2D pos;

  /**
   * 유닛별로 이동하는 법이 다르기 때문에 메서드 정의만 해놓았다.
   * 
   * @param p 목적지
   */
  abstract void move(Point2D p);

  void move(int x, int y) {
    move(new Point2D(x, y));
  }

  void stop() {
    System.out.println("stop at point " + pos);
  }
}

class Marine extends Unit {
  @Override
  void move(Point2D p) {
    System.out.println("뚜벅뚜벅");
    this.pos = p;
  }

  void stimPack() {
    System.out.println("약쟁이 마린.");
  }
}

class Tank extends Unit {
  @Override
  void move(Point2D p) {
    System.out.println("부릉부릉");
    this.pos = p;
  }
}

class Dropship extends Unit {
  @Override
  void move(Point2D p) {
    System.out.println("부아아앙");
    this.pos = p;
  }
}
