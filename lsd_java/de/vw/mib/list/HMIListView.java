/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListState;

public interface HMIListView
extends HMIListState {
    default public void forceUnfreeze() {
    }

    default public void freeze() {
    }

    default public void unfreeze() {
    }

    default public boolean isFrozen() {
    }

    default public Object getItem(int n) {
    }

    default public void enableModCount() {
    }

    default public void disableModCount() {
    }

    default public int getModCount() {
    }

    default public void releaseView() {
    }
}

