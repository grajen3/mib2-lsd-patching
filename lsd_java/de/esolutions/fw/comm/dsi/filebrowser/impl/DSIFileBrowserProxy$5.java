/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserProxy;
import de.esolutions.fw.comm.dsi.filebrowser.impl.PathSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.Path;

class DSIFileBrowserProxy$5
implements ISerializable {
    private final /* synthetic */ int val$sessionHandle;
    private final /* synthetic */ Path val$path;
    private final /* synthetic */ DSIFileBrowserProxy this$0;

    DSIFileBrowserProxy$5(DSIFileBrowserProxy dSIFileBrowserProxy, int n, Path path) {
        this.this$0 = dSIFileBrowserProxy;
        this.val$sessionHandle = n;
        this.val$path = path;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$sessionHandle);
        PathSerializer.putOptionalPath(iSerializer, this.val$path);
    }
}

