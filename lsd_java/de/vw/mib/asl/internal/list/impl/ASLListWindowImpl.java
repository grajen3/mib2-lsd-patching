/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListElementCache;
import de.vw.mib.asl.internal.list.ASLListWindow;
import de.vw.mib.asl.internal.list.impl.LogUtil;
import de.vw.mib.asl.internal.list.impl.Services;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.log4mib.LogMessage;
import java.util.Arrays;

final class ASLListWindowImpl
implements ASLListWindow {
    private static final String LOG_PREFIX;
    private static final int NUM_PAGES;
    private static final int NUM_VISIBLE_PAGES;
    private static final int NUM_PRELOAD_PAGES;
    private final Services services;
    private final ASLCachedWindowList aslList;
    private final int pageSize;
    private final boolean lazyFetching;
    private Object[][] pages;
    private boolean pagesInitialized;
    private int firstPage;
    private int lastQueriedIndex;
    private int lastListSize;

    ASLListWindowImpl(Services services, ASLCachedWindowList aSLCachedWindowList, int n, boolean bl) {
        this.services = services;
        this.aslList = aSLCachedWindowList;
        this.pageSize = n;
        this.lazyFetching = bl;
        this.pages = new Object[NUM_PAGES][];
        for (int i2 = 0; i2 < NUM_PAGES; ++i2) {
            this.pages[i2] = new Object[n];
        }
        this.pagesInitialized = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initPages(int n) {
        ASLCachedWindowList aSLCachedWindowList = this.aslList;
        synchronized (aSLCachedWindowList) {
            this.firstPage = this.alignFirstPage(Math.max(n - NUM_PRELOAD_PAGES, 0));
            this.loadListPages(0, NUM_PAGES - 1, n - this.firstPage, false);
            this.pagesInitialized = true;
        }
    }

    @Override
    public Object getListItem(int n) {
        int n2 = this.getListSize();
        if (n >= 0 && n < n2) {
            this.lastQueriedIndex = n;
            if (!this.pagesInitialized) {
                int n3 = n / this.pageSize;
                this.initPages(n3);
            }
            return this.getListItemFromPages(n);
        }
        LogMessage logMessage = this.services.getASLListLog().warn();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLListWindow", "getListItem", true).append("index out of range - ");
            LogUtil.appendIndex(logMessage, n, false);
            LogUtil.appendSize(logMessage, n2, true);
            LogUtil.appendListConfig(logMessage, this.aslList, true).log();
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Object getListItemFromPages(int n) {
        if (n < 0 || n >= this.getListSize()) {
            return null;
        }
        int n2 = n / this.pageSize;
        int n3 = n2 - this.firstPage;
        Object object = 0 <= n3 && n3 < NUM_PAGES ? this.pages[n3][n % this.pageSize] : null;
        if (n3 < NUM_PRELOAD_PAGES || n3 > NUM_PAGES - NUM_PRELOAD_PAGES - 1) {
            ASLCachedWindowList aSLCachedWindowList = this.aslList;
            synchronized (aSLCachedWindowList) {
                n3 = this.preparePages(n2);
                if (null == object) {
                    object = this.pages[n3][n % this.pageSize];
                }
            }
        }
        if (object == null) {
            object = DynamicListData.ITEM_NOT_LOADED;
        }
        return object;
    }

    private void rollPagesDown(int n) {
        if (0 < n && n < NUM_PAGES) {
            Object[][] objectArrayArray = new Object[NUM_PAGES][];
            System.arraycopy(this.pages, 0, objectArrayArray, n, NUM_PAGES - n);
            System.arraycopy(this.pages, NUM_PAGES - n, objectArrayArray, 0, n);
            this.pages = objectArrayArray;
        }
        this.firstPage -= n;
    }

    private void rollPagesUp(int n) {
        if (0 < n && n < NUM_PAGES) {
            Object[][] objectArrayArray = new Object[NUM_PAGES][];
            System.arraycopy(this.pages, n, objectArrayArray, 0, NUM_PAGES - n);
            System.arraycopy(this.pages, 0, objectArrayArray, NUM_PAGES - n, n);
            this.pages = objectArrayArray;
        }
        this.firstPage += n;
    }

    private void loadListPages(int n, int n2, int n3, boolean bl) {
        if (n <= n2) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = objectArray2 = bl ? new Object[this.pageSize] : null;
            if (0 <= n3 && n3 < NUM_PAGES && n <= n3 && n3 <= n2) {
                objectArray = this.pages[n3];
                this.aslList.getItems((this.firstPage + n3) * this.pageSize, bl ? objectArray2 : objectArray);
                if (bl) {
                    this.merge(objectArray2, objectArray);
                }
            }
            int n4 = NUM_PAGES / 2;
            int n5 = n4 - 1;
            if ((NUM_PAGES & 1) != 0) {
                if (n5 >= n && n5 <= n2 && n5 != n3) {
                    objectArray = this.pages[n5];
                    this.aslList.getItems((this.firstPage + n5) * this.pageSize, bl ? objectArray2 : objectArray);
                    if (bl) {
                        this.merge(objectArray2, objectArray);
                    }
                }
                --n5;
            }
            for (int i2 = 0; i2 < NUM_PAGES / 2; ++i2) {
                if (n5 >= n && n5 <= n2 && n5 != n3) {
                    objectArray = this.pages[n5];
                    this.aslList.getItems((this.firstPage + n5) * this.pageSize, bl ? objectArray2 : objectArray);
                    if (bl) {
                        this.merge(objectArray2, objectArray);
                    }
                }
                if (n4 >= n && n4 <= n2 && n4 != n3) {
                    objectArray = this.pages[n4];
                    this.aslList.getItems((this.firstPage + n4) * this.pageSize, bl ? objectArray2 : objectArray);
                    if (bl) {
                        this.merge(objectArray2, objectArray);
                    }
                }
                --n5;
                ++n4;
            }
        }
    }

    private void merge(Object[] objectArray, Object[] objectArray2) {
        for (int i2 = 0; i2 < objectArray2.length; ++i2) {
            Object object = objectArray[i2];
            if (null == object || DynamicListData.ITEM_NOT_LOADED == object) continue;
            objectArray2[i2] = object;
        }
    }

    private int preparePages(int n) {
        int n2 = n - this.firstPage;
        if (n2 < NUM_PRELOAD_PAGES) {
            int n3 = n2 - NUM_PRELOAD_PAGES;
            if (0 > (n3 = Math.max(n3, -this.firstPage))) {
                this.rollPagesDown(-n3);
                int n4 = Math.min(-n3, NUM_PAGES);
                n2 = n - this.firstPage;
                this.traceWindowPosition();
                this.loadListPages(0, n4 - 1, n2, false);
            }
        } else if (n2 > NUM_PAGES - NUM_PRELOAD_PAGES - 1) {
            int n5 = n2 - (NUM_PAGES - 1) + NUM_PRELOAD_PAGES;
            int n6 = Math.max(this.getListSize() - 1, 0) / this.pageSize;
            if (0 < (n5 = Math.min(n5, n6 - (this.firstPage + NUM_PAGES - 1)))) {
                this.rollPagesUp(n5);
                int n7 = Math.min(n5, NUM_PAGES);
                n2 = n - this.firstPage;
                this.traceWindowPosition();
                this.loadListPages(NUM_PAGES - n7, NUM_PAGES - 1, n2, false);
            }
        }
        return n2;
    }

    private void traceWindowPosition() {
        LogMessage logMessage = this.services.getASLListLog().trace();
        if (null != logMessage) {
            LogUtil.appendPrefixAndMethod(logMessage, "ASLListWindow", "setWindow", true);
            LogUtil.appendRangeProperty(logMessage, "window", this.getFirstListIndex(), this.getLastListIndex(), false);
            LogUtil.appendListConfig(logMessage, this.aslList, true).log();
        }
    }

    @Override
    public void updateListItems(int n, Object[] objectArray) {
        if (this.pagesInitialized || !this.lazyFetching) {
            int n2;
            int n3;
            if (!this.pagesInitialized) {
                this.initPages(this.lastQueriedIndex / this.pageSize);
            }
            if ((n3 = (n2 = n / this.pageSize) - this.firstPage) < NUM_PAGES) {
                int n4;
                int n5 = 0;
                if (n3 < 0) {
                    n4 = this.firstPage * this.pageSize;
                    n5 = n4 - n;
                    n = n4;
                    n3 = 0;
                }
                n4 = n % this.pageSize;
                while (n5 < objectArray.length && n3 < NUM_PAGES) {
                    Object[] objectArray2 = this.pages[n3];
                    int n6 = Math.min(this.pageSize - n4, objectArray.length - n5);
                    System.arraycopy((Object)objectArray, n5, (Object)objectArray2, n4, n6);
                    n5 += n6;
                    ++n3;
                    n4 = 0;
                }
            }
            this.lastListSize = Math.max(this.lastListSize, n + objectArray.length);
        }
    }

    @Override
    public void updateList(Object[] objectArray) {
        if (null == objectArray) {
            throw new IllegalArgumentException("items null");
        }
        if (this.lastQueriedIndex >= objectArray.length) {
            this.lastQueriedIndex = Math.max(0, objectArray.length - 1);
        }
        if (this.pagesInitialized || !this.lazyFetching) {
            Object[] objectArray2;
            int n;
            if (this.lastListSize > objectArray.length) {
                this.firstPage = this.alignFirstPage(this.firstPage);
            }
            int n2 = this.firstPage * this.pageSize;
            for (n = 0; n2 < objectArray.length && n < NUM_PAGES; n2 += this.pageSize, ++n) {
                objectArray2 = this.pages[n];
                int n3 = Math.min(this.pageSize, objectArray.length - n2);
                System.arraycopy((Object)objectArray, n2, (Object)objectArray2, 0, n3);
                if (n3 >= this.pageSize) continue;
                Arrays.fill(objectArray2, n3, this.pageSize, null);
            }
            while (n < NUM_PAGES) {
                objectArray2 = this.pages[n];
                Arrays.fill(objectArray2, null);
                ++n;
            }
            this.pagesInitialized = true;
            this.lastListSize = objectArray.length;
        }
    }

    private int alignFirstPage(int n) {
        int n2 = (this.getListSize() + this.pageSize - 1) / this.pageSize;
        return (n = Math.min(n, n2 - NUM_PAGES)) < 0 ? 0 : n;
    }

    @Override
    public void insertListItems(int n, Object[] objectArray) {
        if (this.pagesInitialized || !this.lazyFetching) {
            if (n < (this.firstPage + NUM_PAGES) * this.pageSize) {
                int n2 = this.lastQueriedIndex / this.pageSize - this.firstPage;
                int n3 = this.firstPage;
                if (n <= this.lastQueriedIndex) {
                    this.lastQueriedIndex += objectArray.length;
                    this.firstPage = this.alignFirstPage(this.lastQueriedIndex / this.pageSize - n2);
                }
                if (!this.pagesInitialized || objectArray.length % this.pageSize != 0 || this.firstPage != n3 || n >= this.firstPage * this.pageSize) {
                    this.loadListPages(0, NUM_PAGES - 1, this.lastQueriedIndex / this.pageSize - this.firstPage, false);
                    this.pagesInitialized = true;
                }
            }
            this.lastListSize += objectArray.length;
        }
    }

    @Override
    public void removeListItems(int n, int n2) {
        if (this.pagesInitialized) {
            if (n < (this.firstPage + NUM_PAGES) * this.pageSize) {
                int n3 = this.lastQueriedIndex / this.pageSize - this.firstPage;
                int n4 = this.firstPage;
                if (n <= this.lastQueriedIndex) {
                    this.lastQueriedIndex = n + n2 < this.lastQueriedIndex ? n - 1 : (this.lastQueriedIndex -= n2);
                    if (this.lastQueriedIndex < 0) {
                        this.lastQueriedIndex = 0;
                    }
                    this.firstPage = this.alignFirstPage(this.lastQueriedIndex / this.pageSize - n3);
                }
                if (n2 % this.pageSize != 0 || this.firstPage != n4 || n >= this.firstPage * this.pageSize) {
                    this.loadListPages(0, NUM_PAGES - 1, this.lastQueriedIndex / this.pageSize - this.firstPage, false);
                }
            }
            this.lastListSize -= n2;
        }
    }

    @Override
    public int getActivatedIndex() {
        return this.aslList.getActivatedIndex();
    }

    @Override
    public void setListSize(int n) {
        if (this.lastQueriedIndex >= n) {
            this.lastQueriedIndex = Math.max(0, n - 1);
        }
        if (0 == n) {
            if (this.pagesInitialized) {
                for (int i2 = 0; i2 < NUM_PAGES; ++i2) {
                    Arrays.fill(this.pages[i2], null);
                }
                this.pagesInitialized = false;
            }
        } else if (!this.pagesInitialized) {
            if (!this.lazyFetching) {
                this.initPages(this.lastQueriedIndex / this.pageSize);
            } else {
                n = 0;
            }
        } else if (n < this.lastListSize) {
            int n2;
            int n3;
            int n4 = this.alignFirstPage(this.firstPage);
            if (n4 < this.firstPage) {
                n3 = this.firstPage - n4;
                this.rollPagesDown(n3);
                n2 = (n - 1) / this.pageSize;
                this.loadListPages(0, Math.min(n3 - 1, n2 - this.firstPage), this.lastQueriedIndex / this.pageSize - this.firstPage, false);
            }
            n3 = Math.max(n / this.pageSize - this.firstPage, 0);
            n2 = n % this.pageSize;
            while (n3 < NUM_PAGES) {
                Arrays.fill(this.pages[n3++], n2, this.pageSize, null);
                n2 = 0;
            }
        } else if (n > this.lastListSize) {
            int n5 = this.lastListSize / this.pageSize - this.firstPage;
            int n6 = (n - 1) / this.pageSize - this.firstPage;
            this.loadListPages(n5, n6, this.lastQueriedIndex / this.pageSize - this.firstPage, false);
        }
        this.lastListSize = n;
    }

    @Override
    public void freeze() {
        this.aslList.freeze();
    }

    @Override
    public void unfreeze() {
        this.aslList.unfreeze();
    }

    @Override
    public boolean isFrozen() {
        return this.aslList.isFrozen();
    }

    @Override
    public int getFirstListIndex() {
        int n = this.getListSize();
        return Math.min(this.firstPage * this.pageSize, n - 1);
    }

    @Override
    public int getLastListIndex() {
        int n = this.getListSize();
        return Math.min((this.firstPage + NUM_PAGES) * this.pageSize - 1, n - 1);
    }

    @Override
    public int getListSize() {
        return this.aslList.getSize();
    }

    @Override
    public void refreshItems(int n, int n2) {
        int n3 = n / this.pageSize - this.firstPage;
        int n4 = (n + n2 - 1) / this.pageSize - this.firstPage;
        if (n3 < NUM_PAGES && n4 >= 0) {
            this.loadListPages(n3, n4, this.lastQueriedIndex / this.pageSize - this.firstPage, true);
        }
    }

    @Override
    public int getLastQueriedIndex() {
        return this.lastQueriedIndex;
    }

    @Override
    public int getFirstVisibleIndex() {
        int n = this.getListSize();
        int n2 = Math.min(this.firstPage + NUM_PRELOAD_PAGES, this.lastQueriedIndex / this.pageSize);
        return Math.min(n2 * this.pageSize, n - 1);
    }

    @Override
    public int getLastVisibleIndex() {
        int n = this.getListSize();
        int n2 = Math.max(this.firstPage + NUM_PRELOAD_PAGES + NUM_VISIBLE_PAGES, this.lastQueriedIndex / this.pageSize);
        return Math.min(n2 * this.pageSize - 1, n - 1);
    }

    @Override
    public boolean isLazyFetching() {
        return this.lazyFetching;
    }

    @Override
    public void storeItems(ASLListElementCache aSLListElementCache) {
        int n = this.getFirstListIndex();
        if (0 <= n) {
            int n2 = this.getLastListIndex() + 1;
            Object[] objectArray = new Object[this.pageSize];
            int n3 = 0;
            while (n < n2) {
                Object[] objectArray2 = this.pages[n3];
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    Object object = objectArray2[i2];
                    if (ASLList.ITEM_NOT_LOADED == object) {
                        object = null;
                    }
                    objectArray[i2] = object;
                }
                aSLListElementCache.updateListItems(n, objectArray, Math.min(this.pageSize, n2 - n));
                ++n3;
                n += this.pageSize;
            }
        }
    }

    protected StringBuffer append(StringBuffer stringBuffer) {
        stringBuffer.append("pageSize=").append(this.pageSize);
        stringBuffer.append(", window=");
        if (!this.pagesInitialized) {
            stringBuffer.append("not_initialized");
        } else {
            int n = this.getFirstListIndex();
            int n2 = this.getLastListIndex();
            stringBuffer.append('[').append(n).append("..").append(n2).append(']');
        }
        stringBuffer.append(", lazyFetching=").append(this.lazyFetching);
        return stringBuffer;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ASLListWindowImpl [");
        logMessage.append("pageSize=").append(this.pageSize);
        logMessage.append(", window=");
        if (!this.pagesInitialized) {
            logMessage.append("not_initialized");
        } else {
            int n = this.getFirstListIndex();
            int n2 = this.getLastListIndex();
            logMessage.append("[").append(n).append("..").append(n2).append("]");
        }
        logMessage.append(", lazyFetching=").append(this.lazyFetching);
        logMessage.append("]");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ASLListWindowImpl [");
        this.append(stringBuffer);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    static {
        NUM_PAGES = Integer.getInteger("de.vw.mib.list.numPages", 4);
        NUM_VISIBLE_PAGES = Integer.getInteger("de.vw.mib.list.numVisiblePages", 2);
        NUM_PRELOAD_PAGES = NUM_PAGES - NUM_VISIBLE_PAGES >> 1;
    }
}

