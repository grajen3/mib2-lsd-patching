/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class PopupViewEventImpl
extends AbstractPooledEvent
implements PopupViewEvent {
    private int command;
    private int dynamicStateId;
    private int popupInfoId;
    private String popupViewId;

    PopupViewEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.viewManager.consumeEvent(this);
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

    @Override
    public String getPopupViewId() {
        return this.popupViewId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("PopupViewEvent - dynamicStateId: ").append(this.dynamicStateId);
        stringBuffer.append(", popupViewId: ").append(this.popupViewId);
        stringBuffer.append(", command: ").append(this.command);
        stringBuffer.append(", popupInfoId: ").append(this.popupInfoId);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("PopupViewEvent - dynamicStateId: ").append(this.dynamicStateId);
        logMessage.append(", popupViewId: ").append(this.popupViewId);
        logMessage.append(", command: ").append(this.command);
        logMessage.append(", popupInfoId: ").append(this.popupInfoId);
    }

    void setContent(int n, String string, int n2, int n3) {
        this.dynamicStateId = n;
        this.popupViewId = string;
        this.command = n2;
        this.popupInfoId = n3;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

