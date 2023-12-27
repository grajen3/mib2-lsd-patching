/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;

public interface ASLListElementFetcher {
    default public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
    }

    default public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
    }

    default public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
    }
}

