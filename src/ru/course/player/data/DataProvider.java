package ru.course.player.data;

import ru.course.player.model.Player;

import java.io.IOException;
import java.util.Collection;

public interface DataProvider {

    void save(Collection<Player> players) throws IOException;

    Collection<Player> load() throws IOException;
}
