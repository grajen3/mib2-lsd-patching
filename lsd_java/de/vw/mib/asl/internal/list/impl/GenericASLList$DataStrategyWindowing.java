/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemHardCacheImpl;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.ASLListWindowImpl;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimeoutHandler;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimer;
import de.vw.mib.asl.internal.list.impl.ElementFetcherDelegator;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.list.impl.GenericASLList$DataStrategy;
import de.vw.mib.asl.internal.list.impl.GenericASLList$FetchBlock;
import de.vw.mib.asl.internal.list.impl.LogUtil;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;

class GenericASLList$DataStrategyWindowing
implements GenericASLList$DataStrategy,
AbstractASLList$FetchTimeoutHandler {
    private final AbstractASLList$FetchTimer timer;
    private ASLListWindowImpl listWindow;
    private ASLListElementCache listCache;
    private ASLListElementFetcher itemFetcher;
    private boolean ignoreModCountOnDummy;
    private boolean sizeChangePending;
    private int cntFetchTries;
    private int suppressFetchingCounter;
    private GenericASLList$FetchBlock firstFetchBlock;
    private GenericASLList$FetchBlock activeFetchBlock;
    private final /* synthetic */ GenericASLList this$0;

    GenericASLList$DataStrategyWindowing(GenericASLList genericASLList, ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        this.this$0 = genericASLList;
        this.timer = genericASLList.accessFetchTimer();
        this.timer.setFetchTimeoutHandler(this);
        this.init(aSLListElementCache, aSLListElementFetcher, n, n2);
    }

    final GenericASLList$DataStrategyWindowing init(ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        this.listWindow = new ASLListWindowImpl(this.this$0.services, this.this$0, n, 0 != (n2 & 1));
        if (null == aSLListElementCache) {
            aSLListElementCache = 0 != (n2 & 4) ? new ASLListItemHardCacheImpl() : new ASLListItemSoftCacheImpl();
        }
        this.listCache = aSLListElementCache;
        this.itemFetcher = aSLListElementFetcher;
        this.ignoreModCountOnDummy = 0 != (n2 & 8);
        this.this$0.listSize = 0;
        this.sizeChangePending = false;
        this.cntFetchTries = 0;
        return this;
    }

    @Override
    public void disableWindowing() {
        this.stopFetchTimer();
        this.clearFetchBlocks();
        this.listCache.clear();
        this.timer.setFetchTimeoutHandler(null);
        this.this$0.setDataStrategy(this.this$0.STRATEGY_ALL_AT_ONCE.init());
    }

    @Override
    public void enableWindowing(ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        LogMessage logMessage = this.this$0.warn();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "enableWindowing", true);
            logMessage.append("windowing already enabled, this may lead to unexpected results");
            LogUtil.appendListConfig(logMessage, this.this$0, true).log();
        }
        this.stopFetchTimer();
        this.clearFetchBlocks();
        this.this$0.setDataStrategy(this.init(aSLListElementCache, aSLListElementFetcher, n, n2));
    }

    @Override
    public boolean isWindowingEnabled() {
        return true;
    }

    @Override
    public int getItemCount() {
        return this.sizeChangePending ? 0 : this.this$0.listSize;
    }

    @Override
    public Object[] getAllItems() {
        throw new UnsupportedOperationException("getDSIObjects must not be called on a windowed list!");
    }

    @Override
    public void getLoadedListItems(int n, Object[] objectArray) {
        this.listCache.getListItems(n, objectArray, objectArray.length, DynamicListData.ITEM_NOT_LOADED);
    }

    @Override
    public void getItems(int n, Object[] objectArray) {
        if (n < this.this$0.listSize) {
            int n2 = Math.min(this.this$0.listSize - n, objectArray.length);
            boolean bl = this.listCache.getListItems(n, objectArray, n2, DynamicListData.ITEM_NOT_LOADED);
            if (n2 < objectArray.length) {
                Arrays.fill(objectArray, n2, objectArray.length, null);
            }
            if (bl) {
                this.checkFetching(n, objectArray, n2);
            }
        } else {
            Arrays.fill(objectArray, null);
        }
    }

    @Override
    public Object getListItemByIdCacheOnly(long l) {
        return this.this$0.getListItemByIdCacheOnlyFromSuper(l);
    }

    @Override
    public Object getRowItem(int n) {
        Object object = this.listWindow.getListItem(n);
        if (!(null == object || this.ignoreModCountOnDummy && DynamicListData.ITEM_NOT_LOADED == object)) {
            this.this$0.addPublicIndex(n);
        }
        return object;
    }

    @Override
    public Object getRowItemCacheOnly(int n) {
        return 0 <= n && n < this.this$0.listSize ? this.listCache.getListItem(n, DynamicListData.ITEM_NOT_LOADED) : null;
    }

    @Override
    public void updateList(Object[] objectArray) {
        int n = this.this$0.listSize;
        int n2 = objectArray.length;
        this.listCache.clear();
        this.this$0.listSize = n2;
        this.listCache.setListSize(n2);
        this.clearFetchBlocks();
        if (0 < n2) {
            this.listCache.updateListItems(0, objectArray, n2);
        }
        this.listWindow.updateList(objectArray);
        if (!this.handlePendingSizeChange()) {
            if (n2 != n) {
                this.this$0.sendNotification(1, -1, -1);
            } else {
                this.this$0.sendNotification(0, -1, -1);
            }
        }
    }

    @Override
    public void setSize(int n) {
        int n2 = this.this$0.listSize;
        if (n != n2) {
            boolean bl;
            this.this$0.listSize = n;
            this.this$0.listLoaded = true;
            this.listCache.setListSize(n);
            this.cutFetchBlocks(n - 1);
            if (0 == n && -1 != this.this$0.activatedIndex) {
                LogMessage logMessage = this.this$0.trace();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "setSize", true);
                    logMessage.append("implicitly invalidating activeIndex");
                    LogUtil.appendListConfig(logMessage, this.this$0, true).log();
                }
                this.this$0.activatedIndex = -1;
                this.this$0.sendNotification(5, -1, -1);
            }
            this.sizeChangePending = bl = 0 == n2 && !this.sizeChangePending && !this.listWindow.isLazyFetching();
            this.listWindow.setListSize(n);
            if (this.sizeChangePending) {
                this.startFetchTimer(this.activeFetchBlock);
                this.this$0.traceListSize("setSize{postponed}", this.this$0.listSize);
            } else if (!bl) {
                this.this$0.traceListSize("setSize{directly}", this.this$0.listSize);
                this.this$0.sendNotification(1, -1, -1);
            }
        } else {
            this.this$0.traceListSize("setSize{ignored}", n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSizeClearCache(int n) {
        if (0 == this.this$0.listSize) {
            this.setSize(n);
        } else {
            int n2 = this.this$0.listSize;
            this.this$0.listSize = n;
            this.this$0.listLoaded = true;
            this.clearFetchBlocks();
            try {
                ++this.suppressFetchingCounter;
                this.listWindow.setListSize(n);
            }
            finally {
                --this.suppressFetchingCounter;
            }
            this.listCache.clear();
            this.listCache.setListSize(n);
            this.listWindow.refreshItems(0, n);
            if (n != n2) {
                this.this$0.sendNotification(1, -1, -1);
            }
        }
    }

    @Override
    public void updateListItems(int n, Object[] objectArray) {
        this.this$0.listLoaded = true;
        int n2 = this.this$0.listSize;
        if (n + objectArray.length > n2) {
            this.this$0.listSize = n + objectArray.length;
        }
        this.listCache.updateListItems(n, objectArray, objectArray.length);
        this.clearFetchArea(n, n + objectArray.length - 1);
        this.listWindow.updateListItems(n, objectArray);
        if (!this.handlePendingSizeChange()) {
            if (n2 == this.this$0.listSize) {
                this.this$0.sendNotification(2, n, objectArray.length);
            } else {
                this.this$0.sendNotification(1, -1, -1);
            }
        }
        this.fetch(null);
    }

    @Override
    public void insertListItems(int n, Object[] objectArray) {
        this.this$0.listLoaded = true;
        this.this$0.listSize = n <= this.this$0.listSize ? (this.this$0.listSize += objectArray.length) : n + objectArray.length;
        this.listCache.insertListItems(n, objectArray);
        this.insertFetchGap(n, objectArray.length);
        this.listWindow.insertListItems(n, objectArray);
        if (!this.handlePendingSizeChange()) {
            this.this$0.sendNotification(3, n, objectArray.length);
        }
    }

    @Override
    public void removeListItems(int n, int n2) {
        if (n < this.this$0.listSize) {
            int n3 = n;
            int n4 = n2;
            if (n3 < 0) {
                n4 += n3;
                n3 = 0;
            }
            if (n3 + n4 > this.this$0.listSize) {
                n4 = this.this$0.listSize - n3;
            }
            if (n4 > 0) {
                this.this$0.listSize -= n4;
                this.listCache.removeListItems(n3, n4);
                this.removeFetchArea(n3, n4);
                this.listWindow.removeListItems(n3, n4);
                if (!this.handlePendingSizeChange()) {
                    this.this$0.sendNotification(4, n3, n4);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void refetch(int n, int n2) {
        this.this$0.traceListRange("refetch", n, n2);
        try {
            ++this.suppressFetchingCounter;
            this.clearFetchArea(n, n + n2 - 1);
            this.listCache.clearItems(n, n2);
            this.listWindow.refreshItems(n, n2);
            this.listWindow.storeItems(this.listCache);
        }
        finally {
            --this.suppressFetchingCounter;
        }
        this.fetch(null);
    }

    @Override
    public void notifyExecutingQueueFinished() {
        this.fetch(null);
    }

    @Override
    public void fetchTimedOut(Object object) {
        Object object2;
        boolean bl;
        GenericASLList$FetchBlock genericASLList$FetchBlock = (GenericASLList$FetchBlock)object;
        if (null != genericASLList$FetchBlock) {
            bl = genericASLList$FetchBlock.intersects(this.activeFetchBlock);
            GenericASLList$FetchBlock.release(genericASLList$FetchBlock);
        } else {
            bl = false;
        }
        if (bl) {
            genericASLList$FetchBlock = this.activeFetchBlock;
            if (++this.cntFetchTries > this.this$0.getMaxFetchTries()) {
                object2 = this.this$0.error();
                if (null != object2) {
                    LogUtil.appendPrefixAndMethod((LogMessage)object2, "GenericASLList", "fetchTimedOut", true);
                    LogUtil.appendRange((LogMessage)object2, genericASLList$FetchBlock.start, genericASLList$FetchBlock.end - genericASLList$FetchBlock.start + 1, false).append(", max fetch retries reached - giving up");
                    LogUtil.appendListConfig((LogMessage)object2, this.this$0, true).log();
                }
                this.unlink(genericASLList$FetchBlock);
                this.release(genericASLList$FetchBlock);
            } else {
                object2 = this.this$0.warn();
                if (null != object2) {
                    LogUtil.appendPrefixAndMethod((LogMessage)object2, "GenericASLList", "fetchTimedOut", true);
                    LogUtil.appendRange((LogMessage)object2, genericASLList$FetchBlock.start, genericASLList$FetchBlock.end - genericASLList$FetchBlock.start + 1, false);
                    LogUtil.appendIntProperty((LogMessage)object2, "try", this.cntFetchTries, true);
                    LogUtil.appendListConfig((LogMessage)object2, this.this$0, true).log();
                }
            }
            this.activeFetchBlock = null;
            object2 = this.getNextFetchBlock();
            if (genericASLList$FetchBlock != object2) {
                this.cntFetchTries = 0;
            }
            if (null != object2) {
                this.fetch((GenericASLList$FetchBlock)object2);
            }
        }
        if (this.sizeChangePending) {
            this.sizeChangePending = false;
            object2 = this.this$0.info();
            if (null != object2) {
                LogUtil.appendPrefixAndMethod((LogMessage)object2, "GenericASLList", "setSize{timed out}", true).append("forcing notification");
                LogUtil.appendListConfig((LogMessage)object2, this.this$0, true).log();
            }
            this.this$0.sendNotification(1, -1, -1);
        }
    }

    @Override
    public StringBuffer append(StringBuffer stringBuffer) {
        stringBuffer.append("type=windowing, itemFetcher=").append(this.itemFetcher);
        stringBuffer.append(", listWindow=[");
        this.listWindow.append(stringBuffer);
        stringBuffer.append(']');
        return stringBuffer;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("type=windowing, itemFetcher=").append(this.itemFetcher);
        logMessage.append(", listWindow=[").append(this.listWindow).append("]");
    }

    private boolean handlePendingSizeChange() {
        boolean bl = this.sizeChangePending;
        if (bl) {
            this.sizeChangePending = false;
            this.this$0.traceListSize("setSize{completed}", this.this$0.listSize);
            this.this$0.sendNotification(1, -1, -1);
        }
        return bl;
    }

    private boolean isFetchingPossible() {
        return !this.isWaitingForUpdate() && !this.this$0.isExecutingQueue() && !this.isSuppressingfetching();
    }

    private boolean isSuppressingfetching() {
        return 0 < this.suppressFetchingCounter;
    }

    private boolean isWaitingForUpdate() {
        return this.activeFetchBlock != null;
    }

    private void startFetchTimer(GenericASLList$FetchBlock genericASLList$FetchBlock) {
        GenericASLList$FetchBlock genericASLList$FetchBlock2 = (GenericASLList$FetchBlock)this.timer.startFetchTimer(genericASLList$FetchBlock = null != genericASLList$FetchBlock ? GenericASLList$FetchBlock.clone(genericASLList$FetchBlock) : null);
        if (null != genericASLList$FetchBlock2) {
            GenericASLList$FetchBlock.release(genericASLList$FetchBlock2);
        }
    }

    private void stopFetchTimer() {
        GenericASLList$FetchBlock genericASLList$FetchBlock = (GenericASLList$FetchBlock)this.timer.stopFetchTimer();
        this.cntFetchTries = 0;
        this.activeFetchBlock = null;
        if (null != genericASLList$FetchBlock) {
            GenericASLList$FetchBlock.release(genericASLList$FetchBlock);
        }
    }

    private void release(GenericASLList$FetchBlock genericASLList$FetchBlock) {
        if (this.activeFetchBlock == genericASLList$FetchBlock) {
            this.stopFetchTimer();
        }
        GenericASLList$FetchBlock.release(genericASLList$FetchBlock);
    }

    private void unlink(GenericASLList$FetchBlock genericASLList$FetchBlock) {
        GenericASLList$FetchBlock genericASLList$FetchBlock2 = this.firstFetchBlock;
        if (genericASLList$FetchBlock2 == genericASLList$FetchBlock) {
            this.firstFetchBlock = genericASLList$FetchBlock.next;
        } else {
            while (null != genericASLList$FetchBlock2 && genericASLList$FetchBlock2.next != genericASLList$FetchBlock) {
                genericASLList$FetchBlock2 = genericASLList$FetchBlock2.next;
            }
            if (null != genericASLList$FetchBlock2) {
                genericASLList$FetchBlock2.next = genericASLList$FetchBlock.next;
            }
        }
    }

    private void checkFetching(int n, Object[] objectArray, int n2) {
        int n3;
        for (n3 = 0; n3 < n2 && objectArray[n3] != DynamicListData.ITEM_NOT_LOADED; ++n3) {
        }
        if (n3 < n2) {
            int n4 = n3;
            for (n3 = n2 - 1; n3 > n4 && objectArray[n3] != DynamicListData.ITEM_NOT_LOADED; --n3) {
            }
            int n5 = n3 + n;
            GenericASLList$FetchBlock genericASLList$FetchBlock = this.addFetchRange(n4 += n, n5);
            this.fetch(genericASLList$FetchBlock);
        }
    }

    private void fetch(GenericASLList$FetchBlock genericASLList$FetchBlock) {
        block9: {
            if (this.isFetchingPossible()) {
                if (null == genericASLList$FetchBlock) {
                    genericASLList$FetchBlock = this.getNextFetchBlock();
                }
                if (null != genericASLList$FetchBlock) {
                    int n = genericASLList$FetchBlock.end - genericASLList$FetchBlock.start + 1;
                    this.this$0.traceListRange("fetchItems", genericASLList$FetchBlock.start, n);
                    this.activeFetchBlock = genericASLList$FetchBlock;
                    this.startFetchTimer(genericASLList$FetchBlock);
                    Object object = this.getRowItemCacheOnly(genericASLList$FetchBlock.start - 1);
                    try {
                        if (this.this$0.isValidItem(object)) {
                            ElementFetcherDelegator.fetchNextPage(this.this$0.services.getThreadSwitch(), this.itemFetcher, this.this$0, object, genericASLList$FetchBlock.start, n);
                        } else {
                            object = this.getRowItemCacheOnly(genericASLList$FetchBlock.end + 1);
                            if (this.this$0.isValidItem(object)) {
                                ElementFetcherDelegator.fetchPreviousPage(this.this$0.services.getThreadSwitch(), this.itemFetcher, this.this$0, object, genericASLList$FetchBlock.start, n);
                            } else {
                                ElementFetcherDelegator.fetchItems(this.this$0.services.getThreadSwitch(), this.itemFetcher, this.this$0, genericASLList$FetchBlock.start, n);
                            }
                        }
                    }
                    catch (Exception exception) {
                        LogMessage logMessage = this.this$0.error();
                        if (null == logMessage) break block9;
                        LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "fetch", true).append("fetcher execution failed");
                        LogUtil.appendListConfig(logMessage, this.this$0, true).attachThrowable(exception).log();
                    }
                }
            }
        }
    }

    private GenericASLList$FetchBlock getNextFetchBlock() {
        GenericASLList$FetchBlock genericASLList$FetchBlock = this.firstFetchBlock;
        if (null != genericASLList$FetchBlock) {
            int n = this.listWindow.getFirstListIndex();
            while (null != genericASLList$FetchBlock && (genericASLList$FetchBlock.end < n || genericASLList$FetchBlock == this.activeFetchBlock)) {
                genericASLList$FetchBlock = genericASLList$FetchBlock.next;
            }
            if (null != genericASLList$FetchBlock) {
                int n2 = this.listWindow.getLastListIndex();
                int n3 = this.listWindow.getFirstVisibleIndex();
                int n4 = this.listWindow.getLastVisibleIndex();
                int n5 = this.listWindow.getLastQueriedIndex();
                GenericASLList$FetchBlock genericASLList$FetchBlock2 = genericASLList$FetchBlock;
                GenericASLList$FetchBlock genericASLList$FetchBlock3 = null;
                GenericASLList$FetchBlock genericASLList$FetchBlock4 = null;
                do {
                    if (genericASLList$FetchBlock2.start <= n5 && n5 <= genericASLList$FetchBlock2.end) {
                        genericASLList$FetchBlock4 = genericASLList$FetchBlock2;
                        continue;
                    }
                    if (genericASLList$FetchBlock3 != null || genericASLList$FetchBlock2.start > n4 || genericASLList$FetchBlock2.end < n3) continue;
                    genericASLList$FetchBlock3 = genericASLList$FetchBlock2;
                } while (null != (genericASLList$FetchBlock2 = genericASLList$FetchBlock2.next) && null == genericASLList$FetchBlock4 && genericASLList$FetchBlock2.start <= n2);
                if (null != genericASLList$FetchBlock4) {
                    genericASLList$FetchBlock = genericASLList$FetchBlock4;
                } else if (null != genericASLList$FetchBlock3) {
                    genericASLList$FetchBlock = genericASLList$FetchBlock3;
                } else if (genericASLList$FetchBlock.end < n || genericASLList$FetchBlock.start > n2) {
                    genericASLList$FetchBlock = null;
                }
            }
        }
        return genericASLList$FetchBlock;
    }

    private GenericASLList$FetchBlock addFetchRange(int n, int n2) {
        GenericASLList$FetchBlock genericASLList$FetchBlock = this.firstFetchBlock;
        GenericASLList$FetchBlock genericASLList$FetchBlock2 = null;
        while (null != genericASLList$FetchBlock && genericASLList$FetchBlock.end < n) {
            genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        while (null != genericASLList$FetchBlock && genericASLList$FetchBlock.start <= n && n <= n2) {
            n = genericASLList$FetchBlock.end + 1;
            genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        if (null != genericASLList$FetchBlock && n <= n2 && genericASLList$FetchBlock.start <= n2) {
            int n3 = genericASLList$FetchBlock.start - 1;
            while (true) {
                if (genericASLList$FetchBlock.end < n2 && null != genericASLList$FetchBlock.next && genericASLList$FetchBlock.end >= genericASLList$FetchBlock.next.start - 1) {
                    genericASLList$FetchBlock = genericASLList$FetchBlock.next;
                    continue;
                }
                if (genericASLList$FetchBlock.end < n2) {
                    int n4 = n3 = null != genericASLList$FetchBlock.next ? genericASLList$FetchBlock.next.start - 1 : n2;
                }
                if (null == (genericASLList$FetchBlock = genericASLList$FetchBlock.next) || genericASLList$FetchBlock.start > n2) break;
            }
            n2 = Math.min(n2, n3);
        }
        genericASLList$FetchBlock = n <= n2 ? this.appendFetchBlock(genericASLList$FetchBlock2, n, n2) : null;
        return genericASLList$FetchBlock;
    }

    private GenericASLList$FetchBlock appendFetchBlock(GenericASLList$FetchBlock genericASLList$FetchBlock, int n, int n2) {
        GenericASLList$FetchBlock genericASLList$FetchBlock2;
        if (null == genericASLList$FetchBlock) {
            this.firstFetchBlock = genericASLList$FetchBlock2 = GenericASLList$FetchBlock.borrow(n, n2, this.firstFetchBlock);
        } else {
            genericASLList$FetchBlock.next = genericASLList$FetchBlock2 = GenericASLList$FetchBlock.borrow(n, n2, genericASLList$FetchBlock.next);
        }
        GenericASLList$FetchBlock genericASLList$FetchBlock3 = genericASLList$FetchBlock2.next;
        while (null != genericASLList$FetchBlock3 && genericASLList$FetchBlock3.end <= n2) {
            genericASLList$FetchBlock2.next = genericASLList$FetchBlock3.next;
            this.release(genericASLList$FetchBlock3);
            genericASLList$FetchBlock3 = genericASLList$FetchBlock2.next;
        }
        if (null != genericASLList$FetchBlock3 && genericASLList$FetchBlock3.start <= n2) {
            genericASLList$FetchBlock3.start = n2 + 1;
        }
        return genericASLList$FetchBlock2;
    }

    private void clearFetchBlocks() {
        GenericASLList$FetchBlock genericASLList$FetchBlock = this.firstFetchBlock;
        while (null != genericASLList$FetchBlock) {
            GenericASLList$FetchBlock genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
            this.release(genericASLList$FetchBlock2);
        }
        this.firstFetchBlock = null;
        this.activeFetchBlock = null;
    }

    private void clearFetchArea(int n, int n2) {
        GenericASLList$FetchBlock genericASLList$FetchBlock = this.firstFetchBlock;
        GenericASLList$FetchBlock genericASLList$FetchBlock2 = null;
        while (null != genericASLList$FetchBlock && genericASLList$FetchBlock.end < n) {
            genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        if (null == genericASLList$FetchBlock || genericASLList$FetchBlock.start > n2) {
            return;
        }
        if (genericASLList$FetchBlock.start < n) {
            if (genericASLList$FetchBlock == this.activeFetchBlock) {
                this.stopFetchTimer();
            }
            if (genericASLList$FetchBlock.end > n2) {
                genericASLList$FetchBlock.next = GenericASLList$FetchBlock.borrow(n2 + 1, genericASLList$FetchBlock.end, genericASLList$FetchBlock.next);
                genericASLList$FetchBlock.end = n - 1;
                return;
            }
            genericASLList$FetchBlock.end = n - 1;
            genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        GenericASLList$FetchBlock genericASLList$FetchBlock3 = genericASLList$FetchBlock;
        while (genericASLList$FetchBlock != null && genericASLList$FetchBlock.end <= n2) {
            GenericASLList$FetchBlock genericASLList$FetchBlock4 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
            this.release(genericASLList$FetchBlock4);
        }
        if (genericASLList$FetchBlock3 != genericASLList$FetchBlock) {
            if (null != genericASLList$FetchBlock2) {
                genericASLList$FetchBlock2.next = genericASLList$FetchBlock;
            } else {
                this.firstFetchBlock = genericASLList$FetchBlock;
            }
        }
        if (null != genericASLList$FetchBlock && genericASLList$FetchBlock.start <= n2) {
            if (genericASLList$FetchBlock == this.activeFetchBlock) {
                this.stopFetchTimer();
            }
            genericASLList$FetchBlock.start = n2 + 1;
        }
    }

    private void insertFetchGap(int n, int n2) {
        GenericASLList$FetchBlock genericASLList$FetchBlock = this.firstFetchBlock;
        while (null != genericASLList$FetchBlock && genericASLList$FetchBlock.end < n) {
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        if (null != genericASLList$FetchBlock && genericASLList$FetchBlock.start < n) {
            genericASLList$FetchBlock.next = GenericASLList$FetchBlock.borrow(n, genericASLList$FetchBlock.end, genericASLList$FetchBlock.next);
            genericASLList$FetchBlock.end = n - 1;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        while (null != genericASLList$FetchBlock) {
            genericASLList$FetchBlock.start += n2;
            genericASLList$FetchBlock.end += n2;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
    }

    private void removeFetchArea(int n, int n2) {
        GenericASLList$FetchBlock genericASLList$FetchBlock = this.firstFetchBlock;
        GenericASLList$FetchBlock genericASLList$FetchBlock2 = null;
        while (null != genericASLList$FetchBlock && genericASLList$FetchBlock.end < n) {
            genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        if (null != genericASLList$FetchBlock && genericASLList$FetchBlock.start < n) {
            genericASLList$FetchBlock.end = Math.max(genericASLList$FetchBlock.end - n2, n - 1);
            genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        GenericASLList$FetchBlock genericASLList$FetchBlock3 = genericASLList$FetchBlock;
        while (genericASLList$FetchBlock != null && genericASLList$FetchBlock.end - n2 < n) {
            GenericASLList$FetchBlock genericASLList$FetchBlock4 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
            this.release(genericASLList$FetchBlock4);
        }
        if (genericASLList$FetchBlock3 != genericASLList$FetchBlock) {
            if (null != genericASLList$FetchBlock2) {
                genericASLList$FetchBlock2.next = genericASLList$FetchBlock;
            } else {
                this.firstFetchBlock = genericASLList$FetchBlock;
            }
        }
        if (null != genericASLList$FetchBlock && genericASLList$FetchBlock.start - n2 < n) {
            genericASLList$FetchBlock.start = n;
            genericASLList$FetchBlock.end -= n2;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        while (null != genericASLList$FetchBlock) {
            genericASLList$FetchBlock.start = Math.max(genericASLList$FetchBlock.start - n2, n);
            genericASLList$FetchBlock.end -= n2;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
    }

    private void cutFetchBlocks(int n) {
        GenericASLList$FetchBlock genericASLList$FetchBlock = this.firstFetchBlock;
        GenericASLList$FetchBlock genericASLList$FetchBlock2 = null;
        while (null != genericASLList$FetchBlock && genericASLList$FetchBlock.end <= n) {
            genericASLList$FetchBlock2 = genericASLList$FetchBlock;
            genericASLList$FetchBlock = genericASLList$FetchBlock.next;
        }
        if (null != genericASLList$FetchBlock) {
            if (genericASLList$FetchBlock.start <= n) {
                genericASLList$FetchBlock.end = n;
                genericASLList$FetchBlock2 = genericASLList$FetchBlock;
                genericASLList$FetchBlock = genericASLList$FetchBlock.next;
            }
            while (null != genericASLList$FetchBlock) {
                GenericASLList$FetchBlock genericASLList$FetchBlock3 = genericASLList$FetchBlock;
                genericASLList$FetchBlock = genericASLList$FetchBlock.next;
                this.release(genericASLList$FetchBlock3);
            }
            if (null != genericASLList$FetchBlock2) {
                genericASLList$FetchBlock2.next = null;
            } else {
                this.firstFetchBlock = null;
            }
        }
    }
}

