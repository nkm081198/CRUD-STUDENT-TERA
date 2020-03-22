package vn.cwa.application.app.test;

import java.util.List;
import vn.cwa.application.app.utils.RegexUtils;

public class TestClass1 {

  private static String parttenTimestamp = "(\\d+)-(\\d+)-(\\d+)-(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)";
  private static String parttenDate = "(\\d{4})(\\d{2})(\\d{2})";
  private static String parttenX = "((\\d{4}-\\d{2}-\\d{2})-(\\d{2}\\.\\d{2}\\.\\d{2}\\.\\d+))";

  public static void main(String[] args) {

    String input = "(1998-11-08-10.11.12.134)";

    List<String> rs = RegexUtils.pregMatchPHP(parttenX, input);
    if (rs.isEmpty()) {
      System.out.println("FAIL !!");
    } else {
      System.out.println("size : " + rs.size());
      for (String str : rs) {
        System.out.println(str);
      }
    }

  }

}
