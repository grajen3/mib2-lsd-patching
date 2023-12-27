/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASClockConsumer;
import de.vw.mib.has.HASList;
import de.vw.mib.has.HASListControl;
import de.vw.mib.has.HASListFetcher;
import de.vw.mib.has.HASListProperty;
import de.vw.mib.has.HASListRequest;
import de.vw.mib.has.internal.Coverage;
import de.vw.mib.has.internal.HASConfig;
import de.vw.mib.has.internal.HASListControlImpl$ArrayStrategy;
import de.vw.mib.has.internal.HASListControlImpl$CacheData;
import de.vw.mib.has.internal.HASListControlImpl$Strategy;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.log4mib.LogMessage;

final class HASListControlImpl
implements HASListControl,
HASClockConsumer {
    static final String LOG_PREFIX;
    private static final int INIT_MOD_COUNT;
    final HASListProperty property;
    private final Coverage sentData = new Coverage();
    private final int defaultPageSize;
    int pageSize;
    private int modCount = 0;
    private final HASListControlImpl$ArrayStrategy defaultStrategy = new HASListControlImpl$ArrayStrategy(this);
    private HASListControlImpl$CacheData cacheStrategy;
    private HASListControlImpl$Strategy strategy = this.defaultStrategy;

    private HASListControlImpl(HASListProperty hASListProperty) {
        this.property = hASListProperty;
        int n = hASListProperty.getPageSize();
        if (0 >= n) {
            n = HASConfig.getListPageSize();
            this.property.setPageSize(n);
        }
        this.defaultPageSize = n;
        this.pageSize = n;
        this.property.setModCount(this.modCount);
    }

    static HASListControlImpl create(HASListProperty hASListProperty) {
        return new HASListControlImpl(hASListProperty);
    }

    @Override
    public HASListProperty getListProperty() {
        return this.property;
    }

    @Override
    public HASList getStrategy() {
        return this.strategy;
    }

    @Override
    public void request(HASListRequest hASListRequest) {
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl", "request", true);
            HASLog.appendIntProperty(logMessage, "offset", hASListRequest.getOffset(), false);
            HASLog.appendHASList(logMessage, this, true).log();
        }
        this.strategy.request(hASListRequest);
    }

    @Override
    public void onClock(HASClock hASClock) {
        this.strategy.onClock(hASClock);
    }

    HASListControlImpl$CacheData enableFetching(HASListFetcher hASListFetcher, int n) {
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl", "enableFetching", true);
            HASLog.appendIntProperty(logMessage, "fetchSize", n, false);
            HASLog.appendHASList(logMessage, this, true).log();
        }
        if (null == hASListFetcher) {
            throw new NullPointerException("fetcher");
        }
        if (0 >= n) {
            throw new IllegalArgumentException(new StringBuffer().append("fetchSize: ").append(n).toString());
        }
        if (null == this.cacheStrategy) {
            this.cacheStrategy = new HASListControlImpl$CacheData(this);
        }
        this.strategy = this.cacheStrategy;
        this.cacheStrategy.enableFetching(hASListFetcher, n);
        return this.cacheStrategy;
    }

    HASListControlImpl$ArrayStrategy disableFetching() {
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl", "disableFetching", true);
            HASLog.appendHASList(logMessage, this, false).log();
        }
        this.strategy = this.defaultStrategy;
        return this.defaultStrategy;
    }

    void checkActive(HASListControlImpl$Strategy hASListControlImpl$Strategy) {
        if (this.strategy != hASListControlImpl$Strategy) {
            throw new IllegalStateException("access to inactive strategy");
        }
    }

    int getPageSize() {
        return this.pageSize;
    }

    void setPageSize(int n) {
        int n2 = Math.min(n, this.defaultPageSize);
        if (0 < n2 && this.pageSize != n2) {
            this.pageSize = n2;
            this.updateProperty(false);
        }
    }

    void setState(int n) {
        int n2 = this.property.getState();
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl", "setState", true);
            HASLog.appendIntProperty(logMessage, "state", n, false);
            HASLog.appendHASList(logMessage, this, true).log();
        }
        if (n2 != n) {
            this.property.setState(n);
            this.property.update();
        }
    }

    boolean probeItems(int n, int n2) {
        return 0 < n2 && this.sentData.intersects(n, n + n2 - 1);
    }

    void notifyUpdated(int n, int n2) {
        if (this.probeItems(n, n2)) {
            this.updateProperty(true);
        }
    }

    void updateProperty(boolean bl) {
        if (bl) {
            this.property.setModCount(++this.modCount);
            this.sentData.clear();
        }
        int n = this.strategy.getSize();
        this.property.setListSize(n);
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl", "updateProperty", true);
            HASLog.appendBooleanProperty(logMessage, "modified", bl, false);
            HASLog.appendIntProperty(logMessage, "modCount", this.modCount, true);
            HASLog.appendIntProperty(logMessage, "pageSize", this.property.getPageSize(), true);
            HASLog.appendHASList(logMessage, this, true).log();
        }
        this.property.update();
    }

    void sendResponse(HASListRequest hASListRequest) {
        int n = hASListRequest.getOffset();
        int n2 = hASListRequest.getData().length;
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, "HASListControlImpl", "sendResponse", true);
            HASLog.appendIntProperty(logMessage, "offset", hASListRequest.getOffset(), false);
            HASLog.appendIntProperty(logMessage, "count", n2, true);
            HASLog.appendIntProperty(logMessage, "modCount", this.modCount, true);
            HASLog.appendHASList(logMessage, this, true).log();
        }
        if (0 < n2) {
            this.sentData.addRange(n, n + n2 - 1);
        }
        hASListRequest.setModCount(this.modCount);
        hASListRequest.response(0);
    }
}

