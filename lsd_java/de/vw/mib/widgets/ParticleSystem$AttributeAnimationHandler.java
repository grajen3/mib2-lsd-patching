/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.ParticleSystem;
import de.vw.mib.widgets.ParticleSystem$AttributeAnimation;
import de.vw.mib.widgets.internal.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ParticleSystem$AttributeAnimationHandler
implements Runnable {
    public static final int ATTRIBUTE_AMPLITUDE;
    public static final int ATTRIBUTE_TINT_INTENSITY;
    public static final int ATTRIBUTE_PARTICLE_ALPHA;
    public static final int ATTRIBUTE_BLUR_INTENSITY;
    public static final int ATTRIBUTE_SCALE;
    public static final int ATTRIBUTE_GAP_X;
    public static final int ATTRIBUTE_GAP_Y;
    public static final int ATTRIBUTE_Z;
    public static final int ATTRIBUTE_PAN_X;
    public static final int ATTRIBUTE_PAN_Y;
    public static final int ATTRIBUTE_ROTATE_X;
    private final ParticleSystem$AttributeAnimation[] attributeAnimations = new ParticleSystem$AttributeAnimation[]{this.createAttributeAnimation(0, 0, 1.0f), this.createAttributeAnimation(1, 0, 181871420), this.createAttributeAnimation(2, 0, -842249156), this.createAttributeAnimation(1, 1, -842249156), this.createAttributeAnimation(0, 1, 28738), this.createAttributeAnimation(2, 2, 0x66660640), this.createAttributeAnimation(3, 2, 0x66660640)};
    private final List queuedAnimations = new ArrayList(5);
    private final ParticleSystem$AttributeAnimation overallAnimation = this.createAttributeAnimation(1, 2, 1.0f);
    private Image oldPrimaryMap = null;
    private Image oldSecondaryMap = null;
    private final /* synthetic */ ParticleSystem this$0;

    public ParticleSystem$AttributeAnimationHandler(ParticleSystem particleSystem) {
        this.this$0 = particleSystem;
    }

    @Override
    public void run() {
        if (AbstractWidget.LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = AbstractWidget.LOGGER.trace(512);
            logMessage.append("ParticleSystem ").append(this.this$0).append(": ").append(" Invoking attribute animation start");
            logMessage.log();
        }
        int n = this.startQueuedAnimations();
        this.updatePropertyMaps();
        if (n > 0) {
            this.startOverallAnimation(n);
        }
    }

    public void startAnimation(int n, EasingParams easingParams, float f2) {
        this.attributeAnimations[n].init(easingParams, f2);
        if (this.this$0.areAnimationsEnabled()) {
            if (AbstractWidget.LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = AbstractWidget.LOGGER.trace(512);
                logMessage.append("ParticleSystem ").append(this.this$0).append(": ");
                logMessage.append(" Enqueing animation start at:").append(n);
                logMessage.append(" to value:").append(f2);
                logMessage.append(" with easing:").append(easingParams);
                logMessage.log();
            }
            this.enqueueAnimation(this.attributeAnimations[n]);
        } else {
            if (AbstractWidget.LOGGER.isTraceEnabled(512)) {
                LogMessage logMessage = AbstractWidget.LOGGER.trace(512);
                logMessage.append("ParticleSystem ").append(this.this$0).append(": ");
                logMessage.append(" Animations disabled go directly to target value for attribute:").append(n);
                logMessage.append(" to value:").append(f2);
                logMessage.append(" with easing:").append(easingParams);
                logMessage.log();
            }
            this.attributeAnimations[n].setAnimationEndValue();
        }
    }

    public void propertyMapPrimaryChanged(Image image) {
        this.oldPrimaryMap = image;
    }

    public void propertyMapSecondaryChanged(Image image) {
        this.oldSecondaryMap = image;
    }

    public void updateEasingIfQueued(int n, EasingParams easingParams) {
        if (this.isQueued(n)) {
            this.attributeAnimations[n].setEasingParams(easingParams);
        }
    }

    public void stopAllAttributeAnimations() {
        for (int i2 = 0; i2 < this.attributeAnimations.length; ++i2) {
            this.this$0.stopInternalAnimation(this.attributeAnimations[i2]);
        }
    }

    public boolean isQueued(int n) {
        return this.queuedAnimations.contains(this.attributeAnimations[n]);
    }

    private int startQueuedAnimations() {
        int n = 0;
        Iterator iterator = this.queuedAnimations.iterator();
        while (iterator.hasNext()) {
            AbstractWidget$WidgetInternalAnimation abstractWidget$WidgetInternalAnimation = (AbstractWidget$WidgetInternalAnimation)iterator.next();
            if (!this.this$0.startInternalAnimation(abstractWidget$WidgetInternalAnimation)) {
                abstractWidget$WidgetInternalAnimation.stop();
                continue;
            }
            int n2 = abstractWidget$WidgetInternalAnimation.getEasingParams().getDuration() + abstractWidget$WidgetInternalAnimation.getEasingParams().getStartDelay();
            n = Math.max(n2, n);
        }
        this.queuedAnimations.clear();
        return n;
    }

    private void startOverallAnimation(int n) {
        EasingParams easingParams = new EasingParams();
        easingParams.setDuration(n);
        easingParams.setEasingClass((short)1);
        easingParams.setEasingKind((short)0);
        this.overallAnimation.setEasingParams(easingParams);
        if (this.overallAnimation.isActive()) {
            this.this$0.stopInternalAnimation(this.overallAnimation);
        }
        this.this$0.startInternalAnimation(this.overallAnimation);
    }

    private void updatePropertyMaps() {
        if (this.oldPrimaryMap != null) {
            this.this$0.propertyMapPrimaryOld = this.oldPrimaryMap;
            this.oldPrimaryMap = null;
            this.this$0.repaint();
        } else if (this.oldPrimaryMap != this.this$0.get_propertymapPrimary()) {
            this.oldPrimaryMap = this.this$0.get_propertymapPrimary();
            this.this$0.repaint();
        }
        if (this.oldSecondaryMap != null) {
            this.this$0.propertyMapSecondaryOld = this.oldSecondaryMap;
            this.oldSecondaryMap = null;
            this.this$0.repaint();
        } else if (this.oldSecondaryMap != this.this$0.get_propertymapSecondary()) {
            this.this$0.propertyMapSecondaryOld = this.this$0.get_propertymapSecondary();
            this.this$0.repaint();
        }
    }

    private ParticleSystem$AttributeAnimation createAttributeAnimation(int n, int n2, float f2) {
        return new ParticleSystem$AttributeAnimation(this.this$0, n, this.this$0.attributesStartValues[n2], this.this$0.attributesEndValues[n2], this.this$0.attributesAnimationValues[n2], f2);
    }

    private void enqueueAnimation(ParticleSystem$AttributeAnimation particleSystem$AttributeAnimation) {
        if (this.queuedAnimations.isEmpty()) {
            ServiceManager.eventDispatcher.invoke(this);
        }
        this.queuedAnimations.add(particleSystem$AttributeAnimation);
    }
}

