package ch7;

import java.util.ArrayList;
import java.util.List;

public class PolyArgument {
  public static void main(String[] args) {
    Buyer bob = new Buyer();
    /**
     * Product타입 아무거나 다 인자로 들어갈 수 있다.
     */
    bob.buy(new TV());
    bob.buy(new Computer());
    bob.buy(new Computer());

    bob.status();
  }
}

class Product {
  static final double MILEAGE_RATIO = 0.1;
  int price;
  int mileage;

  Product(int price) {
    this.price = price;
    this.mileage = (int) (price * MILEAGE_RATIO);
  }
}

class TV extends Product {
  TV() {
    super(100);
  }

  @Override
  public String toString() {
    return "TV";
  }
}

class Computer extends Product {
  Computer() {
    super(200);
  }

  @Override
  public String toString() {
    return "Computer";
  }
}

class Buyer {
  int money = 1000;
  int mileage = 0;
  // 구입한 제품을 저장하기 위한 배열
  List<Product> items = new ArrayList<>();

  void buy(Product p) {
    if (money < p.price) {
      System.out.println("잔액이 부족합니다.");
      return;
    }
    money -= p.price;
    mileage += p.mileage;
    System.out.println(p + " has been purchaced.");
    /**
     * composite가 아닌, Aggregate이다. TV는 Buyer의 것이지만 Buyer에 속하지는 않는다.
     */
    items.add(p);
  }

  void status() {
    System.out.printf("현재 남은 돈은 %d 만원이고 보너스 점수는 %d점 입니다.\n",
        this.money, this.mileage);
    System.out.println("현재 구매한 아이템은 " + items);
  }
}