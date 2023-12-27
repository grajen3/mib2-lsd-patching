/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.asl.internal.list.IndexIterator;
import de.vw.mib.asl.internal.list.buffer.ASLListCache;
import de.vw.mib.asl.internal.list.buffer.SoftRefArrayTreeCache;
import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASDynamicList;
import de.vw.mib.has.HASList;
import de.vw.mib.has.HASListFetcher;
import de.vw.mib.has.HASListRequest;
import de.vw.mib.has.internal.HASConfig;
import de.vw.mib.has.internal.HASListControlImpl;
import de.vw.mib.has.internal.HASListControlImpl$PendingRequest;
import de.vw.mib.has.internal.HASListControlImpl$Strategy;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.has.internal.Range;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class HASListControlImpl$CacheData
extends HASListControlImpl$Strategy
implements HASDynamicList {
    private final ASLListCache cache = new SoftRefArrayTreeCache();
    private final LinkedList requests = new LinkedList();
    private HASListFetcher fetcher;
    private int fetchSize;
    private int size;
    private int timeout = HASConfig.getFetchTTL();
    private HASListControlImpl$PendingRequest pendingFetch;
    private int fetchTTL;
    private final /* synthetic */ HASListControlImpl this$0;

    HASListControlImpl$CacheData(HASListControlImpl hASListControlImpl) {
        this.this$0 = hASListControlImpl;
    }

    private void checkPageSize() {
        int n = Math.min(this.fetchSize, HASConfig.getListPageSize());
        if (this.this$0.pageSize != n) {
            this.this$0.pageSize = n;
            this.this$0.updateProperty(false);
        }
    }

    @Override
    public HASDynamicList enableFetching(HASListFetcher hASListFetcher, int n) {
        this.this$0.checkActive(this);
        this.fetcher = hASListFetcher;
        this.fetchSize = n;
        this.checkPageSize();
        return this;
    }

    @Override
    public HASList disableFetching() {
        this.clear();
        return this.this$0.disableFetching();
    }

    @Override
    public int getPageSize() {
        this.this$0.checkActive(this);
        return this.this$0.pageSize;
    }

    @Override
    public int getSize() {
        this.this$0.checkActive(this);
        return this.size;
    }

    @Override
    public void clear() {
        this.this$0.checkActive(this);
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(cache)", "clear", true);
            HASLog.appendHASList(logMessage, this.this$0, false).log();
        }
        if (0 < this.size) {
            this.size = 0;
            this.cache.clear();
            this.this$0.updateProperty(true);
        }
        this.pendingFetch = null;
        while (!this.requests.isEmpty()) {
            HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = (HASListControlImpl$PendingRequest)this.requests.removeFirst();
            HASListRequest hASListRequest = hASListControlImpl$PendingRequest.getRequest();
            hASListControlImpl$PendingRequest.release();
            hASListRequest.setData(HASListControlImpl$Strategy.EMPTY_ARRAY);
            this.this$0.sendResponse(hASListRequest);
        }
    }

    @Override
    public void setContent(HASContainer[] hASContainerArray) {
        this.this$0.checkActive(this);
        if (null == hASContainerArray) {
            throw new NullPointerException("data");
        }
        int n = this.size;
        this.size = hASContainerArray.length;
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(cache)", "setContent", true);
            HASLog.appendIntProperty(logMessage, "count", hASContainerArray.length, false);
            HASLog.appendHASList(logMessage, this.this$0, true).log();
        }
        this.cache.cutToSize(hASContainerArray.length);
        this.cache.setItems(0, hASContainerArray, hASContainerArray.length);
        if (n != this.size) {
            this.this$0.updateProperty(this.this$0.probeItems(0, this.size));
        } else {
            this.this$0.notifyUpdated(0, this.size);
        }
        this.answerUpdate(0, hASContainerArray.length);
        if (n > this.size) {
            this.answerListShrink();
        }
        this.checkFetch();
    }

    private void release(HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest) {
        if (this.pendingFetch == hASListControlImpl$PendingRequest) {
            this.pendingFetch = null;
        }
        hASListControlImpl$PendingRequest.release();
    }

    private void answerListShrink() {
        if (!this.requests.isEmpty()) {
            Iterator iterator = this.requests.iterator();
            while (iterator.hasNext()) {
                HASListRequest hASListRequest;
                HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = (HASListControlImpl$PendingRequest)iterator.next();
                Range range = hASListControlImpl$PendingRequest.getRange();
                if (range.start >= this.size) {
                    iterator.remove();
                    hASListRequest = hASListControlImpl$PendingRequest.getRequest();
                    this.release(hASListControlImpl$PendingRequest);
                    hASListRequest.setData(HASListControlImpl$Strategy.EMPTY_ARRAY);
                    this.this$0.sendResponse(hASListRequest);
                    continue;
                }
                if (range.end < this.size) continue;
                hASListRequest = hASListControlImpl$PendingRequest.getRequest();
                Object[] objectArray = new HASContainer[this.size - range.start];
                hASListRequest.setData((HASContainer[])objectArray);
                if (!this.cache.getItems(range.start, objectArray, objectArray.length)) continue;
                iterator.remove();
                this.release(hASListControlImpl$PendingRequest);
                this.this$0.sendResponse(hASListRequest);
            }
        }
    }

    private void answerUpdate(int n, int n2) {
        if (null != this.pendingFetch && this.pendingFetch.getRange().intersects(n, n + n2 - 1)) {
            this.pendingFetch = null;
        }
        if (!this.requests.isEmpty() && 0 < n2) {
            int n3 = n + n2 - 1;
            Iterator iterator = this.requests.iterator();
            while (iterator.hasNext()) {
                HASListRequest hASListRequest;
                Object[] objectArray;
                HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = (HASListControlImpl$PendingRequest)iterator.next();
                Range range = hASListControlImpl$PendingRequest.getRange();
                if (!range.intersects(n, n3) || !this.cache.getItems(range.start, objectArray = (hASListRequest = hASListControlImpl$PendingRequest.getRequest()).getData(), objectArray.length)) continue;
                iterator.remove();
                this.release(hASListControlImpl$PendingRequest);
                this.this$0.sendResponse(hASListRequest);
            }
        }
    }

    private void checkFetch() {
        if (null == this.pendingFetch && !this.requests.isEmpty()) {
            HASContainer[] hASContainerArray;
            this.pendingFetch = (HASListControlImpl$PendingRequest)this.requests.getFirst();
            this.fetchTTL = this.timeout;
            Range range = this.pendingFetch.getRange();
            int n = range.start;
            int n2 = range.end - n + 1;
            if (n2 > this.fetchSize) {
                hASContainerArray = this.pendingFetch.getRequest().getData();
                for (int i2 = 0; i2 < hASContainerArray.length && hASContainerArray[i2] != null; ++i2) {
                    ++n;
                    --n2;
                }
                if (n2 > this.fetchSize) {
                    n2 = this.fetchSize;
                }
            }
            if (null != (hASContainerArray = HASLog.trace())) {
                HASLog.appendPrefixAndMethod((LogMessage)hASContainerArray, "HASListControlImpl(cache)", "fetchItems", true);
                HASLog.appendIntProperty((LogMessage)hASContainerArray, "index", n, false);
                HASLog.appendIntProperty((LogMessage)hASContainerArray, "count", n2, true);
                HASLog.appendHASList((LogMessage)hASContainerArray, this.this$0, true).log();
            }
            this.fetcher.fetchItems(this, n, n2);
        }
    }

    @Override
    public void update(int n, HASContainer[] hASContainerArray) {
        this.this$0.checkActive(this);
        if (null == hASContainerArray) {
            throw new NullPointerException("data");
        }
        if (0 > n) {
            throw new IllegalArgumentException("negative index");
        }
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(cache)", "update", true);
            HASLog.appendIntProperty(logMessage, "index", n, false);
            HASLog.appendIntProperty(logMessage, "count", hASContainerArray.length, true);
            HASLog.appendHASList(logMessage, this.this$0, true).log();
        }
        int n2 = this.size;
        this.size = Math.max(this.size, n + hASContainerArray.length);
        this.cache.setItems(n, hASContainerArray, hASContainerArray.length);
        if (n2 != this.size) {
            this.this$0.updateProperty(this.this$0.probeItems(n, hASContainerArray.length));
        } else {
            this.this$0.notifyUpdated(n, hASContainerArray.length);
        }
        this.answerUpdate(n, hASContainerArray.length);
        this.checkFetch();
    }

    @Override
    public void setSize(int n) {
        this.this$0.checkActive(this);
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(cache)", "setSize", true);
            HASLog.appendIntProperty(logMessage, "size", n, false);
            HASLog.appendHASList(logMessage, this.this$0, true).log();
        }
        if (0 == (n = Math.max(0, n))) {
            this.clear();
        } else if (n != this.size) {
            int n2 = this.size;
            this.size = n;
            this.cache.cutToSize(this.size);
            this.this$0.updateProperty(false);
            if (n2 > this.size) {
                this.answerListShrink();
            }
        }
    }

    @Override
    public void refresh(int n, int n2) {
        this.this$0.checkActive(this);
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(cache)", "refresh", true);
            HASLog.appendIntProperty(logMessage, "index", n, false);
            HASLog.appendIntProperty(logMessage, "count", n2, true);
            HASLog.appendHASList(logMessage, this.this$0, true).log();
        }
        if (0 < n2 && Math.max(0, n) < this.size) {
            this.cache.clearItems(n, n2);
            if (!this.requests.isEmpty()) {
                Iterator iterator = this.requests.iterator();
                while (iterator.hasNext()) {
                    HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = (HASListControlImpl$PendingRequest)iterator.next();
                    Arrays.fill(hASListControlImpl$PendingRequest.getRequest().getData(), null);
                }
            }
            this.this$0.updateProperty(true);
            this.checkFetch();
        }
    }

    @Override
    public void setState(int n) {
        this.this$0.checkActive(this);
        this.this$0.setState(n);
    }

    @Override
    protected void request(HASListRequest hASListRequest) {
        boolean bl;
        int n = this.prepareRequest(hASListRequest);
        boolean bl2 = bl = 0 >= n || this.cache.getItems(hASListRequest.getOffset(), hASListRequest.getData(), n);
        if (bl) {
            this.this$0.sendResponse(hASListRequest);
        } else if (HASConfig.getMaxListRequest() <= this.requests.size()) {
            hASListRequest.setData(HASListControlImpl$Strategy.EMPTY_ARRAY);
            hASListRequest.response(2);
        } else {
            HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = HASListControlImpl$PendingRequest.create(hASListRequest);
            this.requests.add(hASListControlImpl$PendingRequest);
            this.checkFetch();
        }
    }

    @Override
    public void onClock(HASClock hASClock) {
        int n = hASClock.getInterval();
        if (!this.requests.isEmpty()) {
            Iterator iterator = this.requests.iterator();
            while (iterator.hasNext()) {
                HASListControlImpl$PendingRequest hASListControlImpl$PendingRequest = (HASListControlImpl$PendingRequest)iterator.next();
                if (!hASListControlImpl$PendingRequest.decreaseTTL(n)) continue;
                iterator.remove();
                this.release(hASListControlImpl$PendingRequest);
            }
        }
        if (null != this.pendingFetch && 0 >= (this.fetchTTL -= n)) {
            this.pendingFetch = null;
        }
        this.checkFetch();
    }

    @Override
    public HASContainer getItem(int n) {
        return (HASContainer)this.cache.getItem(n);
    }

    @Override
    public IndexIterator indexIterator() {
        return this.cache.indexIterator();
    }

    @Override
    public IndexIterator indexIterator(int n, int n2) {
        return this.cache.indexIterator(n, n2);
    }
}

