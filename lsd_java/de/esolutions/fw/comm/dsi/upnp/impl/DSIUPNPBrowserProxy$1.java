/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPBrowserProxy;
import de.esolutions.fw.comm.dsi.upnp.impl.ListEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.upnp.ListEntry;

class DSIUPNPBrowserProxy$1
implements ISerializable {
    private final /* synthetic */ ListEntry[] val$folderpath;
    private final /* synthetic */ DSIUPNPBrowserProxy this$0;

    DSIUPNPBrowserProxy$1(DSIUPNPBrowserProxy dSIUPNPBrowserProxy, ListEntry[] listEntryArray) {
        this.this$0 = dSIUPNPBrowserProxy;
        this.val$folderpath = listEntryArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ListEntrySerializer.putOptionalListEntryVarArray(iSerializer, this.val$folderpath);
    }
}

