package at.grg.Data;

public class Card {
    private int id; 
    private int teamId;
    private String name; 
    
    public Card(int id, int teamId, String name) {
           this.id = id;
           this.teamId = teamId;
           this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }
}
