/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.browser.impl.BookmarkSerializer;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.Bookmark;

class DSIBrowserBookmarkProxy$4
implements ISerializable {
    private final /* synthetic */ Bookmark val$folderName;
    private final /* synthetic */ DSIBrowserBookmarkProxy this$0;

    DSIBrowserBookmarkProxy$4(DSIBrowserBookmarkProxy dSIBrowserBookmarkProxy, Bookmark bookmark) {
        this.this$0 = dSIBrowserBookmarkProxy;
        this.val$folderName = bookmark;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BookmarkSerializer.putOptionalBookmark(iSerializer, this.val$folderName);
    }
}

