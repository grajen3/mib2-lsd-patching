/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.math.algebra.Rotation;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.MeshWidget$DemoAnimation;
import de.vw.mib.widgets.controller.DefaultMeshWidgetController;
import de.vw.mib.widgets.models.MeshWidgetModel;
import de.vw.mib.widgets.models.ViewModel;

public class MeshWidget
extends AbstractWidget
implements MeshWidgetModel {
    public static final int DEMO_ANIMATION_DURATION_MS;
    private String model;
    private MeshWidget$DemoAnimation demoAnimation;
    private int animationMode;
    private float animatedValue;
    private Rotation rotationStart;
    private Rotation rotationEnd;
    private Rotation rotationCurrent;
    private float zoom;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$MeshWidgetUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, String string, String string2, int n3, Insets insets, boolean bl5, int n4, int n5, int n6) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string2, n3, insets, bl5, n4, n5, n6);
        this.model = string;
        this.modelChanged(null);
        this.rotationStart = new Rotation();
        this.rotationEnd = new Rotation();
        this.rotationCurrent = new Rotation();
        this.zoom = 1.0f;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (this.getController() == null) {
            this.setController(new DefaultMeshWidgetController());
        }
        this.getController().init();
    }

    @Override
    public void activate() {
        super.activate();
        this.setAnimationMode(0);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$MeshWidgetUI == null ? (class$de$vw$mib$widgets$ui$MeshWidgetUI = MeshWidget.class$("de.vw.mib.widgets.ui.MeshWidgetUI")) : class$de$vw$mib$widgets$ui$MeshWidgetUI};
    }

    @Override
    public final String get_model() {
        return this.model;
    }

    @Override
    public final void set_model(String string) {
        String string2 = this.model;
        if (string2 == null || !string2.equals(string)) {
            this.model = string;
            this.modelChanged(string2);
            this.propertyChanged(16);
        }
    }

    @Override
    public int getAnimationMode() {
        return this.animationMode;
    }

    @Override
    public void setAnimationMode(int n) {
        this.animationMode = n;
        switch (n) {
            case 0: 
            case 1: {
                this.startDemoAnimation();
                break;
            }
            case 2: {
                this.stopDemoAnimation();
                break;
            }
            case 3: {
                this.startDemoAnimation();
                break;
            }
        }
    }

    @Override
    public float getAnimatedValue() {
        return this.animatedValue;
    }

    @Override
    public void setAnimatedValue(float f2) {
        this.animatedValue = f2;
    }

    @Override
    public Rotation getRotationStart() {
        return this.rotationStart;
    }

    @Override
    public void setRotationStart(Rotation rotation) {
        this.rotationStart.set(rotation);
        this.repaint();
    }

    @Override
    public Rotation getRotationEnd() {
        return this.rotationEnd;
    }

    @Override
    public void setRotationEnd(Rotation rotation) {
        this.rotationEnd.set(rotation);
        this.repaint();
    }

    @Override
    public Rotation getRotationCurrent() {
        return this.rotationCurrent;
    }

    @Override
    public void setRotationCurrent(Rotation rotation) {
        this.rotationCurrent.set(rotation);
        this.repaint();
    }

    @Override
    public float getZoom() {
        return this.zoom;
    }

    @Override
    public void setZoom(float f2) {
        this.zoom = f2;
        this.repaint();
    }

    protected void modelChanged(String string) {
    }

    private boolean startDemoAnimation() {
        this.stopDemoAnimation();
        EasingParams easingParams = new EasingParams(3, 1, 10000);
        if (easingParams == null || easingParams.getEasingClass() == 0 || !this.areAnimationsEnabled()) {
            return false;
        }
        switch (this.animationMode) {
            case 0: {
                this.demoAnimation = new MeshWidget$DemoAnimation(this, this, easingParams, 0.0f, 1.0f);
                break;
            }
            case 1: {
                this.demoAnimation = new MeshWidget$DemoAnimation(this, this, easingParams, 1.0f, 32959);
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                this.demoAnimation = new MeshWidget$DemoAnimation(this, this, easingParams, 0.0f, 1.0f);
                break;
            }
        }
        return this.startInternalAnimation(this.demoAnimation);
    }

    private void stopDemoAnimation() {
        if (this.demoAnimation != null) {
            this.stopInternalAnimation(this.demoAnimation);
            this.demoAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopDemoAnimation();
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

