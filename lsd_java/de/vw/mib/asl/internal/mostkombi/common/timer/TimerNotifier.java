/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.timer;

import de.vw.mib.asl.internal.mostkombi.common.timer.Timer;

public interface TimerNotifier {
    default public void timerFired(Timer timer) {
    }
}

