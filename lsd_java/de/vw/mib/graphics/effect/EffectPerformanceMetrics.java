/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class EffectPerformanceMetrics
implements PerformanceMetrics {
    public int allocatedDummyEffects;
    public int allocatedCheckerboardEffects;
    public int allocatedDepthVisualizationEffects;
    public int allocatedNormalVisualizationEffects;
    public int allocatedDemoEffects;
    public int allocatedColorEffects;
    public int allocatedImageEffects;
    public int allocatedImageTransformationEffects;
    public int allocatedImageCompositionEffects;
    public int allocatedTextEffects;
    public int allocatedColorConversionEffects;
    public int allocatedColorGradientEffects;
    public int allocatedRadialGradientEffects;
    public int allocatedWeightedGradientEffects;
    public int allocatedConvolutionFilterEffects;
    public int allocatedPhongLightingEffects;
    public int allocatedParticleEffects;
    public int allocatedBlurredParticleEffects;
    public int allocatedBlurredParticleHeightMapEffects;
    public int allocatedBokehDepthOfFieldBlurFilterEffects;
    public int effectBinds;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[allocatedDummyEffects=").append(this.allocatedDummyEffects);
        stringBuilder.append(",allocatedCheckerboardEffects=").append(this.allocatedCheckerboardEffects);
        stringBuilder.append(",allocatedDepthVisualizationEffects=").append(this.allocatedDepthVisualizationEffects);
        stringBuilder.append(",allocatedNormalVisualizationEffects=").append(this.allocatedNormalVisualizationEffects);
        stringBuilder.append(",allocatedDemoEffects=").append(this.allocatedDemoEffects);
        stringBuilder.append(",allocatedColorEffects=").append(this.allocatedColorEffects);
        stringBuilder.append(",allocatedImageEffects=").append(this.allocatedImageEffects);
        stringBuilder.append(",allocatedImageTransformationEffects=").append(this.allocatedImageTransformationEffects);
        stringBuilder.append(",allocatedImageCompositionEffects=").append(this.allocatedImageCompositionEffects);
        stringBuilder.append(",allocatedTextEffects=").append(this.allocatedTextEffects);
        stringBuilder.append(",allocatedColorConversionEffects=").append(this.allocatedColorConversionEffects);
        stringBuilder.append(",allocatedColorGradientEffects=").append(this.allocatedColorGradientEffects);
        stringBuilder.append(",allocatedRadialGradientEffects=").append(this.allocatedRadialGradientEffects);
        stringBuilder.append(",allocatedWeightedGradientEffects=").append(this.allocatedWeightedGradientEffects);
        stringBuilder.append(",allocatedConvolutionFilterEffects=").append(this.allocatedConvolutionFilterEffects);
        stringBuilder.append(",allocatedPhongLightingEffects=").append(this.allocatedPhongLightingEffects);
        stringBuilder.append(",allocatedParticleEffects=").append(this.allocatedParticleEffects);
        stringBuilder.append(",allocatedBlurredParticleEffects=").append(this.allocatedBlurredParticleEffects);
        stringBuilder.append(",allocatedBlurredParticleHeightMapEffects=").append(this.allocatedBlurredParticleHeightMapEffects);
        stringBuilder.append(",allocatedBokehDepthOfFieldBlurFilterEffects=").append(this.allocatedBokehDepthOfFieldBlurFilterEffects);
        stringBuilder.append(",effectBinds=").append(this.effectBinds);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.effectBinds = 0;
    }
}

