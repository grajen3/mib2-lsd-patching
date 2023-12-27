/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;

public abstract class AbstractHMIEvent
extends AbstractPooledEvent
implements HMIEvent {
    private static final boolean DRAW_ORDER_DISPATCH = Boolean.getBoolean("activatePopupDrawOrderDispatch");
    protected boolean consumed;
    protected int id;
    protected int type;
    private AppDefinition sender;
    private AppDefinition receiver;

    AbstractHMIEvent(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.viewManager.consumeEvent(this);
        if (!this.consumed || DRAW_ORDER_DISPATCH) {
            ServiceManager.statemachineManager.consumeEvent(this);
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isConsumed() {
        return this.consumed;
    }

    @Override
    public void setConsumed(boolean bl) {
        this.consumed = bl;
    }

    @Override
    public void setId(int n) {
        this.id = n;
    }

    @Override
    public AppDefinition getSender() {
        return this.sender;
    }

    void setSender(AppDefinition appDefinition) {
        this.sender = appDefinition;
    }

    @Override
    public AppDefinition getReceiver() {
        return this.receiver;
    }

    void setReceiver(AppDefinition appDefinition) {
        this.receiver = appDefinition;
    }
}

