package yogdaan.gabru.khata.utils;

import java.util.Stack;

public class Errors {
	private static Stack<Exception> errors = null;

	public static void pushError(Exception e) {
		if (errors == null) {
			errors = new Stack<Exception>();
		}
		errors.add(e);
	}

	public static void flush() {
		while (!errors.isEmpty()) {
			Logger.error(errors.peek().getMessage());
			errors.pop();
		}
	}

	public static Exception peek() {
		if (errors == null || errors.equals(null) || errors.isEmpty()) {
			return null;
		}
		return errors.peek();
	}

	public static int size() {
		if (errors == null || errors.equals(null) || errors.isEmpty()) {
			return 0;
		}
		return errors.size();
	}

	public static void clearAll() {
		if (errors == null) {
			errors = new Stack<>();
		}
		errors.clear();
	}

	public static boolean ok() {
		if (errors.equals(null) || errors == null) return true;

		return errors.isEmpty();
	}
}
