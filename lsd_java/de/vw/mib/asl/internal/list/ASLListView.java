/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLListViewListener;

public interface ASLListView {
    default public void addListViewListener(ASLListViewListener aSLListViewListener) {
    }

    default public void removeListViewListener(ASLListViewListener aSLListViewListener) {
    }

    default public void updateListView(int n, int n2) {
    }
}

