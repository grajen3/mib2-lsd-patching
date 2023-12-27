/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

interface Services {
    default public Logger getASLFWLogger() {
    }

    default public ClassifiedLogger getASLListLog() {
    }

    default public ThreadSwitchingTarget getThreadSwitch() {
    }

    default public TimerManager getTimerManager() {
    }
}

