/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.car.climate.ClimateConfigData;
import de.vw.mib.widgets.car.climate.ClimateConstants;
import de.vw.mib.widgets.models.ClimateModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.io.IOException;

public final class ClimateUI
extends AbstractWidgetUI {
    private static final int UNIT;
    private boolean errMsgAlreadyLogged = false;
    private ImageDrawable backgroundImageDrawable;
    private ImageDrawable[] exhaustImageDrawables;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        this.errMsgAlreadyLogged = false;
        if (this.backgroundImageDrawable != null) {
            this.backgroundImageDrawable.dispose();
            this.backgroundImageDrawable = null;
        }
        if (this.exhaustImageDrawables != null) {
            for (int i2 = 0; i2 < this.exhaustImageDrawables.length; ++i2) {
                ImageDrawable imageDrawable = this.exhaustImageDrawables[i2];
                if (imageDrawable != null) {
                    imageDrawable.dispose();
                }
                this.exhaustImageDrawables[i2] = null;
            }
        }
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ClimateModel climateModel = (ClimateModel)widgetModel;
        ClimateConfigData climateConfigData = (ClimateConfigData)climateModel.getConfigData();
        if (climateConfigData != null && climateConfigData.isDeserialized()) {
            this.drawBackground(graphics3D, climateModel, climateConfigData, f2);
            float f3 = f2 * AbstractWidgetUI.normalizeAlpha(climateModel.get_exhaustsAlpha());
            this.drawExhausts(graphics3D, climateModel, climateConfigData, f3);
            if (this.errMsgAlreadyLogged) {
                this.errMsgAlreadyLogged = false;
            }
        } else {
            if (IS_DEVELOPMENT_BUILD) {
                super.paintUnavailable(graphics3D, widgetModel, "Missing/unexpected configuration file");
            }
            if (!this.errMsgAlreadyLogged) {
                LOGGER.error(128).append("Widget '").append(climateModel.getQualifiedName()).append("': Unable to paint widget, , because of the missing/unexpected configuration file.'").log();
                this.errMsgAlreadyLogged = true;
            }
        }
    }

    private void drawBackground(Graphics3D graphics3D, ClimateModel climateModel, ClimateConfigData climateConfigData, float f2) {
        String string = null;
        try {
            string = climateModel.is_rightHandDrive() ? "climate_rhd_bg" : "climate_bg";
            string = new StringBuffer().append(string).append(".png").toString();
            short[] sArray = climateConfigData.getBackgroundData();
            if (this.backgroundImageDrawable == null) {
                this.backgroundImageDrawable = ClimateUI.createImageDrawableFromSkin0(graphics3D, string, 1, true);
            }
            this.backgroundImageDrawable.setAlpha(f2);
            this.backgroundImageDrawable.draw(sArray[0], sArray[1]);
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(128);
            logMessage.append("Widget '").append(climateModel.getQualifiedName()).append("': Unable to load texture image from path '").append(string).append("'.").append(iOException).log();
        }
    }

    private void drawExhausts(Graphics3D graphics3D, ClimateModel climateModel, ClimateConfigData climateConfigData, float f2) {
        float f3;
        Color4b color4b = climateModel.get_blendColorCold().getCurrentColor();
        Color4b color4b2 = climateModel.get_blendColorWarm().getCurrentColor();
        float f4 = f3 = climateModel.is_automaticAirflow() ? f2 * AbstractWidgetUI.normalizeAlpha(climateModel.get_blendColorAutomatic().getCurrentColor().getAlpha()) : f2;
        if (this.exhaustImageDrawables == null) {
            this.exhaustImageDrawables = new ImageDrawable[ClimateConstants.FEATURE_DRAWING_ORDER.length];
        }
        for (int i2 = ClimateConstants.FEATURE_DRAWING_ORDER.length - 1; i2 >= 0; --i2) {
            String string = new StringBuffer().append(ClimateConstants.FEATURE_NAMES[ClimateConstants.FEATURE_DRAWING_ORDER[i2]]).append(".png").toString();
            if (i2 >= climateModel.get_exhaustsActive().length || !climateModel.get_exhaustsActive()[ClimateConstants.FEATURE_DRAWING_ORDER[i2]] && !climateModel.is_automaticAirflow()) continue;
            try {
                if (this.exhaustImageDrawables[i2] == null) {
                    this.exhaustImageDrawables[i2] = ClimateUI.createImageDrawableFromSkin0(graphics3D, string, 1, true);
                }
                this.exhaustImageDrawables[i2].setColor(climateModel.get_exhaustsCold()[ClimateConstants.FEATURE_DRAWING_ORDER[i2]] ? color4b : color4b2);
                this.exhaustImageDrawables[i2].setAlpha(f3);
                short[] sArray = climateConfigData.getFeatureData(ClimateConstants.FEATURE_DRAWING_ORDER[i2]);
                this.exhaustImageDrawables[i2].draw(sArray[1], sArray[2]);
                continue;
            }
            catch (IOException iOException) {
                LOGGER.error(128).append("Widget '").append(climateModel.getQualifiedName()).append("': Unable to load exhaust image from path '").append(string).append("'.").append(iOException).log();
            }
        }
    }
}

