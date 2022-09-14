package ch7;

import java.util.Random;

public class DeckTest {
  public static void main(String[] args) {
    var deck = new Deck();
    for (final var d : deck.cardArr) {
      System.out.printf("%s, \n", d);
    }
    System.out.println("Let's begin!");
    System.out.println("top card from deck : " + deck.pick(0));
    for (var i = 0; i < 10; ++i) {
      deck.shuffle();
      System.out.println("after shuffle, top card is : " + deck.pick(0));
    }

  }
}

class Deck {
  static final int CARD_NUM = Card.KIND_MAX * Card.NUM_MAX;
  Card[] cardArr = new Card[CARD_NUM];

  Deck() {
    int idx = 0;
    for (var k = 0; k < Card.Kind.values().length; ++k) {
      for (var n = 0; n < Card.NUM_MAX; ++n) {
        // enum은 순서가 보장이 된다. Card.Kind.values()
        cardArr[idx] = new Card(Card.Kind.values()[k], n);
        ++idx;
      }
    }
  }

  public Card pick(int index) {
    return cardArr[index];
  }

  public Card pick() {
    final var idx = new Random().nextInt(Card.NUM_MAX);
    return pick(idx);
  }

  /// 카드의 순서를 섞는다.
  public void shuffle() {
    final var randomGenerator = new Random();
    for (int i = 0; i < cardArr.length; ++i) {
      final var randomIdx = randomGenerator.nextInt(CARD_NUM);
      // swap [i] and [r]
      var tmp = cardArr[i];
      cardArr[i] = cardArr[randomIdx];
      cardArr[randomIdx] = tmp;
    }
  }
}

class Card {
  public enum Kind { // https://www.baeldung.com/a-guide-to-java-enums
    CLOVER,
    HEART,
    DIAMOND,
    SPADE
  } // Kind

  public static final int KIND_MAX = 4; // 카드 무늬의 수
  public static final int NUM_MAX = 13; // 무늬별 카드 수
  static final char[] numbers = "0123456789XJQK".toCharArray();

  Kind kind;
  int number;

  Card(Kind kind, int number) {
    this.kind = kind;
    this.number = number;
  }

  Card(int kind, int number) {
  }

  Card() {
    this(Kind.SPADE, 1);
  }

  @Override
  public String toString() {
    return "{" + kind + ":" + numbers[number] + "}";
  }
}