package yogdaan.gabru.khata.bank;

import java.util.Date;

public class CreditEntry extends Entry {

	CreditEntry() {
		super();
	}

	CreditEntry(double cost, String description, Date date) {
		super(cost < 0 ? -1 * cost : cost, description, date);
	}

	@Override
	public Type getType() {
		return Entry.Type.CREDIT;
	}
}
