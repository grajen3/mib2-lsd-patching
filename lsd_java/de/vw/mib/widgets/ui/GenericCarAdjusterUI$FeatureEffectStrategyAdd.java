/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI$FeatureEffectStategy;

final class GenericCarAdjusterUI$FeatureEffectStrategyAdd
extends GenericCarAdjusterUI$FeatureEffectStategy {
    private final /* synthetic */ GenericCarAdjusterUI this$0;

    public GenericCarAdjusterUI$FeatureEffectStrategyAdd(GenericCarAdjusterUI genericCarAdjusterUI) {
        this.this$0 = genericCarAdjusterUI;
        super(genericCarAdjusterUI);
    }

    @Override
    protected void drawFeaturesAndBackground(Graphics3D graphics3D, GenericCarAdjusterModel genericCarAdjusterModel, float f2) {
        this.drawBackground(graphics3D, genericCarAdjusterModel, f2);
        graphics3D.setBlendFactorsSeparate(6, 1, 1, 1);
        this.drawFeatures(graphics3D, genericCarAdjusterModel, f2);
    }
}

