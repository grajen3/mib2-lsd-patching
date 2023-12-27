/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.BrowsedFileSerializer;
import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.BrowsedFile;

class DSIFileBrowserProxy$4
implements ISerializable {
    private final /* synthetic */ int val$sessionHandle;
    private final /* synthetic */ BrowsedFile val$f;
    private final /* synthetic */ boolean val$selected;
    private final /* synthetic */ DSIFileBrowserProxy this$0;

    DSIFileBrowserProxy$4(DSIFileBrowserProxy dSIFileBrowserProxy, int n, BrowsedFile browsedFile, boolean bl) {
        this.this$0 = dSIFileBrowserProxy;
        this.val$sessionHandle = n;
        this.val$f = browsedFile;
        this.val$selected = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$sessionHandle);
        BrowsedFileSerializer.putOptionalBrowsedFile(iSerializer, this.val$f);
        iSerializer.putBool(this.val$selected);
    }
}

