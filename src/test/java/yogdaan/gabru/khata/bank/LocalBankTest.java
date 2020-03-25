package yogdaan.gabru.khata.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yogdaan.gabru.khata.utils.Errors;

class LocalBankTest {

	@BeforeEach
	void setup() {
		Errors.clearAll();
	}
	
	@Test
	void itChecksNotNullBankInstance() {
		LocalBank bank = LocalBank.getBankInstance();
		assertNotNull(bank);
	}
	
	@Test
	void itChecksBankAndAccountCreation() {
		LocalBank bank = LocalBank.getBankInstance();
		Account account = Account.createNewAccount("123", "random bank", "john doe", Card.newCard());
		assertNotNull(account);
		bank.addAccount(account);
		assertTrue(Errors.ok());
	}
	
	@Test
	void itChecksBankAndAccountCreationWithNullCard() {
		LocalBank bank = LocalBank.getBankInstance();
		Account account = Account.createNewAccount("123", "random bank", "john doe", null);
		bank.addAccount(account);
		assertTrue(Errors.ok());	
	}
	
	@Test
	void itChecksThatSystemFailsOnNullBankName() {
		LocalBank bank = LocalBank.getBankInstance();
		Account account = Account.createNewAccount("12345", null, "manish", null);
		bank.addAccount(account);
		assertFalse(Errors.ok());
	}

}
