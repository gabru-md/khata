package yogdaan.gabru.khata.db;

public class SQLContext {
  private String tableName;
  private String[] values;
  private String[] selectValues;

  public String build() {
    return "";
  }

  public static SQLBuilder newBuilder() {
    return new SQLBuilder();
  }
}

class SQLBuilder {
  private boolean isSelect;
  private boolean isInsert;
  private boolean isCreate;
  private String[] values;
  private String tableName;

  SQLBuilder() {}

  SQLBuilder select() {
    isSelect = true;
    return this;
  }

  SQLBuilder create() {
    isCreate = true;
    return this;
  }

  SQLBuilder insert() {
    isInsert = true;
    return this;
  }

  SQLBuilder values(String... values) {
    this.values = values;
    return this;
  }

  SQLBuilder table(String tableName) {
    this.tableName = tableName;
    return this;
  }
}
