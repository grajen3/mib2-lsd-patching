/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.timer;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;

public interface TimerFactory {
    default public Timer createTimer(TimerNotifier timerNotifier, long l) {
    }
}

