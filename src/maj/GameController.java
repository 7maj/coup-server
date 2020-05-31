package maj;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class GameController {
    private final Map<Long, Game> games;
    private final AtomicLong maxGameId;

    private final Map<Long, Player> players;
    private final AtomicLong maxPlayerId;

    public GameController() {
        games = new HashMap<Long, Game>();
        maxGameId = new AtomicLong(0);
        players = new HashMap<Long, Player>();
        maxPlayerId = new AtomicLong(0);
    }

    public Game createGame() {
        Game game = new Game(maxGameId.getAndIncrement());
        games.put(game.getId(), game);
        return game;
    }

    public Game getGame(long id) {
        return games.get(id);
    }

    public Collection<Long> gameIds() {
        return games.keySet();
    }

    public Collection<Long> playerIds() {
        return players.keySet();
    }

    public Player createPlayer(String displayName) {
        Player player = new Player(maxPlayerId.getAndIncrement(), displayName);
        players.put(player.getId(), player);
        return player;
    }

    public Player getPlayer(long id) {
        return players.get(id);
    }
}