/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.car.status.CarStatusConfigData;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.CarStatusModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.io.IOException;

public final class CarStatusUI
extends AbstractWidgetUI
implements PropertyChangedListener {
    private ImageDrawable carDrawable;
    private boolean errMsgAlreadyLogged;
    private ImageDrawable[] featureDrawables;
    private StringBuilder fileNameBuilder;

    @Override
    public void init() {
        super.init();
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.addPropertyChangedListener(this);
        }
    }

    @Override
    public void deInit() {
        CarStatusUI.disposeDrawable(this.carDrawable);
        this.carDrawable = null;
        CarStatusUI.disposeDrawables(this.featureDrawables);
        this.featureDrawables = null;
        this.errMsgAlreadyLogged = false;
        this.fileNameBuilder = null;
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.removePropertyChangedListener(this);
        }
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        this.errMsgAlreadyLogged = false;
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        CarStatusModel carStatusModel = (CarStatusModel)widgetModel;
        CarStatusConfigData carStatusConfigData = (CarStatusConfigData)carStatusModel.getConfigData();
        if (carStatusConfigData != null && carStatusConfigData.isDeserialized()) {
            if (this.areAllFeaturesNormal(carStatusModel)) {
                this.drawCar(graphics3D, carStatusModel, carStatusConfigData, !carStatusModel.is_showCarTransparent(), f2);
            } else {
                this.drawCar(graphics3D, carStatusModel, carStatusConfigData, false, f2);
                this.drawFeatures(graphics3D, carStatusModel, carStatusConfigData, f2);
            }
            if (this.errMsgAlreadyLogged) {
                this.errMsgAlreadyLogged = false;
            }
        } else {
            if (IS_DEVELOPMENT_BUILD) {
                super.paintUnavailable(graphics3D, widgetModel, "Missing/unexpected configuration file");
            }
            if (!this.errMsgAlreadyLogged) {
                LogMessage logMessage = LOGGER.error(128).append("Widget '").append(carStatusModel.getQualifiedName()).append("': Unable to paint widget, because of the missing/unexpected configuration file!");
                if (carStatusConfigData != null) {
                    logMessage.append(" configFileName='").append(carStatusConfigData.getConfigFileName()).append("'");
                }
                logMessage.log();
                this.errMsgAlreadyLogged = true;
            }
        }
    }

    private boolean areAllFeaturesNormal(CarStatusModel carStatusModel) {
        int[] nArray = carStatusModel.get_featureStates();
        boolean bl = true;
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] == 0) continue;
                bl = false;
                break;
            }
        }
        return bl;
    }

    private void drawCar(Graphics3D graphics3D, CarStatusModel carStatusModel, CarStatusConfigData carStatusConfigData, boolean bl, float f2) {
        if (this.carDrawable == null) {
            this.carDrawable = this.createCarDrawable(graphics3D, carStatusModel, bl);
        }
        if (this.carDrawable != null) {
            int n = carStatusConfigData.getCarXPos(bl);
            int n2 = carStatusConfigData.getCarYPos(bl);
            this.carDrawable.setAlpha(f2);
            this.carDrawable.draw(n, n2);
        }
    }

    private void drawFeatures(Graphics3D graphics3D, CarStatusModel carStatusModel, CarStatusConfigData carStatusConfigData, float f2) {
        if (this.featureDrawables == null) {
            this.featureDrawables = this.createFeatureDrawables(graphics3D, carStatusModel, carStatusConfigData);
        }
        int[] nArray = carStatusModel.get_featureStates();
        Color[] colorArray = carStatusModel.get_featureStateColors();
        if (nArray != null && colorArray != null && this.featureDrawables != null) {
            for (int i2 = 0; i2 < this.featureDrawables.length; ++i2) {
                ImageDrawable imageDrawable = this.featureDrawables[i2];
                if (imageDrawable == null) continue;
                Point point = carStatusConfigData.getFeaturePos(i2, carStatusModel.is_rightHandDrive());
                if (i2 >= nArray.length || nArray[i2] >= colorArray.length) continue;
                Color4b color4b = colorArray[nArray[i2]].getCurrentColor();
                imageDrawable.setColor(color4b);
                imageDrawable.setAlpha(f2);
                imageDrawable.draw(point.x, point.y);
            }
        }
    }

    private ImageDrawable createCarDrawable(Graphics3D graphics3D, CarStatusModel carStatusModel, boolean bl) {
        ImageDrawable imageDrawable = null;
        String string = new StringBuffer().append(bl ? "car" : "car_transp").append(".png").toString();
        try {
            imageDrawable = this.createDrawable(graphics3D, string);
        }
        catch (IOException iOException) {
            LOGGER.error(128).append("Widget '").append(carStatusModel.getQualifiedName()).append("': Unable to load car image! filename='").append(string).append("'").attachThrowable(iOException).log();
        }
        return imageDrawable;
    }

    private ImageDrawable createDrawable(Graphics3D graphics3D, String string) {
        return CarStatusUI.createImageDrawableFromSkin0(graphics3D, string, 2);
    }

    private ImageDrawable[] createFeatureDrawables(Graphics3D graphics3D, CarStatusModel carStatusModel, CarStatusConfigData carStatusConfigData) {
        int[] nArray = carStatusModel.get_featureStates();
        int n = Math.min(carStatusConfigData.getFeatureCount(), nArray != null ? nArray.length : 0);
        boolean bl = carStatusModel.is_rightHandDrive();
        ImageDrawable[] imageDrawableArray = new ImageDrawable[n];
        for (int i2 = 0; i2 < n; ++i2) {
            ImageDrawable imageDrawable;
            if (nArray == null || nArray[i2] == -1) continue;
            try {
                imageDrawable = this.createDrawable(graphics3D, this.createFeatureFileName(i2, bl));
            }
            catch (IOException iOException) {
                if (bl) {
                    try {
                        imageDrawable = this.createDrawable(graphics3D, this.createFeatureFileName(i2, false));
                    }
                    catch (IOException iOException2) {
                        LOGGER.warn(128).append("Widget '").append(carStatusModel.getQualifiedName()).append("': Unable to load feature image!' featureId=").append(carStatusConfigData.getFeatureId(i2)).attachThrowable(iOException2).log();
                        continue;
                    }
                }
                LOGGER.warn(128).append("Widget '").append(carStatusModel.getQualifiedName()).append("': Unable to load feature image!' featureId=").append(carStatusConfigData.getFeatureId(i2)).attachThrowable(iOException).log();
                continue;
            }
            imageDrawableArray[i2] = imageDrawable;
        }
        return imageDrawableArray;
    }

    private String createFeatureFileName(int n, boolean bl) {
        if (this.fileNameBuilder == null) {
            this.fileNameBuilder = new StringBuilder(64);
        } else {
            this.fileNameBuilder.clear();
        }
        this.fileNameBuilder.append("feature_").append(n);
        if (bl) {
            this.fileNameBuilder.append("_RHD");
        }
        this.fileNameBuilder.append(".png");
        return this.fileNameBuilder.toString();
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        boolean bl = false;
        boolean bl2 = false;
        switch (n) {
            case 16: 
            case 18: {
                bl2 = true;
                bl = true;
                break;
            }
            case 17: {
                bl = true;
                break;
            }
        }
        if (bl && this.carDrawable != null) {
            CarStatusUI.disposeDrawable(this.carDrawable);
            this.carDrawable = null;
        }
        if (bl2 && this.featureDrawables != null) {
            CarStatusUI.disposeDrawables(this.featureDrawables);
            this.featureDrawables = null;
        }
    }
}

