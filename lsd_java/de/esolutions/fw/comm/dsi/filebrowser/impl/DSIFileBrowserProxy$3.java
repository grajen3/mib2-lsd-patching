/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.BrowsedFileSetSerializer;
import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.BrowsedFileSet;

class DSIFileBrowserProxy$3
implements ISerializable {
    private final /* synthetic */ int val$callerID;
    private final /* synthetic */ BrowsedFileSet val$files;
    private final /* synthetic */ DSIFileBrowserProxy this$0;

    DSIFileBrowserProxy$3(DSIFileBrowserProxy dSIFileBrowserProxy, int n, BrowsedFileSet browsedFileSet) {
        this.this$0 = dSIFileBrowserProxy;
        this.val$callerID = n;
        this.val$files = browsedFileSet;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$callerID);
        BrowsedFileSetSerializer.putOptionalBrowsedFileSet(iSerializer, this.val$files);
    }
}

