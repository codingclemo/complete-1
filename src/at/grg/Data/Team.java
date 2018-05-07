package at.grg.Data;

public class Team {
    private int id;
    private String name;

    public Team(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
}
