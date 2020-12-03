/**
 * @author : kyd
 * @created : 2020-12-03
**/

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

  private static class Interval {

    public Interval (int start, int end) {
      this.start = start;
      this.end = end;
    }

    int start;
    int end;

  }

  public static void main(String arg[]){

    Interval[] intervals = {
      new Interval(5, 10),
      new Interval(0, 30),
      new Interval(1, 4),
    };

    boolean result = solve(intervals);

    System.out.println("result = " + result);

  }

  private static boolean solve(Interval[] intervals){

    boolean result = true;

    Arrays.sort(intervals, Comparator.comparingInt((Interval i2) -> i2.start));

    for(int i = 1; i < intervals.length; i++){
      if(intervals[i - 1].end > intervals[i].end){
        result = false;
      }
    }

    return result;

  }

}
