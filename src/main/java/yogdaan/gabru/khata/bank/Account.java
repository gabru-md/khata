package yogdaan.gabru.khata.bank;

import yogdaan.gabru.khata.utils.Checker;
import yogdaan.gabru.khata.utils.Errors;

public class Account {
	private String accountIdentifier;
	private String accountNumber;
	private String bankName;
	private String accountHolderName;
	private Card card;

	private Account(String accountNumber, String bankName, String accountHolderName, Card card, String accountIdentifier) throws Exception {
		this.accountNumber = Checker.NullSafeCheck(accountNumber);
		this.accountHolderName = Checker.NullSafeCheck(accountHolderName);
		this.bankName = Checker.NullSafeCheck(bankName);
		this.card = card;
		this.accountIdentifier = accountIdentifier == null ? getAndSetUniqueIdentifier() : accountIdentifier;
	}
	
	public static Account createNewAccount(String accountNumber, String bankName, String accountHolderName, Card card) {
		return createNewAccount(accountNumber, bankName, accountHolderName, card, null);
	}
	
	public static Account createNewAccount(String accountNumber, String bankName, String accountHolderName, Card card, String accountIdentifier) {
		try {
			Account newAccount = new Account(accountNumber, bankName, accountHolderName, card, accountIdentifier);
			return newAccount;
		} catch (Exception e) {
			Errors.pushError(e);
			return null;
		}
	}
	
	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String identifier) {
		this.accountIdentifier = identifier;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public boolean hasCard() {
		return this.card == null;
	}
	
	public Card getCard() {
		if(!hasCard()) {
			return null;
		}
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	private String getAndSetUniqueIdentifier() {
		return "0";
	}
}
