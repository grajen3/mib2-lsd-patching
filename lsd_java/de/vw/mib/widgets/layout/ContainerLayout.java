/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.layout;

import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.layout.ContainerLayout$LayoutStorage;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;

public final class ContainerLayout {
    public static final int BITS_PER_INT;

    private ContainerLayout() {
    }

    public static void performLayout(WidgetModel[] widgetModelArray, int n, LayoutAttribs layoutAttribs, int n2, int n3, int[] nArray, boolean bl) {
        switch (layoutAttribs.getLayoutOrientation()) {
            case 0: {
                ContainerLayout.performFlowLayout(widgetModelArray, layoutAttribs, n, layoutAttribs.getWidgetHorAlignment(), n2, layoutAttribs.getInsetLeft(), layoutAttribs.getInsetRight(), layoutAttribs.getWidgetVerAlignment(), n3, layoutAttribs.getInsetTop(), layoutAttribs.getInsetBottom(), false, nArray, false, bl);
                ContainerLayout.updateLayoutFlags(widgetModelArray, nArray);
                break;
            }
            case 4: {
                ContainerLayout.performFlowLayout(widgetModelArray, layoutAttribs, n, layoutAttribs.getWidgetHorAlignment(), n2, layoutAttribs.getInsetLeft(), layoutAttribs.getInsetRight(), layoutAttribs.getWidgetVerAlignment(), n3, layoutAttribs.getInsetTop(), layoutAttribs.getInsetBottom(), true, nArray, false, bl);
                ContainerLayout.updateLayoutFlags(widgetModelArray, nArray);
                break;
            }
            case 3: {
                ContainerLayout.performFlowLayout(widgetModelArray, layoutAttribs, n, layoutAttribs.getWidgetHorAlignment(), n2, layoutAttribs.getInsetLeft(), layoutAttribs.getInsetRight(), layoutAttribs.getWidgetVerAlignment(), n3, layoutAttribs.getInsetTop(), layoutAttribs.getInsetBottom(), false, nArray, true, bl);
                ContainerLayout.updateLayoutFlags(widgetModelArray, nArray);
                break;
            }
            case 5: {
                ContainerLayout.performFlowLayout(widgetModelArray, layoutAttribs, n, layoutAttribs.getWidgetHorAlignment(), n2, layoutAttribs.getInsetLeft(), layoutAttribs.getInsetRight(), layoutAttribs.getWidgetVerAlignment(), n3, layoutAttribs.getInsetTop(), layoutAttribs.getInsetBottom(), true, nArray, true, bl);
                ContainerLayout.updateLayoutFlags(widgetModelArray, nArray);
                break;
            }
            case 1: {
                ContainerLayout.performFlowLayout(widgetModelArray, layoutAttribs, n, layoutAttribs.getWidgetVerAlignment(), n3, layoutAttribs.getInsetTop(), layoutAttribs.getInsetBottom(), layoutAttribs.getWidgetHorAlignment(), n2, layoutAttribs.getInsetLeft(), layoutAttribs.getInsetRight(), false, nArray, false, bl);
                ContainerLayout.updateLayoutFlags(widgetModelArray, nArray);
                break;
            }
            case 6: {
                ContainerLayout.performFlowLayout(widgetModelArray, layoutAttribs, n, layoutAttribs.getWidgetVerAlignment(), n3, layoutAttribs.getInsetTop(), layoutAttribs.getInsetBottom(), layoutAttribs.getWidgetHorAlignment(), n2, layoutAttribs.getInsetLeft(), layoutAttribs.getInsetRight(), false, nArray, true, bl);
                ContainerLayout.updateLayoutFlags(widgetModelArray, nArray);
                break;
            }
            case 2: {
                ContainerLayout.performFitLayout(widgetModelArray, n2, n3, layoutAttribs.getInsetLeft(), layoutAttribs.getInsetRight(), layoutAttribs.getInsetTop(), layoutAttribs.getInsetBottom());
                break;
            }
        }
    }

    private static void performFitLayout(WidgetModel[] widgetModelArray, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = n - n3 - n4;
        int n8 = n2 - n5 - n6;
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            widgetModel.disableAnimations();
            widgetModel.set_width(n7);
            widgetModel.set_x(n3);
            widgetModel.set_height(n8);
            widgetModel.set_y(n5);
            widgetModel.enableAnimations();
        }
    }

    private static void performLayoutSetWidgetSize(WidgetModel widgetModel, boolean bl, int n) {
        if (bl) {
            widgetModel.set_width(Math.max(0, n));
        } else {
            widgetModel.set_height(Math.max(0, n));
        }
    }

    private static int performLayoutCalcStartPosition(int n, int n2, int n3, int n4, int n5) {
        switch (n) {
            case 1: {
                return (n2 + n4 + n5 >> 1) - (n3 >> 1);
            }
            case 2: {
                return n2 - n3 + n4;
            }
        }
        return n4;
    }

    private static int performFlowLayoutFixWidgetSizes(WidgetModel[] widgetModelArray, LayoutAttribs layoutAttribs, boolean bl, int n, boolean bl2, int[] nArray, boolean bl3) {
        int n2 = layoutAttribs.getWidgetSizesCount();
        int n3 = 0;
        int n4 = 0;
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            if (widgetModel.is_visible()) {
                if (n2 > n4) {
                    int n5;
                    if (!(layoutAttribs.isWidgetSizeRelative(n4) && bl2 || (n5 = layoutAttribs.getWidgetSizeValue(n4)) == 0)) {
                        nArray[i2] = layoutAttribs.isWidgetSizeRelative(n4) ? n5 * n / 100 : n5;
                    }
                } else if (!bl2) {
                    nArray[i2] = bl ? widgetModel.get_width() : widgetModel.get_height();
                }
                n3 += nArray[i2];
                ++n4;
                continue;
            }
            if (!bl3) continue;
            ++n4;
        }
        return n3;
    }

    private static void performFlowLayoutVarWidgetSizes(WidgetModel[] widgetModelArray, LayoutAttribs layoutAttribs, boolean bl, int n, int n2, int[] nArray, boolean bl2) {
        int n3;
        int n4 = n2;
        int n5 = 0;
        int n6 = widgetModelArray.length;
        int n7 = layoutAttribs.getWidgetSizesCount();
        int n8 = 0;
        for (n3 = 0; n8 < n7 && n3 < n6; ++n3) {
            WidgetModel widgetModel = widgetModelArray[n3];
            if (widgetModel.is_visible()) {
                if (layoutAttribs.isWidgetSizeRelative(n8)) {
                    int n9 = n * layoutAttribs.getWidgetSizeValue(n8) / 100;
                    n5 += n9;
                    nArray[n3] = n9;
                    --n4;
                } else if (layoutAttribs.getWidgetSizeValue(n8) != 0) {
                    --n4;
                }
                ++n8;
                continue;
            }
            if (!bl2) continue;
            ++n8;
        }
        n8 = 0;
        for (n3 = 0; n3 < n6; ++n3) {
            if (widgetModelArray[n3].is_visible()) {
                if (n8 >= n7 || !layoutAttribs.isWidgetSizeRelative(n8) && layoutAttribs.getWidgetSizeValue(n8) == 0) {
                    int n10;
                    nArray[n3] = n10 = (n - n5) / n4;
                    n5 += n10;
                    --n4;
                }
                ++n8;
                continue;
            }
            if (!bl2) continue;
            ++n8;
        }
    }

    private static void performFlowLayoutWrapWidgetPositions(WidgetModel[] widgetModelArray, boolean bl, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int[] nArray, int[] nArray2, boolean bl2) {
        int n10;
        int n11;
        int n12;
        ArrayList arrayList = new ArrayList(widgetModelArray.length);
        int[] nArray3 = new int[widgetModelArray.length];
        boolean bl3 = (nArray2[0] & 1) == 0;
        int n13 = 2;
        int n14 = 0;
        ContainerLayout$LayoutStorage containerLayout$LayoutStorage = new ContainerLayout$LayoutStorage();
        for (n12 = 0; n12 < widgetModelArray.length; ++n12) {
            if (!widgetModelArray[n12].is_visible()) continue;
            n11 = nArray[n12];
            int n15 = containerLayout$LayoutStorage.loSize + n11 + (containerLayout$LayoutStorage.loSize == 0 ? 0 : n9);
            if (containerLayout$LayoutStorage.loSize > 0 && n15 > n2 - n3 - n4) {
                containerLayout$LayoutStorage.widgetEndIndex = n12;
                n10 = containerLayout$LayoutStorage.coPosition + n9 + containerLayout$LayoutStorage.coSize;
                arrayList.add(containerLayout$LayoutStorage);
                containerLayout$LayoutStorage = new ContainerLayout$LayoutStorage();
                containerLayout$LayoutStorage.widgetStartIndex = n12;
                containerLayout$LayoutStorage.coPosition = n10;
                containerLayout$LayoutStorage.loSize = n11;
                nArray3[n12] = 0;
            } else {
                nArray3[n12] = n15 - n11;
                containerLayout$LayoutStorage.loSize = n15;
            }
            containerLayout$LayoutStorage.coSize = Math.max(containerLayout$LayoutStorage.coSize, bl ? widgetModelArray[n12].get_height() : widgetModelArray[n12].get_width());
        }
        containerLayout$LayoutStorage.widgetEndIndex = widgetModelArray.length;
        arrayList.add(containerLayout$LayoutStorage);
        n14 = containerLayout$LayoutStorage.coPosition + containerLayout$LayoutStorage.coSize;
        int n16 = 0;
        switch (n5) {
            case 3: {
                n12 = n7;
                n16 = (n6 - n7 - n8 - (arrayList.size() - 1) * n9) / arrayList.size();
                break;
            }
            case 0: {
                n12 = n7;
                break;
            }
            case 1: {
                n12 = (n6 >> 1) - (n14 >> 1);
                break;
            }
            default: {
                n12 = n6 - n14 + n7;
            }
        }
        for (n11 = 0; n11 < arrayList.size(); ++n11) {
            ContainerLayout$LayoutStorage containerLayout$LayoutStorage2 = (ContainerLayout$LayoutStorage)arrayList.get(n11);
            switch (n) {
                case 0: {
                    n10 = n3;
                    break;
                }
                case 2: {
                    n10 = n2 - containerLayout$LayoutStorage2.loSize - n4;
                    break;
                }
                default: {
                    n10 = (n2 >> 1) - (containerLayout$LayoutStorage2.loSize >> 1);
                }
            }
            for (int i2 = containerLayout$LayoutStorage2.widgetStartIndex; i2 < containerLayout$LayoutStorage2.widgetEndIndex; ++i2) {
                int n17;
                boolean bl4;
                WidgetModel widgetModel = widgetModelArray[i2];
                if (!widgetModel.is_visible()) continue;
                boolean bl5 = bl4 = bl3 || (nArray2[i2 / 32] & n13) == 0;
                if (bl4) {
                    widgetModel.disableAnimations();
                }
                switch (n5) {
                    case 0: {
                        n17 = n12 + containerLayout$LayoutStorage2.coPosition;
                        break;
                    }
                    case 2: {
                        n17 = n12 + containerLayout$LayoutStorage2.coPosition + containerLayout$LayoutStorage2.coSize - (bl ? widgetModel.get_height() : widgetModel.get_width());
                        break;
                    }
                    case 3: {
                        n17 = n12 + n16 * n11 + n11 * n9;
                        break;
                    }
                    default: {
                        n17 = n12 + containerLayout$LayoutStorage2.coPosition + (containerLayout$LayoutStorage2.coSize >> 1) - ((bl ? widgetModel.get_height() : widgetModel.get_width()) >> 1);
                    }
                }
                int n18 = bl2 ? n2 - n10 - nArray3[i2] - nArray[i2] : n10 + nArray3[i2];
                if (bl) {
                    widgetModel.set_x(n18);
                    widgetModel.set_y(n17);
                    widgetModel.set_width(nArray[i2]);
                    if (n5 == 3) {
                        widgetModel.set_height(n16);
                    }
                } else {
                    widgetModel.set_y(n18);
                    widgetModel.set_x(n17);
                    widgetModel.set_height(nArray[i2]);
                    if (n5 == 3) {
                        widgetModel.set_width(n16);
                    }
                }
                if (bl4) {
                    widgetModel.enableAnimations();
                }
                n13 = n13 == 128 ? 1 : n13 << 1;
            }
        }
    }

    private static void performFlowLayoutWidgetPositions(WidgetModel[] widgetModelArray, boolean bl, int n, int n2, int n3, int n4, int n5, int n6, int[] nArray, int[] nArray2, boolean bl2) {
        int n7 = 0;
        int n8 = n5;
        boolean bl3 = (nArray2[0] & 1) == 0;
        int n9 = 2;
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            if (widgetModel.is_visible()) {
                int n10;
                boolean bl4;
                boolean bl5 = bl4 = bl3 || (nArray2[i2 / 32] & n9) == 0;
                if (bl4) {
                    widgetModel.disableAnimations();
                }
                int n11 = bl ? widgetModel.get_height() : widgetModel.get_width();
                switch (n) {
                    case 0: {
                        n7 = n3;
                        break;
                    }
                    case 3: {
                        n7 = n3;
                        ContainerLayout.performLayoutSetWidgetSize(widgetModel, !bl, n2 - n3 - n4);
                        break;
                    }
                    case 1: {
                        n7 = (n2 >> 1) - (n11 >> 1);
                        break;
                    }
                    case 2: {
                        n7 = n2 - n11 - n4;
                        break;
                    }
                    default: {
                        n7 = bl ? widgetModel.get_y() : widgetModel.get_x();
                    }
                }
                int n12 = n10 = bl2 ? n8 - nArray[i2] : n8;
                if (bl) {
                    widgetModel.set_x(n10);
                    widgetModel.set_y(n7);
                    widgetModel.set_width(Math.max(0, nArray[i2]));
                } else {
                    widgetModel.set_x(n7);
                    widgetModel.set_y(n10);
                    widgetModel.set_height(Math.max(0, nArray[i2]));
                }
                n8 = bl2 ? (n8 -= nArray[i2] + n6) : (n8 += nArray[i2] + n6);
                if (bl4) {
                    widgetModel.enableAnimations();
                }
            }
            n9 = n9 == 128 ? 1 : n9 << 1;
        }
    }

    private static void performFlowLayout(WidgetModel[] widgetModelArray, LayoutAttribs layoutAttribs, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, boolean bl, int[] nArray, boolean bl2, boolean bl3) {
        if (n > 0) {
            int n10 = layoutAttribs.getLayoutOrientation();
            boolean bl4 = n10 == 0 || n10 == 3 || n10 == 4 || n10 == 5;
            boolean bl5 = n2 == 3;
            int n11 = layoutAttribs.getGap();
            int n12 = n3 - n4 - n5 - (n - 1) * n11;
            int[] nArray2 = new int[widgetModelArray.length];
            int n13 = ContainerLayout.performFlowLayoutFixWidgetSizes(widgetModelArray, layoutAttribs, bl4, n12, bl5, nArray2, bl3);
            if (bl5) {
                ContainerLayout.performFlowLayoutVarWidgetSizes(widgetModelArray, layoutAttribs, bl4, n12 - n13, n, nArray2, bl3);
            }
            if (!bl) {
                int n14 = ContainerLayout.performLayoutCalcStartPosition(n2, n12, n13, n4, n5);
                if (bl2) {
                    n14 = n3 - n14;
                }
                ContainerLayout.performFlowLayoutWidgetPositions(widgetModelArray, bl4, n6, n7, n8, n9, n14, n11, nArray2, nArray, bl2);
            } else {
                ContainerLayout.performFlowLayoutWrapWidgetPositions(widgetModelArray, bl4, n2, n3, n4, n5, n6, n7, n8, n9, n11, nArray2, nArray, bl2);
            }
        }
    }

    public static void setAnimatedLayoutEnabled(boolean bl, int[] nArray) {
        if (nArray != null) {
            nArray[0] = bl ? nArray[0] | 1 : nArray[0] & 0xFFFFFFFE;
        }
    }

    private static void updateLayoutFlags(WidgetModel[] widgetModelArray, int[] nArray) {
        ContainerLayout.setAnimatedLayoutEnabled(true, nArray);
        int n = 2;
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            if (widgetModelArray[i2].is_visible()) {
                int n2 = i2 / 32;
                nArray[n2] = nArray[n2] | n;
            } else {
                int n3 = i2 / 32;
                nArray[n3] = nArray[n3] & ~n;
            }
            n = n == 128 ? 1 : n << 1;
        }
    }
}

