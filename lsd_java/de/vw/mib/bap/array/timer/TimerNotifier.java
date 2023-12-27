/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.timer;

import de.vw.mib.bap.array.timer.Timer;

public interface TimerNotifier {
    default public void timerFired(Timer timer) {
    }
}

