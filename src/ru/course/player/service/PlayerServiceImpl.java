package ru.course.player.service;

import ru.course.player.model.Player;

import java.util.*;

public class PlayerServiceImpl implements PlayerService{
    private Map<Integer, Player> players;
    private Set<String> nicknames;
    private int counter;

    public PlayerServiceImpl() {
        players = new HashMap<>(); // TODO: call data provider
        nicknames = new HashSet<>(); // TODO: call data provider
        counter = 0; // TODO: call data provider
    }

    @Override
    public Player getPlayerById(int id) {
        if (!this.players.containsKey(id)) {
            throw new NoSuchElementException("No such user: " + id);
        }

        return this.players.get(id);
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players.values();
    }

    @Override
    public int createPlayer(String nickname) {
        if (nicknames.contains(nickname)) {
            throw new IllegalArgumentException("Nickname is already used: " + nickname);
        }
        counter++;
        Player player = new Player(counter, nickname, 0, true);
        this.players.put(player.getId(), player);
        this.nicknames.add(nickname);
        return player.getId();
    }

    @Override
    public Player deletePlayer(int id) {
        if (!this.players.containsKey(id)) {
            throw new NoSuchElementException("No such user: " + id);
        }

        return this.players.remove(id);
    }

    @Override
    public int addPoints(int playerId, int points) {
        if (!this.players.containsKey(playerId)) {
            throw new NoSuchElementException("No such user: " + playerId);
        }

        Player player = this.players.get(playerId);
        int currentPoints = player.getPoints();
        int newPoints = currentPoints + points;
        player.setPoints(newPoints);
        return player.getPoints();
    }
}
