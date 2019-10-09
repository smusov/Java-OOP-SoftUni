package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public double getRating(){
        return (players.stream().mapToDouble(Player::overallSkillLevel).sum()/5.00)/this.players.size();
    }

    public void addPlayer (Player player){
        this.players.add(player);
    }
    public void removePlayer(String name){

        for (int i = 0; i < players.size(); i++) {
            if (this.players.get(i).getName().equals(name)){
                this.players.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException(String.format("Player %s is not in %s team.",name,this.name));

    }
    private void setName(String name) {
        if (name.trim().isEmpty()||name.equals("null")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
}
