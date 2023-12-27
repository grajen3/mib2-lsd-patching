/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.log4mib.LogMessage;

public final class AbstractTemplateListController$ListHMIEvent
implements HMIEvent {
    protected AbstractTemplateListController$ListHMIEvent() {
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public void setId(int n) {
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public boolean isConsumed() {
        return false;
    }

    @Override
    public void setConsumed(boolean bl) {
    }

    @Override
    public AppDefinition getSender() {
        return null;
    }

    @Override
    public AppDefinition getReceiver() {
        return null;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ListHMIEvent: ").append(this);
    }
}

