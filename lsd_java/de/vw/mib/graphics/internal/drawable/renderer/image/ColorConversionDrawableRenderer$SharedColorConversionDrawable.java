/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ColorConversionDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.image.ColorConversionEffect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer$AbstractSharedImageDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.image.ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class ColorConversionDrawableRenderer$SharedColorConversionDrawable
extends AbstractImageDrawableRenderer$AbstractSharedImageDrawable
implements ColorConversionDrawable {
    private Tuple3f[] firstColorConversionParams = new Tuple3f[3];
    private Tuple3f[] secondColorConversionParams;
    private ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo firstSourceColorInfo;
    private ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo secondSourceColorInfo;
    private ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo secondDestColorInfo;
    private ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo firstDestColorInfo;
    private boolean colorConversionValid;

    public ColorConversionDrawableRenderer$SharedColorConversionDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        super(abstractSharedDrawableRenderer, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
        int n;
        for (n = 0; n < this.firstColorConversionParams.length; ++n) {
            this.firstColorConversionParams[n] = new Tuple3f();
        }
        this.secondColorConversionParams = new Tuple3f[3];
        for (n = 0; n < this.secondColorConversionParams.length; ++n) {
            this.secondColorConversionParams[n] = new Tuple3f();
        }
        this.firstSourceColorInfo = new ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo(Color4b.WHITE);
        this.firstDestColorInfo = new ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo(Color4b.WHITE);
        this.secondSourceColorInfo = new ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo(Color4b.WHITE);
        this.secondDestColorInfo = new ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo(Color4b.WHITE);
        this.colorConversionValid = false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",firstSignalHue=").append(this.firstSourceColorInfo.getHue());
        stringBuilder.append(",firstColorConversionParam1=").append(this.firstColorConversionParams[0]);
        stringBuilder.append(",firstColorConversionParam2=").append(this.firstColorConversionParams[1]);
        stringBuilder.append(",firstColorConversionParam3=").append(this.firstColorConversionParams[2]);
        stringBuilder.append(",secondSignalHue=").append(this.secondSourceColorInfo.getHue());
        stringBuilder.append(",secondColorConversionParam1=").append(this.secondColorConversionParams[0]);
        stringBuilder.append(",secondColorConversionParam2=").append(this.secondColorConversionParams[1]);
        stringBuilder.append(",secondColorConversionParam3=").append(this.secondColorConversionParams[2]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        int n;
        for (n = 0; n < this.firstColorConversionParams.length; ++n) {
            this.firstColorConversionParams[n].setZero();
        }
        for (n = 0; n < this.secondColorConversionParams.length; ++n) {
            this.secondColorConversionParams[n].setZero();
        }
        this.firstSourceColorInfo.reset();
        this.firstDestColorInfo.reset();
        this.secondSourceColorInfo.reset();
        this.secondDestColorInfo.reset();
        this.colorConversionValid = false;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedColorConversions = drawablePerformanceMetrics.allocatedColorConversions + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getColorConversionEffect();
    }

    @Override
    public void setFirstSourceColors(Color4b[] color4bArray) {
        if (!this.firstSourceColorInfo.describes(color4bArray)) {
            this.firstSourceColorInfo.set(color4bArray);
            this.colorConversionValid = false;
        }
    }

    @Override
    public void setSecondSourceColors(Color4b[] color4bArray) {
        if (!this.secondSourceColorInfo.describes(color4bArray)) {
            this.secondSourceColorInfo.set(color4bArray);
            this.colorConversionValid = false;
        }
    }

    @Override
    public void setFirstDestinationColors(Color4b[] color4bArray) {
        if (!this.firstDestColorInfo.describes(color4bArray)) {
            this.firstDestColorInfo.set(color4bArray);
            this.colorConversionValid = false;
        }
    }

    @Override
    public void setSecondDestinationColors(Color4b[] color4bArray) {
        if (!this.secondDestColorInfo.describes(color4bArray)) {
            this.secondDestColorInfo.set(color4bArray);
            this.colorConversionValid = false;
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        ColorConversionEffect colorConversionEffect = (ColorConversionEffect)effect;
        this.updateTransformationEffect(colorConversionEffect);
        this.updateColorEffect(colorConversionEffect);
        this.updateImageEffect(colorConversionEffect);
        this.updateColorConversionEffect(colorConversionEffect);
    }

    protected void updateColorConversionEffect(ColorConversionEffect colorConversionEffect) {
        this.updateConversionParameters();
        colorConversionEffect.setFirstSignalHue(this.firstSourceColorInfo.getHue());
        colorConversionEffect.setFirstColorConversionParam1(this.firstColorConversionParams[0]);
        colorConversionEffect.setFirstColorConversionParam2(this.firstColorConversionParams[1]);
        colorConversionEffect.setFirstColorConversionParam3(this.firstColorConversionParams[2]);
        colorConversionEffect.setSecondSignalHue(this.secondSourceColorInfo.getHue());
        colorConversionEffect.setSecondColorConversionParam1(this.secondColorConversionParams[0]);
        colorConversionEffect.setSecondColorConversionParam2(this.secondColorConversionParams[1]);
        colorConversionEffect.setSecondColorConversionParam3(this.secondColorConversionParams[2]);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnColorConversions;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        BufferImage bufferImage = this.getImage();
        int n = bufferImage.getWidth();
        int n2 = bufferImage.getHeight();
        this.setSourceX(0);
        this.setSourceY(0);
        this.setSourceWidth(n);
        this.setSourceHeight(n2);
        this.setDestinationX(0);
        this.setDestinationY(0);
        this.setDestinationWidth(n);
        this.setDestinationHeight(n2);
        return super.updateMesh(textureArray, list);
    }

    private void updateConversionParameters() {
        if (!this.colorConversionValid) {
            this.firstSourceColorInfo.getConversionVectorsTo(this.firstDestColorInfo, this.firstColorConversionParams);
            this.secondSourceColorInfo.getConversionVectorsTo(this.secondDestColorInfo, this.secondColorConversionParams);
            this.colorConversionValid = true;
        }
    }
}

