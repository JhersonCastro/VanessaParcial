package Users;

public interface IUser {
    void login(String email, String password);
    void logout();
    void updateProfile(String name, String email);
}
