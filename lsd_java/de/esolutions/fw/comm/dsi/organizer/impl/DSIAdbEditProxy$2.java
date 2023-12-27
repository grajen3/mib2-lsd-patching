/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.AdbEntry;

class DSIAdbEditProxy$2
implements ISerializable {
    private final /* synthetic */ AdbEntry val$entry;
    private final /* synthetic */ int val$profileIndex;
    private final /* synthetic */ DSIAdbEditProxy this$0;

    DSIAdbEditProxy$2(DSIAdbEditProxy dSIAdbEditProxy, AdbEntry adbEntry, int n) {
        this.this$0 = dSIAdbEditProxy;
        this.val$entry = adbEntry;
        this.val$profileIndex = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AdbEntrySerializer.putOptionalAdbEntry(iSerializer, this.val$entry);
        iSerializer.putInt32(this.val$profileIndex);
    }
}

