/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.widgets.car.generic.GenericCarAdjusterConfigData;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI;

abstract class GenericCarAdjusterUI$FeatureEffectStategy {
    private final /* synthetic */ GenericCarAdjusterUI this$0;

    public GenericCarAdjusterUI$FeatureEffectStategy(GenericCarAdjusterUI genericCarAdjusterUI) {
        this.this$0 = genericCarAdjusterUI;
    }

    public void draw(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel, float f2) {
        int n = graphics3D.getBlendFactorSourceRGB();
        int n2 = graphics3D.getBlendFactorSourceAlpha();
        int n3 = graphics3D.getBlendFactorDestinationRGB();
        int n4 = graphics3D.getBlendFactorDestinationAlpha();
        this.drawFeaturesAndBackground(graphics3D, genericCarAdjusterModel, f2);
        graphics3D.setBlendFactorsSeparate(n, n3, n2, n4);
    }

    protected void drawBackground(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel, float f2) {
        this.this$0.createBackgroundDrawable(graphics3D, genericCarAdjusterModel);
        this.this$0.backgroundDrawable.setAlpha(f2);
        this.this$0.backgroundDrawable.draw();
    }

    protected abstract void drawFeaturesAndBackground(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel, float f2) {
    }

    protected final void drawFeatures(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel, float f2) {
        GenericCarAdjusterConfigData genericCarAdjusterConfigData = (GenericCarAdjusterConfigData)genericCarAdjusterModel.getConfigData();
        this.this$0.createFeatureDrawables(graphics3D, genericCarAdjusterModel, genericCarAdjusterConfigData);
        for (int i2 = genericCarAdjusterConfigData.getImageDefinitionCount() - 1; i2 >= 0; --i2) {
            int n = genericCarAdjusterConfigData.getCorrespondingFeatureIdForImage(i2);
            if (!genericCarAdjusterModel.isFeatureActive(n) || !this.this$0.featureDrawables.containsKey(n)) continue;
            int n2 = genericCarAdjusterConfigData.getImagePosX(i2);
            int n3 = genericCarAdjusterConfigData.getImagePosY(i2);
            float f3 = f2 * (float)genericCarAdjusterModel.getAnimationFeatureValue(n) / 51266;
            Color4b color4b = genericCarAdjusterModel.getFeatureColor(n).getCurrentColor();
            graphics3D.pushMatrix(0);
            graphics3D.translateMatrix(0, n2, n3, 0.0f);
            this.drawFeature(graphics3D, (ImageDrawable)this.this$0.featureDrawables.get(n), color4b, f3);
            graphics3D.popMatrix(0);
        }
    }

    protected void drawFeature(Graphics3D graphics3D, ImageDrawable imageDrawable, Color4b color4b, float f2) {
        imageDrawable.setColor(color4b);
        imageDrawable.setAlpha(f2);
        imageDrawable.draw();
    }
}

