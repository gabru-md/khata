package yogdaan.gabru.khata.bank;

import yogdaan.gabru.khata.utils.Checker;
import yogdaan.gabru.khata.utils.Errors;

public class Card {
	private String cardNumber;
	private String cardName;
	private String cardCVV;
	private String cardExpiry;
	private String cardProvider;

	private Card(
		String cardNumber,
		String cardName,
		String cardCVV,
		String cardExpiry,
		String cardProvider
	)
		throws Exception {
		this.cardNumber = Checker.NullSafeCheck(cardNumber);
		this.cardName = Checker.NullSafeCheck(cardName);
		this.cardCVV = Checker.NullSafeCheck(cardCVV);
		this.cardExpiry = Checker.NullSafeCheck(cardExpiry);
		this.cardProvider = cardProvider;
	}

	private Card() {}

	public static Card newCard() {
		return new Card();
	}

	public static Card newCard(
		String cardNumber,
		String cardName,
		String cardCVV,
		String cardExpiry
	) {
		return newCard(cardNumber, cardName, cardCVV, cardExpiry, null);
	}

	public static Card newCard(
		String cardNumber,
		String cardName,
		String cardCVV,
		String cardExpiry,
		String cardProvider
	) {
		try {
			Card card = new Card(cardNumber, cardName, cardCVV, cardExpiry, cardProvider);
			return card;
		} catch (Exception e) {
			Errors.pushError(e);
			return null;
		}
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCardProvider() {
		return cardProvider;
	}

	public void setCardProvider(String cardProvider) {
		this.cardProvider = cardProvider;
	}
}
