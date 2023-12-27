/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.car.ops.OPSConfigData;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class OPS
extends AbstractWidget
implements OPSModel {
    private int[] sensorsSegmentValues;
    private int[] sensorStateValues;
    private Color[] sensorStateColors;
    private int trackDisplay;
    private int radiusRear;
    private int radiusFront;
    private int wheelBase;
    private int[] areaViewStates;
    private ButtonModel[] areaViewButtonRefs;
    private int[] rtaStates;
    private Color[] rtaStateColors;
    private int[] ftaStates;
    private Color[] ftaStateColors;
    private int[] maneuverAssistStates;
    private int[] rimProtectionStates;
    private Color[] rimProtectionStateColors;
    private int[] coloredSensorFailureAlphas;
    private OPSConfigData configData;
    private RawConfigDataProxy configDataInputStream;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$OPSUI;

    public void init(boolean bl, int n, ButtonModel[] buttonModelArray, int[] nArray, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color[] colorArray, int[] nArray2, int n2, boolean bl5, String string, int n3, int n4, Color[] colorArray2, int[] nArray3, int[] nArray4, Color[] colorArray3, int[] nArray5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, int n5, Insets insets, int n6, boolean bl15, int n7, int n8, int n9, int n10) {
        this.init(bl, n, buttonModelArray, nArray, bl2, bl3, easingParamsArray, bl4, colorArray, nArray2, n2, bl5, new int[0], string, n3, n4, colorArray2, nArray3, nArray4, colorArray3, nArray5, bl6, bl7, bl8, bl9, false, bl10, bl11, bl12, bl13, bl14, n5, insets, n6, bl15, n7, n8, n9, n10);
    }

    public void init(boolean bl, int n, ButtonModel[] buttonModelArray, int[] nArray, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color[] colorArray, int[] nArray2, int n2, boolean bl5, int[] nArray3, String string, int n3, int n4, Color[] colorArray2, int[] nArray4, int[] nArray5, Color[] colorArray3, int[] nArray6, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, int n5, Insets insets, int n6, boolean bl16, int n7, int n8, int n9, int n10) {
        this.init(bl, n, buttonModelArray, nArray, bl2, bl3, easingParamsArray, bl4, colorArray, nArray2, n2, bl5, nArray3, string, n3, n4, new Color[0], new int[0], colorArray2, nArray4, nArray5, colorArray3, nArray6, bl6, bl7, bl8, bl9, bl10, bl11, bl12, false, bl13, bl14, bl15, n5, insets, n6, bl16, n7, n8, n9, n10);
    }

    public void init(boolean bl, int n, ButtonModel[] buttonModelArray, int[] nArray, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color[] colorArray, int[] nArray2, int n2, boolean bl5, int[] nArray3, String string, int n3, int n4, Color[] colorArray2, int[] nArray4, Color[] colorArray3, int[] nArray5, int[] nArray6, Color[] colorArray4, int[] nArray7, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, int n5, Insets insets, int n6, boolean bl17, int n7, int n8, int n9, int n10) {
        this.init(bl, n, buttonModelArray, nArray, bl2, new int[0], bl3, easingParamsArray, bl4, colorArray, nArray2, n2, bl5, nArray3, string, n3, n4, colorArray2, nArray4, colorArray3, nArray5, nArray6, colorArray4, nArray7, bl6, bl7, bl8, false, bl9, bl10, bl11, bl12, bl13, bl14, bl15, bl16, n5, insets, n6, bl17, n7, n8, n9, n10);
    }

    public void init(boolean bl, int n, ButtonModel[] buttonModelArray, int[] nArray, boolean bl2, int[] nArray2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color[] colorArray, int[] nArray3, int n2, boolean bl5, int[] nArray4, String string, int n3, int n4, Color[] colorArray2, int[] nArray5, Color[] colorArray3, int[] nArray6, int[] nArray7, Color[] colorArray4, int[] nArray8, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, int n5, Insets insets, int n6, boolean bl18, int n7, int n8, int n9, int n10) {
        super.init(bl, n, bl2, easingParamsArray, bl4, n2, bl5, string, n5, insets, bl18, n8, n9, n10);
        this.sensorsSegmentValues = nArray7;
        this.sensorStateValues = nArray8;
        this.sensorStateColors = colorArray4;
        this.trackDisplay = n6;
        this.radiusRear = n4;
        this.radiusFront = n3;
        this.wheelBase = n7;
        this.areaViewStates = nArray;
        this.areaViewButtonRefs = buttonModelArray;
        this.rtaStates = nArray6;
        this.rtaStateColors = colorArray3;
        this.ftaStates = nArray3;
        this.ftaStateColors = colorArray;
        this.maneuverAssistStates = nArray4;
        this.rimProtectionStateColors = colorArray2;
        this.rimProtectionStates = nArray5;
        this.coloredSensorFailureAlphas = nArray2;
        this.setInternalStateFlag(9, bl13);
        this.setInternalStateFlag(10, bl17);
        this.setInternalStateFlag(11, bl12);
        this.setInternalStateFlag(13, bl6);
        this.setInternalStateFlag(14, bl16);
        this.setInternalStateFlag(15, bl7);
        this.setInternalStateFlag(16, bl15);
        this.setInternalStateFlag(17, bl8);
        this.setInternalStateFlag(18, bl10);
        this.setInternalStateFlag(19, bl11);
        this.setInternalStateFlag(20, bl14);
        this.setInternalStateFlag(21, bl9);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.configData = new OPSConfigData(this.is_showOPSMini());
        if (this.is_showAreaView()) {
            this.initAreaViewButtonRefs(this.areaViewButtonRefs, (OPSConfigData)this.getConfigData());
        }
    }

    @Override
    public void deInit() {
        this.configData = null;
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        this.areaViewButtonRefs = null;
        this.areaViewStates = null;
        this.coloredSensorFailureAlphas = null;
        this.configData = null;
        this.configDataInputStream = null;
        this.ftaStates = null;
        this.ftaStateColors = null;
        this.maneuverAssistStates = null;
        this.radiusFront = 0;
        this.radiusRear = 0;
        this.rtaStates = null;
        this.rtaStateColors = null;
        this.sensorsSegmentValues = null;
        this.sensorStateColors = null;
        this.sensorStateValues = null;
        this.trackDisplay = 0;
        this.wheelBase = 0;
        this.setInternalStateFlag(12, false);
        this.setInternalStateFlag(13, false);
        this.setInternalStateFlag(15, false);
        this.setInternalStateFlag(17, false);
        this.setInternalStateFlag(11, false);
        this.setInternalStateFlag(9, false);
        this.setInternalStateFlag(16, false);
        this.setInternalStateFlag(14, false);
        this.setInternalStateFlag(10, false);
        this.setInternalStateFlag(18, false);
        this.setInternalStateFlag(19, false);
        this.setInternalStateFlag(21, false);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$OPSUI == null ? (class$de$vw$mib$widgets$ui$OPSUI = OPS.class$("de.vw.mib.widgets.ui.OPSUI")) : class$de$vw$mib$widgets$ui$OPSUI};
    }

    @Override
    public AbstractConfigData getConfigData() {
        if (this.configData != null) {
            this.configData.init(this.configDataInputStream);
        }
        return this.configData;
    }

    @Override
    public void setRawConfigData(RawConfigDataProxy rawConfigDataProxy) {
        RawConfigDataProxy rawConfigDataProxy2 = this.configDataInputStream;
        if (rawConfigDataProxy2 == null || !rawConfigDataProxy2.equals(rawConfigDataProxy)) {
            this.configDataInputStream = rawConfigDataProxy;
            this.reloadConfig();
        }
    }

    @Override
    public final int[] get_sensorsSegmentValues() {
        return this.sensorsSegmentValues;
    }

    @Override
    public final void set_sensorsSegmentValues(int[] nArray) {
        this.sensorsSegmentValues = nArray;
        this.sensorsSegmentValuesChanged(nArray);
        this.propertyChanged(15);
    }

    @Override
    public final int[] get_sensorStateValues() {
        return this.sensorStateValues;
    }

    @Override
    public final void set_sensorStateValues(int[] nArray) {
        this.sensorStateValues = nArray;
        this.sensorStateValuesChanged(nArray);
        this.propertyChanged(16);
    }

    @Override
    public final Color[] get_sensorStateColors() {
        return this.sensorStateColors;
    }

    @Override
    public final void set_sensorStateColors(Color[] colorArray) {
        Object[] objectArray = this.sensorStateColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.sensorStateColors = colorArray;
            this.sensorStateColorsChanged((Color[])objectArray);
            this.propertyChanged(17);
        }
    }

    @Override
    public final int get_trackDisplay() {
        return this.trackDisplay;
    }

    @Override
    public final void set_trackDisplay(int n) {
        int n2 = this.trackDisplay;
        if (n2 != n) {
            this.trackDisplay = n;
            this.trackDisplayChanged(n2);
            this.propertyChanged(18);
        }
    }

    @Override
    public final int get_wheelBase() {
        return this.wheelBase;
    }

    @Override
    public final void set_wheelBase(int n) {
        int n2 = this.wheelBase;
        if (n2 != n) {
            this.wheelBase = n;
            this.wheelBaseChanged(n2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final boolean is_direction() {
        return this.getInternalStateFlag(12);
    }

    @Override
    public final void set_direction(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(12);
        if (bl2 != bl) {
            this.setInternalStateFlag(12, bl);
            this.directionChanged(bl2);
            this.propertyChanged(19);
        }
    }

    @Override
    public final int get_radiusRear() {
        return this.radiusRear;
    }

    @Override
    public final void set_radiusRear(int n) {
        int n2 = this.radiusRear;
        if (n2 != n) {
            this.radiusRear = n;
            this.radiusRearChanged(n2);
            this.propertyChanged(20);
        }
    }

    @Override
    public final int get_radiusFront() {
        return this.radiusFront;
    }

    @Override
    public final void set_radiusFront(int n) {
        int n2 = this.radiusFront;
        if (n2 != n) {
            this.radiusFront = n;
            this.radiusFrontChanged(n2);
            this.propertyChanged(21);
        }
    }

    @Override
    public final boolean is_showRearOnly() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public final void set_showRearOnly(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.showRearOnlyChanged(bl2);
            this.propertyChanged(22);
        }
    }

    @Override
    public final boolean is_showTrailer() {
        return this.getInternalStateFlag(10);
    }

    @Override
    public final void set_showTrailer(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(10);
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.showTrailerChanged(bl2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final boolean is_showOPSMini() {
        return this.getInternalStateFlag(11);
    }

    @Override
    public final void set_showOPSMini(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(11);
        if (bl2 != bl) {
            this.setInternalStateFlag(11, bl);
            this.showOPSMiniChanged(bl2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final boolean is_show360() {
        return this.getInternalStateFlag(13);
    }

    @Override
    public final void set_show360(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(13);
        if (bl2 != bl) {
            this.setInternalStateFlag(13, bl);
            this.show360Changed(bl2);
            this.propertyChanged(26);
        }
    }

    @Override
    public final boolean is_showTestMode() {
        return this.getInternalStateFlag(14);
    }

    @Override
    public final void set_showTestMode(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(14);
        if (bl2 != bl) {
            this.setInternalStateFlag(14, bl);
            this.showTestModeChanged(bl2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final boolean is_showAreaView() {
        return this.getInternalStateFlag(15);
    }

    @Override
    public final void set_showAreaView(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(15);
        if (bl2 != bl) {
            this.setInternalStateFlag(15, bl);
            this.showAreaViewChanged(bl2);
            this.propertyChanged(28);
        }
    }

    @Override
    public final int[] get_areaViewStates() {
        return this.areaViewStates;
    }

    @Override
    public final void set_areaViewStates(int[] nArray) {
        int[] nArray2 = this.areaViewStates;
        if (!Arrays.equals(nArray2, nArray)) {
            this.areaViewStates = nArray;
            this.propertyChanged(29);
            this.areaViewStatesChanged(nArray2);
        }
    }

    @Override
    public final ButtonModel[] get_areaViewButtonRefs() {
        return this.areaViewButtonRefs;
    }

    @Override
    public final void set_areaViewButtonRefs(ButtonModel[] buttonModelArray) {
        Object[] objectArray = this.areaViewButtonRefs;
        if (!Arrays.equals(objectArray, buttonModelArray)) {
            this.areaViewButtonRefs = buttonModelArray;
            this.propertyChanged(30);
            this.areaViewButtonRefsChanged((AbstractButtonModel[])objectArray);
        }
    }

    @Override
    public final boolean is_showRTA() {
        return this.getInternalStateFlag(16);
    }

    @Override
    public final void set_showRTA(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(16);
        if (bl2 != bl) {
            this.setInternalStateFlag(16, bl);
            this.showRTAChanged(bl);
            this.propertyChanged(31);
        }
    }

    @Override
    public final int[] get_rtaStates() {
        return this.rtaStates;
    }

    @Override
    public final void set_rtaStates(int[] nArray) {
        this.rtaStates = nArray;
        this.rtaStatesChanged(nArray);
        this.propertyChanged(32);
    }

    @Override
    public final Color[] get_rtaStateColors() {
        return this.rtaStateColors;
    }

    @Override
    public final void set_rtaStateColors(Color[] colorArray) {
        Object[] objectArray = this.get_rtaStateColors();
        if (!Arrays.equals(objectArray, colorArray)) {
            this.rtaStateColors = colorArray;
            this.rtaStateColorsChanged((Color[])objectArray);
            this.propertyChanged(33);
        }
    }

    @Override
    public final boolean is_showCameraBasedSegments() {
        return this.getInternalStateFlag(17);
    }

    @Override
    public final void set_showCameraBasedSegments(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(17);
        if (bl2 != bl) {
            this.setInternalStateFlag(17, bl);
            this.showCameraBasedSegmentsChanged(bl2);
            this.propertyChanged(34);
        }
    }

    @Override
    public final boolean is_showFTA() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public final void set_showFTA(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(18);
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.showFTAChanged(bl2);
            this.propertyChanged(35);
        }
    }

    @Override
    public final int[] get_ftaStates() {
        return this.ftaStates;
    }

    @Override
    public final void set_ftaStates(int[] nArray) {
        this.ftaStates = nArray;
        this.ftaStatesChanged(nArray);
        this.propertyChanged(36);
    }

    @Override
    public final Color[] get_ftaStateColors() {
        return this.ftaStateColors;
    }

    @Override
    public final void set_ftaStateColors(Color[] colorArray) {
        Object[] objectArray = this.ftaStateColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.ftaStateColors = colorArray;
            this.ftaStateColorsChanged((Color[])objectArray);
            this.propertyChanged(37);
        }
    }

    @Override
    public final boolean is_showManeuverAssist() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public final void set_showManeuverAssist(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(19);
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.showManeuverAssistChanged(bl2);
            this.propertyChanged(38);
        }
    }

    @Override
    public final int[] get_maneuverAssistStates() {
        return this.maneuverAssistStates;
    }

    @Override
    public final void set_maneuverAssistStates(int[] nArray) {
        int[] nArray2 = this.maneuverAssistStates;
        if (!Arrays.equals(nArray2, nArray)) {
            this.maneuverAssistStates = nArray;
            this.maneuverAssitStatesChanged(nArray2);
            this.propertyChanged(39);
        }
    }

    @Override
    public final boolean is_showRimProtection() {
        return this.getInternalStateFlag(20);
    }

    @Override
    public final void set_showRimProtection(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(20);
        if (bl2 != bl) {
            this.setInternalStateFlag(20, bl);
            this.showRimProtectionChanged(bl2);
            this.propertyChanged(40);
        }
    }

    @Override
    public final int[] get_rimProtectionStates() {
        return this.rimProtectionStates;
    }

    @Override
    public final void set_rimProtectionStates(int[] nArray) {
        int[] nArray2 = this.rimProtectionStates;
        if (!Arrays.equals(nArray2, nArray)) {
            this.rimProtectionStates = nArray;
            this.rimProtectionStatesChanged(nArray2);
            this.propertyChanged(41);
        }
    }

    @Override
    public final Color[] get_rimProtectionStateColors() {
        return this.rimProtectionStateColors;
    }

    @Override
    public final void set_rimProtectionStateColors(Color[] colorArray) {
        Object[] objectArray = this.rimProtectionStateColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.rimProtectionStateColors = colorArray;
            this.rimProtectionStateColorsChanged((Color[])objectArray);
            this.propertyChanged(42);
        }
    }

    @Override
    public final boolean is_showColoredSensorFailure() {
        return this.getInternalStateFlag(21);
    }

    @Override
    public final void set_showColoredSensorFailure(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(21);
        if (bl2 != bl) {
            this.setInternalStateFlag(21, bl);
            this.showColoredSensorFailureChanged(bl2);
            this.propertyChanged(43);
        }
    }

    @Override
    public final int[] get_coloredSensorFailureAlphas() {
        return this.coloredSensorFailureAlphas;
    }

    @Override
    public final void set_coloredSensorFailureAlphas(int[] nArray) {
        int[] nArray2 = this.coloredSensorFailureAlphas;
        if (!Arrays.equals(nArray2, nArray)) {
            this.coloredSensorFailureAlphas = nArray;
            this.coloredSensorFailureAlphasChanged(nArray2);
            this.propertyChanged(44);
        }
    }

    @Override
    protected void xChanged(int n) {
        if (this.is_showAreaView()) {
            this.initAreaViewButtonRefs(this.areaViewButtonRefs, (OPSConfigData)this.getConfigData());
        }
        super.xChanged(n);
    }

    @Override
    protected void yChanged(int n) {
        if (this.is_showAreaView()) {
            this.initAreaViewButtonRefs(this.areaViewButtonRefs, (OPSConfigData)this.getConfigData());
        }
        super.yChanged(n);
    }

    protected void show360Changed(boolean bl) {
        this.repaint();
    }

    protected void sensorsSegmentValuesChanged(int[] nArray) {
        this.repaint();
    }

    protected void sensorStateValuesChanged(int[] nArray) {
        this.repaint();
    }

    protected void sensorStateColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void trackDisplayChanged(int n) {
        this.repaint();
    }

    protected void directionChanged(boolean bl) {
        if (this.trackDisplay != 0) {
            this.repaint();
        }
    }

    protected void radiusRearChanged(int n) {
        if (this.trackDisplay != 0) {
            this.repaint();
        }
    }

    protected void radiusFrontChanged(int n) {
        if (this.trackDisplay != 0) {
            this.repaint();
        }
    }

    protected void showRearOnlyChanged(boolean bl) {
        this.repaint();
    }

    protected void showTrailerChanged(boolean bl) {
        this.repaint();
    }

    protected void showOPSMiniChanged(boolean bl) {
        this.reloadConfig();
        this.repaint();
    }

    protected void wheelBaseChanged(int n) {
        if (this.trackDisplay != 0) {
            this.repaint();
        }
    }

    protected void showTestModeChanged(boolean bl) {
        this.repaint();
    }

    protected void showAreaViewChanged(boolean bl) {
        if (this.is_showAreaView()) {
            this.initAreaViewButtonRefs(this.areaViewButtonRefs, (OPSConfigData)this.getConfigData());
        } else if (this.areaViewButtonRefs != null) {
            for (int i2 = this.areaViewButtonRefs.length - 1; i2 >= 0; --i2) {
                if (this.areaViewButtonRefs[i2] == null) continue;
                this.areaViewButtonRefs[i2].set_visible(false);
            }
        }
        this.repaint();
    }

    protected void areaViewStatesChanged(int[] nArray) {
        this.repaint();
    }

    protected void areaViewButtonRefsChanged(AbstractButtonModel[] abstractButtonModelArray) {
        this.initAreaViewButtonRefs(this.areaViewButtonRefs, this.configData);
    }

    protected void showRTAChanged(boolean bl) {
        this.repaint();
    }

    protected void rtaStatesChanged(int[] nArray) {
        this.repaint();
    }

    protected void rtaStateColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void showCameraBasedSegmentsChanged(boolean bl) {
        this.repaint();
    }

    protected void showFTAChanged(boolean bl) {
        this.repaint();
    }

    protected void ftaStatesChanged(int[] nArray) {
        this.repaint();
    }

    protected void ftaStateColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void showManeuverAssistChanged(boolean bl) {
        this.repaint();
    }

    protected void maneuverAssitStatesChanged(int[] nArray) {
        this.repaint();
    }

    protected void showRimProtectionChanged(boolean bl) {
        this.repaint();
    }

    protected void rimProtectionStatesChanged(int[] nArray) {
        this.repaint();
    }

    protected void rimProtectionStateColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void showColoredSensorFailureChanged(boolean bl) {
        this.repaint();
    }

    protected void coloredSensorFailureAlphasChanged(int[] nArray) {
        this.repaint();
    }

    private void reloadConfig() {
        this.configData = new OPSConfigData(this.is_showOPSMini());
        this.initAreaViewButtonRefs(this.areaViewButtonRefs, (OPSConfigData)this.getConfigData());
    }

    private void initAreaViewButtonRefs(ButtonModel[] buttonModelArray, OPSConfigData oPSConfigData) {
        if (buttonModelArray != null && oPSConfigData != null) {
            int n;
            boolean bl = this.is_showOPSMini();
            short s = oPSConfigData.getAreaViewDataValue(16);
            short s2 = oPSConfigData.getAreaViewDataValue(18);
            Point point = new Point(s, s2);
            s = oPSConfigData.getAreaViewDataValue(19);
            s2 = oPSConfigData.getAreaViewDataValue(21);
            Point point2 = new Point(s, s2);
            s = oPSConfigData.getAreaViewDataValue(19);
            s2 = oPSConfigData.getAreaViewDataValue(20);
            Point point3 = new Point(s, s2);
            s = oPSConfigData.getAreaViewDataValue(16);
            s2 = oPSConfigData.getAreaViewDataValue(17);
            Point point4 = new Point(s, s2);
            Point[] pointArray = new Point[]{point, point2, point3, point4};
            for (n = pointArray.length - 1; n >= 0; --n) {
                if (bl) {
                    pointArray[n].x += this.get_y();
                    pointArray[n].y -= this.get_x();
                    continue;
                }
                pointArray[n].x += this.get_x();
                pointArray[n].y += this.get_y();
            }
            n = oPSConfigData.getAreaViewDataValue(22);
            short s3 = oPSConfigData.getAreaViewDataValue(23);
            short s4 = oPSConfigData.getAreaViewDataValue(24);
            Point point5 = new Point(0, point.y - s3);
            Point point6 = new Point(!bl ? this.get_width() : this.get_height(), point2.y - s3);
            Point point7 = new Point(0, point4.y + s3);
            Point point8 = new Point(!bl ? this.get_width() : this.get_height(), point3.y + s3);
            pointArray = new Point[]{point5, point6, point7, point8};
            for (int i2 = pointArray.length - 1; i2 >= 0; --i2) {
                if (bl) {
                    pointArray[i2].x += this.get_y();
                    continue;
                }
                pointArray[i2].x += this.get_x();
            }
            Transform transform = null;
            if (bl) {
                transform = new Transform();
                transform.translate(this.get_width() >> 1, this.get_height() >> 1, 0.0f);
                transform.rotate(Util.toRadians(46146), 0.0f, 0.0f, 1.0f);
                transform.translate(-this.get_height() >> 1, -this.get_width() >> 1, 0.0f);
            }
            int n2 = buttonModelArray.length <= 5 ? buttonModelArray.length : 5;
            block9: for (int i3 = 0; i3 < n2; ++i3) {
                Point[] pointArray2;
                ButtonModel buttonModel = buttonModelArray[i3];
                if (buttonModel == null || buttonModel != null && !buttonModel.is_enabled()) continue;
                switch (i3) {
                    case 0: {
                        pointArray2 = new Point[]{point5, new Point(point.x - n, point.y - s3), point, point4, new Point(point4.x - n, point4.y + s3), point7};
                        break;
                    }
                    case 1: {
                        pointArray2 = new Point[]{new Point(point.x - n, point.y - s3), new Point(point2.x + s4, point2.y - s3), point2, point};
                        break;
                    }
                    case 2: {
                        pointArray2 = new Point[]{new Point(point2.x + s4, point2.y - s3), point6, point8, new Point(point3.x + s4, point3.y + s3), point3, point2};
                        break;
                    }
                    case 3: {
                        pointArray2 = new Point[]{point4, point3, new Point(point3.x + s4, point3.y + s3), new Point(point4.x - n, point4.y + s3)};
                        break;
                    }
                    case 4: {
                        pointArray2 = new Point[]{point, point2, point3, point4};
                        break;
                    }
                    default: {
                        continue block9;
                    }
                }
                if (buttonModel == null) continue;
                if (transform != null) {
                    Vector3f vector3f = new Vector3f();
                    Vector3f vector3f2 = new Vector3f();
                    for (int i4 = pointArray2.length - 1; i4 >= 0; --i4) {
                        vector3f.setX(pointArray2[i4].x);
                        vector3f.setY(pointArray2[i4].y);
                        transform.transform(vector3f, vector3f2);
                        pointArray2[i4] = new Point((int)vector3f2.getX(), (int)vector3f2.getY());
                    }
                }
                buttonModel.set_visible(true);
                buttonModel.set_vertices(pointArray2);
            }
        }
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

