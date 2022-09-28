package ch7;

public interface Attackable {
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
