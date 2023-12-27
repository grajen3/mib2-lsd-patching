/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.impl.AbstractHMIListView;

class AbstractHMIListView$InternalDataManipulator
implements HMIListDataManipulator {
    private final /* synthetic */ AbstractHMIListView this$0;

    AbstractHMIListView$InternalDataManipulator(AbstractHMIListView abstractHMIListView) {
        this.this$0 = abstractHMIListView;
    }

    @Override
    public void clear() {
        this.this$0.checkModCount(0);
        this.this$0.executeClear();
    }

    @Override
    public void refresh(int n, int n2) {
        this.this$0.executeRefresh(n, n2);
    }

    @Override
    public void setContent(Object[] objectArray) {
        this.this$0.checkModCount(0);
        this.this$0.executeSetContent(objectArray);
    }

    @Override
    public void setFocus(int n) {
        this.this$0.executeSetFocus(n);
    }

    @Override
    public void setSize(int n) {
        this.this$0.checkModCount(n);
        this.this$0.executeSetSize(n);
    }

    @Override
    public void setState(int n) {
        this.this$0.executeSetState(n);
    }

    @Override
    public void setStringIndex(StringIndex stringIndex) {
        this.this$0.executeSetStringIndex(stringIndex);
    }

    @Override
    public void update(int n, Object[] objectArray) {
        this.this$0.checkModCount(n, objectArray.length);
        this.this$0.executeUpdate(n, objectArray);
    }
}

