/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ReadoutListSelectionEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.log4mib.LogMessage;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class ReadoutListSelectionEventImpl
extends AbstractPooledEvent
implements ReadoutListSelectionEvent {
    private int datasourceIndex;
    private int[] vAIndexesButtons;
    private int vAIndexListItem;
    private int viewHandlerID;

    ReadoutListSelectionEventImpl(EventPool eventPool) {
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
    public int[] getVAIndexesButtons() {
        return this.vAIndexesButtons;
    }

    @Override
    public int getVAIndexListItem() {
        return this.vAIndexListItem;
    }

    @Override
    public int getViewHandlerID() {
        return this.viewHandlerID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ReadoutListSelectionEvent - vAIndexListItem: ").append(this.vAIndexListItem);
        stringBuffer.append(", vAIndexesButtons: ").append(Arrays.toString(this.vAIndexesButtons));
        stringBuffer.append(", datasource index: ").append(this.datasourceIndex);
        stringBuffer.append(", viewHandlerID: ").append(this.viewHandlerID);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ReadoutListSelectionEvent - vAIndexListItem: ").append(this.vAIndexListItem);
        logMessage.append(", vAIndexesButtons: ").append(Arrays.toString(this.vAIndexesButtons));
        logMessage.append(", datasource index: ").append(this.datasourceIndex);
        logMessage.append(", viewHandlerID: ").append(this.viewHandlerID);
    }

    void setContent(int n, int[] nArray, int n2, int n3) {
        this.vAIndexListItem = n;
        this.vAIndexesButtons = nArray;
        this.datasourceIndex = n2;
        this.viewHandlerID = n3;
    }

    @Override
    void traceEvent(byte by, byte by2) {
    }
}

