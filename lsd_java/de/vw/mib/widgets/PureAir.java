/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.PureAir$CleanAnimation;
import de.vw.mib.widgets.PureAir$IonisationAnimation;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.car.pureair.PureAirConfigData;
import de.vw.mib.widgets.models.PureAirModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.WidgetUI;
import java.util.Arrays;

public class PureAir
extends AbstractImage
implements PureAirModel {
    private PureAirConfigData configData;
    private RawConfigDataProxy rawConfigData;
    int[] stepX;
    int[] stepY;
    int step;
    int loopCount;
    int airMode;
    int valueClean;
    private int currentAlphaX;
    private int currentAlphaY;
    private float currentAlphaForFading;
    private float currentAlphaOverlay;
    private float currentAlpha;
    private float cleanThreshholdAlpha;
    private float cleanThreshholdAlphaBlur;
    private float cleanFgAlpha;
    private PureAir$IonisationAnimation ionisationAnimation;
    private PureAir$CleanAnimation cleanAnimation;
    private int currentLoop;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$PureAirUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, int n2, boolean bl2, Color color, int n3, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n4, boolean bl5, String string, int n5, Insets insets, int n6, boolean bl6, int n7, int n8, int n9) {
        super.init(bl, n2, bl2, color, n3, color2, bl3, easingParamsArray, bl4, n4, bl5, string, n5, insets, bl6, n7, n8, n9);
        this.airMode = n;
        this.valueClean = n6;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.stepX = new int[]{-165, 83, 213, 342, 555};
        this.stepY = new int[]{75, 0, 70, 153, 278};
        this.loopCount = 3;
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$PureAirUI == null ? (class$de$vw$mib$widgets$ui$PureAirUI = PureAir.class$("de.vw.mib.widgets.ui.PureAirUI")) : class$de$vw$mib$widgets$ui$PureAirUI};
    }

    public final AbstractConfigData getConfigData() {
        WidgetUI widgetUI = this.getUI();
        if (widgetUI != null && super.getClass() == (class$de$vw$mib$widgets$ui$PureAirUI == null ? (class$de$vw$mib$widgets$ui$PureAirUI = PureAir.class$("de.vw.mib.widgets.ui.PureAirUI")) : class$de$vw$mib$widgets$ui$PureAirUI)) {
            if (this.configData != null) {
                // empty if block
            }
            this.configData = new PureAirConfigData();
            if (!this.configData.isDeserialized()) {
                this.configData.init(this.rawConfigData);
            }
            return this.configData;
        }
        return null;
    }

    public void setRawConfigData(RawConfigDataProxy rawConfigDataProxy) {
        RawConfigDataProxy rawConfigDataProxy2 = this.rawConfigData;
        if (rawConfigDataProxy2 == null || !rawConfigDataProxy2.equals(rawConfigDataProxy)) {
            this.rawConfigData = rawConfigDataProxy;
            this.rawConfigDataChanged(rawConfigDataProxy2);
        }
    }

    @Override
    public void set_airMode(int n) {
        int n2 = this.airMode;
        if (n2 != n) {
            this.airMode = n;
            this.airModeChanged(n2);
            this.propertyChanged(20);
        }
    }

    @Override
    public int get_valueClean() {
        return this.airMode;
    }

    @Override
    public void set_valueClean(int n) {
        int n2 = this.valueClean;
        if (n2 != n) {
            this.valueClean = n;
            this.valueCleanChanged(n);
            this.startCleanAnimation(n2, n);
            this.propertyChanged(21);
        }
    }

    @Override
    public int get_airMode() {
        return this.airMode;
    }

    @Override
    public final int getIonisationStep() {
        return this.step;
    }

    @Override
    public final void setIonisationStep(int n) {
        int n2 = this.step;
        if (n2 != n) {
            if (this.airMode == 1) {
                this.startIonisationAnimation(n2, n);
            }
            this.step = n;
        }
    }

    @Override
    public final int[] getIonisationStepX() {
        return this.stepX;
    }

    @Override
    public final void setIonisationStepX(int[] nArray) {
        int[] nArray2 = this.stepX;
        if (!Arrays.equals(nArray2, nArray)) {
            this.stepX = nArray;
            this.stepXChanged(nArray2);
        }
    }

    @Override
    public final int[] getIonisationStepY() {
        return this.stepY;
    }

    public final void setIonisationStepY(int[] nArray) {
        int[] nArray2 = this.stepY;
        if (!Arrays.equals(nArray2, nArray)) {
            this.stepY = nArray;
            this.stepYChanged(nArray2);
        }
    }

    @Override
    public int getIonisationAlphaX() {
        return this.currentAlphaX;
    }

    @Override
    public void setIonisationAlphaX(int n) {
        this.currentAlphaX = n;
    }

    @Override
    public int getIonisationAlphaY() {
        return this.currentAlphaY;
    }

    @Override
    public void setIonisationAlphaY(int n) {
        this.currentAlphaY = n;
    }

    @Override
    public float getIonisationAlphaForFading() {
        return this.currentAlphaForFading;
    }

    @Override
    public void setIonisationAlphaForFading(float f2) {
        this.currentAlphaForFading = f2;
    }

    @Override
    public void setIonisationAlphaOverlay(float f2) {
        this.currentAlphaOverlay = f2;
    }

    @Override
    public void setIonisationAlpha(float f2) {
        this.currentAlpha = f2;
    }

    @Override
    public float getIonisationAlphaOverlay() {
        return this.currentAlphaOverlay;
    }

    @Override
    public float getIonisationAlpha() {
        return this.currentAlpha;
    }

    void setIonistaionAnimationPercentage(float f2) {
        this.currentAlphaForFading = (float)Math.sin(Math.PI * (double)f2);
        this.currentAlphaOverlay = (float)Math.pow(f2, 5.0);
        this.currentAlpha = (float)Math.atan(f2) / 16448;
    }

    @Override
    public float getCleanThreshholdAlpha() {
        return this.cleanThreshholdAlpha;
    }

    void setCleanThreshholdAlpha(float f2) {
        this.cleanThreshholdAlpha = f2;
    }

    @Override
    public float getCleanThreshholdAlphaBlur() {
        return this.cleanThreshholdAlphaBlur;
    }

    void setCleanThreshholdAlphaBlur(float f2) {
        this.cleanThreshholdAlphaBlur = f2;
    }

    @Override
    public void setCleanFgAlpha(float f2) {
        this.cleanFgAlpha = f2;
    }

    @Override
    public float getCleanFgAlpha() {
        return this.cleanFgAlpha;
    }

    @Override
    public int getIonisationLoopCount() {
        return this.loopCount;
    }

    @Override
    public int getIonisationLoop() {
        return this.currentLoop;
    }

    public void setIonisationLoop(int n) {
        this.currentLoop = n;
    }

    @Override
    public boolean isAnimationRunning() {
        return this.isCleanAnimationRunning();
    }

    protected void animateChanged(boolean bl) {
        this.setIonisationAlphaForFading(0.0f);
        this.setIonisationAlphaOverlay(0.0f);
        this.setIonisationAlpha(0.0f);
        this.setIonisationAlphaX(this.stepX[0]);
        this.setIonisationAlphaY(this.stepY[0]);
        this.repaint();
    }

    protected void airModeChanged(int n) {
        this.repaint();
    }

    protected void valueCleanChanged(int n) {
        this.setCleanThreshholdAlphaBlur((float)(100 - n) / 51266);
        this.setCleanThreshholdAlpha(51266);
        this.setCleanFgAlpha(1.0f);
        this.repaint();
    }

    public boolean isIonisationAnimationRunning() {
        return this.ionisationAnimation != null && this.ionisationAnimation.isActive();
    }

    private void stopIonisationAnimation() {
        if (this.ionisationAnimation != null) {
            this.stopInternalAnimation(this.ionisationAnimation);
            this.ionisationAnimation = null;
        }
    }

    private boolean startIonisationAnimation(int n, int n2) {
        if (this.ionisationAnimation != null && this.ionisationAnimation.isActive() && (float)n2 == this.ionisationAnimation.getEndValue()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null) {
            return false;
        }
        int n3 = this.getIonisationStep();
        this.stopIonisationAnimation();
        this.ionisationAnimation = new PureAir$IonisationAnimation(this, easingParams, (float)n3, (float)(n2 - n3));
        return this.startInternalAnimation(this.ionisationAnimation);
    }

    public boolean isCleanAnimationRunning() {
        return this.cleanAnimation != null && this.cleanAnimation.isActive();
    }

    private void stopCleanAnimation() {
        if (this.cleanAnimation != null) {
            this.stopInternalAnimation(this.cleanAnimation);
            this.cleanAnimation = null;
        }
    }

    private boolean startCleanAnimation(int n, int n2) {
        if (this.cleanAnimation != null && this.cleanAnimation.isActive() && (float)n2 == this.cleanAnimation.getEndValue()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(7);
        if (easingParams == null) {
            return false;
        }
        int n3 = n;
        int n4 = n2 - n;
        this.stopCleanAnimation();
        this.cleanAnimation = new PureAir$CleanAnimation(this, easingParams, (float)n3, (float)n4);
        return this.startInternalAnimation(this.cleanAnimation);
    }

    protected void stepXChanged(int[] nArray) {
    }

    protected void stepYChanged(int[] nArray) {
    }

    protected void rawConfigDataChanged(RawConfigDataProxy rawConfigDataProxy) {
        this.configData = null;
        this.getConfigData();
        this.repaint();
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

