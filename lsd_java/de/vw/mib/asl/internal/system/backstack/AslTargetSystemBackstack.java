/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.backstack;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.system.backstack.transformer.SystemBackstackBackstackEntryCollector;
import java.util.Stack;

public final class AslTargetSystemBackstack
extends AbstractASLTarget {
    private static final String LOGGING_DELIM;
    private GenericASLList list;
    private SystemBackstackBackstackEntryCollector[] collector;
    private Stack backstack;

    public AslTargetSystemBackstack(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AslTargetSystemBackstack(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 1073744328: {
                this.processClear();
                break;
            }
            case 1073744330: {
                this.processPop();
                break;
            }
            case 1073744329: {
                this.processPush(eventGeneric);
                break;
            }
            case 1073744439: {
                this.processDelete(eventGeneric);
                break;
            }
        }
    }

    private void processPowerOn() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemBackstack] ").append("processPowerOn").log();
        }
        this.list = ListManager.getGenericASLList(3508);
        this.collector = new SystemBackstackBackstackEntryCollector[]{new SystemBackstackBackstackEntryCollector()};
        this.backstack = new Stack();
        this.setDefaultData();
    }

    private void processClear() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemBackstack] ").append("processClear").log();
        }
        this.backstack.clear();
        this.setDefaultData();
    }

    private void processPop() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemBackstack] ").append("processPop").log();
        }
        if (!this.backstack.empty()) {
            SystemBackstackBackstackEntryCollector systemBackstackBackstackEntryCollector = (SystemBackstackBackstackEntryCollector)this.backstack.pop();
            this.setData(systemBackstackBackstackEntryCollector.system_backstack_last_entry_mode, systemBackstackBackstackEntryCollector.system_backstack_last_id);
        } else {
            this.setDefaultData();
        }
    }

    private void processPush(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemBackstack] ").append("processPush").log();
        }
        SystemBackstackBackstackEntryCollector systemBackstackBackstackEntryCollector = new SystemBackstackBackstackEntryCollector();
        systemBackstackBackstackEntryCollector.system_backstack_last_id = eventGeneric.getString(0);
        systemBackstackBackstackEntryCollector.system_backstack_last_entry_mode = eventGeneric.getInt(1);
        this.backstack.push(systemBackstackBackstackEntryCollector);
        this.setDefaultData();
    }

    private void processDelete(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemBackstack] ").append("processDelete").log();
        }
        String string = eventGeneric.getString(0);
        while (!this.backstack.empty() && ((SystemBackstackBackstackEntryCollector)this.backstack.peek()).system_backstack_last_id.equals(string)) {
            this.backstack.pop();
        }
        this.setDefaultData();
    }

    private void setData(int n, String string) {
        this.collector[0].system_backstack_last_entry_mode = n;
        this.collector[0].system_backstack_last_id = string;
        this.list.updateList(this.collector);
        AslTargetSystemBackstack.writeIntegerToDatapool(3507, this.backstack.size());
    }

    private void setDefaultData() {
        this.setData(-1, "");
    }

    @Override
    public int getDefaultTargetId() {
        return 5611;
    }
}

