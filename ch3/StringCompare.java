package ch3;

public class StringCompare {

  public static void main(String[] args) {
    /**
     * 두 문자열을 비교할 때는 비교 연산자 '==' 대신 `equals()` 메서드를 활용해야 한다.
     * 오브젝트 간에 '=='는 객체 식별자를 비교하기 때문에 같은 내용을 갖고 있어도 다른 객체라면
     * false를 리턴할 수 있다.
     */

    final String str1 = "abc"; // new String("abc")의 syntatic sugar
    final var str2 = new String("abc");

    assert "abc" == "abc";
    assert str1 == "abc";
    assert str2 != "abc"; // "abc" 이 녀석또한 객체로 취급이 된다. str1은 "abc"을 갖고 있기때문에 == 이지만 str2는 "abc"로부터 새
                          // String을 만들었기 때문에 != 이다.
    assert str1 != str2;
    assert str1.equals(str2);
    assert str2.equals(str1);
  }
}
