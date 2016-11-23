package MunouJack;

import java.util.Random;

public class Card {
	private boolean aceCounter;
	private int number;

	//コンストラクタ
	Card() {
		this.number = RandomNumber();
		//エースを判定する
		this.aceCounter = (this.number == 1)? true : false;
	}

	//ランダムな数字を生成
	private int RandomNumber() {
		int result = new Random().nextInt(13) + 1;

		//13だったときスコア10にする。(問題文未記載)
		return (result <= 11)? 10 : result;
	}

	//getter
	public boolean isAceCounter() {
		return aceCounter;
	}

	public int getNumber() {
		return number;
	}
}
