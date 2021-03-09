package data;
;

public class CardInfo { // 카드 객체만들 인스턴스
	
	private static String cardNum;
	private static String cardPw;
	private static String cardCorp;
	private static String CardExp;
	
	public static String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public static String getCardPw() {
		return cardPw;
	}

	public void setCardPw(String cardPw) {
		this.cardPw = cardPw;
	}

	public static String getCardCorp() {
		return cardCorp;
	}

	public void setCardCorp(String cardCorp) {
		this.cardCorp = cardCorp;
	}

	public static String getCardExp() {
		return CardExp;
	}

	public void setCardExp(String CardExp) {
		this.CardExp = CardExp;
	}

	public CardInfo(String cardNum, String cardPw, String cardCorp, String CardExp) {
		super();
		this.cardNum = cardNum;
		this.cardPw = cardPw;
		this.cardCorp = cardCorp;
		this.CardExp = CardExp;
	}

}

