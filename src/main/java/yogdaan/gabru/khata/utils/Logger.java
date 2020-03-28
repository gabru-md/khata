package yogdaan.gabru.khata.utils;

public class Logger {
  private static final String INFO = "INFO";
  private static final String ERROR = "ERROR";
  private static final String DEBUG = "DEBUG";

  public static void log(String fmt, Object... args) {
    System.out.printf("[%s] %s\n", INFO, _f(fmt, args));
  }

  public static void info(String fmt, Object... args) {
    System.out.printf("[%s] %s\n", INFO, _f(fmt, args));
  }

  public static void error(String fmt, Object... args) {
    System.out.printf("[%s] %s\n", ERROR, _f(fmt, args));
  }

  public static void debug(String fmt, Object... args) {
    System.out.printf("[%s] %s\n", DEBUG, _f(fmt, args));
  }

  private static String _f(String fmt, Object... args) {
    return String.format(fmt, args);
  }
}
