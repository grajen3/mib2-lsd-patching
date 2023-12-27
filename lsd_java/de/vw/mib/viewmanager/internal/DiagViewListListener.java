/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.viewmanager.internal;

import java.util.ArrayList;

public interface DiagViewListListener {
    default public void notifyVisibleViewsChange(ArrayList arrayList) {
    }

    default public void notifyNewMainViewActive(String string) {
    }
}

