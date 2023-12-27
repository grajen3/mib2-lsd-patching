/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientList;
import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.asl.clientapi.list.impl.FetchDelegator$Callback;
import de.vw.mib.threads.MIBInvoker;

final class FetchDelegator {
    FetchDelegator() {
    }

    static void fetchItems(MIBInvoker mIBInvoker, ASLClientListFetcher aSLClientListFetcher, ASLClientList aSLClientList, int n, int n2) {
        FetchDelegator$Callback fetchDelegator$Callback = FetchDelegator$Callback.fetchItemsCallback(aSLClientListFetcher, aSLClientList, n, n2);
        mIBInvoker.invoke(fetchDelegator$Callback);
    }

    static void fetchNextPage(MIBInvoker mIBInvoker, ASLClientListFetcher aSLClientListFetcher, ASLClientList aSLClientList, Object object, int n, int n2) {
        FetchDelegator$Callback fetchDelegator$Callback = FetchDelegator$Callback.fetchNextPageCallback(aSLClientListFetcher, aSLClientList, object, n, n2);
        mIBInvoker.invoke(fetchDelegator$Callback);
    }

    static void fetchPreviousPage(MIBInvoker mIBInvoker, ASLClientListFetcher aSLClientListFetcher, ASLClientList aSLClientList, Object object, int n, int n2) {
        FetchDelegator$Callback fetchDelegator$Callback = FetchDelegator$Callback.fetchPreviousPageCallback(aSLClientListFetcher, aSLClientList, object, n, n2);
        mIBInvoker.invoke(fetchDelegator$Callback);
    }
}

