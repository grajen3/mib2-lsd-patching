/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.media.impl.DSIMediaBrowserProxy;
import de.esolutions.fw.comm.dsi.media.impl.ListEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.ListEntry;

class DSIMediaBrowserProxy$1
implements ISerializable {
    private final /* synthetic */ ListEntry[] val$folderpath;
    private final /* synthetic */ DSIMediaBrowserProxy this$0;

    DSIMediaBrowserProxy$1(DSIMediaBrowserProxy dSIMediaBrowserProxy, ListEntry[] listEntryArray) {
        this.this$0 = dSIMediaBrowserProxy;
        this.val$folderpath = listEntryArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ListEntrySerializer.putOptionalListEntryVarArray(iSerializer, this.val$folderpath);
    }
}

