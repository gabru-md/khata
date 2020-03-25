package yogdaan.gabru.khata.utils;

import java.util.Objects;

public class Checker {

	public static String NullSafeCheck(String in) throws Exception {
		if (in == null || in.equals(null) || in.length() == 0) {
			throw newException(_f("NullSafeCheck failed for input %s", in));
		}
		return in;
	}

	public static Object NullCheck(Object obj) throws Exception {
		if (obj == null || obj.equals(null)) {
			throw newException(_f("NullCheck failed for input %s", Objects.toString(obj)));
		}
		return obj;
	}

	private static String _f(String fmt, Object... args) {
		return String.format(fmt, args);
	}

	public static Exception newException(String fmt, Object... args) {
		return new Exception(_f(fmt, args));
	}
}
