/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.Bookmark;

public class BookmarkSerializer {
    public static void putOptionalBookmark(ISerializer iSerializer, Bookmark bookmark) {
        boolean bl = bookmark == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bookmark.getBookmarkType();
            iSerializer.putInt32(n);
            String string = bookmark.getFolder();
            iSerializer.putOptionalString(string);
            String string2 = bookmark.getTitle();
            iSerializer.putOptionalString(string2);
            String string3 = bookmark.getUrl();
            iSerializer.putOptionalString(string3);
            boolean bl2 = bookmark.isNonerasable();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalBookmarkVarArray(ISerializer iSerializer, Bookmark[] bookmarkArray) {
        boolean bl = bookmarkArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bookmarkArray.length);
            for (int i2 = 0; i2 < bookmarkArray.length; ++i2) {
                BookmarkSerializer.putOptionalBookmark(iSerializer, bookmarkArray[i2]);
            }
        }
    }

    public static Bookmark getOptionalBookmark(IDeserializer iDeserializer) {
        Bookmark bookmark = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            String string3;
            int n;
            bookmark = new Bookmark();
            bookmark.bookmarkType = n = iDeserializer.getInt32();
            bookmark.folder = string3 = iDeserializer.getOptionalString();
            bookmark.title = string2 = iDeserializer.getOptionalString();
            bookmark.url = string = iDeserializer.getOptionalString();
            bookmark.nonerasable = bl2 = iDeserializer.getBool();
        }
        return bookmark;
    }

    public static Bookmark[] getOptionalBookmarkVarArray(IDeserializer iDeserializer) {
        Bookmark[] bookmarkArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bookmarkArray = new Bookmark[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bookmarkArray[i2] = BookmarkSerializer.getOptionalBookmark(iDeserializer);
            }
        }
        return bookmarkArray;
    }
}

