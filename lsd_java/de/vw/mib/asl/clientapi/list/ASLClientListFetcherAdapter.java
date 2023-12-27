/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list;

import de.vw.mib.asl.clientapi.list.ASLClientList;
import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;

public abstract class ASLClientListFetcherAdapter
implements ASLClientListFetcher {
    @Override
    public void fetchNextPage(ASLClientList aSLClientList, Object object, int n, int n2) {
        this.fetchItems(aSLClientList, n, n2);
    }

    @Override
    public void fetchPrevPage(ASLClientList aSLClientList, Object object, int n, int n2) {
        this.fetchItems(aSLClientList, n, n2);
    }
}

