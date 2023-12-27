/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.TouchEvent;
import de.vw.mib.log4mib.LogMessage;

public final class DefaultViewController$CancelEvent
implements TouchEvent {
    private final int type;

    public DefaultViewController$CancelEvent() {
        this.type = 11;
    }

    @Override
    public int getGestureParam1() {
        return 0;
    }

    @Override
    public int getGestureParam2() {
        return 0;
    }

    @Override
    public int getTimestamp() {
        return 0;
    }

    public int getMode() {
        super.getClass();
        return 11;
    }

    @Override
    public int getType() {
        super.getClass();
        return 11;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getZDelta() {
        return 0;
    }

    @Override
    public void setCoordinates(int n, int n2) {
    }

    @Override
    public void toString(LogMessage logMessage) {
        LogMessage logMessage2 = logMessage.append("CancelEvent: Type:");
        super.getClass();
        logMessage2.append(11);
    }
}

