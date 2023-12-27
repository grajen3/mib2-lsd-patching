/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.PreferredDest_List_Status;
import de.vw.mib.bap.mqbab2.navsd.functions.PreferredDestList;

public class PreferredDestListArabic
extends PreferredDestList {
    private boolean lastDestListContainsElements = false;

    private void setPreferredDestListType(PreferredDest_List_Status preferredDest_List_Status) {
        preferredDest_List_Status.listType = this.lastDestListContainsElements ? 1 : 0;
    }

    @Override
    protected PreferredDest_List_Status computePreferredDestList() {
        PreferredDest_List_Status preferredDest_List_Status = this.dequeueBAPEntity();
        this.setPreferredDestListType(preferredDest_List_Status);
        return preferredDest_List_Status;
    }

    private void sendPreferredDestList(PreferredDest_List_Status preferredDest_List_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(preferredDest_List_Status, this);
    }

    @Override
    protected void setFullLastDestList(FsgArrayListComplete fsgArrayListComplete) {
        this.lastDestListContainsElements = fsgArrayListComplete.getSize() != 0;
        this.sendPreferredDestList(this.computePreferredDestList());
    }
}

