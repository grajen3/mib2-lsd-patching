/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ColorConversionDrawable;
import de.vw.mib.graphics.drawable.image.ColorGradientDrawable;
import de.vw.mib.graphics.drawable.image.CompositeImageDrawable;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.image.ScaleImageGradientDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.particle.ParticleCloudDrawable;
import de.vw.mib.graphics.drawable.particle.ParticleGridDrawable;
import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.drawable.particle.ParticleSphereDrawable;
import de.vw.mib.graphics.drawable.scene.SceneDrawable;
import de.vw.mib.graphics.drawable.shape.ArcDrawable;
import de.vw.mib.graphics.drawable.shape.CircleGraphDrawable;
import de.vw.mib.graphics.drawable.shape.CircularSectorDrawable;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.drawable.shape.EllipseDrawable;
import de.vw.mib.graphics.drawable.shape.PolyLineDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleGradientDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;

public interface DrawableManager
extends ResourceManager {
    default public DrawablePerformanceMetrics getPerformanceMetrics() {
    }

    default public ArcDrawable createArcDrawable() {
    }

    default public CircleGraphDrawable createCircleGraphDrawable() {
    }

    default public CircularSectorDrawable createCircularSectorDrawable() {
    }

    default public CubicBezierCurveDrawable createCubicBezierCurveDrawable() {
    }

    default public EllipseDrawable createEllipseDrawable() {
    }

    default public PolyLineDrawable createPolyLineDrawable() {
    }

    default public RectangleDrawable createRectangleDrawable() {
    }

    default public ParticleCloudDrawable createParticleCloudDrawable() {
    }

    default public ParticleGridDrawable createParticleGridDrawable() {
    }

    default public ParticleSphereDrawable createParticleSphereDrawable() {
    }

    default public ParticleHeightMapDrawable createParticleHeightMapDrawable() {
    }

    default public void getMaxImageDrawableSize(Dimension dimension) {
    }

    default public ImageDrawable createImageDrawable() {
    }

    default public CompositeImageDrawable createCompositeImageDrawable() {
    }

    default public ScaleImageDrawable createScaleImageDrawable() {
    }

    default public RectangleGradientDrawable createRectangleGradientDrawable() {
    }

    default public ScaleImageGradientDrawable createScaleImageGradientDrawable() {
    }

    default public ColorConversionDrawable createColorConversionDrawable() {
    }

    default public ColorGradientDrawable createColorGradientDrawable() {
    }

    default public TextDrawable createTextDrawable() {
    }

    default public void getMaxOffscreenDrawableSize(Dimension dimension) {
    }

    default public OffscreenDrawable createOffscreenDrawable(int n, int n2, boolean bl) {
    }

    default public SceneDrawable createSceneDrawable() {
    }
}

