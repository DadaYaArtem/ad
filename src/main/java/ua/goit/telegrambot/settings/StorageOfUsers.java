package ua.goit.telegrambot.settings;

import java.util.concurrent.ConcurrentHashMap;

public class StorageOfUsers {
    ConcurrentHashMap<Integer, User> userSettings;

    public StorageOfUsers(){
        userSettings = new ConcurrentHashMap<>();
    }

    public void add(User user){
        userSettings.put(user.getId(), user);
    }

    public User get(int userId) { return userSettings.get(userId); }
}
