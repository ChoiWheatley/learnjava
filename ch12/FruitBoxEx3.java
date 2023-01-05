package ch12;

import java.util.ArrayList;
import java.util.List;

import ch12.FruitBoxEx2.Apple;
import ch12.FruitBoxEx2.Box;
import ch12.FruitBoxEx2.Edible;
import ch12.FruitBoxEx2.Fruit;
import ch12.FruitBoxEx2.Grape;

public class FruitBoxEx3 {
  public static void main(String[] args) {

  }

  public static <T> void printList(List<T> ls) {
    System.out.println(ls.toString());
  }

  static class Juice {
    String name;

    public Juice(String name) {
      this.name = name + " Juice";
    }

    @Override
    public String toString() {
      return name;
    }
  }

  static class Juicer {
  }

}
