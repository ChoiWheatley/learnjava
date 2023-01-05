package ch12;

import java.util.ArrayList;
import java.util.List;

public class FruitBoxEx2 {
  public static void main(String[] args) {
    FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
    FruitBox<Apple> appleBox = new FruitBox<Apple>();
    FruitBox<Grape> grapeBox = new FruitBox<Grape>();

    /** type mismatch: cannot convert from FruitBox<Apple> to FruitBox<Grape> */
    // FruitBox<Grape> grapeBox2 = new FruitBox<Apple>();

    /**
     * Bound mismatch: The type Toy is not a valid substitute for the
     * bounded parameter <T extends Fruit & Edible> of the type FruitBox<T>
     */
    // FruitBox<Toy> toyBox = new FruitBox<>();

    fruitBox.add(new Fruit());
    fruitBox.add(new Apple());
    fruitBox.add(new Grape());
    appleBox.add(new Apple());

    // appleBox.add(new Grape());

    grapeBox.add(new Grape());

    System.out.printf("friutBox: %s\n", fruitBox);
    System.out.printf("appleBox: %s\n", appleBox);
    System.out.printf("grapeBox: %s\n", grapeBox);
  }

  static interface Edible {
  }

  static class Fruit implements Edible {
    @Override
    public String toString() {
      return "Fruit";
    }
  }

  static class Apple extends Fruit {
    @Override
    public String toString() {
      return "Apple";
    }
  }

  static class Grape extends Fruit {
    @Override
    public String toString() {
      return "Fruit";
    }
  }

  static class Toy {
    @Override
    public String toString() {
      return "Toy";
    }
  }

  static class Box<T> {
    List<T> ls = new ArrayList<T>();

    void add(T item) {
      ls.add(item);
    }

    T get(int i) {
      return ls.get(i);
    }

    int size() {
      return ls.size();
    }

    @Override
    public String toString() {
      return ls.toString();
    }
  }

  static class FruitBox<T extends Fruit & Edible> extends Box<T> {
  }
}
