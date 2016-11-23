package MunouJack;

import java.io.IOException;

public class Blackjack {
	static int getScore(int turn, Card[] cards, boolean burstJudge) {
		int Total = 0;

		//カードの合計を計算
		for (int i = 0; i < turn; i++) {
			Total =+ cards[i].getNumber();
		}

		//1->11に変換するかどうか判定
		if (Total <= 11) {
			return (cards[turn].isAceCounter()) ? Total += 10 : Total;
		}

		//バーストしていたら-1を返す
		if (Total >= 22) {
			burstJudge = true;
		}
		return (Total >= 22) ? -1 : Total;
	}

	static boolean Blackjack_judge(int i) {
		return (i == 21) ? true : false;
	}

	public static int Key_judge() {
		int key;
		try {
			key = System.in.read();
		} catch (IOException e) {
			System.err.println("入力エラーです。");
			key = -1;
		}
		return key;
	}

	public static void main(String[] args) {
		boolean burstJudge = false;
		//カードを配列でインスタンス化
		Card[] cards = new Card[5];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card();	//配列の各要素をインスタンス化。これを書かないとぬるぽ

		}
		System.out.println(cards[0].getNumber());

		for (int turn = 1; turn <= 4; turn++) {
			int key = 0;
			System.out.println(turn + "ターン目");
			System.out.println();
			System.out.println("スコア: " + getScore(turn, cards, burstJudge));
			System.out.println("1枚目のカード: " + cards[0].getNumber());
			System.out.println("2枚目のカード: " + cards[1].getNumber());
			if (turn == 1) {
				if (Blackjack_judge(getScore(turn, cards, burstJudge))) {
					System.out.println("BlackJack(ペイアウト)です。");
					break;
				}
				if (burstJudge) {
					System.out.println("あなたの負けです。");
					break;
				}
				System.out.println("続行しますか?(yなら続行)");
				key = Key_judge();
				if ((char) key == 'y') {
					System.out.println("-------------------------------------------");
					continue;
				} else {
					System.out.println("ここで止めました。");
					System.out.println();
					System.out.println("3枚目のカードは" + cards[2].getNumber() + "でした。");
					System.out.println("4枚目のカードは" + cards[3].getNumber() + "でした。");
					System.out.println("5枚目のカードは" + cards[4].getNumber() + "でした。");
					break;
				}
			}
			if (turn == 2) {
				System.out.println("3枚目のカード: " + cards[2].getNumber());
				if (Blackjack_judge(getScore(turn, cards, burstJudge))) {
					System.out.println("BlackJackです。");
					break;
				}
				if (burstJudge) {
					System.out.println("あなたの負けです。");
					break;
				}
				System.out.println("続行しますか?(yなら続行)");
				key = Key_judge();
				if ((char) key == 'y') {
					System.out.println("-------------------------------------------");
					continue;
				} else {
					System.out.println("ここで止めました。");
					System.out.println();
					System.out.println("4枚目のカードは" + cards[3].getNumber() + "でした。");
					System.out.println("5枚目のカードは" + cards[4].getNumber() + "でした。");
					break;
				}
			}
			if (turn == 3) {
				System.out.println("3枚目のカード: " + cards[2].getNumber());
				System.out.println("4枚目のカード: " + cards[3].getNumber());
				if (Blackjack_judge(getScore(turn, cards, burstJudge))) {
					System.out.println("BlackJackです。");
					break;
				}
				if (burstJudge) {
					System.out.println("あなたの負けです。");
					break;
				}
				System.out.println("続行しますか?(yなら続行)");
				key = Key_judge();
				if ((char) key == 'y') {
					System.out.println("-------------------------------------------");
					continue;
				} else {
					System.out.println("ここで止めました。");
					System.out.println();
					System.out.println("5枚目のカードは" + cards[4] + "でした。");
					break;
				}
			}
			if (turn == 4) {
				System.out.println("3枚目のカード: " + cards[2]);
				System.out.println("4枚目のカード: " + cards[3]);
				System.out.println("5枚目のカード: " + cards[4]);
				if (Blackjack_judge(getScore(turn, cards, burstJudge))) {
					System.out.println("BlackJack+5カードです");
				} else {
					System.out.println("5カードです");
				}
			}
		}
	}
}