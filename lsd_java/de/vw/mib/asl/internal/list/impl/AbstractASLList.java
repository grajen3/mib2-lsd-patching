/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.ASLListStringIndex;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$AbstractAction;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$CommonAction;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimer;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimerImpl;
import de.vw.mib.asl.internal.list.impl.ListViewListenerDelegator;
import de.vw.mib.asl.internal.list.impl.LogUtil;
import de.vw.mib.asl.internal.list.impl.Services;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.list.DynamicListDataListener;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.StringIndex;
import de.vw.mib.log4mib.LogMessage;

public abstract class AbstractASLList
implements ASLList {
    private static final String LOG_PREFIX;
    protected static final Object[] EMPTY_ARRAY;
    protected static final int IGNORED_DATA;
    protected final Services services;
    protected final int listId;
    protected final ItemTransformer transformer;
    protected final String deviceName;
    protected final String name;
    protected int listSize;
    private int listViewIndex;
    private int listViewCount;
    private CowArray listViewListeners;
    private boolean deferredListViewUpdate;
    private ASLListStringIndex stringIndex = ASLListStringIndex.NOT_USED;
    private volatile int freezeCount;
    protected int objectIdColumn = -1;
    private final CowArray dataListeners = new CowArray();
    private CowArray dataUpdateListeners;
    private AbstractASLList$AbstractAction actionQueueHead;
    private AbstractASLList$AbstractAction actionQueueTail;
    private static final int ACTION_QUEUE_SIZE_WARNING;
    private static final int ACTION_QUEUE_SIZE_MAX;
    private int actionQueueSize;
    private boolean executingQueue;
    private boolean deferredDataUpdate;
    protected int activatedIndex = -1;
    protected boolean listLoaded;
    private AbstractASLList$FetchTimer fetchTimer;
    private boolean modCountEnabled;
    private int modCount;
    private static final int MIN_TRAVERSE_SIZE;
    private static final int MAX_QUEUE_RUNS;
    protected static final int LIST_CONTENT_CHANGED;
    protected static final int LIST_CHANGED;
    protected static final int ITEMS_CHANGED;
    protected static final int ITEMS_INSERTED;
    protected static final int ITEMS_REMOVED;
    protected static final int ACTIVATED_INDEX_CHANGED;
    protected static final int STRING_INDEX_CHANGED;

    AbstractASLList(Services services, ItemTransformer itemTransformer, int n, String string, String string2) {
        this.services = services;
        this.transformer = itemTransformer;
        this.listId = n;
        this.deviceName = string;
        this.name = string2;
    }

    protected abstract void getLoadedListItems(int n, Object[] objectArray) {
    }

    protected int getLoadedItemsStart() {
        return 0;
    }

    protected int getLoadedItemsEnd() {
        return this.listSize;
    }

    protected int getLoadedItemsStepSize() {
        return 20;
    }

    private int getTraverseSize() {
        return Math.max(20, this.getLoadedItemsStepSize());
    }

    @Override
    public final void setSpeechListIds(int[] nArray) {
    }

    @Override
    public final int getColumnCount() {
        return this.transformer.getColumnCount();
    }

    public final int[] getColumnIds() {
        return this.transformer.getColumnIds();
    }

    @Override
    public final int getListId() {
        return this.listId;
    }

    @Override
    public final String getDeviceName() {
        return this.deviceName;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final synchronized void addDynamicListDataListener(DynamicListDataListener dynamicListDataListener) {
        this.dataListeners.addIfNotAlreadyIn(dynamicListDataListener);
    }

    @Override
    public final synchronized void addASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
        if (null == this.dataUpdateListeners) {
            this.dataUpdateListeners = new CowArray();
        }
        this.dataUpdateListeners.addIfNotAlreadyIn(aSLListDataUpdateListener);
    }

    @Override
    public final int getActivatedIndex() {
        return this.activatedIndex;
    }

    @Override
    public int getItemCount() {
        return this.listSize;
    }

    @Override
    public final DynamicListDataRowItemTransformer getListTransformer() {
        return this.transformer;
    }

    @Override
    public int getSize() {
        return this.listSize;
    }

    protected final boolean isObjectIdColumnSet() {
        return this.objectIdColumn != -1;
    }

    @Override
    public final boolean isValidItem(Object object) {
        return null != object && object != ITEM_NOT_LOADED;
    }

    protected Object invalidToNull(Object object) {
        return this.isValidItem(object) ? object : null;
    }

    @Override
    public final synchronized void removeDynamicListDataListener(DynamicListDataListener dynamicListDataListener) {
        this.dataListeners.remove(dynamicListDataListener);
    }

    @Override
    public final synchronized void removeASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
        if (null != this.dataUpdateListeners) {
            this.dataUpdateListeners.remove(aSLListDataUpdateListener);
        }
    }

    @Override
    public synchronized void setColumn4ObjectId(int n) {
        this.objectIdColumn = n;
    }

    protected void incModCount() {
        ++this.modCount;
    }

    @Override
    public void enableModCount() {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "enableModCount", true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        this.modCountEnabled = true;
    }

    @Override
    public void disableModCount() {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "disableModCount", true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        this.modCountEnabled = false;
        this.modCount = 0;
    }

    @Override
    public boolean isModCountEnabled() {
        return this.modCountEnabled;
    }

    @Override
    public int getModCount() {
        return this.modCount;
    }

    @Override
    public synchronized void addListViewListener(ASLListViewListener aSLListViewListener) {
        if (null == this.listViewListeners) {
            this.listViewListeners = new CowArray();
        }
        this.listViewListeners.addIfNotAlreadyIn(aSLListViewListener);
    }

    @Override
    public synchronized void removeListViewListener(ASLListViewListener aSLListViewListener) {
        if (null != this.listViewListeners) {
            this.listViewListeners.remove(aSLListViewListener);
            if (0 == this.listViewListeners.size()) {
                this.listViewListeners = null;
                this.listViewIndex = 0;
                this.listViewCount = 0;
            }
        }
    }

    @Override
    public synchronized void updateListView(int n, int n2) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "updateListView", true);
            LogUtil.appendIndex(logMessage, n, false);
            LogUtil.appendCount(logMessage, n2, true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        n2 = Math.max(0, n2);
        if (this.listViewIndex != n || this.listViewCount != n2) {
            this.listViewIndex = n;
            this.listViewCount = n2;
            this.notifyListViewUpdate(n, n2);
        } else {
            logMessage = this.trace();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "updateListView", true);
                logMessage.append("update dropped since values did not change");
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
        }
    }

    protected int getListViewIndex() {
        return this.listViewIndex;
    }

    protected int getListViewCount() {
        return this.listViewCount;
    }

    protected boolean intersectsWithListView(int n, int n2) {
        return 0 < this.listViewCount && 0 < n2 && n < this.listViewIndex + this.listViewCount && this.listViewIndex < n + n2;
    }

    protected void notifyListViewUpdate(int n, int n2) {
        Object[] objectArray;
        CowArray cowArray = this.listViewListeners;
        Object[] objectArray2 = objectArray = null != cowArray ? cowArray.getArray() : null;
        if (null != objectArray) {
            ThreadSwitchingTarget threadSwitchingTarget = this.services.getThreadSwitch();
            Object[] objectArray3 = this.getListViewItems(n, n2);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ASLListViewListener aSLListViewListener = (ASLListViewListener)objectArray[i2];
                try {
                    ListViewListenerDelegator.listViewUpdated(threadSwitchingTarget, aSLListViewListener, this, n, n2, objectArray3);
                    continue;
                }
                catch (Exception exception) {
                    LogMessage logMessage = this.error();
                    if (null == logMessage) continue;
                    LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "notifyListViewUpdate", true);
                    logMessage.append(" failed, listener=").append(String.valueOf(aSLListViewListener));
                    LogUtil.appendListConfig(logMessage, this, true).attachThrowable(exception).log();
                }
            }
        }
    }

    private Object[] getListViewItems(int n, int n2) {
        Object[] objectArray;
        if (0 < n2 && 0 <= n) {
            objectArray = new Object[n2];
            this.getLoadedListItems(n, objectArray);
        } else {
            objectArray = EMPTY_ARRAY;
        }
        return objectArray;
    }

    @Override
    public final synchronized void freeze() {
        if (0 == this.freezeCount++) {
            this.notifyFreeze();
        }
    }

    @Override
    public final boolean isFrozen() {
        return 0 < this.freezeCount;
    }

    @Override
    public final synchronized void unfreeze() {
        if (0 >= this.freezeCount) {
            this.freezeCount = 0;
            LogMessage logMessage = this.info();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "unfreeze", true).append("called on unfrozen list");
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
        } else if (0 == --this.freezeCount) {
            this.unfreezeList();
        }
    }

    @Override
    public final synchronized void forceUnfreeze() {
        if (0 < this.freezeCount) {
            this.unfreezeList();
        }
        this.freezeCount = 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void unfreezeList() {
        try {
            if (this.isActionPending()) {
                this.executeQueuedActions();
            }
        }
        catch (Exception exception) {
            try {
                LogMessage logMessage = this.error();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "unfreeze", true);
                    logMessage.append("failed to execute queued actions, continue fingers crossed");
                    LogUtil.appendListConfig(logMessage, this, true).attachThrowable(exception).log();
                }
                while (null != this.actionQueueHead) {
                    AbstractASLList$AbstractAction abstractASLList$AbstractAction = this.actionQueueHead;
                    this.actionQueueHead = abstractASLList$AbstractAction.next;
                    abstractASLList$AbstractAction.next = null;
                    abstractASLList$AbstractAction.release();
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
        finally {
            this.executingQueue = false;
            this.actionQueueHead = null;
            this.actionQueueTail = null;
            this.actionQueueSize = 0;
            this.freezeCount = 0;
        }
        if (this.deferredDataUpdate) {
            this.fireDataUpdate();
        }
        if (this.deferredListViewUpdate) {
            this.fireListViewUpdate();
        }
        this.notifyUnfreeze();
    }

    protected void notifyFreeze() {
    }

    protected void notifyUnfreeze() {
    }

    private void executeQueuedActions() {
        Object object;
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "executeQueuedActions", true).append("start");
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        int n = 0;
        while (null != this.actionQueueHead && 5 > ++n) {
            object = this.actionQueueTail;
            this.executingQueue = true;
            while (null != this.actionQueueHead && 5 > n) {
                AbstractASLList$AbstractAction abstractASLList$AbstractAction = this.actionQueueHead;
                this.actionQueueHead = abstractASLList$AbstractAction.next;
                --this.actionQueueSize;
                abstractASLList$AbstractAction.next = null;
                abstractASLList$AbstractAction.execute();
                if (abstractASLList$AbstractAction == object && this.actionQueueHead != null) {
                    ++n;
                    object = this.actionQueueTail;
                    if (null != logMessage && null != (logMessage = this.trace())) {
                        LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "executeQueuedActions", true).append("more actions enqueued during action execution");
                        LogUtil.appendListConfig(logMessage, this, true).log();
                    }
                }
                abstractASLList$AbstractAction.release();
            }
            this.executingQueue = false;
            if (null != logMessage && null != (logMessage = this.trace())) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "executeQueuedActions", true).append("post-processing");
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
            this.notifyExecutingQueueFinished();
            if (null == logMessage || null == this.actionQueueHead || null == (logMessage = this.trace())) continue;
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "executeQueuedActions", true).append("more actions enqueued during post-processing");
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        if (5 <= n) {
            object = this.error();
            if (null != object) {
                LogUtil.appendPrefixAndMethod((LogMessage)object, "ASLList", "executeQueuedActions", true).append("forced break of possibly infinite loop");
                LogUtil.appendListConfig((LogMessage)object, this, true).log();
            }
        } else if (null != logMessage && null != (logMessage = this.trace())) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "executeQueuedActions", true).append("done");
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    protected boolean isExecutingQueue() {
        return this.executingQueue;
    }

    protected boolean isActionPending() {
        return null != this.actionQueueHead;
    }

    protected void notifyExecutingQueueFinished() {
    }

    protected final synchronized void enqueueAction(AbstractASLList$AbstractAction abstractASLList$AbstractAction) {
        String string;
        LogMessage logMessage;
        if (100 == this.actionQueueSize) {
            logMessage = this.error();
            string = "maximum queue size reached, ignoring any further actions";
        } else if (20 == this.actionQueueSize) {
            logMessage = this.warn();
            string = "action queue size dangerously growing, continue fingers crossed";
        } else {
            logMessage = null;
            string = null;
        }
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "enqueueAction", true).append(string);
            LogUtil.appendIntProperty(logMessage, "queueSize", this.actionQueueSize, true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        if (100 >= this.actionQueueSize) {
            ++this.actionQueueSize;
            if (null == this.actionQueueHead) {
                this.actionQueueHead = abstractASLList$AbstractAction;
            } else {
                this.actionQueueTail.next = abstractASLList$AbstractAction;
            }
            this.actionQueueTail = abstractASLList$AbstractAction;
            this.traceQueuedListAction(abstractASLList$AbstractAction);
        }
    }

    @Override
    public synchronized void setActiveIndex(int n) {
        if (this.isFrozen()) {
            this.enqueueAction(AbstractASLList$CommonAction.activateIndexAction(this, n));
        } else {
            this.executeSetActiveIndex(n);
        }
    }

    protected void executeSetActiveIndex(int n) {
        this.traceListIndex("setActiveIndex", n);
        this.activatedIndex = n;
        this.sendNotification(5, this.activatedIndex, -1);
    }

    @Override
    public void clear() {
        this.setSize(0);
    }

    public synchronized void setSize(int n) {
        if (0 > n) {
            LogMessage logMessage = this.error();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "setSize", true);
                logMessage.append("Illegal argument ");
                LogUtil.appendSize(logMessage, n, false).append(", using 0 instead");
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
            n = 0;
        }
        if (this.isFrozen()) {
            this.enqueueAction(AbstractASLList$CommonAction.setSizeAction(this, n));
        } else {
            this.executeSetSize(n);
        }
    }

    protected abstract void executeSetSize(int n) {
    }

    @Override
    public synchronized void updateList(Object[] objectArray) {
        if (this.isFrozen()) {
            this.enqueueAction(AbstractASLList$CommonAction.updateListAction(this, objectArray));
        } else {
            this.executeUpdateList(objectArray);
        }
    }

    protected abstract void executeUpdateList(Object[] objectArray) {
    }

    @Override
    public synchronized void clearStringIndex() {
        if (this.isFrozen()) {
            this.enqueueAction(AbstractASLList$CommonAction.clearStringIndexAction(this));
        } else {
            this.executeClearStringIndex();
        }
    }

    void executeClearStringIndex() {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "clearStringIndex", false).log();
        }
        if (ASLListStringIndex.INVALID != this.stringIndex) {
            this.stringIndex.release();
            this.stringIndex = ASLListStringIndex.INVALID;
            this.sendNotification(6, -1, -1);
        }
    }

    @Override
    public synchronized StringIndex getStringIndex() {
        LogMessage logMessage;
        if (!this.isFrozen() && null != (logMessage = this.error())) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "getStringIndex", true);
            logMessage.append("called on un-frozen list, this will lead to unexpected results");
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        return this.stringIndex;
    }

    @Override
    public synchronized void updateStringIndex(int[] nArray, String[] stringArray) {
        if (this.isFrozen()) {
            this.enqueueAction(AbstractASLList$CommonAction.updateStringIndexAction(this, nArray, stringArray));
        } else {
            this.executeUpdateStringIndex(nArray, stringArray);
        }
    }

    void executeUpdateStringIndex(int[] nArray, String[] stringArray) {
        if (null == nArray || null == stringArray) {
            this.executeClearStringIndex();
        } else {
            LogMessage logMessage = this.trace();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "updateStringIndex", true);
                logMessage.append("entries=").append(nArray.length);
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
            this.stringIndex.release();
            this.stringIndex = ASLListStringIndex.borrow(nArray, stringArray);
            if (ASLListStringIndex.INVALID == this.stringIndex && null != (logMessage = this.error())) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "updateStringIndex", true);
                logMessage.append("mismatching array sizes");
                LogUtil.appendIntProperty(logMessage, "rowIndexes", nArray.length, true);
                LogUtil.appendIntProperty(logMessage, "stringIndexes", stringArray.length, true);
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
            this.sendNotification(6, -1, -1);
        }
    }

    @Override
    public long getObjectIdByRowCacheOnly(int n) {
        long l = !this.isObjectIdColumnSet() ? (long)n : this.getObjectId(this.getRowItemCacheOnly(n));
        return l;
    }

    @Override
    public final long getObjectId(Object object) {
        long l = this.isObjectIdColumnSet() && this.isValidItem(object) ? this.transformer.getLong(this.objectIdColumn, object) : -1L;
        return l;
    }

    @Override
    public synchronized Object getListItemByIdCacheOnly(long l) {
        Object object = null;
        if (this.isObjectIdColumnSet()) {
            int n = this.getLoadedItemsEnd();
            int n2 = this.getTraverseSize();
            Object[] objectArray = new Object[n2];
            for (int i2 = this.getLoadedItemsStart(); null == object && i2 < n; i2 += n2) {
                this.getLoadedListItems(i2, objectArray);
                for (int i3 = 0; null == object && i3 < objectArray.length; ++i3) {
                    Object object2 = objectArray[i3];
                    if (!this.isValidItem(object2) || this.transformer.getLong(this.objectIdColumn, object2) != l) continue;
                    object = object2;
                }
            }
        }
        return object;
    }

    @Override
    public synchronized boolean toArray(int n, Object[] objectArray) {
        this.getLoadedListItems(n, objectArray);
        return this.getLoadedItemsEnd() <= n + objectArray.length;
    }

    protected final void sendNotification(int n, int n2, int n3) {
        int n4;
        int n5 = this.getSize();
        Object[] objectArray = this.dataListeners.getArray();
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "sendNotification", true);
            AbstractASLList.appendListNotification(logMessage, n, n2, n3, n5);
            LogUtil.appendIntProperty(logMessage, "listeners", objectArray.length, true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        for (n4 = 0; n4 < objectArray.length; ++n4) {
            DynamicListDataListener dynamicListDataListener = (DynamicListDataListener)objectArray[n4];
            try {
                AbstractASLList.sendNotification(dynamicListDataListener, n, n2, n3, n5);
                continue;
            }
            catch (Exception exception) {
                logMessage = this.error();
                if (null == logMessage) continue;
                LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "sendNotification", true);
                AbstractASLList.appendListNotification(logMessage, n, n2, n3, n5);
                logMessage.append(" failed, listener=").append(String.valueOf(dynamicListDataListener));
                LogUtil.appendListConfig(logMessage, this, true).attachThrowable(exception).log();
            }
        }
        if (5 != n && 6 != n) {
            this.fireDataUpdate();
            int n6 = n4 = 0 < this.listViewCount && null != this.listViewListeners ? 1 : 0;
            if (n4 != 0) {
                switch (n) {
                    case 0: {
                        n4 = 1;
                        break;
                    }
                    case 1: {
                        int n7 = n4 = 0 == n5 ? 1 : 0;
                        if (n4 == 0) break;
                        this.listViewIndex = 0;
                        this.listViewCount = 0;
                        break;
                    }
                    case 2: {
                        n4 = this.intersectsWithListView(n2, n3) ? 1 : 0;
                        break;
                    }
                    case 3: 
                    case 4: {
                        n4 = 0;
                        break;
                    }
                }
            }
            if (n4 != 0) {
                this.fireListViewUpdate();
            }
        }
    }

    private void fireDataUpdate() {
        this.deferredDataUpdate = this.isFrozen();
        if (!this.deferredDataUpdate && null != this.dataUpdateListeners) {
            Object[] objectArray = this.dataUpdateListeners.getArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ASLListDataUpdateListener aSLListDataUpdateListener = (ASLListDataUpdateListener)objectArray[i2];
                try {
                    aSLListDataUpdateListener.notifyListDataUpdated(this);
                    continue;
                }
                catch (Exception exception) {
                    LogMessage logMessage = this.error();
                    if (null == logMessage) continue;
                    LogUtil.appendPrefixAndMethod(logMessage, "ASLList", "fireDataUpdate", true);
                    logMessage.append(" failed, listener=").append(String.valueOf(aSLListDataUpdateListener));
                    LogUtil.appendListConfig(logMessage, this, true).attachThrowable(exception).log();
                }
            }
        }
    }

    private void fireListViewUpdate() {
        this.deferredListViewUpdate = this.isFrozen();
        if (!this.deferredListViewUpdate) {
            this.notifyListViewUpdate(this.listViewIndex, this.listViewCount);
        }
    }

    private static void sendNotification(DynamicListDataListener dynamicListDataListener, int n, int n2, int n3, int n4) {
        switch (n) {
            case 0: {
                dynamicListDataListener.listContentChanged();
                break;
            }
            case 1: {
                dynamicListDataListener.listChanged(n4);
                break;
            }
            case 2: {
                dynamicListDataListener.itemsChanged(n2, n3);
                break;
            }
            case 3: {
                dynamicListDataListener.itemsInserted(n2, n3, n4);
                break;
            }
            case 4: {
                dynamicListDataListener.itemsRemoved(n2, n3, n4);
                break;
            }
            case 5: {
                dynamicListDataListener.activatedIndexChanged(n2);
                break;
            }
            case 6: {
                dynamicListDataListener.stringIndexChanged();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("illegal notification type: ").append(n).toString());
            }
        }
    }

    protected synchronized AbstractASLList$FetchTimer accessFetchTimer() {
        if (null == this.fetchTimer) {
            this.fetchTimer = new AbstractASLList$FetchTimerImpl(this);
        }
        return this.fetchTimer;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    protected long getFetchTimeout() {
        return null != this.fetchTimer ? (int)this.fetchTimer.getFetchTimeout() : 0;
    }

    public void setFetchTimeout(long l) {
        this.accessFetchTimer().setFetchTimeout(l);
    }

    protected LogMessage trace() {
        return this.services.getASLListLog().trace();
    }

    protected LogMessage info() {
        return this.services.getASLListLog().info();
    }

    protected LogMessage warn() {
        return this.services.getASLListLog().warn();
    }

    protected LogMessage error() {
        return this.services.getASLListLog().error();
    }

    private void traceQueuedListAction(AbstractASLList$AbstractAction abstractASLList$AbstractAction) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            logMessage.append("ASLList").append("#queued_").append(abstractASLList$AbstractAction.getName()).append(": ");
            LogUtil.appendIndex(logMessage, abstractASLList$AbstractAction.index, false);
            LogUtil.appendCount(logMessage, abstractASLList$AbstractAction.count, true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    protected final void traceListRange(String string, int n, int n2) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", string, true);
            LogUtil.appendRange(logMessage, n, n2, false);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    private static LogMessage appendListNotification(LogMessage logMessage, int n, int n2, int n3, int n4) {
        switch (n) {
            case 0: {
                logMessage.append("listContentChanged()");
                break;
            }
            case 1: {
                logMessage.append("listChanged( ");
                LogUtil.appendSize(logMessage, n4, false).append(" )");
                break;
            }
            case 2: {
                logMessage.append("itemsChanged( ");
                LogUtil.appendRange(logMessage, n2, n3, false);
                LogUtil.appendSize(logMessage, n4, true).append(" )");
                break;
            }
            case 3: {
                logMessage.append("itemsInserted( ");
                LogUtil.appendRange(logMessage, n2, n3, false);
                LogUtil.appendSize(logMessage, n4, true).append(" )");
                break;
            }
            case 4: {
                logMessage.append("itemsRemoved( ");
                LogUtil.appendRange(logMessage, n2, n3, false);
                LogUtil.appendSize(logMessage, n4, true).append(" )");
                break;
            }
            case 5: {
                logMessage.append("activatedIndexChanged( ");
                LogUtil.appendIndex(logMessage, n2, false).append(" )");
                break;
            }
            case 6: {
                logMessage.append("stringIndexChanged()");
                break;
            }
            default: {
                logMessage.append("?UNKNOWN?");
            }
        }
        return logMessage;
    }

    protected final void traceListIndex(String string, int n) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", string, true);
            LogUtil.appendIndex(logMessage, n, false);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    protected final void traceListCount(String string, int n) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", string, true);
            LogUtil.appendCount(logMessage, n, false);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    protected final void traceListSize(String string, int n) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLList", string, true);
            LogUtil.appendSize(logMessage, n, false);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    @Override
    public String[] getRowValuesAsStrings(int n) {
        Object object = this.getRowItemCacheOnly(n);
        String[] stringArray = null == object ? null : (ITEM_NOT_LOADED == object ? DUMMY_ROW : this.transformer.getRowValuesAsStrings(object));
        return stringArray;
    }

    protected StringBuffer append(StringBuffer stringBuffer) {
        stringBuffer.append("listId=").append(this.listId);
        stringBuffer.append(", name=");
        if (null != this.deviceName) {
            stringBuffer.append(this.deviceName).append('.');
        }
        stringBuffer.append(this.name);
        stringBuffer.append(", listSize=").append(this.listSize);
        stringBuffer.append(", objectIdColumn=").append(this.objectIdColumn);
        stringBuffer.append(", stringIndex=").append(this.stringIndex);
        stringBuffer.append(", dataListeners=").append(this.dataListeners.size());
        stringBuffer.append(", dataUpdateListeners=").append(null != this.dataUpdateListeners ? this.dataUpdateListeners.size() : 0);
        return stringBuffer;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("AbstractASLList [");
        logMessage.append("listId=").append(this.listId);
        logMessage.append(", name=");
        if (null != this.deviceName) {
            logMessage.append(this.deviceName).append(".");
        }
        logMessage.append(this.name);
        logMessage.append(", listSize=").append(this.listSize);
        logMessage.append(", objectIdColumn=").append(this.objectIdColumn);
        logMessage.append(", stringIndex=").append(this.stringIndex);
        logMessage.append(", dataListeners=").append(this.dataListeners.size());
        logMessage.append(", dataUpdateListeners=").append(null != this.dataUpdateListeners ? this.dataUpdateListeners.size() : 0);
        logMessage.append("]");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("AbstractASLList [");
        this.append(stringBuffer);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    static {
        EMPTY_ARRAY = new Object[0];
    }
}

