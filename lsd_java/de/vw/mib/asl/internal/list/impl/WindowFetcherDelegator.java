/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListWindowFetcher;
import de.vw.mib.asl.internal.list.impl.WindowFetcherDelegator$Callback;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

final class WindowFetcherDelegator {
    WindowFetcherDelegator() {
    }

    static void fetchFirstItems(ThreadSwitchingTarget threadSwitchingTarget, ASLListWindowFetcher aSLListWindowFetcher, ASLList aSLList) {
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            WindowFetcherDelegator$Callback windowFetcherDelegator$Callback = WindowFetcherDelegator$Callback.fetchFirstItemsCallback(aSLListWindowFetcher, aSLList);
            threadSwitchingTarget.enqueue(windowFetcherDelegator$Callback);
        } else {
            aSLListWindowFetcher.fetchFirstItems(aSLList);
        }
    }

    static void fetchWindow(ThreadSwitchingTarget threadSwitchingTarget, ASLListWindowFetcher aSLListWindowFetcher, ASLList aSLList, int n, Object object, int n2) {
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            WindowFetcherDelegator$Callback windowFetcherDelegator$Callback = WindowFetcherDelegator$Callback.fetchWindowCallback(aSLListWindowFetcher, aSLList, n, object, n2);
            threadSwitchingTarget.enqueue(windowFetcherDelegator$Callback);
        } else {
            aSLListWindowFetcher.fetchWindow(aSLList, n, object, n2);
        }
    }
}

