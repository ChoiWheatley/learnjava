package ch6;

public class Initializer {
  public static void main(String[] args) {
    var car = new Car();
    System.out.println(car);
  }

}

class Car {
  String color;
  String gearType;
  int door;

  /* 1 */ Car() {
    // this.gearType = "auto"; // this() 가 항상 먼저 와야 한다.
    this("white"); // call 2
  }

  /* 2 */ Car(String color) {
    this(color, "auto", 4); // call 3
  }

  /* 3 */ Car(String color, String gearType, int door) {
    this.color = color;
    this.gearType = gearType;
    this.door = door;
  }

  /* copy ctor */ Car(Car other) {
    this(other.color, other.gearType, other.door);
  }

  @Override /* 뭔가 이렇게 쓰는 걸 본 적이 있다. */
  public String toString() { /* 사실 얘는 Object 메서드로, 오버라이딩 하면 println같은 함수에 객체를 집어넣어도 된다. */
    String ret = "[ ";
    ret += "color: " + this.color + ", ";
    ret += "gearType: " + this.gearType + ", ";
    ret += "door: " + this.door + ", ";
    ret += " ]";
    return ret;
  }
}
