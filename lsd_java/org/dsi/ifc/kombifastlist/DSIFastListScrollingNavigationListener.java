/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingNavigationListener
extends DSIListener {
    default public void indicationNavBook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void indicationGetInitialsNavigation(int n, int n2, int n3, int n4) {
    }

    default public void indicationNotifyLastDestListPUSH(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyFavoriteDestListPUSH(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyCurrentListSizeNavigation(boolean bl, boolean bl2) {
    }

    default public void indicationNavBookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
    }
}

