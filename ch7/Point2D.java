package ch7;

public class Point2D {
  int x, y;

  Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  String getLocation() {
    return "{x: " + x + ", y: " + y + "}";
  }

  @Override
  public String toString() {
    return getLocation();
  }
}
