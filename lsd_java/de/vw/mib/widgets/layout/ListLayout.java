/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.layout;

import de.vw.mib.collections.ints.IntIntMultimap;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.WidgetListModel;

public final class ListLayout {
    private static IntIntMultimap alignmentMap;

    private ListLayout() {
    }

    public static void performLayout(WidgetListModel widgetListModel) {
        if (widgetListModel != null && widgetListModel.getLayoutIndexFirst() >= 0 && widgetListModel.getLayoutIndexLast() >= 0) {
            switch (widgetListModel.get_orientation()) {
                case 0: {
                    ListLayout.performVerticalLayout(widgetListModel, false);
                    break;
                }
                case 4: {
                    ListLayout.performVerticalLayout(widgetListModel, true);
                    break;
                }
                case 2: {
                    ListLayout.performVerticalWrapLayout(widgetListModel, false);
                    break;
                }
                case 6: {
                    ListLayout.performVerticalWrapLayout(widgetListModel, true);
                    break;
                }
                case 1: {
                    ListLayout.performHorizontalLayout(widgetListModel, false);
                    break;
                }
                case 5: {
                    ListLayout.performHorizontalLayout(widgetListModel, true);
                    break;
                }
                case 3: {
                    ListLayout.performHorizontalWrapLayout(widgetListModel, false);
                    break;
                }
                case 7: {
                    ListLayout.performHorizontalWrapLayout(widgetListModel, true);
                    break;
                }
                case 20: {
                    ListLayout.performItemPointsLayout(widgetListModel);
                    break;
                }
                default: {
                    ListLayout.performVerticalLayout(widgetListModel, false);
                }
            }
        }
    }

    private static void performAlignmentPage(WidgetListModel widgetListModel, int n, int n2, boolean bl) {
        int n3 = widgetListModel.get_alignmentPage();
        if (n3 != 0) {
            int n4;
            int n5 = n4 = bl ? widgetListModel.get_height() : widgetListModel.get_width();
            if (alignmentMap == null) {
                alignmentMap = new IntIntMultimap();
            } else {
                alignmentMap.clear();
            }
            for (int i2 = n; i2 <= n2; ++i2) {
                alignmentMap.put(bl ? widgetListModel.getItemX(i2) : widgetListModel.getItemY(i2), i2);
            }
            int[] nArray = alignmentMap.keysToArray();
            if (nArray != null) {
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    int n6;
                    int[] nArray2 = alignmentMap.getAll(nArray[i3]).toArray();
                    if (nArray2 == null || nArray2.length <= 0) continue;
                    int n7 = nArray2.length;
                    int n8 = nArray2[0];
                    int n9 = nArray2[n7 - 1];
                    int n10 = bl ? widgetListModel.getItemY(n8) : widgetListModel.getItemX(n8);
                    int n11 = bl ? widgetListModel.getItemY(n9) + widgetListModel.getItemHeight(n9) : widgetListModel.getItemX(n9) + widgetListModel.getItemWidth(n9);
                    switch (n3) {
                        case 2: {
                            n6 = (n4 >> 1) - (n11 - n10 >> 1);
                            break;
                        }
                        case 1: {
                            n6 = n4 - n11 + n10;
                            break;
                        }
                        default: {
                            n6 = 0;
                        }
                    }
                    for (int i4 = 0; i4 < n7; ++i4) {
                        int n12 = nArray2[i4];
                        if (bl) {
                            widgetListModel.setItemY(n12, widgetListModel.getItemY(n12) + n6);
                            continue;
                        }
                        widgetListModel.setItemX(n12, widgetListModel.getItemX(n12) + n6);
                    }
                }
            }
        }
    }

    private static void performVerticalLayout(WidgetListModel widgetListModel, boolean bl) {
        int n;
        Insets insets = widgetListModel.get_padding();
        int n2 = widgetListModel.getLayoutIndexFirst();
        int n3 = widgetListModel.getLayoutIndexLast();
        int n4 = n2 > 0 ? widgetListModel.getItemY(n2 - 1) + widgetListModel.getItemHeight(n2 - 1) + widgetListModel.get_spacingVertical() : insets.top;
        int n5 = widgetListModel.get_spacingPage();
        int n6 = n = widgetListModel.get_height();
        int n7 = 0;
        int n8 = 0;
        for (int i2 = n2; i2 <= n3; ++i2) {
            int n9 = widgetListModel.getItemHeight(i2);
            if (bl && n4 + n9 > n6) {
                ListLayout.performAlignmentPage(widgetListModel, n7, i2 - 1, true);
                n4 = n6 + n5;
                n6 = n4 + n;
                n7 = i2;
                ++n8;
            }
            widgetListModel.setItemX(i2, insets.left);
            widgetListModel.setItemY(i2, n4);
            if (bl) {
                widgetListModel.setItemPage(i2, n8);
            }
            n4 += n9 + widgetListModel.get_spacingVertical();
        }
        if (bl) {
            ListLayout.performAlignmentPage(widgetListModel, n7, n3, true);
        }
    }

    private static void performHorizontalLayout(WidgetListModel widgetListModel, boolean bl) {
        int n;
        Insets insets = widgetListModel.get_padding();
        int n2 = widgetListModel.getLayoutIndexFirst();
        int n3 = widgetListModel.getLayoutIndexLast();
        int n4 = n2 > 0 ? widgetListModel.getItemX(n2 - 1) + widgetListModel.getItemWidth(n2 - 1) + widgetListModel.get_spacingHorizontal() : insets.left;
        int n5 = widgetListModel.get_spacingPage();
        int n6 = n = widgetListModel.get_width();
        int n7 = 0;
        int n8 = 0;
        for (int i2 = n2; i2 <= n3; ++i2) {
            int n9 = widgetListModel.getItemWidth(i2);
            if (bl && n4 + n9 > n6) {
                ListLayout.performAlignmentPage(widgetListModel, n7, i2 - 1, false);
                n4 = n6 + n5;
                n6 = n4 + n;
                n7 = i2;
                ++n8;
            }
            widgetListModel.setItemY(i2, insets.top);
            widgetListModel.setItemX(i2, n4);
            if (bl) {
                widgetListModel.setItemPage(i2, n8);
            }
            n4 += n9 + widgetListModel.get_spacingHorizontal();
        }
        if (bl) {
            ListLayout.performAlignmentPage(widgetListModel, n7, n3, false);
        }
    }

    private static void performVerticalWrapLayout(WidgetListModel widgetListModel, boolean bl) {
        int n;
        Insets insets = widgetListModel.get_padding();
        int n2 = widgetListModel.getLayoutIndexFirst();
        int n3 = widgetListModel.getLayoutIndexLast();
        int n4 = n2 > 0 ? widgetListModel.getItemY(n2 - 1) + widgetListModel.getItemHeight(n2 - 1) : insets.top;
        int n5 = n2 > 0 ? widgetListModel.getItemX(n2 - 1) + widgetListModel.getItemWidth(n2 - 1) : insets.left;
        int n6 = insets.left;
        int n7 = widgetListModel.get_width() - insets.right;
        int n8 = widgetListModel.get_spacingPage();
        int n9 = n = widgetListModel.get_height();
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        for (int i2 = n2; i2 <= n3; ++i2) {
            int n13 = widgetListModel.getItemHeight(i2);
            int n14 = widgetListModel.getItemWidth(i2);
            if (n5 + n14 > n7) {
                n5 = n6;
                n4 += n12 + widgetListModel.get_spacingVertical();
                n12 = 0;
            }
            if (bl && n4 + n13 > n9) {
                ListLayout.performAlignmentPage(widgetListModel, n10, i2 - 1, true);
                n4 = n9 + n8;
                n9 = n4 + n;
                n10 = i2;
                ++n11;
            }
            widgetListModel.setItemX(i2, n5);
            widgetListModel.setItemY(i2, n4);
            if (bl) {
                widgetListModel.setItemPage(i2, n11);
            }
            n12 = Math.max(n12, n13);
            n5 += n14 + widgetListModel.get_spacingHorizontal();
        }
        if (bl) {
            ListLayout.performAlignmentPage(widgetListModel, n10, n3, true);
        }
    }

    private static void performHorizontalWrapLayout(WidgetListModel widgetListModel, boolean bl) {
        int n;
        Insets insets = widgetListModel.get_padding();
        int n2 = widgetListModel.getLayoutIndexFirst();
        int n3 = widgetListModel.getLayoutIndexLast();
        int n4 = n2 > 0 ? widgetListModel.getItemY(n2 - 1) + widgetListModel.getItemHeight(n2 - 1) : insets.top;
        int n5 = n2 > 0 ? widgetListModel.getItemX(n2 - 1) + widgetListModel.getItemWidth(n2 - 1) : insets.left;
        int n6 = insets.top;
        int n7 = widgetListModel.get_height() - insets.bottom;
        int n8 = widgetListModel.get_spacingPage();
        int n9 = n = widgetListModel.get_width();
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        for (int i2 = n2; i2 <= n3; ++i2) {
            int n13 = widgetListModel.getItemHeight(i2);
            int n14 = widgetListModel.getItemWidth(i2);
            if (n4 + n13 > n7) {
                n4 = n6;
                n5 += n12 + widgetListModel.get_spacingHorizontal();
                n12 = 0;
            }
            if (bl && n5 + n14 > n9) {
                ListLayout.performAlignmentPage(widgetListModel, n10, i2 - 1, false);
                n5 = n9 + n8;
                n9 = n5 + n;
                n10 = i2;
                ++n11;
            }
            widgetListModel.setItemX(i2, n5);
            widgetListModel.setItemY(i2, n4);
            if (bl) {
                widgetListModel.setItemPage(i2, n11);
            }
            n12 = Math.max(n12, n14);
            n4 += n13 + widgetListModel.get_spacingVertical();
        }
        if (bl) {
            ListLayout.performAlignmentPage(widgetListModel, n10, n3, false);
        }
    }

    private static void performItemPointsLayout(WidgetListModel widgetListModel) {
        Point[] pointArray = widgetListModel.get_itemPoints();
        ListItemModel[] listItemModelArray = widgetListModel.getListItems();
        int[] nArray = ListLayout.getItemOffsets(listItemModelArray);
        int n = widgetListModel.getLayoutIndexFirst();
        int n2 = widgetListModel.getLayoutIndexLast();
        if (pointArray != null && pointArray.length > 0) {
            for (int i2 = n; i2 <= n2; ++i2) {
                int n3;
                int n4 = ListLayout.getItemNumber(listItemModelArray, widgetListModel.getItem(i2));
                int n5 = nArray[n4];
                int n6 = Math.min(n5 + (n3 = widgetListModel.getItemIndex(i2)), pointArray.length - 1);
                int n7 = pointArray[n6] != null ? pointArray[n6].x : 0;
                int n8 = pointArray[n6] != null ? pointArray[n6].y : 0;
                widgetListModel.setItemX(i2, n7);
                widgetListModel.setItemY(i2, n8);
            }
        }
    }

    private static int[] getItemOffsets(ListItemModel[] listItemModelArray) {
        int[] nArray = null;
        if (listItemModelArray != null) {
            int n = 0;
            int n2 = listItemModelArray.length;
            nArray = new int[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                nArray[i2] = n;
                n += listItemModelArray[i2].getItemCount();
            }
        }
        return nArray;
    }

    private static int getItemNumber(ListItemModel[] listItemModelArray, ListItemModel listItemModel) {
        int n = -1;
        if (listItemModelArray != null) {
            int n2 = listItemModelArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (listItemModelArray[i2] != listItemModel) continue;
                n = i2;
                break;
            }
        }
        return n;
    }
}

