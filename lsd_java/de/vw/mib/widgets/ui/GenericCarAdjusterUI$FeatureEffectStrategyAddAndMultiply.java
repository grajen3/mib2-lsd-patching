/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI$FeatureEffectStategy;

final class GenericCarAdjusterUI$FeatureEffectStrategyAddAndMultiply
extends GenericCarAdjusterUI$FeatureEffectStategy {
    private final /* synthetic */ GenericCarAdjusterUI this$0;

    public GenericCarAdjusterUI$FeatureEffectStrategyAddAndMultiply(GenericCarAdjusterUI genericCarAdjusterUI) {
        this.this$0 = genericCarAdjusterUI;
        super(genericCarAdjusterUI);
    }

    @Override
    protected void drawFeaturesAndBackground(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel, float f2) {
        graphics3D.setBlendFactorsSeparate(6, 1, 0, 1);
        this.drawFeatures(graphics3D, genericCarAdjusterModel, f2);
        graphics3D.setBlendFactorsSeparate(1, 1, 0, 1);
        this.drawBackground(graphics3D, genericCarAdjusterModel, f2);
    }

    @Override
    protected void drawFeature(Graphics3D graphics3D, ImageDrawable imageDrawable, Color4b color4b, float f2) {
        super.drawFeature(graphics3D, imageDrawable, color4b, f2);
        imageDrawable.setAlpha(f2);
        imageDrawable.draw();
    }
}

