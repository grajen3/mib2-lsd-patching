/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling;

import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public class Timer
implements Loggable {
    private final AbstractTarget target;
    private final int eventId;
    private long timeout;

    public Timer(AbstractTarget abstractTarget, int n) {
        this.target = abstractTarget;
        this.eventId = n;
    }

    public void start(int n) {
        this.timeout = n;
        this.target.startTimer(this.eventId, (long)n, false);
    }

    public void stop() {
        if (this.isActive()) {
            this.target.stopTimer(this.eventId);
        }
    }

    public boolean isActive() {
        return this.target.getTimerServer().isTimerActive(this.target.getTargetId(), this.eventId);
    }

    public void restartOrStart() {
        this.target.getTimerServer().restartOrStartTimedEvent(this.target.getTargetId(), this.eventId, this.timeout, false);
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append(this.timeout).append("ms");
    }
}

