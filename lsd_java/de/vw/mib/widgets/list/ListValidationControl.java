/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.widgets.models.ListItemModel;

public interface ListValidationControl {
    public static final int INVALID_LIST_NONE;
    public static final int INVALID_LIST_LUT;
    public static final int INVALID_LIST_VIEWPORT;
    public static final int INVALID_LIST_CONTROL;
    public static final int INVALID_LIST_FOLLOW_ITEM;
    public static final int INVALID_LIST_ACTIVATED_INDEX;
    public static final int INVALID_LIST_SELECTED_INDEX;
    public static final int INVALID_LIST_FOCUSED_INDEX;
    public static final int INVALID_LIST_ITEM_CLONES;
    public static final int INVALID_LIST_ITEM_NUMBERS;
    public static final int INVALID_LIST_VISIBLE_INDICES;
    public static final int INVALID_LIST_LETTER_INDICATOR;
    public static final int INVALID_LIST_FAST_SCROLLING;
    public static final int INVALID_LIST_VIEW_OBSERVER;
    public static final int INVALID_LIST_ADJUSTMENT_RANGE;
    public static final int INVALID_LIST_FIRST_ITEM_INDEX;
    public static final int INVALID_LIST_SELECTIVE_ITEM;
    public static final int INVALID_LIST_BROWSING;
    public static final int INVALID_LIST_EXPAND;
    public static final int INVALID_LIST_NO_ANIMATIONS;

    default public void invalidateList() {
    }

    default public void invalidateList(int n) {
    }

    default public void resetListInvalidation() {
    }

    default public void validateList() {
    }

    default public void validateListImmediately(int n) {
    }

    default public void validateListImmediately(int n, ListItemModel listItemModel) {
    }

    default public void validateListImmediately(int n, ListItemModel listItemModel, int n2, int n3) {
    }
}

