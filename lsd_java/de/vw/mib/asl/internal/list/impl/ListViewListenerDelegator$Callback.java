/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.list.IllegalListArgumentException;
import de.vw.mib.asl.internal.list.impl.PoolItem;
import de.vw.mib.pool.PoorMansPool;

final class ListViewListenerDelegator$Callback
implements Runnable,
PoolItem {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int OPERATIONTYPE_LISTVIEWUPDATED;
    private int operationType;
    private ASLListViewListener listener;
    private ASLList list;
    private int index;
    private int count;
    private Object[] items;

    private ListViewListenerDelegator$Callback() {
    }

    private ListViewListenerDelegator$Callback init(int n, ASLListViewListener aSLListViewListener, ASLList aSLList, int n2, int n3, Object[] objectArray) {
        this.operationType = n;
        this.listener = aSLListViewListener;
        this.list = aSLList;
        this.index = n2;
        this.count = n3;
        this.items = objectArray;
        return this;
    }

    private static ListViewListenerDelegator$Callback borrow() {
        ListViewListenerDelegator$Callback listViewListenerDelegator$Callback = (ListViewListenerDelegator$Callback)POOL.borrow();
        if (null == listViewListenerDelegator$Callback) {
            listViewListenerDelegator$Callback = new ListViewListenerDelegator$Callback();
        }
        return listViewListenerDelegator$Callback;
    }

    @Override
    public void release() {
        this.listener = null;
        this.list = null;
        this.items = null;
        POOL.release(this);
    }

    static ListViewListenerDelegator$Callback listViewUpdateCallback(ASLListViewListener aSLListViewListener, ASLList aSLList, int n, int n2, Object[] objectArray) {
        return ListViewListenerDelegator$Callback.borrow().init(0, aSLListViewListener, aSLList, n, n2, objectArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void run() {
        try {
            switch (this.operationType) {
                case 0: {
                    this.listener.listViewUpdated(this.list, this.index, this.count, this.items);
                    return;
                }
                default: {
                    throw new IllegalListArgumentException(new StringBuffer().append("Unknown operation type: ").append(this.operationType).toString());
                }
            }
        }
        finally {
            this.release();
        }
    }

    static {
        POOL = new PoorMansPool("ASLList.ListViewListenerCallback", 3);
    }
}

