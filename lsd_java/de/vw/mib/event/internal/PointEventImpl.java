/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.PointEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class PointEventImpl
extends AbstractHMIEvent
implements PointEvent {
    private int param1;
    private int param2;
    private int x;
    private int y;

    PointEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getGestureParam1() {
        return this.param1;
    }

    @Override
    public int getGestureParam2() {
        return this.param2;
    }

    @Override
    public int getType() {
        return 32;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("PointEvent - x: ").append(this.x);
        stringBuffer.append(", y: ").append(this.y);
        stringBuffer.append(", param1: ").append(this.param1);
        stringBuffer.append(", param2: ").append(this.param2);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("PointEvent - x: ").append(this.x);
        logMessage.append(", y: ").append(this.y);
        logMessage.append(", param1: ").append(this.param1);
        logMessage.append(", param2: ").append(this.param2);
    }

    void setContent(int n, int n2, int n3, int n4, int n5) {
        this.id = n;
        this.x = n2;
        this.y = n3;
        this.param1 = n4;
        this.param2 = n5;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

