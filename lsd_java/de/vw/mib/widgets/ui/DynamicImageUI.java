/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ImageBaseDrawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.DynamicImageModel;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import java.io.IOException;

public class DynamicImageUI
extends AbstractImageUI {
    private static int INDEX_CURRENT_PICTURE = 0;
    private static int INDEX_NEW_PICTURE = 1;
    private static int INDEX_COUNT = 2;
    private static Rectangle clipRect = new Rectangle();
    private final OffscreenDrawable[] offscreenReflectionDrawables = new OffscreenDrawable[INDEX_COUNT];
    private final ImageBaseDrawable[] imageDrawables = new ImageBaseDrawable[INDEX_COUNT];
    private ScaleImageDrawable borderImageDrawable;
    private ScaleImageDrawable reflectionAlphaMaskDrawable;
    private ScaleImageDrawable foregroundImageDrawable;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        DynamicImageUI.disposeDrawable(this.offscreenReflectionDrawables, INDEX_CURRENT_PICTURE);
        DynamicImageUI.disposeDrawable(this.offscreenReflectionDrawables, INDEX_NEW_PICTURE);
        DynamicImageUI.disposeDrawable(this.imageDrawables, INDEX_CURRENT_PICTURE);
        DynamicImageUI.disposeDrawable(this.imageDrawables, INDEX_NEW_PICTURE);
        if (this.borderImageDrawable != null) {
            this.borderImageDrawable.dispose();
            this.borderImageDrawable = null;
        }
        if (this.reflectionAlphaMaskDrawable != null) {
            this.reflectionAlphaMaskDrawable.dispose();
            this.reflectionAlphaMaskDrawable = null;
        }
        if (this.foregroundImageDrawable != null) {
            this.foregroundImageDrawable.dispose();
            this.foregroundImageDrawable = null;
        }
        super.deInit();
    }

    private void enablePictureClipping(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2, DynamicImageModel dynamicImageModel, DynamicImageModel$Picture dynamicImageModel$Picture) {
        if (dynamicImageModel$Picture.isDynamicResource() && dynamicImageModel.get_borderImageMode() == 0) {
            Insets insets = dynamicImageModel.get_borderImagePadding();
            clipRect.setBounds(insets.left, insets.top, rectangle2.width - insets.left - insets.right, rectangle2.height - insets.top - insets.bottom);
        } else {
            clipRect.setBounds(0, 0, rectangle2.width, rectangle2.height);
        }
        this.enableClipping(graphics3D, rectangle, clipRect, rectangle2);
    }

    private void disablePictureClipping(Graphics3D graphics3D) {
        this.disableClipping(graphics3D);
    }

    @Override
    protected void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        DynamicImageModel dynamicImageModel = (DynamicImageModel)widgetModel;
        DynamicImageModel$Picture dynamicImageModel$Picture = dynamicImageModel.getNewPicture();
        DynamicImageModel$Picture dynamicImageModel$Picture2 = dynamicImageModel.getCurrentPicture();
        if (dynamicImageModel$Picture2 != null && dynamicImageModel$Picture != null && dynamicImageModel$Picture2.getCenterZ() < dynamicImageModel$Picture.getCenterZ()) {
            this.paintPicture(graphics3D, dynamicImageModel, dynamicImageModel$Picture, f2, rectangle, rectangle2, INDEX_NEW_PICTURE);
            this.paintPicture(graphics3D, dynamicImageModel, dynamicImageModel$Picture2, f2, rectangle, rectangle2, INDEX_CURRENT_PICTURE);
        } else {
            this.paintPicture(graphics3D, dynamicImageModel, dynamicImageModel$Picture2, f2, rectangle, rectangle2, INDEX_CURRENT_PICTURE);
            this.paintPicture(graphics3D, dynamicImageModel, dynamicImageModel$Picture, f2, rectangle, rectangle2, INDEX_NEW_PICTURE);
        }
    }

    private void paintPicture(Graphics3D graphics3D, DynamicImageModel dynamicImageModel, DynamicImageModel$Picture dynamicImageModel$Picture, float f2, Rectangle rectangle, Rectangle rectangle2, int n) {
        block26: {
            try {
                this.updateImageDrawable(graphics3D, dynamicImageModel, dynamicImageModel$Picture, n, dynamicImageModel.isInvalid());
            }
            catch (IOException iOException) {
                LogMessage logMessage = LOGGER.warn(4);
                logMessage.append(dynamicImageModel).append(": Error updating the image drawable. Image can't be displayed.").attachThrowable(iOException).log();
                if (this.imageDrawables[n] == null) break block26;
                this.imageDrawables[n].dispose();
                this.imageDrawables[n] = null;
            }
        }
        if (this.imageDrawables[n] != null) {
            LogMessage logMessage;
            int n2;
            int n3;
            int n4;
            int n5;
            Cloneable cloneable;
            boolean bl = dynamicImageModel.isInvalid();
            int n6 = !dynamicImageModel$Picture.isDynamicResource() ? -1 : dynamicImageModel.get_borderImageMode();
            switch (n6) {
                case 1: {
                    cloneable = dynamicImageModel.get_borderImagePadding();
                    n5 = dynamicImageModel$Picture.getScaledImageWidth() + ((Insets)cloneable).left + ((Insets)cloneable).right;
                    n4 = dynamicImageModel$Picture.getScaledImageHeight() + ((Insets)cloneable).top + ((Insets)cloneable).bottom;
                    n3 = ((Insets)cloneable).left;
                    n2 = ((Insets)cloneable).top;
                    break;
                }
                case 0: {
                    cloneable = dynamicImageModel.get_borderImagePadding();
                    n5 = (int)((float)dynamicImageModel.get_width() * dynamicImageModel$Picture.getZoomFactor());
                    n4 = (int)((float)dynamicImageModel.get_height() * dynamicImageModel$Picture.getZoomFactor());
                    n3 = ((Insets)cloneable).left + (dynamicImageModel.get_width() - ((Insets)cloneable).right - ((Insets)cloneable).left >> 1) - (dynamicImageModel$Picture.getScaledImageWidth() >> 1);
                    n2 = ((Insets)cloneable).top + (dynamicImageModel.get_height() - ((Insets)cloneable).top - ((Insets)cloneable).bottom >> 1) - (dynamicImageModel$Picture.getScaledImageHeight() >> 1);
                    break;
                }
                default: {
                    n5 = dynamicImageModel$Picture.getScaledImageWidth();
                    n4 = dynamicImageModel$Picture.getScaledImageHeight();
                    n3 = 0;
                    n2 = 0;
                }
            }
            if (bl || this.borderImageDrawable == null) {
                if (n6 != -1) {
                    cloneable = dynamicImageModel.get_borderImage();
                    try {
                        this.borderImageDrawable = DynamicImageUI.updateScaleImageDrawable(graphics3D, dynamicImageModel, this.borderImageDrawable, (Image)cloneable, n5, n4);
                    }
                    catch (IOException iOException) {
                        logMessage = LOGGER.warn(4);
                        logMessage.append(dynamicImageModel).append(": Could not load border image.").attachThrowable(iOException).log();
                        if (this.borderImageDrawable != null) {
                            this.borderImageDrawable.dispose();
                            this.borderImageDrawable = null;
                        }
                    }
                } else if (this.borderImageDrawable != null) {
                    this.borderImageDrawable.dispose();
                    this.borderImageDrawable = null;
                }
            }
            if (bl || this.foregroundImageDrawable == null) {
                cloneable = dynamicImageModel.get_imageForeground();
                if (cloneable != null && !((Image)cloneable).getCurrentImage().isEmpty()) {
                    try {
                        this.foregroundImageDrawable = DynamicImageUI.updateScaleImageDrawable(graphics3D, dynamicImageModel, this.foregroundImageDrawable, (Image)cloneable, dynamicImageModel.get_width(), dynamicImageModel.get_height());
                    }
                    catch (IOException iOException) {
                        logMessage = LOGGER.warn(4);
                        logMessage.append(dynamicImageModel).append(": Could not load foreground image.").attachThrowable(iOException).log();
                        if (this.foregroundImageDrawable != null) {
                            this.foregroundImageDrawable.dispose();
                            this.foregroundImageDrawable = null;
                        }
                    }
                } else if (this.foregroundImageDrawable != null) {
                    this.foregroundImageDrawable.dispose();
                    this.foregroundImageDrawable = null;
                }
            }
            if (dynamicImageModel.is_reflectionEnabled()) {
                if (this.offscreenReflectionDrawables[n] == null || bl || this.offscreenReflectionDrawables[n] != null && !this.offscreenReflectionDrawables[n].isValid()) {
                    this.updatePictureReflection(graphics3D, dynamicImageModel, rectangle, rectangle2, dynamicImageModel$Picture, n, n3, n2, n5, n4);
                }
            } else {
                DynamicImageUI.disposeDrawable(this.offscreenReflectionDrawables, INDEX_CURRENT_PICTURE);
                DynamicImageUI.disposeDrawable(this.offscreenReflectionDrawables, INDEX_NEW_PICTURE);
            }
            int n7 = dynamicImageModel.get_width() >> 1;
            int n8 = dynamicImageModel.get_height() >> 1;
            float f3 = f2 * dynamicImageModel$Picture.getAlpha();
            graphics3D.pushMatrix(0);
            graphics3D.translateMatrix(0, (float)n7 + dynamicImageModel$Picture.getCenterX(), (float)n8 + dynamicImageModel$Picture.getCenterY(), dynamicImageModel$Picture.getCenterZ());
            graphics3D.rotateMatrix(0, dynamicImageModel$Picture.getRotationY(), 0.0f, 1.0f, 0.0f);
            if (this.offscreenReflectionDrawables[n] != null) {
                graphics3D.setBlendColor(new Color4f(1.0f, 1.0f, 1.0f, f3));
                int n9 = graphics3D.getBlendFactorSourceRGB();
                int n10 = graphics3D.getBlendFactorDestinationRGB();
                int n11 = graphics3D.getBlendFactorSourceAlpha();
                int n12 = graphics3D.getBlendFactorDestinationAlpha();
                graphics3D.setBlendFactorsSeparate(13, 7, 1, 7);
                this.offscreenReflectionDrawables[n].draw(-n7, -n8 + dynamicImageModel.get_height());
                graphics3D.setBlendFactorsSeparate(n9, n10, n11, n12);
            }
            this.paintPictureWithBorder(graphics3D, rectangle, rectangle2, dynamicImageModel, dynamicImageModel$Picture, n, false, n3, n2, n5, n4, f3);
            if (this.foregroundImageDrawable != null) {
                Color4b color4b = !dynamicImageModel.is_colorEnabled() ? Color4b.WHITE : dynamicImageModel.get_colorForeground().getCurrentColor();
                this.foregroundImageDrawable.setColor(color4b);
                this.foregroundImageDrawable.draw();
            }
            graphics3D.popMatrix(0);
        }
    }

    private void updatePictureReflection(Graphics3D graphics3D, DynamicImageModel dynamicImageModel, Rectangle rectangle, Rectangle rectangle2, DynamicImageModel$Picture dynamicImageModel$Picture, int n, int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        block7: {
            n7 = rectangle2.width >> 1;
            n6 = rectangle2.height >> 1;
            Image image = dynamicImageModel.get_reflectionAlphaImage();
            try {
                this.reflectionAlphaMaskDrawable = DynamicImageUI.updateScaleImageDrawable(graphics3D, dynamicImageModel, this.reflectionAlphaMaskDrawable, image, dynamicImageModel.get_width(), dynamicImageModel.get_height());
                DynamicImageUI.updateAlphaImageDrawableHeight(this.reflectionAlphaMaskDrawable);
            }
            catch (IOException iOException) {
                LogMessage logMessage = LOGGER.warn(4);
                logMessage.append(dynamicImageModel).append(": Could not load reflection alpha image.").attachThrowable(iOException).log();
                if (this.reflectionAlphaMaskDrawable == null) break block7;
                this.reflectionAlphaMaskDrawable.dispose();
                this.reflectionAlphaMaskDrawable = null;
            }
        }
        if (this.reflectionAlphaMaskDrawable != null) {
            BufferImage bufferImage = dynamicImageModel$Picture.getDynamicImage();
            if (this.reflectionAlphaMaskDrawable == null || bufferImage == null) {
                DynamicImageUI.disposeDrawable(this.offscreenReflectionDrawables, n);
                return;
            }
            if (bufferImage != null) {
                int n8 = graphics3D.getBlendFactorSourceRGB();
                int n9 = graphics3D.getBlendFactorDestinationRGB();
                int n10 = graphics3D.getBlendFactorSourceAlpha();
                int n11 = graphics3D.getBlendFactorDestinationAlpha();
                OffscreenDrawable offscreenDrawable = this.offscreenReflectionDrawables[n];
                if (offscreenDrawable == null || offscreenDrawable.getWidth() != dynamicImageModel.get_width() || offscreenDrawable.getHeight() != this.reflectionAlphaMaskDrawable.getHeight()) {
                    if (offscreenDrawable != null) {
                        offscreenDrawable.dispose();
                    }
                    this.offscreenReflectionDrawables[n] = offscreenDrawable = graphics3D.getDrawableManager().createOffscreenDrawable(dynamicImageModel.get_width(), this.reflectionAlphaMaskDrawable.getHeight(), false);
                }
                offscreenDrawable.prepareGraphics(graphics3D, rectangle2, 0);
                graphics3D.pushMatrix(0);
                graphics3D.translateMatrix(0, n7, n6, 0.0f);
                this.paintPictureWithBorder(graphics3D, rectangle, rectangle2, dynamicImageModel, dynamicImageModel$Picture, n, true, n2, n3, n4, n5, 1.0f);
                graphics3D.popMatrix(0);
                graphics3D.setBlendFactorsSeparate(0, 6, 0, 6);
                this.reflectionAlphaMaskDrawable.draw();
                graphics3D.setBlendFactorsSeparate(n8, n9, n10, n11);
                offscreenDrawable.restoreGraphics(graphics3D, rectangle2);
            }
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void paintPictureWithBorder(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2, DynamicImageModel dynamicImageModel, DynamicImageModel$Picture dynamicImageModel$Picture, int n, boolean bl, int n2, int n3, int n4, int n5, float f2) {
        Color4b color4b;
        int n6 = dynamicImageModel.get_zoomType();
        boolean bl2 = n6 == 1 || n6 == 3;
        boolean bl3 = dynamicImageModel.get_borderImageMode() == 1;
        boolean bl4 = dynamicImageModel.is_colorEnabled();
        if (bl3 && bl2) {
            this.enablePictureClipping(graphics3D, rectangle, rectangle2, dynamicImageModel, dynamicImageModel$Picture);
        }
        graphics3D.rotateMatrix(0, dynamicImageModel$Picture.getRotationZ() + (float)dynamicImageModel$Picture.getDefaultRotation(), 0.0f, 0.0f, bl ? 32959 : (int)1.0f);
        boolean bl5 = dynamicImageModel$Picture.isFlipY() ^ bl;
        if (dynamicImageModel$Picture.isFlipX() || bl5) {
            graphics3D.scaleMatrix(0, dynamicImageModel$Picture.isFlipX() ? 32959 : (int)1.0f, bl5 ? 32959 : (int)1.0f, 1.0f);
        }
        graphics3D.translateMatrix(0, -(n4 >> 1), -(n5 >> 1), 0.0f);
        if (this.borderImageDrawable != null) {
            color4b = !bl4 ? Color4b.WHITE : dynamicImageModel.get_borderImageColor().getCurrentColor();
            this.borderImageDrawable.setColor(color4b);
            this.borderImageDrawable.setAlpha(f2);
            this.borderImageDrawable.draw();
        }
        if (!bl3 && bl2) {
            this.enablePictureClipping(graphics3D, rectangle, rectangle2, dynamicImageModel, dynamicImageModel$Picture);
        }
        color4b = !bl4 ? Color4b.WHITE : dynamicImageModel$Picture.getColor().getCurrentColor();
        ImageBaseDrawable imageBaseDrawable = this.imageDrawables[n];
        imageBaseDrawable.setColor(color4b);
        imageBaseDrawable.setAlpha(f2);
        imageBaseDrawable.draw(n2, n3);
        if (bl2) {
            this.disablePictureClipping(graphics3D);
        }
    }

    private static void disposeDrawable(Drawable[] drawableArray, int n) {
        if (drawableArray[n] != null) {
            drawableArray[n].dispose();
            drawableArray[n] = null;
        }
    }

    private void updateImageDrawable(Graphics3D graphics3D, DynamicImageModel dynamicImageModel, DynamicImageModel$Picture dynamicImageModel$Picture, int n, boolean bl) {
        boolean bl2 = true;
        if (dynamicImageModel$Picture != null) {
            if (bl && this.imageDrawables[n] != null) {
                this.imageDrawables[n].dispose();
                this.imageDrawables[n] = null;
            }
            if (this.imageDrawables[n] == null) {
                boolean bl3 = true;
                if (!dynamicImageModel$Picture.isDynamicResource()) {
                    Image image = dynamicImageModel$Picture.getStaticImage();
                    if (image != null && !image.getCurrentImage().isEmpty()) {
                        this.imageDrawables[n] = DynamicImageUI.updateScaleImageDrawable(graphics3D, dynamicImageModel, null, dynamicImageModel$Picture.getStaticImage(), dynamicImageModel$Picture.getScaledImageWidth(), dynamicImageModel$Picture.getScaledImageHeight(), true);
                    }
                } else {
                    BufferImage bufferImage = dynamicImageModel$Picture.getDynamicImage();
                    if (bufferImage != null) {
                        Object object;
                        int n2 = dynamicImageModel$Picture.getScaledImageWidth();
                        int n3 = dynamicImageModel$Picture.getScaledImageHeight();
                        Dimension dimension = new Dimension();
                        graphics3D.getDrawableManager().getMaxImageDrawableSize(dimension);
                        if (bufferImage.getWidth() > dimension.getWidth() || bufferImage.getHeight() > dimension.getHeight()) {
                            object = LOGGER.warn(4);
                            object.append(dynamicImageModel).append(": ").append(" unable to display image - image size too large. Width (allowed): ").append(bufferImage.getWidth()).append("(").append(dimension.getWidth()).append("); Height (allowed): ").append(bufferImage.getHeight()).append("(").append(dimension.getHeight()).append(")");
                            object.log();
                            try {
                                bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(dynamicImageModel.get_imageError().getCurrentImage());
                                n2 = bufferImage.getWidth();
                                n3 = bufferImage.getHeight();
                            }
                            catch (IOException iOException) {
                                bufferImage = null;
                            }
                        }
                        if (bufferImage != null) {
                            this.imageDrawables[n] = object = graphics3D.getDrawableManager().createImageDrawable();
                            object.setImage(bufferImage);
                            object.setImageFilter(1);
                            object.setSourceWidth(bufferImage.getWidth());
                            object.setSourceHeight(bufferImage.getHeight());
                            object.setDestinationWidth(n2);
                            object.setDestinationHeight(n3);
                        } else {
                            bl2 = false;
                        }
                    }
                }
            }
        } else {
            bl2 = false;
        }
        if (!bl2) {
            DynamicImageUI.disposeDrawable(this.imageDrawables, n);
        }
    }

    private static void updateAlphaImageDrawableHeight(ScaleImageDrawable scaleImageDrawable) {
        BufferImage bufferImage = scaleImageDrawable.getImage();
        if (bufferImage != null) {
            scaleImageDrawable.setHeight(bufferImage.getHeight());
        }
    }
}

