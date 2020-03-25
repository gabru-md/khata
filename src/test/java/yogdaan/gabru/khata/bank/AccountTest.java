package yogdaan.gabru.khata.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void itTestsAccountCreation() {
		Account account = Account.createNewAccount("123456789", "Random Bank Limited", "John Doe", Card.newCard());
		assertNotNull(account);
		account = Account.createNewAccount("123456789", "Random Bank Limited", "John Doe", null);
		assertNotNull(account);
	}

}
