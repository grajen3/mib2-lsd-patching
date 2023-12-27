/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.event.TouchEvent;
import de.vw.mib.log4mib.LogMessage;

class DefaultTouchDelegator$TouchEventStub
implements TouchEvent {
    int x;
    int y;
    int param1;
    int param2;
    int type;
    int zDelta;

    public DefaultTouchDelegator$TouchEventStub(int n, int n2, int n3) {
        this.type = n;
        this.x = n2;
        this.y = n3;
        this.param1 = 0;
        this.param2 = 0;
        this.zDelta = 0;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
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
        return this.type;
    }

    @Override
    public int getZDelta() {
        return this.zDelta;
    }

    @Override
    public void setCoordinates(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    @Override
    public int getTimestamp() {
        return 0;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("TouchEventStub: Type:").append(this.type).append("(").append(this.x).append(";").append(this.y).append(")");
    }
}

