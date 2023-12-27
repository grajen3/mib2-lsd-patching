/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.TouchEvent;
import de.vw.mib.log4mib.LogMessage;

public final class AbstractTemplateListController$ListTouchEvent
implements TouchEvent {
    private final int type;
    private int x;
    private int y;

    public AbstractTemplateListController$ListTouchEvent(int n) {
        this.type = n;
    }

    public AbstractTemplateListController$ListTouchEvent(int n, int n2, int n3) {
        this.type = n;
        this.x = n2;
        this.y = n3;
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
        return this.type;
    }

    @Override
    public int getType() {
        return this.type;
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
    public int getZDelta() {
        return 0;
    }

    @Override
    public void setCoordinates(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ListTouchEvent: Type:").append(this.type).append("(").append(";").append(this.y).append(")");
    }
}

