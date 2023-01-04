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
    // `::` 이건 도대체 무슨 문법이여
    final Iterable<Movable> movableUnits = group.stream()
        .filter(Movable.class::isInstance)
        .map(Movable.class::cast)::iterator;

    for (var m : movableUnits) {
      m.move(new Point2D(100, 200));
      System.out.println(((Unit) m).position());
    }

    // stimpack altogether
    group.stream()
        .filter(Marine.class::isInstance)
        .map(Marine.class::cast)
        .forEach(Marine::stimPack);

    Unit enemy = new Tank();
    // group attacks an enemy;
    /* Stream과 Double coln operator를 활용한 함수형 프로그래밍 */
    group.stream()
        // .filter(Attackable.class::isInstance)
        .filter(e -> e instanceof Attackable)
        .map(Attackable.class::cast)
        .forEach(attacker -> attacker.attack(enemy));

    /* 반복문을 통해서 직접 타입체크와 캐스팅을 수행하기 */
    for (var unit : group) {
      if (unit instanceof Attackable) {
        ((Attackable) unit).attack(enemy);
      }
    }

    /* 적진 SCV가 적진 탱크를 수리하는 과정 */
    var scv = new SCV();
    scv.repair((Tank) enemy);
    System.out.println("enemy's hp: " + enemy.hp());
  }

}

interface Fightable extends Movable, Attackable {
}

class Marine extends GroundUnit implements Fightable {
  Marine() {
    this.guard = 2;
    this.hp = 10;
  }

  @Override
  public void move(Point2D p) {
    System.out.println("뚜벅뚜벅");
    this.pos = p;
  }

  @Override
  public void attack(Unit u) {
    System.out.printf("%s가 %s를 %d의 데미지로 공격합니다.\n", this, u, power());
    u.takeDamage(power());
  }

  void stimPack() {
    System.out.println("약쟁이 마린.");
  }

  @Override
  public String toString() {
    return "마린";
  }

  @Override
  public int power() {
    return 2;
  }
}

class Tank extends GroundUnit implements Fightable, Repairable {
  Tank() {
    this.hp = 30;
    this.guard = 5;
  }

  @Override
  public void move(Point2D p) {
    System.out.println("부릉부릉");
    this.pos = p;
  }

  @Override
  public void attack(Unit u) {
    System.out.printf("%s가 %s를 %d의 데미지로 공격합니다.\n", this, u, power());
    u.takeDamage(power());
  }

  @Override
  public String toString() {
    return "시즈탱크";
  }

  @Override
  public int power() {
    return 10;
  }

  @Override
  public void repairMe(int amount) {
    final var beforeHp = hp;
    hp += amount;
    System.out.printf("%s's getting repaired(from %d to %d)\n", this, beforeHp, hp);
  }
}

class Dropship extends AirUnit implements Movable, Repairable {
  Dropship() {
    this.hp = 30;
    this.guard = 15;
  }

  @Override
  public void move(Point2D p) {
    System.out.println("부아아앙");
    this.pos = p;
  }

  @Override
  public String toString() {
    return "드롭쉽";
  }

  @Override
  public void repairMe(int amount) {
    final var beforeHp = hp;
    hp += amount;
    System.out.printf("%s's getting repaired(from %d to %d)\n", this, beforeHp, hp);
  }
}

class SCV extends GroundUnit implements Fightable, Repairable {
  int power = 3;

  SCV() {
    this.hp = 15;
    this.guard = 5;
  }

  /**
   * 수리가능한 기계유닛을 수리한다.
   */
  public void repair(Repairable r) {
    System.out.printf("%s.repair -> %s(%d)\n", this, r, power);
    r.repairMe(power);
  }

  @Override
  public void move(Point2D p) {
    System.out.println("에씨비스고써!");
    this.pos.x = p.x;
    this.pos.y = p.y;
  }

  @Override
  public int power() {
    return this.power;
  }

  @Override
  public void attack(Unit u) {
    System.out.printf("SCV.attack -> %s(%d)\n", u, power());
    u.takeDamage(power());
  }

  @Override
  public void repairMe(int amount) {
    final var beforeHp = hp;
    final var afterHp = hp + amount;
    System.out.printf("%s's getting repaired(from %d to %d)\n", this, beforeHp, hp);
    hp = afterHp;
  }

  @Override
  public String toString() {
    return "SCV";
  }

}