/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.browser.impl.BookmarkSerializer;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.Bookmark;

class DSIBrowserBookmarkProxy$3
implements ISerializable {
    private final /* synthetic */ Bookmark val$bookmark;
    private final /* synthetic */ DSIBrowserBookmarkProxy this$0;

    DSIBrowserBookmarkProxy$3(DSIBrowserBookmarkProxy dSIBrowserBookmarkProxy, Bookmark bookmark) {
        this.this$0 = dSIBrowserBookmarkProxy;
        this.val$bookmark = bookmark;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BookmarkSerializer.putOptionalBookmark(iSerializer, this.val$bookmark);
    }
}

