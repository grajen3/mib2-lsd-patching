/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.CommonImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import java.io.IOException;

public class CommonImageUI
extends AbstractImageUI {
    private ImageDrawable imageDrawable;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.imageDrawable != null) {
            this.imageDrawable.dispose();
            this.imageDrawable = null;
        }
        super.deInit();
    }

    @Override
    public void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        CommonImageModel commonImageModel = (CommonImageModel)widgetModel;
        if (commonImageModel.isInvalid() || this.imageDrawable == null) {
            String string = commonImageModel.get_imageFile();
            if (string != null && string.length() > 0) {
                try {
                    int n;
                    int n2;
                    int n3;
                    int n4;
                    BufferImage bufferImage = commonImageModel.get_imageType() == 1 ? SkinHelper.getCarSpecificImageFromCommonSkin(string, 3) : ServiceManager.imageManager.getImageFromCommonSkin(string);
                    if (commonImageModel.get_scaleMode() == 1) {
                        float f3 = Math.min((float)commonImageModel.get_height() / (float)bufferImage.getHeight(), (float)commonImageModel.get_width() / (float)bufferImage.getWidth());
                        n4 = (int)((float)bufferImage.getWidth() * f3);
                        n3 = (int)((float)bufferImage.getHeight() * f3);
                        n2 = (commonImageModel.get_width() >> 1) - (n4 >> 1);
                        n = (commonImageModel.get_height() >> 1) - (n3 >> 1);
                    } else {
                        n2 = (commonImageModel.get_width() >> 1) - (bufferImage.getWidth() >> 1);
                        n = (commonImageModel.get_height() >> 1) - (bufferImage.getHeight() >> 1);
                        n4 = bufferImage.getWidth();
                        n3 = bufferImage.getHeight();
                    }
                    if (this.imageDrawable == null) {
                        this.imageDrawable = graphics3D.getDrawableManager().createImageDrawable();
                    }
                    boolean bl = commonImageModel.get_imageType() == 0;
                    this.imageDrawable.setImage(bufferImage);
                    this.imageDrawable.setImageFilter(bl ? 1 : 0);
                    this.imageDrawable.setSourceWidth(bufferImage.getWidth());
                    this.imageDrawable.setSourceHeight(bufferImage.getHeight());
                    this.imageDrawable.setDestinationX(n2);
                    this.imageDrawable.setDestinationY(n);
                    this.imageDrawable.setDestinationWidth(n4);
                    this.imageDrawable.setDestinationHeight(n3);
                }
                catch (IOException iOException) {
                    LogMessage logMessage = LOGGER.error(4);
                    logMessage.append("Widget '").append(widgetModel.getQualifiedName()).append("': Unable to load common image '").append(string).append("': ").append(iOException).log();
                }
            } else if (this.imageDrawable != null) {
                this.imageDrawable.dispose();
                this.imageDrawable = null;
            }
        }
        if (this.imageDrawable != null) {
            this.imageDrawable.setAlpha(f2);
            this.imageDrawable.draw();
        }
    }
}

