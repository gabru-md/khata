package yogdaan.gabru.khata.bank;

import java.util.ArrayList;
import java.util.List;
import yogdaan.gabru.khata.utils.Checker;
import yogdaan.gabru.khata.utils.Errors;

public class LocalBank {
	private static LocalBank LOCAL_BANK = null;
	private int size;
	private List<Account> bankAccounts;

	private LocalBank() {
		bankAccounts = new ArrayList<>();
		size = 0;
	}

	public void incrementSize() {
		incrementSize(1);
	}

	public void incrementSize(int inc) {
		size += inc;
	}

	public int getSize() {
		return size;
	}

	public List<Account> getAccounts() {
		return bankAccounts;
	}

	public void addAccount(Account account) {
		if (account == null || account.equals(null)) {
			Errors.pushError(Checker.newException("Cannot create a new account!"));
			return;
		}
		bankAccounts.add(account);
		incrementSize();
	}

	public static LocalBank getBankInstance() {
		if (LOCAL_BANK == null) {
			LOCAL_BANK = new LocalBank();
		}
		return LOCAL_BANK;
	}
}
