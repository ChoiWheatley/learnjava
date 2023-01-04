package ch9;

import static java.lang.System.identityHashCode;

public class LearnObject {
  public static void main(String[] args) {
    /** equals */
    {
      final var a = new Value(0);
      final var b = new Value(0);
      final var aPtr = a;
      assert !a.equals(b);
      assert a.equals(aPtr);
      assert !(a == b);
      assert a == aPtr;
      final var integer1 = Integer.valueOf(0);
      final var integer2 = Integer.valueOf(0);
      final var int1Ptr = integer1;
      assert integer1.equals(integer2); // 같은 객체라고? No. 별도로 오버라이딩이 되어 값을 비교하는 것이다.
      assert integer1.equals(int1Ptr);
      assert integer1 == integer2;
      final var person1 = new Person(1234567890L);
      final var person2 = new Person(1234567890L);
      assert person1.equals(person2);
      assert person1 != person2;
    }
    /** hashCode */
    {
      final var str1 = new String("abc");
      final var str2 = new String("abc");
      final var str3 = "abc";
      final var str4 = "abc";
      assert str1.equals(str2);
      assert str1.equals(str3);
      assert str1.equals(str4);
      assert str1.hashCode() == str2.hashCode();
      assert str1.hashCode() == str3.hashCode();
      assert str1.hashCode() == str4.hashCode();
      assert identityHashCode(str1) != identityHashCode(str2); // 요놈은 객체의 진짜 주소값으로 생성한 해시코드
      assert identityHashCode(str1) != identityHashCode(str3); // 요놈은 객체의 진짜 주소값으로 생성한 해시코드
      assert identityHashCode(str1) != identityHashCode(str4); // 요놈은 객체의 진짜 주소값으로 생성한 해시코드
      assert identityHashCode(str3) == identityHashCode(str4); // 얘는 둘이 같다. string literal이 같으면 같은 위치에
                                                               // 저장된다.
    }
    /** clone */
    {
      final var str1 = new MyString("original");
      final var str2 = (MyString) str1.clone();
      assert !str1.equals(str2);
      final MyIntegerArray arr1 = new MyIntegerArray(1, 2, 3, 4, 5);
      final var arr2 = arr1.clone();
      assert !arr1.equals(arr2);
      for (var i = 0; i < arr1.length(); ++i) {
        assert arr1.indexOf(i).equals(arr2.indexOf(i)); // 값도 같고
        assert arr1.indexOf(i) == arr2.indexOf(i); // 가리키는 레퍼런스도 같다.
      }
      // clone array with `arraycopy()`
      int[] arr3 = { 1, 2, 3, 4, 5 };
      int[] arr4 = new int[arr3.length];
      System.arraycopy(arr3, 0, arr4, 0, arr3.length);
      // clone array with `clone()`
      int[] arr5 = arr3.clone();
      Value[] refarr1 = {
          new Value(10),
          new Value(20),
          new Value(30),
          new Value(40),
          new Value(50)
      };
      Value[] refarr2 = refarr1.clone();
      for (var i = 0; i < refarr1.length; ++i) {
        assert refarr1[i] == refarr2[i];
      }
    }
  }
}

class Value {
  public int value;

  public Value(int val) {
    this.value = val;
  }
}

/** equals 오버라이딩 하여 id가 같으면 같은 사람으로 간주한다. */
class Person {
  public long id;

  public Person(long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person) {
      return (this.id) == ((Person) obj).id;
    }
    return false;
  }
}

class MyString implements Cloneable {
  public String value;

  public MyString(String original) {
    this.value = original;
  }

  @Override
  protected Object clone() {
    Object ret = null;
    try {
      ret = super.clone();
    } catch (CloneNotSupportedException e) {
    }
    return ret;
  }
}

class MyIntegerArray implements Cloneable {
  private Integer[] container;

  public MyIntegerArray(Integer... ts) {
    container = ts;
  }

  public Integer indexOf(int idx) {
    return container[idx];
  }

  public Integer length() {
    return container.length;
  }

  @Override
  protected MyIntegerArray clone() { /** 공변타입(covariant type) 가능!, Object 타입이 아니어도 된다. */
    Object ret = null;
    try {
      ret = super.clone();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (MyIntegerArray) ret;
  }
}

class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Circle implements Cloneable {
  Point center;
  int radius;

  Circle(Point center, int radius) {
    this.center = new Point(center.x, center.y);
    this.radius = radius;
  }

  Circle(int x, int y, int radius) {
    this.center = new Point(x, y);
    this.radius = radius;
  }

  public Circle shallowCopy() {
    Object ret = null;
    try {
      ret = super.clone();
    } catch (CloneNotSupportedException e) {
    }
    return (Circle) ret;
  }

  public Circle deepCopy() {
    Object ret = null;
    try {
      ret = super.clone(); // shallow copy를 먼저 한다.
    } catch (CloneNotSupportedException e) {
    }

    return (Circle) ret;
  }
}