/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.drawable.DrawableManager;
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
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.drawable.renderer.image.ColorConversionDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ColorGradientDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.CompositeImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ScaleImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ScaleImageGradientDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.offscreen.OffscreenDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.particle.LegacyParticleHeightMapDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.particle.OptimizedParticleHeightMapDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.particle.ParticleCloudDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.particle.ParticleHeightMapDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.scene.SceneDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.ArcDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CircleGraphDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CircularSectorDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CurveDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.EllipseDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.LineDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.RectangleDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.RectangleGradientDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.text.TextDrawableRenderer;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.graphics.texture.TextureFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public final class DrawableRendererManager
extends AbstractResource
implements DrawableManager,
GraphicsListener {
    private final GraphicsState state;
    private final DrawablePerformanceMetrics performanceMetrics;
    private final Dimension maxImageDrawableSize;
    private final Dimension maxOffscreenDrawableSize;
    private final TextureAtlas imageTextureAtlas;
    private final TextureAtlas textTextureAtlas;
    private ArcDrawableRenderer arcRenderer;
    private CircleGraphDrawableRenderer circleGraphRenderer;
    private CircularSectorDrawableRenderer circularSectorRenderer;
    private CurveDrawableRenderer curveRenderer;
    private EllipseDrawableRenderer ellipseRenderer;
    private LineDrawableRenderer lineRenderer;
    private RectangleDrawableRenderer rectangleRenderer;
    private ParticleCloudDrawableRenderer particleCloudRenderer;
    private ParticleHeightMapDrawableRenderer particleRenderer;
    private ImageDrawableRenderer imageRenderer;
    private CompositeImageDrawableRenderer compositeImageRenderer;
    private ScaleImageDrawableRenderer scaleImageRenderer;
    private RectangleGradientDrawableRenderer gradientRenderer;
    private ScaleImageGradientDrawableRenderer scaleImageGradientRenderer;
    private ColorConversionDrawableRenderer colorConversionRenderer;
    private ColorGradientDrawableRenderer colorGradientRenderer;
    private TextDrawableRenderer textRenderer;
    private OffscreenDrawableRenderer offscreenRenderer;
    private SceneDrawableRenderer sceneRenderer;

    public DrawableRendererManager(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState) {
        super(graphics3D, logger);
        TextureFormat[] textureFormatArray;
        this.state = graphicsState;
        this.performanceMetrics = new DrawablePerformanceMetrics();
        TextureFormat[] textureFormatArray2 = this.getImageDrawableTextureAtlasPageSizes();
        this.maxImageDrawableSize = DrawableRendererManager.getMaximumTextureSize(textureFormatArray2);
        this.imageTextureAtlas = this.createTextureAtlas(textureFormatArray2);
        this.arcRenderer = new ArcDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.circleGraphRenderer = new CircleGraphDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.circularSectorRenderer = new CircularSectorDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.curveRenderer = new CurveDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.ellipseRenderer = new EllipseDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics);
        this.lineRenderer = new LineDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics);
        this.rectangleRenderer = new RectangleDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics);
        this.particleRenderer = graphics3D.getTextureManager().getMaxVertexTextureUnits() >= 4 ? new OptimizedParticleHeightMapDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas) : new LegacyParticleHeightMapDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.particleCloudRenderer = new ParticleCloudDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics);
        this.imageRenderer = new ImageDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.compositeImageRenderer = new CompositeImageDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.scaleImageRenderer = new ScaleImageDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.gradientRenderer = new RectangleGradientDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics);
        this.scaleImageGradientRenderer = new ScaleImageGradientDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.colorConversionRenderer = new ColorConversionDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        this.colorGradientRenderer = new ColorGradientDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.imageTextureAtlas);
        TextureFormat[] textureFormatArray3 = this.getTextDrawableTextureAtlasPageSizes();
        this.textTextureAtlas = this.createTextureAtlas(textureFormatArray3);
        this.textRenderer = new TextDrawableRenderer(graphics3D, logger, graphicsState, this.performanceMetrics, this.textTextureAtlas);
        if (!graphics3D.areFrameBuffersSupported()) {
            throw new UnsupportedOperationException("Offscreen rendering not supported");
        }
        TextureFormat[] textureFormatArray4 = textureFormatArray = this.getOffscreenDrawableTextureAtlasPageSizes();
        this.maxOffscreenDrawableSize = DrawableRendererManager.getMaximumTextureSize(textureFormatArray4);
        this.offscreenRenderer = new OffscreenDrawableRenderer(graphics3D, this.getLogger(), this.getState(), this.getPerformanceMetrics(), textureFormatArray4);
        this.sceneRenderer = new SceneDrawableRenderer(this.getGraphics3D(), this.getLogger(), this.getState(), this.getPerformanceMetrics());
        graphics3D.addListener(this);
    }

    @Override
    public void dispose() {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.removeListener(this);
        this.arcRenderer.dispose();
        this.circleGraphRenderer.dispose();
        this.circularSectorRenderer.dispose();
        this.curveRenderer.dispose();
        this.ellipseRenderer.dispose();
        this.lineRenderer.dispose();
        this.rectangleRenderer.dispose();
        this.particleRenderer.dispose();
        this.particleCloudRenderer.dispose();
        this.imageRenderer.dispose();
        this.scaleImageRenderer.dispose();
        this.gradientRenderer.dispose();
        this.scaleImageGradientRenderer.dispose();
        this.textRenderer.dispose();
        this.colorConversionRenderer.dispose();
        this.colorGradientRenderer.dispose();
        this.offscreenRenderer.dispose();
        this.sceneRenderer.dispose();
        this.imageTextureAtlas.dispose();
        this.textTextureAtlas.dispose();
        super.dispose();
    }

    private TextureFormat[] getImageDrawableTextureAtlasPageSizes() {
        Graphics3D graphics3D = this.getGraphics3D();
        Surface surface = graphics3D.getSurface();
        int n = graphics3D.getTextureManager().getMaxTextureSize();
        int n2 = Math.min(Util.nextPowerOfTwo(surface.getWidth()), n);
        int n3 = Math.min(Util.nextPowerOfTwo(surface.getHeight()), n);
        int n4 = Math.max(n2, n3);
        return new TextureFormat[]{new TextureFormat(4356, n2, n3), new TextureFormat(4356, n2, n3), new TextureFormat(4356, n2, n3), new TextureFormat(4356, n2, n3), new TextureFormat(4356, n4, n4), new TextureFormat(4356, n4, n4), new TextureFormat(4096, n2, n3), new TextureFormat(4096, n2, n3), new TextureFormat(4096, n2, n3), new TextureFormat(4096, n2, n3), new TextureFormat(4096, n4, n4), new TextureFormat(4096, n4, n4)};
    }

    private TextureFormat[] getTextDrawableTextureAtlasPageSizes() {
        Graphics3D graphics3D = this.getGraphics3D();
        Surface surface = graphics3D.getSurface();
        int n = graphics3D.getTextureManager().getMaxTextureSize();
        int n2 = Math.min(Util.nextPowerOfTwo(surface.getWidth()), n);
        int n3 = Math.min(Util.nextPowerOfTwo(surface.getHeight()), n);
        int n4 = Math.max(n2, n3);
        return new TextureFormat[]{new TextureFormat(4096, n2, n3)};
    }

    private TextureFormat[] getOffscreenDrawableTextureAtlasPageSizes() {
        Graphics3D graphics3D = this.getGraphics3D();
        Surface surface = graphics3D.getSurface();
        int n = graphics3D.getTextureManager().getMaxTextureSize();
        int n2 = Math.min(Util.nextPowerOfTwo(surface.getWidth()), n);
        int n3 = Math.min(Util.nextPowerOfTwo(surface.getHeight()), n);
        int n4 = Math.max(n2, n3);
        return new TextureFormat[]{new TextureFormat(4356, n2, n3), new TextureFormat(4356, n2, n3), new TextureFormat(4356, n2, n3), new TextureFormat(4356, n2, n3)};
    }

    private static Dimension getMaximumTextureSize(TextureFormat[] textureFormatArray) {
        Dimension dimension = new Dimension();
        for (int i2 = 0; i2 < textureFormatArray.length; ++i2) {
            TextureFormat textureFormat = textureFormatArray[i2];
            if (textureFormat.width < dimension.width || textureFormat.height < dimension.height) continue;
            dimension.setSize(textureFormat.width, textureFormat.height);
        }
        return dimension;
    }

    public TextureAtlas getImageTextureAtlas() {
        return this.imageTextureAtlas;
    }

    public TextureAtlas getTextTextureAtlas() {
        return this.textTextureAtlas;
    }

    private TextureAtlas createTextureAtlas(TextureFormat[] textureFormatArray) {
        Logger logger = this.getLogger();
        TextureAtlas textureAtlas = new TextureAtlas(this.getGraphics3D(), logger, textureFormatArray);
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("DrawableRendererManager: Created texture atlas ");
            for (int i2 = 0; i2 < textureFormatArray.length; ++i2) {
                logMessage.append(textureFormatArray[i2]);
                if (i2 >= textureFormatArray.length - 1) continue;
                logMessage.append("],[");
            }
            logMessage.log();
        }
        return textureAtlas;
    }

    public GraphicsState getState() {
        return this.state;
    }

    @Override
    public DrawablePerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public ArcDrawable createArcDrawable() {
        return this.arcRenderer.createArcDrawable();
    }

    @Override
    public CircleGraphDrawable createCircleGraphDrawable() {
        return this.circleGraphRenderer.createCircleGraphDrawable();
    }

    @Override
    public CircularSectorDrawable createCircularSectorDrawable() {
        return this.circularSectorRenderer.createCircularSectorDrawable();
    }

    @Override
    public CubicBezierCurveDrawable createCubicBezierCurveDrawable() {
        return this.curveRenderer.createCubicBezierCurveDrawable();
    }

    @Override
    public EllipseDrawable createEllipseDrawable() {
        return this.ellipseRenderer.createEllipseDrawable();
    }

    @Override
    public PolyLineDrawable createPolyLineDrawable() {
        return this.lineRenderer.createPolyLineDrawable();
    }

    @Override
    public RectangleDrawable createRectangleDrawable() {
        return this.rectangleRenderer.createRectangleDrawable();
    }

    @Override
    public ParticleCloudDrawable createParticleCloudDrawable() {
        return this.particleCloudRenderer.createParticleCloudDrawable();
    }

    @Override
    public ParticleGridDrawable createParticleGridDrawable() {
        return this.particleCloudRenderer.createParticlerGridDrawable();
    }

    @Override
    public ParticleSphereDrawable createParticleSphereDrawable() {
        return this.particleCloudRenderer.createParticleSphereDrawable();
    }

    @Override
    public ParticleHeightMapDrawable createParticleHeightMapDrawable() {
        return this.particleRenderer.createAnimatedParticleHeightMapDrawable();
    }

    @Override
    public void getMaxImageDrawableSize(Dimension dimension) {
        dimension.setSize(this.maxImageDrawableSize);
    }

    @Override
    public ImageDrawable createImageDrawable() {
        return this.imageRenderer.createImageDrawable();
    }

    @Override
    public CompositeImageDrawable createCompositeImageDrawable() {
        return this.compositeImageRenderer.createCompositeImageDrawable();
    }

    @Override
    public ScaleImageDrawable createScaleImageDrawable() {
        return this.scaleImageRenderer.createScaleImageDrawable();
    }

    @Override
    public RectangleGradientDrawable createRectangleGradientDrawable() {
        return this.gradientRenderer.createGradientDrawable();
    }

    @Override
    public ScaleImageGradientDrawable createScaleImageGradientDrawable() {
        return this.scaleImageGradientRenderer.createScaleImageGradientDrawable();
    }

    @Override
    public ColorConversionDrawable createColorConversionDrawable() {
        return this.colorConversionRenderer.createColorConversionDrawable();
    }

    @Override
    public ColorGradientDrawable createColorGradientDrawable() {
        return this.colorGradientRenderer.createColorGradientDrawable();
    }

    @Override
    public TextDrawable createTextDrawable() {
        return this.textRenderer.createTextDrawable();
    }

    @Override
    public void getMaxOffscreenDrawableSize(Dimension dimension) {
        dimension.setSize(this.maxOffscreenDrawableSize);
    }

    @Override
    public OffscreenDrawable createOffscreenDrawable(int n, int n2, boolean bl) {
        return this.offscreenRenderer.createOffscreenDrawable(n, n2, bl);
    }

    @Override
    public SceneDrawable createSceneDrawable() {
        return this.sceneRenderer.createSceneDrawable();
    }

    @Override
    public void beginFrame(Graphics3D graphics3D) {
    }

    @Override
    public void endFrame(Graphics3D graphics3D) {
    }

    @Override
    public void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
        if (bl) {
            this.performanceMetrics.clear();
        }
    }
}

