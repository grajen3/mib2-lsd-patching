/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class DisplayTimer {
    private static final String LOGGING_DELIM2;
    private static final long RESPONSE_TIMER_DURATION;
    private static final long SETUP_TIMER_DURATION;
    private final GenericEvents genericEvents;
    private final Logger logger;
    private static final int TARGET_RECIEVING_TIMER_EVENTS;
    private boolean displayResponseTimerActive;
    private boolean displaySetupTimerActive;

    public DisplayTimer(GenericEvents genericEvents, Logger logger) {
        DisplayTimer.checkConstructorArguments(genericEvents, logger);
        this.genericEvents = genericEvents;
        this.logger = logger;
    }

    boolean isDisplayResponseTimerActive() {
        return this.displayResponseTimerActive;
    }

    boolean isDisplaySetupTimerActive() {
        return this.displaySetupTimerActive;
    }

    void setDisplayResponseTimerActive(boolean bl) {
        this.displayResponseTimerActive = bl;
    }

    void setDisplaySetupTimerActive(boolean bl) {
        this.displaySetupTimerActive = bl;
    }

    void stopDisplayResponseTimer() {
        if (this.displayResponseTimerActive) {
            this.genericEvents.getTimerServer().stopTimedEvent(0x171100, 109510912);
            this.displayResponseTimerActive = false;
        }
    }

    void stopDisplaySetupTimer() {
        if (this.displaySetupTimerActive) {
            this.genericEvents.getTimerServer().stopTimedEvent(0x171100, 92733696);
            this.displaySetupTimerActive = false;
        }
    }

    public void triggerDisplayResponseTimer() {
        if (this.displayResponseTimerActive) {
            if (this.isTraceEnabled()) {
                this.trace("triggerVideoResponseTimer, retriggerTimer( EV_VIDEO_RESPONSE_TIMER )");
            }
            this.genericEvents.getTimerServer().restartTimedEvent(0x171100, 109510912);
        } else {
            if (this.isTraceEnabled()) {
                this.trace("triggerVideoResponseTimer, startTimer( EV_VIDEO_RESPONSE_TIMER )");
            }
            this.genericEvents.getTimerServer().sendTimedEvent(0x171100, 109510912, 0, false);
            this.displayResponseTimerActive = true;
        }
    }

    void triggerDisplaySetupTimer() {
        if (this.displaySetupTimerActive) {
            if (this.isTraceEnabled()) {
                this.trace("triggerVideoSetupTimer, retriggerTimer( EV_VIDEO_SETUP_TIMER )");
            }
            this.genericEvents.getTimerServer().restartTimedEvent(0x171100, 92733696);
        } else {
            if (this.isTraceEnabled()) {
                this.trace("triggerVideoSetupTimer, startTimer( EV_VIDEO_SETUP_TIMER )");
            }
            this.genericEvents.getTimerServer().sendTimedEvent(0x171100, 92733696, 0, false);
            this.displaySetupTimerActive = true;
        }
    }

    private static void checkConstructorArguments(GenericEvents genericEvents, Logger logger) {
        if (genericEvents == null) {
            throw new IllegalArgumentException("genericEvents argument must not be null.");
        }
        if (logger == null) {
            throw new IllegalArgumentException("logger argument must not be null.");
        }
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(4096);
    }

    private void trace(String string) {
        this.logger.trace(4096, new StringBuffer().append("[DisplayTimer] ").append(string).toString());
    }
}

