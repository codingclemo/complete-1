package at.grg.CompleteDummyDataProvider;

import java.util.ArrayList;
import java.util.TreeMap;

import at.grg.Data.Card;
import at.grg.Data.Region;
import at.grg.Data.User;
import at.grg.ICompleteDataProvider.ICompleteDataProvider;

public class CompleteDummyDataProvider implements ICompleteDataProvider {

    static int userId = 0; 
    private TreeMap<String, User> tableUser = new TreeMap<String, User>(); 
    private ArrayList<Region> listRegion = new ArrayList<Region>(); 
    private ArrayList<Card> listCard = new ArrayList<Card>(); 
    
    
    public CompleteDummyDataProvider() {
        // add dummy data;
        addUser("hans", "krankl", 1);
        addUser("luis", "figo", 2);
        
        // regions where user is at home
        addRegion(1, "Austria");
        addRegion(2, "Germany");
        addRegion(3, "Portugal");
        
        // soccer teams
        addTeam(1, "Austria");
        addTeam(2, "Germany");
        addTeam(3, "USA");
        
        // player cards
        addCard(1, 1, "Marko Arnautovic");
        addCard(2, 3, "Alexis Lallas");
        addCard(3, 3, "Freddy Adu");
        addCard(4, 2, "Lothar Matthäus");
    }
    
    @Override
    public User getUserByUsername(String username) {
        if (tableUser.containsKey(username)) {
            return tableUser.get(username);
        }
        return null;
    }

    @Override
    public boolean addUser(String username, String password, int regionId) {
        userId++;
        if (tableUser.containsKey(username)) {
            return false; 
        }
        User user = new User(userId, username, password, regionId);
        tableUser.put(username, user);
        return true; 
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        if (tableUser.containsKey(username) && tableUser.get(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addRegion(int regionId, String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addCard(int id, int teamId, String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addTeam(int id, String name) {
        // TODO Auto-generated method stub
        return false;
    }
}

