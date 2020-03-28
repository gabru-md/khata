package yogdaan.gabru.khata.db;

public class Attribute {
	private String name;
	private Type type;
	private boolean notNull;
	private boolean primaryKey;

	public enum Type {
		INT,
		STRING,
		DOUBLE
	}

	public Attribute(String name, Type type, boolean notNull, boolean primaryKey) {
		this.name = name;
		this.type = type;
		this.notNull = notNull;
		this.primaryKey = primaryKey;
	}

	public Attribute(String name, Type type) {
		this(name, type, false, false);
	}

	public Attribute isNotNull() {
		this.notNull = true;
		return this;
	}

	public Attribute isPrimaryKey() {
		this.primaryKey = true;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean getPrimaryKeyStatus() {
		return this.primaryKey;
	}

	public boolean getNotNullStatus() {
		return this.notNull;
	}

	private String realise(Type type) {
		if (type == Type.INT) return "integer";
		if (type == Type.STRING) return "char(150)"; else return "real";
	}

	String build() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" ").append(realise(type));
		if (primaryKey) {
			sb.append(" PRIMARY KEY");
		}
		if (notNull) {
			sb.append(" NOT NULL");
		}

		return sb.toString();
	}
}
