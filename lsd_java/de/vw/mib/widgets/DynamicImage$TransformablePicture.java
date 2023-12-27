/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.DynamicImage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;
import java.io.IOException;

final class DynamicImage$TransformablePicture
implements DynamicImageModel$Picture {
    private final short imageResourceType;
    private final int defaultRotation;
    private final boolean flipVertical;
    private final boolean flipHorizontal;
    private final int prescaleFactor;
    private BufferImage dynamicImage;
    private Image staticImage;
    private final Dimension boundingDimension;
    private float scaleFactor;
    private boolean scaleValid;
    private float centerX;
    private float centerY;
    private float centerZ;
    private float zoomFactor;
    private float rotationZ;
    private float rotationY;
    private float pictureAlpha;
    private final /* synthetic */ DynamicImage this$0;

    protected DynamicImage$TransformablePicture(DynamicImage dynamicImage, BufferImage bufferImage, ExifInfo exifInfo, int n) {
        this(dynamicImage, bufferImage, null, exifInfo, 0, n);
    }

    public DynamicImage$TransformablePicture(DynamicImage dynamicImage, short s, Image image) {
        this(dynamicImage, null, image, null, s, 1);
    }

    private DynamicImage$TransformablePicture(DynamicImage dynamicImage, BufferImage bufferImage, Image image, ExifInfo exifInfo, short s, int n) {
        Integer n2;
        this.this$0 = dynamicImage;
        this.imageResourceType = s;
        this.prescaleFactor = n;
        if (bufferImage != null) {
            bufferImage.reference();
        }
        this.dynamicImage = bufferImage;
        this.staticImage = image;
        this.boundingDimension = new Dimension(1, 1);
        this.pictureAlpha = 1.0f;
        this.zoomFactor = 1.0f;
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.centerZ = 0.0f;
        this.rotationY = 0.0f;
        this.rotationZ = 0.0f;
        int n3 = exifInfo != null ? ((n2 = (Integer)exifInfo.getExifValue(274)) != null ? n2 : 1) : 1;
        this.flipVertical = n3 == 2 || n3 == 3 || n3 == 5;
        this.flipHorizontal = n3 == 4 || n3 == 3 || n3 == 5;
        switch (n3) {
            case 5: 
            case 6: {
                this.defaultRotation = 90;
                break;
            }
            case 7: 
            case 8: {
                this.defaultRotation = -90;
                break;
            }
            default: {
                this.defaultRotation = 0;
            }
        }
        this.scaleValid = false;
    }

    @Override
    public int getDefaultRotation() {
        return this.defaultRotation;
    }

    @Override
    public boolean isFlipX() {
        return this.flipVertical;
    }

    @Override
    public boolean isFlipY() {
        return this.flipHorizontal;
    }

    @Override
    public void dispose() {
        if (this.dynamicImage != null) {
            this.dynamicImage.dispose();
            this.dynamicImage = null;
        }
    }

    @Override
    public BufferImage getDynamicImage() {
        return this.dynamicImage;
    }

    @Override
    public Image getStaticImage() {
        if (this.staticImage == null) {
            switch (this.imageResourceType) {
                case 1: {
                    this.staticImage = this.this$0.get_imageDefault();
                    break;
                }
                case 2: {
                    this.staticImage = this.this$0.get_imageError();
                    break;
                }
            }
        }
        return this.staticImage;
    }

    @Override
    public Color getColor() {
        switch (this.imageResourceType) {
            case 1: {
                return this.this$0.get_colorDefault();
            }
            case 2: {
                return this.this$0.get_colorError();
            }
        }
        return this.this$0.get_color();
    }

    @Override
    public short getImageResourceType() {
        return this.imageResourceType;
    }

    @Override
    public boolean isDynamicResource() {
        return this.imageResourceType == 0;
    }

    @Override
    public float getAlpha() {
        return this.pictureAlpha;
    }

    @Override
    public void setAlpha(float f2) {
        if (!Util.equalsEpsilon(this.pictureAlpha, f2)) {
            this.pictureAlpha = f2;
            this.this$0.repaintParent();
        }
    }

    @Override
    public int getBoundingBoxWidth() {
        if (!this.scaleValid) {
            this.updateScale();
        }
        return (int)((float)this.boundingDimension.width * this.scaleFactor);
    }

    @Override
    public int getBoundingBoxHeight() {
        if (!this.scaleValid) {
            this.updateScale();
        }
        return (int)((float)this.boundingDimension.height * this.scaleFactor);
    }

    @Override
    public int getZoomedBoundingBoxWidth() {
        if (!this.scaleValid) {
            this.updateScale();
        }
        return (int)((float)this.boundingDimension.width * this.scaleFactor * this.zoomFactor);
    }

    @Override
    public int getZoomedBoundingBoxHeight() {
        if (!this.scaleValid) {
            this.updateScale();
        }
        return (int)((float)this.boundingDimension.height * this.scaleFactor * this.zoomFactor);
    }

    @Override
    public int getScaledImageWidth() {
        BufferImage bufferImage;
        if (!this.scaleValid) {
            this.updateScale();
        }
        BufferImage bufferImage2 = bufferImage = this.isDynamicResource() ? this.getDynamicImage() : this.getStaticBufferImage();
        if (bufferImage != null) {
            return Math.round((float)bufferImage.getWidth() * this.scaleFactor * this.zoomFactor);
        }
        return 0;
    }

    private BufferImage getStaticBufferImage() {
        if (this.staticImage != null && !this.staticImage.getCurrentImage().isEmpty()) {
            try {
                return ServiceManager.imageManager.getImageFromCurrentSkin(this.staticImage);
            }
            catch (IOException iOException) {
                LogMessage logMessage = AbstractWidget.LOGGER.warn(4);
                logMessage.append(this.this$0).append(": Picture.getImage() Error while loading skin image ").append(this.staticImage);
                if (AbstractWidget.LOGGER.isTraceEnabled(4)) {
                    logMessage.attachThrowable(iOException);
                }
                logMessage.log();
            }
        }
        return null;
    }

    @Override
    public int getScaledImageHeight() {
        BufferImage bufferImage;
        if (!this.scaleValid) {
            this.updateScale();
        }
        BufferImage bufferImage2 = bufferImage = this.isDynamicResource() ? this.getDynamicImage() : this.getStaticBufferImage();
        if (bufferImage != null) {
            return Math.round((float)bufferImage.getHeight() * this.scaleFactor * this.zoomFactor);
        }
        return 0;
    }

    @Override
    public float getCenterX() {
        return this.centerX;
    }

    @Override
    public float getCenterY() {
        return this.centerY;
    }

    @Override
    public float getCenterZ() {
        return this.centerZ;
    }

    @Override
    public void setCenterX(float f2) {
        if (!Util.equalsEpsilon(this.centerX, f2)) {
            this.centerX = f2;
            this.this$0.repaintParent();
        }
    }

    @Override
    public void setCenterY(float f2) {
        if (!Util.equalsEpsilon(this.centerY, f2)) {
            this.centerY = f2;
            this.this$0.repaintParent();
        }
    }

    @Override
    public void setCenterZ(float f2) {
        if (!Util.equalsEpsilon(this.centerZ, f2)) {
            this.centerZ = f2;
            this.this$0.repaintParent();
        }
    }

    @Override
    public float getRotationY() {
        return this.rotationY;
    }

    @Override
    public void setRotationY(float f2) {
        if (!Util.equalsEpsilon(this.rotationY, f2)) {
            this.rotationY = f2;
            this.this$0.repaintParent();
        }
    }

    @Override
    public void setZoomFactor(float f2) {
        if (!Util.equalsEpsilon(this.zoomFactor, f2)) {
            this.zoomFactor = f2;
            this.this$0.repaint();
        }
    }

    @Override
    public float getZoomFactor() {
        return this.zoomFactor;
    }

    @Override
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override
    public void setRotationZ(float f2) {
        if (!Util.equalsEpsilon(this.rotationZ, f2)) {
            this.rotationZ = f2;
            this.invalidateScale();
            this.this$0.repaint();
        }
    }

    public void invalidateScale() {
        this.scaleValid = false;
    }

    private void updateScale() {
        this.scaleValid = true;
        this.updateBoundingBox();
        if (this.zoomFactor == 1.0f) {
            this.scaleFactor = this.this$0.calculateScaleFactor(this.boundingDimension.width, this.boundingDimension.height, this.isDynamicResource(), this.prescaleFactor);
        }
    }

    private void updateBoundingBox() {
        BufferImage bufferImage;
        BufferImage bufferImage2 = bufferImage = this.isDynamicResource() ? this.getDynamicImage() : this.getStaticBufferImage();
        if (bufferImage != null) {
            float f2 = Math.abs((this.rotationZ + (float)this.defaultRotation) % 13379);
            if (f2 > 46146) {
                f2 = 13379 - f2;
            }
            int n = bufferImage.getWidth();
            int n2 = bufferImage.getHeight();
            float f3 = Util.toRadians(f2);
            float f4 = (float)Math.sin(f3);
            float f5 = (float)Math.cos(f3);
            this.boundingDimension.height = Math.round((float)n * f4 + (float)n2 * f5);
            this.boundingDimension.width = Math.round((float)n * f5 + (float)n2 * f4);
        }
    }
}

