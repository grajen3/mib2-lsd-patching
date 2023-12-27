/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.AbstractBitmap
 */
package de.vw.mib.widgets.gem;

import de.audi.gem.AbstractBitmap;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.internal.ServiceManager;
import java.io.IOException;

public final class VWGEMBitmap
extends AbstractBitmap {
    private final Graphics3D g3d;
    private BufferImage image;
    private final Color4b defaultColor;
    private final Color4b selectedColor;
    private int x;
    private int y;
    private boolean selected;
    private boolean visible;
    private float scaleFactorX;
    private float scaleFactorY;
    private ImageDrawable imageDrawable;

    public VWGEMBitmap(Graphics3D graphics3D, ImageManager imageManager, String string) {
        this.g3d = graphics3D;
        try {
            this.image = imageManager.getImageFromCommonSkin(new StringBuffer().append("GEM/").append(string).toString());
            this.image.reference();
        }
        catch (IOException iOException) {
            Logger logger = ServiceManager.loggerFactory.getLogger(2048);
            LogMessage logMessage = logger.error(4);
            logMessage.append("VWGEMBitmap: Unable to load image (").append(string).append("): ").attachThrowable(iOException).log();
            this.image = null;
        }
        this.defaultColor = new Color4b(Color4b.WHITE);
        this.selectedColor = new Color4b(Color4b.WHITE);
        this.selected = false;
        this.visible = true;
        this.scaleFactorX = 1.0f;
        this.scaleFactorY = 1.0f;
        this.imageDrawable = null;
    }

    public int getWidth() {
        return this.image != null ? this.image.getWidth() : 0;
    }

    public int getHeight() {
        return this.image != null ? this.image.getHeight() : 0;
    }

    public int getDefaultColorRGBA() {
        return this.defaultColor.getRGBA();
    }

    public int getSelectedColorRGBA() {
        return this.selectedColor.getRGBA();
    }

    public void setColors(int n, int n2) {
        this.defaultColor.setRGBA(n);
        this.selectedColor.setRGBA(n2);
    }

    public int getPositionX() {
        return this.x;
    }

    public int getPositionY() {
        return this.y;
    }

    public void setPosition(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
    }

    public void draw() {
        if (this.isVisible()) {
            if (this.imageDrawable == null) {
                this.imageDrawable = this.g3d.getDrawableManager().createImageDrawable();
                this.imageDrawable.setImage(this.image);
                this.imageDrawable.setSourceWidth(this.getWidth());
                this.imageDrawable.setSourceHeight(this.getHeight());
                this.imageDrawable.setDestinationWidth((int)((float)this.getWidth() * this.scaleFactorX));
                this.imageDrawable.setDestinationHeight((int)((float)this.getHeight() * this.scaleFactorY));
            }
            this.imageDrawable.setColor(this.isSelected() ? this.selectedColor : this.defaultColor);
            this.imageDrawable.draw(this.getPositionX(), this.getPositionY());
        }
    }

    public void setScaleFactor(float f2, float f3) {
        this.scaleFactorX = f2;
        this.scaleFactorY = f3;
    }

    public void cleanUp() {
        if (this.imageDrawable != null) {
            this.imageDrawable.dispose();
            this.imageDrawable = null;
        }
        if (this.image != null) {
            this.image.dispose();
        }
    }
}

