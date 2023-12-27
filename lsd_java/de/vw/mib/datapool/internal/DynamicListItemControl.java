/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataListener;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.update.ListItemControlUpdater;
import de.vw.mib.log4mib.Logger;

final class DynamicListItemControl
implements DynamicListDataListener,
ExtendedListItemControl,
ListItemControlUpdater {
    private static Logger logger = ServiceManagerCommon.loggerFactory.getLogger(8);
    private static final int SUB_CLASSIFIER;
    private final DynamicListData dynamicListData;
    private final DynamicListDataRowItemTransformer transformer;
    private final CowArray listeners;

    DynamicListItemControl(DynamicListData dynamicListData) {
        this.dynamicListData = dynamicListData;
        this.transformer = dynamicListData.getListTransformer();
        this.dynamicListData.addDynamicListDataListener(this);
        this.listeners = new CowArray();
    }

    @Override
    public void activatedIndexChanged(int n) {
        ServiceManagerCommon.datapoolEventDispatcher.createAndSubmitListItemControlUpdateEvent_activatedIndexChanged(this, n);
    }

    @Override
    public void activatedIndexChanged_internal(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            ((ListItemControlListener)objectArray[i2]).activatedIndexChanged(n);
        }
    }

    @Override
    public void addListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listeners.addIfNotAlreadyIn(listItemControlListener);
    }

    @Override
    public void forceUnfreeze() {
        this.dynamicListData.forceUnfreeze();
    }

    @Override
    public void freeze() {
        this.dynamicListData.freeze();
    }

    @Override
    public int getActivatedIndex() {
        return this.dynamicListData.getActivatedIndex();
    }

    @Override
    public DynamicListData getASLList() {
        return this.dynamicListData;
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

    @Override
    public int getItemCount() {
        return this.dynamicListData.getItemCount();
    }

    @Override
    public DynamicListDataRowItemTransformer getListTransformer() {
        return this.transformer;
    }

    @Override
    public Object getRowItem(int n) {
        try {
            return this.dynamicListData.getRowItem(n);
        }
        catch (RuntimeException runtimeException) {
            logger.error(64).attachThrowable(runtimeException).append("Error while gettings row item").append(" [row: ").append(n).append("]: ").append(runtimeException.getMessage()).log();
            return DynamicListData.ITEM_NOT_LOADED;
        }
    }

    @Override
    public CellValue getCellValue(CellValue cellValue, Object object, int n, int n2) {
        if (object == DynamicListData.ITEM_NOT_LOADED) {
            return cellValue;
        }
        try {
            byte by = cellValue.getType();
            switch (by) {
                case 1: {
                    return cellValue.setBoolean(this.transformer.getBoolean(n2, object));
                }
                case 5: {
                    return cellValue.setInt(this.transformer.getInt(n2, object));
                }
                case 6: {
                    return cellValue.setLong(this.transformer.getLong(n2, object));
                }
                case 9: {
                    return cellValue.setString(this.transformer.getString(n2, object));
                }
                case 10: {
                    return cellValue.setObject(this.transformer.get(n2, object));
                }
            }
            throw new IllegalStateException("Unknown cell type.");
        }
        catch (RuntimeException runtimeException) {
            logger.error(64).attachThrowable(runtimeException).append("Error while gettings cell value").append(" [row: ").append(n).append(", column: ").append(n2).append("]: ").append(runtimeException.getMessage()).log();
            return cellValue;
        }
    }

    @Override
    public StringIndex getStringIndex() {
        return this.dynamicListData.getStringIndex();
    }

    @Override
    public void itemsChanged(int n, int n2) {
        ServiceManagerCommon.datapoolEventDispatcher.createAndSubmitListItemControlUpdateEvent_itemsChanged(this, n, n2);
    }

    @Override
    public void itemsChanged_internal(int n, int n2) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            ((ListItemControlListener)objectArray[i2]).itemsChanged(n, n2);
        }
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        ServiceManagerCommon.datapoolEventDispatcher.createAndSubmitListItemControlUpdateEvent_itemsInserted(this, n, n2, n3);
    }

    @Override
    public void itemsInserted_internal(int n, int n2, int n3) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            ((ListItemControlListener)objectArray[i2]).itemsInserted(n, n2, n3);
        }
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        ServiceManagerCommon.datapoolEventDispatcher.createAndSubmitListItemControlUpdateEvent_itemsRemoved(this, n, n2, n3);
    }

    @Override
    public void itemsRemoved_internal(int n, int n2, int n3) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            ((ListItemControlListener)objectArray[i2]).itemsRemoved(n, n2, n3);
        }
    }

    @Override
    public void listChanged(int n) {
        ServiceManagerCommon.datapoolEventDispatcher.createAndSubmitListItemControlUpdateEvent_listChanged(this, n);
    }

    @Override
    public void listChanged_internal(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            ((ListItemControlListener)objectArray[i2]).listChanged(n);
        }
    }

    @Override
    public void listContentChanged() {
        ServiceManagerCommon.datapoolEventDispatcher.createAndSubmitListItemControlUpdateEvent_listContentChanged(this);
    }

    @Override
    public void listContentChanged_internal() {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            ((ListItemControlListener)objectArray[i2]).listContentChanged();
        }
    }

    @Override
    public void refresh() {
        this.listContentChanged_internal();
    }

    @Override
    public void removeListItemControlListener(ListItemControlListener listItemControlListener) {
        this.listeners.remove(listItemControlListener);
    }

    @Override
    public void stringIndexChanged() {
        ServiceManagerCommon.datapoolEventDispatcher.createAndSubmitListItemControlUpdateEvent_stringIndexChanged(this);
    }

    @Override
    public void stringIndexChanged_internal() {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = this.listeners.size() - 1; i2 >= 0; --i2) {
            ((ListItemControlListener)objectArray[i2]).stringIndexChanged();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ListItemControl - ").append(this.dynamicListData);
        return stringBuffer.toString();
    }

    @Override
    public void unfreeze() {
        this.dynamicListData.unfreeze();
    }

    @Override
    public void updateListView(int n, int n2) {
        this.dynamicListData.updateListView(n, n2);
    }
}

