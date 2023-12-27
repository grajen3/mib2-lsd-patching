/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.albumbrowser;

import org.dsi.ifc.albumbrowser.AlbumEntryInfo;
import org.dsi.ifc.base.DSIListener;

public interface DSIAlbumBrowserListener
extends DSIListener {
    default public void updateBrowserState(int n, int n2) {
    }

    default public void updateFocusedEntry(AlbumEntryInfo albumEntryInfo, int n) {
    }

    default public void updateListPosition(long l, int n) {
    }

    default public void updateNumEntries(long l, int n) {
    }

    default public void updateScrollMode(int n, int n2) {
    }

    default public void selectAlbum(long l) {
    }

    default public void albumIdxForFID(long l, long l2) {
    }
}

