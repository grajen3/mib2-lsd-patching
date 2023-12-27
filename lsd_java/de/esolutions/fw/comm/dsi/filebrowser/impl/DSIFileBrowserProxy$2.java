/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.BrowsedFileSerializer;
import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.BrowsedFile;

class DSIFileBrowserProxy$2
implements ISerializable {
    private final /* synthetic */ int val$sessionHandle;
    private final /* synthetic */ int val$windowSize;
    private final /* synthetic */ BrowsedFile val$f;
    private final /* synthetic */ int val$numFilesBeforeWanted;
    private final /* synthetic */ DSIFileBrowserProxy this$0;

    DSIFileBrowserProxy$2(DSIFileBrowserProxy dSIFileBrowserProxy, int n, int n2, BrowsedFile browsedFile, int n3) {
        this.this$0 = dSIFileBrowserProxy;
        this.val$sessionHandle = n;
        this.val$windowSize = n2;
        this.val$f = browsedFile;
        this.val$numFilesBeforeWanted = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$sessionHandle);
        iSerializer.putInt32(this.val$windowSize);
        BrowsedFileSerializer.putOptionalBrowsedFile(iSerializer, this.val$f);
        iSerializer.putInt32(this.val$numFilesBeforeWanted);
    }
}

