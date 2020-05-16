import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("Login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        userRepository.addToList(new Users("Radek", "Radek"));
        String userName = httpServletRequest.getParameter("Login");
        String userPassword = httpServletRequest.getParameter("Password");
        Users user = new Users(userName, userPassword);
        if (userRepository.userExist(user)) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("login", user.getName());
            httpServletRequest.getRequestDispatcher("Home.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("unregistered", "Please register!");
            httpServletRequest.getRequestDispatcher("Login.jsp").forward(httpServletRequest,httpServletResponse);
        }


    }
}
