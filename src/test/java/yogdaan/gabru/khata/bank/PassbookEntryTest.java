package yogdaan.gabru.khata.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yogdaan.gabru.khata.utils.Errors;

class PassbookEntryTest {

  @BeforeEach
  void setup() {
    Errors.clearAll();
  }

  @Test
  void itCreatesBankWithAccount() {
    LocalBank bank = LocalBank.getBankInstance();
    assertNotNull(bank);
    Account newAccount = Account.createNewAccount(
      "4031121",
      "libre bank",
      "lobre john",
      Card.newCard(),
      "libreaccount"
    );
    assertNotNull(newAccount);
    assertTrue(Errors.ok());
    bank.addAccount(newAccount);
  }

  @Test
  void itCreatesEntriesInAccount() {
    Account account = Account.createNewAccount(
      "4031121",
      "libre bank",
      "lobre john",
      Card.newCard(),
      "libreaccount"
    );
    assertNotNull(account);
    account.addEntry(new CreditEntry(43500, "salary", new Date()));
    int last = account.getPassbook().size() - 1;
    Entry recentEntry = account.getPassbook().get(last);
    assertEquals(recentEntry.getCost(), 43500.00);
    assertEquals(recentEntry.getDescription(), "salary");
    assertEquals(account.getBalance(), 43500.00);
    account.addEntry(new DebitEntry(13220, "party", new Date()));
    assertEquals(account.getBalance(), 30280.00);
  }
}
