/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.DynamicImage$1;
import de.vw.mib.widgets.DynamicImage$ImageLoadingHandler;
import de.vw.mib.widgets.DynamicImage$TransformablePicture;
import de.vw.mib.widgets.DynamicImage$Transition;
import de.vw.mib.widgets.DynamicImage$TransitionAnimation;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.DynamicImageModel;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;
import de.vw.mib.widgets.models.ScreenModel;
import de.vw.mib.widgets.models.ViewModel;
import org.dsi.ifc.global.ResourceLocator;

public class DynamicImage
extends AbstractImage
implements DynamicImageModel {
    protected static final short LOADING_STATE_DECIDE_IMAGE_WO_ANIMATION;
    protected static final short LOADING_STATE_DECIDE_IMAGE;
    protected static final short LOADING_STATE_INITIAL;
    protected static final short LOADING_STATE_LOAD_RESOURCE_IMAGE;
    protected static final short LOADING_STATE_START_IN_ANIMATION;
    protected static final short LOADING_STATE_ANIMATE;
    protected static final short LOADING_STATE_DISPLAY_NEW_IMAGE;
    protected static final short LOADING_STATE_DISPLAY;
    public static final int SCALE_DENOM_MAX;
    public static final int SCALE_DENOM_MIN;
    private static final int[] ALLOWED_SCALE_DENOMINATORS;
    private static final int[] EXIF_TAGS_ORIENTATION;
    private static final int EXIF_TAG_ORIENTATION_IFD;
    private static final int FALLBACK_MAX_IMAGE_SIZE;
    private Image imageDefault;
    private Color colorDefault;
    private Image imageError;
    private Color colorError;
    private Image imageForeground;
    private Color colorForeground;
    protected ResourceLocator imageResource;
    private int transitionNextImageIn;
    private int transitionNextImageOut;
    private int reflectionDistance;
    private int reflectionAlpha;
    private Image reflectionAlphaImage;
    private Image borderImage;
    private Color borderImageColor;
    private Insets borderImagePadding;
    private short borderImageMode;
    private int zoomType;
    private DynamicImage$TransformablePicture currentPicture;
    private DynamicImage$TransformablePicture newPicture;
    private short loadingState;
    protected DynamicImage$TransitionAnimation newPictureInAnimation;
    protected DynamicImage$TransitionAnimation currentPictureOutAnimation;
    private final DynamicImage$ImageLoadingHandler imageLoadingHandler = new DynamicImage$ImageLoadingHandler(this);
    private final Runnable validateInvoker = new DynamicImage$1(this);
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$DynamicImageUI;

    protected static final boolean resourceIsValid(ResourceLocator resourceLocator) {
        return resourceLocator != null && (resourceLocator.isIntResource() && resourceLocator.getId() != -1 || !resourceLocator.isIntResource() && resourceLocator.getUrl() != null && resourceLocator.getUrl().length() > 0);
    }

    protected static final boolean resourceEquals(ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        return resourceLocator == resourceLocator2 || resourceLocator != null && resourceLocator2 != null && (resourceLocator.isIntResource() && resourceLocator2.isIntResource() && resourceLocator.getId() == resourceLocator2.getId() || !resourceLocator.isIntResource() && !resourceLocator2.isIntResource() && resourceLocator.getUrl().equals(resourceLocator2.getUrl()));
    }

    protected static final int getNextAllowedScaleDenominator(int n) {
        int n2;
        for (n2 = 0; n2 < ALLOWED_SCALE_DENOMINATORS.length - 1 && n < ALLOWED_SCALE_DENOMINATORS[n2]; ++n2) {
        }
        return ALLOWED_SCALE_DENOMINATORS[n2];
    }

    @Override
    protected void reset() {
        super.reset();
        this.imageDefault = null;
        this.imageError = null;
        this.imageResource = null;
        this.reflectionAlphaImage = null;
        this.borderImage = null;
        this.borderImagePadding = null;
        this.newPictureInAnimation = null;
        this.currentPictureOutAnimation = null;
        this.setImmediateAnimations(false);
        this.setLimitMaxResourceSize(false);
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Image image, Color color2, int n3, Insets insets, Color color3, Color color4, boolean bl3, Color color5, Color color6, EasingParams[] easingParamsArray, boolean bl4, int n4, Image image2, Image image3, Image image4, ResourceLocator resourceLocator, boolean bl5, String string, boolean bl6, int n5, Image image5, int n6, boolean bl7, int n7, boolean bl8, Insets insets2, int n8, int n9, boolean bl9, boolean bl10, int n10, int n11, int n12, int n13) {
        super.init(bl, n, bl2, color, n2, color3, bl3, easingParamsArray, bl4, n4, bl5, string, n7, insets2, bl10, n10, n11, n12);
        this.imageDefault = image2;
        this.colorDefault = color4;
        this.imageError = image3;
        this.colorError = color5;
        this.imageForeground = image4;
        this.colorForeground = color6;
        this.imageResource = resourceLocator;
        this.transitionNextImageIn = n8;
        this.transitionNextImageOut = n9;
        this.reflectionAlpha = n5;
        this.reflectionAlphaImage = image5;
        this.reflectionDistance = n6;
        this.borderImage = image;
        this.borderImageMode = (short)n3;
        this.borderImagePadding = insets;
        this.borderImageColor = color2;
        this.zoomType = n13;
        this.setInternalStateFlag(9, bl8);
        this.setInternalStateFlag(10, bl9);
        this.setInternalStateFlag(11, bl7);
        this.setInternalStateFlag(12, bl6);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.loadingState = 0;
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.imageDefault);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.imageError);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.reflectionAlphaImage);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.borderImage);
        this.imageResourceChanged(null);
    }

    @Override
    public void deInit() {
        if (this.currentPicture != null) {
            this.currentPicture.dispose();
            this.currentPicture = null;
        }
        if (this.newPicture != null) {
            this.newPicture.dispose();
            this.newPicture = null;
        }
        this.imageLoadingHandler.reset();
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$DynamicImageUI == null ? (class$de$vw$mib$widgets$ui$DynamicImageUI = DynamicImage.class$("de.vw.mib.widgets.ui.DynamicImageUI")) : class$de$vw$mib$widgets$ui$DynamicImageUI};
    }

    @Override
    public final Image get_imageDefault() {
        return this.imageDefault;
    }

    @Override
    public final void set_imageDefault(Image image) {
        Image image2 = this.imageDefault;
        if (image2 == null || !image2.equals(image)) {
            this.imageDefault = image;
            this.imageDefaultChanged(image2);
            this.propertyChanged(20);
        }
    }

    @Override
    public Color get_colorDefault() {
        return this.colorDefault;
    }

    @Override
    public void set_colorDefault(Color color) {
        Color color2 = this.colorDefault;
        if (color2 == null || !color2.equals(color)) {
            this.colorDefault = color;
            this.colorDefaultChanged(color2);
            this.propertyChanged(21);
        }
    }

    @Override
    public Image get_imageForeground() {
        return this.imageForeground;
    }

    @Override
    public void set_imageForeground(Image image) {
        Image image2 = this.imageForeground;
        if (image2 == null || !image2.equals(image)) {
            this.imageForeground = image;
            this.imageForegroundChanged(image2);
            this.propertyChanged(25);
        }
    }

    @Override
    public Color get_colorForeground() {
        return this.colorForeground;
    }

    @Override
    public void set_colorForeground(Color color) {
        Color color2 = this.colorForeground;
        if (color2 == null || !color2.equals(color)) {
            this.colorForeground = color;
            this.colorForegroundChanged(color2);
            this.propertyChanged(26);
        }
    }

    @Override
    public final ResourceLocator get_imageResource() {
        return this.imageResource;
    }

    @Override
    public final void set_imageResource(ResourceLocator resourceLocator) {
        ResourceLocator resourceLocator2 = this.imageResource;
        if (!DynamicImage.resourceEquals(resourceLocator2, resourceLocator)) {
            this.imageResource = resourceLocator;
            this.imageResourceChanged(resourceLocator2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final boolean is_thumbnail() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public final void set_thumbnail(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.thumbnailChanged(bl2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final boolean is_useExifOrientation() {
        return this.getInternalStateFlag(10);
    }

    @Override
    public final void set_useExifOrientation(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(10);
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.useExifOrientationChanged(bl2);
            this.propertyChanged(28);
        }
    }

    @Override
    public boolean is_prescaleResource() {
        return this.getInternalStateFlag(12);
    }

    @Override
    public void set_prescaleResource(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(12);
        if (bl2 != bl) {
            this.setInternalStateFlag(12, bl);
            this.prescaleResourceChanged(bl2);
            this.propertyChanged(39);
        }
    }

    @Override
    public final Image get_imageError() {
        return this.imageError;
    }

    @Override
    public final void set_imageError(Image image) {
        Image image2 = this.imageError;
        if (image2 == null || !image2.equals(image)) {
            this.imageError = image;
            this.imageErrorChanged(image2);
            this.propertyChanged(22);
        }
    }

    @Override
    public Color get_colorError() {
        return this.colorError;
    }

    @Override
    public void set_colorError(Color color) {
        Color color2 = this.colorError;
        if (color2 == null || !color2.equals(color)) {
            this.colorError = color;
            this.colorErrorChanged(color2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final void set_transitionNextImageIn(int n) {
        int n2 = this.transitionNextImageIn;
        if (n2 != n) {
            this.transitionNextImageIn = n;
            this.transitionNextImageInChanged(n2);
            this.propertyChanged(29);
        }
    }

    @Override
    public final int get_transitionNextImageIn() {
        return this.transitionNextImageIn;
    }

    @Override
    public final void set_transitionNextImageOut(int n) {
        int n2 = this.transitionNextImageOut;
        if (n2 != n) {
            this.transitionNextImageOut = n;
            this.transitionNextImageOutChanged(n2);
            this.propertyChanged(30);
        }
    }

    @Override
    public final int get_transitionNextImageOut() {
        return this.transitionNextImageOut;
    }

    @Override
    public final void set_reflectionEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(11);
        if (bl2 != bl) {
            this.setInternalStateFlag(11, bl);
            this.reflectionEnabledChanged(bl2);
            this.propertyChanged(31);
        }
    }

    @Override
    public final boolean is_reflectionEnabled() {
        return this.getInternalStateFlag(11);
    }

    @Override
    public final void set_reflectionAlpha(int n) {
        int n2 = this.reflectionAlpha;
        if (n2 != n) {
            this.reflectionAlpha = n;
            this.reflectionAlphaChanged(n2);
            this.propertyChanged(32);
        }
    }

    @Override
    public final int get_reflectionAlpha() {
        return this.reflectionAlpha;
    }

    @Override
    public final void set_reflectionAlphaImage(Image image) {
        Image image2 = this.reflectionAlphaImage;
        if (image2 == null || !image2.equals(image)) {
            this.reflectionAlphaImage = image;
            this.reflectionAlphaImageChanged(image2);
            this.propertyChanged(33);
        }
    }

    @Override
    public final Image get_reflectionAlphaImage() {
        return this.reflectionAlphaImage;
    }

    @Override
    public final void set_reflectionDistance(int n) {
        int n2 = this.reflectionDistance;
        if (n2 != n) {
            this.reflectionDistance = n;
            this.reflectionAlphaChanged(n2);
            this.propertyChanged(34);
        }
    }

    @Override
    public final int get_reflectionDistance() {
        return this.reflectionDistance;
    }

    @Override
    public void set_borderImage(Image image) {
        Image image2 = this.borderImage;
        if (image2 != image) {
            this.borderImage = image;
            this.borderImageChanged(image2);
            this.propertyChanged(35);
        }
    }

    @Override
    public Image get_borderImage() {
        return this.borderImage;
    }

    @Override
    public void set_borderImageMode(int n) {
        short s = this.borderImageMode;
        if (s != n) {
            this.borderImageMode = (short)n;
            this.borderImageModeChanged(s);
            this.propertyChanged(36);
        }
    }

    @Override
    public int get_borderImageMode() {
        return this.borderImageMode;
    }

    @Override
    public void set_borderImagePadding(Insets insets) {
        Insets insets2 = this.borderImagePadding;
        if (insets2 == null || !insets2.equals(insets)) {
            this.borderImagePadding = insets;
            this.borderImagePaddingChanged(insets2);
            this.propertyChanged(37);
        }
    }

    @Override
    public Insets get_borderImagePadding() {
        return this.borderImagePadding;
    }

    @Override
    public Color get_borderImageColor() {
        return this.borderImageColor;
    }

    @Override
    public void set_borderImageColor(Color color) {
        Color color2 = this.borderImageColor;
        if (color2 == null || !color2.equals(color)) {
            this.borderImageColor = color;
            this.borderImageColorChanged(color2);
            this.propertyChanged(38);
        }
    }

    @Override
    public final int get_zoomType() {
        return this.zoomType;
    }

    @Override
    public final void set_zoomType(int n) {
        int n2 = this.zoomType;
        if (n2 != n) {
            this.zoomType = n;
            this.zoomTypeChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public DynamicImageModel$Picture getCurrentPicture() {
        if (this.currentPicture == null) {
            this.validate();
        }
        return this.currentPicture;
    }

    @Override
    public DynamicImageModel$Picture getNewPicture() {
        return this.loadingState == 3 ? this.newPicture : null;
    }

    private synchronized void setNewPicture(DynamicImage$TransformablePicture dynamicImage$TransformablePicture, boolean bl) {
        if (bl && this.newPicture != null) {
            this.newPicture.dispose();
        }
        this.newPicture = dynamicImage$TransformablePicture;
        this.repaint();
    }

    protected void imageLoadingSuccess(BufferImage bufferImage, ExifInfo exifInfo, int n) {
        this.setNewPicture(new DynamicImage$TransformablePicture(this, bufferImage, exifInfo, n), true);
        this.invokeValidate();
    }

    protected void imageLoadingFailure() {
        this.setNewPicture(new DynamicImage$TransformablePicture(this, 2, this.get_imageError()), true);
        this.invokeValidate();
    }

    protected final void currentPictureOutAnimationFinished() {
        if (!(this.loadingState != 3 || this.newPictureInAnimation != null && this.newPictureInAnimation.isActive())) {
            this.setLoadingState((short)4, true);
        }
        this.currentPicture.dispose();
        this.currentPicture = null;
        this.currentPictureOutAnimation = null;
        if (this.isImmediateAnimations()) {
            this.validate();
        }
    }

    protected final void nextPictureAnimationFinished() {
        if (!(this.loadingState != 3 || this.currentPictureOutAnimation != null && this.currentPictureOutAnimation.isActive())) {
            this.setLoadingState((short)4, true);
        }
        this.newPictureInAnimation = null;
    }

    protected final boolean isImageLoadingComplete() {
        return this.loadingState == 5;
    }

    protected final void setImmediateAnimations(boolean bl) {
        this.setInternalStateFlag(14, bl);
    }

    private boolean isImmediateAnimations() {
        return this.is_enabled() && this.getInternalStateFlag(14);
    }

    protected final void setLimitMaxResourceSize(boolean bl) {
        this.setInternalStateFlag(13, bl);
    }

    protected final boolean isLimitMaxResourceSize() {
        return this.getInternalStateFlag(13);
    }

    private void setLoadingState(short s, boolean bl) {
        short s2 = this.loadingState;
        if (this.loadingState != s) {
            if (LOGGER.isTraceEnabled(4)) {
                LogMessage logMessage = LOGGER.trace(4);
                logMessage.append(this.toString()).append(": Loading state changed from '").append(s2).append("' to '").append(s).append("'").log();
            }
            this.loadingState = s;
            this.loadingStateChanged(s2, s);
            if (bl) {
                this.invokeValidate();
            }
        }
    }

    protected void imageDefaultChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.imageDefault);
        if (this.currentPicture != null && this.currentPicture.getImageResourceType() == 1 || this.newPicture != null && this.newPicture.getImageResourceType() == 1) {
            this.setLoadingState(this.areAnimationsEnabled() ? (short)-1 : -2, true);
        }
    }

    protected void colorDefaultChanged(Color color) {
        this.repaint();
    }

    protected void imageForegroundChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.imageForeground);
        this.repaint();
    }

    protected void colorForegroundChanged(Color color) {
        this.repaint();
    }

    protected void imageErrorChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.imageError);
        if (this.loadingState == 5 && this.currentPicture != null && this.currentPicture.getImageResourceType() == 2) {
            this.setLoadingState(this.areAnimationsEnabled() ? (short)-1 : -2, true);
        }
    }

    protected void colorErrorChanged(Color color) {
        this.repaint();
    }

    protected void imageResourceChanged(ResourceLocator resourceLocator) {
        LogMessage logMessage;
        if (LOGGER.isTraceEnabled(4)) {
            logMessage = LOGGER.trace(4);
            logMessage.append(this.toString()).append(": imageResourceChanged : ").append(this.get_imageResource()).log();
        }
        if (this.loadingState == 1 && DynamicImage.resourceIsValid(resourceLocator)) {
            if (LOGGER.isTraceEnabled(4)) {
                logMessage = LOGGER.trace(4);
                logMessage.append(this.toString()).append(": Cancelled loading because no longer required: ").append(resourceLocator).log();
            }
            if (this.is_thumbnail()) {
                ServiceManager.imageManager.cancelGetThumbnailImageFromResource(resourceLocator, this.imageLoadingHandler);
            } else {
                ServiceManager.imageManager.cancelGetImageFromResource(resourceLocator, this.imageLoadingHandler);
            }
        }
        this.setLoadingState((short)(!this.areAnimationsEnabled() || !this.is_visible() || !this.areParentsVisible() ? -2 : -1), true);
    }

    protected void loadingStateChanged(int n, int n2) {
    }

    protected void thumbnailChanged(boolean bl) {
    }

    protected void useExifOrientationChanged(boolean bl) {
    }

    protected void prescaleResourceChanged(boolean bl) {
    }

    protected void transitionNextImageOutChanged(int n) {
    }

    protected void transitionNextImageInChanged(int n) {
    }

    protected void reflectionEnabledChanged(boolean bl) {
        this.repaint();
    }

    protected void reflectionAlphaChanged(int n) {
        this.repaint();
    }

    protected void reflectionAlphaImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_reflectionAlphaImage());
        this.repaint();
    }

    protected void borderImageModeChanged(int n) {
        if (this.currentPicture != null) {
            this.currentPicture.invalidateScale();
        }
        this.repaint();
    }

    protected void borderImageChanged(Image image) {
        this.repaint();
    }

    protected void borderImagePaddingChanged(Insets insets) {
        if (this.currentPicture != null) {
            this.currentPicture.invalidateScale();
        }
        this.repaint();
    }

    protected void borderImageColorChanged(Color color) {
        this.repaint();
    }

    protected void reflectionDistanceChanged(int n) {
        this.repaint();
    }

    @Override
    protected void widthChanged(int n) {
        if (n <= 0) {
            this.invokeValidate();
        }
        if (this.currentPicture != null) {
            this.currentPicture.invalidateScale();
        }
        if (this.newPicture != null) {
            this.newPicture.invalidateScale();
        }
        super.widthChanged(n);
    }

    @Override
    protected void heightChanged(int n) {
        if (n <= 0) {
            this.invokeValidate();
        }
        if (this.currentPicture != null) {
            this.currentPicture.invalidateScale();
        }
        if (this.newPicture != null) {
            this.newPicture.invalidateScale();
        }
        super.heightChanged(n);
    }

    protected void zoomTypeChanged(int n) {
        if (this.currentPicture != null) {
            this.currentPicture.invalidateScale();
        }
        if (this.newPicture != null) {
            this.newPicture.invalidateScale();
        }
        this.repaint();
    }

    protected final int getMaxResourceSize() {
        ScreenModel screenModel;
        ViewModel viewModel = this.getView();
        if (viewModel != null && (screenModel = viewModel.getScreen()) != null) {
            return Util.nextPowerOfTwo(Math.max(screenModel.get_width(), screenModel.get_height()));
        }
        return 1024;
    }

    protected final int getDesiredResourceSize() {
        return this.is_prescaleResource() ? Math.max(this.get_width(), this.get_height()) : this.getMaxResourceSize();
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        if (!bl) {
            this.invokeValidate();
        }
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        super.parentVisibilityChanged(bl);
        if (!bl) {
            this.invokeValidate();
        }
    }

    private void invokeValidate() {
        if (this.loadingState != 5 && this.is_visible() && this.get_width() > 0 && this.get_height() > 0 && this.areParentsVisible()) {
            if (this.loadingState == -2 || this.loadingState == -1) {
                if (LOGGER.isTraceEnabled(4)) {
                    LogMessage logMessage = LOGGER.trace(4);
                    logMessage.append(this.toString()).append(": Validate immediately").log();
                }
                this.validate();
            } else {
                if (LOGGER.isTraceEnabled(4)) {
                    LogMessage logMessage = LOGGER.trace(4);
                    logMessage.append(this.toString()).append(": Queue validate invokation").log();
                }
                if (!this.getInternalStateFlag(15)) {
                    this.setInternalStateFlag(15, true);
                    ServiceManager.eventDispatcher.invoke(this.validateInvoker);
                }
            }
        }
    }

    private void startImageLoading(boolean bl) {
        ResourceLocator resourceLocator = this.imageResource;
        this.stopNewPictureInAnimation();
        this.stopCurrentPictureOutAnimation();
        if (this.newPicture != null) {
            this.switchCurrentAndNewPicture();
        }
        if (DynamicImage.resourceIsValid(resourceLocator)) {
            if (this.currentPicture == null) {
                this.currentPicture = new DynamicImage$TransformablePicture(this, 1, this.get_imageDefault());
            }
            if (bl || this.isImmediateAnimations() && !this.startCurrentPictureOutAnimation()) {
                if (this.currentPicture != null) {
                    this.currentPicture.dispose();
                }
                this.currentPicture = new DynamicImage$TransformablePicture(this, 1, this.get_imageDefault());
            }
            this.setLoadingState((short)1, false);
            if (bl) {
                this.disableAnimations();
            }
            this.loadDynamicImage(resourceLocator);
            if (bl) {
                this.enableAnimations();
            }
        } else {
            if (LOGGER.isTraceEnabled(4)) {
                LogMessage logMessage = LOGGER.trace(4);
                logMessage.append(this.toString()).append(": Resource is invalid or empty, show default image: ").append(resourceLocator).log();
            }
            if (!bl && this.startCurrentPictureOutAnimation()) {
                this.setNewPicture(new DynamicImage$TransformablePicture(this, 1, this.get_imageDefault()), true);
                this.setLoadingState((short)2, false);
            } else {
                if (this.currentPicture != null) {
                    this.currentPicture.dispose();
                }
                if (this.imageDefault != null) {
                    this.currentPicture = new DynamicImage$TransformablePicture(this, 1, this.get_imageDefault());
                    this.setLoadingState((short)5, false);
                }
            }
        }
        this.repaint();
    }

    private void switchCurrentAndNewPicture() {
        if (this.currentPicture != null) {
            this.currentPicture.dispose();
        }
        this.currentPicture = this.newPicture;
        this.setNewPicture(null, false);
        this.repaint();
    }

    protected final void validate() {
        LogMessage logMessage;
        if (LOGGER.isTraceEnabled(4)) {
            logMessage = LOGGER.trace(4);
            logMessage.append(this).append(": Starting validation");
        }
        if (this.loadingState == -1 || this.loadingState == -2) {
            this.startImageLoading(this.loadingState == -2);
        }
        if (!(this.loadingState != 1 || this.newPicture == null || this.currentPictureOutAnimation != null && this.currentPictureOutAnimation.isActive())) {
            this.setLoadingState(this.areAnimationsEnabled() ? (short)2 : 4, false);
        }
        if (this.loadingState == 2) {
            if (this.startNewPictureInAnimation()) {
                if (!this.isImmediateAnimations()) {
                    this.startCurrentPictureOutAnimation();
                }
                this.setLoadingState((short)3, false);
            } else {
                this.setLoadingState((short)4, false);
            }
        }
        if (this.loadingState == 4) {
            this.switchCurrentAndNewPicture();
            this.setLoadingState((short)5, false);
        }
        if (LOGGER.isTraceEnabled(4)) {
            logMessage = LOGGER.trace(4);
            logMessage.append(this).append(": End of validation");
        }
    }

    protected float calculateScaleFactor(int n, int n2, boolean bl, int n3) {
        int n4;
        int n5;
        if (bl && this.borderImageMode != -1 && this.borderImagePadding != null) {
            n5 = this.get_width() - (this.borderImagePadding.left + this.borderImagePadding.right);
            n4 = this.get_height() - (this.borderImagePadding.top + this.borderImagePadding.bottom);
        } else {
            n5 = this.get_width();
            n4 = this.get_height();
        }
        float f2 = (float)n4 / (float)n2;
        float f3 = (float)n5 / (float)n;
        switch (this.zoomType) {
            case 1: {
                return Math.min((float)n3, Math.max(f3, f2));
            }
            case 2: {
                return Math.min(f3, f2);
            }
            case 3: {
                return Math.max(f3, f2);
            }
            case 4: {
                float f4 = Math.min(f3, f2);
                return f4 > 1.0f ? (float)Math.floor(f4) : f4;
            }
            case 5: {
                return Math.min(Math.min(f3, f2), 2.0f);
            }
        }
        return Math.min((float)n3, Math.min(f3, f2));
    }

    private void loadDynamicImage(ResourceLocator resourceLocator) {
        LogMessage logMessage;
        boolean bl = this.is_useExifOrientation();
        this.imageLoadingHandler.newImage(bl);
        if (bl) {
            if (LOGGER.isTraceEnabled(4)) {
                logMessage = LOGGER.trace(4);
                logMessage.append(this.toString()).append(": Resource is valid, start loading (Exif): ").append(resourceLocator).log();
            }
            ServiceManager.imageManager.getExifInfoFromResource(resourceLocator, 0, EXIF_TAGS_ORIENTATION, this.imageLoadingHandler);
        }
        if (this.is_thumbnail()) {
            if (LOGGER.isTraceEnabled(4)) {
                logMessage = LOGGER.trace(4);
                logMessage.append(this.toString()).append(": Resource is valid, start loading (Thumbnail): ").append(resourceLocator).log();
            }
            ServiceManager.imageManager.getThumbnailImageFromResource(resourceLocator, this.imageLoadingHandler);
        } else if (this.is_prescaleResource() || this.isLimitMaxResourceSize()) {
            if (LOGGER.isTraceEnabled(4)) {
                logMessage = LOGGER.trace(4);
                logMessage.append(this.toString()).append(": Resource is valid, start loading (scaled): ").append(resourceLocator).log();
            }
            ServiceManager.imageManager.getImageInfoFromResource(resourceLocator, this.imageLoadingHandler);
        } else {
            if (LOGGER.isTraceEnabled(4)) {
                logMessage = LOGGER.trace(4);
                logMessage.append(this.toString()).append(": Resource is valid, start loading: ").append(resourceLocator).log();
            }
            boolean bl2 = false;
            ServiceManager.imageManager.getImageFromResource(resourceLocator, this.imageLoadingHandler, false);
        }
    }

    protected DynamicImage$Transition getInTransition() {
        switch (this.get_transitionNextImageIn()) {
            case 2: {
                return DynamicImage$Transition.FLY_IN_WEST;
            }
            case 1: {
                return DynamicImage$Transition.FLY_IN_EAST;
            }
            case 3: {
                return DynamicImage$Transition.FADE_IN;
            }
            case 4: {
                return DynamicImage$Transition.FLAP_IN;
            }
        }
        return null;
    }

    protected DynamicImage$Transition getOutTransition() {
        switch (this.get_transitionNextImageOut()) {
            case 2: {
                return DynamicImage$Transition.FLY_OUT_WEST;
            }
            case 1: {
                return DynamicImage$Transition.FLY_OUT_EAST;
            }
            case 3: {
                return DynamicImage$Transition.FADE_OUT;
            }
            case 4: {
                return DynamicImage$Transition.FLAP_OUT;
            }
        }
        return null;
    }

    private void stopNewPictureInAnimation() {
        if (this.newPictureInAnimation != null) {
            this.stopInternalAnimation(this.newPictureInAnimation);
            this.newPictureInAnimation = null;
        }
    }

    private boolean startNewPictureInAnimation() {
        this.stopNewPictureInAnimation();
        EasingParams easingParams = this.getEasing(7);
        DynamicImage$Transition dynamicImage$Transition = this.getInTransition();
        if (easingParams == null || dynamicImage$Transition == null || this.newPicture == null) {
            return false;
        }
        this.newPictureInAnimation = new DynamicImage$TransitionAnimation(this, this.newPicture, dynamicImage$Transition, easingParams);
        if (LOGGER.isTraceEnabled(4)) {
            LogMessage logMessage = LOGGER.trace(4);
            logMessage.append(this).append(": starting in animation of Picture:").append(this.newPicture).log();
        }
        return this.startInternalAnimation(this.newPictureInAnimation);
    }

    private void stopCurrentPictureOutAnimation() {
        if (this.currentPictureOutAnimation != null) {
            this.stopInternalAnimation(this.currentPictureOutAnimation);
            this.currentPictureOutAnimation = null;
        }
    }

    private boolean startCurrentPictureOutAnimation() {
        if (this.currentPictureOutAnimation != null && this.currentPictureOutAnimation.isActive()) {
            return true;
        }
        DynamicImage$Transition dynamicImage$Transition = this.getOutTransition();
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null || dynamicImage$Transition == null || this.currentPicture == null) {
            return false;
        }
        this.currentPictureOutAnimation = new DynamicImage$TransitionAnimation(this, this.currentPicture, dynamicImage$Transition, easingParams);
        if (LOGGER.isTraceEnabled(4)) {
            LogMessage logMessage = LOGGER.trace(4);
            logMessage.append(this).append(": starting out animation of Picture:").append(this.currentPicture).log();
        }
        return this.startInternalAnimation(this.currentPictureOutAnimation);
    }

    @Override
    public void stopInternalAnimations() {
        this.stopCurrentPictureOutAnimation();
        this.stopNewPictureInAnimation();
        super.stopInternalAnimations();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$000(DynamicImage dynamicImage) {
        return dynamicImage.isImmediateAnimations();
    }

    static {
        ALLOWED_SCALE_DENOMINATORS = new int[]{8, 4, 2, 1};
        EXIF_TAGS_ORIENTATION = new int[]{274};
    }
}

