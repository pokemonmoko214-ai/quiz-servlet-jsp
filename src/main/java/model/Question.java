package model;

public class Question {
	String question; //問題文
	String[] choice; //選択肢
	int answer; //答え

	//コンストラクタで問題、選択肢、答えをセット
	public Question(String question, String[] choice, int answer) {
		this.question = question;
		this.choice = choice;
		this.answer = answer;

	}

	//ゲッターでで問題、選択肢、答えを返す
	public String getQuestion() {
		return question;
	}

	public String[] getChoice() {
		return choice;
	}

	public int getAnswer() {
		return answer;
	}

}