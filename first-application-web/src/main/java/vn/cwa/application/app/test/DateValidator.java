package vn.cwa.application.app.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
	public boolean isThisDateValid(String dateToValidate, String dateFromat) {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	public static String[] hiii(boolean hi) {

		String[] strA = new String[3];
		strA[0] = "mot";
		strA[1] = "hai";
		
		if (hi) {
			strA[2] = "ba";
		}
		
		return strA;
	}

}
