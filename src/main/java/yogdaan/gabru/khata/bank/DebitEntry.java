package yogdaan.gabru.khata.bank;

import java.util.Date;

public class DebitEntry extends Entry {

  DebitEntry() {
    super();
  }

  DebitEntry(double cost, String description, Date date) {
    super(cost > 0 ? -1 * cost : cost, description, date);
  }

  @Override
  public Type getType() {
    return Entry.Type.DEBIT;
  }
}
