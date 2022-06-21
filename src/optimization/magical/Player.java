package optimization.magical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    protected String firstName;
    protected String lastName;
    protected String team;

    protected List<Player> getMatchPlayers(List<Player> basketballPlayers, List<Player> footballPlayers) {
        Map<String, Boolean> players = new HashMap<>();

        for (Player basketballPlayer : basketballPlayers) {
            players.put(basketballPlayer.firstName + basketballPlayer.lastName, true);
        }

        basketballPlayers.clear();

        for (Player footballPlayer : footballPlayers) {
           if (players.getOrDefault(footballPlayer.firstName + footballPlayer.lastName, false)) {
               basketballPlayers.add(footballPlayer);
            }
        }

        return basketballPlayers;
    }

}
