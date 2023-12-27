/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.Climate;
import de.vw.mib.widgets.Climate$ClimateInternalAnimation;

final class Climate$ZoomInOutAnimation
extends Climate$ClimateInternalAnimation {
    private final /* synthetic */ Climate this$0;

    public Climate$ZoomInOutAnimation(Climate climate, Climate climate2) {
        this.this$0 = climate;
        super(climate, climate2);
    }

    public Climate$ZoomInOutAnimation(Climate climate, Climate climate2, EasingParams easingParams) {
        this.this$0 = climate;
        super(climate, climate2, easingParams);
    }

    @Override
    protected void onAnimate(int n, int n2, int n3) {
        this.climate.setInteriorScale(n3);
        if (LOGGER.isTraceEnabled(2)) {
            LOGGER.trace(2).append("Widget '").append(this.climate.getQualifiedName()).append("': [ZoomInOutAnimation]: ").append("from=").append(n).append(" to=").append(n2).append(" current=").append(n3).append(" direction=").append(n < n2 ? "in" : "out").log();
        }
    }
}

