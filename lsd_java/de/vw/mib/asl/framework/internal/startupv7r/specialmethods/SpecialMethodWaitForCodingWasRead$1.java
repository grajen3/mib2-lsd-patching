/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTarget;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForCodingWasRead;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

class SpecialMethodWaitForCodingWasRead$1
extends AbstractStartupTarget {
    private final /* synthetic */ SpecialMethodWaitForCodingWasRead this$0;

    SpecialMethodWaitForCodingWasRead$1(SpecialMethodWaitForCodingWasRead specialMethodWaitForCodingWasRead, GenericEvents genericEvents, Logger logger) {
        this.this$0 = specialMethodWaitForCodingWasRead;
        super(genericEvents, logger);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100001: {
                SpecialMethodWaitForCodingWasRead.access$000(this.this$0, "[ASLStartup v8]Received initial coding, moving on..");
                SpecialMethodWaitForCodingWasRead.access$100(this.this$0);
                break;
            }
        }
    }
}

