/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.ContainerUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class InactiveAreaUI
extends ContainerUI {
    private static final int STENCIL_BUFFER_MASK_ON;
    private static final int STENCIL_BUFFER_CLEAR_VALUE;
    private static final int STENCIL_BUFFER_MASK_OFF;
    private final Rectangle focusableClipArea = new Rectangle();
    private int oldStencilBufferEnabled;
    private boolean oldRedBufferEnabled;
    private boolean oldGreenBufferEnabled;
    private boolean oldBlueBufferEnabled;
    private boolean oldAlphaBufferEnabled;
    private boolean oldStencilTestEnabled;
    private int oldStencilTestFunc;
    private int oldStencilTestMask;
    private int oldStencilTestRefValue;
    private int oldStencilOpZPass;
    private int oldStencilOpZFail;
    private int oldStencilOpFail;
    private RectangleDrawable[] rectDrawables;

    @Override
    public void deInit() {
        InactiveAreaUI.disposeDrawables(this.rectDrawables);
        this.rectDrawables = null;
        super.deInit();
    }

    protected boolean areExclusionAreasAvailable() {
        InactiveAreaModel inactiveAreaModel = (InactiveAreaModel)this.getWidget();
        ArrayList arrayList = new ArrayList();
        arrayList.add(inactiveAreaModel.get_exclusionArea());
        if (inactiveAreaModel.getAdditionalExclusionAreas() != null) {
            arrayList.addAll(Arrays.asList(inactiveAreaModel.getAdditionalExclusionAreas()));
        }
        boolean bl = false;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Rectangle rectangle = (Rectangle)iterator.next();
            bl = bl || rectangle != null && rectangle.getHeight() != 0 && rectangle.getWidth() != 0;
        }
        return bl;
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        InactiveAreaModel inactiveAreaModel = (InactiveAreaModel)widgetModel;
        boolean bl = this.areExclusionAreasAvailable();
        if (bl) {
            this.updateRectanlgeDrawables(graphics3D, inactiveAreaModel);
            if (this.rectDrawables != null) {
                this.saveOldBufferParams(graphics3D);
                graphics3D.setStencilBufferEnabled(1);
                graphics3D.clearStencilBuffer(0);
                graphics3D.setColorBufferEnabled(false, false, false, false);
                graphics3D.setStencilTestEnabled(true);
                graphics3D.setStencilTest(7, 1, 1);
                graphics3D.setStencilOperation(2, 2, 2);
                for (int i2 = 0; i2 < this.rectDrawables.length; ++i2) {
                    if (this.rectDrawables[i2] == null) continue;
                    this.rectDrawables[i2].draw();
                }
                graphics3D.setColorBufferEnabled(true, true, true, true);
                graphics3D.setStencilBufferEnabled(0);
                graphics3D.setStencilTest(6, 1, 1);
            } else {
                bl = !bl;
            }
        }
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        if (bl) {
            this.restoreOldBufferParams(graphics3D);
        }
        if (inactiveAreaModel.isFocusActive()) {
            Focusable focusable = inactiveAreaModel.getFocusedWidget();
            int n = focusable.getAbsX();
            int n2 = focusable.getAbsY();
            this.focusableClipArea.setBounds(n, n2, focusable.get_width(), focusable.get_height());
            graphics3D.pushMatrix(0);
            graphics3D.translateMatrix(0, n - widgetModel.getAbsX(), n2 - widgetModel.getAbsY(), 0.0f);
            focusable.paintFocused(graphics3D, viewModel, rectangle, this.focusableClipArea, AbstractWidgetUI.normalizeAlpha(focusable.get_alpha()));
            graphics3D.popMatrix(0);
        }
    }

    private void restoreOldBufferParams(Graphics3D graphics3D) {
        graphics3D.setStencilBufferEnabled(this.oldStencilBufferEnabled);
        graphics3D.setColorBufferEnabled(this.oldRedBufferEnabled, this.oldGreenBufferEnabled, this.oldBlueBufferEnabled, this.oldAlphaBufferEnabled);
        graphics3D.setStencilTestEnabled(this.oldStencilTestEnabled);
        graphics3D.setStencilTest(this.oldStencilTestFunc, this.oldStencilTestRefValue, this.oldStencilTestMask);
        graphics3D.setStencilOperation(this.oldStencilOpFail, this.oldStencilOpZFail, this.oldStencilOpZPass);
    }

    private void saveOldBufferParams(Graphics3D graphics3D) {
        this.oldStencilBufferEnabled = graphics3D.isStencilBufferEnabled();
        this.oldRedBufferEnabled = graphics3D.isColorBufferRedChannelEnabled();
        this.oldGreenBufferEnabled = graphics3D.isColorBufferGreenChannelEnabled();
        this.oldBlueBufferEnabled = graphics3D.isColorBufferBlueChannelEnabled();
        this.oldAlphaBufferEnabled = graphics3D.isColorBufferAlphaChannelEnabled();
        this.oldStencilTestEnabled = graphics3D.isStencilTestEnabled();
        this.oldStencilTestFunc = graphics3D.getStencilTestFunction();
        this.oldStencilTestMask = graphics3D.getStencilTestMask();
        this.oldStencilTestRefValue = graphics3D.getStencilTestReferenceValue();
        this.oldStencilOpZPass = graphics3D.getStencilZPassOperation();
        this.oldStencilOpZFail = graphics3D.getStencilZFailOperation();
        this.oldStencilOpFail = graphics3D.getStencilFailOperation();
    }

    private void updateRectanlgeDrawables(Graphics3D graphics3D, InactiveAreaModel inactiveAreaModel) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(inactiveAreaModel.get_exclusionArea());
        if (inactiveAreaModel.getAdditionalExclusionAreas() != null) {
            arrayList.addAll(Arrays.asList(inactiveAreaModel.getAdditionalExclusionAreas()));
        }
        if (this.rectDrawables == null || this.rectDrawables.length != arrayList.size()) {
            if (this.rectDrawables != null) {
                InactiveAreaUI.disposeDrawables(this.rectDrawables);
                this.rectDrawables = null;
            }
            this.rectDrawables = new RectangleDrawable[arrayList.size()];
        }
        for (int i2 = 0; i2 < this.rectDrawables.length; ++i2) {
            this.rectDrawables[i2] = InactiveAreaUI.updateRectangleDrawable(graphics3D, inactiveAreaModel, this.rectDrawables[i2], (Rectangle)arrayList.get(i2));
        }
    }
}

