/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPBrowserListener
extends DSIListener {
    default public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
    }

    default public void updateListSize(int n, int n2, int n3) {
    }

    default public void responseList(ListEntry[] listEntryArray, int n) {
    }

    default public void invalidBrowsePath() {
    }
}

