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
      if (unit instanceof Movable) {
        ((Movable) unit).move(new Point2D(100, 200));
      }
    }

    // stimpack altogether
    group.stream().filter(unit -> unit instanceof Marine).forEach(
        marine -> ((Marine) marine).stimPack());

    Unit enemy = new Tank();
    // group attacks an enemy;
    for (var unit : group) {
      if (unit instanceof Attackable) {
        ((Attackable) unit).attack(enemy);
      }
    }
  }

}

abstract class Unit {
  Point2D pos;
  int hp;
  int guard;

  /**
   * 자신의 hp를 깎는 기능을 작성하시오.
   * 
   * @param amount 만큼의 데미지가 들어왔다.
   */
  public abstract void takeDamage(int amount);
}

interface Movable {
  /**
   * 지정된 위치로 이동하는 기능을 작성하시오.
   */
  void move(Point2D p);
}

interface Attackable {
  /**
   * 자신의 공격력을 리턴합니다.
   */
  int power();

  /**
   * 지정된 대상(u)의 hp를 깎는 기능을 작성하시오.
   * 
   * @param u enemy
   */
  void attack(Unit u);

}

interface Fightable extends Movable, Attackable {
}

class Marine extends Unit implements Fightable {
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
  public void takeDamage(int amount) {
    var damage = amount - guard;
    if (damage < 0)
      damage = 1;
    hp -= damage;
    System.out.printf("%d의 데미지를 입었습니다. %s의 현재 체력: %d\n",
        damage, this, hp);
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

class Tank extends Unit implements Fightable {
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
  public void takeDamage(int amount) {
    var damage = amount - guard;
    if (damage < 0)
      damage = 1;
    hp -= damage;
    System.out.printf("%d의 데미지를 입었습니다. %s의 현재 체력: %d\n",
        damage, this, hp);

  }

  @Override
  public String toString() {
    return "시즈탱크";
  }

  @Override
  public int power() {
    return 10;
  }
}

class Dropship extends Unit implements Fightable {
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
  public void attack(Unit u) {
    System.out.println("드롭쉽은 공격기능이 없습니다.");
  }

  @Override
  public void takeDamage(int amount) {
    var damage = amount - guard;
    if (damage < 0)
      damage = 1;
    hp -= damage;
    System.out.printf("%d의 데미지를 입었습니다. %s의 현재 체력: %d\n",
        damage, this, hp);
  }

  @Override
  public String toString() {
    return "드롭쉽";
  }

  @Override
  public int power() {
    return 0;
  }
}
