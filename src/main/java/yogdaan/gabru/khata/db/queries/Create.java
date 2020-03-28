package yogdaan.gabru.khata.db.queries;

public interface Create {
	String createBankTable =
		"create table librebank (" +
		"id integer PRIMARY KEY NOT NULL," +
		"desc text NOT NULL" +
		");";

	String createAccountsTable =
		"create table accounts (" +
		"acno text PRIMARY KEY NOT NULL," +
		"bankname text NOT NULL," +
		"acholdername text NOT NULL," +
		"balance real NOT NULL" +
		");";

	String createCardsTable =
		"create table cards (" +
		"cardno text PRIMARY KEY NOT NULL," +
		"cardname text NOT NULL," +
		"cardcvv text NOT NULL," +
		"cardexpiry text NOT NULL," +
		"cardprovider text" +
		");";
}
