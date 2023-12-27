/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.DynamicStateEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class DynamicStateEventImpl
extends AbstractPooledEvent
implements DynamicStateEvent {
    private int command;
    private int dynamicStateId;
    private int popupInfoId;

    public DynamicStateEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.popupStackManager.consumeEvent(this);
    }

    @Override
    public int getCommand() {
        return this.command;
    }

    @Override
    public int getDynamicStateId() {
        return this.dynamicStateId;
    }

    @Override
    public int getPopupInfoId() {
        return this.popupInfoId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("DynamicStateEvent - dynamicStateId: ").append(this.dynamicStateId);
        stringBuffer.append(", command: ").append(this.command);
        stringBuffer.append(", popupInfoId: ").append(this.popupInfoId);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("DynamicStateEvent - dynamicStateId: ").append(this.dynamicStateId);
        logMessage.append(", command: ").append(this.command);
        logMessage.append(", popupInfoId: ").append(this.popupInfoId);
    }

    void setContent(int n, int n2, int n3) {
        this.dynamicStateId = n;
        this.command = n2;
        this.popupInfoId = n3;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

