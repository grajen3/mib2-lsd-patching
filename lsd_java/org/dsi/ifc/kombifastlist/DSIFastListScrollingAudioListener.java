/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingAudioListener
extends DSIListener {
    default public void indicationMediaBrowser(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void indicationNotifyCommonListPUSH(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyReceptionListPUSH(boolean bl, boolean bl2) {
    }

    default public void indicationNotifyCurrentListSizeAudio(boolean bl, boolean bl2) {
    }

    default public void indicationMediaBrowserJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
    }
}

