public class FloatingPoints {
  /**
   * # Floating points
   * (+-)M *2 ^ E
   * float: {
   * Sign: 1bit,
   * Exponent: 8bit,
   * Mantissa: 23bit
   * }: 32bit
   * double: {
   * Sign: 1bit,
   * Exponent: 11bit,
   * Mantissa: 52bit
   * }: 64bit
   * 
   * # Exponent:
   * 부호있는 정수, 즉, 절반을 나누어 쓴다. 이때 양쪽 맨 끝의 값(2^7, -2^7)은 각각 양의 무한대, 음의 무한대를
   * 나타내는 예약된 값이므로 사용할 수 있는 범위는 [-2^7+1, 2^7-1]이고, bases는 2^7-1 = 127이 된다.
   * bases(기저)는 단순히 0을 127로 옮겨놓은 것에 불과하다. double형에서의 bases는 뭘까? 2^11-1 = 2047
   * eg)
   * 예를 들어 float 기준으로 2^3을 floating point로 변환하고 싶다. 이 경우 Exponent값은 어떻게 될까?
   * 정답 = 3+127 = 130 (0b1000_0010)이 된다.
   * double을 기준으로 Exponent가 0b000_0000_0000이라고 가정하자, 이를 2^E의 형태로 변환할 때 E의 값은?
   * 정답 = 0 - 2047 = -2047
   * 
   * # Mantissa:
   * 가수, singer 아니다. 실제 값을 저장하는 부분을 가수라고 칭한다. IEEE에서 가수를 정규화 하도록 강제하는데,
   * 이때 정규화 하게되면 0bsomething.something을 0b1.something으로 밀어버리게 된다. 이때 가장 앞에있는 수 1은
   * 굳이 가지고 있을 필요가 없기 때문에 소수자리수만 취급한다. 무한소수이거나 Mantissa 범위를 넘어가는 자릿수는
   * 강제로 잘라낸다.
   * eg)
   * 9.1234567을 float 형으로 나타내시오.
   * 9 = 0b1001
   * 0.1234567 = 0b0001111110011010110110110110110... 무한소수
   * 9.1234567 = 0b1001.0001111110011010110110110110110...
   * normalize = 0b1.0010001111110011010110110110110110... * 2^3
   * exponent = 3 + base = 3 + 127 = 130 = 0b10000010
   * mantissa = 0b0010001111110011010110110110110110... 중 23bit =
   * = 0b00100011111100110101101
   * sign = 0
   * $sign $exponent $mantissa = 0b0_10000010_00100011111100110101101
   * eg)
   * float 형 변수 0b0_10000010_00100011111100110101101를 실수 형태로 변환하시오.
   * sign = 0: 양수
   * exponent = 0b1000_0010 - 0b0111_1111 = 0b0011 // 130 - 127 = 3
   * mantissa = 0b0010001111110011010110110110110110 =
   * 0b(1).0010001111110011010110110110110110
   * $mantissa * 2^$exponent = 0b1001.0001111110011010110110110110110 =
   * 9.1234567
   * 
   */
  public static void main(String[] args) {
    final var f = 9.1234567f;
    final var i = Float.floatToIntBits(f);

    System.out.printf("%f\n", f);
    System.out.printf("%#x\n", i);
  }
}
