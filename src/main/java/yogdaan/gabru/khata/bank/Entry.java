package yogdaan.gabru.khata.bank;

import java.util.Date;

public abstract class Entry {
	private double cost;
	private String description;
	private Date date;

	public enum Type {
		DEBIT,
		CREDIT
	}

	Entry() {
		this(0.0, null, null);
	}

	Entry(double cost, String description, Date date) {
		this.cost = cost;
		this.description = description;
		this.date = date;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return this.cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public abstract Type getType();
}
