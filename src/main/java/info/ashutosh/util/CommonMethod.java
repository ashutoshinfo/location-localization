package info.ashutosh.util;

public class CommonMethod {

	public static Long stringToLong(String StringLong) {

		if (StringLong == null) {
			return null;
		}
		String trimmed = StringLong.trim();

		if (trimmed.isEmpty()) {
			return null;
		}

		try {
			return Long.parseLong(trimmed);
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer stringToInteger(String StringInteger) {

		if (StringInteger == null) {
			return null;
		}
		String trimmed = StringInteger.trim();

		if (trimmed.isEmpty()) {
			return null;
		}

		try {
			return Integer.parseInt(trimmed);
		} catch (Exception e) {
			return null;
		}
	}
	

	/**
	 * This Method return Trimmed String or null.
	 * 
	 * @param str
	 * @return String Trimmed String
	 */
	public static String trimString(String str) {

		if (str == null) {
			return null;
		}

		String trimmed = str.trim();

		if (trimmed.isEmpty()) {
			return null;
		}

		return trimmed;
	}

}
