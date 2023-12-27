/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListUpdates;
import de.vw.mib.log4mib.Loggable;

public interface ASLListWindow
extends ASLListUpdates,
Loggable {
    default public Object getListItem(int n) {
    }

    default public int getFirstListIndex() {
    }

    default public int getLastListIndex() {
    }

    default public int getActivatedIndex() {
    }

    default public boolean isFrozen() {
    }

    default public void freeze() {
    }

    default public void unfreeze() {
    }

    default public int getListSize() {
    }

    default public void setListSize(int n) {
    }

    default public void refreshItems(int n, int n2) {
    }

    default public int getFirstVisibleIndex() {
    }

    default public int getLastVisibleIndex() {
    }

    default public int getLastQueriedIndex() {
    }

    default public void updateList(Object[] objectArray) {
    }

    default public boolean isLazyFetching() {
    }

    default public void storeItems(ASLListElementCache aSLListElementCache) {
    }
}

