/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.IllegalListArgumentException;
import de.vw.mib.asl.internal.list.impl.PoolItem;
import de.vw.mib.pool.PoorMansPool;

final class ElementFetcherDelegator$Callback
implements Runnable,
PoolItem {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int FETCHTYPE_ITEMS;
    private static final int FETCHTYPE_NEXTPAGE;
    private static final int FETCHTYPE_PREVIOUSPAGE;
    private int fetchType;
    private ASLListElementFetcher fetcher;
    private ASLCachedWindowList list;
    private Object item;
    private int index;
    private int count;

    private ElementFetcherDelegator$Callback() {
    }

    private static ElementFetcherDelegator$Callback borrow() {
        ElementFetcherDelegator$Callback elementFetcherDelegator$Callback = (ElementFetcherDelegator$Callback)POOL.borrow();
        if (null == elementFetcherDelegator$Callback) {
            elementFetcherDelegator$Callback = new ElementFetcherDelegator$Callback();
        }
        return elementFetcherDelegator$Callback;
    }

    private ElementFetcherDelegator$Callback init(int n, ASLListElementFetcher aSLListElementFetcher, ASLCachedWindowList aSLCachedWindowList, Object object, int n2, int n3) {
        this.fetchType = n;
        this.fetcher = aSLListElementFetcher;
        this.list = aSLCachedWindowList;
        this.item = object;
        this.index = n2;
        this.count = n3;
        return this;
    }

    @Override
    public void release() {
        this.fetcher = null;
        this.list = null;
        this.item = null;
        POOL.release(this);
    }

    static ElementFetcherDelegator$Callback fetchItemsCallback(ASLListElementFetcher aSLListElementFetcher, ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        return ElementFetcherDelegator$Callback.borrow().init(0, aSLListElementFetcher, aSLCachedWindowList, null, n, n2);
    }

    static ElementFetcherDelegator$Callback fetchNextPageCallback(ASLListElementFetcher aSLListElementFetcher, ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        return ElementFetcherDelegator$Callback.borrow().init(1, aSLListElementFetcher, aSLCachedWindowList, object, n, n2);
    }

    static ElementFetcherDelegator$Callback fetchPreviousPageCallback(ASLListElementFetcher aSLListElementFetcher, ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        return ElementFetcherDelegator$Callback.borrow().init(2, aSLListElementFetcher, aSLCachedWindowList, object, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void run() {
        try {
            switch (this.fetchType) {
                case 0: {
                    this.fetcher.fetchItems(this.list, this.index, this.count);
                    return;
                }
                case 1: {
                    this.fetcher.fetchNextPage(this.list, this.item, this.index, this.count);
                    return;
                }
                case 2: {
                    this.fetcher.fetchPreviousPage(this.list, this.item, this.index, this.count);
                    return;
                }
                default: {
                    throw new IllegalListArgumentException(new StringBuffer().append("Unknown fetch type: ").append(this.fetchType).toString());
                }
            }
        }
        finally {
            this.release();
        }
    }

    static {
        POOL = new PoorMansPool("ASLList.ElementFetcherCallback", 3);
    }
}

