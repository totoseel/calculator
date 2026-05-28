package org.example.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertThat(game).isNotNull();
    }

    @Test
    void throwExceptionWhenInputIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> game.guess(null));
    }

    @Test
    void throwExceptionWhenInputLengthIsUnmatched() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> game.guess("12"));
    }
}