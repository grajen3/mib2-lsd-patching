/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.IllegalListArgumentException;
import de.vw.mib.asl.internal.list.impl.AbstractASLList;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$AbstractAction;
import de.vw.mib.asl.internal.list.impl.PoolItem;
import de.vw.mib.pool.PoorMansPool;

final class AbstractASLList$CommonAction
extends AbstractASLList$AbstractAction
implements PoolItem {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int ACTIVATE_INDEX_TYPE;
    private static final int SET_SIZE_TYPE;
    private static final int UPDATE_LIST_TYPE;
    private static final int UPDATE_STRING_INDEX;
    private static final int CLEAR_STRING_INDEX;
    private AbstractASLList list;
    private int updateType;
    private Object additionalData;

    private AbstractASLList$CommonAction() {
    }

    private AbstractASLList$CommonAction init(AbstractASLList abstractASLList, int n, int n2, Object[] objectArray, int n3, Object object) {
        super.init(n2, objectArray, n3);
        this.list = abstractASLList;
        this.updateType = n;
        this.additionalData = object;
        return this;
    }

    private static AbstractASLList$CommonAction borrow() {
        AbstractASLList$CommonAction abstractASLList$CommonAction = (AbstractASLList$CommonAction)POOL.borrow();
        if (null == abstractASLList$CommonAction) {
            abstractASLList$CommonAction = new AbstractASLList$CommonAction();
        }
        return abstractASLList$CommonAction;
    }

    @Override
    protected void clear() {
        super.clear();
        this.list = null;
        this.additionalData = null;
    }

    static AbstractASLList$CommonAction activateIndexAction(AbstractASLList abstractASLList, int n) {
        return AbstractASLList$CommonAction.borrow().init(abstractASLList, 0, n, null, -1, null);
    }

    static AbstractASLList$CommonAction setSizeAction(AbstractASLList abstractASLList, int n) {
        return AbstractASLList$CommonAction.borrow().init(abstractASLList, 1, -1, null, n, null);
    }

    static AbstractASLList$CommonAction updateListAction(AbstractASLList abstractASLList, Object[] objectArray) {
        return AbstractASLList$CommonAction.borrow().init(abstractASLList, 2, 0, objectArray, null != objectArray ? objectArray.length : 0, null);
    }

    static AbstractASLList$CommonAction updateStringIndexAction(AbstractASLList abstractASLList, int[] nArray, String[] stringArray) {
        return AbstractASLList$CommonAction.borrow().init(abstractASLList, 3, -1, stringArray, null != nArray ? nArray.length : 0, nArray);
    }

    static AbstractASLList$CommonAction clearStringIndexAction(AbstractASLList abstractASLList) {
        return AbstractASLList$CommonAction.borrow().init(abstractASLList, 4, -1, null, -1, null);
    }

    @Override
    protected String getName() {
        switch (this.updateType) {
            case 0: {
                return "setActiveIndex";
            }
            case 1: {
                return "setSize";
            }
            case 2: {
                return "updateList";
            }
            case 3: {
                return "updateStringIndex";
            }
            case 4: {
                return "clearStringIndex";
            }
        }
        return "unknown";
    }

    @Override
    protected void execute() {
        switch (this.updateType) {
            case 0: {
                this.list.executeSetActiveIndex(this.index);
                break;
            }
            case 1: {
                this.list.executeSetSize(this.count);
                break;
            }
            case 2: {
                this.list.executeUpdateList(this.items);
                break;
            }
            case 3: {
                this.list.executeUpdateStringIndex((int[])this.additionalData, (String[])this.items);
                break;
            }
            case 4: {
                this.list.executeClearStringIndex();
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
        POOL = new PoorMansPool("ASLList.CommonAction", 5);
    }
}

