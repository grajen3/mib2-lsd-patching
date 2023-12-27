/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.AbstractASLList;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimeoutHandler;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimer;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimerImpl$1;
import de.vw.mib.asl.internal.list.impl.LogUtil;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

class AbstractASLList$FetchTimerImpl
implements Runnable,
AbstractASLList$FetchTimer {
    private long timeout = 0;
    private Timer timer;
    private Object data;
    private AbstractASLList$FetchTimeoutHandler handler;
    private final /* synthetic */ AbstractASLList this$0;

    AbstractASLList$FetchTimerImpl(AbstractASLList abstractASLList) {
        this.this$0 = abstractASLList;
    }

    @Override
    public long getFetchTimeout() {
        return this.timeout;
    }

    @Override
    public void setFetchTimeout(long l) {
        if (l < 0L) {
            throw new IllegalArgumentException("illegal negative timeout");
        }
        this.timeout = l;
        if (null != this.timer) {
            this.timer.setDelay(l);
        }
    }

    @Override
    public Object startFetchTimer(Object object) {
        Object object2 = this.getAndSetData(object);
        if (null == this.timer) {
            this.createTimer();
        }
        if (null != this.timer) {
            this.timer.start();
        }
        return object2;
    }

    @Override
    public Object stopFetchTimer() {
        if (null != this.timer) {
            this.timer.stop();
        }
        return this.getAndSetData(null);
    }

    @Override
    public void setFetchTimeoutHandler(AbstractASLList$FetchTimeoutHandler abstractASLList$FetchTimeoutHandler) {
        this.handler = abstractASLList$FetchTimeoutHandler;
    }

    @Override
    public void run() {
        Object object = this.getAndSetData(null);
        AbstractASLList$FetchTimeoutHandler abstractASLList$FetchTimeoutHandler = this.handler;
        if (null != abstractASLList$FetchTimeoutHandler) {
            abstractASLList$FetchTimeoutHandler.fetchTimedOut(object);
        } else {
            LogMessage logMessage = this.this$0.warn();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "fetchTimedOut", true);
                logMessage.append(" no timout handler defined, event is lost");
                LogUtil.appendListConfig(logMessage, this.this$0, true).log();
            }
        }
    }

    private synchronized Object getAndSetData(Object object) {
        Object object2 = this.data;
        this.data = object;
        return object2;
    }

    private void createTimer() {
        TimerManager timerManager = this.this$0.services.getTimerManager();
        ThreadSwitchingTarget threadSwitchingTarget = this.this$0.services.getThreadSwitch();
        if (null != timerManager && null != threadSwitchingTarget) {
            AbstractASLList$FetchTimerImpl$1 abstractASLList$FetchTimerImpl$1 = new AbstractASLList$FetchTimerImpl$1(this, threadSwitchingTarget);
            this.timer = timerManager.createTimer(new StringBuffer().append("ASLListFetchTimer(").append(this.this$0.deviceName).append('.').append(this.this$0.name).append(')').toString(), this.timeout, false, this, abstractASLList$FetchTimerImpl$1);
        } else if (null == threadSwitchingTarget) {
            LogMessage logMessage = this.this$0.error();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "startFetchTimer", true);
                logMessage.append("fetch timer not available - Thread Switch target not initialized for ASLCommon");
                LogUtil.appendListConfig(logMessage, this.this$0, true).log();
            }
        } else {
            LogMessage logMessage = this.this$0.warn();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "startFetchTimer", true);
                logMessage.append("fetch timer not available - TimerManager not initialized for ASLCommon");
                LogUtil.appendListConfig(logMessage, this.this$0, true).log();
            }
        }
    }
}

