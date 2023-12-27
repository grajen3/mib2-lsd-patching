/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.ContainerUI;
import java.io.IOException;

class ContainerUI$ReflectionDecorationHelper
implements DecoratableUI,
Disposable {
    private int absZ = 0;
    private int height;
    private ScaleImageDrawable reflectionAlphaImageDrawable = null;
    private final /* synthetic */ ContainerUI this$0;

    public ContainerUI$ReflectionDecorationHelper(ContainerUI containerUI, Graphics3D graphics3D, Rectangle rectangle) {
        this.this$0 = containerUI;
        this.updateAlphaImageDrawable(graphics3D, rectangle);
    }

    void setAbsZ(int n) {
        this.absZ = n;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public void drawDecoratableContent(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2) {
        ContainerModel containerModel = (ContainerModel)this.this$0.getWidget();
        if (containerModel.isInvalid() || this.reflectionAlphaImageDrawable == null) {
            this.updateAlphaImageDrawable(graphics3D, rectangle2);
        }
        if (this.reflectionAlphaImageDrawable != null) {
            int n = this.getHeight() - containerModel.get_height() - containerModel.get_reflectionDistance();
            graphics3D.translateMatrix(0, 0.0f, n, -this.absZ);
            rectangle2.translate(0, n);
            this.this$0.paintContainer(graphics3D, containerModel.getView(), containerModel, rectangle, rectangle2, 1.0f, false);
            graphics3D.scaleMatrix(0, 1.0f, 32959, 1.0f);
            ContainerUI.paintAlphaMaskDrawable(graphics3D, this.reflectionAlphaImageDrawable, 0, n - this.reflectionAlphaImageDrawable.getHeight(), 0.0f);
        }
    }

    @Override
    public void dispose() {
        if (this.reflectionAlphaImageDrawable != null) {
            this.reflectionAlphaImageDrawable.dispose();
            this.reflectionAlphaImageDrawable = null;
        }
    }

    private void updateAlphaImageDrawable(Graphics3D graphics3D, Rectangle rectangle) {
        ContainerModel containerModel = (ContainerModel)this.this$0.getWidget();
        try {
            this.reflectionAlphaImageDrawable = AbstractWidgetUI.updateScaleImageDrawable(graphics3D, containerModel, this.reflectionAlphaImageDrawable, containerModel.get_reflectionAlphaImage());
            if (this.reflectionAlphaImageDrawable != null) {
                BufferImage bufferImage = this.reflectionAlphaImageDrawable.getImage();
                this.reflectionAlphaImageDrawable.setColor(Color4f.WHITE);
                this.reflectionAlphaImageDrawable.setAlpha(1.0f);
                this.reflectionAlphaImageDrawable.setWidth(rectangle.width);
                this.reflectionAlphaImageDrawable.setHeight(bufferImage.getHeight());
                this.height = bufferImage.getHeight();
            } else {
                this.height = rectangle.height;
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = AbstractWidgetUI.LOGGER.error(4);
            logMessage.append("Unable to load image (").append(containerModel.get_reflectionAlphaImage()).append("): ").append(iOException).log();
            this.dispose();
        }
    }
}

