/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.repaint.internal;

import de.vw.mib.animation.control.AnimationManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

final class ServiceManager {
    static AnimationManager animationManager;
    static FrameworkEventDispatcher eventDispatcher;
    static LoggerFactory loggerFactory;
    static TimerManager timerManager;

    private ServiceManager() {
    }
}

