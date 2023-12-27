/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLListDataUpdateRegistry;
import de.vw.mib.asl.internal.list.ASLListStringIndexed;
import de.vw.mib.asl.internal.list.ASLListView;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataDebug;
import de.vw.mib.log4mib.Loggable;

public interface ASLList
extends DynamicListData,
DynamicListDataDebug,
ASLListDataUpdateRegistry,
ASLListStringIndexed,
ASLListView,
Loggable {
    public static final int LIST_ONE_ELEMENT_DEFAULT_INDEX;
    public static final int OBJECT_ID_BY_ROW;

    default public boolean isFrozen() {
    }

    @Override
    default public Object getRowItem(int n) {
    }

    default public Object getRowItemCacheOnly(int n) {
    }

    @Override
    default public int getSize() {
    }

    default public void setActiveIndex(int n) {
    }

    default public int getListId() {
    }

    default public String getDeviceName() {
    }

    default public String getName() {
    }

    default public boolean isValidItem(Object object) {
    }

    default public void setColumn4ObjectId(int n) {
    }

    @Override
    default public long getObjectId(Object object) {
    }

    default public long getObjectIdByRowCacheOnly(int n) {
    }

    default public Object getListItemByIdCacheOnly(long l) {
    }

    default public void updateList(Object[] objectArray) {
    }

    default public void setSpeechListIds(int[] nArray) {
    }

    default public boolean toArray(int n, Object[] objectArray) {
    }

    default public void clear() {
    }

    default public void enableModCount() {
    }

    default public void disableModCount() {
    }

    default public boolean isModCountEnabled() {
    }

    default public int getModCount() {
    }
}

