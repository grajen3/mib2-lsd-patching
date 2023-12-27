/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.asl.internal.list.IndexIterator;
import de.vw.mib.asl.internal.list.impl.ArrayIterator;
import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASDynamicList;
import de.vw.mib.has.HASListFetcher;
import de.vw.mib.has.HASListRequest;
import de.vw.mib.has.internal.HASListControlImpl;
import de.vw.mib.has.internal.HASListControlImpl$Strategy;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.log4mib.LogMessage;

class HASListControlImpl$ArrayStrategy
extends HASListControlImpl$Strategy {
    private HASContainer[] items = HASListControlImpl$Strategy.EMPTY_ARRAY;
    private final /* synthetic */ HASListControlImpl this$0;

    HASListControlImpl$ArrayStrategy(HASListControlImpl hASListControlImpl) {
        this.this$0 = hASListControlImpl;
    }

    @Override
    public HASDynamicList enableFetching(HASListFetcher hASListFetcher, int n) {
        this.clear();
        return this.this$0.enableFetching(hASListFetcher, n);
    }

    @Override
    public int getPageSize() {
        this.this$0.checkActive(this);
        return this.this$0.pageSize;
    }

    @Override
    public int getSize() {
        this.this$0.checkActive(this);
        return this.items.length;
    }

    @Override
    public void clear() {
        this.this$0.checkActive(this);
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(array)", "clear", true);
            HASLog.appendHASList(logMessage, this.this$0, false).log();
        }
        if (0 < this.items.length) {
            this.items = HASListControlImpl$Strategy.EMPTY_ARRAY;
            this.this$0.updateProperty(true);
        }
    }

    @Override
    public void setContent(HASContainer[] hASContainerArray) {
        this.this$0.checkActive(this);
        HASContainer[] hASContainerArray2 = null == hASContainerArray || 0 == hASContainerArray.length ? HASListControlImpl$Strategy.EMPTY_ARRAY : hASContainerArray;
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(array)", "setContent", true);
            HASLog.appendIntProperty(logMessage, "count", hASContainerArray2.length, false);
            HASLog.appendHASList(logMessage, this.this$0, true).log();
        }
        if (hASContainerArray2 != HASListControlImpl$Strategy.EMPTY_ARRAY || this.items != HASListControlImpl$Strategy.EMPTY_ARRAY) {
            int n = this.items.length;
            this.items = hASContainerArray2;
            if (n != hASContainerArray2.length) {
                this.this$0.updateProperty(this.this$0.probeItems(0, hASContainerArray2.length));
            } else {
                this.this$0.notifyUpdated(0, n);
            }
        }
    }

    @Override
    public void update(int n, HASContainer[] hASContainerArray) {
        this.this$0.checkActive(this);
        if (null == hASContainerArray) {
            throw new NullPointerException("data");
        }
        int n2 = hASContainerArray.length;
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(array)", "update", true);
            HASLog.appendIntProperty(logMessage, "index", n, false);
            HASLog.appendIntProperty(logMessage, "count", n2, true);
            HASLog.appendHASList(logMessage, this.this$0, true).log();
        }
        int n3 = 0;
        if (0 > n) {
            n3 = -n;
            n2 -= n3;
            n = 0;
        }
        if ((n2 = Math.min(n2, this.items.length - n)) < hASContainerArray.length && null != (logMessage = HASLog.warn())) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl(array)", "update", true);
            logMessage.append("Updated data exceeds list");
            HASLog.appendIntProperty(logMessage, "index", n, true);
            HASLog.appendIntProperty(logMessage, "count", n2, true);
            HASLog.appendHASList(logMessage, this.this$0, true).log();
        }
        if (0 < n2) {
            System.arraycopy((Object)hASContainerArray, n3, (Object)this.items, n, n2);
            this.this$0.notifyUpdated(n, n2);
        }
    }

    @Override
    public void setState(int n) {
        this.this$0.checkActive(this);
        this.this$0.setState(n);
    }

    @Override
    protected void request(HASListRequest hASListRequest) {
        this.this$0.checkActive(this);
        int n = this.prepareRequest(hASListRequest);
        if (0 < n) {
            System.arraycopy((Object)this.items, hASListRequest.getOffset(), (Object)hASListRequest.getData(), 0, n);
        }
        this.this$0.sendResponse(hASListRequest);
    }

    @Override
    public void onClock(HASClock hASClock) {
    }

    @Override
    public HASContainer getItem(int n) {
        return 0 <= n && n < this.items.length ? this.items[n] : null;
    }

    @Override
    public IndexIterator indexIterator() {
        return ArrayIterator.create(this.items, 0, this.items.length);
    }

    @Override
    public IndexIterator indexIterator(int n, int n2) {
        return ArrayIterator.create(this.items, n == -1 ? 0 : n, n2 == -1 ? this.items.length : n2);
    }
}

