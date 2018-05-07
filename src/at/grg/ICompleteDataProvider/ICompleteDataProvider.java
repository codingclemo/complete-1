package at.grg.ICompleteDataProvider;

import at.grg.Data.User;

public interface ICompleteDataProvider {
   
    // User 
    public User getUserByUsername(String username) ;
    public boolean addUser(String userame, String password, int regionId);
    public int authenticateUser(String username, String password);
    
    // Region
    public boolean addRegion(int regionId, String name );

    // card
    public boolean addCard(int id, int teamId, String name);
    
    // team
    public boolean addTeam(int id, String name);
}
