/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingTelephoneListener
extends DSIListener {
    default public void indicationPhonebook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void indicationGetInitialsTelephone(int n, int n2, int n3, int n4) {
    }

    default public void indicationNotifyFavoriteListPush(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyCombinedNumbersPush(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyCurrentListSizeTelephone(boolean bl, boolean bl2) {
    }

    default public void indicationPhonebookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
    }
}

