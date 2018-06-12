package borysov.dao;

import borysov.entity.User;

public interface MessageDao {
    void addNewMessageToDB(User currentUser, String message);
}
