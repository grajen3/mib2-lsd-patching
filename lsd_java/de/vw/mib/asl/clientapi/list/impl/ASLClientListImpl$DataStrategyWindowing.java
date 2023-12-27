/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategy;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategyAllAtOnce;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategyWindowing$InternalManipulator;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$UpdateBucket;
import de.vw.mib.asl.clientapi.list.impl.FetchHandler;
import de.vw.mib.asl.clientapi.list.impl.LogUtil;
import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.StringIndex;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;

class ASLClientListImpl$DataStrategyWindowing
extends ASLClientListImpl$DataStrategy {
    private final ASLListElementCache cache;
    private final FetchHandler fetchHandler;
    private final boolean lazyFetching;
    private int size;
    private boolean sizeChangePending;
    private final /* synthetic */ ASLClientListImpl this$0;

    ASLClientListImpl$DataStrategyWindowing(ASLClientListImpl aSLClientListImpl, ASLClientListFetcher aSLClientListFetcher, int n, int n2) {
        this.this$0 = aSLClientListImpl;
        super(aSLClientListImpl);
        this.cache = new ASLListItemSoftCacheImpl();
        this.fetchHandler = new FetchHandler(aSLClientListImpl, aSLClientListFetcher, n);
        this.lazyFetching = 0 != (n2 & 1);
    }

    @Override
    void fetchTimedOut() {
        if (this.sizeChangePending) {
            ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket;
            this.sizeChangePending = false;
            LogMessage logMessage = this.this$0.getServices().getLogger().info();
            if (null != logMessage) {
                LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", "setSize{timed out}", true).append("forcing notification");
                LogUtil.appendListConfig(logMessage, this.this$0, true).log();
            }
            if (this.handlePendingSizeChange(aSLClientListImpl$UpdateBucket = this.this$0.createBucket())) {
                aSLClientListImpl$UpdateBucket.commit();
                this.this$0.notifyObserver(aSLClientListImpl$UpdateBucket.getUpdate());
            } else {
                aSLClientListImpl$UpdateBucket.dismiss();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    HMIListDataUpdate execute(HMIListDataUpdate hMIListDataUpdate) {
        try {
            ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket = this.this$0.createBucket();
            ASLClientListImpl$DataStrategyWindowing$InternalManipulator aSLClientListImpl$DataStrategyWindowing$InternalManipulator = new ASLClientListImpl$DataStrategyWindowing$InternalManipulator(this, aSLClientListImpl$UpdateBucket);
            hMIListDataUpdate.acceptManipulator(aSLClientListImpl$DataStrategyWindowing$InternalManipulator);
            aSLClientListImpl$UpdateBucket.commit();
            HMIListDataUpdate hMIListDataUpdate2 = aSLClientListImpl$UpdateBucket.getUpdate();
            return hMIListDataUpdate2;
        }
        finally {
            hMIListDataUpdate.release();
        }
    }

    @Override
    void fillItems(int n, Object[] objectArray) {
        if (n < this.size) {
            int n2 = Math.min(this.size - n, objectArray.length);
            boolean bl = this.cache.getListItems(n, objectArray, n2, HMIList.ITEM_NOT_LOADED);
            if (n2 < objectArray.length) {
                Arrays.fill(objectArray, n2, objectArray.length, null);
            }
            if (bl) {
                int n3 = this.addInvalids(n, objectArray, n2);
                this.fetchHandler.fetchAt(n3);
            }
        } else {
            Arrays.fill(objectArray, null);
        }
    }

    private int addInvalids(int n, Object[] objectArray, int n2) {
        int n3;
        for (n3 = 0; n3 < n2 && objectArray[n3] != HMIList.ITEM_NOT_LOADED; ++n3) {
        }
        if (n3 < n2) {
            for (int i2 = n2 - 1; i2 > n3 && objectArray[i2] != HMIList.ITEM_NOT_LOADED; --i2) {
            }
            this.fetchHandler.addInvalidRange(n3 += n, i2 += n);
        } else {
            n3 = -1;
        }
        return n3;
    }

    @Override
    Object getItem(int n) {
        return this.cache.getListItem(n, null);
    }

    @Override
    void disableFetching() {
        this.fetchHandler.clearInvalids();
        Object[] objectArray = new Object[this.size];
        this.cache.getListItems(0, objectArray, this.size, HMIList.ITEM_NOT_LOADED);
        this.cache.clear();
        ASLClientListImpl aSLClientListImpl = this.this$0;
        super.getClass();
        ASLClientListImpl$DataStrategyAllAtOnce aSLClientListImpl$DataStrategyAllAtOnce = new ASLClientListImpl$DataStrategyAllAtOnce(aSLClientListImpl);
        aSLClientListImpl$DataStrategyAllAtOnce.setContent(objectArray);
        this.this$0.setDataStrategy(aSLClientListImpl$DataStrategyAllAtOnce);
    }

    @Override
    void enableFetching(ASLClientListFetcher aSLClientListFetcher, int n, int n2) {
        LogMessage logMessage = this.this$0.getServices().getLogger().warn();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", "enableFetching", true);
            logMessage.append("fetching already enabled, this may lead to unexpected results");
            LogUtil.appendListConfig(logMessage, this.this$0, true).log();
        }
    }

    @Override
    public int getListSize() {
        return this.size;
    }

    void executeSetFocus(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket, int n) {
        if (n != -1 || n != this.getFocusIndex()) {
            this.this$0.focusIndex = n;
            if (!this.sizeChangePending) {
                aSLClientListImpl$UpdateBucket.setFocus(n);
            }
        }
    }

    void executeSetState(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket, int n) {
        this.this$0.state = n;
        aSLClientListImpl$UpdateBucket.setState(n);
    }

    void executeSetStringIndex(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket, StringIndex stringIndex) {
        this.this$0.stringIndex = stringIndex;
        aSLClientListImpl$UpdateBucket.setStringIndex(stringIndex);
    }

    void executeClear(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket) {
        this.executeSetSize(aSLClientListImpl$UpdateBucket, 0);
    }

    void executeRefresh(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket, int n, int n2) {
        this.this$0.traceListRange("refetch", n, n2);
        this.fetchHandler.addInvalidRange(n, n + n2 - 1);
        aSLClientListImpl$UpdateBucket.refresh(n, n2);
    }

    void executeSetContent(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket, Object[] objectArray) {
        if (0 == objectArray.length) {
            this.executeClear(aSLClientListImpl$UpdateBucket);
        } else {
            this.size = objectArray.length;
            this.cache.clear();
            this.cache.setListSize(this.size);
            this.cache.updateListItems(0, objectArray, this.size);
            this.fetchHandler.clearInvalids();
            aSLClientListImpl$UpdateBucket.setContent(objectArray);
            this.handlePendingSizeChange(aSLClientListImpl$UpdateBucket);
        }
    }

    private boolean handlePendingSizeChange(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket) {
        boolean bl = this.sizeChangePending;
        if (bl) {
            this.sizeChangePending = false;
            this.this$0.traceListSize("setSize{completed}", this.size);
            aSLClientListImpl$UpdateBucket.setSize(this.size);
            if (-1 != this.this$0.focusIndex) {
                LogMessage logMessage = this.this$0.getServices().getLogger().trace();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", "setSize", true);
                    logMessage.append("implicitly setting focusIndex");
                    LogUtil.appendIntProperty(logMessage, "focusIndex", this.this$0.focusIndex, true);
                    LogUtil.appendListConfig(logMessage, this.this$0, true).log();
                }
                aSLClientListImpl$UpdateBucket.setFocus(this.this$0.focusIndex);
            }
        }
        return bl;
    }

    void executeSetSize(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket, int n) {
        int n2 = this.size;
        if (n == n2) {
            this.this$0.traceListSize("setSize{ignored}", n);
        } else {
            this.size = n;
            this.cache.setListSize(n);
            if (0 == n) {
                this.fetchHandler.clearInvalidRange(0, n2 - 1);
            } else if (n2 > n) {
                this.fetchHandler.clearInvalidRange(n, n2 - 1);
            } else {
                this.fetchHandler.addInvalidRange(n2, n - 1);
            }
            if (0 == n && -1 != this.this$0.focusIndex) {
                LogMessage logMessage = this.this$0.getServices().getLogger().trace();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", "setSize", true);
                    logMessage.append("implicitly invalidating focusIndex");
                    LogUtil.appendListConfig(logMessage, this.this$0, true).log();
                }
                this.this$0.focusIndex = -1;
                aSLClientListImpl$UpdateBucket.setFocus(-1);
            }
            boolean bl = this.sizeChangePending = 0 == n2 && !this.sizeChangePending && !this.lazyFetching;
            if (this.sizeChangePending) {
                this.this$0.traceListSize("setSize{postponed}", this.size);
                this.fetchHandler.initialFetch(this.size);
            } else {
                this.this$0.traceListSize("setSize{directly}", this.size);
                if (0 == this.size) {
                    aSLClientListImpl$UpdateBucket.clear();
                } else {
                    aSLClientListImpl$UpdateBucket.setSize(this.size);
                    if (n2 > this.size) {
                        this.fetchHandler.fetch(null);
                    }
                }
            }
        }
    }

    void executeUpdate(ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket, int n, Object[] objectArray) {
        int n2 = n;
        int n3 = n2 + objectArray.length - 1;
        int n4 = this.size;
        if (n3 >= n4) {
            this.size = n3 + 1;
        }
        this.cache.updateListItems(n, objectArray, objectArray.length);
        this.fetchHandler.clearInvalidRange(n2, n3);
        if (0 < objectArray.length) {
            aSLClientListImpl$UpdateBucket.update(n, objectArray);
        } else if (n4 != this.size) {
            aSLClientListImpl$UpdateBucket.setSize(this.size);
        }
        this.handlePendingSizeChange(aSLClientListImpl$UpdateBucket);
        this.fetchHandler.fetch(null);
    }
}

