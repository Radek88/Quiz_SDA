import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestions")
    private int questionId;
    @Column(name = "Question")
    private String question;
    @Column(name = "answer_A")
    private String answer_A;
    @Column(name = "answer_B")
    private String answer_B;
    @Column(name = "answer_C")
    private String answer_C;
    @Column(name = "answer_D")
    private String answer_D;
    @Column(name = "correctAnswer")
    private String correctAnswer;

    public Question(int questionId, String question, String answer_A, String answer_B, String answer_C, String answer_D, String correctAnswer) {
        this.questionId = questionId;
        this.question = question;
        this.answer_A = answer_A;
        this.answer_B = answer_B;
        this.answer_C = answer_C;
        this.answer_D = answer_D;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer_A() {
        return answer_A;
    }

    public String getAnswer_B() {
        return answer_B;
    }

    public String getAnswer_C() {
        return answer_C;
    }

    public String getAnswer_D() {
        return answer_D;
    }
}
