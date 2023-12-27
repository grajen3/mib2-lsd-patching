/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.flush;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.FlushController;
import de.vw.mib.genericevents.GenericEvents;

public final class ApiPersFlush {
    static final int EV_FLUSH;
    static final int EV_TIMER;
    static final int EV_TIMER_STAT;
    static final int EV_SHUTDOWN;
    static final int EV_TIMER_SHUTDOWN;
    static final int EV_TIMER_DELAY;
    static final int EV_DELAYED_FLUSH;
    static final int EV_ABORT_SHUTDOWN;
    static final int TIMEOUT_FLUSH_SECOND;
    static final int TIMEOUT_FLUSH_STATISTICS_TIMER;
    static final int TIMEOUT_SHUTDOWN;
    static final int TIMEOUT_DELAY;
    private static FlushController mController;

    public static void activate() {
        PersDebug.trace("ApiPersFlush activate", true);
        ApiPersFlush.trigger(6);
    }

    public static void deactivate() {
        PersDebug.trace("ApiPersFlush deactivate", true);
        ApiPersFlush.trigger(7);
    }

    public static void deactivateDueToError() {
        PersDebug.trace("ApiPersFlush deactivateDueToError", true);
        mController.deactivateDueToError();
        ApiPersFlush.trigger(7);
    }

    public static void activateAfterError() {
        PersDebug.trace("ApiPersFlush activateAfterError", true);
        mController.activateAfterError();
        ApiPersFlush.trigger(6);
    }

    public static void flushDatabase(boolean bl) {
        if (bl) {
            PersDebug.trace("ApiPersFlush flushDatabase with delay", true);
            ApiPersFlush.trigger(-1484390144);
        } else {
            PersDebug.trace("ApiPersFlush flushDatabase without delay", true);
            ApiPersFlush.trigger(-1585053440);
        }
    }

    public static void flushDatabaseShutdown() {
        PersDebug.trace("ApiPersFlush flushDatabaseShutdown", true);
        ApiPersFlush.trigger(-1534721792);
    }

    public static void indicatePowerstateOn() {
        PersDebug.trace("ApiPersFlush indicatePowerstateOn", true);
        ApiPersFlush.trigger(-1467612928);
    }

    public static void handleWrite(int n, long l) {
        mController.handleWrite(n, l);
    }

    public static void start(GenericEvents genericEvents, String string) {
        if (mController == null) {
            mController = new FlushController(genericEvents, string);
        }
    }

    private static void trigger(int n) {
        if (mController != null) {
            mController.triggerMe(n);
        }
    }
}

