package lesson_07.enumer;

public class UserStatusRun {
    public static void main(String[] args) {
        User u = new User("test@email.com");

        System.out.println(u);

        u.setStatus(UserStatus.ACTIVE);

        System.out.println(u);

        System.out.println(u.isActive());

        u.setActive(isActive(u));

        setActiveStatus(u);

        System.out.println(u);
    }

    public static void setActiveStatus(User user) {
        if (user.getStatus().equals(UserStatus.ACTIVE)) {
            user.setActive(true);
        }
    }

    public static boolean isActive(User user) {
        return user.getStatus().equals(UserStatus.ACTIVE);
    }
}