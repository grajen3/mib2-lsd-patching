/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI$FeatureEffectStategy;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI$FeatureEffectStrategyAdd;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI$FeatureEffectStrategyAddAndMultiply;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI$FeatureEffectStrategyNone;
import java.io.IOException;

public class GenericCarAdjusterUI
extends AbstractWidgetUI
implements PropertyChangedListener {
    private boolean errMsgAlreadyLogged = false;
    private GenericCarAdjusterUI$FeatureEffectStategy effectStrategy;
    private StringBuilder sb;
    protected ImageDrawable backgroundDrawable;
    protected IntObjectMap featureDrawables;

    @Override
    public void init() {
        super.init();
        this.sb = new StringBuilder();
        this.errMsgAlreadyLogged = false;
        this.registerAsPropertyChangedListener();
    }

    @Override
    public void deInit() {
        this.effectStrategy = null;
        this.sb = null;
        this.unregisterAsPropertyChangedListener();
        this.disposeDrawables();
        super.deInit();
    }

    private void registerAsPropertyChangedListener() {
        GenericCarAdjusterModel genericCarAdjusterModel = (GenericCarAdjusterModel)this.getWidget();
        if (genericCarAdjusterModel != null) {
            genericCarAdjusterModel.addPropertyChangedListener(this);
        }
    }

    private void unregisterAsPropertyChangedListener() {
        GenericCarAdjusterModel genericCarAdjusterModel = (GenericCarAdjusterModel)this.getWidget();
        if (genericCarAdjusterModel != null) {
            genericCarAdjusterModel.removePropertyChangedListener(this);
        }
    }

    private void featureEffectTypeChanged() {
        this.effectStrategy = null;
    }

    private void configSubTypeChanged() {
        this.disposeDrawables();
    }

    private void disposeDrawables() {
        GenericCarAdjusterUI.disposeDrawable(this.backgroundDrawable);
        this.backgroundDrawable = null;
        if (this.featureDrawables != null) {
            if (!this.featureDrawables.isEmpty()) {
                GenericCarAdjusterUI.disposeDrawables((Drawable[])this.featureDrawables.valuesToArray(new Drawable[this.featureDrawables.size()]));
            }
            this.featureDrawables = null;
        }
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        GenericCarAdjusterModel genericCarAdjusterModel = (GenericCarAdjusterModel)widgetModel;
        GenericCarAdjusterConfigData genericCarAdjusterConfigData = (GenericCarAdjusterConfigData)genericCarAdjusterModel.getConfigData();
        if (genericCarAdjusterConfigData != null && genericCarAdjusterConfigData.isDeserialized()) {
            this.createFeatureEffectStrategy(genericCarAdjusterModel);
            try {
                this.effectStrategy.draw(graphics3D, genericCarAdjusterModel, f2);
            }
            catch (IOException iOException) {
                this.logError(graphics3D, widgetModel, new StringBuffer().append("Missing image: ").append(iOException.getLocalizedMessage()).toString());
            }
        } else {
            this.logError(graphics3D, widgetModel, "Missing/unexpected configuration file");
        }
    }

    private void logError(Graphics3D graphics3D, WidgetModel widgetModel, String string) {
        if (IS_DEVELOPMENT_BUILD) {
            super.paintUnavailable(graphics3D, widgetModel, string);
        }
        if (!this.errMsgAlreadyLogged) {
            LOGGER.error(128).append("Widget '").append(widgetModel.getQualifiedName()).append("' - Unable to paint widget, because of: ").append(string).log();
            this.errMsgAlreadyLogged = true;
        }
    }

    private void createFeatureEffectStrategy(GenericCarAdjusterModel genericCarAdjusterModel) {
        if (this.effectStrategy == null) {
            switch (genericCarAdjusterModel.get_featureEffectType()) {
                case 1: {
                    this.effectStrategy = new GenericCarAdjusterUI$FeatureEffectStrategyAdd(this);
                    break;
                }
                case 2: {
                    this.effectStrategy = new GenericCarAdjusterUI$FeatureEffectStrategyAddAndMultiply(this);
                    break;
                }
                default: {
                    this.effectStrategy = new GenericCarAdjusterUI$FeatureEffectStrategyNone(this);
                }
            }
        }
    }

    protected void createFeatureDrawables(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel, GenericCarAdjusterConfigData genericCarAdjusterConfigData) {
        if (this.featureDrawables == null) {
            int n = genericCarAdjusterConfigData.getImageDefinitionCount();
            this.featureDrawables = new IntObjectOptHashMap(n);
            for (int i2 = n - 1; i2 >= 0; --i2) {
                int n2 = genericCarAdjusterConfigData.getImageId(i2);
                int n3 = genericCarAdjusterConfigData.getCorrespondingFeatureIdForImage(i2);
                this.sb.clear();
                this.sb.append(genericCarAdjusterModel.get_configIdentifier()).append("/Feature_").append(genericCarAdjusterModel.getConfigSubTypeName()).append("_").append(n2).append(".png");
                this.featureDrawables.put(n3, GenericCarAdjusterUI.createImageDrawableFromSkin0(graphics3D, this.sb.toString(), 5));
            }
        }
    }

    protected void createBackgroundDrawable(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel) {
        if (this.backgroundDrawable == null) {
            this.sb.clear();
            this.sb.append(genericCarAdjusterModel.get_configIdentifier()).append("/Interior_").append(genericCarAdjusterModel.getConfigSubTypeName()).append(".png");
            this.backgroundDrawable = GenericCarAdjusterUI.createImageDrawableFromSkin0(graphics3D, this.sb.toString(), 5);
        }
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (n == 17) {
            this.configSubTypeChanged();
        } else if (n == 20) {
            this.featureEffectTypeChanged();
        }
    }
}

