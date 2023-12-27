/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.Action;
import de.vw.mib.genericevents.EventGeneric;

public class GenericAction
implements Action {
    private final int systemEvent;
    private final int downEvent;

    public GenericAction(int n, int n2) {
        this.systemEvent = n;
        this.downEvent = n2;
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == this.downEvent) {
            this.onAction();
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (n == this.downEvent) {
            this.onAction();
        }
    }

    protected void onAction() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.systemEvent);
    }

    @Override
    public int getDownEvent() {
        return this.downEvent;
    }
}

