package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question_Collection {

	List<Question> questions = new ArrayList<>();

	//問題文、選択肢、正解の配列番号を作る
	public Question_Collection() {
		/*1*/questions.add(new Question("世界で最も人口が多い国は?", 
				new String[] { "アメリカ", "中国", "ロシア", "インド" }, 3));

		/*2*/questions.add(new Question(" 次の中で哺乳類はどれ？",
				new String[] { "カエル", "ワニ", "クジラ", "カメ" }, 2));

		/*3*/questions.add(new Question(" 次の中で元素記号「O」で\n表されるものはどれ？", 
				new String[] { "金", "酸素", "銀", "鉄" }, 1));

		/*4*/questions.add(new Question(" ３, ６, ９, １２, ？  "
				+ " \n【 ? 】に入る数字はどれ？", new String[] { "15", "18", "16", "14" }, 0));

		/*5*/questions.add(new Question(" １,  ４,  ９,  １６, ？ \n "
				+ " 【 ? 】に入る数字はどれ？", new String[] { "36", "30", "25", "20" }, 2));

		/*6*/questions.add(new Question("昔ばなし「桃太郎」に登場する\n動物の組み合わせは？",
				new String[] { " 犬・猿・キジ", "犬・猫・鳥", "猿・馬・鶴", "犬・猿・兎 " }, 0));

		/*7*/questions.add(new Question("タコの心臓は\n 全部でいくつある？", 
				new String[] { "１つ", "２つ", "３つ", "４つ" }, 2));

		/*8*/questions.add(new Question("1から100までの数字を\nすべて足すと\n合計はいくつになる？", 
				new String[] { "1260", "3080", "5050", "7200" }, 2));

		/*9*/questions.add(new Question("太陽系の惑星で\n最も平均気温が高い惑星はどこ？",
				new String[] { "水星", "金星", "火星", "木星" }, 1));

		/*10*/questions.add(new Question("世界で最も高い山は\n次のうちどれ？", 
				new String[] { "キリマンジャロ", "富士山", "エベレスト", "モンブラン" }, 2));

		/*11*/questions.add(new Question("日本一多い苗字はどれ？ ", 
				new String[] { "鈴木", "佐藤", "高橋", "田中" }, 1));

		/*12*/questions.add(new Question("「ユニコーン」のモデルに\nなったとされる\n実在の動物はどれ？",
				new String[] { "サイ", "ゾウ", "キリン", "ウマ" }, 0));

		/*13*/questions.add(new Question(" A, Z, B, Y, C, ？  "
				+ " \n【 ? 】に入る数字はどれ？", new String[] { "X", "W", "D", "V" }, 0));
		
		/*14*/questions.add(new Question("太陽系の惑星の中で、自転の方向が\n"
				+ "他の多くの惑星と逆（時計回り）\n惑星はどれ？", new String[] { " 火星", "海王星", "木星", "金星" }, 3));

		/*15*/questions.add(new Question("「ホタル」が光る理由は？", 
				new String[] { "恋のアピール", "敵を驚かせるため", "体温調整", "眠気を伝えるため" }, 0));
  
		/*16*/questions.add(new Question("石川県には日本一長い〇〇があります。\nさて、〇に入る言葉はなんでしょう？",
				new String[] { "ベンチ", "滑り台", "ロープウェイ", "ブランコ" }, 0));

		/*17*/questions.add(new Question("くしゃみを止めたいとき\n体のどこを押さえると止まる？ ",
				new String[] { "へその上", "つむじ", "鼻の下", "耳たぶ" }, 2));

		/*18*/questions.add(new Question("世界共通の言葉はどれ？", 
				new String[] { "津波", "地震", "台風", "雷" }, 0));

		/*19*/questions.add(new Question(" 食べ過ぎると中毒死する恐れのある\n食べ物はどれ？",
				new String[] { "ゆりね", "グリーンピース", "ニラ", "ぎんなん" }, 3));

		/*20*/questions.add(new Question("魚のニオイが手に残ったとき、\nこすると消えやすいものは？\n",
				new String[] { "塩", "米", "酢", "ステンレス" }, 3));

		/*21*/questions.add(new Question("レモンよりビタミンCが多い果物は？",
				new String[] { "いちご", "ぶどう", "りんご", "バナナ" }, 0));

		/*22*/questions.add(new Question("“世界で最も古い国旗”として\n現在も使われているのは？\n",
				new String[] { "日本", "デンマーク", "中国", "イギリス" }, 1));

		/*23*/questions.add(new Question(" “人間が最初に感じる味覚”\nと言われるのは？\n",
				new String[] { "旨味", "苦味", "塩味", "甘味" }, 3));

		
		/*-----↓問題を増やしたいときコピペして使う。-------

				questions.add( new Question("問題文"
				,new String[]{"", "", "", ""}, 0));

		 --------------------------------------------------*/

	}

	//ランダムで問題を取り出す
	public List<Question> getRandomQuestions(int limit) {
		List<Question> shuffled = new ArrayList<>(questions);
		Collections.shuffle(shuffled); // シャッフル
		return shuffled.subList(0, Math.min(limit, shuffled.size()));
	}

}
