/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ViewChangeEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class ViewChangeEventImpl
extends AbstractPooledEvent
implements ViewChangeEvent {
    private int command;
    private int driverDistractionPreventionGroupId;
    private String followingView;
    private boolean resetView;
    private int sequenceNumber;

    ViewChangeEventImpl(EventPool eventPool) {
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
    public int getDriverDistractionPreventionGroupId() {
        return this.driverDistractionPreventionGroupId;
    }

    @Override
    public String getFollowingView() {
        return this.followingView;
    }

    @Override
    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    @Override
    public boolean shouldResetView() {
        return this.resetView;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ViewChangeEvent - command: ").append(this.command);
        stringBuffer.append(", following view: ").append(this.followingView);
        if (this.resetView) {
            stringBuffer.append(", reset view: ").append(this.resetView);
        }
        if (this.sequenceNumber != -1) {
            stringBuffer.append(", sequence number: ").append(this.sequenceNumber);
        }
        if (this.driverDistractionPreventionGroupId != -1) {
            stringBuffer.append(", driver distraction prevention group id: ").append(this.driverDistractionPreventionGroupId);
        }
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ViewChangeEvent - command: ").append(this.command);
        logMessage.append(", following view: ").append(this.followingView);
        if (this.resetView) {
            logMessage.append(", reset view: ").append(this.resetView);
        }
        if (this.sequenceNumber != -1) {
            logMessage.append(", sequence number: ").append(this.sequenceNumber);
        }
        if (this.driverDistractionPreventionGroupId != -1) {
            logMessage.append(", driver distraction prevention group id: ").append(this.driverDistractionPreventionGroupId);
        }
    }

    void setContent(int n, String string, boolean bl, int n2, int n3) {
        this.command = n;
        this.followingView = string;
        this.resetView = bl;
        this.sequenceNumber = n2;
        this.driverDistractionPreventionGroupId = n3;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

