package ch7;

public interface Unit {
  /** 자신의 hp를 깎는 기능을 작성하시오. */
  public abstract void takeDamage(int amount);

  /** 현재 위치를 반환한다. */
  public abstract Point2D position();

  /** 현재 체력을 반환한다. */
  public abstract int hp();

  /** 현재 방어구 효율을 반환한다. */
  public abstract int guard();
}

abstract class UnitImpl implements Unit {
  Point2D pos;
  int hp;
  int guard;

  @Override
  public Point2D position() {
    return pos;
  }

  @Override
  public int hp() {
    return hp;
  }

  @Override
  public int guard() {
    return guard;
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

}

abstract class GroundUnit extends UnitImpl {
}

abstract class AirUnit extends UnitImpl {
}