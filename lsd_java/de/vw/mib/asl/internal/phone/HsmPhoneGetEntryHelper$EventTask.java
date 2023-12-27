/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper;
import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper$Task;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import org.dsi.ifc.organizer.AdbEntry;

abstract class HsmPhoneGetEntryHelper$EventTask
extends HsmPhoneGetEntryHelper$Task {
    private final EventGeneric pendingEvent;
    private final int resultObjectIndex;
    private final /* synthetic */ HsmPhoneGetEntryHelper this$0;

    HsmPhoneGetEntryHelper$EventTask(HsmPhoneGetEntryHelper hsmPhoneGetEntryHelper, int n, int n2, long[] lArray, EventGeneric eventGeneric, int n3) {
        this.this$0 = hsmPhoneGetEntryHelper;
        super(n, n2, lArray);
        this.pendingEvent = eventGeneric;
        this.resultObjectIndex = n3;
    }

    @Override
    void callback(boolean bl, AdbEntry[] adbEntryArray) {
        this.pendingEvent.setResult(bl ? 0 : 12);
        this.pendingEvent.setObject(this.resultObjectIndex, this.setResultObject(adbEntryArray, bl));
        this.pendingEvent.setBlocked(false);
        try {
            this.this$0.getEventDispatcher().sendBack(this.pendingEvent);
        }
        catch (GenericEventException genericEventException) {
            this.this$0.error(genericEventException);
        }
    }

    protected abstract Object setResultObject(AdbEntry[] adbEntryArray, boolean bl) {
    }
}

