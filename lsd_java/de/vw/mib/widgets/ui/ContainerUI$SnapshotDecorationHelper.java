/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.ContainerUI;
import java.io.IOException;

class ContainerUI$SnapshotDecorationHelper
implements DecoratableUI,
Disposable {
    private int absZ;
    private int offsetX;
    private int offsetY;
    private ScaleImageDrawable snapShotAlphaImageDrawable;
    private final /* synthetic */ ContainerUI this$0;

    public ContainerUI$SnapshotDecorationHelper(ContainerUI containerUI) {
        this.this$0 = containerUI;
    }

    public void setAbsZ(int n) {
        this.absZ = n;
    }

    public void setOffset(int n, int n2) {
        this.offsetX = n;
        this.offsetY = n2;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    @Override
    public void drawDecoratableContent(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2) {
        ContainerModel containerModel = (ContainerModel)this.this$0.getWidget();
        ViewModel viewModel = containerModel.getView();
        graphics3D.translateMatrix(0, this.offsetX, this.offsetY, -this.absZ);
        this.this$0.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, 1.0f);
        if (containerModel.is_alphaImageEnabled()) {
            block5: {
                if (containerModel.isInvalid() || this.snapShotAlphaImageDrawable == null) {
                    try {
                        this.snapShotAlphaImageDrawable = AbstractWidgetUI.updateScaleImageDrawable(graphics3D, containerModel, this.snapShotAlphaImageDrawable, containerModel.get_alphaImage(), rectangle2.getWidth(), rectangle2.getHeight());
                    }
                    catch (IOException iOException) {
                        LogMessage logMessage = AbstractWidgetUI.LOGGER.error(4);
                        logMessage.append("Unable to load image (").append(containerModel.get_alphaImage()).append("): ").append(iOException).log();
                        if (this.snapShotAlphaImageDrawable == null) break block5;
                        this.snapShotAlphaImageDrawable.dispose();
                        this.snapShotAlphaImageDrawable = null;
                    }
                }
            }
            if (this.snapShotAlphaImageDrawable != null) {
                ContainerUI.paintAlphaMaskDrawable(graphics3D, this.snapShotAlphaImageDrawable, containerModel.get_width() - rectangle2.getWidth() >> 1, containerModel.get_height() - rectangle2.getHeight() >> 1, containerModel.getAlphaImageRotation());
            }
        }
    }

    @Override
    public void dispose() {
        if (this.snapShotAlphaImageDrawable != null) {
            this.snapShotAlphaImageDrawable.dispose();
            this.snapShotAlphaImageDrawable = null;
        }
    }
}

