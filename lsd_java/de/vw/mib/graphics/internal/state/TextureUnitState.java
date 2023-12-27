/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.state;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.AbstractGraphics3D;
import de.vw.mib.graphics.internal.state.AbstractState;
import de.vw.mib.graphics.internal.util.Matrix4fStack;
import de.vw.mib.graphics.internal.util.MatrixStack;
import de.vw.mib.graphics.internal.util.TransformStack;
import de.vw.mib.graphics.texture.Texture;

public final class TextureUnitState
extends AbstractState {
    private static final Color4f DEFAULT_TEXTURE_BLEND_COLOR = Color4f.WHITE;
    private static final int DEFAULT_TEXTURE_TRANSFORM_STACK_DEPTH;
    public Texture texture;
    public int wrapS;
    public int wrapT;
    public int filterMin;
    public int filterMag;
    public int filterMip;
    public int blendMode;
    public Color4f blendColor = new Color4f(DEFAULT_TEXTURE_BLEND_COLOR);
    public int textureAddressGenerationMode;
    public boolean textureAddressGenerationEnable;
    public MatrixStack textureTransform = AbstractGraphics3D.OPTIMIZE_TRANSFORM ? new TransformStack(4) : new Matrix4fStack(4);

    @Override
    public Object clone() {
        TextureUnitState textureUnitState = (TextureUnitState)super.clone();
        textureUnitState.blendColor = (Color4f)this.blendColor.clone();
        textureUnitState.textureTransform = (MatrixStack)this.textureTransform.clone();
        return textureUnitState;
    }

    @Override
    public void reset() {
        this.texture = null;
        this.wrapS = 0;
        this.wrapT = 0;
        this.filterMin = 1;
        this.filterMag = 1;
        this.filterMip = 0;
        this.blendMode = 1;
        this.blendColor.set(DEFAULT_TEXTURE_BLEND_COLOR);
        this.textureAddressGenerationMode = 0;
        this.textureAddressGenerationEnable = false;
        this.textureTransform.reset();
    }
}

