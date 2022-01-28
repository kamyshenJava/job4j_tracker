package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User us : users) {
            if (login.equals(us.getUsername())) {
                return us;
            }
        }
        throw new UserNotFoundException("The user has not been found.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("The user is invalid.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has access.");
            }
        } catch (UserInvalidException ui) {
            System.out.println(ui.getMessage());
        } catch (UserNotFoundException unf) {
            System.out.println(unf.getMessage());
        }
    }
}