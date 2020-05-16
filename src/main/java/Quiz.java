import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

@WebServlet(name = "Quiz", value = "/quiz")
public class Quiz extends HttpServlet {
    QuestionBase questionBase = new QuestionBase();
    int numberLeftQuestion = QuestionBase.questionsList.size();
    List<Question> usedQuestion = new ArrayList<>();
    String parameter;


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String parameter = httpServletRequest.getParameter("parameter");

        if (parameter.equals("new_game")) {
            newGame();
            httpServletRequest.setAttribute("Start", "START");
            httpServletRequest.getRequestDispatcher("Quiz.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("Start", "START");
            httpServletRequest.getRequestDispatcher("Quiz.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        parameter = httpServletRequest.getParameter("parameter");

        if (parameter.equals("next_question")) {
            showQuestion(httpServletRequest, httpServletResponse);

        } else if (parameter.equals("A") || parameter.equals("B") || parameter.equals("C") || parameter.equals("D")) {
            getUserAnswer(httpServletRequest, httpServletResponse, parameter);
        }
    }

    private void getUserAnswer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String parameter) throws ServletException, IOException {
        String userAnswer = parameter;
        String correctAnswer = httpServletRequest.getParameter("correctAnswer");
        boolean answerIsCorrect = checkAnswer(userAnswer, correctAnswer);
        if (answerIsCorrect) {

            httpServletRequest.getRequestDispatcher("CorrectAnswet.jsp").forward(httpServletRequest, httpServletResponse);

        } else {
            httpServletRequest.setAttribute("Lost", "Smutny Hubert");
            httpServletRequest.getRequestDispatcher("Quiz.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    private void showQuestion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Question question = getRandomQuestion();
        if (question == null) {
            httpServletRequest.setAttribute("Lost", "Sorry, no more questions");
            httpServletRequest.getRequestDispatcher("Quiz.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("Show_question", "sq");
            httpServletRequest.setAttribute("quest", question);
            httpServletRequest.getRequestDispatcher("Quiz.jsp").forward(httpServletRequest, httpServletResponse);
        }


    }

    public Question getRandomQuestion() {
        Question question;
        if (numberLeftQuestion == 0) {

            return null;
        } else {
            Random random = new Random();
            int i = random.nextInt(QuestionBase.questionsList.size());
            System.out.println(i);
            question = QuestionBase.questionsList.get(i);

            if (usedQuestion.contains(question)) {
                getRandomQuestion();
            } else {
                usedQuestion.add(question);
                numberLeftQuestion--;
            }
        }
        return question;
    }

    public boolean checkAnswer(String userAnswer, String correctAnswer) {
        StringTokenizer st = new StringTokenizer(userAnswer);
        String userAnswerToc = st.nextToken();
        return correctAnswer.equals(userAnswerToc);

    }

    private void newGame() {
        numberLeftQuestion = QuestionBase.questionsList.size();
        usedQuestion.clear();
    }

}
