package at.grg.State;

import at.grg.Data.User;
import at.grg.ICompleteDataProvider.ICompleteDataProvider;

public final class AppState {

    private static final AppState instance = new AppState(); // singleton

    // if a user is loggedin, then here is the data
    private User user;
    private ICompleteDataProvider db; 
    
    public static AppState getInstance() {
        return instance;
    }

    private AppState() {}

    public boolean isUserLoggedIn() {
        return (user != null);
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setDatabase (ICompleteDataProvider db) {
        this.db = db;
    }
    
    public ICompleteDataProvider getDatabase() {
        return db;
    }
}
