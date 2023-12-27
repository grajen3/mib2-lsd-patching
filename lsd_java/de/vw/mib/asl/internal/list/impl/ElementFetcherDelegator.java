/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ElementFetcherDelegator$Callback;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

final class ElementFetcherDelegator {
    ElementFetcherDelegator() {
    }

    static void fetchItems(ThreadSwitchingTarget threadSwitchingTarget, ASLListElementFetcher aSLListElementFetcher, ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            ElementFetcherDelegator$Callback elementFetcherDelegator$Callback = ElementFetcherDelegator$Callback.fetchItemsCallback(aSLListElementFetcher, aSLCachedWindowList, n, n2);
            threadSwitchingTarget.enqueue(elementFetcherDelegator$Callback);
        } else {
            aSLListElementFetcher.fetchItems(aSLCachedWindowList, n, n2);
        }
    }

    static void fetchNextPage(ThreadSwitchingTarget threadSwitchingTarget, ASLListElementFetcher aSLListElementFetcher, ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            ElementFetcherDelegator$Callback elementFetcherDelegator$Callback = ElementFetcherDelegator$Callback.fetchNextPageCallback(aSLListElementFetcher, aSLCachedWindowList, object, n, n2);
            threadSwitchingTarget.enqueue(elementFetcherDelegator$Callback);
        } else {
            aSLListElementFetcher.fetchNextPage(aSLCachedWindowList, object, n, n2);
        }
    }

    static void fetchPreviousPage(ThreadSwitchingTarget threadSwitchingTarget, ASLListElementFetcher aSLListElementFetcher, ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            ElementFetcherDelegator$Callback elementFetcherDelegator$Callback = ElementFetcherDelegator$Callback.fetchPreviousPageCallback(aSLListElementFetcher, aSLCachedWindowList, object, n, n2);
            threadSwitchingTarget.enqueue(elementFetcherDelegator$Callback);
        } else {
            aSLListElementFetcher.fetchPreviousPage(aSLCachedWindowList, object, n, n2);
        }
    }
}

