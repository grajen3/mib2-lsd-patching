/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTarget;
import de.vw.mib.asl.framework.internal.startupv7r.operation.LoadPersistenceOperation;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

class LoadPersistenceOperation$1
extends AbstractStartupTarget {
    private final /* synthetic */ LoadPersistenceOperation this$0;

    LoadPersistenceOperation$1(LoadPersistenceOperation loadPersistenceOperation, GenericEvents genericEvents, Logger logger) {
        this.this$0 = loadPersistenceOperation;
        super(genericEvents, logger);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100014: {
                this.this$0.persistenceCallback(eventGeneric);
                break;
            }
        }
    }
}

