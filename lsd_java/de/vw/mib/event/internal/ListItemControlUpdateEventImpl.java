/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ListItemControlUpdateEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.list.update.ListItemControlUpdater;
import de.vw.mib.log4mib.LogMessage;

public class ListItemControlUpdateEventImpl
extends AbstractPooledEvent
implements ListItemControlUpdateEvent {
    private int parameter1;
    private int parameter2;
    private int parameter3;
    private int type;
    private ListItemControlUpdater updater;

    ListItemControlUpdateEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        switch (this.type) {
            case 0: {
                this.updater.activatedIndexChanged_internal(this.parameter1);
                break;
            }
            case 1: {
                this.updater.itemsChanged_internal(this.parameter1, this.parameter2);
                break;
            }
            case 2: {
                this.updater.itemsInserted_internal(this.parameter1, this.parameter2, this.parameter3);
                break;
            }
            case 3: {
                this.updater.itemsRemoved_internal(this.parameter1, this.parameter2, this.parameter3);
                break;
            }
            case 4: {
                this.updater.listChanged_internal(this.parameter1);
                break;
            }
            case 5: {
                this.updater.listContentChanged_internal();
                break;
            }
            case 6: {
                this.updater.stringIndexChanged_internal();
                break;
            }
            default: {
                throw new IllegalStateException("unknown ListItemControlUpdateEvent type!");
            }
        }
    }

    @Override
    public ListItemControlUpdater getListItemControlUpdater() {
        return this.updater;
    }

    @Override
    public int getParameter_1() {
        return this.parameter1;
    }

    @Override
    public int getParameter_2() {
        return this.parameter2;
    }

    @Override
    public int getParameter_3() {
        return this.parameter3;
    }

    @Override
    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("ListItemControlUpdateEvent - updater: ").append(this.updater).append(" , type: ").append(this.type);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ListItemControlUpdateEvent - updater: ").append(this.updater).append(" , type: ").append(this.type);
    }

    void setContent(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3, int n4) {
        this.updater = listItemControlUpdater;
        this.type = n;
        this.parameter1 = n2;
        this.parameter2 = n3;
        this.parameter3 = n4;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

