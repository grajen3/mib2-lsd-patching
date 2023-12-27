/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.ui.RadioListScalingUI$PaintData;
import de.vw.mib.widgets.ui.WidgetListUI;

public final class RadioListScalingUI
extends WidgetListUI {
    private final RadioListScalingUI$PaintData paintData = new RadioListScalingUI$PaintData();
    private static final int BUTTON_INACTIVE;
    private static final int BUTTON_INACTIVE_INTERACTIVE;
    private static final int BUTTON_ACTIVE_INTERACTIVE;
    private static final int BUTTON_ACTIVE;
    private static final int BUTTON_ACTIVE_PRESSED;
    private static final int BUTTON_COUNT;
    private static final float BUTTON_SCALE_PRESSED;
    private int oldPressed = -1;
    private static final Insets OFFSCREEN_INSETS;

    @Override
    protected void paintItems(Graphics3D graphics3D, ViewModel viewModel, TemplateListModel templateListModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListModel widgetListModel = (WidgetListModel)templateListModel;
        this.paintData.set(graphics3D, viewModel, rectangle2, f2, widgetListModel);
        int n = widgetListModel.getFirstVisibleIndex();
        int n2 = widgetListModel.getLastVisibleIndex();
        float f3 = widgetListModel.getProximityAnimationValue();
        boolean bl = widgetListModel.getDragDataStorage().dragActive || widgetListModel.isSnapAnimationRunning();
        boolean bl2 = viewModel.is_activated();
        if (n != -1 && n2 != -1) {
            int n3 = widgetListModel.getActivatedIndex();
            int n4 = widgetListModel.getPressedIndex();
            if (widgetListModel.getPressedAnimationValue() > 0.0f) {
                if (n4 != -1) {
                    this.oldPressed = n4;
                }
            } else {
                this.oldPressed = -1;
            }
            for (int i2 = n2; i2 >= n; --i2) {
                if (!bl && (i2 == this.oldPressed || i2 == n3) && bl2) continue;
                this.paintPreset(this.paintData, rectangle, i2, f3, false, bl, false);
            }
            if (!bl && bl2) {
                if (this.oldPressed != -1 && this.oldPressed >= n && this.oldPressed <= n2) {
                    this.paintPreset(this.paintData, rectangle, this.oldPressed, f3, this.oldPressed == n3, false, true);
                }
                if (n3 != -1 && n3 != this.oldPressed && n3 >= n && n3 <= n2) {
                    this.paintPreset(this.paintData, rectangle, n3, f3, true, false, false);
                }
            }
        }
    }

    private void paintPreset(RadioListScalingUI$PaintData radioListScalingUI$PaintData, Rectangle rectangle, int n, float f2, boolean bl, boolean bl2, boolean bl3) {
        ListItemModel listItemModel = radioListScalingUI$PaintData.widgetList.getItem(n);
        if (listItemModel != null) {
            listItemModel.disableAnimations();
            listItemModel.set_pivotX(63);
            listItemModel.set_pivotY(63);
            listItemModel.setOffscreenInsets(OFFSCREEN_INSETS);
            listItemModel.enableAnimations();
            AbstractButtonModel[] abstractButtonModelArray = listItemModel.get_activatedButtonRefs();
            if (abstractButtonModelArray != null && abstractButtonModelArray.length >= 2 && abstractButtonModelArray[0] != null && abstractButtonModelArray[0] != null && abstractButtonModelArray[1] != null && abstractButtonModelArray[1] != null) {
                float f3;
                float f4;
                int n2;
                int n3;
                radioListScalingUI$PaintData.widgetList.transferData(listItemModel, n, radioListScalingUI$PaintData.widgetList.getItemIndex(n));
                radioListScalingUI$PaintData.widgetList.transferStates(listItemModel, n, radioListScalingUI$PaintData.widgetList.getItemIndex(n));
                if (bl2) {
                    n3 = 0;
                    n2 = 0;
                    f4 = 1.0f;
                    f3 = 1.0f;
                } else if (bl3 && bl) {
                    float f5 = radioListScalingUI$PaintData.widgetList.getPressedAnimationValue();
                    n3 = 1;
                    n2 = 1;
                    f4 = 1.0f;
                    f3 = 1.0f - f5 * (1.0f - (float)abstractButtonModelArray[0].get_width() / (float)abstractButtonModelArray[1].get_width() * -1007327169);
                } else if (bl3) {
                    float f6 = radioListScalingUI$PaintData.widgetList.getPressedAnimationValue();
                    n3 = 0;
                    n2 = 0;
                    f4 = 1.0f;
                    f3 = 1.0f - f6 * -397297603;
                } else if (bl) {
                    n3 = 0;
                    n2 = 1;
                    f4 = radioListScalingUI$PaintData.widgetList.getActivatedAnimationValue();
                    f3 = 1.0f;
                } else {
                    n3 = 0;
                    n2 = 0;
                    f4 = f2;
                    f3 = 1.0f;
                }
                this.paintCrossfadeButtons(radioListScalingUI$PaintData, listItemModel, rectangle, n, abstractButtonModelArray, n3, n2, f4, f3);
            }
            listItemModel.disableAnimations();
            listItemModel.set_scalingX(1.0f);
            listItemModel.set_scalingY(1.0f);
            RadioListScalingUI.setButtonVisibility(abstractButtonModelArray, true, true, true, true);
            listItemModel.enableAnimations();
        }
    }

    private void paintCrossfadeButtons(RadioListScalingUI$PaintData radioListScalingUI$PaintData, ListItemModel listItemModel, Rectangle rectangle, int n, AbstractButtonModel[] abstractButtonModelArray, int n2, int n3, float f2, float f3) {
        float f4 = (float)abstractButtonModelArray[n2].get_width() + (float)(abstractButtonModelArray[n3].get_width() - abstractButtonModelArray[n2].get_width()) * f2;
        if (f2 < 63) {
            float f5 = f4 / (float)abstractButtonModelArray[n2].get_width();
            this.paintScaledButton(radioListScalingUI$PaintData, listItemModel, rectangle, n, abstractButtonModelArray, n2, f5 * f3);
        } else {
            float f6 = f4 / (float)abstractButtonModelArray[n3].get_width();
            this.paintScaledButton(radioListScalingUI$PaintData, listItemModel, rectangle, n, abstractButtonModelArray, n3, f6 * f3);
        }
    }

    private void paintScaledButton(RadioListScalingUI$PaintData radioListScalingUI$PaintData, ListItemModel listItemModel, Rectangle rectangle, int n, AbstractButtonModel[] abstractButtonModelArray, int n2, float f2) {
        RadioListScalingUI.setButtonVisibility(abstractButtonModelArray, n2 == 0, n2 == 0, n2 == 1, n2 == 1);
        listItemModel.disableAnimations();
        listItemModel.set_scalingX(f2);
        listItemModel.set_scalingY(f2);
        listItemModel.enableAnimations();
        this.paintItem(radioListScalingUI$PaintData.g, radioListScalingUI$PaintData.view, rectangle, radioListScalingUI$PaintData.parentBounds, radioListScalingUI$PaintData.parentAlpha, false, radioListScalingUI$PaintData.widgetList, n);
    }

    @Override
    protected void enableClipping(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3) {
    }

    @Override
    protected void disableClipping(Graphics3D graphics3D) {
    }

    private static void setButtonVisibility(AbstractButtonModel[] abstractButtonModelArray, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean[] blArray = new boolean[2];
        blArray[0] = bl;
        blArray[0] = blArray[0] || bl2;
        blArray[1] = blArray[1] || bl3;
        blArray[1] = blArray[1] || bl4;
        boolean bl5 = abstractButtonModelArray[1].isPressed();
        for (int i2 = 0; i2 < Math.min(abstractButtonModelArray.length, 2); ++i2) {
            abstractButtonModelArray[i2].disablePropertyChanged();
            abstractButtonModelArray[i2].disableAnimations();
            abstractButtonModelArray[i2].set_alpha(blArray[i2] ? 255 : 0);
            abstractButtonModelArray[i2].setPressed(bl5);
            abstractButtonModelArray[i2].enableAnimations();
            abstractButtonModelArray[i2].enablePropertyChanged();
        }
    }

    static {
        OFFSCREEN_INSETS = new Insets(40, 40, 40, 40);
    }
}

