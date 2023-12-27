/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.widgets.car.climate.ClimateConfigDataHelper;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.ClimateModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.io.IOException;

public final class Climate2UI
extends AbstractWidgetUI
implements PropertyChangedListener {
    private static final float CONVERT_SCALE_INT2FLOAT;
    private ImageDrawable backgroundDrawable;
    private boolean errMsgAlreadyLogged;
    private ImageDrawable[] exhaustDrawables;

    @Override
    public void deInit() {
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.removePropertyChangedListener(this);
        }
        this.errMsgAlreadyLogged = false;
        Climate2UI.disposeDrawable(this.backgroundDrawable);
        this.backgroundDrawable = null;
        Climate2UI.disposeDrawables(this.exhaustDrawables);
        this.exhaustDrawables = null;
        super.deInit();
    }

    @Override
    public void init() {
        super.init();
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.addPropertyChangedListener(this);
        }
    }

    @Override
    protected void reset() {
        super.reset();
        this.errMsgAlreadyLogged = false;
    }

    private ImageDrawable createBackgroundDrawable(Graphics3D graphics3D, ClimateModel climateModel, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        boolean bl = climateModel.is_rightHandDrive();
        String string = new StringBuffer().append("Interior_").append(bl ? "RHD" : "LHD").append("_0.png").toString();
        ImageDrawable imageDrawable = null;
        try {
            imageDrawable = this.createDrawable(graphics3D, string, true);
        }
        catch (IOException iOException) {
            LOGGER.error(128).append("Widget '").append(climateModel.getQualifiedName()).append("': Unable to load texture image from path '").append(string).append("'.").attachThrowable(iOException).log();
        }
        return imageDrawable;
    }

    private ImageDrawable createDrawable(Graphics3D graphics3D, String string, boolean bl) {
        return Climate2UI.createImageDrawableFromSkin0(graphics3D, string, 1, bl);
    }

    private ImageDrawable[] createExhaustDrawables(Graphics3D graphics3D, ClimateModel climateModel, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        boolean bl = climateModel.is_rightHandDrive();
        String string = new StringBuffer().append("Exhaust").append(bl ? "_RHD_" : "_LHD_").toString();
        ImageDrawable[] imageDrawableArray = new ImageDrawable[genericCarAdjusterConfigData.getImageDefinitionCount()];
        for (int i2 = 0; i2 < imageDrawableArray.length; ++i2) {
            String string2 = string.concat(String.valueOf(genericCarAdjusterConfigData.getImageId(i2))).concat(".png");
            try {
                imageDrawableArray[i2] = this.createDrawable(graphics3D, string2, true);
                continue;
            }
            catch (IOException iOException) {
                LOGGER.warn(128).append("Widget '").append(climateModel.getQualifiedName()).append("': Unable to load texture image from path '").append(string2).append("'.").log();
            }
        }
        return imageDrawableArray;
    }

    private void drawBackground(Graphics3D graphics3D, ClimateModel climateModel, float f2, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        if (this.backgroundDrawable == null) {
            this.backgroundDrawable = this.createBackgroundDrawable(graphics3D, climateModel, genericCarAdjusterConfigData);
        }
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.setAlpha(f2);
            this.backgroundDrawable.setColor(Color4f.WHITE);
            this.backgroundDrawable.draw();
        }
    }

    private void drawExhausts(Graphics3D graphics3D, ClimateModel climateModel, float f2, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        int n;
        if (this.exhaustDrawables == null) {
            this.exhaustDrawables = this.createExhaustDrawables(graphics3D, climateModel, genericCarAdjusterConfigData);
        }
        int n2 = n = climateModel.get_exhaustStates() != null ? climateModel.get_exhaustStates().length : 0;
        if (n > 0) {
            block13: for (int i2 = this.exhaustDrawables.length - 1; i2 >= 0; --i2) {
                if (this.exhaustDrawables[i2] == null) continue;
                int n3 = genericCarAdjusterConfigData.getCorrespondingFeatureIdForImage(i2);
                int n4 = n > n3 ? climateModel.get_exhaustStates()[n3] : 0;
                switch (n4 & 1) {
                    case 1: {
                        Color4b color4b;
                        int n5;
                        int n6 = n4;
                        int n7 = -1;
                        if (((n4 ^= 1) & 0x100) > 0) {
                            if (((n4 ^= 0x100) & 0x200) > 0) {
                                n4 ^= 0x200;
                            }
                            switch (n4) {
                                case 2: {
                                    n7 = 1;
                                    break;
                                }
                                case 4: {
                                    n7 = 5;
                                    break;
                                }
                                case 8: {
                                    n7 = 3;
                                    break;
                                }
                                default: {
                                    LOGGER.warn(128).append("Widget '").append(climateModel.getQualifiedName()).append("': More than the expected exhaust state bits left! ").append("exhaustIndex=").append(n3).append(" exhaustState=").append(n6).append(" exhaustStateLeft=").append(n4).append(" expectedStates=[").append(2).append("|").append(4).append("|").append(8).append("]").log();
                                    break;
                                }
                            }
                        } else {
                            if ((n4 & 0x200) > 0) {
                                n4 ^= 0x200;
                            }
                            switch (n4) {
                                case 2: {
                                    n7 = 0;
                                    break;
                                }
                                case 4: {
                                    n7 = 4;
                                    break;
                                }
                                case 8: {
                                    n7 = 2;
                                    break;
                                }
                                default: {
                                    LOGGER.warn(128).append("Widget '").append(climateModel.getQualifiedName()).append("': More than the expected exhaust state bits left! ").append("exhaustIndex=").append(n3).append(" exhaustState=").append(n6).append(" exhaustStateLeft=").append(n4).append(" expectedStates=[").append(2).append("|").append(4).append("|").append(8).append("]").log();
                                }
                            }
                        }
                        if (n7 <= -1) continue block13;
                        int n8 = n5 = climateModel.get_exhaustColors() != null ? climateModel.get_exhaustColors().length : 0;
                        if (n5 <= 0 || n7 >= n5 || (color4b = climateModel.get_exhaustColors()[n7].getCurrentColor()) == null) continue block13;
                        int n9 = genericCarAdjusterConfigData.getImagePosX(i2);
                        int n10 = genericCarAdjusterConfigData.getImagePosY(i2);
                        float f3 = f2 * AbstractWidgetUI.normalizeAlpha(climateModel.get_exhaustsAlpha());
                        this.exhaustDrawables[i2].setColor(color4b);
                        this.exhaustDrawables[i2].setAlpha(f3);
                        this.exhaustDrawables[i2].draw(n9, n10);
                        continue block13;
                    }
                }
            }
        }
    }

    private void drawInterior(Graphics3D graphics3D, ClimateModel climateModel, Rectangle rectangle, Rectangle rectangle2, float f2, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        boolean bl;
        float f3;
        int n;
        int n2;
        int[] nArray = ClimateConfigDataHelper.determineBackgroundIndicesByAspect(climateModel.get_aspect(), genericCarAdjusterConfigData);
        int n3 = nArray.length > 0 ? nArray[0] : -1;
        boolean bl2 = n3 >= 0;
        float f4 = bl2 ? (float)genericCarAdjusterConfigData.getBackgroundPosX(n3) : 0.0f;
        float f5 = climateModel.getInteriorPositionY();
        if (this.backgroundDrawable == null) {
            this.backgroundDrawable = this.createBackgroundDrawable(graphics3D, climateModel, genericCarAdjusterConfigData);
        }
        if ((n2 = climateModel.get_width()) != (n = this.backgroundDrawable.getImage().getWidth())) {
            int n4 = (int)((float)(n2 - n) * 63);
            f4 += (float)n4;
        }
        boolean bl3 = (f3 = (float)climateModel.getInteriorScale() * 181871420) > 1.0f;
        boolean bl4 = bl = f3 < 1.0f;
        if (bl3 ^ bl) {
            f4 += (float)n * Math.abs(1.0f - f3) * 63 * (float)(bl3 ? -1 : 1);
        }
        graphics3D.pushMatrix(0);
        if (f4 != 0.0f || f5 != 0.0f) {
            graphics3D.translateMatrix(0, f4, f5, 0.0f);
        }
        if (bl3 ^ bl) {
            graphics3D.scaleMatrix(0, f3, f3, 1.0f);
        }
        if (bl2) {
            this.drawBackground(graphics3D, climateModel, f2, genericCarAdjusterConfigData);
        } else {
            LOGGER.warn(128).append("Widget '").append(climateModel.getQualifiedName()).append("': Unable to draw climate interior background, because of missing background definition in configuration for aspect! aspect=").append(climateModel.get_aspect()).log();
        }
        this.drawExhausts(graphics3D, climateModel, f2, genericCarAdjusterConfigData);
        graphics3D.popMatrix(0);
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ClimateModel climateModel = (ClimateModel)widgetModel;
        GenericCarAdjusterConfigData genericCarAdjusterConfigData = (GenericCarAdjusterConfigData)climateModel.getConfigData();
        if (genericCarAdjusterConfigData != null && genericCarAdjusterConfigData.isDeserialized()) {
            this.drawInterior(graphics3D, climateModel, rectangle, rectangle2, f2, genericCarAdjusterConfigData);
            if (this.errMsgAlreadyLogged) {
                this.errMsgAlreadyLogged = false;
            }
        } else {
            if (IS_DEVELOPMENT_BUILD) {
                super.paintUnavailable(graphics3D, widgetModel, "Missing/unexpected configuration file");
            }
            if (!this.errMsgAlreadyLogged) {
                LOGGER.error(128).append("Widget '").append(climateModel.getQualifiedName()).append("': Unable to paint widget, because of the missing/unexpected configuration file.").log();
                this.errMsgAlreadyLogged = true;
            }
        }
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 15: {
                Climate2UI.disposeDrawable(this.backgroundDrawable);
                this.backgroundDrawable = null;
                break;
            }
            case 26: {
                Climate2UI.disposeDrawable(this.backgroundDrawable);
                this.backgroundDrawable = null;
                break;
            }
        }
    }
}

