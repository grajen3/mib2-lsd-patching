/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ListReadoutEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.log4mib.LogMessage;

public final class ListReadoutEventImpl
extends AbstractPooledEvent
implements ListReadoutEvent {
    private int datasourceIndex;
    private int vAIndexListItem;
    private int viewHandlerId;

    ListReadoutEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
    }

    @Override
    public int getDatasourceIndex() {
        return this.datasourceIndex;
    }

    @Override
    public int getVAIndexListItem() {
        return this.vAIndexListItem;
    }

    @Override
    public int getViewHandlerID() {
        return this.viewHandlerId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ListReadoutEvent - vAIndexListItem: ").append(this.vAIndexListItem);
        stringBuffer.append(", viewHandlerID: ").append(this.viewHandlerId);
        stringBuffer.append(", datasourceIndex: ").append(this.datasourceIndex);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ListReadoutEvent - vAIndexListItem: ").append(this.vAIndexListItem);
        logMessage.append(", viewHandlerID: ").append(this.viewHandlerId);
        logMessage.append(", datasourceIndex: ").append(this.datasourceIndex);
    }

    void setContent(int n, int n2, int n3) {
        this.vAIndexListItem = n;
        this.viewHandlerId = n2;
        this.datasourceIndex = n3;
    }

    @Override
    void traceEvent(byte by, byte by2) {
    }
}

