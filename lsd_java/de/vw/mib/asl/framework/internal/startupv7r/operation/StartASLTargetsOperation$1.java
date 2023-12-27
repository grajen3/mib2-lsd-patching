/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTarget;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartASLTargetsOperation;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

class StartASLTargetsOperation$1
extends AbstractStartupTarget {
    private final /* synthetic */ StartASLTargetsOperation this$0;

    StartASLTargetsOperation$1(StartASLTargetsOperation startASLTargetsOperation, GenericEvents genericEvents, Logger logger) {
        this.this$0 = startASLTargetsOperation;
        super(genericEvents, logger);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100003: {
                this.this$0.aslTargetCallback(eventGeneric);
                break;
            }
        }
    }
}

