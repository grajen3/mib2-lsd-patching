/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractSlider;
import de.vw.mib.widgets.Slider$ProgressImageValueChangeAnimation;
import de.vw.mib.widgets.Slider$SlidingAnimation;
import de.vw.mib.widgets.SliderCalculator;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.SliderModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class Slider
extends AbstractSlider
implements SliderModel {
    private static final int VALUE_CHANGE_SHADOW_MULTIPLIER;
    private Image[] imagesSlider;
    private Color[] colorsSlider;
    private StaticImageModel imageSliderRef;
    private Image[] imagesProgress;
    private Color[] colorsProgress;
    private StaticImageModel imageProgressRef;
    private StaticImageModel[] imageProgressIndicatorRefs;
    private Image[] imagesProgressIndicatorActive;
    private Image[] imagesProgressIndicatorPassive;
    private int imageSliderValuePointX;
    private int imageSliderValuePointY;
    private boolean valueChangeInstantly;
    private boolean valueChangeOnlyOnRelease;
    private int fireEventTimer;
    private Slider$SlidingAnimation slidingAnimation;
    private Slider$ProgressImageValueChangeAnimation progressImageValueChangeAnimation;
    private int activeProgressImageIndex;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SliderUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SliderCurveUI;

    @Override
    protected void reset() {
        super.reset();
        this.imagesSlider = null;
        this.imageSliderRef = null;
        this.imagesProgress = null;
        this.imageProgressIndicatorRefs = null;
        this.activeProgressImageIndex = 0;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, Color[] colorArray3, Color[] colorArray4, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, int n2, Color[] colorArray5, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, StaticImageModel[] staticImageModelArray, StaticImageModel staticImageModel3, Image[] imageArray, Image[] imageArray2, StaticImageModel staticImageModel4, int n4, int n5, Image[] imageArray3, Image[] imageArray4, Image[] imageArray5, Image[] imageArray6, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n6, int n7, int n8, boolean bl7, int n9, Image image2, int n10, boolean bl8, boolean bl9, int n11, int n12, int n13, Insets insets, int n14, boolean bl10, boolean bl11, int n15, int n16, boolean bl12, int n17, boolean bl13, int n18, int n19) {
        super.init(bl, n, image, bl2, bl3, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray5, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, bl5, keyframeAnimationArray, bl6, layoutAttribs, string, n6, n7, n8, n9, image2, n10, bl8, bl9, n11, n12, n13, insets, n14, n15, n16, bl12, n17, bl13, n18, n19);
        this.imagesSlider = imageArray6;
        this.colorsSlider = colorArray4;
        this.imageSliderRef = staticImageModel4;
        this.imagesProgress = imageArray3;
        this.colorsProgress = colorArray3;
        this.imageProgressRef = staticImageModel3;
        this.imageProgressIndicatorRefs = staticImageModelArray;
        this.imagesProgressIndicatorActive = imageArray4;
        this.imagesProgressIndicatorPassive = imageArray5;
        this.imageSliderValuePointX = n4;
        this.imageSliderValuePointY = n5;
        this.valueChangeInstantly = bl10;
        this.valueChangeOnlyOnRelease = bl11;
        this.fireEventTimer = n2;
        this.setInternalStateFlag(22, bl7);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, this.get_value()));
        this.disableAnimations();
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.updateProgressImages(this.get_valueMin());
        this.enableAnimations();
        int n = 30;
        if (this.fireEventTimer < 30) {
            this.trace(new StringBuffer().append(".init( view ); fireEventTimer with value: ").append(this.fireEventTimer).append(" has been set to minimum of: ").append(30).toString());
            this.fireEventTimer = 30;
        }
        this.trace(new StringBuffer().append(".init( view ), activated: ").append(this.is_activated()).append(", alpha: ").append(this.alpha).append(", availableInVariant: ").append(this.is_availableInVariant()).append(", enabled: ").append(this.is_enabled()).append(", fireEventTimer: ").append(this.fireEventTimer).append(", ValueChangeTimerMultiplier: ").append(3).append(", height: ").append(this.get_height()).append(", imageSliderValuePointX: ").append(this.imageSliderValuePointX).append(", imageSliderValuePointY: ").append(this.imageSliderValuePointY).append(", interactive: ").append(this.is_interactive()).append(", layoutable: ").append(this.is_layoutable()).append(", orientation: ").append(this.get_orientation()).append(", paddingMax: ").append(this.get_paddingMax()).append(", paddingMin: ").append(this.get_paddingMin()).append(", progressMode: ").append(this.is_progressMode()).append(", reflectionEnabled: ").append(this.is_reflectionEnabled()).append(", selected: ").append(this.is_selected()).append(", state: ").append(this.get_state()).append(", step: ").append(this.get_step()).append(", touchInsets: ").append(this.get_touchInsets()).append(", value: ").append(this.get_value()).append(", valueChangeInstantly: ").append(this.valueChangeInstantly).append(", valueChangeOnlyOnRelease: ").append(this.valueChangeOnlyOnRelease).append(", valueMax: ").append(this.get_valueMax()).append(", valueMin: ").append(this.get_valueMin()).append(", visible: ").append(this.is_visible()).append(", width: ").append(this.width).append(", wrapFlag: ").append(this.is_wrapFlag()).append(", x: ").append(this.x).append(", y: ").append(this.y).toString());
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$SliderUI == null ? (class$de$vw$mib$widgets$ui$SliderUI = Slider.class$("de.vw.mib.widgets.ui.SliderUI")) : class$de$vw$mib$widgets$ui$SliderUI, class$de$vw$mib$widgets$ui$SliderCurveUI == null ? (class$de$vw$mib$widgets$ui$SliderCurveUI = Slider.class$("de.vw.mib.widgets.ui.SliderCurveUI")) : class$de$vw$mib$widgets$ui$SliderCurveUI};
    }

    @Override
    public final Image[] get_imagesSlider() {
        return this.imagesSlider;
    }

    @Override
    public final void set_imagesSlider(Image[] imageArray) {
        Object[] objectArray = this.imagesSlider;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesSlider = imageArray;
            this.imagesSliderChanged((Image[])objectArray);
            this.propertyChanged(43);
        }
    }

    @Override
    public Color[] get_colorsSlider() {
        return this.colorsSlider;
    }

    @Override
    public void set_colorsSlider(Color[] colorArray) {
        Object[] objectArray = this.colorsSlider;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.colorsSlider = colorArray;
            this.colorsSliderChanged((Color[])objectArray);
            this.propertyChanged(44);
        }
    }

    @Override
    public final StaticImageModel get_imageSliderRef() {
        return this.imageSliderRef;
    }

    @Override
    public final void set_imageSliderRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageSliderRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageSliderRef = staticImageModel;
            this.imageSliderRefChanged(staticImageModel2);
            this.propertyChanged(45);
        }
    }

    @Override
    public final Image[] get_imagesProgress() {
        return this.imagesProgress;
    }

    @Override
    public final void set_imagesProgress(Image[] imageArray) {
        Object[] objectArray = this.imagesProgress;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesProgress = imageArray;
            this.imagesProgressChanged((Image[])objectArray);
            this.propertyChanged(46);
        }
    }

    @Override
    public Color[] get_colorsProgress() {
        return this.colorsProgress;
    }

    @Override
    public void set_colorsProgress(Color[] colorArray) {
        Object[] objectArray = this.colorsProgress;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.colorsProgress = colorArray;
            this.colorsProgressChanged((Color[])objectArray);
            this.propertyChanged(47);
        }
    }

    @Override
    public final StaticImageModel get_imageProgressRef() {
        return this.imageProgressRef;
    }

    @Override
    public final void set_imageProgressRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageProgressRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageProgressRef = staticImageModel;
            this.imageProgressRefChanged(staticImageModel2);
            this.propertyChanged(48);
        }
    }

    @Override
    public final StaticImageModel[] get_imageProgressIndicatorRefs() {
        return this.imageProgressIndicatorRefs;
    }

    @Override
    public final void set_imageProgressIndicatorRefs(StaticImageModel[] staticImageModelArray) {
        Object[] objectArray = this.imageProgressIndicatorRefs;
        if (!Arrays.equals(objectArray, staticImageModelArray)) {
            this.imageProgressIndicatorRefs = staticImageModelArray;
            this.imageProgressIndicatorRefsChanged((StaticImageModel[])objectArray);
            this.propertyChanged(49);
        }
    }

    @Override
    public Image[] get_imagesProgressIndicatorActive() {
        return this.imagesProgressIndicatorActive;
    }

    @Override
    public void set_imagesProgressIndicatorActive(Image[] imageArray) {
        Object[] objectArray = this.imagesProgressIndicatorActive;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesProgressIndicatorActive = imageArray;
            this.imagesProgressIndicatorActiveChanged((Image[])objectArray);
            this.propertyChanged(50);
        }
    }

    @Override
    public Image[] get_imagesProgressIndicatorPassive() {
        return this.imagesProgressIndicatorPassive;
    }

    @Override
    public void set_imagesProgressIndicatorPassive(Image[] imageArray) {
        Object[] objectArray = this.imagesProgressIndicatorPassive;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesProgressIndicatorPassive = imageArray;
            this.imagesProgressIndicatorPassiveChanged((Image[])objectArray);
            this.propertyChanged(51);
        }
    }

    @Override
    public final int get_imageSliderValuePointX() {
        return this.imageSliderValuePointX;
    }

    @Override
    public final void set_imageSliderValuePointX(int n) {
        int n2 = this.imageSliderValuePointX;
        if (n2 != n) {
            this.imageSliderValuePointX = n;
            this.imageSliderValuePointXChanged(n2);
            this.propertyChanged(52);
        }
    }

    @Override
    public final int get_imageSliderValuePointY() {
        return this.imageSliderValuePointY;
    }

    @Override
    public final void set_imageSliderValuePointY(int n) {
        int n2 = this.imageSliderValuePointY;
        if (n2 != n) {
            this.imageSliderValuePointY = n;
            this.imageSliderValuePointYChanged(n2);
            this.propertyChanged(53);
        }
    }

    @Override
    public final boolean is_progressMode() {
        return this.getInternalStateFlag(22);
    }

    @Override
    public final void set_progressMode(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(22);
        if (bl2 != bl) {
            this.setInternalStateFlag(22, bl);
            this.progressModeChanged(bl2);
            this.propertyChanged(54);
        }
    }

    @Override
    public final boolean is_valueChangeOnlyOnRelease() {
        return this.valueChangeOnlyOnRelease;
    }

    @Override
    public final void set_valueChangeOnlyOnRelease(boolean bl) {
        boolean bl2 = this.valueChangeOnlyOnRelease;
        if (bl2 != bl) {
            this.valueChangeOnlyOnRelease = bl;
            this.valueChangeOnlyOnReleaseChanged(bl2);
            this.propertyChanged(55);
        }
    }

    @Override
    public boolean is_valueChangeInstantly() {
        return this.valueChangeInstantly;
    }

    @Override
    public void set_valueChangeInstantly(boolean bl) {
        boolean bl2 = this.valueChangeInstantly;
        if (bl2 != bl) {
            this.valueChangeInstantly = bl;
            this.propertyChanged(56);
        }
    }

    @Override
    public final int get_fireEventTimer() {
        return this.fireEventTimer;
    }

    @Override
    public final void set_fireEventTimer(int n) {
        int n2 = this.fireEventTimer;
        if (n2 != n) {
            this.fireEventTimer = n;
            this.fireEventTimerChanged(n2);
            this.propertyChanged(57);
        }
    }

    @Override
    protected int getValueChangeTimer() {
        return 3 * this.fireEventTimer;
    }

    @Override
    public void setPositionOnScrollbarButton(int n, int n2) {
        StaticImageModel staticImageModel = this.get_imageSliderRef();
        if (staticImageModel != null) {
            this.positionOnScrollbarButton = SliderCalculator.getPositionOnScrollbarButton(this, n, n2, staticImageModel);
            if (this.positionOnScrollbarButton < 0) {
                this.positionOnScrollbarButton = this.get_orientation() > 1 ? this.imageSliderValuePointY : this.imageSliderValuePointX;
            }
        }
    }

    public int getActiveImageIndex() {
        return this.activeProgressImageIndex;
    }

    protected void updateImageIndexAndImageReferenceProperties(int n) {
        if (this.getActiveImageIndex() != n) {
            int n2 = this.getActiveImageIndex();
            if (n2 > n) {
                for (int i2 = n2; i2 > n; --i2) {
                    this.get_imageProgressIndicatorRefs()[i2].set_image(this.get_imagesProgressIndicatorPassive()[i2]);
                }
                if (n == 0) {
                    this.get_imageProgressIndicatorRefs()[n].set_image(this.get_imagesProgressIndicatorPassive()[n]);
                }
            } else {
                if (n2 == 0) {
                    this.get_imageProgressIndicatorRefs()[n2].set_image(this.get_imagesProgressIndicatorActive()[n2]);
                }
                for (int i3 = n2 + 1; i3 <= n; ++i3) {
                    this.get_imageProgressIndicatorRefs()[i3].set_image(this.get_imagesProgressIndicatorActive()[n]);
                }
            }
            this.activeProgressImageIndex = n;
        }
    }

    private void updateProgressIndicatorImages(int n) {
        if (this.checkProgressImageIndicatorDimensions()) {
            for (int i2 = 0; i2 < this.get_imageProgressIndicatorRefs().length; ++i2) {
                if (i2 <= n && n != 0) {
                    this.get_imageProgressIndicatorRefs()[i2].set_image(this.get_imagesProgressIndicatorActive()[i2]);
                    continue;
                }
                this.get_imageProgressIndicatorRefs()[i2].set_image(this.get_imagesProgressIndicatorPassive()[i2]);
            }
            this.activeProgressImageIndex = n;
            this.repaintParent();
        }
    }

    private int mapValueToIndex(int n) {
        int n2 = Math.min(Math.min(this.get_imagesProgressIndicatorPassive().length, this.get_imagesProgressIndicatorActive().length), this.get_imageProgressIndicatorRefs().length);
        return (int)((float)n / (float)(this.get_valueMax() - this.get_valueMin()) * (float)(n2 - 1)) % n2;
    }

    @Override
    protected void valueChanged(int n) {
        int n2 = this.get_value();
        if (!this.startSlidingAnimation(n)) {
            int n3 = SliderCalculator.calculateSliderPositionByValue(this, n2);
            this.setScalePosition(n3);
            if (!this.isPressed()) {
                this.updateSliderImageGeometry();
                this.updateProgressImageGeometry();
            } else if (!this.is_valueChangeInstantly()) {
                this.updateProgressImageGeometry();
            }
            this.updateProgressImages(n);
        }
        this.repaint();
    }

    @Override
    protected void valueMinChanged(int n) {
        super.valueMinChanged(n);
        this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, this.get_value()));
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    @Override
    protected void valueMaxChanged(int n) {
        super.valueMaxChanged(n);
        this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, this.get_value()));
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    @Override
    protected void paddingMinChanged(int n) {
        super.paddingMinChanged(n);
        this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, this.get_value()));
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    @Override
    protected void paddingMaxChanged(int n) {
        super.paddingMaxChanged(n);
        this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, this.get_value()));
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    @Override
    protected void stepChanged(int n) {
    }

    @Override
    protected void orientationChanged(int n) {
        super.orientationChanged(n);
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    protected void imagesSliderChanged(Image[] imageArray) {
        this.updateSliderImage();
    }

    protected void colorsSliderChanged(Color[] colorArray) {
        this.updateSliderImage();
    }

    protected void imagesProgressChanged(Image[] imageArray) {
        this.updateProgressImage();
    }

    protected void colorsProgressChanged(Color[] colorArray) {
        this.updateProgressImage();
    }

    protected void imageSliderRefChanged(StaticImageModel staticImageModel) {
        this.updateSliderImage();
    }

    protected void imageProgressRefChanged(StaticImageModel staticImageModel) {
        this.updateProgressImage();
    }

    protected void imageProgressIndicatorRefsChanged(StaticImageModel[] staticImageModelArray) {
        this.updateProgressImages(this.get_valueMin());
    }

    protected void imagesProgressIndicatorActiveChanged(Image[] imageArray) {
        this.updateProgressImages(this.get_valueMin());
    }

    protected void imagesProgressIndicatorPassiveChanged(Image[] imageArray) {
        this.updateProgressImages(this.get_valueMin());
    }

    protected void imageSliderValuePointXChanged(int n) {
        this.calculateScaleRatio(0);
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    protected void imageSliderValuePointYChanged(int n) {
        this.calculateScaleRatio(0);
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    protected void progressModeChanged(boolean bl) {
        this.calculateScaleRatio(0);
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
    }

    protected void valueChangeOnlyOnReleaseChanged(boolean bl) {
    }

    protected void easingChanged(EasingParams easingParams) {
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, this.get_value()));
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, this.get_value()));
        this.updateSliderImageGeometry();
        this.updateProgressImageGeometry();
        this.repaint();
    }

    @Override
    protected void calculateScaleRatio(int n) {
        if (this.is_progressMode()) {
            int n2 = this.get_orientation();
            if (0 == n2 || 1 == n2) {
                int n3 = this.get_imageSliderValuePointX();
                super.calculateScaleRatio(n + n3);
            } else {
                super.calculateScaleRatio(n + this.get_imageSliderValuePointY());
            }
        } else {
            super.calculateScaleRatio(n);
        }
    }

    protected void updateSliderImage() {
        StaticImageModel staticImageModel = this.get_imageSliderRef();
        if (staticImageModel != null) {
            Image[] imageArray = this.get_imagesSlider();
            int n = this.inferIndexFromState();
            if (imageArray != null && imageArray.length > n) {
                staticImageModel.set_image(imageArray[n]);
            } else {
                staticImageModel.set_image(null);
            }
            if (this.colorsSlider != null && this.colorsSlider.length > n) {
                staticImageModel.set_color(this.colorsSlider[n]);
            } else {
                staticImageModel.set_color(Color.WHITE);
            }
        }
    }

    protected void updateProgressImage() {
        StaticImageModel staticImageModel = this.get_imageProgressRef();
        if (staticImageModel != null) {
            Image[] imageArray = this.get_imagesProgress();
            int n = this.inferIndexFromState();
            if (imageArray != null && imageArray.length > n) {
                staticImageModel.set_image(imageArray[n]);
            } else {
                staticImageModel.set_image(null);
            }
            if (this.colorsProgress != null && this.colorsProgress.length > n) {
                staticImageModel.set_color(this.colorsProgress[n]);
            } else {
                staticImageModel.set_color(Color.WHITE);
            }
        }
    }

    private boolean checkProgressImageIndicatorPassiveDimensions() {
        return this.get_imageProgressIndicatorRefs() != null && this.get_imagesProgressIndicatorPassive() != null && this.get_imageProgressIndicatorRefs().length == this.get_imagesProgressIndicatorPassive().length;
    }

    private boolean checkProgressImageIndicatorActiveDimensions() {
        return this.get_imageProgressIndicatorRefs() != null && this.get_imagesProgressIndicatorActive() != null && this.get_imageProgressIndicatorRefs().length == this.get_imagesProgressIndicatorActive().length;
    }

    private boolean checkProgressImageIndicatorDimensions() {
        return this.checkProgressImageIndicatorPassiveDimensions() && this.checkProgressImageIndicatorActiveDimensions() && this.get_imageProgressIndicatorRefs().length > 1;
    }

    private boolean isProgressImageAnimationAvailable() {
        return ANIMATIONS_ENABLED && this.areAnimationsEnabled() && this.isEasingAvailable(10) && this.get_valueMax() != this.get_valueMin() && this.checkProgressImageIndicatorDimensions();
    }

    private boolean startProgressImageValueChangeAnimation(int n) {
        int n2 = this.mapValueToIndex(this.get_value());
        EasingParams easingParams = this.get_easing()[10];
        easingParams = new EasingParams(easingParams);
        int n3 = easingParams.getDuration() * Math.abs(n2 - n);
        easingParams.setDuration(n3);
        if (n != n2) {
            this.progressImageValueChangeAnimation = new Slider$ProgressImageValueChangeAnimation(this, easingParams, n, n2);
            ServiceManager.animationManager.startAnimation(this.progressImageValueChangeAnimation);
            this.trace(new StringBuffer().append(" - Started progressImageValueChangeAnimation - images count: ").append(this.get_imageProgressIndicatorRefs().length).append(", newIndex: ").append(n2).append(", (oldIndex: ").append(n).append("), duration: ").append(easingParams.getDuration()).toString());
        }
        return true;
    }

    private void stopValueChangeAnimation() {
        if (this.isValueChangeAnimationRunning()) {
            ServiceManager.animationManager.stopAnimation(this.progressImageValueChangeAnimation);
            this.progressImageValueChangeAnimation = null;
            this.trace(" - Stopped progressImageValueChangeAnimation timer");
        }
    }

    private boolean isValueChangeAnimationRunning() {
        return this.progressImageValueChangeAnimation != null && this.progressImageValueChangeAnimation.isActive();
    }

    public void updateProgressImages(int n) {
        if (this.isProgressImageAnimationAvailable()) {
            int n2 = this.mapValueToIndex(n);
            if (this.isValueChangeAnimationRunning()) {
                this.stopValueChangeAnimation();
                n2 = this.getActiveImageIndex();
            }
            this.startProgressImageValueChangeAnimation(n2);
        } else if (this.checkProgressImageIndicatorActiveDimensions() && this.get_imageProgressIndicatorRefs().length > 1) {
            int n3 = this.mapValueToIndex(this.get_value());
            this.updateProgressIndicatorImages(n3);
        }
    }

    @Override
    public void updateProgressImageGeometry() {
        this.trace(".updateProgressImageGeometry()");
        this.setProgressBounds();
        this.updateProgressImage();
    }

    protected void updateSliderImageGeometry() {
        this.trace(".updateSliderImageGeometry()");
        this.updateSliderImagePosition();
        this.updateSliderImage();
    }

    @Override
    protected void updateImages() {
        super.updateImages();
        this.updateSliderImage();
        this.updateProgressImage();
    }

    @Override
    public int updatePosition(int n, int n2, boolean bl) {
        int n3 = this.calculateValuePointByTouchPosition(n, n2);
        int n4 = SliderCalculator.calculateSliderValueByPosition(this, n3);
        int n5 = this.get_step();
        if (n5 == 0) {
            n5 = 1;
        }
        float f2 = (float)n4 - (float)this.get_valueMin();
        int n6 = Math.round(f2 / (float)n5);
        int n7 = this.get_valueMin() + n6 * n5;
        this.trace(new StringBuffer().append(".updatePosition();; x: ").append(n).append(", y: ").append(n2).append(", valuePoint: ").append(n3).append(", snapValue: ").append(n4).append(", roundedSnapValue: ").append(n7).append(", snap: ").append(bl).append(", step: ").append(n5).append(", stepNumber: ").append(n6).toString());
        if (bl) {
            this.setScalePosition(SliderCalculator.calculateSliderPositionByValue(this, n7));
        } else {
            this.setScalePosition(n3);
        }
        this.updateSliderImageGeometry();
        return n7;
    }

    private int calculateValuePointByTouchPosition(int n, int n2) {
        int n3 = SliderCalculator.getRelativePositionByOrientation(this, n, n2, false);
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = this.get_imageSliderValuePointX();
        int n8 = this.get_imageSliderValuePointY();
        int n9 = this.getPositionOnScrollbarButton();
        switch (this.get_orientation()) {
            case 0: {
                n4 = this.get_paddingMin();
                n5 = this.get_width() - this.get_paddingMax();
                n6 = n3 + n7 - n9;
                break;
            }
            case 1: {
                n4 = this.get_paddingMax();
                n5 = this.get_width() - this.get_paddingMin();
                n6 = n3 + n7 - n9;
                break;
            }
            case 2: {
                n4 = this.get_paddingMin();
                n5 = this.get_height() - this.get_paddingMax();
                n6 = n3 + n8 - n9;
                break;
            }
            case 3: {
                n4 = this.get_paddingMax();
                n5 = this.get_height() - this.get_paddingMin();
                n6 = n3 + n8 - n9;
                break;
            }
        }
        n6 = Util.clamp(n6, n4, n5);
        return n6;
    }

    private void updateSliderImagePosition() {
        StaticImageModel staticImageModel = this.get_imageSliderRef();
        if (staticImageModel != null) {
            this.disableAnimations();
            if (this.get_orientation() == 0 || this.get_orientation() == 1) {
                staticImageModel.set_x(this.getScalePosition() - this.imageSliderValuePointX);
            } else {
                staticImageModel.set_y(this.getScalePosition() - this.imageSliderValuePointY);
            }
            this.enableAnimations();
        }
    }

    private void setProgressBounds() {
        StaticImageModel staticImageModel = this.get_imageProgressRef();
        if (staticImageModel != null) {
            if (this.is_progressMode()) {
                int n = this.getScalePosition();
                int n2 = 0;
                int n3 = 0;
                int n4 = this.get_imageSliderValuePointX();
                int n5 = this.get_imageSliderValuePointY();
                this.disableAnimations();
                switch (this.get_orientation()) {
                    case 0: {
                        n2 = n - this.get_paddingMin() <= 0 ? 0 : n4;
                        staticImageModel.set_x(0);
                        staticImageModel.set_width(Math.min(n + n2, this.get_width()));
                        break;
                    }
                    case 1: {
                        n2 = n + this.get_paddingMin() >= this.get_width() ? 0 : n4;
                        staticImageModel.set_x(Math.max(n - n2, 0));
                        staticImageModel.set_width(this.get_width() - n + n2);
                        break;
                    }
                    case 3: {
                        n3 = n + this.get_paddingMax() >= this.get_height() ? 0 : n5;
                        staticImageModel.set_y(n - n3);
                        staticImageModel.set_height(this.get_height() - n + n3);
                        break;
                    }
                    case 2: {
                        n3 = n - this.get_paddingMin() <= 0 ? 0 : n5;
                        staticImageModel.set_y(0);
                        staticImageModel.set_height(n + n3);
                        break;
                    }
                }
                this.enableAnimations();
            } else {
                int n = this.getScalePosition();
                int n6 = 63;
                int n7 = (int)((float)this.get_imageSliderValuePointX() * 63);
                int n8 = (int)((float)this.get_imageSliderValuePointX() * 63);
                int n9 = (int)((float)this.get_imageSliderValuePointY() * 63);
                int n10 = (int)((float)this.get_imageSliderValuePointY() * 63);
                Image[] imageArray = this.get_imagesProgress();
                int n11 = this.inferIndexFromState();
                if (imageArray != null && n11 < imageArray.length && n11 >= 0 && imageArray[n11] != null && imageArray[n11].getCurrentImage() != null && imageArray[n11].getCurrentImage().getInsets() != null) {
                    n7 = imageArray[n11].getCurrentImage().getInsets().getLeft() - 1;
                    n8 = imageArray[n11].getCurrentImage().getInsets().getRight() - 1;
                    n9 = imageArray[n11].getCurrentImage().getInsets().getTop() - 1;
                    n10 = imageArray[n11].getCurrentImage().getInsets().getBottom() - 1;
                }
                int n12 = 0;
                int n13 = 0;
                this.disableAnimations();
                switch (this.get_orientation()) {
                    case 0: {
                        n13 = n - this.get_paddingMin() <= 0 ? 0 : (n + this.get_paddingMax() >= this.get_width() ? this.get_width() : n + n8);
                        staticImageModel.set_x(n12);
                        staticImageModel.set_width(n13);
                        break;
                    }
                    case 1: {
                        if (n + this.get_paddingMin() >= this.get_width()) {
                            n12 = this.get_width();
                            n13 = 0;
                        } else if (n - this.get_paddingMax() <= 0) {
                            n13 = this.get_width();
                        } else {
                            n12 = n - n7;
                            n13 = this.get_width() - n12;
                        }
                        staticImageModel.set_x(n12);
                        staticImageModel.set_width(n13);
                        break;
                    }
                    case 3: {
                        if (n + this.get_paddingMin() >= this.get_height()) {
                            n12 = this.get_height();
                            n13 = 0;
                        } else if (n - this.get_paddingMax() <= 0) {
                            n12 = 0;
                            n13 = this.get_height();
                        } else {
                            n12 = n - n9;
                            n13 = this.get_height() - n12;
                        }
                        staticImageModel.set_y(n12);
                        staticImageModel.set_height(n13);
                        break;
                    }
                    case 2: {
                        n13 = n + this.get_paddingMax() >= this.get_height() ? this.get_height() : (n - this.get_paddingMin() <= 0 ? 0 : n + n10);
                        staticImageModel.set_y(n12);
                        staticImageModel.set_height(n13);
                        break;
                    }
                }
                this.enableAnimations();
            }
        }
    }

    private boolean startSlidingAnimation(int n) {
        EasingParams easingParams = this.getEasing(9);
        if (easingParams == null) {
            return false;
        }
        int n2 = this.get_value();
        this.stopSlidingAnimation();
        this.slidingAnimation = new Slider$SlidingAnimation(this, this, easingParams, n, n2);
        return this.startInternalAnimation(this.slidingAnimation);
    }

    private void stopSlidingAnimation() {
        if (this.slidingAnimation != null) {
            this.stopInternalAnimation(this.slidingAnimation);
            this.slidingAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopSlidingAnimation();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

