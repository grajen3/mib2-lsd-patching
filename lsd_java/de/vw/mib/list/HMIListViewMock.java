/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListView;
import de.vw.mib.list.StringIndex;

public class HMIListViewMock
implements HMIListView {
    @Override
    public int getFocusIndex() {
        return 0;
    }

    @Override
    public int getListSize() {
        return 0;
    }

    @Override
    public int getListState() {
        return 0;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public void forceUnfreeze() {
    }

    @Override
    public void freeze() {
    }

    @Override
    public void unfreeze() {
    }

    @Override
    public boolean isFrozen() {
        return false;
    }

    @Override
    public Object getItem(int n) {
        return null;
    }

    @Override
    public void disableModCount() {
    }

    @Override
    public void enableModCount() {
    }

    @Override
    public int getModCount() {
        return 0;
    }

    @Override
    public void releaseView() {
    }
}

