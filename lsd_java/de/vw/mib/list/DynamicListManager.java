/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.DynamicListData;

public interface DynamicListManager {
    public static final Object NOT_LOADED_ENTRY = DynamicListData.ITEM_NOT_LOADED;

    default public DynamicListData getDynamicList(int n) {
    }
}

