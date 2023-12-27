/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.FetchTimeoutHandler;
import de.vw.mib.asl.clientapi.list.impl.FetchTimer;
import de.vw.mib.timer.Timer;

abstract class AbstractFetchTimer
implements Runnable,
FetchTimer {
    private final FetchTimeoutHandler handler;
    private long timeout = 0;
    private Timer timer;
    private Object data;

    AbstractFetchTimer(FetchTimeoutHandler fetchTimeoutHandler) {
        this.handler = fetchTimeoutHandler;
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
            this.timer = this.createTimer();
        }
        this.timer.start();
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
    public void run() {
        Object object = this.getAndSetData(null);
        this.handler.fetchTimedOut(object);
    }

    private synchronized Object getAndSetData(Object object) {
        Object object2 = this.data;
        this.data = object;
        return object2;
    }

    protected abstract Timer createTimer() {
    }
}

