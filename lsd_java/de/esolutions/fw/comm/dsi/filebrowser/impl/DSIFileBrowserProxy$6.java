/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIFileBrowserProxy$6
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$sourceFile;
    private final /* synthetic */ int val$desiredWidth;
    private final /* synthetic */ int val$desiredHeight;
    private final /* synthetic */ DSIFileBrowserProxy this$0;

    DSIFileBrowserProxy$6(DSIFileBrowserProxy dSIFileBrowserProxy, ResourceLocator resourceLocator, int n, int n2) {
        this.this$0 = dSIFileBrowserProxy;
        this.val$sourceFile = resourceLocator;
        this.val$desiredWidth = n;
        this.val$desiredHeight = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$sourceFile);
        iSerializer.putInt32(this.val$desiredWidth);
        iSerializer.putInt32(this.val$desiredHeight);
    }
}

