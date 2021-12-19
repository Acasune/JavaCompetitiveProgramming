class Solution {
  public double angleClock(int hour, int minutes) {
    if (hour == 12) {
      hour = 0;
    }
    double anglePerHour = 360.0 / 12;
    double angleHourHand = hour * anglePerHour + (((double) minutes) / 60) * anglePerHour;
    double angleMinutesHand = 360.0 * (((double) minutes) / 60);
    double ans1 = Math.max(angleHourHand, angleMinutesHand) - Math.min(angleHourHand, angleMinutesHand);
    double ans2 = Math.max(360.0 - angleHourHand, 360.0 - angleMinutesHand)
        - Math.min(360.0 - angleHourHand, 360.0 - angleMinutesHand);
    double ans3 = angleHourHand + 360.0 - angleMinutesHand;
    double ans4 = 360.0 - angleHourHand + angleMinutesHand;

    return Math.min(Math.min(ans1, ans2), Math.min(ans3, ans4));
  }
}
