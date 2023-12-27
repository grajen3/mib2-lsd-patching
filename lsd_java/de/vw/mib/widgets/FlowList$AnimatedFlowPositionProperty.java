/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.FlowList;
import de.vw.mib.widgets.controller.FlowListController;

final class FlowList$AnimatedFlowPositionProperty
extends AbstractWidget$WidgetInternalAnimation {
    private boolean disableTargetSelectedIndexUpdates;
    private boolean animatedAdjustmentEnabled;
    private final int easingIndex;
    private final /* synthetic */ FlowList this$0;

    public FlowList$AnimatedFlowPositionProperty(FlowList flowList, int n) {
        this.this$0 = flowList;
        super(flowList);
        this.easingIndex = n;
    }

    public boolean startAnimation(float f2, boolean bl) {
        if (!Util.equalsEpsilon(f2, this.getTargetValue())) {
            this.disableTargetSelectedIndexUpdates = bl;
            EasingParams easingParams = this.this$0.getEasing(this.easingIndex);
            if (easingParams == null) {
                return false;
            }
            return this.startAnimation(this.this$0.flowPosition, f2, easingParams);
        }
        return true;
    }

    public boolean startAnimation(float f2, EasingParams easingParams, boolean bl) {
        if (!Util.equalsEpsilon(f2, this.getTargetValue())) {
            this.disableTargetSelectedIndexUpdates = bl;
            return this.startAnimation(this.this$0.flowPosition, f2, easingParams);
        }
        return true;
    }

    private boolean startAnimation(float f2, float f3, EasingParams easingParams) {
        boolean bl = this.isStarted();
        this.animatedAdjustmentEnabled = this.this$0.isAdjustmentEnabled();
        if (!bl) {
            this.this$0.stopInternalAnimation(this);
        }
        this.setEasingParams(easingParams);
        this.setStartValue(f2);
        this.setDeltaValue(f3 - f2);
        return bl || this.this$0.startInternalAnimation(this);
    }

    public float getTargetValue() {
        return this.clampValue(this.isActive() ? this.getStartValue() + this.getDeltaValue() : this.this$0.flowPosition);
    }

    private float clampValue(float f2) {
        int n = (int)f2;
        if (this.this$0.is_cyclicScrolling()) {
            if (n != 0) {
                f2 -= (float)n;
            }
            if (f2 < 0.0f) {
                f2 += 1.0f;
            }
        }
        return f2;
    }

    public void setValue(float f2) {
        float f3 = this.this$0.flowPosition;
        if (f3 != (f2 = this.this$0.clampFlowPosition(f2))) {
            this.this$0.flowPosition = f2;
            this.this$0.setSnappingEnabled(false);
            this.this$0.updateSelectedIndex();
            if (!this.disableTargetSelectedIndexUpdates) {
                this.this$0.setTargetSelectedIndex(this.this$0.get_selectedIndex());
            }
            this.this$0.setSnappingEnabled(true);
            this.this$0.invalidateFlowLayout();
        }
    }

    @Override
    public void stop() {
        super.stop();
        ((FlowListController)this.this$0.getController()).fireQueuedOutEvents();
        if (this.this$0.snapShortcutIndexOffset != 0) {
            this.this$0.snapShortcutIndexOffset = 0;
        }
    }

    @Override
    public void animate(float f2, long l, long l2) {
        if (!this.animatedAdjustmentEnabled) {
            this.this$0.disableAdjustmentChanged();
        }
        this.setValue(f2);
        if (!this.animatedAdjustmentEnabled) {
            this.this$0.enableAdjustmentChanged();
        }
    }
}

