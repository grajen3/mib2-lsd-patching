/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper;
import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper$EventTask;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.organizer.AdbEntry;

final class HsmPhoneGetEntryHelper$GetEntriesTask
extends HsmPhoneGetEntryHelper$EventTask {
    private final /* synthetic */ HsmPhoneGetEntryHelper this$0;

    HsmPhoneGetEntryHelper$GetEntriesTask(HsmPhoneGetEntryHelper hsmPhoneGetEntryHelper, int n, int n2, long[] lArray, EventGeneric eventGeneric) {
        this.this$0 = hsmPhoneGetEntryHelper;
        super(hsmPhoneGetEntryHelper, n, n2, lArray, eventGeneric, 3);
    }

    @Override
    protected Object setResultObject(AdbEntry[] adbEntryArray, boolean bl) {
        return adbEntryArray;
    }
}

