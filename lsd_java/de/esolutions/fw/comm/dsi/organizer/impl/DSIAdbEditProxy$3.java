/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.AdbEntry;

class DSIAdbEditProxy$3
implements ISerializable {
    private final /* synthetic */ AdbEntry val$speedDialEntry;
    private final /* synthetic */ DSIAdbEditProxy this$0;

    DSIAdbEditProxy$3(DSIAdbEditProxy dSIAdbEditProxy, AdbEntry adbEntry) {
        this.this$0 = dSIAdbEditProxy;
        this.val$speedDialEntry = adbEntry;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AdbEntrySerializer.putOptionalAdbEntry(iSerializer, this.val$speedDialEntry);
    }
}

