
package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Question;
import model.Question_Collection;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//------ doGet ------
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータ  を取得する
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		// ★ 1.index.jsp から来たとき → クイズトップへ
		if ("start".equals(action)) { //actionがstartの時【クイズトップ画面】
			request.getRequestDispatcher("WEB-INF/jsp/quizTop.jsp").forward(request, response);
			return;
		}

		// ★ 2. クイズ開始（トップ画面【きらめきを探す】）
		if ("quiz".equals(action)) {
			//セッションリセット
			session.removeAttribute("questions");
			session.removeAttribute("index");
			session.removeAttribute("correctCount");
		}

		// ★ 3. 初回 or リセット後 → 問題をセット
		if (session.getAttribute("questions") == null) {
			//問題クラスを生成
			Question_Collection qc = new Question_Collection();

			//問題をランダムに１０問取得
			List<Question> tenquestions = qc.getRandomQuestions(10);
			//セッションに保存---クイズ開始の準備---
			session.setAttribute("questions", tenquestions);
			session.setAttribute("index", 0);
			session.setAttribute("correctCount", 0);
		}

		// ★ 4. 現在の問題を取得
		List<Question> questions = (List<Question>) session.getAttribute("questions");
		int index = (int) session.getAttribute("index");

		// ★ 5. まだ問題がある時 → quiz.jsp【クイズ回答画面】
		if (index < questions.size()) { // 出題する問題が残っている時if入る
			request.setAttribute("currentQuestion", questions.get(index));
			request.setAttribute("index", index);//今の問題番号をセット
			request.getRequestDispatcher("WEB-INF/jsp/quiz.jsp").forward(request, response);
			return;
		}

		// ★ 6. 全問終了 → 結果画面へ
		request.getRequestDispatcher("WEB-INF/jsp/quizResult.jsp").forward(request, response);
	}

	//------ doPost ------
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//リクエストパラメーター(選んだ回答を取得)
		String answer = request.getParameter("answer");
		//セッション
		HttpSession session = request.getSession();
		//問題リストを取得
		List<Question> questions = (List<Question>) session.getAttribute("questions");
		//現在の番号を取得        
		int index = (int) session.getAttribute("index");
		//正解数をカウント
		int correctCount = (int) session.getAttribute("correctCount");
		//今の問題を取得
		Question currentQuestion = questions.get(index);

		//回答をintに変換
		int userAnswer = Integer.parseInt(answer);

		// ★ 次の問題へ進める
		session.setAttribute("index", index + 1);

		// ★ 正解判定《正解の時→if 、 不正解の時→else》
		if (userAnswer == currentQuestion.getAnswer()) {
			//正解数を+1して、ok.jsp【正解画面】
			session.setAttribute("correctCount", correctCount + 1);
			request.getRequestDispatcher("WEB-INF/jsp/ok.jsp").forward(request, response);
		} else {
			//no.jsp【不正解画面】
			request.getRequestDispatcher("WEB-INF/jsp/no.jsp").forward(request, response);
		}
		// ★ 10問終わったら結果画面へ
		// index が問題数以上なら【結果画面】へ
		if (index + 1 >= questions.size()) {
			request.getRequestDispatcher("WEB-INF/jsp/quizResult.jsp").forward(request, response);
			return;

		}
	}
}
