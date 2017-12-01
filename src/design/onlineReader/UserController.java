package design.onlineReader;

import java.util.HashMap;
import java.util.Optional;

public class UserController {
    private HashMap<Integer, User> users;

    public UserController() {
        this.users = new HashMap<>();
    }

    public boolean addUser(User user) {
        if (users.containsKey(user.getId())) {
            return false;
        }
        this.users.put(user.getId(), user);
        return true;
    }

    public boolean remove(User user) {
        if (!users.containsKey(user.getId())) {
            return false;
        }
        this.users.remove(user);
        return true;
    }

    public User searchBook(String name) {
        Optional<User> userOptional = users.entrySet().stream()
                .filter(x -> x.getValue().getName().equalsIgnoreCase(name)).map(y -> y.getValue()).findFirst();
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }


}
