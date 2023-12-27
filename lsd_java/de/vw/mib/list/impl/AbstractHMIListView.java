/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.Coverage;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataUpdate;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListView;
import de.vw.mib.list.HMIListViewRanges;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.impl.AbstractHMIListView$InternalDataManipulator;
import de.vw.mib.list.impl.CoverageImpl;
import de.vw.mib.list.impl.HMIListImpl;

abstract class AbstractHMIListView
implements HMIListView,
HMIListDataObserver {
    protected final HMIListImpl list;
    private final Object semaphore;
    private final HMIListObserver observer;
    private final HMIListDataManipulator manipulator = new AbstractHMIListView$InternalDataManipulator(this);
    private boolean released;
    private int freezeCnt;
    private HMIListDataUpdate pendingUpdate;
    private int modCount;
    private boolean ignoreModCountOnDummy;
    private Coverage publicItems;
    private int focus;
    private int size;
    private int state;
    private StringIndex stringIndex;

    protected AbstractHMIListView(HMIListImpl hMIListImpl, HMIListObserver hMIListObserver, int n) {
        this.list = hMIListImpl;
        this.semaphore = hMIListImpl.getSemaphore();
        this.observer = hMIListObserver;
        this.focus = hMIListImpl.getFocusIndex();
        this.size = hMIListImpl.getListSize();
        this.state = hMIListImpl.getListState();
        this.stringIndex = hMIListImpl.getStringIndex();
        this.ignoreModCountOnDummy = 0 != (n & 1);
    }

    @Override
    public int getFocusIndex() {
        this.checkReleaseState();
        return this.focus;
    }

    @Override
    public int getListSize() {
        this.checkReleaseState();
        return this.size;
    }

    protected int getSize() {
        return this.size;
    }

    protected void setSize(int n) {
        this.size = n;
    }

    @Override
    public int getListState() {
        this.checkReleaseState();
        return this.state;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void forceUnfreeze() {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            if (0 < this.freezeCnt) {
                this.onViewUnfreeze();
            }
            this.freezeCnt = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void freeze() {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            ++this.freezeCnt;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unfreeze() {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            if (0 >= this.freezeCnt) {
                this.freezeCnt = 0;
            } else if (0 == --this.freezeCnt) {
                this.onViewUnfreeze();
            }
        }
    }

    private void onViewUnfreeze() {
        while (null != this.pendingUpdate) {
            HMIListDataUpdate hMIListDataUpdate = this.pendingUpdate;
            this.pendingUpdate = null;
            this.execute(hMIListDataUpdate);
            hMIListDataUpdate.release();
        }
    }

    @Override
    public boolean isFrozen() {
        this.checkReleaseState();
        return 0 < this.freezeCnt;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object getItem(int n) {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            Object object2 = this.getViewItem(n);
            if (!(null == object2 || this.ignoreModCountOnDummy && HMIList.ITEM_NOT_LOADED == object2)) {
                this.addPublicIndex(n);
            }
            return object2;
        }
    }

    protected abstract Object getViewItem(int n) {
    }

    protected abstract void fillViewRanges(HMIListViewRanges hMIListViewRanges) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public StringIndex getStringIndex() {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            return this.stringIndex;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releaseView() {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            this.released = true;
            this.list.releaseListView(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void disableModCount() {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            if (null != this.publicItems) {
                this.publicItems.clear();
                this.publicItems = null;
            }
            this.modCount = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enableModCount() {
        Object object = this.semaphore;
        synchronized (object) {
            this.checkReleaseState();
            if (null == this.publicItems) {
                this.publicItems = CoverageImpl.create(true);
            }
        }
    }

    @Override
    public int getModCount() {
        return this.modCount;
    }

    protected void addPublicIndex(int n) {
        if (null != this.publicItems) {
            this.publicItems.addRange(n, n);
        }
    }

    void incModCount() {
        ++this.modCount;
    }

    void checkModCount(int n) {
        if (null != this.publicItems) {
            boolean bl;
            if (0 < n) {
                bl = this.publicItems.intersects(n, -129);
            } else {
                boolean bl2 = bl = !this.publicItems.isEmpty();
            }
            if (bl) {
                this.publicItems.clear();
                this.incModCount();
            }
        }
    }

    void checkModCount(int n, int n2) {
        boolean bl;
        if (null != this.publicItems && (bl = this.publicItems.intersects(n, n + n2 - 1))) {
            this.publicItems.clear();
            this.incModCount();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onUpdate(HMIListDataUpdate hMIListDataUpdate) {
        Object object = this.semaphore;
        synchronized (object) {
            if (this.isFrozen()) {
                this.enqueue(hMIListDataUpdate);
            } else {
                this.execute(hMIListDataUpdate);
                hMIListDataUpdate.release();
            }
        }
    }

    void enqueue(HMIListDataUpdate hMIListDataUpdate) {
        if (null == this.pendingUpdate) {
            this.pendingUpdate = hMIListDataUpdate;
        } else {
            HMIListDataUpdate hMIListDataUpdate2 = this.pendingUpdate.merge(hMIListDataUpdate);
            hMIListDataUpdate.release();
            this.pendingUpdate.release();
            this.pendingUpdate = hMIListDataUpdate2;
        }
    }

    void execute(HMIListDataUpdate hMIListDataUpdate) {
        hMIListDataUpdate.acceptManipulator(this.manipulator);
        hMIListDataUpdate.acceptObserver(this.observer);
    }

    protected abstract void executeClear() {
    }

    protected abstract void executeRefresh(int n, int n2) {
    }

    protected abstract void executeSetContent(Object[] objectArray) {
    }

    void executeSetFocus(int n) {
        this.focus = n;
    }

    protected abstract void executeSetSize(int n) {
    }

    void executeSetState(int n) {
        this.state = n;
    }

    void executeSetStringIndex(StringIndex stringIndex) {
        this.stringIndex = stringIndex;
    }

    protected abstract void executeUpdate(int n, Object[] objectArray) {
    }

    private void checkReleaseState() {
        if (this.released) {
            throw new IllegalStateException("HMIListView already released");
        }
    }
}

