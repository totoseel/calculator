package org.example.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    Game game = new Game();

    @Test
    void createGame() {
        Game game = new Game();
        assertThat(game).isNotNull();
    }

    @Test
    void throwExceptionWhenInputIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> game.guess(null));
    }
}