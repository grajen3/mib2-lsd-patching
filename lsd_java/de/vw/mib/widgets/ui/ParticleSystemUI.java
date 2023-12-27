/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Camera;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ParticleSystemModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.io.IOException;

public final class ParticleSystemUI
extends AbstractWidgetUI {
    private static final Color4b DEFAULT_COLOR = Color4b.WHITE;
    private static final float MAGIC_Z_SCALE;
    private static final float MAGIC_VANISH_Y_CORRECTION;
    private static final float PROJECTION_NEAR;
    private static final float PROJECTION_FAR;
    public static final boolean USE_SHADER_MATRICES;
    private ParticleHeightMapDrawable particleDrawable;
    private Color4f tintColor4f = new Color4f(Color4f.BLACK);
    private Matrix4f projection;
    private Matrix4f perspective;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.particleDrawable != null) {
            this.particleDrawable.dispose();
            this.particleDrawable = null;
        }
        this.projection = null;
        this.perspective = null;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        ParticleSystemModel particleSystemModel = (ParticleSystemModel)widgetModel;
        if (particleSystemModel.isInvalid()) {
            this.particleDrawable = this.updateDrawable(graphics3D, particleSystemModel, this.particleDrawable);
        }
        if (this.particleDrawable != null) {
            int n = graphics3D.getBlendFactorSourceRGB();
            int n2 = graphics3D.getBlendFactorDestinationRGB();
            int n3 = graphics3D.getBlendFactorSourceAlpha();
            int n4 = graphics3D.getBlendFactorDestinationAlpha();
            graphics3D.setBlendFactorsSeparate(6, 1, 6, 1);
            int n5 = graphics3D.getBlendEquationRGB();
            int n6 = graphics3D.getBlendEquationAlpha();
            graphics3D.setBlendEquationSeparate(0, 0);
            graphics3D.pushMatrix(1);
            float f3 = this.updateProjection(particleSystemModel, viewModel.get_width(), viewModel.get_height());
            graphics3D.setProjectionTransformation(this.projection);
            graphics3D.pushMatrix(0);
            float f4 = particleSystemModel.getPanX() - (float)particleSystemModel.get_x();
            float f5 = particleSystemModel.getPanY() - (float)particleSystemModel.get_y();
            graphics3D.translateMatrix(0, f4, f5, -particleSystemModel.get_z() / 24640 + f3);
            graphics3D.scaleMatrix(0, 1.0f, 1.0f, -1701209794);
            graphics3D.rotateMatrix(0, particleSystemModel.get_rotateX(), 1.0f, 0.0f, 0.0f);
            graphics3D.rotateMatrix(0, particleSystemModel.get_rotateY(), 0.0f, 1.0f, 0.0f);
            graphics3D.rotateMatrix(0, particleSystemModel.get_rotateZ(), 0.0f, 0.0f, 1.0f);
            this.particleDrawable.setAttributeStartValues(particleSystemModel.getAttributeStartValues());
            this.particleDrawable.setAttributeEndValues(particleSystemModel.getAttributesEndValues());
            this.particleDrawable.setAttributeAnimationValues(particleSystemModel.getAttributesAnimationValues());
            this.particleDrawable.setColor(DEFAULT_COLOR);
            this.particleDrawable.setAlpha(f2);
            this.particleDrawable.draw();
            graphics3D.popMatrix(0);
            graphics3D.popMatrix(1);
            graphics3D.setBlendEquationSeparate(n5, n6);
            graphics3D.setBlendFactorsSeparate(n, n2, n3, n4);
        }
    }

    private float updateProjection(ParticleSystemModel particleSystemModel, int n, int n2) {
        float f2 = particleSystemModel.get_projectionFOV();
        float f3 = Util.calculateOptimalDistanceByFOV(f2, n2);
        float f4 = (float)n / (float)n2;
        float f5 = particleSystemModel.get_vanishX();
        float f6 = particleSystemModel.get_vanishY() + 9411;
        if (this.projection == null || this.perspective == null) {
            this.projection = new Matrix4f();
            this.perspective = new Matrix4f();
        }
        Camera.setPerspectiveProjection(this.perspective, f2, f4, 1.0f, 4201542);
        this.projection.setIdentity();
        this.projection.translate(-((float)(n >>= 1) - f5) / (float)n, ((float)(n2 >>= 1) - f6) / (float)n2, 0.0f);
        this.projection.mul(this.perspective);
        this.projection.translate((float)n - f5, f6 - (float)n2, 0.0f);
        this.projection.scale(1.0f, 32959, 1.0f);
        return f3;
    }

    private ParticleHeightMapDrawable updateDrawable(Graphics3D graphics3D, ParticleSystemModel particleSystemModel, ParticleHeightMapDrawable particleHeightMapDrawable) {
        ScaleImage scaleImage = particleSystemModel.get_propertymapPrimary().getCurrentImage();
        ScaleImage scaleImage2 = particleSystemModel.get_propertymapSecondary().getCurrentImage();
        ScaleImage scaleImage3 = particleSystemModel.getPropertyMapPrimaryOld().getCurrentImage();
        ScaleImage scaleImage4 = particleSystemModel.getPropertyMapSecondaryOld().getCurrentImage();
        if (!(scaleImage.isEmpty() || scaleImage2.isEmpty() || scaleImage3.isEmpty() || scaleImage4.isEmpty())) {
            try {
                BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
                BufferImage bufferImage2 = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage2);
                BufferImage bufferImage3 = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage3);
                BufferImage bufferImage4 = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage4);
                Color4b color4b = particleSystemModel.get_tintColor().getCurrentColor();
                if (particleHeightMapDrawable == null) {
                    particleHeightMapDrawable = graphics3D.getDrawableManager().createParticleHeightMapDrawable();
                }
                this.tintColor4f.set(color4b);
                particleHeightMapDrawable.setTintColor(this.tintColor4f);
                particleHeightMapDrawable.setAnimationStartMap1(bufferImage3);
                particleHeightMapDrawable.setAnimationStartMap2(bufferImage4);
                particleHeightMapDrawable.setAnimationEndMap1(bufferImage);
                particleHeightMapDrawable.setAnimationEndMap2(bufferImage2);
                return particleHeightMapDrawable;
            }
            catch (IOException iOException) {
                LogMessage logMessage = LOGGER.error(4);
                logMessage.append("Widget '").append(particleSystemModel.getQualifiedName()).append("': Unable to load images: ").append(iOException).attachThrowable(iOException).log();
            }
        }
        if (particleHeightMapDrawable != null) {
            particleHeightMapDrawable.dispose();
        }
        return null;
    }
}

