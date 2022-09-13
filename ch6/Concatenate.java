package ch6;

public class Concatenate {
  static String concatenate(char delim, String... args) {
    String result = "";
    for (String string : args) {
      result += string + delim;
    }
    return result;
  }

  static String concatenate(String... args) {
    return concatenate(' ', args);
  }

  public static void main(String[] args) {
    System.out.println(
        concatenate(
            '|',
            "hello", "world", "my", "name", "is", "choi", "wheatley"));
    String[] strArr = { "Hello", "this", "is", "string", "array" };
    System.out.println(
        concatenate(
            strArr));
  }

}
