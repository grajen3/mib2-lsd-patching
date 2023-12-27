/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawableException;
import de.vw.mib.graphics.drawable.image.ColorConversionDrawable;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.SkinHelper;
import de.vw.mib.widgets.car.energyflow.EnergyFlowConfigData;
import de.vw.mib.widgets.car.energyflow.EnergyFlowConstants;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.EnergyFlowModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.ImageLoadingException;
import java.io.IOException;

public final class EnergyFlowUI
extends AbstractWidgetUI
implements PropertyChangedListener {
    private static final int COUNT_FLOOR_COLOR_CONVERSION_DRAWABLES;
    private static final int COUNT_ENERGY_FLOW_MASK_IMAGES;
    private static final int COUNT_ENERGY_FLOW_BATTERY_IMAGES;
    private static final int COUNT_WHEELS;
    public static final int COUNT_CAR_IMAGES;
    private static final int COUNT_BATTERY_IMAGES;
    public static final int HSV_COLOR_LEN;
    private static final int FEATURE_IDX_ENGINE;
    private static final int FEATURE_IDX_ELECTRIC_MOTOR;
    private static final int FEATURE_IDX_COUNT;
    private EnergyFlowModel model;
    private boolean errMsgAlreadyLogged = false;
    private ColorConversionDrawable[][] wheelEnergyFlowColorConversionDrawables;
    private ColorConversionDrawable[] floorEnergyFlowColorConversionDrawables;
    private ImageDrawable[] carBodyImageDrawables;
    private ImageDrawable[] energyFlowBatteryImageDrawables;
    private ImageDrawable[] energyFlowMaskImageDrawables;
    private ImageDrawable[][] featureImageDrawables;
    private ImageDrawable[] batteryImageDrawables;
    private Color4b[] colorGradient;
    private boolean isImageLoadingDone;
    private StringBuilder sb;

    @Override
    public void init() {
        super.init();
        this.model = (EnergyFlowModel)this.getWidget();
        if (this.model != null) {
            this.model.addPropertyChangedListener(this);
        }
        this.sb = new StringBuilder();
        this.colorGradient = new Color4b[2];
    }

    @Override
    public void reset() {
        super.reset();
        this.resetInternalProperties();
    }

    @Override
    public void deInit() {
        if (this.model != null) {
            this.model.removePropertyChangedListener(this);
        }
        this.resetInternalProperties();
        this.model = null;
        this.colorGradient = null;
        this.sb = null;
        super.deInit();
    }

    private void resetInternalProperties() {
        EnergyFlowUI.disposeDrawables(this.carBodyImageDrawables);
        this.carBodyImageDrawables = null;
        EnergyFlowUI.disposeDrawables(this.batteryImageDrawables);
        this.batteryImageDrawables = null;
        EnergyFlowUI.disposeDrawables(this.energyFlowMaskImageDrawables);
        this.energyFlowMaskImageDrawables = null;
        EnergyFlowUI.disposeDrawables(this.floorEnergyFlowColorConversionDrawables);
        this.floorEnergyFlowColorConversionDrawables = null;
        EnergyFlowUI.disposeDrawables(this.wheelEnergyFlowColorConversionDrawables);
        this.wheelEnergyFlowColorConversionDrawables = null;
        EnergyFlowUI.disposeDrawables(this.featureImageDrawables);
        this.featureImageDrawables = null;
        this.isImageLoadingDone = false;
        this.errMsgAlreadyLogged = false;
    }

    private void createWheelColorConversionDrawables(Graphics3D graphics3D, EnergyFlowModel energyFlowModel) {
        if (this.wheelEnergyFlowColorConversionDrawables == null) {
            this.wheelEnergyFlowColorConversionDrawables = new ColorConversionDrawable[2][32];
            for (int i2 = 1; i2 >= 0; --i2) {
                for (int i3 = 31; i3 >= 0; --i3) {
                    String string = this.buildImageNameForCarType(EnergyFlowUI.createWheelImagePathColorize(i3, i2, true, this.sb));
                    this.wheelEnergyFlowColorConversionDrawables[i2][i3] = this.createColorConversionDrawable(graphics3D, energyFlowModel, string);
                }
            }
        }
    }

    private void createFloorColorConversionDrawables(Graphics3D graphics3D, EnergyFlowModel energyFlowModel) {
        if (this.floorEnergyFlowColorConversionDrawables == null) {
            this.floorEnergyFlowColorConversionDrawables = new ColorConversionDrawable[2];
            for (int i2 = 1; i2 >= 0; --i2) {
                String string = this.buildImageNameForCarType(EnergyFlowConstants.E_FLOW_UNDER_WHEEL_IMAGES[i2]);
                this.floorEnergyFlowColorConversionDrawables[i2] = this.createColorConversionDrawable(graphics3D, energyFlowModel, string);
            }
        }
    }

    private ColorConversionDrawable createColorConversionDrawable(Graphics3D graphics3D, EnergyFlowModel energyFlowModel, String string) {
        BufferImage bufferImage = SkinHelper.getCarSpecificImageFromCommonSkin(string, 4);
        ColorConversionDrawable colorConversionDrawable = graphics3D.getDrawableManager().createColorConversionDrawable();
        colorConversionDrawable.setImage(bufferImage);
        colorConversionDrawable.setFirstSourceColors(energyFlowModel.getEMotorColors(this.colorGradient));
        colorConversionDrawable.setFirstDestinationColors(energyFlowModel.getCurrentColor(this.colorGradient));
        colorConversionDrawable.setSecondSourceColors(energyFlowModel.getEngineColors(this.colorGradient));
        colorConversionDrawable.setSecondDestinationColors(energyFlowModel.getCurrentColor(this.colorGradient));
        return colorConversionDrawable;
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        EnergyFlowConfigData energyFlowConfigData = (EnergyFlowConfigData)this.model.getConfigData();
        if (energyFlowConfigData != null && energyFlowConfigData.isDeserialized()) {
            if (!this.isImageLoadingDone) {
                try {
                    this.createImageDrawables(graphics3D);
                    this.createFloorColorConversionDrawables(graphics3D, this.model);
                    this.createWheelColorConversionDrawables(graphics3D, this.model);
                }
                catch (DrawableException drawableException) {
                }
                catch (ImageLoadingException imageLoadingException) {
                    if (IS_DEVELOPMENT_BUILD) {
                        super.paintUnavailable(graphics3D, widgetModel, "Images are not available/complete");
                    }
                    if (!this.errMsgAlreadyLogged) {
                        this.errMsgAlreadyLogged = true;
                    }
                    return;
                }
                catch (IOException iOException) {
                    if (IS_DEVELOPMENT_BUILD) {
                        super.paintUnavailable(graphics3D, widgetModel, "Images are not available/complete");
                    }
                    if (!this.errMsgAlreadyLogged) {
                        LogMessage logMessage = LOGGER.error(4);
                        logMessage.append("Widget '").append("EnergyFlow").append("':  Unable to load image: ").append(iOException.getLocalizedMessage()).log();
                        logMessage = LOGGER.error(128);
                        logMessage.append("Widget '").append(this.model.getQualifiedName()).append("': Unable to paint widget, because of the missing/unexpected image file'").log();
                        this.errMsgAlreadyLogged = true;
                    }
                    return;
                }
                this.isImageLoadingDone = true;
            }
            try {
                short s = energyFlowConfigData.getCarPositionX(0);
                short s2 = energyFlowConfigData.getCarPositionY(0);
                this.carBodyImageDrawables[0].setAlpha(f2);
                this.carBodyImageDrawables[0].draw(s, s2);
                if (this.model.get_motionState() < 0 || this.model.get_motionState() >= 2) {
                    this.drawFeatures(graphics3D, energyFlowConfigData, f2);
                    this.carBodyImageDrawables[1].setAlpha(f2);
                    this.carBodyImageDrawables[1].draw(s, s2);
                    return;
                }
                this.drawMaskedEnergyFlows(graphics3D, energyFlowConfigData, f2);
                this.drawEnergyFlowAroundWheels(graphics3D, energyFlowConfigData, f2);
                this.drawFeatures(graphics3D, energyFlowConfigData, f2);
                this.carBodyImageDrawables[1].setAlpha(f2);
                this.carBodyImageDrawables[1].draw(s, s2);
            }
            catch (DrawableException drawableException) {}
        } else {
            if (IS_DEVELOPMENT_BUILD) {
                super.paintUnavailable(graphics3D, widgetModel, "Missing/unexpected configuration file");
            }
            if (!this.errMsgAlreadyLogged) {
                LogMessage logMessage = LOGGER.error(128);
                logMessage.append("Widget '").append(this.model.getQualifiedName()).append("': Unable to paint widget, because of the missing/unexpected configuration file. '").log();
                this.errMsgAlreadyLogged = true;
            }
        }
    }

    private void drawMaskedEnergyFlows(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        graphics3D.setStencilBufferEnabled(1);
        graphics3D.clearStencilBuffer(0);
        graphics3D.setStencilTestEnabled(true);
        graphics3D.setStencilTest(7, 1, 1);
        graphics3D.setStencilOperation(2, 2, 2);
        graphics3D.setAlphaTestEnabled(true);
        graphics3D.setAlphaTest(4, -842216387);
        graphics3D.setColorBufferEnabled(false, false, false, false);
        this.drawMasks(graphics3D, energyFlowConfigData, f2);
        graphics3D.setColorBufferEnabled(true, true, true, true);
        graphics3D.setAlphaTestEnabled(false);
        graphics3D.setStencilBufferEnabled(0);
        graphics3D.setStencilTest(2, 1, 1);
        this.drawEnergyFlows(graphics3D, energyFlowConfigData, f2);
        graphics3D.setStencilBufferEnabled(0);
        graphics3D.setStencilTestEnabled(false);
    }

    private void drawEnergyFlows(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        this.drawEnergyFlowToBattery(graphics3D, energyFlowConfigData, f2);
        if (this.model.get_energyState() > 0 && this.model.get_energyState() <= 5 && this.model.get_motionState() != 0) {
            this.drawEnergyFlowUnderWheels(graphics3D, energyFlowConfigData, f2);
        }
    }

    private void drawEnergyFlowUnderWheels(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        int n = 0;
        short s = 0;
        int n2 = 0;
        short s2 = 0;
        int n3 = 0;
        ColorConversionDrawable colorConversionDrawable = null;
        for (int i2 = EnergyFlowConstants.EF_INDICES_POS.length - 1; i2 >= 0; --i2) {
            if (this.model.get_energyState() != 3 && this.model.get_energyState() != 5) {
                n = EnergyFlowConstants.EF_INDICES_POS[i2];
                s = energyFlowConfigData.getShiftValue(EnergyFlowConstants.EF_SHIFT_INDICES_POS[i2]);
                colorConversionDrawable = this.floorEnergyFlowColorConversionDrawables[i2];
            } else {
                n = EnergyFlowConstants.EF_INDICES_NEG[i2];
                s = energyFlowConfigData.getShiftValue(EnergyFlowConstants.EF_SHIFT_INDICES_NEG[i2]);
                colorConversionDrawable = this.floorEnergyFlowColorConversionDrawables[i2];
            }
            n3 = Math.round((float)s * this.model.getPosXFlowWheels());
            n2 = energyFlowConfigData.getEnergyFlowPositionX(n) + n3;
            s2 = energyFlowConfigData.getEnergyFlowPositionY(n);
            colorConversionDrawable.setAlpha(f2);
            colorConversionDrawable.draw(n2, s2);
        }
    }

    private void drawEnergyFlowToBattery(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        int n;
        short s;
        ImageDrawable imageDrawable;
        int n2 = this.model.get_batteryState();
        if (n2 == 2) {
            imageDrawable = this.energyFlowBatteryImageDrawables[0];
            s = energyFlowConfigData.getShiftValues()[8];
            n = 0;
        } else if (n2 == 1) {
            imageDrawable = this.energyFlowBatteryImageDrawables[1];
            s = energyFlowConfigData.getShiftValues()[9];
            n = 22;
        } else {
            return;
        }
        int n3 = Math.round((float)s * this.model.getPosXFlowBattery());
        int n4 = energyFlowConfigData.getEnergyFlowPositionX(n) - n3;
        short s2 = energyFlowConfigData.getEnergyFlowPositionY(n);
        imageDrawable.setAlpha(f2);
        imageDrawable.draw(n4, s2);
    }

    private void drawEnergyFlowAroundWheels(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        if (this.model.get_energyState() <= 0 || this.model.get_energyState() > 5 || this.model.get_motionState() == 0) {
            return;
        }
        if (this.model.get_powerDriveConcept() == 2 || this.model.get_powerDriveConcept() == 0) {
            int n = this.model.getCurrentSequenceIndex();
            for (int i2 = 1; i2 >= 0; --i2) {
                int n2 = EnergyFlowConstants.EF_WHEEL_INDICES[i2];
                short s = energyFlowConfigData.getEnergyFlowPositionX(n2);
                short s2 = energyFlowConfigData.getEnergyFlowPositionY(n2);
                this.wheelEnergyFlowColorConversionDrawables[i2][n].setAlpha(f2);
                this.wheelEnergyFlowColorConversionDrawables[i2][n].draw(s, s2);
            }
        }
    }

    private void drawFeatures(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        for (int i2 = 1; i2 >= 0; --i2) {
            this.drawFeature(graphics3D, i2, energyFlowConfigData, f2);
        }
        this.drawBattery(graphics3D, energyFlowConfigData, f2);
    }

    private void drawBattery(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        int[] nArray = this.model.get_featureStates();
        if (nArray.length > 0) {
            int n = energyFlowConfigData.getFeaturePositionX(0);
            short s = energyFlowConfigData.getFeaturePositionY(0);
            switch (nArray[0]) {
                case 0: {
                    this.batteryImageDrawables[0].setAlpha(f2);
                    this.batteryImageDrawables[0].draw(n, s);
                    break;
                }
                case 1: {
                    int n2 = EnergyFlowUI.getIndexForStateOfCharge(this.model.get_batteryStateOfCharge());
                    this.batteryImageDrawables[n2].setAlpha(f2);
                    this.batteryImageDrawables[n2].draw(n, s);
                    break;
                }
            }
        }
    }

    private void drawFeature(Graphics3D graphics3D, int n, EnergyFlowConfigData energyFlowConfigData, float f2) {
        int n2;
        int[] nArray = this.model.get_featureStates();
        if (nArray.length > (n2 = n + 1)) {
            int n3 = energyFlowConfigData.getFeaturePositionX(n2);
            short s = energyFlowConfigData.getFeaturePositionY(n2);
            switch (nArray[n2]) {
                case 0: {
                    this.featureImageDrawables[n][0].setAlpha(f2);
                    this.featureImageDrawables[n][0].draw(n3, s);
                    break;
                }
                case 1: {
                    this.featureImageDrawables[n][1].setAlpha(f2);
                    this.featureImageDrawables[n][1].draw(n3, s);
                    break;
                }
            }
        }
    }

    private void drawMasks(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        this.drawBatteryMask(graphics3D, energyFlowConfigData, f2);
        this.drawOtherEnergyFlowMasks(graphics3D, energyFlowConfigData, f2);
    }

    private void drawOtherEnergyFlowMasks(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        ImageDrawable imageDrawable = null;
        short s = 0;
        short s2 = 0;
        int n = 0;
        for (int i2 = EnergyFlowConstants.EF_INDICES_MASK_POS.length - 1; i2 >= 0; --i2) {
            if (this.model.get_energyState() != 3 && this.model.get_energyState() != 5) {
                n = EnergyFlowConstants.EF_INDICES_MASK_POS[i2];
                imageDrawable = this.energyFlowMaskImageDrawables[EnergyFlowConstants.EF_IMG_INDICES_POS[i2]];
            } else {
                n = EnergyFlowConstants.EF_INDICES_MASK_NEG[i2];
                imageDrawable = this.energyFlowMaskImageDrawables[EnergyFlowConstants.EF_IMG_INDICES_NEG[i2]];
            }
            s = energyFlowConfigData.getEnergyFlowPositionX(n);
            s2 = energyFlowConfigData.getEnergyFlowPositionY(n);
            imageDrawable.setAlpha(f2);
            imageDrawable.draw(s, s2);
        }
    }

    private void drawBatteryMask(Graphics3D graphics3D, EnergyFlowConfigData energyFlowConfigData, float f2) {
        int n;
        ImageDrawable imageDrawable;
        int n2 = this.model.get_batteryState();
        if (n2 == 2) {
            imageDrawable = this.energyFlowMaskImageDrawables[2];
            n = 1;
        } else if (n2 == 1) {
            imageDrawable = this.energyFlowMaskImageDrawables[3];
            n = 23;
        } else {
            return;
        }
        short s = energyFlowConfigData.getEnergyFlowPositionX(n);
        short s2 = energyFlowConfigData.getEnergyFlowPositionY(n);
        imageDrawable.setAlpha(f2);
        imageDrawable.draw(s, s2);
    }

    private void updateDrawable() {
        int n;
        for (n = this.floorEnergyFlowColorConversionDrawables.length - 1; n >= 0; --n) {
            this.floorEnergyFlowColorConversionDrawables[n].setFirstSourceColors(this.model.getEMotorColors(this.colorGradient));
            this.floorEnergyFlowColorConversionDrawables[n].setFirstDestinationColors(this.model.getCurrentColor(this.colorGradient));
            this.floorEnergyFlowColorConversionDrawables[n].setSecondSourceColors(this.model.getEngineColors(this.colorGradient));
            this.floorEnergyFlowColorConversionDrawables[n].setSecondDestinationColors(this.model.getCurrentColor(this.colorGradient));
        }
        for (n = this.wheelEnergyFlowColorConversionDrawables.length - 1; n >= 0; --n) {
            for (int i2 = 31; i2 >= 0; --i2) {
                this.wheelEnergyFlowColorConversionDrawables[n][i2].setFirstSourceColors(this.model.getEMotorColors(this.colorGradient));
                this.wheelEnergyFlowColorConversionDrawables[n][i2].setFirstDestinationColors(this.model.getCurrentColor(this.colorGradient));
                this.wheelEnergyFlowColorConversionDrawables[n][i2].setSecondSourceColors(this.model.getEngineColors(this.colorGradient));
                this.wheelEnergyFlowColorConversionDrawables[n][i2].setSecondDestinationColors(this.model.getCurrentColor(this.colorGradient));
            }
        }
    }

    private void createImageDrawables(Graphics3D graphics3D) {
        int n;
        this.carBodyImageDrawables = new ImageDrawable[2];
        this.carBodyImageDrawables[0] = this.loadImageDrawableForCarType(graphics3D, "Hy_Car_Background");
        this.carBodyImageDrawables[1] = this.loadImageDrawableForCarType(graphics3D, "Hy_Car_Foreground");
        this.energyFlowMaskImageDrawables = new ImageDrawable[6];
        for (n = 5; n >= 0; --n) {
            this.energyFlowMaskImageDrawables[n] = this.loadImageDrawableForCarType(graphics3D, EnergyFlowConstants.E_FLOW_MASK_IMAGES[n]);
        }
        this.energyFlowBatteryImageDrawables = new ImageDrawable[2];
        for (n = 1; n >= 0; --n) {
            this.energyFlowBatteryImageDrawables[n] = this.loadImageDrawableForCarType(graphics3D, EnergyFlowConstants.E_FLOW_BATTERY_IMAGES[n]);
        }
        this.batteryImageDrawables = new ImageDrawable[11];
        for (n = 10; n >= 0; --n) {
            this.batteryImageDrawables[n] = this.loadImageDrawableForCarType(graphics3D, EnergyFlowUI.createBatteryImagePath(n, this.sb));
        }
        this.featureImageDrawables = new ImageDrawable[2][2];
        this.featureImageDrawables[0][0] = this.loadImageDrawableForCarType(graphics3D, "Hy_Drive_Engine", "_Inactive");
        this.featureImageDrawables[0][1] = this.loadImageDrawableForCarType(graphics3D, "Hy_Drive_Engine", "_Active");
        this.featureImageDrawables[1][0] = this.loadImageDrawableForCarType(graphics3D, "Hy_Drive_Emotor", "_Inactive");
        this.featureImageDrawables[1][1] = this.loadImageDrawableForCarType(graphics3D, "Hy_Drive_Emotor", "_Active");
    }

    private String buildImageNameForCarType(String string) {
        String string2 = EnergyFlowConstants.CAR_TYPE_DIR[this.model.get_carType()];
        this.sb.clear();
        if (!string2.equals("")) {
            this.sb.append(string2).append("/");
        }
        this.sb.append(string).append(".png");
        return this.sb.toString();
    }

    private ImageDrawable loadImageDrawableForCarType(Graphics3D graphics3D, String string, String string2) {
        this.sb.clear();
        this.sb.append(string).append(string2);
        return this.loadImageDrawableForCarType(graphics3D, this.sb.toString());
    }

    private ImageDrawable loadImageDrawableForCarType(Graphics3D graphics3D, String string) {
        String string2 = EnergyFlowConstants.CAR_TYPE_DIR[this.model.get_carType()];
        this.sb.clear();
        if (!string2.equals("")) {
            this.sb.append(string2).append("/");
        }
        this.sb.append(string).append(".png");
        return EnergyFlowUI.createImageDrawableFromSkin0(graphics3D, this.sb.toString(), 4);
    }

    private static String createWheelImagePathColorize(int n, int n2, boolean bl, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        stringBuilder.append("Hy_Wheel").append(EnergyFlowConstants.WHEEL_SUFFIXES[n2]);
        String string = stringBuilder.toString();
        stringBuilder.append("/").append(string).append(n < 10 ? new StringBuffer().append("_0").append(n).toString() : new StringBuffer().append("_").append(n).toString());
        return stringBuilder.toString();
    }

    private static String createBatteryImagePath(int n, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        stringBuilder.append("Hy_Battery").append("/").append("Hy_Battery").append(n < 10 ? new StringBuffer().append("_0").append(n).toString() : new StringBuffer().append("_").append(n).toString());
        return stringBuilder.toString();
    }

    private static int getIndexForStateOfCharge(int n) {
        int n2 = n / 10 + 1;
        return Math.min(Math.max(n2, 1), 10);
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 18: {
                this.energyFlowColorsChanged();
                break;
            }
            case 19: {
                this.energyStateChanged();
                break;
            }
            case 23: {
                this.carTypeChanged();
                break;
            }
        }
    }

    private void energyFlowColorsChanged() {
        this.updateDrawable();
    }

    private void energyStateChanged() {
        this.updateDrawable();
    }

    private void carTypeChanged() {
        this.resetInternalProperties();
    }
}

