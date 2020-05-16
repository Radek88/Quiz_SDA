import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Map<String, String> usersList = new HashMap<>();
    private static final UserRepository INSTANCE = new UserRepository();

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        return INSTANCE;
    }

    public void addToList(Users u) {
        usersList.put(u.getName(), u.getPassword());
    }

    public boolean userExist(Users u) {
        if (usersList.containsKey(u.getName()) && usersList.get(u.getName()).equals(u.getPassword())) return true;

        return false;
    }



}
