package Users;

import Company.Inventory;

public interface IUser {
    public void login(Inventory inventory);
        void updateProfile(String name, String email);
}
