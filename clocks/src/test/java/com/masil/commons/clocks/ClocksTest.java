package com.masil.commons.clocks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ClocksTest {

    @AfterEach
    void tearDown() {
        Clocks.resetToSystem();
    }

    @Test
    @DisplayName("Clocks usually use SystemClock.")
    void use_systemClock() {
        assertThat(Clocks.getInstance()).isInstanceOf(Clocks.SystemClock.class);
    }

    @Test
    @DisplayName("When clock is frozen, Clock use FrozenClock")
    void use_frozenClock() {
        LocalDateTime freeze = LocalDateTime.of(2021, 1, 1, 1, 1);

        Clocks.freeze(freeze);

        assertThat(Clocks.getInstance()).isInstanceOf(Clocks.FrozenClock.class);
    }

    @Test
    void freeze() {

        LocalDateTime freeze = LocalDateTime.of(2021, 1, 1, 1, 1);

        Clocks.freeze(freeze);

        assertThat(Clocks.getInstance().getNow()).isEqualTo(freeze);
    }

}

