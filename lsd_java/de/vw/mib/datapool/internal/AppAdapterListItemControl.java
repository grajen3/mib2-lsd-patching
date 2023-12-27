/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.app.appadapter.list.AppAdapterList;
import de.vw.mib.app.appadapter.list.AppAdapterListUpdateEvent;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.datapool.internal.AppAdapterListItemControl$1;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.list.StringIndex;
import java.lang.reflect.Proxy;

public class AppAdapterListItemControl
implements ExtendedListItemControl {
    private final CowArray listeners;
    private AppAdapterList backingList;
    private static final DynamicListData UNSUPPORTED_OPERATION_DYNAMIC_LIST_DATA = AppAdapterListItemControl.unsupportedOperationDynamicListData();
    static /* synthetic */ Class class$de$vw$mib$list$DynamicListData;

    public AppAdapterListItemControl(AppAdapterList appAdapterList) {
        Preconditions.checkNotNull(appAdapterList, "initial");
        this.listeners = new CowArray();
        this.backingList = appAdapterList;
    }

    public void bind(AppAdapterList appAdapterList) {
        this.backingList = appAdapterList;
        this.refresh();
    }

    @Override
    public DynamicListData getASLList() {
        return UNSUPPORTED_OPERATION_DYNAMIC_LIST_DATA;
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

    @Override
    public int getItemCount() {
        return this.backingList.getListSize();
    }

    @Override
    public DynamicListDataRowItemTransformer getListTransformer() {
        throw new UnsupportedOperationException("App adapter list item control not supports 'getListTransformer'");
    }

    @Override
    public Object getRowItem(int n) {
        return this.backingList.getRowItem(n);
    }

    @Override
    public CellValue getCellValue(CellValue cellValue, Object object, int n, int n2) {
        return this.backingList.getCellValue(cellValue, object, n, n2);
    }

    @Override
    public int getActivatedIndex() {
        return this.backingList.getFocusIndex();
    }

    @Override
    public StringIndex getStringIndex() {
        return this.backingList.getStringIndex();
    }

    @Override
    public void updateListView(int n, int n2) {
    }

    @Override
    public void addListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listeners.add(listItemControlListener);
    }

    @Override
    public void removeListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listeners.remove(listItemControlListener);
    }

    @Override
    public void freeze() {
        this.backingList.freeze();
    }

    @Override
    public void unfreeze() {
        this.backingList.unfreeze();
    }

    @Override
    public void forceUnfreeze() {
        this.backingList.forceUnfreeze();
    }

    @Override
    public void refresh() {
        this.refresh(AppAdapterListUpdateEvent.contentChanged());
    }

    public void refresh(AppAdapterListUpdateEvent appAdapterListUpdateEvent) {
        int n = this.listeners.size();
        block7: for (int i2 = 0; i2 < n; ++i2) {
            ListItemControlListener listItemControlListener = (ListItemControlListener)this.listeners.get(i2);
            switch (appAdapterListUpdateEvent.getUpdateType()) {
                case 1: {
                    listItemControlListener.listContentChanged();
                    continue block7;
                }
                case 2: {
                    listItemControlListener.itemsChanged(appAdapterListUpdateEvent.getIndex(), appAdapterListUpdateEvent.getCount());
                    continue block7;
                }
                case 8: {
                    listItemControlListener.activatedIndexChanged(appAdapterListUpdateEvent.getIndex());
                    continue block7;
                }
                case 4: {
                    listItemControlListener.listChanged(appAdapterListUpdateEvent.getListSize());
                    continue block7;
                }
                case 16: {
                    listItemControlListener.stringIndexChanged();
                    continue block7;
                }
            }
        }
    }

    private static DynamicListData unsupportedOperationDynamicListData() {
        Class[] classArray = new Class[]{class$de$vw$mib$list$DynamicListData == null ? (class$de$vw$mib$list$DynamicListData = AppAdapterListItemControl.class$("de.vw.mib.list.DynamicListData")) : class$de$vw$mib$list$DynamicListData};
        return (DynamicListData)Proxy.newProxyInstance(classArray[0].getClassLoader(), classArray, new AppAdapterListItemControl$1());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

