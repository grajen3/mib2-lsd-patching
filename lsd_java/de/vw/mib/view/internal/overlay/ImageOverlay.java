/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.overlay.AbstractOverlay;

public class ImageOverlay
extends AbstractOverlay {
    private BufferImage image;
    private boolean centerImage;
    private ImageDrawable imageDrawable;
    private boolean imageDrawableValid;

    public ImageOverlay(Logger logger, Graphics3D graphics3D, String string) {
        super(logger, graphics3D, string);
    }

    @Override
    public void dispose() {
        if (this.imageDrawable != null) {
            this.imageDrawable.dispose();
            this.imageDrawable = null;
        }
        super.dispose();
    }

    public final BufferImage getImage() {
        return this.image;
    }

    public final void setImage(BufferImage bufferImage) {
        this.image = bufferImage;
        this.imageDrawableValid = false;
    }

    public final boolean isCenterImage() {
        return this.centerImage;
    }

    public final void setCenterImage(boolean bl) {
        this.centerImage = bl;
    }

    @Override
    public final void draw() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (!this.imageDrawableValid) {
            if (this.imageDrawable == null) {
                this.imageDrawable = graphics3D.getDrawableManager().createImageDrawable();
            }
            this.imageDrawable.setImage(this.image);
            this.imageDrawable.setSourceWidth(this.image.getWidth());
            this.imageDrawable.setSourceHeight(this.image.getHeight());
            this.imageDrawable.setDestinationWidth(this.image.getWidth());
            this.imageDrawable.setDestinationHeight(this.image.getHeight());
            this.imageDrawableValid = true;
        }
        graphics3D.resetMatrix(0);
        this.imageDrawable.draw(this.centerImage ? (float)(this.getX() - (this.imageDrawable.getSourceWidth() >> 1)) : (float)this.getX(), this.centerImage ? (float)(this.getY() - (this.imageDrawable.getSourceHeight() >> 1)) : (float)this.getY());
    }
}

