package ch7;

public class InstanceOf {
  public static void main(String[] args) {
    Object obj = null;
    Car car = null;
    FireFighter ff = new FireFighter();
    Ambulance ambulance = new Ambulance();

    car = ff; // 자동 형 변환이 가능하다. Car 타입이 FireFighter 보다 상위에 있기 때문에
              // 멤버의 수가 더 적다.
    obj = ambulance; // 자동 형 변환이 가능하다. Object가 Ambulance보다 상위에 있기 때문.

    /**
     * Car 타입에는 water() 메서드가 없기 때문에 undefined 에러가 뜬다.
     * 따라서 이 경우에는 해당 인스턴스의 타입인 FireFighter로의 형변환을
     * 먼저 해야 한다.
     */
    // car.water();
    if (car instanceof FireFighter) {
      ((FireFighter) car).water();
    }
    /**
     * obj가 사실 어떤 인스턴스를 가지고 있을지 모를 수도 있다. 따라서 instanceof
     * 연산자를 사용하여 한 번 필터링을 하는 습관을 들이는 것이 몸에 좋고 정신에도
     * 좋다. 만약에 인스턴스의 타입과 사용하려는 멤버의 타입이 서로 다른 경우,
     * 컴파일러는 이를 잡아내지 못해 런타임 에러를 발생시키게 된다!
     */
    if (obj instanceof FireFighter) {
      ((FireFighter) obj).water();
    }
    // ((FireFighter) obj).water(); // java.lang.ClassCastException:
    if (obj instanceof Ambulance) {
      ((Ambulance) obj).siren();
    }
  }
}

class Car {
  void drive() {
    System.out.println("부릉");
  }

  void stop() {
    System.out.println("멈춰!");
  }
}

class FireFighter extends Car {
  void water() {
    System.out.println("물을 뿌린다.");
  }
}

class Ambulance extends Car {
  void siren() {
    System.out.println("애애앵");
  }
}