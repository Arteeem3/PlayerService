package ru.course.player.service;

import ru.course.player.model.Player;

import java.util.Collection;

public interface PlayerService {
    // получить игрока по id
    Player getPlayerById(int id);

    // получить список игроков
    Collection<Player> getPlayers();

    // создать игрока (возвращает id нового игрока)
    int createPlayer(String nickname);

    // удалить игрока по id, вернёт удалённого игрока
    Player deletePlayer(int id);

    // добавить очков игроку, возвращает обновлённый счёт
    int addPoints(int playerId, int points);
}
