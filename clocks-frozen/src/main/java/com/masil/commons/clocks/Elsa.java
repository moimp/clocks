package com.masil.commons.clocks;

import java.time.LocalDateTime;

public final class Elsa {

    public static void freeze(LocalDateTime localDateTime) {
        Clocks.freeze(localDateTime);
    }

    public static void rollback() {
        Clocks.resetToSystem();
    }
}
