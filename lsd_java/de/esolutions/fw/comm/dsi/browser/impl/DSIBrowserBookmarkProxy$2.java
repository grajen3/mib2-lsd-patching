/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.dsi.browser.impl.BookmarkSerializer;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.Bookmark;

class DSIBrowserBookmarkProxy$2
implements ISerializable {
    private final /* synthetic */ Bookmark val$oldBookmark;
    private final /* synthetic */ Bookmark val$newBookmark;
    private final /* synthetic */ DSIBrowserBookmarkProxy this$0;

    DSIBrowserBookmarkProxy$2(DSIBrowserBookmarkProxy dSIBrowserBookmarkProxy, Bookmark bookmark, Bookmark bookmark2) {
        this.this$0 = dSIBrowserBookmarkProxy;
        this.val$oldBookmark = bookmark;
        this.val$newBookmark = bookmark2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BookmarkSerializer.putOptionalBookmark(iSerializer, this.val$oldBookmark);
        BookmarkSerializer.putOptionalBookmark(iSerializer, this.val$newBookmark);
    }
}

