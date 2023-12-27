/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.ITimeOutHandler;
import de.esolutions.fw.util.commons.timeout.MonoTimerTask;

public class TimeOutTimer$TimeOutTask
extends MonoTimerTask {
    private final Thread thread;
    private final ITimeOutHandler handler;
    private boolean armed;

    public TimeOutTimer$TimeOutTask(Thread thread, ITimeOutHandler iTimeOutHandler) {
        this.thread = thread;
        this.handler = iTimeOutHandler;
        this.armed = true;
    }

    public void disarm() {
        this.armed = false;
        this.cancel();
    }

    @Override
    public void run() {
        if (this.armed) {
            this.handler.timeoutOccurred(this.thread);
        }
    }
}

