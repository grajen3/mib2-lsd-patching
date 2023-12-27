/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListViewRanges;
import de.vw.mib.list.impl.AbstractHMIListView;
import de.vw.mib.list.impl.HMIListImpl;
import de.vw.mib.list.impl.Pools;
import java.util.Arrays;

class HMIListWindowView
extends AbstractHMIListView {
    private static final int NUM_PAGES = Integer.getInteger("de.vw.mib.list.numPages", 4);
    private static final int NUM_PAGES_HALF = NUM_PAGES / 2;
    private static final int NUM_VISIBLE_PAGES = Integer.getInteger("de.vw.mib.list.numVisiblePages", 2);
    private static final int NUM_PRELOAD_PAGES = NUM_PAGES - NUM_VISIBLE_PAGES >> 1;
    private final int pageSize;
    private int lastListSize;
    private Object[][] pages;
    private boolean pagesInitialized;
    private int firstPage;
    private int lastQueriedIndex;

    HMIListWindowView(HMIListImpl hMIListImpl, HMIListObserver hMIListObserver, int n, int n2) {
        super(hMIListImpl, hMIListObserver, n);
        this.pageSize = n2;
        this.pages = new Object[NUM_PAGES][];
        for (int i2 = 0; i2 < NUM_PAGES; ++i2) {
            this.pages[i2] = new Object[n2];
        }
        this.pagesInitialized = false;
    }

    private void initPages(int n) {
        this.firstPage = this.alignFirstPage(Math.max(n - NUM_PRELOAD_PAGES, 0));
        this.loadListPages(0, NUM_PAGES - 1, n - this.firstPage, false);
        this.pagesInitialized = true;
    }

    private int alignFirstPage(int n) {
        int n2 = (this.getSize() + this.pageSize - 1) / this.pageSize;
        n = Math.min(n, n2 - NUM_PAGES);
        return Math.max(n, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadListPages(int n, int n2, int n3, boolean bl) {
        if ((n = Math.max(n, 0)) <= (n2 = Math.min(n2, NUM_PAGES - 1))) {
            Object[] objectArray = bl ? Pools.borrowObjectArray(this.pageSize) : null;
            try {
                if (n <= n3 && n3 <= n2) {
                    this.loadListPage(n3, objectArray);
                }
                int n4 = NUM_PAGES_HALF;
                int n5 = n4 - 1;
                if ((NUM_PAGES & 1) != 0) {
                    if (n <= n4 && n4 <= n2 && n4 != n3) {
                        this.loadListPage(n4, objectArray);
                    }
                    ++n4;
                }
                while (n <= n5 || n4 <= n2) {
                    if (n <= n5 && n5 <= n2 && n5 != n3) {
                        this.loadListPage(n5, objectArray);
                    }
                    if (n <= n4 && n4 <= n2 && n4 != n3) {
                        this.loadListPage(n4, objectArray);
                    }
                    --n5;
                    ++n4;
                }
            }
            finally {
                Pools.releaseObjectArray(objectArray);
            }
        }
    }

    private void loadListPage(int n, Object[] objectArray) {
        Object[] objectArray2 = this.pages[n];
        if (null != objectArray) {
            this.list.fillItems((this.firstPage + n) * this.pageSize, objectArray);
            HMIListWindowView.merge(objectArray, objectArray2);
        } else {
            this.list.fillItems((this.firstPage + n) * this.pageSize, objectArray2);
        }
    }

    private static void merge(Object[] objectArray, Object[] objectArray2) {
        for (int i2 = 0; i2 < objectArray2.length; ++i2) {
            Object object = objectArray[i2];
            if (null == object || HMIList.ITEM_NOT_LOADED == object) continue;
            objectArray2[i2] = object;
        }
    }

    @Override
    protected Object getViewItem(int n) {
        Object object;
        if (0 <= n && n < this.getSize()) {
            int n2;
            this.lastQueriedIndex = n;
            int n3 = n / this.pageSize;
            if (!this.pagesInitialized) {
                this.initPages(n3);
            }
            if (null == (object = this.pages[n2 = this.shiftWindow(n3)][n % this.pageSize])) {
                object = HMIList.ITEM_NOT_LOADED;
            }
        } else {
            object = null;
        }
        return object;
    }

    @Override
    protected void fillViewRanges(HMIListViewRanges hMIListViewRanges) {
        int n = this.getListSize() - 1;
        if (0 <= n) {
            int n2 = Math.max(this.lastQueriedIndex / this.pageSize, 0);
            int n3 = n2 * this.pageSize;
            int n4 = Math.min(this.firstPage * this.pageSize, n);
            int n5 = Math.min((this.firstPage + NUM_PAGES) * this.pageSize - 1, n);
            int n6 = Math.min(this.getFirstVisiblePage(n2) * this.pageSize, n);
            int n7 = Math.min((this.getLastVisiblePage(n2) + 1) * this.pageSize - 1, n);
            hMIListViewRanges.addMostRecentViewRange(n3, Math.min(n3 + this.pageSize - 1, n));
            hMIListViewRanges.addVisibleViewRange(n6, n7);
            hMIListViewRanges.addPrefetchViewRange(n4, n5);
        }
    }

    private int getFirstVisiblePage(int n) {
        return Math.min(this.firstPage + NUM_PRELOAD_PAGES, n);
    }

    private int getLastVisiblePage(int n) {
        return Math.max(this.firstPage + NUM_PRELOAD_PAGES + NUM_VISIBLE_PAGES - 1, n);
    }

    private int shiftWindow(int n) {
        int n2 = n - this.firstPage;
        if (n2 < NUM_PRELOAD_PAGES) {
            int n3 = NUM_PRELOAD_PAGES - n2;
            if (0 < (n3 = Math.min(n3, this.firstPage))) {
                this.shiftWindowUp(n3);
                int n4 = Math.min(n3, NUM_PAGES);
                n2 = n - this.firstPage;
                this.traceWindowPosition();
                this.loadListPages(0, n4 - 1, n2, false);
            }
        } else if (n2 > NUM_PAGES - NUM_PRELOAD_PAGES - 1) {
            int n5 = n2 - (NUM_PAGES - 1) + NUM_PRELOAD_PAGES;
            int n6 = Math.max(this.getSize() - 1, 0) / this.pageSize;
            if (0 < (n5 = Math.min(n5, n6 - (this.firstPage + NUM_PAGES - 1)))) {
                this.shiftWindowDown(n5);
                int n7 = Math.min(n5, NUM_PAGES);
                n2 = n - this.firstPage;
                this.traceWindowPosition();
                this.loadListPages(NUM_PAGES - n7, NUM_PAGES - 1, n2, false);
            }
        }
        return n2;
    }

    private void shiftWindowUp(int n) {
        if (0 < n && n < NUM_PAGES) {
            Object[][] objectArrayArray = new Object[NUM_PAGES][];
            System.arraycopy(this.pages, 0, objectArrayArray, n, NUM_PAGES - n);
            System.arraycopy(this.pages, NUM_PAGES - n, objectArrayArray, 0, n);
            this.pages = objectArrayArray;
        }
        this.firstPage -= n;
    }

    private void shiftWindowDown(int n) {
        if (0 < n && n < NUM_PAGES) {
            Object[][] objectArrayArray = new Object[NUM_PAGES][];
            System.arraycopy(this.pages, n, objectArrayArray, 0, NUM_PAGES - n);
            System.arraycopy(this.pages, 0, objectArrayArray, NUM_PAGES - n, n);
            this.pages = objectArrayArray;
        }
        this.firstPage += n;
    }

    @Override
    protected void executeClear() {
        this.executeSetSize(0);
    }

    @Override
    protected void executeRefresh(int n, int n2) {
        int n3 = n / this.pageSize - this.firstPage;
        int n4 = (n + n2 - 1) / this.pageSize - this.firstPage;
        if (n3 < NUM_PAGES && n4 >= 0) {
            this.loadListPages(n3, n4, this.lastQueriedIndex / this.pageSize - this.firstPage, true);
        }
    }

    @Override
    protected void executeSetContent(Object[] objectArray) {
        Object[] objectArray2;
        int n;
        if (null == objectArray) {
            throw new IllegalArgumentException("items");
        }
        this.lastQueriedIndex = Math.max(0, objectArray.length - 1);
        this.setSize(objectArray.length);
        if (objectArray.length < this.lastListSize) {
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

    @Override
    protected void executeSetSize(int n) {
        this.setSize(n);
        this.lastQueriedIndex = Math.max(0, n - 1);
        if (0 == n) {
            if (this.pagesInitialized) {
                for (int i2 = 0; i2 < NUM_PAGES; ++i2) {
                    Arrays.fill(this.pages[i2], null);
                }
                this.pagesInitialized = false;
            }
        } else if (!this.pagesInitialized) {
            this.initPages(this.lastQueriedIndex / this.pageSize);
        } else if (n < this.lastListSize) {
            int n2;
            int n3;
            int n4 = this.alignFirstPage(this.firstPage);
            if (n4 < this.firstPage) {
                n3 = this.firstPage - n4;
                this.shiftWindowUp(n3);
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
    protected void executeUpdate(int n, Object[] objectArray) {
        int n2;
        int n3;
        int n4 = this.getSize();
        if (n4 < n + objectArray.length) {
            n4 = n + objectArray.length;
            this.setSize(n4);
        }
        if (!this.pagesInitialized) {
            this.initPages(this.lastQueriedIndex / this.pageSize);
        }
        if ((n3 = (n2 = n / this.pageSize) - this.firstPage) < NUM_PAGES) {
            int n5;
            int n6 = 0;
            if (n3 < 0) {
                n5 = this.firstPage * this.pageSize;
                n6 = n5 - n;
                n = n5;
                n3 = 0;
            }
            n5 = n % this.pageSize;
            while (n6 < objectArray.length && n3 < NUM_PAGES) {
                Object[] objectArray2 = this.pages[n3];
                int n7 = Math.min(this.pageSize - n5, objectArray.length - n6);
                System.arraycopy((Object)objectArray, n6, (Object)objectArray2, n5, n7);
                n6 += n7;
                ++n3;
                n5 = 0;
            }
        }
        this.lastListSize = n4;
    }

    private void traceWindowPosition() {
    }
}

