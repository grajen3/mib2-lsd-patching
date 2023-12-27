/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.models.SequencedImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import java.io.IOException;

public final class SequencedImageUI
extends AbstractImageUI {
    private ScaleImageDrawable[] imageDrawables;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        this.invalidateDrawables();
        this.imageDrawables = null;
        super.deInit();
    }

    @Override
    public void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        SequencedImageModel sequencedImageModel = (SequencedImageModel)widgetModel;
        Image[] imageArray = sequencedImageModel.get_sequenceImages();
        if (imageArray != null && imageArray.length > 0) {
            boolean bl;
            boolean bl2 = bl = this.imageDrawables == null || this.imageDrawables.length != imageArray.length;
            if (sequencedImageModel.isInvalid() || bl) {
                this.invalidateDrawables();
                if (bl) {
                    this.imageDrawables = new ScaleImageDrawable[imageArray.length];
                }
            }
            Drawable drawable = null;
            if (!sequencedImageModel.isImagefadingActive()) {
                drawable = this.getDrawable(graphics3D, sequencedImageModel, imageArray, sequencedImageModel.getActiveImageIndex());
                if (drawable != null) {
                    drawable.setColor(color4b);
                    drawable.setAlpha(f2);
                    drawable.draw();
                }
            } else {
                float[] fArray = sequencedImageModel.getAlphas();
                for (int i2 = 0; i2 < fArray.length; ++i2) {
                    if (fArray[i2] == 0.0f || (drawable = this.getDrawable(graphics3D, sequencedImageModel, imageArray, i2)) == null) continue;
                    drawable.setColor(color4b);
                    drawable.setAlpha(fArray[i2] * f2);
                    drawable.draw();
                }
            }
        } else if (this.imageDrawables != null) {
            this.invalidateDrawables();
            this.imageDrawables = null;
        }
    }

    private Drawable getDrawable(Graphics3D graphics3D, SequencedImageModel sequencedImageModel, Image[] imageArray, int n) {
        if (this.imageDrawables[n] == null) {
            try {
                this.imageDrawables[n] = SequencedImageUI.updateScaleImageDrawable(graphics3D, sequencedImageModel, this.imageDrawables[n], imageArray[n]);
            }
            catch (IOException iOException) {
                LogMessage logMessage = LOGGER.error(4);
                logMessage.append("Widget '").append(sequencedImageModel.getQualifiedName()).append("': Unable to load image (").append(imageArray[n]).append(") with index: [").append(n).append("]: ").append(iOException).log();
            }
        }
        return this.imageDrawables[n];
    }

    private void invalidateDrawables() {
        if (this.imageDrawables != null) {
            for (int i2 = this.imageDrawables.length - 1; i2 >= 0; --i2) {
                if (this.imageDrawables[i2] == null) continue;
                this.imageDrawables[i2].dispose();
                this.imageDrawables[i2] = null;
            }
        }
    }
}

