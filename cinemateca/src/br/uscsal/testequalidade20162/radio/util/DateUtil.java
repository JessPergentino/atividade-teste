package br.uscsal.testequalidade20162.radio.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static String FORMATO_DATA = "dd/MM/yyyy";

	private static SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_DATA);

	public static String format(Date date) {
		return sdf.format(date);
	}

	public static Date parse(String dateString) throws ParseException {
		return sdf.parse(dateString);
	}

}
