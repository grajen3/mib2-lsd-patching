/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.SearchHit;

public interface DSIBrowserBoardbookListener
extends DSIListener {
    default public void indicateSearchResults(String string, int n, SearchHit[] searchHitArray, int n2) {
    }

    default public void updateBoardbookStatus(int n, int n2) {
    }
}

