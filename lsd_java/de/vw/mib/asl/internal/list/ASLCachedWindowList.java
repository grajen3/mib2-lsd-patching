/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.ASLListUpdates;

public interface ASLCachedWindowList
extends ASLList,
ASLListUpdates {
    public static final int WINDOWING_LAZY_FETCHING;
    public static final int WINDOWING_RING_VIEW;
    public static final int WINDOWING_HARD_CACHE;
    public static final int WINDOWING_NO_MOD_INC_ON_DUMMY_UPDATE;
    public static final int WINDOWING_DEFAULT_SETTINGS;

    default public void disableWindowing() {
    }

    default public void enableWindowing(ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
    }

    default public void enableWindowing(ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
    }

    default public void getItems(int n, Object[] objectArray) {
    }

    default public boolean isWindowingEnabled() {
    }

    default public void setSize(int n) {
    }

    default public void updateListItem(int n, Object object) {
    }

    default public void removeListItem(int n) {
    }

    default public void insertListItem(int n, Object object) {
    }

    default public void refetch(int n, int n2) {
    }

    default public void setSizeClearCache(int n) {
    }
}

