package ch7;

public class SuperInit {
  public static void main(String[] args) {
    new Point3D(1, 2, 3);
  }
}

class Point3D extends Point2D {
  int z;

  /**
   * 생성자를 정의하지 않으면 아래와 같은 컴파일 에러를 얻게된다.
   * Implicit super constructor Point() is undefined for default constructor. Must
   * define an explicit constructor
   * 암묵적 super 생성자 Point()가 정의되지 않았습니다. 명시적 생성자를 정의하세요.
   */
  Point3D(int x, int y, int z) {
    /**
     * super() 생성자를 호출하지 않으면 아래와 같은 컴파일 에러를 얻게된다.
     * Implicit super constructor Point() is undefined. Must explicitly invoke
     * another constructor
     */
    super(x, y);
    this.z = z;
  }

  @Override
  String getLocation() {
    return "{x: " + x + ", y: " + y + ", z: " + z + "}";
  }
}
