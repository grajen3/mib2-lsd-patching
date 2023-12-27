/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.IllegalListArgumentException;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$AbstractAction;
import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.asl.internal.list.impl.PoolItem;
import de.vw.mib.pool.PoorMansPool;

final class DirectWindowList$WindowAction
extends AbstractASLList$AbstractAction
implements PoolItem {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int UPDATE_WINDOW_TYPE;
    private DirectWindowList list;
    private int updateType;
    private boolean endReached;
    private boolean startReached;

    private DirectWindowList$WindowAction() {
    }

    private DirectWindowList$WindowAction init(DirectWindowList directWindowList, int n, int n2, Object[] objectArray, int n3, boolean bl, boolean bl2) {
        super.init(n2, objectArray, n3);
        this.list = directWindowList;
        this.updateType = n;
        this.startReached = bl;
        this.endReached = bl2;
        return this;
    }

    private static DirectWindowList$WindowAction borrow() {
        DirectWindowList$WindowAction directWindowList$WindowAction = (DirectWindowList$WindowAction)POOL.borrow();
        if (null == directWindowList$WindowAction) {
            directWindowList$WindowAction = new DirectWindowList$WindowAction();
        }
        return directWindowList$WindowAction;
    }

    @Override
    protected void clear() {
        super.clear();
        this.list = null;
    }

    static DirectWindowList$WindowAction updateListWindow(DirectWindowList directWindowList, int n, Object[] objectArray, boolean bl, boolean bl2) {
        return DirectWindowList$WindowAction.borrow().init(directWindowList, 0, n, objectArray, null != objectArray ? objectArray.length : 0, bl, bl2);
    }

    @Override
    protected String getName() {
        switch (this.updateType) {
            case 0: {
                return "udpateListWindow";
            }
        }
        return "unknown";
    }

    @Override
    protected void execute() {
        switch (this.updateType) {
            case 0: {
                this.list.executeUpdateListWindow(this.index, this.items, this.startReached, this.endReached);
                break;
            }
            default: {
                throw new IllegalListArgumentException(new StringBuffer().append("Illegal update type: ").append(this.updateType).toString());
            }
        }
    }

    @Override
    public void release() {
        this.clear();
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("ASLList.WindowAction", 5);
    }
}

