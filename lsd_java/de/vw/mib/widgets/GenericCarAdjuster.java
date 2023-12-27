/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.GenericCarAdjuster$AmbientInteriorColorHandler;
import de.vw.mib.widgets.GenericCarAdjuster$SingleFeatureValueAnimation;
import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.controller.GenericCarAdjusterController;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;

public class GenericCarAdjuster
extends AbstractWidget
implements GenericCarAdjusterModel {
    private static final int FEATURE_VALUE_MIN;
    private static final int FEATURE_VALUE_MAX;
    private static final int FEATURE_VALUE_THRESHOLD;
    private ButtonModel[] buttonRefs;
    private String configIdentifier;
    private int configSubType;
    private int[] featureButtonMapping;
    private Color[] featureColors;
    private boolean[] featureAmbientInteriorColored;
    private int featureEffectType;
    private int[] featureStates;
    private int[] featureValues;
    private GenericCarAdjusterConfigData configData;
    private RawConfigDataProxy rawConfigData;
    private ArrayList featureValueAnimations;
    private int activeButtonIdx;
    private GenericCarAdjuster$AmbientInteriorColorHandler ambientInteriorColorHandler;
    private int[] animationFeatureValues;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$GenericCarAdjusterUI;

    @Override
    protected void reset() {
        super.reset();
        this.configData = null;
        this.rawConfigData = null;
        if (this.featureValueAnimations == null) {
            this.featureValueAnimations = new ArrayList();
        }
        this.featureValueAnimations.clear();
        this.activeButtonIdx = 0;
    }

    public void init(boolean bl, int n, boolean bl2, ButtonModel[] buttonModelArray, String string, int n2, EasingParams[] easingParamsArray, boolean bl3, boolean[] blArray, int[] nArray, Color[] colorArray, int n3, int[] nArray2, int[] nArray3, int n4, boolean bl4, String string2, int n5, Insets insets, boolean bl5, int n6, int n7, int n8) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n4, bl4, string2, n5, insets, bl5, n6, n7, n8);
        this.buttonRefs = buttonModelArray;
        this.configIdentifier = string;
        this.featureButtonMapping = nArray;
        this.featureAmbientInteriorColored = blArray;
        this.featureColors = colorArray;
        this.featureEffectType = n3;
        this.featureStates = nArray2;
        this.featureValues = nArray3;
        this.configSubType = n2;
        if (this.getController() != null) {
            ((GenericCarAdjusterController)this.getController()).updateButtonListener(null);
        }
        this.updateButtonPositionsAndOutlines();
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateAnimationFeatureValues();
        this.configData = new GenericCarAdjusterConfigData(this.configIdentifier, this.configSubType);
        this.ambientInteriorColorHandler = new GenericCarAdjuster$AmbientInteriorColorHandler();
    }

    @Override
    public void deInit() {
        this.configData = null;
        this.ambientInteriorColorHandler.dispose();
        this.ambientInteriorColorHandler = null;
        this.stopFeatureValueAnimation();
        super.deInit();
    }

    @Override
    public ButtonModel[] get_buttonRefs() {
        return this.buttonRefs;
    }

    @Override
    public void set_buttonRefs(ButtonModel[] buttonModelArray) {
        Object[] objectArray = this.buttonRefs;
        if (objectArray == null || !Arrays.equals(objectArray, buttonModelArray)) {
            this.buttonRefs = buttonModelArray;
            this.buttonRefsChanged((ButtonModel[])objectArray);
            this.propertyChanged(15);
        }
    }

    @Override
    public String get_configIdentifier() {
        return this.configIdentifier;
    }

    @Override
    public void set_configIdentifier(String string) {
        String string2 = this.configIdentifier;
        if (string2 == null || !string2.equals(string)) {
            this.configIdentifier = string;
            this.configIdentifierChanged(string2);
            this.propertyChanged(16);
        }
    }

    @Override
    public Color[] get_featureColors() {
        return this.featureColors;
    }

    @Override
    public void set_featureColors(Color[] colorArray) {
        Object[] objectArray = this.featureColors;
        if (objectArray == null || !Arrays.equals(objectArray, colorArray)) {
            this.featureColors = colorArray;
            this.featureColorsChanged((Color[])objectArray);
            this.propertyChanged(19);
        }
    }

    @Override
    public boolean[] get_featureAmbientInteriorColored() {
        return this.featureAmbientInteriorColored;
    }

    @Override
    public void set_featureAmbientInteriorColored(boolean[] blArray) {
        boolean[] blArray2 = this.featureAmbientInteriorColored;
        if (blArray2 == null || !Arrays.equals(blArray2, blArray)) {
            this.featureAmbientInteriorColored = blArray;
            this.featureAmbientInteriorColoredChanged(blArray2);
            this.propertyChanged(23);
        }
    }

    @Override
    public int[] get_featureButtonMapping() {
        return this.featureButtonMapping;
    }

    @Override
    public void set_featureButtonMapping(int[] nArray) {
        int[] nArray2 = this.featureButtonMapping;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.featureButtonMapping = nArray;
            this.featureButtonMappingChanged(nArray2);
            this.propertyChanged(22);
        }
    }

    @Override
    public int get_featureEffectType() {
        return this.featureEffectType;
    }

    @Override
    public void set_featureEffectType(int n) {
        int n2 = this.featureEffectType;
        if (n2 != n) {
            this.featureEffectType = n;
            this.featureEffectTypeChanged(n2);
            this.propertyChanged(20);
        }
    }

    @Override
    public int[] get_featureStates() {
        return this.featureStates;
    }

    @Override
    public void set_featureStates(int[] nArray) {
        int[] nArray2 = this.featureStates;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.featureStates = nArray;
            this.featureStatesChanged(nArray2);
            this.propertyChanged(18);
        }
    }

    @Override
    public int[] get_featureValues() {
        return this.featureValues;
    }

    @Override
    public void set_featureValues(int[] nArray) {
        int[] nArray2 = this.featureValues;
        this.stopFeatureValueAnimation();
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.featureValues = nArray;
            this.featureValuesChanged(nArray2);
            this.propertyChanged(21);
        }
    }

    @Override
    public int get_configSubType() {
        return this.configSubType;
    }

    @Override
    public void set_configSubType(int n) {
        int n2 = this.configSubType;
        if (n2 != n) {
            this.configSubType = n;
            this.configSubTypeChanged(n2);
            this.propertyChanged(17);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$GenericCarAdjusterUI == null ? (class$de$vw$mib$widgets$ui$GenericCarAdjusterUI = GenericCarAdjuster.class$("de.vw.mib.widgets.ui.GenericCarAdjusterUI")) : class$de$vw$mib$widgets$ui$GenericCarAdjusterUI};
    }

    @Override
    public AbstractConfigData getConfigData() {
        if (this.configData != null && !this.configData.isDeserialized()) {
            this.configData.init(this.rawConfigData);
            this.updateButtonPositionsAndOutlines();
        }
        return this.configData;
    }

    @Override
    public void setRawConfigData(RawConfigDataProxy rawConfigDataProxy) {
        RawConfigDataProxy rawConfigDataProxy2 = this.rawConfigData;
        if (rawConfigDataProxy2 == null || !rawConfigDataProxy2.equals(rawConfigDataProxy)) {
            this.rawConfigData = rawConfigDataProxy;
            this.rawConfigDataChanged(rawConfigDataProxy2);
        }
    }

    @Override
    public void setActiveButtonIdx(int n) {
        int n2 = this.activeButtonIdx;
        if (n2 != n || !this.areFeatureValueAnimationsActive()) {
            this.activeButtonIdx = n;
            this.activeButtonIdxChanged();
        }
    }

    @Override
    public boolean isFeatureActive(int n) {
        if (n < 0 || n >= this.featureStates.length) {
            return false;
        }
        return this.featureStates[n] == 1;
    }

    @Override
    public String getConfigSubTypeName() {
        if (this.configSubType < 0 || this.configSubType >= CONFIG_SUB_TYPE_NAMES.length) {
            LOGGER.error(128).append("GenericCarAdjuster: Unknown configSubType: ").append(this.configSubType);
            return "";
        }
        return CONFIG_SUB_TYPE_NAMES[this.configSubType];
    }

    protected void setAnimationFeatureValueForId(int n, int n2) {
        if (this.animationFeatureValues != null && n >= 0 && n < this.animationFeatureValues.length) {
            this.animationFeatureValues[n] = n2;
        }
    }

    @Override
    public int getAnimationFeatureValue(int n) {
        if (n < 0 || n >= this.animationFeatureValues.length) {
            LOGGER.warn(128).append("GenericCarAdjuster (").append(this.getQualifiedName()).append("): No value found for feature ").append(n).log();
            return 0;
        }
        return this.animationFeatureValues[n];
    }

    @Override
    public Color getFeatureColor(int n) {
        Color color = Color.WHITE;
        boolean bl = false;
        if (this.featureAmbientInteriorColored != null && n >= 0 && n < this.featureAmbientInteriorColored.length) {
            bl = this.featureAmbientInteriorColored[n];
        }
        if (bl) {
            color = this.ambientInteriorColorHandler.getAmbientInteriorColor();
        } else if (this.featureColors != null && n >= 0 && n < this.featureColors.length) {
            color = this.featureColors[n];
        }
        return color;
    }

    private void activeButtonIdxChanged() {
        this.startFeatureValueAnimationPartOne(this.activeButtonIdx);
    }

    private void featureButtonMappingChanged(int[] nArray) {
        this.updateButtonPositionsAndOutlines();
    }

    private void buttonRefsChanged(ButtonModel[] buttonModelArray) {
        if (this.getController() != null) {
            ((GenericCarAdjusterController)this.getController()).updateButtonListener(buttonModelArray);
        }
        this.updateButtonPositionsAndOutlines();
    }

    private void configIdentifierChanged(String string) {
        this.updateConfigData();
    }

    private void featureColorsChanged(Color[] colorArray) {
        this.stopFeatureValueAnimation();
        this.repaint();
    }

    private void featureAmbientInteriorColoredChanged(boolean[] blArray) {
        this.repaint();
    }

    private void featureEffectTypeChanged(int n) {
        this.repaint();
    }

    private void featureStatesChanged(int[] nArray) {
        this.stopFeatureValueAnimation();
        this.updateButtonPositionsAndOutlines();
    }

    private void featureValuesChanged(int[] nArray) {
        this.updateAnimationFeatureValues();
        this.repaint();
    }

    private void configSubTypeChanged(int n) {
        this.updateConfigData();
    }

    private void rawConfigDataChanged(RawConfigDataProxy rawConfigDataProxy) {
        this.configData = new GenericCarAdjusterConfigData(this.configIdentifier, this.configSubType);
        this.configData.init(this.rawConfigData);
        this.updateButtonPositionsAndOutlines();
    }

    private void updateConfigData() {
        this.configData = new GenericCarAdjusterConfigData(this.configIdentifier, this.configSubType);
        this.repaint();
    }

    private void updateButtonPositionsAndOutlines() {
        if (this.buttonRefs == null || this.featureStates == null || this.configData == null) {
            return;
        }
        if (this.buttonRefs != null && this.featureStates != null) {
            for (int i2 = this.buttonRefs.length - 1; i2 >= 0; --i2) {
                boolean bl = false;
                int n = this.configData.getButtonIndex(i2);
                int n2 = this.configData.getButtonId(n);
                if (n2 != -1) {
                    for (int i3 = this.featureButtonMapping.length - 1; i3 >= 0; --i3) {
                        if (i3 >= this.featureStates.length) {
                            bl = true;
                            break;
                        }
                        if (this.featureStates[i3] != 1 || this.featureButtonMapping[i3] != n2) continue;
                        bl = true;
                        break;
                    }
                }
                if (this.buttonRefs[i2] == null) continue;
                this.buttonRefs[i2].set_visible(bl);
                if (!bl) continue;
                this.buttonRefs[i2].set_vertices(this.configData.getButtonVertices(n));
                this.adjustButtonImagesPositionAndDimension(this.buttonRefs[i2], n);
            }
        }
        this.repaint();
    }

    private void adjustButtonImagesPositionAndDimension(ButtonModel buttonModel, int n) {
        this.adjustButtonImagesPositionAndDimension(buttonModel.get_imageStateRef(), n);
    }

    private void adjustButtonImagesPositionAndDimension(StaticImageModel staticImageModel, int n) {
        if (staticImageModel == null) {
            return;
        }
        staticImageModel.set_x(this.configData.getButtonImageX(n));
        staticImageModel.set_y(this.configData.getButtonImageY(n));
    }

    private void updateAnimationFeatureValues() {
        if (this.featureValues != null) {
            this.animationFeatureValues = edu.emory.mathcs.backport.java.util.Arrays.copyOf(this.featureValues, this.featureValues.length);
        }
    }

    private boolean startFeatureValueAnimationPartOne(int n) {
        this.stopFeatureValueAnimation();
        this.clearFeatureValueAnimations();
        EasingParams easingParams = this.getEasing(7);
        if (easingParams == null) {
            return false;
        }
        boolean bl = false;
        int n2 = this.configData.getButtonId(this.configData.getButtonIndex(n));
        if (n2 == -1) {
            return false;
        }
        if (this.featureButtonMapping.length != this.featureStates.length) {
            return false;
        }
        for (int i2 = this.featureButtonMapping.length - 1; i2 >= 0; --i2) {
            if (this.featureStates[i2] != 1 || this.featureButtonMapping[i2] != n2) continue;
            int n3 = 0;
            if (this.featureValues[i2] < 75) {
                n3 = 100;
            }
            GenericCarAdjuster$SingleFeatureValueAnimation genericCarAdjuster$SingleFeatureValueAnimation = new GenericCarAdjuster$SingleFeatureValueAnimation(this, easingParams, this.featureValues[i2], n3, i2, false);
            this.featureValueAnimations.add(genericCarAdjuster$SingleFeatureValueAnimation);
            bl |= this.startInternalAnimation(genericCarAdjuster$SingleFeatureValueAnimation);
        }
        return bl;
    }

    protected boolean startFeatureValueAnimationPartTwo(int n, int n2) {
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null) {
            return false;
        }
        GenericCarAdjuster$SingleFeatureValueAnimation genericCarAdjuster$SingleFeatureValueAnimation = new GenericCarAdjuster$SingleFeatureValueAnimation(this, easingParams, this.featureValues[n], n2, n, true);
        this.featureValueAnimations.add(genericCarAdjuster$SingleFeatureValueAnimation);
        return this.startInternalAnimation(genericCarAdjuster$SingleFeatureValueAnimation);
    }

    private void clearFeatureValueAnimations() {
        this.featureValueAnimations.clear();
    }

    private boolean areFeatureValueAnimationsActive() {
        boolean bl = false;
        for (int i2 = this.featureValueAnimations.size() - 1; i2 >= 0; --i2) {
            GenericCarAdjuster$SingleFeatureValueAnimation genericCarAdjuster$SingleFeatureValueAnimation = (GenericCarAdjuster$SingleFeatureValueAnimation)this.featureValueAnimations.get(i2);
            bl |= genericCarAdjuster$SingleFeatureValueAnimation.isActive();
        }
        return bl;
    }

    private void stopFeatureValueAnimation() {
        for (int i2 = this.featureValueAnimations.size() - 1; i2 >= 0; --i2) {
            GenericCarAdjuster$SingleFeatureValueAnimation genericCarAdjuster$SingleFeatureValueAnimation = (GenericCarAdjuster$SingleFeatureValueAnimation)this.featureValueAnimations.get(i2);
            this.stopInternalAnimation(genericCarAdjuster$SingleFeatureValueAnimation);
        }
        this.featureValueAnimations.clear();
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopFeatureValueAnimation();
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

