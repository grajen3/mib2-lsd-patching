/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.effect.ClippingEffect;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformColorShaderEffect;
import de.vw.mib.graphics.math.geometry.Plane3f;
import java.util.List;

public final class ClippingShaderEffect
extends TransformColorShaderEffect
implements ClippingEffect {
    public static final int MAX_CLIPPING_PLANES;

    public ClippingShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
    }

    @Override
    protected void getVertexShaderFilenames(List list) {
        throw new NotYetImplementedException();
    }

    @Override
    protected void getFragmentShaderFilenames(List list) {
        throw new NotYetImplementedException();
    }

    @Override
    public Plane3f getClipPlane(int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public void setClipPlane(int n, Plane3f plane3f) {
        throw new NotYetImplementedException();
    }
}

