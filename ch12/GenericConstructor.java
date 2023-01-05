package ch12;

public class GenericConstructor {
  public static void main(String[] args) {
    MyClass<Integer> myIntClass = new MyClass<>("");
  }

  public static class MyClass<X> {
    public <E> MyClass(E e) {
      System.out.println(e.getClass().getName());
    }
  }
}
