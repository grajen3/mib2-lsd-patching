/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.widgets.models.ListModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class DefaultListSelectionStrategy {
    public static int getNextSelectedIndex(ListModel listModel) {
        return DefaultListSelectionStrategy.getNextEnabledVisibleChildsIdx(listModel.get_selectedIndex(), listModel, true, listModel.is_cyclicScrolling(), false, false);
    }

    public static int getPrevSelectedIndex(ListModel listModel) {
        return DefaultListSelectionStrategy.getNextEnabledVisibleChildsIdx(listModel.get_selectedIndex(), listModel, false, listModel.is_cyclicScrolling(), false, false);
    }

    public static int getNewSelectedIndex(ListModel listModel, int n) {
        WidgetModel widgetModel;
        WidgetModel[] widgetModelArray = listModel.getChildren();
        boolean bl = true;
        int n2 = -1;
        boolean bl2 = true;
        boolean bl3 = listModel.is_cyclicScrolling();
        if (n >= 0 && n < widgetModelArray.length && (widgetModel = widgetModelArray[n]) != null && widgetModel.is_visible() && widgetModel.is_enabled()) {
            return n;
        }
        int n3 = DefaultListSelectionStrategy.getNextEnabledVisibleChildsIdx(n, listModel, true, bl3, false, false);
        if (n3 == n && (n3 = DefaultListSelectionStrategy.getNextEnabledVisibleChildsIdx(n, listModel, false, bl3, false, false)) == n) {
            n3 = -1;
        }
        return n3;
    }

    protected static int getNextEnabledVisibleChildsIdx(int n, ListModel listModel, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        WidgetModel[] widgetModelArray = listModel.getChildren();
        int n2 = widgetModelArray.length;
        WidgetModel widgetModel = null;
        if (bl) {
            int n3 = n < 0 ? 0 : Math.min(n + 1, n2);
            int n4 = 0;
            while (bl2 ? n4 < n2 : n3 < n2) {
                int n5 = DefaultListSelectionStrategy.MATH_MOD(n3, n2);
                widgetModel = widgetModelArray[n5];
                if ((bl3 || widgetModel.is_enabled()) && (bl4 || widgetModel.is_visible())) {
                    return n5;
                }
                ++n3;
                ++n4;
            }
        } else {
            int n6 = n >= n2 ? n2 - 1 : n - 1;
            int n7 = 0;
            while (bl2 ? n7 < n2 : n6 > -1) {
                int n8 = DefaultListSelectionStrategy.MATH_MOD(n6, n2);
                widgetModel = widgetModelArray[n8];
                if ((bl3 || widgetModel.is_enabled()) && (bl4 || widgetModel.is_visible())) {
                    return n8;
                }
                --n6;
                ++n7;
            }
        }
        return n;
    }

    public static int MATH_MOD(int n, int n2) {
        if (n2 != 0) {
            int n3 = n % n2;
            return n3 < 0 ? n2 + n3 : n3;
        }
        return 0;
    }
}

