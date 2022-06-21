package optimization.magical;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PlayerTest {

    @Test
    void getMatchPlayers() {
        // Given
        Player player = new Player();
        List<Player> basketballPlayers = buildBasketballPlayers();
        List<Player> footballPlayers = buildFootballPlayers();
        List<Player> expected = buildExpected();
        // When
        List<Player> result = player.getMatchPlayers(basketballPlayers, footballPlayers);
        // Then
        result.get(0).firstName = expected.get(0).firstName;
        result.get(0).lastName = expected.get(0).lastName;
        result.get(0).team = expected.get(0).team;
        result.get(1).firstName = expected.get(1).firstName;
        result.get(1).lastName = expected.get(1).lastName;
        result.get(1).team = expected.get(1).team;
    }

    private static List<Player> buildBasketballPlayers() {
        List<Player> basketballPlayers = new ArrayList<>();
        Player player1 = new Player();
        player1.firstName = "Jill";
        player1.lastName = "Huang";
        player1.team = "Gators";
        basketballPlayers.add(player1);
        Player player2 = new Player();
        player2.firstName = "Janko";
        player2.lastName = "Barton";
        player2.team = "Sharks";
        basketballPlayers.add(player2);
        Player player3 = new Player();
        player3.firstName = "Wanda";
        player3.lastName = "Vakulskas";
        player3.team = "Sharks";
        basketballPlayers.add(player3);
        Player player4 = new Player();
        player4.firstName = "Jill";
        player4.lastName = "Moloney";
        player4.team = "Gators";
        basketballPlayers.add(player4);
        Player player5 = new Player();
        player5.firstName = "Luuk";
        player5.lastName = "Huang";
        player5.team = "Watkins";
        basketballPlayers.add(player5);

        return basketballPlayers;
    }

    private static List<Player> buildFootballPlayers() {
        List<Player> footballPlayers = new ArrayList<>();
        Player player6 = new Player();
        player6.firstName = "Hanzla";
        player6.lastName = "Radosti";
        player6.team = "32ers";
        footballPlayers.add(player6);
        Player player7 = new Player();
        player7.firstName = "Tina";
        player7.lastName = "Watkins";
        player7.team = "Barleycorns";
        footballPlayers.add(player7);
        Player player8 = new Player();
        player8.firstName = "Alex";
        player8.lastName = "Patel";
        player8.team = "32ers";
        footballPlayers.add(player8);
        Player player9 = new Player();
        player9.firstName = "Jill";
        player9.lastName = "Huang";
        player9.team = "Barleycorns";
        footballPlayers.add(player9);
        Player player10 = new Player();
        player10.firstName = "Wanda";
        player10.lastName = "Vakulskas";
        player10.team = "Barleycorns";
        footballPlayers.add(player10);

        return footballPlayers;
    }

    private List<Player> buildExpected() {
        List<Player> expected = new ArrayList<>();
        Player player1 = new Player();
        player1.firstName = "Jill";
        player1.lastName = "Huang";
        player1.team = "Gators";
        expected.add(player1);
        Player player2 = new Player();
        player2.firstName = "Wanda";
        player2.lastName = "Vakulskas";
        player2.team = "Sharks";
        expected.add(player2);

        return expected;
    }

}