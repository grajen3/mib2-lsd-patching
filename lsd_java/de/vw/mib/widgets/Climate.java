/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.Climate$SlideUpDownAnimation;
import de.vw.mib.widgets.Climate$ZoomInOutAnimation;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.car.climate.ClimateConfigData;
import de.vw.mib.widgets.car.climate.ClimateConfigDataHelper;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.models.ClimateModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.WidgetUI;
import edu.emory.mathcs.backport.java.util.Arrays;

public class Climate
extends AbstractWidget
implements ClimateModel {
    private int aspect;
    private Color blendColorAutomatic;
    private Color blendColorCold;
    private Color blendColorWarm;
    private Color[] exhaustColors;
    private int[] exhaustStates;
    private boolean[] exhaustsActive;
    private int exhaustsAlpha;
    private boolean[] exhaustsCold;
    private TemplateListModel listRef;
    private ClimateConfigData configData;
    private GenericCarAdjusterConfigData configDataNg;
    private int interiorPosition;
    private int interiorScale;
    private RawConfigDataProxy rawConfigData;
    private Climate$SlideUpDownAnimation slideUpDownAnimation;
    private Climate$ZoomInOutAnimation zoomInOutAnimation;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ClimateUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$Climate2UI;

    public void init(boolean bl, int n, int n2, boolean bl2, boolean bl3, Color color, Color color2, Color color3, EasingParams[] easingParamsArray, boolean bl4, Color[] colorArray, boolean[] blArray, int n3, boolean[] blArray2, int[] nArray, int n4, boolean bl5, TemplateListModel templateListModel, String string, boolean bl6, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        super.init(bl, n, bl3, easingParamsArray, bl4, n4, bl5, string, n5, insets, bl7, n6, n7, n8);
        this.aspect = n2;
        this.blendColorAutomatic = color;
        this.blendColorCold = color2;
        this.blendColorWarm = color3;
        this.exhaustColors = colorArray;
        this.exhaustStates = nArray;
        this.exhaustsActive = blArray;
        this.exhaustsAlpha = n3;
        this.exhaustsCold = blArray2;
        this.listRef = templateListModel;
        this.setInternalStateFlag(9, bl2);
        this.setInternalStateFlag(10, bl6);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.passButtonPositionsToReferencedList();
        this.initInteriorScaleAndPosition(this.aspect);
    }

    @Override
    public void deInit() {
        this.configData = null;
        this.configDataNg = null;
        this.stopSlideUpDownAnimation();
        this.stopZoomInOutAnimation();
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        this.aspect = -1;
        this.blendColorAutomatic = null;
        this.blendColorCold = null;
        this.blendColorWarm = null;
        this.configData = null;
        this.configDataNg = null;
        this.exhaustColors = null;
        this.exhaustStates = null;
        this.exhaustsActive = null;
        this.exhaustsCold = null;
        this.interiorPosition = 0;
        this.interiorScale = 100;
        this.listRef = null;
    }

    @Override
    public final int get_aspect() {
        return this.aspect;
    }

    @Override
    public final void set_aspect(int n) {
        int n2 = this.get_aspect();
        if (n2 != n) {
            this.aspect = n;
            this.aspectChanged(n2);
            this.propertyChanged(15);
        }
    }

    @Override
    public final boolean is_automaticAirflow() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public final void set_automaticAirflow(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.automaticAirflowChanged(bl2);
            this.propertyChanged(16);
        }
    }

    @Override
    public final Color get_blendColorAutomatic() {
        return this.blendColorAutomatic;
    }

    @Override
    public final void set_blendColorAutomatic(Color color) {
        Color color2 = this.blendColorAutomatic;
        if (color2 == null || !color2.equals(color)) {
            this.blendColorAutomatic = color;
            this.blendColorAutomaticChanged(color2);
            this.propertyChanged(17);
        }
    }

    @Override
    public final Color get_blendColorCold() {
        return this.blendColorCold;
    }

    @Override
    public final void set_blendColorCold(Color color) {
        Color color2 = this.blendColorCold;
        if (color2 == null || !color2.equals(color)) {
            this.blendColorCold = color;
            this.blendColorColdChanged(color2);
            this.propertyChanged(18);
        }
    }

    @Override
    public final Color get_blendColorWarm() {
        return this.blendColorWarm;
    }

    @Override
    public final void set_blendColorWarm(Color color) {
        Color color2 = this.blendColorWarm;
        if (color2 == null || !color2.equals(color)) {
            this.blendColorWarm = color;
            this.blendColorWarmChanged(color2);
            this.propertyChanged(19);
        }
    }

    @Override
    public final Color[] get_exhaustColors() {
        return this.exhaustColors;
    }

    @Override
    public final void set_exhaustColors(Color[] colorArray) {
        Object[] objectArray = this.get_exhaustColors();
        if (objectArray == null || !Arrays.equals(objectArray, colorArray)) {
            this.exhaustColors = colorArray;
            this.exhaustColorsChanged((Color[])objectArray);
            this.propertyChanged(20);
        }
    }

    @Override
    public final int[] get_exhaustStates() {
        return this.exhaustStates;
    }

    @Override
    public final void set_exhaustStates(int[] nArray) {
        int[] nArray2 = this.get_exhaustStates();
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.exhaustStates = nArray;
            this.exhaustStatesChanged(nArray2);
            this.propertyChanged(21);
        }
    }

    @Override
    public final boolean[] get_exhaustsActive() {
        return this.exhaustsActive;
    }

    @Override
    public final void set_exhaustsActive(boolean[] blArray) {
        boolean[] blArray2 = this.exhaustsActive;
        if (blArray2 != blArray) {
            this.exhaustsActive = blArray;
            this.exhaustsActiveChanged(blArray2);
            this.propertyChanged(22);
        }
    }

    @Override
    public final int get_exhaustsAlpha() {
        return this.exhaustsAlpha;
    }

    @Override
    public final void set_exhaustsAlpha(int n) {
        int n2 = this.exhaustsAlpha;
        if (n2 != n) {
            this.exhaustsAlpha = n;
            this.exhaustsAlphaChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final boolean[] get_exhaustsCold() {
        return this.exhaustsCold;
    }

    @Override
    public final void set_exhaustsCold(boolean[] blArray) {
        boolean[] blArray2 = this.exhaustsCold;
        if (blArray2 != blArray) {
            this.exhaustsCold = blArray;
            this.exhaustsColdChanged(blArray2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final TemplateListModel get_listRef() {
        return this.listRef;
    }

    @Override
    public final void set_listRef(TemplateListModel templateListModel) {
        TemplateListModel templateListModel2 = this.get_listRef();
        if (templateListModel2 != templateListModel) {
            this.listRef = templateListModel;
            this.listRefChanged(templateListModel2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final boolean is_rightHandDrive() {
        return this.getInternalStateFlag(10);
    }

    @Override
    public final void set_rightHandDrive(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(10);
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.rightHandDriveChanged(bl2);
            this.propertyChanged(26);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ClimateUI == null ? (class$de$vw$mib$widgets$ui$ClimateUI = Climate.class$("de.vw.mib.widgets.ui.ClimateUI")) : class$de$vw$mib$widgets$ui$ClimateUI, class$de$vw$mib$widgets$ui$Climate2UI == null ? (class$de$vw$mib$widgets$ui$Climate2UI = Climate.class$("de.vw.mib.widgets.ui.Climate2UI")) : class$de$vw$mib$widgets$ui$Climate2UI};
    }

    @Override
    public final AbstractConfigData getConfigData() {
        WidgetUI widgetUI = this.getUI();
        if (widgetUI != null) {
            if (super.getClass() == (class$de$vw$mib$widgets$ui$ClimateUI == null ? (class$de$vw$mib$widgets$ui$ClimateUI = Climate.class$("de.vw.mib.widgets.ui.ClimateUI")) : class$de$vw$mib$widgets$ui$ClimateUI)) {
                if (this.configData == null) {
                    this.configData = new ClimateConfigData();
                }
                if (!this.configData.isDeserialized()) {
                    this.configData.init(this.rawConfigData);
                }
                return this.configData;
            }
            if (this.configDataNg == null) {
                this.configDataNg = new GenericCarAdjusterConfigData("Climate", this.is_rightHandDrive() ? 1 : 0);
            }
            if (!this.configDataNg.isDeserialized()) {
                this.configDataNg.init(this.rawConfigData);
            }
            return this.configDataNg;
        }
        return null;
    }

    @Override
    public final int getInteriorPositionY() {
        return this.interiorPosition;
    }

    final void setInteriorPositionY(int n) {
        int n2 = this.interiorPosition;
        if (n2 != n) {
            this.interiorPosition = n;
            this.repaint();
        }
    }

    @Override
    public final int getInteriorScale() {
        return this.interiorScale;
    }

    final void setInteriorScale(int n) {
        int n2 = this.interiorScale;
        if (n2 != n) {
            this.interiorScale = n;
            this.repaint();
        }
    }

    @Override
    public final void setRawConfigData(RawConfigDataProxy rawConfigDataProxy) {
        RawConfigDataProxy rawConfigDataProxy2 = this.rawConfigData;
        if (rawConfigDataProxy2 == null || !rawConfigDataProxy2.equals(rawConfigDataProxy)) {
            this.rawConfigData = rawConfigDataProxy;
            this.rawConfigDataChanged(rawConfigDataProxy2);
        }
    }

    protected void aspectChanged(int n) {
        int n2 = this.get_aspect();
        this.startSlideUpDownAnimation(n, n2);
        this.startZoomInOutAnimation(n, n2);
        this.repaint();
    }

    protected void automaticAirflowChanged(boolean bl) {
        this.repaint();
    }

    protected void blendColorAutomaticChanged(Color color) {
        this.repaint();
    }

    protected void blendColorColdChanged(Color color) {
        this.repaint();
    }

    protected void blendColorWarmChanged(Color color) {
        this.repaint();
    }

    protected void exhaustColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void exhaustStatesChanged(int[] nArray) {
        this.repaint();
    }

    protected void exhaustsActiveChanged(boolean[] blArray) {
        this.repaint();
    }

    protected void exhaustsAlphaChanged(int n) {
        this.repaint();
    }

    protected void exhaustsColdChanged(boolean[] blArray) {
        this.repaint();
    }

    protected void listRefChanged(TemplateListModel templateListModel) {
        this.passButtonPositionsToReferencedList();
        this.repaint();
    }

    protected void rawConfigDataChanged(RawConfigDataProxy rawConfigDataProxy) {
        this.configData = null;
        this.configDataNg = null;
        this.getConfigData();
        this.passButtonPositionsToReferencedList();
        this.repaint();
    }

    protected void rightHandDriveChanged(boolean bl) {
        this.configDataNg = null;
        this.getConfigData();
        this.passButtonPositionsToReferencedList();
        this.repaint();
    }

    private void initInteriorScaleAndPosition(int n) {
        if (this.configDataNg == null) {
            this.getConfigData();
        }
        if (this.configDataNg != null) {
            int[] nArray = ClimateConfigDataHelper.determineBackgroundIndicesByAspect(n, this.configDataNg);
            int n2 = nArray.length > 0 ? this.configDataNg.getBackgroundPosY(nArray[0]) : 0;
            int n3 = nArray.length > 0 ? this.configDataNg.getBackgroundScale(nArray[0]) : 100;
            this.setInteriorPositionY(n2);
            this.setInteriorScale(n3);
        }
    }

    private void passButtonPositionsToReferencedList() {
        if (this.listRef != null) {
            int n;
            if (this.configDataNg == null) {
                this.getConfigData();
            }
            if (this.configDataNg != null && (n = this.configDataNg.getButtonDefinitionCount()) > 0) {
                Point[] pointArray = new Point[11];
                int[] nArray = ClimateConfigDataHelper.determineButtonIndicesByAspect(this.aspect, this.configDataNg);
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    Point point;
                    Point[] pointArray2 = this.configDataNg.getButtonVertices(nArray[i2]);
                    int n2 = this.configDataNg.getButtonId(nArray[i2]);
                    if (pointArray2 == null || pointArray2.length <= 0) continue;
                    int n3 = -1;
                    if (n2 >= 100 && n2 <= 199) {
                        n3 = 0 + n2 - 100;
                    } else if (n2 >= 200 && n2 <= 299) {
                        n3 = 2 + n2 - 200;
                    } else if (n2 >= 300 && n2 <= 399) {
                        n3 = 4 + n2 - 300;
                    } else if (n2 >= 400 && n2 <= 499) {
                        n3 = 9 + n2 - 400;
                    } else {
                        LOGGER.warn(128).append("Widget '").append(this.getQualifiedName()).append("': Unknown button id defined in configuration file [buttonId=").append(n2).append("]!").log();
                    }
                    if (n3 < 0 || n3 >= pointArray.length) continue;
                    pointArray[n3] = point = pointArray2[0];
                }
                this.listRef.set_itemPoints(pointArray);
            }
        }
    }

    private boolean startSlideUpDownAnimation(int n, int n2) {
        int n3;
        if (this.configDataNg == null || !this.configDataNg.isDeserialized()) {
            LogMessage logMessage = LOGGER.warn(128).append("startSlideUpDownAnimation: Missing/unexpected configuration file!");
            if (this.configDataNg != null) {
                logMessage.append(" configFileName='").append(this.configDataNg.getConfigFileName()).append("'");
            }
            logMessage.log();
            return false;
        }
        int[] nArray = ClimateConfigDataHelper.determineBackgroundIndicesByAspect(n, this.configDataNg);
        int[] nArray2 = ClimateConfigDataHelper.determineBackgroundIndicesByAspect(n2, this.configDataNg);
        int n4 = nArray.length > 0 ? this.configDataNg.getBackgroundPosY(nArray[0]) : 0;
        int n5 = n3 = nArray2.length > 0 ? this.configDataNg.getBackgroundPosY(nArray2[0]) : 0;
        if (n4 != n3) {
            this.stopSlideUpDownAnimation();
            EasingParams easingParams = this.getEasing(8);
            this.slideUpDownAnimation = easingParams != null ? new Climate$SlideUpDownAnimation(this, this, easingParams) : new Climate$SlideUpDownAnimation(this, this);
            this.slideUpDownAnimation.setAnimationParams(n4, n3);
            return this.startInternalAnimation(this.slideUpDownAnimation);
        }
        return false;
    }

    private boolean startZoomInOutAnimation(int n, int n2) {
        int n3;
        if (this.configDataNg == null || !this.configDataNg.isDeserialized()) {
            LogMessage logMessage = LOGGER.warn(128).append("startZoomInOutAnimation: Missing/unexpected configuration file!");
            if (this.configDataNg != null) {
                logMessage.append(" configFileName='").append(this.configDataNg.getConfigFileName()).append("'");
            }
            logMessage.log();
            return false;
        }
        int[] nArray = ClimateConfigDataHelper.determineBackgroundIndicesByAspect(n, this.configDataNg);
        int[] nArray2 = ClimateConfigDataHelper.determineBackgroundIndicesByAspect(n2, this.configDataNg);
        int n4 = nArray.length > 0 ? this.configDataNg.getBackgroundScale(nArray[0]) : 100;
        int n5 = n3 = nArray2.length > 0 ? this.configDataNg.getBackgroundScale(nArray2[0]) : 100;
        if (n4 != n3) {
            this.stopZoomInOutAnimation();
            EasingParams easingParams = this.getEasing(9);
            this.zoomInOutAnimation = easingParams != null ? new Climate$ZoomInOutAnimation(this, this, easingParams) : new Climate$ZoomInOutAnimation(this, this);
            this.zoomInOutAnimation.setAnimationParams(n4, n3);
            return this.startInternalAnimation(this.zoomInOutAnimation);
        }
        return false;
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopSlideUpDownAnimation();
        this.stopZoomInOutAnimation();
    }

    private void stopSlideUpDownAnimation() {
        if (this.slideUpDownAnimation != null) {
            this.stopInternalAnimation(this.slideUpDownAnimation);
            this.slideUpDownAnimation = null;
        }
    }

    private void stopZoomInOutAnimation() {
        if (this.zoomInOutAnimation != null) {
            this.stopInternalAnimation(this.zoomInOutAnimation);
            this.zoomInOutAnimation = null;
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

