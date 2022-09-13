package ch6;

public class Time {
  private int hour;
  private int minute;
  private float second;

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public float getSecond() {
    return second;
  }

  public void setHour(int h) {
    if (h < 0 || h > 23)
      return;
    hour = h;
  }

  public void setMinute(int m) {
    if (m < 0 || m > 60)
      return;
    minute = m;
  }

  public void setSecond(float s) {
    if (s < 0.f || s > 59.99f)
      return;
    second = s;
  }

}
