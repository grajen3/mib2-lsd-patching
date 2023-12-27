/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.EnergyFlow;
import de.vw.mib.widgets.event.AnimationStateListener;

class EnergyFlow$EnergyFlowAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private CowList stateListeners;
    private final /* synthetic */ EnergyFlow this$0;

    public EnergyFlow$EnergyFlowAnimation(EnergyFlow energyFlow, EasingParams easingParams, float f2, float f3) {
        this.this$0 = energyFlow;
        super(energyFlow, true, easingParams);
        this.setStartValue(f2);
        this.setDeltaValue(f3 - f2);
        this.stateListeners = CowList.EMPTY;
        this.setAnimationInterval(83);
    }

    @Override
    public final void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.notifyStateListeners(f2);
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
        this.this$0.repaint();
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.notifyStateListeners(0.0f);
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }

    public void addStateListener(AnimationStateListener animationStateListener) {
        this.stateListeners = this.stateListeners.addIfAbsent(animationStateListener);
    }

    private void notifyStateListeners(float f2) {
        for (CowList cowList = this.stateListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AnimationStateListener animationStateListener = (AnimationStateListener)cowList.head();
            animationStateListener.updateCurrentAnimationState(this, f2);
        }
    }
}

