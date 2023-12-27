/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy;
import de.esolutions.fw.comm.dsi.browser.impl.PathInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.PathInfo;

class DSIBrowserBookmarkProxy$5
implements ISerializable {
    private final /* synthetic */ PathInfo val$exportinfo;
    private final /* synthetic */ DSIBrowserBookmarkProxy this$0;

    DSIBrowserBookmarkProxy$5(DSIBrowserBookmarkProxy dSIBrowserBookmarkProxy, PathInfo pathInfo) {
        this.this$0 = dSIBrowserBookmarkProxy;
        this.val$exportinfo = pathInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        PathInfoSerializer.putOptionalPathInfo(iSerializer, this.val$exportinfo);
    }
}

