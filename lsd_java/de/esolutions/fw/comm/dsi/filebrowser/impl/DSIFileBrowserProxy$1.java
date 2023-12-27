/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserProxy;
import de.esolutions.fw.comm.dsi.filebrowser.impl.PathSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.Path;

class DSIFileBrowserProxy$1
implements ISerializable {
    private final /* synthetic */ Path val$path;
    private final /* synthetic */ DSIFileBrowserProxy this$0;

    DSIFileBrowserProxy$1(DSIFileBrowserProxy dSIFileBrowserProxy, Path path) {
        this.this$0 = dSIFileBrowserProxy;
        this.val$path = path;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PathSerializer.putOptionalPath(iSerializer, this.val$path);
    }
}

