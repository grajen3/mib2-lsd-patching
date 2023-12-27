/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPPlayerProxy;
import de.esolutions.fw.comm.dsi.upnp.impl.ListEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.upnp.ListEntry;

class DSIUPNPPlayerProxy$1
implements ISerializable {
    private final /* synthetic */ String[] val$deviceId;
    private final /* synthetic */ String val$entryID;
    private final /* synthetic */ ListEntry[] val$path;
    private final /* synthetic */ int val$timePosition;
    private final /* synthetic */ DSIUPNPPlayerProxy this$0;

    DSIUPNPPlayerProxy$1(DSIUPNPPlayerProxy dSIUPNPPlayerProxy, String[] stringArray, String string, ListEntry[] listEntryArray, int n) {
        this.this$0 = dSIUPNPPlayerProxy;
        this.val$deviceId = stringArray;
        this.val$entryID = string;
        this.val$path = listEntryArray;
        this.val$timePosition = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalStringVarArray(this.val$deviceId);
        iSerializer.putOptionalString(this.val$entryID);
        ListEntrySerializer.putOptionalListEntryVarArray(iSerializer, this.val$path);
        iSerializer.putInt32(this.val$timePosition);
    }
}

