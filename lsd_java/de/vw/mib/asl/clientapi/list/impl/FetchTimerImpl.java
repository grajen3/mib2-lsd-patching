/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.asl.clientapi.list.impl.AbstractFetchTimer;
import de.vw.mib.asl.clientapi.list.impl.FetchTimeoutHandler;
import de.vw.mib.asl.clientapi.list.impl.FetchTimerImpl$1;
import de.vw.mib.asl.clientapi.list.impl.Services;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

class FetchTimerImpl
extends AbstractFetchTimer {
    private final ASLClientListImpl list;
    private final Services services;

    FetchTimerImpl(ASLClientListImpl aSLClientListImpl, Services services, FetchTimeoutHandler fetchTimeoutHandler) {
        super(fetchTimeoutHandler);
        this.list = aSLClientListImpl;
        this.services = services;
    }

    @Override
    protected Timer createTimer() {
        TimerManager timerManager = this.services.getTimerManager();
        MIBInvoker mIBInvoker = this.services.getASLInvoker();
        Invoker invoker = mIBInvoker instanceof Invoker ? (Invoker)mIBInvoker : new FetchTimerImpl$1(this, mIBInvoker);
        return timerManager.createTimer(new StringBuffer().append("ASLClientList.FetchTimer[key=").append(String.valueOf(this.list.getKey())).append(']').toString(), this.getFetchTimeout(), false, this, invoker);
    }
}

