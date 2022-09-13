package ch6;

public class Initializer {
  public static void main(String[] args) {
    var car = new Car();
    System.out.println(toString(car));
  }

  static String toString(final Car car) {
    String ret = "[ ";
    ret += "color: " + car.color + ", ";
    ret += "gearType: " + car.gearType + ", ";
    ret += "door: " + car.door + ", ";
    ret += " ]";
    return ret;
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
}
