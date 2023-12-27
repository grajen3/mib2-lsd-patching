/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy;
import de.esolutions.fw.comm.dsi.browser.impl.PathInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.PathInfo;

class DSIBrowserBookmarkProxy$6
implements ISerializable {
    private final /* synthetic */ PathInfo val$importinfo;
    private final /* synthetic */ boolean val$append;
    private final /* synthetic */ boolean val$overwrite;
    private final /* synthetic */ DSIBrowserBookmarkProxy this$0;

    DSIBrowserBookmarkProxy$6(DSIBrowserBookmarkProxy dSIBrowserBookmarkProxy, PathInfo pathInfo, boolean bl, boolean bl2) {
        this.this$0 = dSIBrowserBookmarkProxy;
        this.val$importinfo = pathInfo;
        this.val$append = bl;
        this.val$overwrite = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PathInfoSerializer.putOptionalPathInfo(iSerializer, this.val$importinfo);
        iSerializer.putBool(this.val$append);
        iSerializer.putBool(this.val$overwrite);
    }
}

