/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.EnergyFlow$EnergyFlowAnimation;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.car.energyflow.EnergyFlowConfigData;
import de.vw.mib.widgets.event.AnimationStateListener;
import de.vw.mib.widgets.models.EnergyFlowModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public final class EnergyFlow
extends AbstractWidget
implements EnergyFlowModel,
AnimationStateListener {
    private static final int COLOR_ENGINE_1;
    private static final int COLOR_EMOTOR_1;
    private static final int COLOR_RECUP_1;
    private static final int COLOR_ENGINE_2;
    private static final int COLOR_EMOTOR_2;
    private static final int COLOR_RECUP_2;
    private static final int ANIMATION_INTERVAL_MIN;
    private int batteryState;
    private int batteryStateOfCharge;
    private Color[] energyFlowColors;
    private int energyState;
    private int[] featureStates;
    private int motionState;
    private int powerDriveConcept;
    private int carType;
    private EnergyFlowConfigData configData;
    private RawConfigDataProxy rawConfigData;
    private float posXFlowBattery;
    private float posXFlowWheels;
    private int currentSequenceIdx;
    private EnergyFlow$EnergyFlowAnimation shiftEnergyFlowBatteryAnimation;
    private EnergyFlow$EnergyFlowAnimation shiftEnergyFlowWheelAnimation;
    private EnergyFlow$EnergyFlowAnimation rotateEnergyFlowAnimation;
    private boolean animationBlockingEnabled;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$EnergyFlowUI;

    @Override
    protected void reset() {
        super.reset();
        this.configData = null;
        this.rawConfigData = null;
        this.batteryState = 0;
        this.batteryStateOfCharge = 0;
        this.energyFlowColors = null;
        this.energyState = 0;
        this.motionState = 0;
        this.powerDriveConcept = 0;
        this.currentSequenceIdx = 0;
        this.posXFlowBattery = 0.0f;
        this.posXFlowWheels = 0.0f;
        this.shiftEnergyFlowBatteryAnimation = null;
        this.shiftEnergyFlowWheelAnimation = null;
        this.rotateEnergyFlowAnimation = null;
        this.animationBlockingEnabled = false;
    }

    public void init(boolean bl, int n, boolean bl2, int n2, int n3, int n4, EasingParams[] easingParamsArray, boolean bl3, Color[] colorArray, int n5, int[] nArray, int n6, boolean bl4, int n7, String string, int n8, int n9, Insets insets, boolean bl5, int n10, int n11, int n12) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n6, bl4, string, n9, insets, bl5, n10, n11, n12);
        this.batteryState = n2;
        this.batteryStateOfCharge = n3;
        this.energyFlowColors = colorArray;
        this.energyState = n5;
        this.featureStates = nArray;
        this.motionState = n7;
        this.powerDriveConcept = n8;
        this.carType = n4;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.configData = new EnergyFlowConfigData(this.carType);
        if (viewModel != null) {
            viewModel.activate();
        }
        this.manageAnimations();
    }

    @Override
    public void deInit() {
        this.stopBatteryFlowAnimation();
        this.stopWheelFlowAnimations();
        this.configData = null;
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$EnergyFlowUI == null ? (class$de$vw$mib$widgets$ui$EnergyFlowUI = EnergyFlow.class$("de.vw.mib.widgets.ui.EnergyFlowUI")) : class$de$vw$mib$widgets$ui$EnergyFlowUI};
    }

    @Override
    public int get_batteryState() {
        return this.batteryState;
    }

    @Override
    public void set_batteryState(int n) {
        int n2 = this.batteryState;
        if (n2 != n) {
            this.batteryState = n;
            this.batteryStateChanged(n2);
            this.propertyChanged(17);
        }
    }

    @Override
    public int get_batteryStateOfCharge() {
        return this.batteryStateOfCharge;
    }

    @Override
    public void set_batteryStateOfCharge(int n) {
        int n2 = this.batteryStateOfCharge;
        if (n2 != n) {
            this.batteryStateOfCharge = n;
            this.batteryStateOfChargeChanged(n2);
            this.propertyChanged(16);
        }
    }

    @Override
    public int get_carType() {
        return this.carType;
    }

    @Override
    public void set_carType(int n) {
        int n2 = this.carType;
        if (n2 != n) {
            this.carType = n;
            this.carTypeChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public Color[] get_energyFlowColors() {
        return this.energyFlowColors;
    }

    @Override
    public void set_energyFlowColors(Color[] colorArray) {
        Object[] objectArray = this.energyFlowColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.energyFlowColors = colorArray;
            this.energyFlowColorsChanged((Color[])objectArray);
            this.propertyChanged(18);
        }
    }

    @Override
    public int get_energyState() {
        return this.energyState;
    }

    @Override
    public void set_energyState(int n) {
        int n2 = this.energyState;
        if (n2 != n) {
            this.energyState = n;
            this.energyStateChanged(n2);
            this.propertyChanged(19);
        }
    }

    @Override
    public int[] get_featureStates() {
        return this.featureStates;
    }

    @Override
    public void set_featureStates(int[] nArray) {
        int[] nArray2 = this.featureStates;
        if (nArray2 != nArray) {
            this.featureStates = nArray;
            this.featureStatesChanged(nArray2);
            this.propertyChanged(20);
        }
    }

    @Override
    public int get_motionState() {
        return this.motionState;
    }

    @Override
    public void set_motionState(int n) {
        int n2 = this.motionState;
        if (n2 != n) {
            this.motionState = n;
            this.motionStateChanged(n2);
            this.propertyChanged(21);
        }
    }

    @Override
    public int get_powerDriveConcept() {
        return this.powerDriveConcept;
    }

    @Override
    public void set_powerDriveConcept(int n) {
        int n2 = this.powerDriveConcept;
        if (n2 != n) {
            this.powerDriveConcept = n;
            this.powerDriveConceptChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public float getPosXFlowBattery() {
        return this.posXFlowBattery;
    }

    @Override
    public float getPosXFlowWheels() {
        return this.posXFlowWheels;
    }

    @Override
    public int getCurrentSequenceIndex() {
        return this.currentSequenceIdx;
    }

    @Override
    public AbstractConfigData getConfigData() {
        if (this.configData != null) {
            this.configData.init(this.rawConfigData);
        }
        return this.configData;
    }

    @Override
    public void setRawConfigData(RawConfigDataProxy rawConfigDataProxy) {
        RawConfigDataProxy rawConfigDataProxy2 = this.rawConfigData;
        if (rawConfigDataProxy2 == null || !rawConfigDataProxy2.equals(rawConfigDataProxy)) {
            this.rawConfigData = rawConfigDataProxy;
        }
    }

    @Override
    public Color4b[] getCurrentColor(Color4b[] color4bArray) {
        switch (this.energyState) {
            case 1: {
                color4bArray[0] = this.energyFlowColors[1].getCurrentColor();
                color4bArray[1] = this.energyFlowColors[4].getCurrentColor();
                break;
            }
            case 2: {
                color4bArray[0] = this.energyFlowColors[0].getCurrentColor();
                color4bArray[1] = this.energyFlowColors[3].getCurrentColor();
                break;
            }
            case 3: 
            case 5: {
                color4bArray[0] = this.energyFlowColors[2].getCurrentColor();
                color4bArray[1] = this.energyFlowColors[5].getCurrentColor();
                break;
            }
            default: {
                color4bArray[0] = null;
                color4bArray[1] = null;
            }
        }
        return color4bArray;
    }

    @Override
    public Color4b[] getEMotorColors(Color4b[] color4bArray) {
        if (color4bArray == null) {
            return null;
        }
        color4bArray[0] = this.energyFlowColors[1].getCurrentColor();
        color4bArray[1] = this.energyFlowColors[4].getCurrentColor();
        return color4bArray;
    }

    @Override
    public Color4b[] getEngineColors(Color4b[] color4bArray) {
        if (color4bArray == null) {
            return null;
        }
        color4bArray[0] = this.energyFlowColors[0].getCurrentColor();
        color4bArray[1] = this.energyFlowColors[3].getCurrentColor();
        return color4bArray;
    }

    private void energyStateChanged(int n) {
        this.manageAnimations();
        this.repaint();
    }

    private void featureStatesChanged(int[] nArray) {
        this.repaint();
    }

    private void carTypeChanged(int n) {
        this.configData = new EnergyFlowConfigData(this.carType);
        this.repaint();
    }

    private void motionStateChanged(int n) {
        this.manageAnimations();
        this.repaint();
    }

    private void batteryStateChanged(int n) {
        this.manageAnimations();
        this.repaint();
    }

    private void batteryStateOfChargeChanged(int n) {
        this.repaint();
    }

    private void energyFlowColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    private void powerDriveConceptChanged(int n) {
        this.repaint();
    }

    @Override
    public void easingChanged(EasingParams[] easingParamsArray) {
        this.stopBatteryFlowAnimation();
        this.stopWheelFlowAnimations();
        super.easingChanged(easingParamsArray);
        this.startWheelFlowAnimations();
        this.startBatteryFlowAnimation();
    }

    private void manageAnimations() {
        if (this.animationBlockingEnabled) {
            this.stopBatteryFlowAnimation();
            this.stopWheelFlowAnimations();
            return;
        }
        if (this.energyState != 0 && this.motionState == 1) {
            if (this.shiftEnergyFlowWheelAnimation == null || !this.shiftEnergyFlowWheelAnimation.isActive()) {
                this.startWheelFlowAnimations();
            }
        } else {
            this.stopWheelFlowAnimations();
        }
        if (this.batteryState != 0) {
            if (this.shiftEnergyFlowBatteryAnimation == null || !this.shiftEnergyFlowBatteryAnimation.isActive()) {
                this.startBatteryFlowAnimation();
            }
        } else {
            this.stopBatteryFlowAnimation();
        }
    }

    @Override
    public void updateCurrentAnimationState(Object object, float f2) {
        if (object == this.shiftEnergyFlowBatteryAnimation) {
            this.posXFlowBattery = f2;
        } else if (object == this.shiftEnergyFlowWheelAnimation) {
            this.posXFlowWheels = f2;
        } else if (object == this.rotateEnergyFlowAnimation) {
            this.currentSequenceIdx = Math.round(f2 * 63553);
        }
    }

    private boolean startBatteryFlowAnimation() {
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null) {
            return false;
        }
        if (this.shiftEnergyFlowBatteryAnimation == null) {
            this.shiftEnergyFlowBatteryAnimation = new EnergyFlow$EnergyFlowAnimation(this, easingParams, 0.0f, 1.0f);
            this.shiftEnergyFlowBatteryAnimation.addStateListener(this);
            if (!this.startInternalAnimation(this.shiftEnergyFlowBatteryAnimation)) {
                this.shiftEnergyFlowBatteryAnimation = null;
                return false;
            }
        }
        return true;
    }

    private void startWheelFlowAnimations() {
        EasingParams easingParams = this.getEasing(9);
        EasingParams easingParams2 = this.getEasing(7);
        if (easingParams != null && this.rotateEnergyFlowAnimation == null) {
            this.rotateEnergyFlowAnimation = new EnergyFlow$EnergyFlowAnimation(this, easingParams, 0.0f, 1.0f);
            this.rotateEnergyFlowAnimation.addStateListener(this);
            if (!this.startInternalAnimation(this.rotateEnergyFlowAnimation)) {
                this.rotateEnergyFlowAnimation = null;
            }
        }
        if (easingParams2 != null && this.shiftEnergyFlowWheelAnimation == null) {
            this.shiftEnergyFlowWheelAnimation = new EnergyFlow$EnergyFlowAnimation(this, easingParams2, 0.0f, 1.0f);
            this.shiftEnergyFlowWheelAnimation.addStateListener(this);
            if (!this.startInternalAnimation(this.shiftEnergyFlowWheelAnimation)) {
                this.shiftEnergyFlowWheelAnimation = null;
            }
        }
    }

    private void stopBatteryFlowAnimation() {
        if (this.shiftEnergyFlowBatteryAnimation != null) {
            this.stopInternalAnimation(this.shiftEnergyFlowBatteryAnimation);
            this.shiftEnergyFlowBatteryAnimation = null;
        }
    }

    private void stopWheelFlowAnimations() {
        if (this.rotateEnergyFlowAnimation != null) {
            this.stopInternalAnimation(this.rotateEnergyFlowAnimation);
            this.rotateEnergyFlowAnimation = null;
        }
        if (this.shiftEnergyFlowWheelAnimation != null) {
            this.stopInternalAnimation(this.shiftEnergyFlowWheelAnimation);
            this.shiftEnergyFlowWheelAnimation = null;
        }
    }

    @Override
    public void setAnimationBlockingEnabled(boolean bl) {
        this.animationBlockingEnabled = bl;
        this.manageAnimations();
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

