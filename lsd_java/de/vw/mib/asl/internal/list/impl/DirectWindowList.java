/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListWindowFetcher;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.AbstractASLList;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimeoutHandler;
import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimer;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$1;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$2;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$3;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$4;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$IdIndexArray;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$ScrollFallbackMechanism;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$WindowAction;
import de.vw.mib.asl.internal.list.impl.LogUtil;
import de.vw.mib.asl.internal.list.impl.Services;
import de.vw.mib.asl.internal.list.impl.WindowFetcherDelegator;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongOptHashSet;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;

public final class DirectWindowList
extends AbstractASLList
implements ASLList {
    private static final String LOG_PREFIX;
    private Object[] window = EMPTY_ARRAY;
    private final AbstractASLList$FetchTimer fetchTimer;
    private final AbstractASLList$FetchTimeoutHandler timeoutHandler = new DirectWindowList$1(this);
    private ASLListWindowFetcher fetcher;
    private int windowSize;
    private int margin;
    private boolean lazyFetching;
    private int itemsUsed;
    private DirectWindowList$IdIndexArray currentIds;
    private DirectWindowList$IdIndexArray incomingIds;
    private int firstIndex;
    private int lastQueriedIndex;
    private boolean startOfListContained = true;
    private boolean endOfListContained = true;
    private boolean listSizeKnown = true;
    private static final long NO_ANCHOR_PROVIDED;
    private static final long NO_FETCHING_ACTIVE;
    private long fetchingAnchorId = -2L;
    private static final int MAX_FETCH_TRIES;
    private int cntFetchTries;
    private static final int SCROLL_OFF;
    private static final int SCROLL_UP;
    private static final int SCROLL_DOWN;
    private int scrollDirection = 0;
    private int cntScrollTries;
    public static final DirectWindowList$ScrollFallbackMechanism SCROLL_FALLBACK_OFF;
    public static final DirectWindowList$ScrollFallbackMechanism SCROLL_FALLBACK_EDGE_DETECT;
    public static final DirectWindowList$ScrollFallbackMechanism SCROLL_FALLBACK_ANCHOR_SWITCH;
    private DirectWindowList$ScrollFallbackMechanism scrollFallbackMechanism = SCROLL_FALLBACK_OFF;
    private static final int MAX_NUM_AVOID_ANCHORS;
    private LongSet avoidingAnchorIds;
    private static final int DEFAULT_SCROLL_FALLBACK_TRIES;
    private int scrollFallbackTries = 5;

    DirectWindowList(Services services, ItemTransformer itemTransformer, int n, String string, String string2) {
        super(services, itemTransformer, n, string, string2);
        this.fetchTimer = this.accessFetchTimer();
        this.fetchTimer.setFetchTimeoutHandler(this.timeoutHandler);
    }

    public synchronized void setConfiguration(ASLListWindowFetcher aSLListWindowFetcher, int n, int n2, boolean bl) {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "setConfiguration", true);
            LogUtil.appendIntProperty(logMessage, "windowSize", n, false);
            LogUtil.appendIntProperty(logMessage, "margin", n2, true);
            LogUtil.appendBooleanProperty(logMessage, "lazyFetching", bl, true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        if (0 != this.windowSize && null != (logMessage = this.warn())) {
            LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "setConfiguration", true).append("already configured, this meay lead to unexpected results");
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        this.fetcher = aSLListWindowFetcher;
        this.windowSize = n;
        this.margin = n2;
        this.lazyFetching = bl;
        this.window = new Object[this.windowSize];
        this.currentIds = new DirectWindowList$IdIndexArray(n);
        this.incomingIds = new DirectWindowList$IdIndexArray(n);
        this.firstIndex = 0;
        this.startOfListContained = true;
        this.endOfListContained = true;
        this.listSizeKnown = true;
        this.listSize = 0;
        this.itemsUsed = 0;
    }

    public void setScrollFallbackMechanism(DirectWindowList$ScrollFallbackMechanism directWindowList$ScrollFallbackMechanism) {
        this.scrollFallbackMechanism = null != directWindowList$ScrollFallbackMechanism ? directWindowList$ScrollFallbackMechanism : SCROLL_FALLBACK_OFF;
        LogMessage logMessage = this.info();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "setScrollFallbackMechanism", true);
            logMessage.append("now using ").append(this.scrollFallbackMechanism.getName());
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    public void setScrollFallbackTries(int n) {
        this.scrollFallbackTries = n;
    }

    synchronized void fetchTimedOut(Object object) {
        if (this.isFetching()) {
            this.fetchingAnchorId = -2L;
            ++this.cntFetchTries;
            if (this.cntFetchTries >= 5) {
                LogMessage logMessage = this.error();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "fetchTimedOut", true).append("max fetch retries reached, giving up");
                    LogUtil.appendListConfig(logMessage, this, true).log();
                }
            } else {
                LogMessage logMessage = this.warn();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "fetchTimedOut", true);
                    LogUtil.appendIntProperty(logMessage, "try", this.cntFetchTries, false);
                    LogUtil.appendListConfig(logMessage, this, true).log();
                }
                if (!this.checkScrolling() && ITEM_NOT_LOADED == this.getRowItemCacheOnly(this.lastQueriedIndex)) {
                    this.refetch();
                }
            }
            if (!this.isFetching()) {
                this.cntFetchTries = 0;
            }
        }
    }

    private void fetchWindow(int n, Object object, int n2) {
        block2: {
            this.traceListRange("fetchWindow", n, this.windowSize);
            this.fetchingAnchorId = this.getObjectId(object);
            this.fetchTimer.startFetchTimer(null);
            try {
                WindowFetcherDelegator.fetchWindow(this.services.getThreadSwitch(), this.fetcher, this, n, object, n2);
            }
            catch (Exception exception) {
                LogMessage logMessage = this.error();
                if (null == logMessage) break block2;
                LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "fetchWindow", true).append("fetcher execution failed");
                LogUtil.appendListConfig(logMessage, this, true).attachThrowable(exception).log();
            }
        }
    }

    private void fetchFirstItems() {
        block2: {
            this.traceListRange("fetchFirstItems", 0, this.windowSize);
            this.fetchingAnchorId = -1L;
            this.fetchTimer.startFetchTimer(null);
            try {
                WindowFetcherDelegator.fetchFirstItems(this.services.getThreadSwitch(), this.fetcher, this);
            }
            catch (Exception exception) {
                LogMessage logMessage = this.error();
                if (null == logMessage) break block2;
                LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "fetchFirstItems", true).append("fetcher execution failed");
                LogUtil.appendListConfig(logMessage, this, true).attachThrowable(exception).log();
            }
        }
    }

    @Override
    public synchronized Object getListItemByIdCacheOnly(long l) {
        Object object = null;
        if (0 < this.itemsUsed && this.isObjectIdColumnSet()) {
            int n = this.currentIds.findID(l);
            object = n != -1 ? this.window[n] : null;
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void getLoadedListItems(int n, Object[] objectArray) {
        int n2;
        int n3;
        int n4;
        Object[] objectArray2;
        int n5;
        int n6;
        DirectWindowList directWindowList = this;
        synchronized (directWindowList) {
            n6 = this.firstIndex;
            n5 = this.listSize;
            objectArray2 = this.window;
            n4 = this.itemsUsed;
        }
        int n7 = 0;
        if (n < n6) {
            n7 = Math.min(objectArray.length, n6 - n);
            Arrays.fill(objectArray, 0, n7, ITEM_NOT_LOADED);
            n = n6;
        }
        if (0 < (n3 = Math.min(objectArray.length - n7, (n2 = Math.min(n6 + n4, n5)) - n))) {
            System.arraycopy((Object)objectArray2, n - n6, (Object)objectArray, n7, n3);
            n7 += n3;
            n += n3;
        }
        if (0 < (n3 = Math.min(objectArray.length - n7, n5 - n))) {
            Arrays.fill(objectArray, n7, n7 + n3, ITEM_NOT_LOADED);
            n7 += n3;
            n += n3;
        }
        if (0 < (n3 = objectArray.length - n7)) {
            Arrays.fill(objectArray, n7, objectArray.length, null);
        }
    }

    @Override
    protected int getLoadedItemsStart() {
        return this.firstIndex;
    }

    @Override
    protected int getLoadedItemsEnd() {
        return Math.min(this.firstIndex + this.itemsUsed, this.listSize);
    }

    @Override
    protected int getLoadedItemsStepSize() {
        return this.windowSize;
    }

    @Override
    public Object getRowItem(int n) {
        this.lastQueriedIndex = n;
        int n2 = n - this.firstIndex;
        Object object = this.getRowItemCacheOnly(n);
        boolean bl = false;
        if (n2 < this.margin && !this.startOfListContained) {
            bl = this.checkScrolling();
        } else if (this.itemsUsed - n2 <= this.margin && !this.endOfListContained) {
            bl = this.checkScrolling();
        }
        if (ITEM_NOT_LOADED == object && !bl) {
            this.refetch();
        }
        return object;
    }

    @Override
    public Object getRowItemCacheOnly(int n) {
        Object object;
        int n2 = n - this.firstIndex;
        int n3 = this.getSize();
        if (0 <= n2 && n2 < this.itemsUsed) {
            object = this.window[n2];
        } else if (0 <= n && n < n3) {
            object = ITEM_NOT_LOADED;
        } else {
            LogMessage logMessage = this.warn();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "getRowItemCacheOnly", true).append("index out of range - ");
                LogUtil.appendIndex(logMessage, n, false);
                LogUtil.appendSize(logMessage, n3, true);
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
            object = null;
        }
        return object;
    }

    @Override
    public int getSize() {
        return this.listSizeKnown ? this.listSize : this.listSize + this.margin;
    }

    private boolean isFetching() {
        return this.fetchingAnchorId != -2L;
    }

    private boolean isFetchingPossible() {
        return !this.isFetching() && !this.isExecutingQueue();
    }

    @Override
    protected void notifyExecutingQueueFinished() {
        this.checkScrolling();
    }

    public synchronized void refetch() {
        if (this.isFetchingPossible()) {
            int n = this.lastQueriedIndex - this.firstIndex;
            if (n < 0 || this.itemsUsed <= n) {
                n = this.itemsUsed >> 1;
            }
            Object object = null;
            int n2 = -1;
            int n3 = Math.max(n, this.itemsUsed - n - 1);
            for (int i2 = 0; object == null && i2 <= n3; ++i2) {
                int n4 = n + i2;
                if (n4 < this.itemsUsed && null != (object = this.invalidToNull(this.window[n4]))) {
                    n2 = n4;
                }
                n4 = n - i2;
                if (null != object || n4 < 0 || i2 == 0 || null == (object = this.invalidToNull(this.window[n4]))) continue;
                n2 = n4;
            }
            this.cntScrollTries = 0;
            this.scrollDirection = 0;
            if (null != object) {
                this.fetchWindow(this.firstIndex, object, n2);
            } else {
                this.fetchFirstItems();
            }
        }
    }

    private synchronized boolean checkScrolling() {
        boolean bl = false;
        if (this.isFetchingPossible()) {
            int n = this.lastQueriedIndex - this.firstIndex;
            if (n < this.margin && !this.startOfListContained) {
                this.scrollUp();
                bl = true;
                if (this.scrollDirection != -1) {
                    this.cntScrollTries = 0;
                    this.scrollDirection = -1;
                }
            } else if (this.itemsUsed - n <= this.margin && !this.endOfListContained) {
                this.scrollDown();
                bl = true;
                if (this.scrollDirection != 1) {
                    this.cntScrollTries = 0;
                    this.scrollDirection = 1;
                }
            }
        }
        return bl;
    }

    private boolean avoidAnchor(Object object) {
        return this.scrollFallbackMechanism == SCROLL_FALLBACK_ANCHOR_SWITCH && null != this.avoidingAnchorIds && this.avoidingAnchorIds.contains(this.getObjectId(object));
    }

    private void scrollDown() {
        int n = this.lastQueriedIndex;
        int n2 = n - this.firstIndex;
        Object object = null;
        Object object2 = null;
        int n3 = -1;
        if (0 <= n2 && n2 < this.itemsUsed && null != (object = this.invalidToNull(this.window[n2]))) {
            object2 = object;
            n3 = n2;
            if (this.avoidAnchor(object)) {
                object = null;
            }
        }
        if (null == object) {
            n2 = this.itemsUsed;
            while (null == object && 0 <= --n2) {
                object = this.invalidToNull(this.window[n2]);
                if (null == object) continue;
                if (null == object2) {
                    object2 = object;
                    n3 = n2;
                }
                if (!this.avoidAnchor(object)) continue;
                object = null;
            }
        }
        if (null == object) {
            object = object2;
            n2 = n3;
        }
        if (null != object && n2 > 0) {
            int n4 = Math.max(n - this.firstIndex - this.windowSize + 1, 0) + this.margin;
            int n5 = Math.max(n2 - n4, 0);
            n4 = n5 - n2;
            this.traceListCount("scrollDown", -n4);
            this.fetchWindow(this.firstIndex - n4, object, n5);
        } else {
            this.fetchFirstItems();
        }
    }

    private void scrollUp() {
        int n = this.lastQueriedIndex;
        int n2 = n - this.firstIndex;
        Object object = null;
        Object object2 = null;
        int n3 = -1;
        if (0 <= n2 && n2 < this.itemsUsed && null != (object = this.invalidToNull(this.window[n2]))) {
            object2 = object;
            n3 = n2;
            if (this.avoidAnchor(object)) {
                object = null;
            }
        }
        if (null == object) {
            n2 = -1;
            while (null == object && ++n2 < this.itemsUsed) {
                object = this.invalidToNull(this.window[n2]);
                if (null == object) continue;
                if (null == object2) {
                    object2 = object;
                    n3 = n2;
                }
                if (!this.avoidAnchor(object)) continue;
                object = null;
            }
        }
        if (null == object) {
            object = object2;
            n2 = n3;
        }
        if (null != object && n2 < this.windowSize - 1) {
            int n4 = Math.min(n - this.firstIndex, 0) - this.margin;
            int n5 = Math.min(n2 - n4, this.windowSize - 1);
            n4 = n5 - n2;
            this.traceListCount("scrollUp", n4);
            this.fetchWindow(this.firstIndex - n4, object, n5);
        } else {
            this.fetchFirstItems();
        }
    }

    @Override
    public synchronized void setColumn4ObjectId(int n) {
        super.setColumn4ObjectId(n);
        if (0 < this.windowSize) {
            if (this.isObjectIdColumnSet()) {
                this.storeIDs(this.currentIds, this.window);
            } else {
                this.currentIds.count = 0;
            }
        }
    }

    private void storeIDs(DirectWindowList$IdIndexArray directWindowList$IdIndexArray, Object[] objectArray) {
        int n = 0;
        if (null != objectArray) {
            int n2 = Math.min(objectArray.length, this.windowSize);
            for (int i2 = 0; i2 < n2; ++i2) {
                long l;
                directWindowList$IdIndexArray.ids[i2] = l = this.getObjectId(objectArray[i2]);
                if (-1L == l) continue;
                n = i2 + 1;
            }
        }
        directWindowList$IdIndexArray.count = n;
        directWindowList$IdIndexArray.sort();
    }

    public synchronized void updateListWindow(int n, Object[] objectArray, boolean bl, boolean bl2) {
        if (null == objectArray) {
            throw new IllegalArgumentException("items null");
        }
        this.fetchTimer.stopFetchTimer();
        this.cntFetchTries = 0;
        if (this.isFrozen()) {
            this.enqueueAction(DirectWindowList$WindowAction.updateListWindow(this, n, objectArray, bl, bl2));
        } else {
            this.executeUpdateListWindow(n, objectArray, bl, bl2);
        }
    }

    void executeUpdateListWindow(int n, Object[] objectArray, boolean bl, boolean bl2) {
        this.traceListRange("updateListWindow", n, null != objectArray ? objectArray.length : 0);
        if (this.windowSize <= 0) {
            LogMessage logMessage = this.error();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "updateListWindow", true).append("called before list was configured");
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
        } else {
            int n2;
            int n3;
            int n4;
            int n5 = this.getSize();
            this.endOfListContained = bl2;
            this.startOfListContained = bl;
            this.listLoaded = true;
            int n6 = null != objectArray ? Math.min(objectArray.length, this.windowSize) : 0;
            int n7 = -1;
            int n8 = -1;
            if (this.isObjectIdColumnSet()) {
                this.storeIDs(this.incomingIds, objectArray);
                if (this.isFetching() && this.fetchingAnchorId != -1L) {
                    n8 = this.currentIds.findID(this.fetchingAnchorId);
                    n7 = this.incomingIds.findID(this.fetchingAnchorId);
                }
                if (n7 == -1 || n8 == -1) {
                    DirectWindowList$IdIndexArray.findMatch(this.currentIds, this.incomingIds);
                    n8 = this.currentIds.matchIndex;
                    n7 = this.incomingIds.matchIndex;
                }
                DirectWindowList$IdIndexArray directWindowList$IdIndexArray = this.currentIds;
                this.currentIds = this.incomingIds;
                this.incomingIds = directWindowList$IdIndexArray;
            }
            int n9 = 0;
            boolean bl3 = false;
            if (n7 != -1) {
                LogMessage logMessage = this.trace();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "updateListWindow", true).append("matching item found - ");
                    LogUtil.appendIntProperty(logMessage, "oldIdx", n8, false);
                    LogUtil.appendIntProperty(logMessage, "newIdx", n7, true);
                    LogUtil.appendListConfig(logMessage, this, true).log();
                }
                n4 = n8 - n7;
                boolean bl4 = bl3 = n6 < this.windowSize;
                if (bl3) {
                    if (n4 < 0 && !this.endOfListContained) {
                        n3 = this.windowSize + n4;
                        if (0 < n3) {
                            System.arraycopy((Object)this.window, 0, (Object)this.window, -n4, n3);
                        }
                    } else if (n4 > 0 && !this.startOfListContained) {
                        n9 = n4;
                        n4 = 0;
                        n3 = n9 + n6 - this.windowSize;
                        if (n3 > 0) {
                            System.arraycopy((Object)this.window, n3, (Object)this.window, 0, this.windowSize - n3);
                            n9 -= n3;
                            n4 += n3;
                        }
                    }
                }
            } else {
                n4 = n6 == 0 ? 0 : Math.max(n, 0) - this.firstIndex;
            }
            if (0 == n4 && this.scrollDirection != 0) {
                this.scrollingFailed();
            } else {
                this.cntScrollTries = 0;
                this.scrollDirection = 0;
            }
            this.fetchingAnchorId = -2L;
            this.itemsUsed = Math.max(n9 + n6, this.endOfListContained ? 0 : this.itemsUsed);
            if (0 < n6) {
                System.arraycopy((Object)objectArray, 0, (Object)this.window, n9, n6);
            }
            if (this.endOfListContained && this.itemsUsed < this.windowSize) {
                Arrays.fill(this.window, this.itemsUsed, this.windowSize, ITEM_NOT_LOADED);
            }
            if (bl3) {
                this.storeIDs(this.currentIds, this.window);
            }
            this.firstIndex += n4;
            int n10 = n2 = this.firstIndex < 0 ? -this.firstIndex : 0;
            if (0 < n2) {
                this.firstIndex += n2;
                this.lastQueriedIndex += n2;
                this.listSize += n2;
            }
            int n11 = n3 = this.startOfListContained ? this.firstIndex : 0;
            if (0 < n3) {
                this.firstIndex -= n3;
                this.lastQueriedIndex = Math.max(0, this.lastQueriedIndex - n3);
                this.listSize = Math.max(0, this.listSize - n3);
            }
            if (this.endOfListContained) {
                this.listSize = this.firstIndex + this.itemsUsed;
                this.listSizeKnown = true;
            } else {
                int n12 = this.firstIndex + this.itemsUsed;
                if (n12 >= this.listSize) {
                    this.listSize = n12;
                    this.listSizeKnown = false;
                }
            }
            this.traceWindowPosition();
            if (n3 > 0) {
                this.sendNotification(4, 0, n3);
            }
            if (n2 > 0) {
                this.sendNotification(3, 0, n2);
            }
            if (n5 != this.getSize()) {
                this.sendNotification(1, -1, -1);
            } else if (this.itemsUsed > 0) {
                this.sendNotification(2, this.firstIndex, this.itemsUsed);
            }
            this.checkScrolling();
        }
    }

    private void scrollingFailed() {
        ++this.cntScrollTries;
        if (this.cntScrollTries > this.scrollFallbackTries) {
            LogMessage logMessage = this.info();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "scrollingFailed", true);
                logMessage.append("could not scroll ").append(this.cntScrollTries).append(" times, fallback ").append(this.scrollFallbackMechanism.getName()).append(" active - ");
            }
            this.scrollFallbackMechanism.fallback(this, logMessage);
            if (null != logMessage) {
                LogUtil.appendListConfig(logMessage, this, true).log();
            }
            this.cntScrollTries = 0;
        }
    }

    static void scrollFallbackEdgeDetect(DirectWindowList directWindowList, LogMessage logMessage) {
        DirectWindowList.appendMessage(logMessage, "assuming ");
        switch (directWindowList.scrollDirection) {
            case 1: {
                directWindowList.endOfListContained = true;
                directWindowList.listSizeKnown = true;
                DirectWindowList.appendMessage(logMessage, "end");
                break;
            }
            case -1: {
                directWindowList.startOfListContained = true;
                DirectWindowList.appendMessage(logMessage, "start");
                break;
            }
        }
        DirectWindowList.appendMessage(logMessage, " of list reached");
        directWindowList.cntScrollTries = 0;
        directWindowList.scrollDirection = 0;
    }

    static void scrollFallbackAnchorSwitch(DirectWindowList directWindowList, LogMessage logMessage) {
        if (null != logMessage) {
            logMessage.append("avoiding anchor with id ").append(directWindowList.fetchingAnchorId);
        }
        if (null == directWindowList.avoidingAnchorIds) {
            directWindowList.avoidingAnchorIds = new LongOptHashSet(10);
        } else if (directWindowList.avoidingAnchorIds.size() >= 10) {
            LongIterator longIterator = directWindowList.avoidingAnchorIds.iterator();
            longIterator.next();
            longIterator.remove();
        }
        directWindowList.avoidingAnchorIds.add(directWindowList.fetchingAnchorId);
    }

    static LogMessage appendMessage(LogMessage logMessage, String string) {
        if (null != logMessage) {
            logMessage.append(string);
        }
        return logMessage;
    }

    private void traceWindowPosition() {
        LogMessage logMessage = this.trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "windowPosition", true);
            if (0 < this.itemsUsed) {
                LogUtil.appendRangeProperty(logMessage, "window", this.firstIndex, this.firstIndex + this.itemsUsed - 1, false);
            } else {
                logMessage.append("window=empty");
            }
            LogUtil.appendBooleanProperty(logMessage, "beginReached", this.startOfListContained, true);
            LogUtil.appendBooleanProperty(logMessage, "endReached", this.endOfListContained, true);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    @Override
    protected void executeSetSize(int n) {
        this.traceListSize("setSize", n);
        int n2 = this.listSize;
        if (n != n2) {
            this.listSize = n;
            if (this.windowSize <= 0) {
                LogMessage logMessage = this.error();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "DirectWindowList", "setSize", true).append("called before list was configured");
                    LogUtil.appendListConfig(logMessage, this, true).log();
                }
            } else if (n > 0) {
                int n3;
                int n4;
                this.listLoaded = true;
                this.lastQueriedIndex = Math.min(this.lastQueriedIndex, n - 1);
                boolean bl = this.endOfListContained = n - this.firstIndex <= this.windowSize;
                if (n < n2) {
                    int n5 = Math.max(n - this.firstIndex, 0);
                    if (n5 < this.windowSize) {
                        Arrays.fill(this.window, n5, this.windowSize, ITEM_NOT_LOADED);
                        this.itemsUsed = n5;
                        if (this.isObjectIdColumnSet()) {
                            this.storeIDs(this.currentIds, this.window);
                        }
                    }
                } else if (n > n2 && (n4 = Math.max(n2 - this.firstIndex, 0)) < (n3 = Math.min(n - this.firstIndex, this.windowSize))) {
                    Arrays.fill(this.window, n4, n3, ITEM_NOT_LOADED);
                    if (!this.lazyFetching) {
                        this.refetch();
                    }
                }
            } else {
                this.fetchTimer.stopFetchTimer();
                this.cntFetchTries = 0;
                this.lastQueriedIndex = 0;
                Arrays.fill(this.window, ITEM_NOT_LOADED);
                Arrays.fill(this.currentIds.ids, -1L);
                this.currentIds.count = 0;
                this.fetchingAnchorId = -2L;
                this.scrollDirection = 0;
                this.startOfListContained = true;
                this.endOfListContained = true;
                this.itemsUsed = 0;
            }
            this.listSizeKnown = true;
            this.sendNotification(1, -1, -1);
        }
    }

    @Override
    public synchronized void updateList(Object[] objectArray) {
        this.fetchTimer.stopFetchTimer();
        this.cntFetchTries = 0;
        super.updateList(objectArray);
    }

    @Override
    protected void executeUpdateList(Object[] objectArray) {
        int n = null != objectArray ? objectArray.length : 0;
        this.traceListRange("updateList", 0, n);
        this.firstIndex = Math.max(n - this.windowSize, 0);
        this.listSize = n;
        this.listLoaded = true;
        this.startOfListContained = 0 == this.firstIndex;
        this.endOfListContained = n <= this.firstIndex + this.windowSize;
        this.listSizeKnown = true;
        this.lastQueriedIndex = Math.max(this.lastQueriedIndex - 1, n - 1) + 1;
        this.fetchingAnchorId = -2L;
        this.itemsUsed = Math.min(this.windowSize, n);
        if (0 < this.itemsUsed) {
            System.arraycopy((Object)objectArray, 0, (Object)this.window, 0, this.itemsUsed);
        }
        if (this.itemsUsed < this.windowSize) {
            Arrays.fill(this.window, this.itemsUsed, this.windowSize, ITEM_NOT_LOADED);
        }
        this.traceWindowPosition();
        if (0 < this.windowSize && this.isObjectIdColumnSet()) {
            this.storeIDs(this.currentIds, this.window);
        }
        this.cntScrollTries = 0;
        this.scrollDirection = 0;
        this.sendNotification(1, -1, -1);
    }

    public Object[] accessWindow() {
        Object[] objectArray = this.window;
        Object[] objectArray2 = new Object[objectArray.length];
        System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, objectArray.length);
        return objectArray2;
    }

    public synchronized void notifyUpdates() {
        this.sendNotification(0, -1, -1);
    }

    @Override
    protected StringBuffer append(StringBuffer stringBuffer) {
        super.append(stringBuffer);
        stringBuffer.append(", windowSize=").append(this.windowSize);
        stringBuffer.append(", margin=").append(this.margin);
        int n = this.itemsUsed;
        stringBuffer.append(", window=");
        if (0 < n) {
            int n2 = this.firstIndex;
            int n3 = n2 + n - 1;
            stringBuffer.append('[').append(n2).append("..").append(n3).append(']');
        } else {
            stringBuffer.append("empty");
        }
        stringBuffer.append(", scrollFallbackMechanism=").append(this.scrollFallbackMechanism.getName());
        return stringBuffer;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("DirectWindowList [");
        super.toString(logMessage);
        logMessage.append(", windowSize=").append(this.windowSize);
        logMessage.append(", margin=").append(this.margin);
        int n = this.itemsUsed;
        logMessage.append(", window=");
        if (0 < n) {
            int n2 = this.firstIndex;
            int n3 = n2 + n - 1;
            logMessage.append("[").append(n2).append("..").append(n3).append("]");
        } else {
            logMessage.append("empty");
        }
        logMessage.append(", scrollFallbackMechanism=").append(this.scrollFallbackMechanism.getName());
        logMessage.append("]");
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DirectWindowList [");
        this.append(stringBuffer);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    static {
        SCROLL_FALLBACK_OFF = new DirectWindowList$2();
        SCROLL_FALLBACK_EDGE_DETECT = new DirectWindowList$3();
        SCROLL_FALLBACK_ANCHOR_SWITCH = new DirectWindowList$4();
    }
}

