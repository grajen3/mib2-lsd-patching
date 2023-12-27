/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientList;
import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataProvider;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategy;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategyAllAtOnce;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$InternalObserver;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$UpdateBucket;
import de.vw.mib.asl.clientapi.list.impl.LogUtil;
import de.vw.mib.asl.clientapi.list.impl.Services;
import de.vw.mib.list.Coverage;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataProvider;
import de.vw.mib.list.HMIListDataTransaction;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.HMIListViewRanges;
import de.vw.mib.list.StringIndex;
import de.vw.mib.log4mib.LogMessage;

class ASLClientListImpl
implements ASLClientList {
    private static final String LOG_PREFIX;
    static final Object[] EMPTY_ARRAY;
    private final Services services;
    private final HMIList list;
    private final Object semaphore;
    private final HMIListDataProvider dataProvider = new ASLClientListImpl$DataProvider(this);
    private final HMIListDataObserver internalObserver = new ASLClientListImpl$InternalObserver(this);
    private HMIListDataObserver dataObserver;
    private ASLClientListImpl$DataStrategy dataStrategy = new ASLClientListImpl$DataStrategyAllAtOnce(this);
    int focusIndex = -1;
    int state = 0;
    StringIndex stringIndex;

    ASLClientListImpl(Services services, HMIList hMIList) {
        this.services = services;
        this.list = hMIList;
        this.semaphore = hMIList.getSemaphore();
        this.stringIndex = this.services.getFactory().createStringIndex(null, null);
    }

    void fillViewRanges(HMIListViewRanges hMIListViewRanges) {
        this.list.fillViewRanges(hMIListViewRanges);
    }

    HMIListDataProvider getDataProvider() {
        return this.dataProvider;
    }

    Object getKey() {
        return this.list.getKey();
    }

    Object getItem(int n) {
        return this.dataStrategy.getItem(n);
    }

    Object getSemaphore() {
        return this.semaphore;
    }

    Services getServices() {
        return this.services;
    }

    void setDataStrategy(ASLClientListImpl$DataStrategy aSLClientListImpl$DataStrategy) {
        this.dataStrategy = aSLClientListImpl$DataStrategy;
    }

    void fetchTimedOut() {
        this.dataStrategy.fetchTimedOut();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setDataObserver(HMIListDataObserver hMIListDataObserver) {
        Object object = this.semaphore;
        synchronized (object) {
            this.dataObserver = hMIListDataObserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void fillItems(int n, Object[] objectArray) {
        Object object = this.semaphore;
        synchronized (object) {
            this.dataStrategy.fillItems(n, objectArray);
        }
    }

    @Override
    public int getFocusIndex() {
        return this.focusIndex;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getListSize() {
        Object object = this.semaphore;
        synchronized (object) {
            return this.dataStrategy.getListSize();
        }
    }

    @Override
    public int getListState() {
        return this.state;
    }

    @Override
    public StringIndex getStringIndex() {
        return this.stringIndex;
    }

    @Override
    public HMIListDataTransaction beginTransaction() {
        return this.services.getFactory().createDataTransaction(this.internalObserver);
    }

    @Override
    public void clear() {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.clear();
        hMIListDataTransaction.commit();
    }

    @Override
    public void refresh(int n, int n2) {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.refresh(n, n2);
        hMIListDataTransaction.commit();
    }

    @Override
    public void setContent(Object[] objectArray) {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.setContent(objectArray);
        hMIListDataTransaction.commit();
    }

    @Override
    public void setFocus(int n) {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.setFocus(n);
        hMIListDataTransaction.commit();
    }

    @Override
    public void setSize(int n) {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.setSize(n);
        hMIListDataTransaction.commit();
    }

    @Override
    public void setState(int n) {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.setState(n);
        hMIListDataTransaction.commit();
    }

    @Override
    public void setStringIndex(StringIndex stringIndex) {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.setStringIndex(stringIndex);
        hMIListDataTransaction.commit();
    }

    @Override
    public void update(int n, Object[] objectArray) {
        HMIListDataTransaction hMIListDataTransaction = this.beginTransaction();
        hMIListDataTransaction.update(n, objectArray);
        hMIListDataTransaction.commit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void execute(HMIListDataUpdate hMIListDataUpdate) {
        Object object = this.semaphore;
        synchronized (object) {
            hMIListDataUpdate = this.dataStrategy.execute(hMIListDataUpdate);
            this.notifyObserver(hMIListDataUpdate);
        }
    }

    void notifyObserver(HMIListDataUpdate hMIListDataUpdate) {
        if (null != this.dataObserver) {
            this.dataObserver.onUpdate(hMIListDataUpdate);
        } else {
            hMIListDataUpdate.release();
        }
    }

    ASLClientListImpl$UpdateBucket createBucket() {
        return ASLClientListImpl$UpdateBucket.create(this.services.getFactory());
    }

    Coverage createCoverage() {
        return this.services.getFactory().createCoverage();
    }

    void traceListRange(String string, int n, int n2) {
        LogMessage logMessage = this.services.getLogger().trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", string, true);
            LogUtil.appendRange(logMessage, n, n2, false);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    void traceListSize(String string, int n) {
        LogMessage logMessage = this.services.getLogger().trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", string, true);
            LogUtil.appendSize(logMessage, n, false);
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
    }

    @Override
    public StringIndex createStringIndex(int[] nArray, String[] stringArray) {
        return this.services.getFactory().createStringIndex(nArray, stringArray);
    }

    @Override
    public void disableFetching() {
        LogMessage logMessage = this.services.getLogger().trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", "disableFetching", true);
            LogUtil.appendListConfig(logMessage, this, false).log();
        }
        this.dataStrategy.disableFetching();
    }

    @Override
    public void enableFetching(ASLClientListFetcher aSLClientListFetcher, int n, int n2) {
        LogMessage logMessage = this.services.getLogger().trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", "enableFetching", true);
            LogUtil.appendIntProperty(logMessage, "maxFetchSize", n, false);
            logMessage.append(", settings=0x").append(Integer.toHexString(n2));
            LogUtil.appendListConfig(logMessage, this, true).log();
        }
        this.dataStrategy.enableFetching(aSLClientListFetcher, n, n2);
    }

    static {
        EMPTY_ARRAY = new Object[0];
    }
}

