package Users;

import Company.Inventory;

public interface IUser {
    public void login(Inventory inventory);
    public void updateProfile(String name, String email);
}
