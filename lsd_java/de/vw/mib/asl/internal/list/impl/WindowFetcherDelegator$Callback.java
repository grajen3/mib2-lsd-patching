/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListWindowFetcher;
import de.vw.mib.asl.internal.list.IllegalListArgumentException;
import de.vw.mib.asl.internal.list.impl.PoolItem;
import de.vw.mib.pool.PoorMansPool;

final class WindowFetcherDelegator$Callback
implements Runnable,
PoolItem {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int FETCHTYPE_FIRSTITEMS;
    private static final int FETCHTYPE_WINDOW;
    private int fetchType;
    private ASLListWindowFetcher fetcher;
    private ASLList list;
    private int index;
    private Object anchor;
    private int anchorOffset;

    private WindowFetcherDelegator$Callback() {
    }

    private WindowFetcherDelegator$Callback init(int n, ASLListWindowFetcher aSLListWindowFetcher, ASLList aSLList, int n2, Object object, int n3) {
        this.fetchType = n;
        this.fetcher = aSLListWindowFetcher;
        this.list = aSLList;
        this.index = n2;
        this.anchor = object;
        this.anchorOffset = n3;
        return this;
    }

    private static WindowFetcherDelegator$Callback borrow() {
        WindowFetcherDelegator$Callback windowFetcherDelegator$Callback = (WindowFetcherDelegator$Callback)POOL.borrow();
        if (null == windowFetcherDelegator$Callback) {
            windowFetcherDelegator$Callback = new WindowFetcherDelegator$Callback();
        }
        return windowFetcherDelegator$Callback;
    }

    @Override
    public void release() {
        this.fetcher = null;
        this.list = null;
        this.anchor = null;
        POOL.release(this);
    }

    static WindowFetcherDelegator$Callback fetchFirstItemsCallback(ASLListWindowFetcher aSLListWindowFetcher, ASLList aSLList) {
        return WindowFetcherDelegator$Callback.borrow().init(0, aSLListWindowFetcher, aSLList, 0, null, 0);
    }

    static WindowFetcherDelegator$Callback fetchWindowCallback(ASLListWindowFetcher aSLListWindowFetcher, ASLList aSLList, int n, Object object, int n2) {
        return WindowFetcherDelegator$Callback.borrow().init(1, aSLListWindowFetcher, aSLList, n, object, n2);
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
                    this.fetcher.fetchFirstItems(this.list);
                    return;
                }
                case 1: {
                    this.fetcher.fetchWindow(this.list, this.index, this.anchor, this.anchorOffset);
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
        POOL = new PoorMansPool("ASLList.WindowFetcherCallback", 3);
    }
}

