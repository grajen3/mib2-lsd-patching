/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.car.status.CarStatusConfigData;
import de.vw.mib.widgets.models.CarStatusModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class CarStatus
extends AbstractWidget
implements CarStatusModel {
    private Color[] featureStateColors;
    private int[] featureStates;
    private CarStatusConfigData configData;
    private RawConfigDataProxy rawConfigData;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$CarStatusUI;

    @Override
    protected void reset() {
        super.reset();
        this.configData = null;
        this.rawConfigData = null;
        this.featureStateColors = null;
        this.featureStates = null;
    }

    public void init(boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, Color[] colorArray, int[] nArray, int n2, boolean bl4, String string, boolean bl5, int n3, Insets insets, boolean bl6, int n4, int n5, int n6) {
        this.init(bl, n, bl2, easingParamsArray, bl3, colorArray, nArray, n2, bl4, string, false, bl5, n3, insets, bl6, n4, n5, n6);
    }

    public void init(boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, Color[] colorArray, int[] nArray, int n2, boolean bl4, String string, boolean bl5, boolean bl6, int n3, Insets insets, boolean bl7, int n4, int n5, int n6) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string, n3, insets, bl7, n4, n5, n6);
        this.featureStateColors = colorArray;
        this.featureStates = nArray;
        this.setInternalStateFlag(9, bl6);
        this.setInternalStateFlag(10, bl5);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.configData = new CarStatusConfigData();
    }

    @Override
    public void deInit() {
        this.configData = null;
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$CarStatusUI == null ? (class$de$vw$mib$widgets$ui$CarStatusUI = CarStatus.class$("de.vw.mib.widgets.ui.CarStatusUI")) : class$de$vw$mib$widgets$ui$CarStatusUI};
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
    public final Color[] get_featureStateColors() {
        return this.featureStateColors;
    }

    @Override
    public final void set_featureStateColors(Color[] colorArray) {
        Object[] objectArray = this.featureStateColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.featureStateColors = colorArray;
            this.featureStateColorsChanged((Color[])objectArray);
            this.propertyChanged(15);
        }
    }

    @Override
    public final int[] get_featureStates() {
        return this.featureStates;
    }

    @Override
    public final void set_featureStates(int[] nArray) {
        int[] nArray2 = this.featureStates;
        if (nArray2 != nArray) {
            this.featureStates = nArray;
            this.featureStatesChanged(nArray2);
            this.propertyChanged(16);
        }
    }

    @Override
    public boolean is_showCarTransparent() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public void set_showCarTransparent(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.showCarTransparentChanged(bl2);
            this.propertyChanged(17);
        }
    }

    @Override
    public boolean is_rightHandDrive() {
        return this.getInternalStateFlag(10);
    }

    @Override
    public void set_rightHandDrive(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(10);
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.rightHandDriveChanged(bl2);
            this.propertyChanged(18);
        }
    }

    protected void featureStateColorsChanged(Color[] colorArray) {
    }

    protected void featureStatesChanged(int[] nArray) {
    }

    private void showCarTransparentChanged(boolean bl) {
        this.repaint();
    }

    private void rightHandDriveChanged(boolean bl) {
        this.configData = new CarStatusConfigData();
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

