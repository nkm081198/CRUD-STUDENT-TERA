package vn.cwa.application.app.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain1 {

  public static void main(String[] args) {
    for (int i = 2; i <= 20; i++) {
      
//      System.out.print("'app_label" + i + "value',");
//      i++;
//      System.out.println(
//          "UPDATE campaign SET label" + i + "_name = null where label" + i + "_name = '0';");
      
//      System.out.println(
//          "UPDATE campaign SET label" + i + "_flg = null where label" + i + "_name = null;");
    }
    
    List<Integer> number = Arrays.asList(2,3,4,5);
    List<Integer> square = number.stream().map(x->x*x).collect(Collectors.toList());
    square.forEach(System.out::println);
    
  }
}
