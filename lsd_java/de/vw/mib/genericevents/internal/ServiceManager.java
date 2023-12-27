/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.internal;

import de.vw.mib.error.ErrorHandler;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.diag.GenericEventTracer;
import de.vw.mib.genericevents.diag.HsmStateTracer;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.TimerManager;

public final class ServiceManager {
    public static LogManager logManager;
    public static LoggerFactory loggerFactory;
    public static ErrorHandler errorHandler;
    public static EventFactory mEventFactory;
    public static HsmStateTracer hsmTracer;
    public static GenericEventTracer eventTracer;
    public static Logger mLogger;
    public static GenericEvents mEventContext;
    public static MIBThreadManager mThreadManager;
    public static TimerManager mTimerManager;

    private ServiceManager() {
    }

    static {
        hsmTracer = HsmStateTracer.EMPTY_TRACER;
        eventTracer = GenericEventTracer.EMPTY_TRACER;
    }
}

