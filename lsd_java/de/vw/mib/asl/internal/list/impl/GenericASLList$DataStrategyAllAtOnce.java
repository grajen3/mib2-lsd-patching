/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.AbstractASLList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.list.impl.GenericASLList$DataStrategy;
import de.vw.mib.asl.internal.list.impl.GenericASLList$DataStrategyWindowing;
import de.vw.mib.asl.internal.list.impl.LogUtil;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;

class GenericASLList$DataStrategyAllAtOnce
implements GenericASLList$DataStrategy {
    private Object[] listItems;
    private final /* synthetic */ GenericASLList this$0;

    GenericASLList$DataStrategyAllAtOnce(GenericASLList genericASLList) {
        this.this$0 = genericASLList;
        this.init();
    }

    final GenericASLList$DataStrategyAllAtOnce init() {
        this.listItems = AbstractASLList.EMPTY_ARRAY;
        this.this$0.listSize = 0;
        return this;
    }

    @Override
    public void disableWindowing() {
        LogMessage logMessage = this.this$0.warn();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "disableWindowing", true);
            logMessage.append("windowing already disabled");
            LogUtil.appendListConfig(logMessage, this.this$0, true).log();
        }
    }

    @Override
    public void enableWindowing(ASLListElementCache aSLListElementCache, ASLListElementFetcher aSLListElementFetcher, int n, int n2) {
        GenericASLList genericASLList = this.this$0;
        super.getClass();
        this.this$0.setDataStrategy(new GenericASLList$DataStrategyWindowing(genericASLList, aSLListElementCache, aSLListElementFetcher, n, n2));
    }

    @Override
    public boolean isWindowingEnabled() {
        return false;
    }

    @Override
    public int getItemCount() {
        return this.listItems.length;
    }

    @Override
    public Object[] getAllItems() {
        return this.listItems;
    }

    @Override
    public void getLoadedListItems(int n, Object[] objectArray) {
        this.getItems(n, objectArray);
    }

    @Override
    public void getItems(int n, Object[] objectArray) {
        Object[] objectArray2 = this.listItems;
        int n2 = Math.min(objectArray2.length - n, objectArray.length);
        if (0 < n2) {
            System.arraycopy((Object)objectArray2, n, (Object)objectArray, 0, n2);
        }
        if (n2 < objectArray.length) {
            n2 = Math.max(0, n2);
            Arrays.fill(objectArray, n2, objectArray.length, null);
        }
    }

    @Override
    public Object getListItemByIdCacheOnly(long l) {
        Object object = null;
        if (this.this$0.isObjectIdColumnSet()) {
            Object[] objectArray = this.listItems;
            int n = 0;
            while (null == object && n < objectArray.length) {
                Object object2;
                if (this.this$0.getObjectId(object2 = objectArray[n++]) != l) continue;
                object = object2;
            }
        }
        return object;
    }

    @Override
    public Object getRowItem(int n) {
        Object object;
        Object[] objectArray = this.listItems;
        int n2 = objectArray.length;
        if ((0 > n || n >= n2) && null != (object = this.this$0.warn())) {
            LogUtil.appendPrefixAndMethod((LogMessage)object, "GenericASLList", "getRowItem", true).append("index out of range - ");
            LogUtil.appendIndex((LogMessage)object, n, false);
            LogUtil.appendSize((LogMessage)object, n2, true);
            LogUtil.appendListConfig((LogMessage)object, this.this$0, true).log();
        }
        object = objectArray[n];
        this.this$0.addPublicIndex(n);
        return object;
    }

    @Override
    public Object getRowItemCacheOnly(int n) {
        Object[] objectArray = this.listItems;
        return 0 <= n && n < objectArray.length ? objectArray[n] : null;
    }

    @Override
    public void updateList(Object[] objectArray) {
        int n = this.listItems.length;
        this.listItems = objectArray;
        this.this$0.listSize = objectArray.length;
        if (objectArray.length != n) {
            if (0 == objectArray.length && -1 != this.this$0.activatedIndex) {
                LogMessage logMessage = this.this$0.trace();
                if (null != logMessage) {
                    LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "setSize", true);
                    logMessage.append("implicitly invalidating activeIndex");
                    LogUtil.appendListConfig(logMessage, this.this$0, true).log();
                }
                this.this$0.activatedIndex = -1;
                this.this$0.sendNotification(5, -1, -1);
            }
            this.this$0.sendNotification(1, -1, -1);
        } else {
            this.this$0.sendNotification(0, -1, -1);
        }
    }

    @Override
    public void setSize(int n) {
        if (0 != n) {
            this.errorNoWindowing("setSize");
        } else if (0 != this.this$0.listSize) {
            this.updateList(AbstractASLList.EMPTY_ARRAY);
        }
    }

    @Override
    public void setSizeClearCache(int n) {
        this.errorNoWindowing("setSizeClearCache");
    }

    @Override
    public void updateListItems(int n, Object[] objectArray) {
        LogMessage logMessage;
        int n2 = Math.max(0, -n);
        int n3 = Math.min(objectArray.length, this.listItems.length - n) - n2;
        if ((0 < n2 || n3 < objectArray.length) && null != (logMessage = this.this$0.warn())) {
            LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", "updateListItems", true);
            logMessage.append("updated range exceeds list, ");
            if (0 < n3) {
                logMessage.append("some");
            } else {
                logMessage.append("all");
            }
            logMessage.append(" items are ignored - ");
            LogUtil.appendRange(logMessage, n, objectArray.length, false);
            LogUtil.appendSize(logMessage, this.this$0.listSize, true);
            LogUtil.appendListConfig(logMessage, this.this$0, true).log();
        }
        if (0 < n3) {
            System.arraycopy((Object)objectArray, n2, (Object)this.listItems, n, n3);
            this.this$0.sendNotification(2, n, n3);
        }
    }

    @Override
    public void insertListItems(int n, Object[] objectArray) {
        this.errorNoWindowing("insertListItems");
    }

    @Override
    public void removeListItems(int n, int n2) {
        this.errorNoWindowing("removeListItems");
    }

    @Override
    public void refetch(int n, int n2) {
        this.errorNoWindowing("refetch");
    }

    @Override
    public void notifyExecutingQueueFinished() {
    }

    @Override
    public StringBuffer append(StringBuffer stringBuffer) {
        return stringBuffer.append("type=all_at_once");
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("type=all_at_once");
    }

    private void errorNoWindowing(String string) {
        LogMessage logMessage = this.this$0.error();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "GenericASLList", string, true).append("only allowed if windowing is enabled");
            LogUtil.appendListConfig(logMessage, this.this$0, true).log();
        }
    }
}

