package ch6;

public class InitBlock {
  public static void main(String[] args) {
    for (var i = 0; i < 10; ++i) {
      var block = new BlockTest();
      System.out.println("serialNo = " + block.serialNo);
    }
  }
}

class BlockTest {
  static int count = 0;
  static {
    System.out.println("Welcome to static init block!");
  }

  int serialNo;
  {
    count++;
    serialNo = count;
    System.out.println("Weocome to instance init block! current serialNo is " + serialNo);
  }
}
