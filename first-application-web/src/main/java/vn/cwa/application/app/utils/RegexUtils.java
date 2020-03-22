package vn.cwa.application.app.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

  public static List<String> pregMatchPHP(String patternStr, String subject) {
    
    if (!pregMatch(patternStr, subject)) {
      return new ArrayList<String>();
    }
    
//    Pattern pattern = Pattern.compile(patternStr);
    Matcher matcher = Pattern.compile(patternStr).matcher(subject);
    List<String> lstRs = new ArrayList<String>();
    if (matcher.find()) {
      for (int i = 0; i <= matcher.groupCount(); i++) {
        lstRs.add(matcher.group(i));
      }
    }
    return lstRs;
  }
  
  public static boolean pregMatch(String pattern, String content) {
    return content.matches(pattern);
  }
  

}
