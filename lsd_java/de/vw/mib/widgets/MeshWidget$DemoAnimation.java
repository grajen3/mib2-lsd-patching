/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.MeshWidget;

public final class MeshWidget$DemoAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final MeshWidget meshWidget;
    private final /* synthetic */ MeshWidget this$0;

    public MeshWidget$DemoAnimation(MeshWidget meshWidget, MeshWidget meshWidget2, EasingParams easingParams, float f2, float f3) {
        this.this$0 = meshWidget;
        super(meshWidget, easingParams, f2, f3);
        this.setLooped(true);
        this.meshWidget = meshWidget2;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.meshWidget.setAnimatedValue(f2);
    }

    @Override
    public void stop() {
        super.stop();
    }
}

