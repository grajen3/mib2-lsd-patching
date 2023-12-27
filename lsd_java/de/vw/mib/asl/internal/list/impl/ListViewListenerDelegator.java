/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.list.impl.ListViewListenerDelegator$Callback;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

final class ListViewListenerDelegator {
    ListViewListenerDelegator() {
    }

    static void listViewUpdated(ThreadSwitchingTarget threadSwitchingTarget, ASLListViewListener aSLListViewListener, ASLList aSLList, int n, int n2, Object[] objectArray) {
        if (threadSwitchingTarget.isThreadChangeNecessary()) {
            ListViewListenerDelegator$Callback listViewListenerDelegator$Callback = ListViewListenerDelegator$Callback.listViewUpdateCallback(aSLListViewListener, aSLList, n, n2, objectArray);
            threadSwitchingTarget.enqueue(listViewListenerDelegator$Callback);
        } else {
            aSLListViewListener.listViewUpdated(aSLList, n, n2, objectArray);
        }
    }
}

