/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.widgets.models.ListItemModel;

public interface ListItemChangedListener {
    public static final int UPDATE_ALL;
    public static final int UPDATE_EXISTENCE;
    public static final int UPDATE_CONTENT;
    public static final int UPDATE_ACTIVATED_INDEX_HMI;
    public static final int UPDATE_ACTIVATED_INDEX_API;
    public static final int UPDATE_ITEMS_INSERTED;
    public static final int UPDATE_ITEMS_REMOVED;
    public static final int UPDATE_ITEMS_CHANGED;
    public static final int UPDATE_STRING_INDEX;
    public static final int UPDATE_ITEM_HEIGHT;
    public static final int UPDATE_ITEM_WIDTH;
    public static final int INDEX_NONE;
    public static final int COUNT_NONE;

    default public void listItemChanged(ListItemModel listItemModel, int n, int n2, int n3) {
    }
}

