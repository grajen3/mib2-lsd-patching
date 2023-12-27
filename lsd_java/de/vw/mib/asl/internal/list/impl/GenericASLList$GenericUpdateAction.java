/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.AbstractASLList$AbstractAction;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.pool.PoorMansPool;

final class GenericASLList$GenericUpdateAction
extends AbstractASLList$AbstractAction {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int UPDATE_ITEMS_TYPE;
    private static final int INSERT_ITEMS_TYPE;
    private static final int REMOVE_ITEMS_TYPE;
    private static final int REFETCH_TYPE;
    private static final int SET_SIZE_CLEAR_CACHE_TYPE;
    private GenericASLList list;
    private int updateType;

    private GenericASLList$GenericUpdateAction() {
    }

    private GenericASLList$GenericUpdateAction init(GenericASLList genericASLList, int n, int n2, Object[] objectArray, int n3) {
        super.init(n2, objectArray, n3);
        this.list = genericASLList;
        this.updateType = n;
        return this;
    }

    private static GenericASLList$GenericUpdateAction borrow() {
        GenericASLList$GenericUpdateAction genericASLList$GenericUpdateAction = (GenericASLList$GenericUpdateAction)POOL.borrow();
        if (null == genericASLList$GenericUpdateAction) {
            genericASLList$GenericUpdateAction = new GenericASLList$GenericUpdateAction();
        }
        return genericASLList$GenericUpdateAction;
    }

    @Override
    public void clear() {
        super.clear();
        this.list = null;
    }

    static GenericASLList$GenericUpdateAction updateItemsAction(GenericASLList genericASLList, int n, Object[] objectArray) {
        return GenericASLList$GenericUpdateAction.borrow().init(genericASLList, 0, n, objectArray, null != objectArray ? objectArray.length : 0);
    }

    static GenericASLList$GenericUpdateAction insertItemsAction(GenericASLList genericASLList, int n, Object[] objectArray) {
        return GenericASLList$GenericUpdateAction.borrow().init(genericASLList, 1, n, objectArray, null != objectArray ? objectArray.length : 0);
    }

    static GenericASLList$GenericUpdateAction removeItemsAction(GenericASLList genericASLList, int n, int n2) {
        return GenericASLList$GenericUpdateAction.borrow().init(genericASLList, 2, n, null, n2);
    }

    static GenericASLList$GenericUpdateAction refetchAction(GenericASLList genericASLList, int n, int n2) {
        return GenericASLList$GenericUpdateAction.borrow().init(genericASLList, 3, n, null, n2);
    }

    static GenericASLList$GenericUpdateAction setSizeClearCacheAction(GenericASLList genericASLList, int n) {
        return GenericASLList$GenericUpdateAction.borrow().init(genericASLList, 4, -1, null, n);
    }

    @Override
    protected String getName() {
        switch (this.updateType) {
            case 0: {
                return "updateItems";
            }
            case 1: {
                return "insertItems";
            }
            case 2: {
                return "removeItems";
            }
            case 3: {
                return "refetch";
            }
            case 4: {
                return "setSizeClearCache";
            }
        }
        return "unknown";
    }

    @Override
    protected void execute() {
        switch (this.updateType) {
            case 0: {
                this.list.executeUpdateListItems(this.index, this.items);
                break;
            }
            case 1: {
                this.list.executeInsertListItems(this.index, this.items);
                break;
            }
            case 2: {
                this.list.executeRemoveListItems(this.index, this.count);
                break;
            }
            case 3: {
                this.list.executeRefetch(this.index, this.count);
                break;
            }
            case 4: {
                this.list.executeSetSizeClearCache(this.count);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal update type: ").append(this.updateType).toString());
            }
        }
    }

    @Override
    protected void release() {
        this.clear();
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("ASLList.GenericUpdateAction", 5);
    }
}

