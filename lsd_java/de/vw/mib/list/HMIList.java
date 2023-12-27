/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListState;
import de.vw.mib.list.HMIListView;
import de.vw.mib.list.HMIListViewRanges;

public interface HMIList
extends HMIListState {
    public static final Object ITEM_NOT_LOADED = DynamicListData.ITEM_NOT_LOADED;
    public static final int VIEW_SETTING_DEFAULTS;
    public static final int VIEW_SETTING_NO_MOD_INC_ON_DUMMY_UPDATE;

    default public HMIListView createListWindowView(HMIListObserver hMIListObserver, int n, int n2) {
    }

    default public HMIListView createListView(HMIListObserver hMIListObserver, int n) {
    }

    default public Object getKey() {
    }

    default public void fillViewRanges(HMIListViewRanges hMIListViewRanges) {
    }

    default public Object getSemaphore() {
    }
}

