/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.timer;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;

public interface TimerService {
    default public Timer createTimer(TimerNotifier timerNotifier, int n) {
    }
}

