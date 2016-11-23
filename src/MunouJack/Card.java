package MunouJack;

import java.util.Random;

public class Card {
	private boolean aceCounter;
	private int number;

	//コンストラクタ
	Card() {
		this.aceCounter = false;
		this.number = RandomCard();
	}

	//ランダムな数字を生成
	public int RandomCard() {
		int result = new Random().nextInt(13) + 1;

		//13だったときスコア10にする。(問題文未記載)
		if (result == 11 || result == 12 || result == 13) {
			result = 10;
		} else {
			//エースを判定する
			if (result == 1) {
				this.aceCounter = true;
			}
		}
		return result;
	}

	//getter
	public boolean isAceCounter() {
		return aceCounter;
	}

	public int getNumber() {
		return number;
	}
}
