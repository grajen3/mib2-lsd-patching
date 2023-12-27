/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui.util;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.interfaces.CompositeBackground;
import de.vw.mib.widgets.internal.ServiceManager;
import java.io.IOException;

public final class BackgroundCompositor
implements Disposable {
    private static final Logger LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    private static float ALPHA_MASK_TRESHOLD = -1701209794;
    private Rectangle arrowArea = new Rectangle();
    private Rectangle oldScissor = new Rectangle();
    private Rectangle clippingArea = new Rectangle();
    private ScaleImageDrawable drawableBorderBackground;
    private ScaleImageDrawable drawableBorderArrow;
    private ScaleImageDrawable drawableMaskBackground;
    private ScaleImageDrawable drawableMaskArrow;
    private ScaleImageDrawable drawableBackground;

    @Override
    public void dispose() {
        if (this.drawableBorderBackground != null) {
            this.drawableBorderBackground.dispose();
            this.drawableBorderBackground = null;
        }
        if (this.drawableBorderArrow != null) {
            this.drawableBorderArrow.dispose();
            this.drawableBorderArrow = null;
        }
        if (this.drawableMaskBackground != null) {
            this.drawableMaskBackground.dispose();
            this.drawableMaskBackground = null;
        }
        if (this.drawableMaskArrow != null) {
            this.drawableMaskArrow.dispose();
            this.drawableMaskArrow = null;
        }
        if (this.drawableBackground != null) {
            this.drawableBackground.dispose();
            this.drawableBackground = null;
        }
    }

    public void paintCompositeBackground(Graphics3D graphics3D, CompositeBackground compositeBackground, Rectangle rectangle, Rectangle rectangle2, float f2) {
        Image[] imageArray;
        int n = compositeBackground.get_compositeBackgroundMode();
        if (n != 0 && (imageArray = compositeBackground.get_compositeBackgroundImages()) != null) {
            if (n == 6) {
                this.paintSimple(graphics3D, compositeBackground, rectangle, rectangle2, imageArray, f2);
            } else {
                this.paintStencil(graphics3D, compositeBackground, rectangle, rectangle2, imageArray, f2);
            }
        }
    }

    private Color getColor(CompositeBackground compositeBackground, int n) {
        Color[] colorArray = compositeBackground.get_compositeBackgroundColors();
        return colorArray != null && colorArray.length > n ? colorArray[n] : Color.WHITE;
    }

    private void paintSimple(Graphics3D graphics3D, CompositeBackground compositeBackground, Rectangle rectangle, Rectangle rectangle2, Image[] imageArray, float f2) {
        if (imageArray.length > 0) {
            this.updateDrawables(graphics3D, compositeBackground, imageArray, true);
            Rectangle rectangle3 = compositeBackground.getBackgroundArea();
            if (this.drawableBackground != null) {
                this.drawableBackground.setWidth(rectangle3.width);
                this.drawableBackground.setHeight(rectangle3.height);
                this.drawableBackground.setAlpha(f2);
                this.drawableBackground.setColor(this.getColor(compositeBackground, 0).getCurrentColor());
                this.drawableBackground.draw(rectangle3.x, rectangle3.y);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void paintStencil(Graphics3D graphics3D, CompositeBackground compositeBackground, Rectangle rectangle, Rectangle rectangle2, Image[] imageArray, float f2) {
        if (imageArray.length == 5) {
            this.updateDrawables(graphics3D, compositeBackground, imageArray, false);
            Rectangle rectangle3 = compositeBackground.getBackgroundArea();
            Point point = compositeBackground.getArrowPosition();
            this.clippingArea.setBounds(rectangle3);
            boolean bl = graphics3D.isAlphaTestEnabled();
            boolean bl2 = graphics3D.isScissorTestEnabled();
            boolean bl3 = graphics3D.isStencilTestEnabled();
            try {
                if (compositeBackground.get_compositeBackgroundMode() != 1) {
                    this.arrowArea.setLocation(point.x + compositeBackground.get_compositeBackgroundArrowOffsetX(), point.y + compositeBackground.get_compositeBackgroundArrowOffsetY());
                    ScaleImage scaleImage = imageArray[4].getCurrentImage();
                    try {
                        BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
                        this.arrowArea.setSize(bufferImage.getWidth(), bufferImage.getHeight());
                        this.extendClippingAreaWithArrow();
                    }
                    catch (IOException iOException) {
                        LogMessage logMessage = LOGGER.error(1);
                        logMessage.append("Widget '").append(compositeBackground).append("': Unable to load composite background image: ").append(iOException).log();
                    }
                }
                this.clippingArea.translate(rectangle2.x, rectangle2.y);
                graphics3D.setScissorTestEnabled(true);
                graphics3D.getScissor(this.oldScissor);
                if (AbstractWidget.DIRTY_REGION_MANAGEMENT) {
                    graphics3D.setScissor(rectangle.intersection(this.clippingArea));
                } else {
                    graphics3D.setScissor(this.clippingArea);
                }
                if (this.drawableBorderBackground != null) {
                    this.drawableBorderBackground.setColor(this.getColor(compositeBackground, 3).getCurrentColor());
                    this.drawableBorderBackground.setAlpha(f2);
                    this.drawableBorderBackground.setWidth(rectangle3.width);
                    this.drawableBorderBackground.setHeight(rectangle3.height);
                    this.drawableBorderBackground.draw(rectangle3.x, rectangle3.y);
                }
                if (this.drawableBorderArrow != null) {
                    this.drawableBorderArrow.setColor(this.getColor(compositeBackground, 4).getCurrentColor());
                    this.drawableBorderArrow.setAlpha(f2);
                    this.drawableBorderArrow.draw(this.arrowArea.x, this.arrowArea.y);
                }
                graphics3D.setColorBufferEnabled(false, false, false, false);
                graphics3D.setAlphaTestEnabled(true);
                graphics3D.setAlphaTest(4, ALPHA_MASK_TRESHOLD);
                graphics3D.setStencilBufferEnabled(1);
                graphics3D.clearStencilBuffer(0);
                graphics3D.setStencilTestEnabled(true);
                graphics3D.setStencilTest(7, 1, 1);
                graphics3D.setStencilOperation(2, 2, 2);
                if (this.drawableMaskBackground != null) {
                    this.drawableMaskBackground.setWidth(rectangle3.width);
                    this.drawableMaskBackground.setHeight(rectangle3.height);
                    this.drawableMaskBackground.draw(rectangle3.x, rectangle3.y);
                }
                if (this.drawableMaskArrow != null) {
                    this.drawableMaskArrow.draw(this.arrowArea.x, this.arrowArea.y);
                }
                graphics3D.setAlphaTestEnabled(false);
                graphics3D.setColorBufferEnabled(true, true, true, true);
                graphics3D.setStencilBufferEnabled(0);
                graphics3D.setStencilTest(2, 1, 1);
                if (this.drawableBackground != null) {
                    this.drawableBackground.setColor(this.getColor(compositeBackground, 0).getCurrentColor());
                    this.drawableBackground.setAlpha(f2);
                    this.drawableBackground.setWidth(rectangle3.width);
                    this.drawableBackground.setHeight(rectangle3.height);
                    this.drawableBackground.draw(rectangle3.x, rectangle3.y);
                }
            }
            finally {
                graphics3D.setAlphaTestEnabled(bl);
                graphics3D.setScissorTestEnabled(bl2);
                graphics3D.setScissor(this.oldScissor);
                graphics3D.setStencilTestEnabled(bl3);
            }
        }
    }

    private void updateDrawables(Graphics3D graphics3D, CompositeBackground compositeBackground, Image[] imageArray, boolean bl) {
        if (this.drawableBackground == null || this.drawableBackground.getImage() == null) {
            this.drawableBackground = BackgroundCompositor.updateDrawable(graphics3D, compositeBackground, imageArray[0].getCurrentImage(), 0, 0, this.drawableBackground);
        }
        if (!bl) {
            if (this.drawableBorderBackground == null || this.drawableBorderBackground.getImage() == null) {
                this.drawableBorderBackground = BackgroundCompositor.updateDrawable(graphics3D, compositeBackground, imageArray[3].getCurrentImage(), 0, 0, this.drawableBorderBackground);
            }
            if (compositeBackground.get_compositeBackgroundMode() != 1) {
                if (this.drawableBorderArrow == null || this.drawableBorderArrow.getImage() == null) {
                    this.drawableBorderArrow = BackgroundCompositor.updateDrawable(graphics3D, compositeBackground, imageArray[4].getCurrentImage(), 0, 0, this.drawableBorderArrow);
                }
                if (this.drawableMaskArrow == null || this.drawableMaskArrow.getImage() == null) {
                    this.drawableMaskArrow = BackgroundCompositor.updateDrawable(graphics3D, compositeBackground, imageArray[2].getCurrentImage(), 0, 0, this.drawableMaskArrow);
                }
            } else {
                if (this.drawableBorderArrow != null) {
                    this.drawableBorderArrow.dispose();
                    this.drawableBorderArrow = null;
                }
                if (this.drawableMaskArrow != null) {
                    this.drawableMaskArrow.dispose();
                    this.drawableMaskArrow = null;
                }
            }
            if (this.drawableMaskBackground == null || this.drawableMaskBackground.getImage() == null) {
                this.drawableMaskBackground = BackgroundCompositor.updateDrawable(graphics3D, compositeBackground, imageArray[1].getCurrentImage(), 0, 0, this.drawableMaskBackground);
            }
        }
    }

    private static ScaleImageDrawable updateDrawable(Graphics3D graphics3D, CompositeBackground compositeBackground, ScaleImage scaleImage, int n, int n2, ScaleImageDrawable scaleImageDrawable) {
        boolean bl = scaleImage.isEmpty();
        if (!scaleImage.isEmpty()) {
            try {
                BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
                if (scaleImageDrawable == null) {
                    scaleImageDrawable = graphics3D.getDrawableManager().createScaleImageDrawable();
                }
                scaleImageDrawable.setImage(bufferImage);
                scaleImageDrawable.setScaleImage(scaleImage);
                scaleImageDrawable.setWidth(n > 0 ? n : bufferImage.getWidth());
                scaleImageDrawable.setHeight(n2 > 0 ? n2 : bufferImage.getHeight());
            }
            catch (IOException iOException) {
                bl = true;
                LogMessage logMessage = LOGGER.error(4);
                logMessage.append("Widget '").append(compositeBackground).append("': Unable to load image (").append(scaleImage).append("): ").append(iOException).log();
            }
        }
        if (scaleImageDrawable != null && bl) {
            scaleImageDrawable.dispose();
            scaleImageDrawable = null;
        }
        return scaleImageDrawable;
    }

    private void extendClippingAreaWithArrow() {
        int n = this.clippingArea.x >= this.arrowArea.x ? this.arrowArea.x : this.clippingArea.x;
        int n2 = this.clippingArea.y >= this.arrowArea.y ? this.arrowArea.y : this.clippingArea.y;
        int n3 = this.clippingArea.x + this.clippingArea.width;
        int n4 = this.arrowArea.x + this.arrowArea.width;
        int n5 = n3 <= n4 ? n4 : n3;
        n3 = this.clippingArea.y + this.clippingArea.height;
        n4 = this.arrowArea.y + this.arrowArea.height;
        int n6 = n3 <= n4 ? n4 : n3;
        this.clippingArea.setBounds(n, n2, n5 - n, n6 - n2);
    }
}

