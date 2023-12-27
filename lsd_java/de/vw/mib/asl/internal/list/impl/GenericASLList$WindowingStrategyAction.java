/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$AbstractAction;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.pool.PoorMansPool;

final class GenericASLList$WindowingStrategyAction
extends AbstractASLList$AbstractAction {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int DISABLE_WINDOWING_TYPE;
    private static final int ENABLE_WINDOWING_TYPE;
    private GenericASLList list;
    private ASLListElementCache cache;
    private ASLListElementFetcher fetcher;
    private int settings;
    private int updateType;

    private GenericASLList$WindowingStrategyAction() {
    }

    private GenericASLList$WindowingStrategyAction init(GenericASLList genericASLList, int n, ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n2, int n3) {
        super.init(0, null, n2);
        this.list = genericASLList;
        this.cache = aSLListElementCache;
        this.fetcher = aSLListElementFetcher;
        this.settings = n3;
        this.updateType = n;
        return this;
    }

    private static GenericASLList$WindowingStrategyAction borrow() {
        GenericASLList$WindowingStrategyAction genericASLList$WindowingStrategyAction = (GenericASLList$WindowingStrategyAction)POOL.borrow();
        if (null == genericASLList$WindowingStrategyAction) {
            genericASLList$WindowingStrategyAction = new GenericASLList$WindowingStrategyAction();
        }
        return genericASLList$WindowingStrategyAction;
    }

    @Override
    public void clear() {
        super.clear();
        this.list = null;
        this.cache = null;
        this.fetcher = null;
    }

    static GenericASLList$WindowingStrategyAction disableWindowingAction(GenericASLList genericASLList) {
        return GenericASLList$WindowingStrategyAction.borrow().init(genericASLList, 0, null, null, -1, -1);
    }

    static GenericASLList$WindowingStrategyAction enableWindowingAction(GenericASLList genericASLList, ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        return GenericASLList$WindowingStrategyAction.borrow().init(genericASLList, 1, aSLListElementCache, aSLListElementFetcher, n, n2);
    }

    @Override
    protected String getName() {
        switch (this.updateType) {
            case 0: {
                return "disableWindowing";
            }
            case 1: {
                return "enableWindowing";
            }
        }
        return "unknown";
    }

    @Override
    protected void execute() {
        switch (this.updateType) {
            case 0: {
                this.list.executeDisableWindowing();
                break;
            }
            case 1: {
                this.list.executeEnableWindowing(this.cache, this.fetcher, this.count, this.settings);
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
        POOL = new PoorMansPool("ASLList.WindowingStrategyAction", 5);
    }
}

