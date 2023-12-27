/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.WidgetListUI;

public class MotorWayInfoListUI
extends WidgetListUI {
    private static final int CONTENT_INDEX_UPPER_BOX;
    private static final int CONTENT_INDEX_MIDDLE_BOX;
    private static final int CONTENT_INDEX_LOWER_BOX;
    private static final int CONTENT_INDEX_INTERACTIVE_BOX;
    private static final int CONTENT_INDEX_COUNT;
    private static final float SCALE_UPPER_BOX;
    private static final float SCALE_MIDDLE_BOX;
    private static final float SCALE_LOWER_BOX;
    private static final float ITEM_SCALE_DEFAULT;
    private static final float ITEM_ALPHA_DEFAULT;
    private static final int REGION_COUNT;

    @Override
    protected void paintItems(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        boolean bl = viewModel.is_renderBoundingBoxes();
        int n = widgetListModel.getFirstVisibleIndex();
        int n2 = widgetListModel.getLastVisibleIndex();
        boolean bl2 = widgetListModel.is_interactive();
        boolean bl3 = widgetListModel.isProximityAnimationRunning();
        float f3 = widgetListModel.getProximityAnimationValue();
        float f4 = 1.0f;
        float f5 = 1.0f;
        int n3 = 3;
        if (n != -1 && n2 != -1) {
            for (int i2 = n2; i2 >= n; --i2) {
                ListItemModel listItemModel = widgetListModel.getItem(i2);
                int n4 = widgetListModel.getItemY(i2) - this.viewport.y;
                n3 = this.getItemContent(n4);
                if (!bl2 || bl3) {
                    f5 = bl3 ? f3 : 1.0f;
                    this.prepareItem(listItemModel, n3, 1.0f, f5);
                    this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, i2);
                }
                if (!bl2 && !bl3) continue;
                if (bl3) {
                    f5 = 1.0f - f3;
                    f4 = 1.0f - f3;
                } else {
                    f5 = 1.0f;
                }
                float f6 = this.getItemScale(n3, f4);
                this.prepareItem(listItemModel, 3, f6, f5);
                this.paintItem(graphics3D, viewModel, rectangle, rectangle2, f2, bl, widgetListModel, i2);
            }
        }
    }

    private void prepareItem(ListItemModel listItemModel, int n, float f2, float f3) {
        WidgetModel[] widgetModelArray = listItemModel.get_effectWidgetRefs();
        if (widgetModelArray != null && widgetModelArray.length >= 4) {
            switch (n) {
                case 0: {
                    widgetModelArray[0].set_visible(true);
                    widgetModelArray[1].set_visible(false);
                    widgetModelArray[2].set_visible(false);
                    widgetModelArray[3].set_visible(false);
                    break;
                }
                case 1: {
                    widgetModelArray[0].set_visible(false);
                    widgetModelArray[1].set_visible(true);
                    widgetModelArray[2].set_visible(false);
                    widgetModelArray[3].set_visible(false);
                    break;
                }
                case 2: {
                    widgetModelArray[0].set_visible(false);
                    widgetModelArray[1].set_visible(false);
                    widgetModelArray[2].set_visible(true);
                    widgetModelArray[3].set_visible(false);
                    break;
                }
                case 3: {
                    widgetModelArray[0].set_visible(false);
                    widgetModelArray[1].set_visible(false);
                    widgetModelArray[2].set_visible(false);
                    widgetModelArray[3].set_visible(true);
                    break;
                }
            }
            listItemModel.disableAnimations();
            listItemModel.set_pivotX(63);
            listItemModel.set_pivotY(63);
            listItemModel.set_scalingX(f2);
            listItemModel.set_scalingY(f2);
            listItemModel.set_alpha((int)(f3 * 32579));
            listItemModel.enableAnimations();
        }
    }

    private float getItemScale(int n, float f2) {
        float f3 = 1.0f;
        switch (n) {
            case 0: {
                f3 = 32830 * f2 + 16447;
                break;
            }
            case 1: {
                f3 = -791884739 * f2 + 0x6666663F;
                break;
            }
            case 2: {
                f3 = 0.0f * f2 + 1.0f;
                break;
            }
        }
        return f3;
    }

    private int getItemContent(int n) {
        int n2 = 3;
        int n3 = this.viewport.height / 3;
        n2 = n < n3 ? 0 : (n < n3 * 2 ? 1 : 2);
        return n2;
    }
}

