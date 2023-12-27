/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.Disposable;
import de.vw.mib.widgets.interfaces.WidgetCloneFactory;
import de.vw.mib.widgets.layout.Layoutable;
import de.vw.mib.widgets.models.ListItemModel;

public interface ListLUT
extends Disposable {
    public static final int ITEM_ID_NONE;
    public static final int CLONE_ID_NONE;
    public static final int ITEM_INDEX_NONE;
    public static final int ITEM_ABS_INDEX;
    public static final int ITEM_LAYOUT_VALUE_NONE;
    public static final int LETTER_INDEX_NONE;

    default public int getItemCount() {
    }

    default public int getItemID(int n) {
    }

    default public int getCloneID(int n) {
    }

    default public int getItemIndex(int n) {
    }

    default public int getAbsIndexByListItemDynamicIndex(ListItemModel listItemModel, int n) {
    }

    default public void setItemLayoutValue(int n, int n2, int n3) {
    }

    default public int getItemLayoutValue(int n, int n2) {
    }

    default public int findLayoutValueItemIndex(int n, int n2, int n3, boolean bl) {
    }

    default public void setLayoutValueCount(int n) {
    }

    default public void setLayoutable(Layoutable layoutable) {
    }

    default public int getLayoutIndexFirst() {
    }

    default public int getLayoutIndexLast() {
    }

    default public boolean isLetterScrollingSupported() {
    }

    default public int getLetterScrollingCount() {
    }

    default public int getLetterScrollingAbsIndex(int n) {
    }

    default public String getLetterScrollingText(int n) {
    }

    default public int getLetterScrollingIndexByAbsIndex(int n) {
    }

    default public int getLetterScrollingIndexByLayoutValue(int n) {
    }

    default public void setLetterScrollingLayoutValueNumber(int n) {
    }

    default public void update(ListItemModel[] listItemModelArray, boolean bl, boolean bl2) {
    }

    default public void validateClones(WidgetCloneFactory widgetCloneFactory, int n, int n2, boolean bl) {
    }

    default public void destroyClones(WidgetCloneFactory widgetCloneFactory, ListItemModel[] listItemModelArray) {
    }
}

