package ch7;

import java.util.Arrays;

public class Composition {
  public static void main(String[] args) {
    Point[] points = {
        new Point(0, 0),
        new Point(50, 50),
        new Point(100, 50),
        new Point(75, 100),
    };
    Circle circleComposite = new CircleComposite(points[0], 30);
    Circle circleAggregate = new CircleAggregate(points[0], 30);
    Triangle triangle = new Triangle(Arrays.copyOfRange(points, 1, 1 + points.length));

    circleComposite.draw();
    circleAggregate.draw();
    triangle.draw();

    System.out
        .println("Is same between points[0] and circleComposite.center? : " +
            (points[0] == circleComposite.center));
    System.out
        .println("Is same between points[0] and circleAggregate.center? : " +
            (points[0] == circleAggregate.center));
  }
}

abstract class Shape {
  String color = "black";

  void draw() {
    System.out.println("draw with color [" + color + "]");
  }
}

/*
 * inheritance: 객체 간에 가장 강한 결합.
 */
abstract class Circle extends Shape {
  Point center;
  Integer radius;

  @Override
  void draw() {
    System.out.printf("{center = %s, radius = %d}\n", center, radius);
    super.draw();
  }
}

class CircleComposite extends Circle {
  CircleComposite(Point center, int radius) {
    /*
     * 아래는 composition이다. Circle이 죽으면 Point도 같이 죽는다. 또는 해당 객체의 소유권을
     * 다른 composition에 넘겨주어야 한다.
     * Point is **part of** a Circle
     * Circle은 Point를 **소유한다.**
     * where
     * - Circle = Commposite (owner)
     * - Point = Component (part)
     */
    this.center = new Point(center);
    this.radius = radius;
  }
}

class CircleAggregate extends Circle {
  CircleAggregate(Point center, int radius) {
    /*
     * 이렇게 하면 composition이 아니라 aggregation
     * aggregation은 동일한 생명주기를 갖지 않는 관계, 'Person'과 'Address'와 같다.
     * Circle **has a** Point
     * where
     * - Circle = Aggregate (whole)
     * - Point = Component (part)
     */
    this.center = center;
    this.radius = radius;
  }
}

class Triangle extends Shape {
  static final int NUMBER_OF_POINTS = 3;
  final Point[] vertex = new Point[NUMBER_OF_POINTS];

  Triangle(Point[] points) {
    if (points.length < NUMBER_OF_POINTS)
      return;
    for (var i = 0; i < NUMBER_OF_POINTS; ++i) {
      vertex[i] = new Point(points[i]); // composition
    }
  }

  @Override
  void draw() {
    System.out.printf("{p1 = %s, p2 = %s, p3 = %s}\n", vertex[0], vertex[1], vertex[2]);
    super.draw();
  }
}

class Point {
  Integer x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  Point(Point other) {
    x = other.x;
    y = other.y;
  }

  @Override
  public String toString() {
    return "{x = " + x + ", y = " + y + "}";
  }
}
