package at.grg.Data;

public class User {

    private String username;
    private String password;
    private int id;
    private int regionId;
    
    public User(int id, String username, String password, int regionId) {
        this.id = id; 
        this.username = username; 
        this.password = password; 
        this.setRegionId(regionId); 
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
