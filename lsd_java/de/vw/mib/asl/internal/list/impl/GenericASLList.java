/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.AbstractASLList;
import de.vw.mib.asl.internal.list.impl.Coverage;
import de.vw.mib.asl.internal.list.impl.GenericASLList$DataStrategy;
import de.vw.mib.asl.internal.list.impl.GenericASLList$DataStrategyAllAtOnce;
import de.vw.mib.asl.internal.list.impl.GenericASLList$GenericUpdateAction;
import de.vw.mib.asl.internal.list.impl.GenericASLList$WindowingStrategyAction;
import de.vw.mib.asl.internal.list.impl.LogUtil;
import de.vw.mib.asl.internal.list.impl.Services;
import de.vw.mib.log4mib.LogMessage;

public class GenericASLList
extends AbstractASLList
implements ASLCachedWindowList {
    private static final String LOG_PREFIX;
    protected Coverage publicItems;
    private volatile boolean readAccessWarningMade;
    final GenericASLList$DataStrategyAllAtOnce STRATEGY_ALL_AT_ONCE = new GenericASLList$DataStrategyAllAtOnce(this);
    private GenericASLList$DataStrategy dataStrategy = this.STRATEGY_ALL_AT_ONCE;
    private static final int DEFAULT_MAX_FETCH_TRIES;
    private int maxFetchTries = 5;

    GenericASLList(Services services, ItemTransformer itemTransformer, int n, String string, String string2) {
        super(services, itemTransformer, n, string, string2);
    }

    public Object[] getDSIObjects() {
        this.checkReadAccessWarning("getDSIObjects");
        return this.dataStrategy.getAllItems();
    }

    private void checkReadAccessWarning(String string) {
        if (!this.readAccessWarningMade && this.isActionPending()) {
            this.readAccessWarningMade = true;
            LogMessage logMessage = this.warn();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", string, true);
                logMessage.append("Read access to list while actions are pending");
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
        }
    }

    @Override
    public void enableWindowing(ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        this.enableWindowing(null, aSLListElementFetcher, n, n2);
    }

    @Override
    public synchronized void enableWindowing(ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        if (this.isFrozen()) {
            this.enqueueAction(GenericASLList$WindowingStrategyAction.enableWindowingAction(this, aSLListElementCache, aSLListElementFetcher, n, n2));
        } else {
            this.executeEnableWindowing(aSLListElementCache, aSLListElementFetcher, n, n2);
        }
    }

    void executeEnableWindowing(ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "enableWindowing", true);
            LogUtil.appendIntProperty(logMessage, "pageSize", n, false);
            logMessage.append(", settings=0x").append(Integer.toHexString(n2));
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        this.dataStrategy.enableWindowing(aSLListElementCache, aSLListElementFetcher, n, n2);
    }

    @Override
    public synchronized void disableWindowing() {
        if (this.isFrozen()) {
            this.enqueueAction(GenericASLList$WindowingStrategyAction.disableWindowingAction(this));
        } else {
            this.executeDisableWindowing();
        }
    }

    void executeDisableWindowing() {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "disableWindowing", true);
            LogUtil.appendListConfig(logMessage, this, false).log();
        }
        this.dataStrategy.disableWindowing();
    }

    @Override
    public boolean isWindowingEnabled() {
        return this.dataStrategy.isWindowingEnabled();
    }

    @Override
    public int getItemCount() {
        return this.dataStrategy.getItemCount();
    }

    @Override
    protected void getLoadedListItems(int n, Object[] objectArray) {
        this.dataStrategy.getLoadedListItems(n, objectArray);
    }

    @Override
    public Object getListItemByIdCacheOnly(long l) {
        Object object = this.dataStrategy.getListItemByIdCacheOnly(l);
        return object;
    }

    Object getListItemByIdCacheOnlyFromSuper(long l) {
        return super.getListItemByIdCacheOnly(l);
    }

    @Override
    public Object getRowItem(int n) {
        Object object = this.dataStrategy.getRowItem(n);
        return object;
    }

    @Override
    public Object getRowItemCacheOnly(int n) {
        this.checkReadAccessWarning("getRowItemsCacheOnly");
        Object object = this.dataStrategy.getRowItemCacheOnly(n);
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void addPublicIndex(int n) {
        Coverage coverage = this.publicItems;
        if (null != coverage) {
            GenericASLList genericASLList = this;
            synchronized (genericASLList) {
                coverage.addRange(n, n);
            }
        }
    }

    @Override
    public synchronized void enableModCount() {
        if (null == this.publicItems) {
            this.publicItems = new Coverage(true);
        }
        super.enableModCount();
    }

    @Override
    public synchronized void disableModCount() {
        super.disableModCount();
        if (null != this.publicItems) {
            this.publicItems.clear();
        }
        this.publicItems = null;
    }

    @Override
    protected void executeUpdateList(Object[] objectArray) {
        Object[] objectArray2 = null != objectArray ? objectArray : EMPTY_ARRAY;
        this.traceListRange("updateList", 0, objectArray2.length);
        this.listLoaded = true;
        if (null != this.publicItems) {
            boolean bl;
            boolean bl2 = bl = !this.publicItems.isEmpty();
            if (bl) {
                this.publicItems.clear();
                this.incModCount();
            }
        }
        this.dataStrategy.updateList(objectArray2);
    }

    @Override
    public synchronized void setSizeClearCache(int n) {
        if (0 > n) {
            LogMessage logMessage = this.error();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "setSizeClearCache", true);
                logMessage.append("Illegal argument ");
                LogUtil.appendSize(logMessage, n, false).append(", using 0 instead");
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
            n = 0;
        }
        if (this.isFrozen()) {
            this.enqueueAction(GenericASLList$GenericUpdateAction.setSizeClearCacheAction(this, n));
        } else {
            this.executeSetSizeClearCache(n);
        }
    }

    void executeSetSizeClearCache(int n) {
        this.traceListSize("setSizeClearCache", n);
        this.checkModCount(0);
        this.dataStrategy.setSizeClearCache(n);
    }

    private void checkModCount(int n) {
        if (null != this.publicItems) {
            boolean bl;
            if (0 < n) {
                bl = this.publicItems.intersects(n, -129);
            } else {
                boolean bl2 = bl = !this.publicItems.isEmpty();
            }
            if (bl) {
                this.publicItems.clear();
                this.incModCount();
            }
        }
    }

    @Override
    protected void executeSetSize(int n) {
        this.traceListSize("setSize", n);
        this.checkModCount(n);
        this.dataStrategy.setSize(n);
    }

    @Override
    public void updateListItem(int n, Object object) {
        this.updateListItems(n, new Object[]{object});
    }

    @Override
    public synchronized void updateListItems(int n, Object[] objectArray) {
        if (null == objectArray) {
            throw new IllegalArgumentException("items null");
        }
        if (this.isFrozen()) {
            this.enqueueAction(GenericASLList$GenericUpdateAction.updateItemsAction(this, n, objectArray));
        } else {
            this.executeUpdateListItems(n, objectArray);
        }
    }

    void executeUpdateListItems(int n, Object[] objectArray) {
        int n2;
        boolean bl;
        this.traceListRange("updateListItems", n, objectArray.length);
        if (null != this.publicItems && (bl = this.publicItems.intersects(n, n + (n2 = objectArray.length) - 1))) {
            this.publicItems.clear();
            this.incModCount();
        }
        this.dataStrategy.updateListItems(n, objectArray);
    }

    @Override
    public void insertListItem(int n, Object object) {
        this.insertListItems(n, new Object[]{object});
    }

    @Override
    public synchronized void insertListItems(int n, Object[] objectArray) {
        if (null == objectArray) {
            throw new IllegalArgumentException("items null");
        }
        if (this.isFrozen()) {
            this.enqueueAction(GenericASLList$GenericUpdateAction.insertItemsAction(this, n, objectArray));
        } else {
            this.executeInsertListItems(n, objectArray);
        }
    }

    void executeInsertListItems(int n, Object[] objectArray) {
        this.traceListRange("insertListItems", n, objectArray.length);
        if (null != this.publicItems) {
            boolean bl = this.publicItems.intersects(n, -129);
            if (bl) {
                this.publicItems.clear();
                this.incModCount();
            } else {
                this.publicItems.insertGap(n, objectArray.length);
            }
        }
        this.dataStrategy.insertListItems(n, objectArray);
    }

    @Override
    public void removeListItem(int n) {
        this.removeListItems(n, 1);
    }

    @Override
    public synchronized void removeListItems(int n, int n2) {
        if (this.isFrozen()) {
            this.enqueueAction(GenericASLList$GenericUpdateAction.removeItemsAction(this, n, n2));
        } else {
            this.executeRemoveListItems(n, n2);
        }
    }

    void executeRemoveListItems(int n, int n2) {
        this.traceListRange("removeListItems", n, n2);
        if (null != this.publicItems) {
            boolean bl = this.publicItems.intersects(n, -129);
            if (bl) {
                this.publicItems.clear();
                this.incModCount();
            } else {
                this.publicItems.removeRange(n, n2);
            }
        }
        this.dataStrategy.removeListItems(n, n2);
    }

    @Override
    public synchronized void refetch(int n, int n2) {
        if (this.isFrozen()) {
            this.enqueueAction(GenericASLList$GenericUpdateAction.refetchAction(this, n, n2));
        } else {
            this.executeRefetch(n, n2);
        }
    }

    void executeRefetch(int n, int n2) {
        this.dataStrategy.refetch(n, n2);
    }

    @Override
    public synchronized void getItems(int n, Object[] objectArray) {
        this.dataStrategy.getItems(n, objectArray);
    }

    public void setMaxFetchTries(int n) {
        this.maxFetchTries = n;
    }

    public int getMaxFetchTries() {
        return this.maxFetchTries;
    }

    @Override
    protected void notifyExecutingQueueFinished() {
        this.dataStrategy.notifyExecutingQueueFinished();
    }

    @Override
    protected void notifyUnfreeze() {
        this.readAccessWarningMade = false;
        super.notifyUnfreeze();
    }

    void setDataStrategy(GenericASLList$DataStrategy genericASLList$DataStrategy) {
        this.dataStrategy = genericASLList$DataStrategy;
        if (null != this.publicItems) {
            boolean bl;
            boolean bl2 = bl = !this.publicItems.isEmpty();
            if (bl) {
                this.publicItems.clear();
                this.incModCount();
            }
        }
    }

    @Override
    protected StringBuffer append(StringBuffer stringBuffer) {
        super.append(stringBuffer);
        stringBuffer.append(", dataStrategy=[");
        this.dataStrategy.append(stringBuffer).append(']');
        return stringBuffer;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("GenericASLList [");
        super.toString(logMessage);
        logMessage.append(", dataStrategy=[").append(this.dataStrategy).append("]]");
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("GenericASLList [");
        this.append(stringBuffer);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}

