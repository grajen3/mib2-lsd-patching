/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategy;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategyWindowing;
import de.vw.mib.asl.clientapi.list.impl.LogUtil;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.StringIndex;
import de.vw.mib.log4mib.LogMessage;
import java.lang.reflect.Array;
import java.util.Arrays;

class ASLClientListImpl$DataStrategyAllAtOnce
extends ASLClientListImpl$DataStrategy
implements HMIListDataManipulator {
    private Object[] content;
    private final /* synthetic */ ASLClientListImpl this$0;

    ASLClientListImpl$DataStrategyAllAtOnce(ASLClientListImpl aSLClientListImpl) {
        this.this$0 = aSLClientListImpl;
        super(aSLClientListImpl);
        this.content = ASLClientListImpl.EMPTY_ARRAY;
    }

    @Override
    HMIListDataUpdate execute(HMIListDataUpdate hMIListDataUpdate) {
        hMIListDataUpdate.acceptManipulator(this);
        return hMIListDataUpdate;
    }

    @Override
    void fetchTimedOut() {
    }

    @Override
    void disableFetching() {
        LogMessage logMessage = this.this$0.getServices().getLogger().warn();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLClientListImpl", "disableFetching", true);
            logMessage.append("fetching already disabled");
            LogUtil.appendListConfig(logMessage, this.this$0, true).log();
        }
    }

    @Override
    void enableFetching(ASLClientListFetcher aSLClientListFetcher, int n, int n2) {
        ASLClientListImpl aSLClientListImpl = this.this$0;
        super.getClass();
        this.this$0.setDataStrategy(new ASLClientListImpl$DataStrategyWindowing(aSLClientListImpl, aSLClientListFetcher, n, n2));
    }

    final ASLClientListImpl$DataStrategyAllAtOnce init() {
        this.content = ASLClientListImpl.EMPTY_ARRAY;
        return this;
    }

    @Override
    void fillItems(int n, Object[] objectArray) {
        if (0 > n) {
            throw new IllegalArgumentException(new StringBuffer().append("index=").append(n).toString());
        }
        if (null == objectArray) {
            throw new NullPointerException("buf");
        }
        int n2 = Math.min(this.content.length - n, objectArray.length);
        if (0 < n2) {
            System.arraycopy((Object)this.content, n, (Object)objectArray, 0, n2);
        }
        if (n2 < objectArray.length) {
            Arrays.fill(objectArray, Math.max(0, n2), objectArray.length, null);
        }
    }

    @Override
    Object getItem(int n) {
        Object[] objectArray = this.content;
        return 0 <= n && n < objectArray.length ? objectArray[n] : null;
    }

    @Override
    public int getListSize() {
        return this.content.length;
    }

    @Override
    public void setFocus(int n) {
        this.this$0.focusIndex = n;
    }

    @Override
    public void setState(int n) {
        this.this$0.state = n;
    }

    @Override
    public void setStringIndex(StringIndex stringIndex) {
        this.this$0.stringIndex = stringIndex;
    }

    @Override
    public void clear() {
        if (ASLClientListImpl.EMPTY_ARRAY != this.content) {
            this.content = (Object[])Array.newInstance(super.getClass().getComponentType(), 0);
        }
    }

    @Override
    public void refresh(int n, int n2) {
    }

    @Override
    public void setContent(Object[] objectArray) {
        if (null == objectArray) {
            throw new NullPointerException("items");
        }
        this.content = objectArray;
    }

    @Override
    public void setSize(int n) {
        if (0 > n) {
            throw new IllegalArgumentException(new StringBuffer().append("size=").append(n).toString());
        }
        if (0 == n) {
            this.clear();
        } else if (n != this.content.length) {
            Object[] objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
            System.arraycopy((Object)this.content, 0, (Object)objectArray, 0, Math.min(n, this.content.length));
            if (this.content.length < n) {
                Arrays.fill(objectArray, this.content.length, n, HMIList.ITEM_NOT_LOADED);
            }
            this.content = objectArray;
        }
    }

    @Override
    public void update(int n, Object[] objectArray) {
        if (0 > n) {
            throw new IllegalArgumentException(new StringBuffer().append("index=").append(n).toString());
        }
        if (null == objectArray) {
            throw new NullPointerException("items");
        }
        int n2 = n + objectArray.length;
        if (this.content.length < n2) {
            Object[] objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), n2);
            System.arraycopy((Object)this.content, 0, (Object)objectArray2, 0, this.content.length);
            if (n > this.content.length) {
                Arrays.fill(objectArray2, this.content.length, n2, HMIList.ITEM_NOT_LOADED);
            }
            this.content = objectArray2;
        }
        System.arraycopy((Object)objectArray, 0, (Object)this.content, n, objectArray.length);
    }
}

