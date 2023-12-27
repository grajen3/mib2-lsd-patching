/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.list;

import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;

public final class DefaultTemplateListSelectionStrategy {
    private static final int DEFAULT_TICK_COUNT;

    private DefaultTemplateListSelectionStrategy() {
    }

    public static int getNextSelectedIndex(TemplateListModel templateListModel, int n, boolean bl) {
        int n2;
        int n3 = n2 = templateListModel.get_selectedIndex();
        int n4 = templateListModel.isItemSelectable(n2) ? n2 : -1;
        boolean bl2 = false;
        boolean bl3 = true;
        boolean bl4 = templateListModel.is_cyclicScrolling();
        int n5 = templateListModel.get_itemCount();
        int n6 = n;
        int n7 = 0;
        while (bl3) {
            if (n3 == -1) {
                n3 = DefaultTemplateListSelectionStrategy.getInitialSelectedIndex(templateListModel, true, bl);
            } else if (bl4) {
                n3 = DefaultTemplateListSelectionStrategy.MATH_MOD(n3 + n, n5);
            } else if (n3 + n6 < n5) {
                n3 += n6;
            } else {
                n3 = n5 - 1;
                n6 = -1;
            }
            bl2 = templateListModel.isItemSelectable(n3);
            bl3 = !bl2 && n7 < n5;
            ++n7;
        }
        if (bl2) {
            return n3;
        }
        return n4;
    }

    public static int getNextSelectedIndex(TemplateListModel templateListModel, int n) {
        return DefaultTemplateListSelectionStrategy.getNextSelectedIndex(templateListModel, n, true);
    }

    public static int getNextSelectedIndex(TemplateListModel templateListModel) {
        return DefaultTemplateListSelectionStrategy.getNextSelectedIndex(templateListModel, 1, false);
    }

    public static int getPrevSelectedIndex(TemplateListModel templateListModel, int n, boolean bl) {
        int n2;
        int n3 = n2 = templateListModel.get_selectedIndex();
        int n4 = templateListModel.isItemSelectable(n2) ? n2 : -1;
        boolean bl2 = false;
        boolean bl3 = true;
        boolean bl4 = templateListModel.is_cyclicScrolling();
        int n5 = templateListModel.get_itemCount();
        int n6 = n;
        int n7 = 0;
        while (bl3) {
            if (n3 == -1) {
                n3 = DefaultTemplateListSelectionStrategy.getInitialSelectedIndex(templateListModel, false, bl);
            } else if (bl4) {
                n3 = DefaultTemplateListSelectionStrategy.MATH_MOD(n3 - n6, n5);
            } else if (n3 - n6 >= 0) {
                n3 -= n6;
            } else {
                n3 = 0;
                n6 = -1;
            }
            bl2 = templateListModel.isItemSelectable(n3);
            bl3 = !bl2 && n7 < n5;
            ++n7;
        }
        if (bl2) {
            return n3;
        }
        return n4;
    }

    public static int getPrevSelectedIndex(TemplateListModel templateListModel, int n) {
        return DefaultTemplateListSelectionStrategy.getPrevSelectedIndex(templateListModel, n, true);
    }

    public static int getPrevSelectedIndex(TemplateListModel templateListModel) {
        return DefaultTemplateListSelectionStrategy.getPrevSelectedIndex(templateListModel, 1, false);
    }

    private static int MATH_MOD(int n, int n2) {
        if (n2 != 0) {
            int n3 = n % n2;
            return n3 < 0 ? n2 + n3 : n3;
        }
        return 0;
    }

    private static int getInitialSelectedIndex(TemplateListModel templateListModel, boolean bl, boolean bl2) {
        int n;
        int n2 = templateListModel.get_itemCount();
        int n3 = templateListModel.getFirstMostlyVisibleIndex();
        int n4 = templateListModel.getLastMostlyVisibleIndex();
        int n5 = n = bl2 ? DefaultTemplateListSelectionStrategy.getInitialSelectedIndexByActivation(templateListModel) : -1;
        if (n == -1) {
            switch (templateListModel.get_scrollTypeRotary()) {
                case 0: 
                case 2: {
                    n = bl ? n3 : n4;
                    break;
                }
                case 1: {
                    if (bl) {
                        n = n3 == 0 ? n3 : n3 + 1;
                        break;
                    }
                    n = n4 == n2 - 1 ? n4 : n4 - 1;
                    break;
                }
                default: {
                    n = bl ? n3 : n4;
                }
            }
        }
        return n;
    }

    private static int getInitialSelectedIndexByActivation(TemplateListModel templateListModel) {
        ListItemModel listItemModel;
        int n;
        int n2 = -1;
        int n3 = templateListModel.getInitialSelectionMode();
        for (n = templateListModel.getLastMostlyVisibleIndex(); n >= templateListModel.getFirstMostlyVisibleIndex(); --n) {
            listItemModel = templateListModel.getItemMaster(n);
            if (listItemModel == null || listItemModel.get_activatedIndex() != templateListModel.getItemIndex(n) || !templateListModel.isItemSelectable(n)) continue;
            n2 = n;
            break;
        }
        if (n2 == -1 && n3 == 1) {
            for (n = templateListModel.getLastMostlyVisibleIndex(); n >= templateListModel.getFirstMostlyVisibleIndex(); --n) {
                listItemModel = templateListModel.getItem(n);
                templateListModel.transferData(listItemModel, n, templateListModel.getItemIndex(n));
                if (listItemModel == null || listItemModel.get_selectedButtonRefs() == null || listItemModel.get_selectedButtonRefs().length <= 0 || !listItemModel.get_selectedButtonRefs()[0].is_activated()) continue;
                n2 = n;
                break;
            }
        }
        return n2;
    }
}

