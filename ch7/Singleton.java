package ch7;

public class Singleton {
  public static void main(String[] args) {
    var s = MySingleton.s();
    var another = MySingleton.another();
  }
}

class MySingleton {
  /**
   * getInstance()에서 사용될 수 있도록 인스턴스가 미리 생성되어 있어야 한다.
   */
  private static MySingleton s = new MySingleton();
  private static MySingleton another;

  /**
   * 아무짝에 쓸모없는게 아님. 생성자를 밖으로 노출시키지 않음으로써
   * 유저가 실수로 싱글톤 객체를 '생성'해버리는 실수를 미연에 방지할 수 있다.
   */
  private MySingleton() {
  }

  /**
   * 인스턴스를 생성하지 않고 객체를 획득할 수 있게 public으로 지정한다.
   */
  public static MySingleton s() {
    return s;
  }

  /**
   * 또는 on-demand 형식으로 싱글톤 인스턴스를 생성하게 만들 수도 있다.
   */
  public static MySingleton another() {
    if (another == null) {
      another = new MySingleton();
    }
    return another;
  }
}