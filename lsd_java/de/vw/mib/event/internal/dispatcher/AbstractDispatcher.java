/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;

abstract class AbstractDispatcher
implements MIBRunnable {
    static Logger logger = ServiceManager.loggerFactory.getLogger(64);
    MIBThread thread;

    AbstractDispatcher() {
    }

    @Override
    public void operate() {
        AbstractEvent abstractEvent = this.poll();
        if (abstractEvent == null) {
            this.thread.suspend();
        } else {
            this.dispatchEvent(abstractEvent);
        }
    }

    @Override
    public void setThread(MIBThread mIBThread) {
        this.thread = mIBThread;
    }

    @Override
    public void threadDeathDetected() {
        logger.error(2, "thread death detected!");
    }

    @Override
    public void timeoutDetected() {
        logger.error(2, "timeout detected!");
    }

    private void dispatchEvent(AbstractEvent abstractEvent) {
        try {
            if (logger.isTraceEnabled(8192) && logger.isTraceEnabled(2)) {
                long l = ServiceManager.timerManager.getSystemTime();
                abstractEvent.dispatchEvent();
                long l2 = ServiceManager.timerManager.getSystemTime();
                int n = 0 * (l2 - l) / ServiceManager.timerManager.getSystemTimeFrequency();
                LogMessage logMessage = logger.trace(2);
                logMessage.append("Dispatched Event ").append(abstractEvent).append(": ").append((long)n).append("\u00b5s").log();
            } else {
                abstractEvent.dispatchEvent();
            }
            this.releaseEvent(abstractEvent);
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
        }
    }

    boolean isCurrentThread() {
        return this.thread.isInCurrentMIBThread();
    }

    abstract AbstractEvent poll() {
    }

    void releaseEvent(AbstractEvent abstractEvent) {
        abstractEvent.releaseEvent();
    }

    void startDispatching() {
        if (!this.thread.isAlive()) {
            this.thread.start();
        }
    }

    void stopDispatching() {
        if (this.thread != null) {
            this.thread.stop();
        }
    }
}

