package ch9;

public class LearnClass {
  public static void main(String[] args) {
    // new 키워드로 인스턴스화 하기
    Card c = new Card("DIAMOND", 5);
    // Class 객체를 통해 객체 생성하기
    try {
      Card c1 = Card.class
          .getConstructor(String.class, int.class)
          .newInstance("HEART", 10);
      // Card c2 = Card.class.newInstance(); // 기본생성자만을 호출할 수 있다. 하지만 대상 클래스가 기본생성자가
      // 정의되어있지 않다면?
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

final class Card {
  String kind;
  int num;

  public Card(String kind, int num) {
    this.kind = kind;
    this.num = num;
  }
}