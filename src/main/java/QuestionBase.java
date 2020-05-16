import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class QuestionBase {

    public static List<Question> questionsList = new ArrayList<>();
    public  QuestionBase(){
        createQuestionsList();
    }

    public void createQuestionsList(){
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();

        factory.getCurrentSession();
        Session session;

        for (int i = 1; i <= 4; i++) {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Question question = session.get(Question.class,i);
            session.getTransaction().commit();
            questionsList.add(question);

        }

    }
}
