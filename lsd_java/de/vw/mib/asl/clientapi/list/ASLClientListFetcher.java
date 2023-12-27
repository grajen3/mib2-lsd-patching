/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list;

import de.vw.mib.asl.clientapi.list.ASLClientList;

public interface ASLClientListFetcher {
    default public void fetchItems(ASLClientList aSLClientList, int n, int n2) {
    }

    default public void fetchNextPage(ASLClientList aSLClientList, Object object, int n, int n2) {
    }

    default public void fetchPrevPage(ASLClientList aSLClientList, Object object, int n, int n2) {
    }
}

