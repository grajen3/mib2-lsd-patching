/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;

public class TimerHandler {
    private final String classname;
    private final AbstractASLTarget target;
    private final IntIntOptHashMap timerMap;

    public TimerHandler(AbstractASLTarget abstractASLTarget) {
        this.classname = "TimerHandler";
        Preconditions.checkNotNull(abstractASLTarget, "CarlifeHSMTarget must not be null!");
        this.target = abstractASLTarget;
        this.timerMap = new IntIntOptHashMap();
        this.timerMap.put(171, -1434058496);
        this.timerMap.put(167, -1484390144);
        this.timerMap.put(168, -1450835712);
        this.timerMap.put(169, -1467612928);
    }

    public void startTimer(int n, long l) {
        if (this.timerMap.containsKey(n)) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("TimerHandler").append("startTimer(").append("audioConnection = ").append(n).append("  )").log();
            }
            int n2 = this.timerMap.get(n);
            if (!this.target.getTimerServer().isTimerActive(this.target.getTargetId(), n2)) {
                this.target.startTimer(n2, l, false);
            } else {
                this.target.restartTimer(n2);
            }
        }
    }

    public void stopTimer(int n) {
        if (this.timerMap.containsKey(n)) {
            int n2 = this.timerMap.get(n);
            if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), n2)) {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("TimerHandler").append("stopTimer(").append("audioConnection = ").append(n).append("  )").log();
                }
                this.target.stopTimer(n2);
            }
        }
    }

    public void stopAll() {
        IntIterator intIterator = this.timerMap.keyIterator();
        while (intIterator.hasNext()) {
            this.stopTimer(intIterator.next());
        }
    }
}

