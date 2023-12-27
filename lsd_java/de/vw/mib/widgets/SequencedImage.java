/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.SequencedImage$ImageFadeAnimation;
import de.vw.mib.widgets.SequencedImage$ImageSequenceAnimation;
import de.vw.mib.widgets.SequencedImage$ImageValueChangeAnimation;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.SequencedImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.util.Arrays;

public class SequencedImage
extends AbstractImage
implements SequencedImageModel {
    private static final int ANIMATION_INTERVAL_MIN;
    private Image[] sequenceImages;
    private int value;
    private int valueMax;
    private int valueMin;
    private int activeImageIndex;
    private CowList adjustmentListeners;
    private int adjustmentShadowCounter;
    private SequencedImage$ImageSequenceAnimation sequenceAnimation;
    private SequencedImage$ImageValueChangeAnimation valueChangeAnimation;
    private float[] alphas;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SequencedImageUI;

    @Override
    protected void reset() {
        super.reset();
        this.adjustmentListeners = CowList.EMPTY;
        this.sequenceImages = null;
        this.sequenceAnimation = null;
        this.activeImageIndex = 0;
        this.valueChangeAnimation = null;
        this.alphas = null;
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, boolean bl5, String string, boolean bl6, Image[] imageArray, int n4, Insets insets, int n5, int n6, int n7, boolean bl7, int n8, int n9, int n10) {
        super.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, bl5, string, n4, insets, bl7, n8, n9, n10);
        this.value = n5;
        this.valueMax = n6;
        this.valueMin = n7;
        this.sequenceImages = imageArray;
        this.setInternalStateFlag(9, bl6);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_sequenceImages());
        this.alphas = new float[0];
        this.updateActiveImageIndex();
    }

    @Override
    public void deInit() {
        this.alphas = null;
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        if (this.is_visible() && this.areParentsVisible() && this.isEasingAnimationAvailable(7)) {
            this.startSequenceAnimation();
        }
    }

    @Override
    public void deActivate() {
        this.stopAnimations();
        super.deActivate();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$SequencedImageUI == null ? (class$de$vw$mib$widgets$ui$SequencedImageUI = SequencedImage.class$("de.vw.mib.widgets.ui.SequencedImageUI")) : class$de$vw$mib$widgets$ui$SequencedImageUI};
    }

    @Override
    public final boolean is_repeat() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public final void set_repeat(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.repeatChanged(bl2);
            this.propertyChanged(20);
        }
    }

    @Override
    public final Image[] get_sequenceImages() {
        return this.sequenceImages;
    }

    @Override
    public final void set_sequenceImages(Image[] imageArray) {
        Object[] objectArray = this.sequenceImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.sequenceImages = imageArray;
            this.sequenceImagesChanged((Image[])objectArray);
            this.propertyChanged(21);
        }
    }

    @Override
    public final int get_value() {
        return this.value;
    }

    @Override
    public final void set_value(int n) {
        int n2 = this.value;
        if (n2 != n) {
            this.value = n;
            this.valueChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public final int get_valueMax() {
        return this.valueMax;
    }

    @Override
    public final void set_valueMax(int n) {
        int n2 = this.valueMax;
        if (n2 != n) {
            this.valueMax = n;
            this.valueMaxChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final int get_valueMin() {
        return this.valueMin;
    }

    @Override
    public final void set_valueMin(int n) {
        int n2 = this.valueMin;
        if (n2 != n) {
            this.valueMin = n;
            this.valueMinChanged(n2);
            this.propertyChanged(24);
        }
    }

    @Override
    public int getActiveImageIndex() {
        return this.activeImageIndex;
    }

    protected void setActiveImageIndex(int n, boolean bl) {
        if (this.activeImageIndex != n) {
            if (bl) {
                int n2 = this.activeImageIndex;
                this.handleCrossfading(n2, n);
            }
            this.activeImageIndex = n;
            this.repaintParent();
        }
    }

    private void handleCrossfading(int n, int n2) {
        EasingParams easingParams;
        if (this.alphas == null || this.alphas.length == 0) {
            this.updateAlphas();
        }
        if (this.isEasingAvailable(10)) {
            easingParams = this.get_easing()[10];
            ServiceManager.animationManager.startAnimation(new SequencedImage$ImageFadeAnimation(this, easingParams, n, AbstractWidgetUI.normalizeAlpha(this.get_alpha()), 0.0f));
        }
        if (this.isEasingAvailable(11)) {
            easingParams = this.get_easing()[11];
            ServiceManager.animationManager.startAnimation(new SequencedImage$ImageFadeAnimation(this, easingParams, n2, 0.0f, AbstractWidgetUI.normalizeAlpha(this.get_alpha())));
        }
    }

    @Override
    public boolean isImagefadingActive() {
        if (this.alphas != null) {
            return this.alphas.length > 0;
        }
        return false;
    }

    protected void updateAlphaForIndex(int n, float f2, boolean bl) {
        if (this.alphas != null && n >= 0 && n < this.alphas.length) {
            this.alphas[n] = f2;
            if (bl) {
                this.repaint();
            }
        }
    }

    private void updateAlphas() {
        if (this.isEasingAnimationAvailable(10) || this.isEasingAnimationAvailable(11)) {
            this.alphas = new float[this.sequenceImages.length];
        }
    }

    @Override
    public float[] getAlphas() {
        return this.alphas;
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        if (!bl && this.areParentsVisible()) {
            this.startSequenceAnimation();
        } else {
            this.stopSequenceAnimation();
        }
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        super.parentVisibilityChanged(bl);
        if (this.is_visible()) {
            if (!bl) {
                this.startSequenceAnimation();
            } else {
                this.stopSequenceAnimation();
            }
        }
    }

    protected void repeatChanged(boolean bl) {
        if (this.is_visible() && this.areParentsVisible()) {
            if (this.isSequenceAnimationRunning()) {
                this.sequenceAnimation.setLooped(!bl);
            } else if (!bl) {
                this.startSequenceAnimation();
            }
            if (this.isValueChangeAnimationRunning()) {
                this.valueChangeAnimation.setLooped(!bl);
            }
        }
    }

    protected void sequenceImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_sequenceImages());
        if (this.isSequenceAnimationRunning()) {
            this.stopSequenceAnimation();
            this.startSequenceAnimation();
        }
        this.updateActiveImageIndex();
        this.repaint();
    }

    protected void valueChanged(int n) {
        int n2 = -1;
        boolean bl = false;
        if (this.areAnimationsEnabled()) {
            if (this.isEasingAnimationAvailable(8)) {
                n2 = 8;
            } else if (this.isEasingAnimationAvailable(9)) {
                n2 = 9;
            }
        }
        if (n2 != -1) {
            if (this.isValueChangeAnimationRunning()) {
                this.stopValueChangeAnimation();
                n = this.mapIndexToValue(this.getActiveImageIndex());
            }
            bl = this.startImageValueChangeAnimation(n, n2);
        }
        if (!bl) {
            this.updateActiveImageIndex();
        }
    }

    private boolean isEasingAnimationAvailable(int n) {
        return ANIMATIONS_ENABLED && this.isEasingAvailable(n) && SequencedImage.isEasingValid(this.get_easing()[n]) && this.sequenceImages != null && this.sequenceImages.length != 0;
    }

    protected void valueMaxChanged(int n) {
        this.updateActiveImageIndex();
    }

    protected void valueMinChanged(int n) {
        this.updateActiveImageIndex();
    }

    private void updateActiveImageIndex() {
        if (this.get_sequenceImages() == null || this.get_sequenceImages().length == 0 || this.get_valueMax() == this.get_valueMin()) {
            this.setActiveImageIndex(0, false);
            return;
        }
        int n = this.mapValueToIndex(this.get_value());
        this.setActiveImageIndex(n, false);
    }

    private boolean isViewActivated() {
        return this.getView() != null && this.getView().is_activated();
    }

    private boolean canStartSequenceAnimation() {
        return !this.isSequenceAnimationRunning() && this.isViewActivated();
    }

    private boolean isSequenceAnimationRunning() {
        return this.sequenceAnimation != null && this.sequenceAnimation.isActive();
    }

    private int mapValueToIndex(int n) {
        if (this.get_sequenceImages() == null || this.get_sequenceImages().length < 2 || this.get_valueMax() == this.get_valueMin()) {
            return 0;
        }
        return (int)((float)n / (float)(this.get_valueMax() - this.get_valueMin()) * (float)(this.get_sequenceImages().length - 1)) % this.get_sequenceImages().length;
    }

    private int mapIndexToValue(int n) {
        if (this.get_sequenceImages() == null || this.get_sequenceImages().length < 2) {
            return 0;
        }
        return (int)((float)n / (float)(this.get_sequenceImages().length - 1) * (float)(this.get_valueMax() - this.get_valueMin()));
    }

    private boolean startSequenceAnimation() {
        EasingParams easingParams;
        if (!this.canStartSequenceAnimation()) {
            return false;
        }
        EasingParams[] easingParamsArray = this.get_easing();
        EasingParams easingParams2 = easingParams = easingParamsArray != null && easingParamsArray.length > 7 ? easingParamsArray[7] : null;
        if (!ANIMATIONS_ENABLED || easingParams == null || !SequencedImage.isEasingValid(easingParams) || this.sequenceImages == null || this.sequenceImages.length == 0) {
            return false;
        }
        if (easingParams.getEasingClass() != 0) {
            easingParams.setEasingClass((short)1);
        }
        this.sequenceAnimation = new SequencedImage$ImageSequenceAnimation(this, easingParams, 0, this.sequenceImages.length - 1, this.is_repeat());
        ServiceManager.animationManager.startAnimation(this.sequenceAnimation);
        if (LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = LOGGER.trace(512);
            logMessage.append(new StringBuffer().append("SequencedImage - Started sequence timer - Widget:").append(this.toString()).append(" images:").append(this.sequenceImages.length).append(" duration: ").append(easingParams.getDuration()).append(" repeat:").append(this.is_repeat()).toString()).log();
        }
        return true;
    }

    private void stopAnimations() {
        this.stopSequenceAnimation();
        this.stopValueChangeAnimation();
        if (this.alphas != null) {
            this.alphas = new float[0];
        }
    }

    private void stopSequenceAnimation() {
        if (this.isSequenceAnimationRunning()) {
            ServiceManager.animationManager.stopAnimation(this.sequenceAnimation);
            this.sequenceAnimation = null;
            if (LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = LOGGER.trace(512);
                logMessage.append(new StringBuffer().append("SequencedImage - Stopped sequence timer - Widget:").append(this.toString()).toString()).log();
            }
        }
    }

    private boolean startImageValueChangeAnimation(int n, int n2) {
        if (!this.isViewActivated()) {
            return false;
        }
        int n3 = this.mapValueToIndex(n);
        int n4 = this.mapValueToIndex(this.get_value());
        EasingParams easingParams = this.get_easing()[n2];
        if (n2 == 9) {
            easingParams = new EasingParams(easingParams);
            int n5 = n4 - n3;
            int n6 = easingParams.getDuration() * Math.abs(n5);
            easingParams.setDuration(n6);
        }
        if (n3 != n4 && n4 > -1) {
            this.valueChangeAnimation = new SequencedImage$ImageValueChangeAnimation(this, easingParams, this.is_repeat(), n3, n4);
            ServiceManager.animationManager.startAnimation(this.valueChangeAnimation);
        }
        if (LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = LOGGER.trace(512);
            logMessage.append(new StringBuffer().append("SequencedImage - Started imageValueChangeAnimation timer - Widget:").append(this.toString()).append(" images:").append(this.sequenceImages.length).append(" duration: ").append(easingParams.getDuration()).append(" repeat:").append(this.is_repeat()).toString()).log();
        }
        return true;
    }

    private void stopValueChangeAnimation() {
        if (this.isValueChangeAnimationRunning()) {
            ServiceManager.animationManager.stopAnimation(this.valueChangeAnimation);
            this.valueChangeAnimation = null;
            if (LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = LOGGER.trace(512);
                logMessage.append(new StringBuffer().append("SequencedImage - Stopped valueChangeAnimation timer - Widget:").append(this.toString()).toString()).log();
            }
        }
    }

    private boolean isValueChangeAnimationRunning() {
        return this.valueChangeAnimation != null && this.valueChangeAnimation.isActive();
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
    }

    @Override
    public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.addIfAbsent(adjustmentListener);
    }

    @Override
    public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.remove(adjustmentListener);
    }

    @Override
    public int getMinimum() {
        return this.get_valueMin();
    }

    @Override
    public void setMinimum(int n) {
        this.set_valueMin(n);
    }

    @Override
    public int getMaximum() {
        return this.get_valueMax();
    }

    @Override
    public void setMaximum(int n) {
        this.set_valueMax(n);
    }

    @Override
    public int getBlockIncrement() {
        return 1;
    }

    @Override
    public void setBlockIncrement(int n) {
    }

    @Override
    public int getValue() {
        return this.get_value();
    }

    @Override
    public void setValue(int n) {
        this.set_value(n);
    }

    @Override
    public int getUnitIncrement() {
        return 1;
    }

    @Override
    public void setUnitIncrement(int n) {
    }

    @Override
    public void disableAdjustmentChanged() {
        ++this.adjustmentShadowCounter;
    }

    @Override
    public void enableAdjustmentChanged() {
        --this.adjustmentShadowCounter;
    }

    @Override
    public boolean isAdjustmentEnabled() {
        return this.adjustmentShadowCounter == 0;
    }

    @Override
    public void adjustmentValueChanged(Adjustable adjustable, int n) {
        if (this.isAdjustmentEnabled() && n != 1 && n != 2 && n == 0) {
            this.setValue(adjustable.getValue());
        }
    }

    protected void notifyAdjustmentListener() {
        this.disableAdjustmentChanged();
        for (CowList cowList = this.adjustmentListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AdjustmentListener adjustmentListener = (AdjustmentListener)cowList.head();
            adjustmentListener.adjustmentValueChanged(this, 0);
        }
        this.enableAdjustmentChanged();
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

