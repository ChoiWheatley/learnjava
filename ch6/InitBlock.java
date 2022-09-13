package ch6;

public class InitBlock {
  public static void main(String[] args) {
    System.out.println("static property init sequence: ");
    System.out.println("\t1. default value");
    System.out.println("\t2. explicit initialization");
    System.out.println("\t3. static init block (called only once)");
    System.out.println("instance property init sequence: ");
    System.out.println("\t1. default value");
    System.out.println("\t2. explicit initialization");
    System.out.println("\t3. instance init block");
    System.out.println("\t4. initializer");
    for (var i = 0; i < 5; ++i) {
      var block = new BlockTest();
      System.out.println("serialNo = " + block.serialNo);
    }
  }
}

class BlockTest {
  static int count = 0; // explicit init
  /// class init block (static init block)
  static {
    System.out.println("class init block!");
  }

  int serialNo;
  /// instance init block
  {
    count++;
    serialNo = count;
    System.out.println("instance init block!");
  }

  BlockTest() {
    System.out.println("initializer!");
  }
}
